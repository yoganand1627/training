--STGAP00017004 - Release(5.0) Adding table for new Permancy Roundtable From

create table caps.PERM_ROUNDTABLE_NARR
(ID_EVENT NUMBER(16) not null,
dt_last_update date not null,
ID_CASE NUMBER(16),
NARRATIVE LONG RAW,
ID_DOCUMENT_TABLE NUMBER(16),
CONSTRAINT PK_PERM_ROUNDTABLE_NARR PRIMARY KEY (ID_EVENT) using index tablespace index01,
CONSTRAINT FK_PERM_ROUNDTABLE_NARR_CASE FOREIGN KEY (ID_CASE)
   REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE) tablespace data01 ;

grant select,update,insert,delete on caps.PERM_ROUNDTABLE_NARR to capson,capsbat,ops$datafix;

grant select on caps.PERM_ROUNDTABLE_NARR to operator;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PERM_ROUNDTABLE_NARR
BEFORE UPDATE
ON CAPS.PERM_ROUNDTABLE_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PERM_ROUNDTABLE_NARR 
BEFORE INSERT
ON CAPS.PERM_ROUNDTABLE_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/



COMMENT ON TABLE CAPS.PERM_ROUNDTABLE_NARR IS
'Contains the narrative blob for the Permanency Roundtable Narrative.' ;

COMMENT ON COLUMN CAPS.PERM_ROUNDTABLE_NARR.DT_LAST_UPDATE IS
'Date of insert or last update' ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1070, 'SacwisRev5', 'Release 5.0 - DBCR 17004');

commit;

