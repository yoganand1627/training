--STGAP00016998 - Release(5.0) Creating new table for characteristc groupings

--Per ECEM - Foster Home Matching: Placement Log add new table CHARACTERISTICS_GROUP

CREATE TABLE CAPS.CHARACTERISTICS_GROUP
(ID_CHARACTERISTICS_GROUP Number(16,0) not null,
 CHARACTERISTICS_CODE VARCHAR2(20 BYTE) NOT NULL,
 CHARACTERISTICS_DECODE VARCHAR2(370 BYTE),
 CHARACTERISTICS_GROUP_CODE VARCHAR2(20 BYTE) NOT NULL,
 CHARACTERISTICS_GROUP_DECODE VARCHAR2(370 BYTE),
 DT_LAST_UPDATE Date not null,
CONSTRAINT PK_CHARACTERISTICS_GROUP PRIMARY KEY (ID_CHARACTERISTICS_GROUP) using index tablespace index01) tablespace data01;

comment on table CAPS.CHARACTERISTICS_GROUP is 'The table containing the groupings of person characteristics' ;
comment on column CAPS.CHARACTERISTICS_GROUP.ID_CHARACTERISTICS_GROUP is 'Primary Key' ;
comment on column CAPS.CHARACTERISTICS_GROUP.CHARACTERISTICS_CODE is 'the code value for the characteristic' ;
comment on column CAPS.CHARACTERISTICS_GROUP.CHARACTERISTICS_DECODE is 'the decode value for the characteristic' ;
comment on column CAPS.CHARACTERISTICS_GROUP.CHARACTERISTICS_GROUP_CODE is 'the code value for the characteristic group' ;
comment on column CAPS.CHARACTERISTICS_GROUP.CHARACTERISTICS_GROUP_DECODE is 'the decode value for the characteristic group' ;
comment on column CAPS.CHARACTERISTICS_GROUP.DT_LAST_UPDATE is 'Used to record the last updated date' ;


grant select,update,insert,delete on caps.CHARACTERISTICS_GROUP to capson,capsbat,ops$datafix;
grant select on caps.CHARACTERISTICS_GROUP to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_CHARACTERISTICS_GROUP  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CHARACTERISTICS_GROUP  to capsbat,capson,ops$datafix;


/
CREATE OR REPLACE TRIGGER "CAPS"."TUBR_CHARACTERISTICS_GROUP" 
  BEFORE UPDATE ON CAPS.CHARACTERISTICS_GROUP FOR EACH ROW 
  BEGIN 
    :new.DT_LAST_UPDATE := sysdate;
  END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CHARACTERISTICS_GROUP
BEFORE INSERT
ON CAPS.CHARACTERISTICS_GROUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_CHARACTERISTICS_GROUP=0 then
    SELECT SEQ_CHARACTERISTICS_GROUP.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_CHARACTERISTICS_GROUP := dummy;
  end if;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1071, 'SacwisRev5', 'Release 5.0 - DBCR 16998');

commit;

