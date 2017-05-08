--STGAP00016137 - Release(4.3) CAPTA-4.3:Spcl Inv add State Concur table

--05/22/2011
CREATE TABLE CAPS.SPCL_INV_STATE_CONCUR
(
   ID_SPCL_INV_STATE_CONCUR Number(16,0) NOT NULL,
   DT_LAST_UPDATE date NOT NULL,
   ID_SPCL_INV_EVENT Number(16,0) NOT NULL,
   CD_STATE_CONCUR varchar2(4) NOT NULL,
   CONSTRAINT PK_ID_SPCL_INV_STATE_CONCUR PRIMARY KEY(ID_SPCL_INV_STATE_CONCUR) using index tablespace index01,
   CONSTRAINT FK_SPCL_INVESTIGATION FOREIGN KEY (ID_SPCL_INV_EVENT)
      REFERENCES CAPS.SPCL_INVESTIGATION(ID_SPCL_INV_EVENT) ) tablespace data01;

CREATE SEQUENCE caps.SEQ_SPCL_INV_STATE_CONCUR NOMINVALUE NOMAXVALUE INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on caps.SEQ_SPCL_INV_STATE_CONCUR to capson,capsbat,ops$datafix;

create index caps.IND_SPCL_INV on CAPS.SPCL_INV_STATE_CONCUR(ID_SPCL_INV_EVENT) tablespace index01;

comment on table CAPS.SPCL_INV_STATE_CONCUR is 'The table containing the State Office Concurrence(s) for a Special Investigation' ;
comment on column CAPS.SPCL_INV_STATE_CONCUR.ID_SPCL_INV_STATE_CONCUR is 'Primary Key' ;
comment on column CAPS.SPCL_INV_STATE_CONCUR.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.SPCL_INV_STATE_CONCUR.ID_SPCL_INV_EVENT is 'Foreign Key to the Special Investigation record' ;
comment on column CAPS.SPCL_INV_STATE_CONCUR.CD_STATE_CONCUR is 'records a State Office Concurrence code' ;

grant select,update,insert,delete on caps.SPCL_INV_STATE_CONCUR to capson,capsbat,ops$datafix;
grant select on caps.SPCL_INV_STATE_CONCUR to operator,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPCL_INV_STATE_CONCUR
BEFORE UPDATE
ON CAPS.SPCL_INV_STATE_CONCUR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SPCL_INV_STATE_CONCUR
BEFORE INSERT
ON CAPS.SPCL_INV_STATE_CONCUR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number(16);
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
   IF (:new.ID_SPCL_INV_STATE_CONCUR = 0) THEN
        SELECT  SEQ_SPCL_INV_STATE_CONCUR.NEXTVAL
        INTO    dummy
        FROM    DUAL;
        :new.ID_SPCL_INV_STATE_CONCUR := dummy;
   END IF;
END;
/



/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPCL_INV_HME_WVR_CHD2_HST
BEFORE UPDATE
ON CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SPCL_INV_HME_WVR_CHD2_HST
BEFORE INSERT
ON CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

--BACKOUT
--DROP TABLE CAPS.SPCL_INV_STATE_CONCUR;

--DROP SEQUENCE caps.SEQ_SPCL_INV_STATE_CONCUR;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1015, 'SacwisRev4', 'Release 4.3 - DBCR 16137');

commit;
