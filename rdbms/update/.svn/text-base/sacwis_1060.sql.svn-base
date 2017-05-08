-- STGAP00016504
-- MR-095 Person Relationships
-- Add New Table STAGE_PERSON_ADD_HISTORY

CREATE TABLE CAPS.STAGE_PERSON_ADD_HISTORY
(ID_STAGE_PERSON_ADD_HISTORY NUMBER(16,0) not null,
DT_LAST_UPDATE DATE NOT NULL,
ID_PERSON number(16,0) not null,
ID_FROM_STAGE number(16,0) not null,
ID_TO_STAGE number(16,0) not null,
ID_CASE number(16,0) null,
CD_STAGE_PERS_TYPE varchar2(3) null,
CD_STAGE_PERS_REL_INT varchar2(2) null,
DT_ADDED DATE NULL,
CONSTRAINT PK_STAGE_PERSON_ADD_HISTORY PRIMARY KEY(ID_STAGE_PERSON_ADD_HISTORY) using index tablespace index01) tablespace data01;

create index caps.IND_STAGE_PERSON_ADD_HISTORY_1 on CAPS.STAGE_PERSON_ADD_HISTORY(ID_PERSON, ID_FROM_STAGE) tablespace index01;

comment on table CAPS.STAGE_PERSON_ADD_HISTORY is 'Further details about an individual in the system than are recorded on the STAGE_PERSON_ADD_HISTORY table' ;
COMMENT ON COLUMN CAPS.STAGE_PERSON_ADD_HISTORY.ID_STAGE_PERSON_ADD_HISTORY IS 'A unique identifier located on the STAGE_PERSON_ADD_HISTORY table' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.ID_PERSON is 'ID of child for whom the referral was sent. A unique identifier for a row on the Person table' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.ID_FROM_STAGE is 'A unique identifier for a row on the STAGE table. The stage where the person detail is accessed' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.ID_TO_STAGE is 'A unique identifier for a row on the STAGE table. The stage where the person is added via person detail' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.ID_CASE is 'A unique identifier for a row on the CAPS_CASE table' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.CD_STAGE_PERS_TYPE is 'Code that indicates the type of function each person has in a particular report (i.e. principal, reporter, collateral.)' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.CD_STAGE_PERS_REL_INT is 'Code representing the relationship/interest of an individual to a case' ;
comment on column CAPS.STAGE_PERSON_ADD_HISTORY.DT_ADDED is 'Used to record the date that the person is added to the stage' ;

grant select,update,insert,delete on caps.STAGE_PERSON_ADD_HISTORY to capson,capsbat,ops$datafix;
grant select on caps.STAGE_PERSON_ADD_HISTORY to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_STAGE_PERSON_ADD_HISTORY  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_STAGE_PERSON_ADD_HISTORY  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE_PERSON_ADD_HISTORY
BEFORE UPDATE
ON CAPS.STAGE_PERSON_ADD_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_STAGE_PERSON_ADD_HISTORY
BEFORE INSERT
ON CAPS.STAGE_PERSON_ADD_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_STAGE_PERSON_ADD_HISTORY=0 then
    SELECT SEQ_STAGE_PERSON_ADD_HISTORY.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_STAGE_PERSON_ADD_HISTORY := dummy;
  end if;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1061, 'SacwisRev4', 'Release 5.0 - DBCR 16504');

commit;


