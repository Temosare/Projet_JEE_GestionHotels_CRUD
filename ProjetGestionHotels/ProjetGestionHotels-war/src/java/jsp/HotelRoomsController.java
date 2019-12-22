package jsp;

import entities.HotelRooms;
import jsp.util.JsfUtil;
import jsp.util.PaginationHelper;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import sessionbean.HotelRoomsFacadeLocal;

@Named("hotelRoomsController")
@SessionScoped
public class HotelRoomsController implements Serializable {

    private HotelRooms current;
    private DataModel items = null;
    @EJB
    private HotelRoomsFacadeLocal ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public HotelRoomsController() {
    }

    public HotelRooms getSelected() {
        if (current == null) {
            current = new HotelRooms();
            current.setHotelRoomsPK(new entities.HotelRoomsPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private HotelRoomsFacadeLocal getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (HotelRooms) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new HotelRooms();
        current.setHotelRoomsPK(new entities.HotelRoomsPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getHotelRoomsPK().setHotelId(current.getHotels().getHotelId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("HotelRoomsCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (HotelRooms) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getHotelRoomsPK().setHotelId(current.getHotels().getHotelId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("HotelRoomsUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (HotelRooms) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("HotelRoomsDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public HotelRooms getHotelRooms(entities.HotelRoomsPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = HotelRooms.class)
    public static class HotelRoomsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HotelRoomsController controller = (HotelRoomsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "hotelRoomsController");
            return controller.getHotelRooms(getKey(value));
        }

        entities.HotelRoomsPK getKey(String value) {
            entities.HotelRoomsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entities.HotelRoomsPK();
            key.setRoomNumber(Integer.parseInt(values[0]));
            key.setHotelId(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entities.HotelRoomsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getRoomNumber());
            sb.append(SEPARATOR);
            sb.append(value.getHotelId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof HotelRooms) {
                HotelRooms o = (HotelRooms) object;
                return getStringKey(o.getHotelRoomsPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + HotelRooms.class.getName());
            }
        }

    }

}
