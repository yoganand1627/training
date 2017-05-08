--STGAP00015960 - Release(4.0) MR-067: NYTD Survey Create New Table

--Per MR-067 NYTD Survey Add New Table PORTAL_USER_DTL

CREATE TABLE CAPS.PORTAL_USER_DTL
(ID_USER NUMBER(16,0) not null,
DT_LAST_UPDATE DATE NOT NULL,
ID_PERSON NUMBER(16,0) not null,
TXT_USER_FACEBOOK VARCHAR2(320) null,
TXT_USER_MYSPACE VARCHAR2(320) null,
TXT_USER_TWITTER VARCHAR2(320) null,
TXT_OTHER_SITE VARCHAR2(320) null,
TXT_USER_OTHER_SITE VARCHAR2(320) null,
NBR_USER_PHONE_BEST VARCHAR2(10) null,
NBR_USER_PHONE_BEST_EXTENSION VARCHAR2(8) null,
CD_USER_PHONE_BEST_TYPE VARCHAR2(2) null,
NBR_USER_PHONE_ALT_1 VARCHAR2(10) null,
NBR_USER_PHONE_ALT_1_EXTENSION VARCHAR2(8) null,
CD_USER_PHONE_ALT_1_TYPE VARCHAR2(2) null,
NBR_USER_PHONE_ALT_2 VARCHAR2(10) null,
NBR_USER_PHONE_ALT_2_EXTENSION VARCHAR2(8) null,
CD_USER_PHONE_ALT_2_TYPE VARCHAR2(2) null,
IND_CONTACT_BY_TEXT VARCHAR2(1) null,
TXT_EMER_CONTACT VARCHAR2(300) NULL,
CONSTRAINT PK_PORTAL_USER_DTL PRIMARY KEY(ID_USER),
CONSTRAINT FK_PORTAL_USER_DTL_USER FOREIGN KEY (ID_USER)
   REFERENCES CAPS.PORTAL_USER(ID_USER),
CONSTRAINT FK_PORTAL_USER_DTL_PERSON FOREIGN KEY (ID_PERSON)
   REFERENCES CAPS.PERSON_ENC(ID_PERSON)
) tablespace data01;

create index caps.FK_PORTAL_USER_DTL_PERSON on CAPS.PORTAL_USER_DTL(ID_PERSON) tablespace index01;

comment on table CAPS.PORTAL_USER_DTL is 'Further details about an individual in the system than are recorded on the PORTAL_USER table' ;
COMMENT ON COLUMN CAPS.PORTAL_USER_DTL.ID_USER IS 'A unique identifier to the PORTAL_USER table located on the PORTAL_USER_DTL table' ;
COMMENT ON COLUMN CAPS.PORTAL_USER_DTL.DT_LAST_UPDATE IS 'Used to record the last updated date' ;
comment on column CAPS.PORTAL_USER_DTL.ID_PERSON is 'Records the SHINES Person ID. Foreign key to PERSON_ENC.ID_PERSON' ;
comment on column CAPS.PORTAL_USER_DTL.TXT_USER_FACEBOOK is 'Facebook User Name of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.TXT_USER_MYSPACE is 'MySpace User Name of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.TXT_USER_TWITTER is 'Twitter User Name of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.TXT_OTHER_SITE is 'Name of Other Site' ;
comment on column CAPS.PORTAL_USER_DTL.TXT_USER_OTHER_SITE is 'User Name of Other Site' ;
comment on column CAPS.PORTAL_USER_DTL.NBR_USER_PHONE_BEST is 'Best Contact Phone Number of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.NBR_USER_PHONE_BEST_EXTENSION is 'Extension of the Best Contact Phone of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.CD_USER_PHONE_BEST_TYPE is 'Phone Type of the Best Contact Phone of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.NBR_USER_PHONE_ALT_1 is 'Alternate Phone Number 1 of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.NBR_USER_PHONE_ALT_1_EXTENSION is 'Extension of the Alternate Phone Number 1 of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.CD_USER_PHONE_ALT_1_TYPE is 'Phone Type of the Alternate Phone Number 1 of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.NBR_USER_PHONE_ALT_2 is 'Alternate Phone Number 2 of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.NBR_USER_PHONE_ALT_2_EXTENSION is 'Extension of the Alternate Phone Number 2 of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.CD_USER_PHONE_ALT_2_TYPE is 'Phone Type of the Alternate Phone Number 2 of the NYTD User' ;
comment on column CAPS.PORTAL_USER_DTL.IND_CONTACT_BY_TEXT is 'Indicator User Accepting Contact by Text' ;
comment on column CAPS.PORTAL_USER_DTL.TXT_EMER_CONTACT is 'Emergency Contact of the NYTD User' ;

grant select,update,insert,delete on caps.PORTAL_USER_DTL to capson,capsbat,ops$datafix;
grant select on caps.PORTAL_USER_DTL to operator,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PORTAL_USER_DTL
BEFORE UPDATE
ON CAPS.PORTAL_USER_DTL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PORTAL_USER_DTL
BEFORE INSERT
ON CAPS.PORTAL_USER_DTL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (871, 'SacwisRev4', 'Release 4.0 - DBCR 15960');

commit;


