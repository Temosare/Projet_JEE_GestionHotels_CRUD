create table HOTEL_CHAINS
(
	HOTEL_CHAIN_ID			INTEGER			not null,
	HOTEL_CHAIN_CODE		CHAR(10)		,
	HOTEL_CHAIN_NAME		VARCHAR(50)		,
	constraint PK_HOTEL_CHAINS primary key (HOTEL_CHAIN_ID)
);

create table REF_HOTEL_CHARACTERISTICS
(
	CHARACTERISTIC_ID			INTEGER			not null,
	CHARACTERISTIC_CODE			CHAR(10)			,
	CHARACTERISTIC_DESCRIPTION		VARCHAR(50)			,
	constraint PK_REF_HOTEL_CHARACTERISTICS primary key (CHARACTERISTIC_ID)
);

create table REF_COUNTRYS
(
	COUNTRY_CODE		CHAR(3)			not null,
	COUNTRY_CURRENCY	CHAR(10)			,
	COUNTRY_NAME		VARCHAR(50)			,
	constraint PK_REF_COUNTRYS primary key (COUNTRY_CODE)
);

create table REF_STAR_RATINGS
(
	STAR_RATING_ID			INTEGER			not null,
	STAR_RATING_CODE		CHAR(8)				,
	STAR_RATING_IMAGE		CHAR(20)			,
	constraint PK_REF_STAR_RATINGS primary key (STAR_RATING_ID)
);

create table REF_ROOM_TYPES
(
	ROOM_TYPE_CODE			CHAR(10)		NOT NULL,
	ROOM_STANDARD_RATE		INTEGER				,
	ROOM_TYPE_DESCRIPTION		VARCHAR(100)			,
	ROOM_SMOKING_YN			CHAR(1)				,
	CONSTRAINT PK_REF_ROOM_TYPES PRIMARY KEY (ROOM_TYPE_CODE)
);

create table GUESTS
(
	GUEST_NUMBER		INTEGER			NOT NULL,
	GUEST_NAME		VARCHAR(50)			,
	GUEST_ADDRESS		VARCHAR(100)			,
	GUEST_CITY		VARCHAR(50)			,
	GUEST_PHONE		CHAR(12)			,
	CONSTRAINT PK_GUESTS PRIMARY KEY (GUEST_NUMBER)
);

create table HOTELS
(
	HOTEL_ID			INTEGER			not null,
	COUNTRY_CODE			CHAR(3)			not null,
	STAR_RATING_ID			INTEGER			not null,
	HOTEL_CHAIN_ID			INTEGER			NOT NULL,
	HOTEL_CODE			CHAR(10)			,
	HOTEL_NAME			VARCHAR(50)			,
	HOTEL_URL			VARCHAR(100)			,
	HOTEL_POST_CODE			VARCHAR(10)			,
	constraint PK_HOTELS primary key (HOTEL_ID),
	CONSTRAINT FK_HOTELS_COUNTRY_CODE FOREIGN KEY (COUNTRY_CODE) REFERENCES REF_COUNTRYS (COUNTRY_CODE) ON DELETE CASCADE,
	CONSTRAINT FK_HOTELS_STAR_RATING_ID FOREIGN KEY (STAR_RATING_ID) REFERENCES REF_STAR_RATINGS (STAR_RATING_ID) ON DELETE CASCADE,
	CONSTRAINT FK_HOTELS_HOTEL_CHAIN_ID FOREIGN KEY (HOTEL_CHAIN_ID) REFERENCES HOTEL_CHAINS (HOTEL_CHAIN_ID) ON DELETE CASCADE	
);

create table HOTEL_CHARACTERISTICS
(
	CHARACTERISTIC_ID		INTEGER                not null,
	HOTEL_ID			INTEGER                not null,
	constraint PK_HOTEL_CHARACTERISTICS primary key (CHARACTERISTIC_ID, HOTEL_ID),
	CONSTRAINT FK_HOTEL_CHARACTERISTICS_CHARACTERISTIC_ID FOREIGN KEY (CHARACTERISTIC_ID) REFERENCES REF_HOTEL_CHARACTERISTICS (CHARACTERISTIC_ID) ON DELETE CASCADE,
	CONSTRAINT FK_HOTEL_CHARACTERISTICS_HOTEL_ID FOREIGN KEY (HOTEL_ID) REFERENCES HOTELS (HOTEL_ID) ON DELETE CASCADE
);

create table HOTEL_STAR_RATINGS
(
	STAR_RATING_ID		INTEGER			NOT NULL,
	HOTEL_ID		INTEGER			NOT NULL,
	CONSTRAINT PK_HOTEL_STAR_RATINGS PRIMARY KEY (STAR_RATING_ID,HOTEL_ID),
	CONSTRAINT FK_HOTEL_STAR_RATINGS_STAR_RATING_ID FOREIGN KEY (STAR_RATING_ID) REFERENCES REF_STAR_RATINGS (STAR_RATING_ID) ON DELETE CASCADE,
	CONSTRAINT FK_HOTEL_STAR_RATINGS_HOTEL_ID FOREIGN KEY (HOTEL_ID) REFERENCES HOTELS (HOTEL_ID) ON DELETE CASCADE
);

create table HOTEL_ROOMS
(
	ROOM_NUMBER		INTEGER			not null,
	HOTEL_ID		INTEGER			NOT NULL,
	ROOM_TYPE_CODE		CHAR(10)		,
	ROOM_FLOOR		INTEGER				,
	ROOM_FLOOR_COUNT	INTEGER				,
	constraint PK_HOTEL_ROOMS primary key (ROOM_NUMBER,HOTEL_ID),
	CONSTRAINT FK_HOTEL_ROOMS_HOTEL_ID FOREIGN KEY (HOTEL_ID) REFERENCES HOTELS (HOTEL_ID) ON DELETE CASCADE
);

create table BOOKINGS
(
	BOOKING_ID			INTEGER			NOT NULL,
	GUEST_NUMBER			INTEGER			,
	HOTEL_ID			INTEGER			,
	ROOM_NUMBER			INTEGER 		,
	DATE_FROM			DATE				,
	DATE_TO				DATE				,
	CONSTRAINT PK_BOOKINGS PRIMARY KEY (BOOKING_ID),
	CONSTRAINT FK_BOOKINGS_GUEST_NUMBER FOREIGN KEY (GUEST_NUMBER) REFERENCES GUESTS (GUEST_NUMBER) ON DELETE CASCADE
	
);

create table ROOM_BOOKINGS
(
	BOOKING_ID		INTEGER			NOT NULL,
	HOTEL_ID		INTEGER			,
	ROOM_NUMBER		INTEGER			,
	DATE_BOOKING_FROM	DATE				,
	DATE_BOOKING_TO		DATE				,
	ROOM_COUNT		INTEGER				,
	CONSTRAINT PK_ROOM_BOOKINGS PRIMARY KEY (BOOKING_ID),
	CONSTRAINT FK_ROOM_BOOKINGS_BOOKING_ID FOREIGN KEY (BOOKING_ID) REFERENCES BOOKINGS (BOOKING_ID) on delete cascade
);

