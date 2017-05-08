--STGAP00015963 - Release(4.0) MR-072 Add new table for Contacts

create table CAPS.CONTACT_DISCUSSED_CBX 
(id_contact_discussed_cbx number(16) not null,
dt_last_update date not null,
id_contact_event number(16) not null,
id_discussed_person number(16) not null,
constraint pk_CONTACT_DISCUSSED_CBX primary key(id_contact_discussed_cbx) using index tablespace index01,
constraint fk_CONTACT_DISCUSSED_EVENT foreign key(id_contact_event) references caps.contact(id_event) ) tablespace data01;

comment on table caps.contact_discussed_cbx is 'This table is used to record the Contact Discussed/In Reference To on the Contact Detail Page.';
comment on column caps.contact_discussed_cbx.id_contact_discussed_cbx is 'Primary Key';
comment on column caps.contact_discussed_cbx.dt_last_update is 'Used to record the last updated date';
comment on column caps.contact_discussed_cbx.id_contact_event is 'Records the event id of the contact record for which this record is created';
comment on column caps.contact_discussed_cbx.id_discussed_person is 'Records the person Discussed/In Reference To for that contact';

create index caps.fk_contact_discussed_event on caps.contact_discussed_cbx(id_contact_event) tablespace index01;

grant select,update,insert,delete on caps.contact_discussed_cbx to capson,capsbat,ops$datafix;
grant select on caps.contact_discussed_cbx to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_contact_discussed_cbx  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_contact_discussed_cbx  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_contact_discussed_cbx 
BEFORE UPDATE
ON CAPS.contact_discussed_cbx
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CONTACT_DISCUSSED_CBX 
BEFORE INSERT
ON CAPS.CONTACT_DISCUSSED_CBX
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_contact_discussed_cbx=0 then
    SELECT SEQ_CONTACT_DISCUSSED_CBX.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_contact_discussed_cbx := dummy;
  end if;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (869, 'SacwisRev4', 'Release 4.0 - DBCR 15963');

commit;


