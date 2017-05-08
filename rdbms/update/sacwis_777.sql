--STGAP00015835 - Release(3.5) Creating New Table For CD/SI/NF Form

create table caps.CHILD_DEATH_NARR
(ID_EVENT NUMBER(16) not null,
dt_last_update date not null,
ID_CASE NUMBER(16),
NARRATIVE LONG RAW,
ID_DOCUMENT_TABLE NUMBER(16),
CONSTRAINT PK_CHILD_DEATH_NARR PRIMARY KEY (ID_EVENT),
CONSTRAINT FK_CHILD_DEATH_NARR_CASE FOREIGN KEY (ID_CASE)
   REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE) ;

create index caps.ind_CHILD_DEATH_NARR_1 on caps.CHILD_DEATH_NARR(id_case) tablespace index01;

grant select,update,insert,delete on CAPS.CHILD_DEATH_NARR to capson,capsbat,ops$datafix;
grant select on caps.CHILD_DEATH_NARR to operator;


/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CHILD_DEATH_NARR 
BEFORE UPDATE
ON CAPS.CHILD_DEATH_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CHILD_DEATH_NARR
BEFORE INSERT
ON CAPS.CHILD_DEATH_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


COMMENT ON TABLE CAPS.CHILD_DEATH_NARR IS
'Contains the narrative blob for the Child Death Narrative.' ;

COMMENT ON COLUMN CAPS.CHILD_DEATH_NARR.DT_LAST_UPDATE IS
'Date of insert or last update' ;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (778, 'SacwisRev3', 'Release 3.5 - DBCR 15835');

commit;

