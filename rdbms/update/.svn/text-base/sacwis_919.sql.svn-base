--STGAP00016024 - Release(4.1) MR-074 AFCARS: Enable Delete task, Add Trigger Del

--New table to record delete LS action and deleted data
--Add trigger to insert deleted legal status and related info to a new audit table
--Update Task table to enable Delete for Legal Status in Event List

-- New audit table to record deleted LS 
CREATE TABLE CAPS.LEGAL_STATUS_AUDIT 
   (	ID_LEGAL_STATUS_AUDIT NUMBER(16,0) not null,
        ID_LEGAL_STAT_EVENT NUMBER(16,0) NOT NULL, 
	ID_PERSON NUMBER(16,0) NOT NULL, 
        ID_CASE NUMBER(16,0),
	CD_LEGAL_STAT_CNTY VARCHAR2(3 BYTE), 
	CD_LEGAL_STAT_STATUS VARCHAR2(3 BYTE), 
	DT_LEGAL_STAT_STATUS_DT DATE, 
	IND_CSUP_SEND CHAR(1 BYTE), 
	CD_COURT_NBR VARCHAR2(10 BYTE), 
	DT_LEGAL_STAT_CRT_ODR_EXP_DT DATE, 
	DT_LEGAL_STAT_CUS_EXP_DT DATE, 
	DT_LEGAL_STAT_P_M_DUE_DT DATE, 
	IND_LEGAL_STAT_RISK CHAR(1 BYTE), 
  ID_PERSON_CREATED_BY NUMBER(16,0), 
  ID_PERSON_MODIFIED_BY NUMBER(16,0), 
  ID_STAGE NUMBER(16,0),
  DT_USER_ACTION DATE,
  DT_LAST_UPDATE DATE NOT NULL ENABLE, 
  CD_USER_ACTION VARCHAR2(1 BYTE),
CONSTRAINT PK_LEGAL_STATUS_AUDIT PRIMARY KEY (ID_LEGAL_STATUS_AUDIT)
   using index tablespace index01) tablespace data01;

comment on column caps.LEGAL_STATUS_AUDIT.ID_LEGAL_STATUS_AUDIT is 'Primary key for audit table';
comment on column caps.LEGAL_STATUS_AUDIT.ID_PERSON is 'Person ID of the legal status.';
comment on column caps.LEGAL_STATUS_AUDIT.ID_PERSON_CREATED_BY is 'Person ID of the case manager who created legal status (event.id_event_person).';
comment on column caps.LEGAL_STATUS_AUDIT.ID_PERSON_MODIFIED_BY is 'Person ID of the person who modified the legal status.';
comment on column caps.LEGAL_STATUS_AUDIT.DT_USER_ACTION is 'Date the action performed on the legal status.';
comment on column caps.LEGAL_STATUS_AUDIT.DT_LAST_UPDATE is 'Date this entry was updated; not of the legal status.';
comment on column caps.LEGAL_STATUS_AUDIT.CD_USER_ACTION is 'The action performed on the legal status (currently just D - delete).';
comment on column caps.LEGAL_STATUS_AUDIT.ID_STAGE is 'Stage ID of the stage the legal status was created in.';

grant update,insert,delete,select on CAPS.LEGAL_STATUS_AUDIT to capson,capsbat,ops$datafix;
grant select on CAPS.LEGAL_STATUS_AUDIT to operator,shinesdm;


CREATE SEQUENCE  CAPS.SEQ_LEGAL_STATUS_AUDIT  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_LEGAL_STATUS_AUDIT to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_LEGAL_STATUS_AUDIT
BEFORE INSERT
ON CAPS.LEGAL_STATUS_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_LEGAL_STATUS_AUDIT=0 then
    SELECT SEQ_LEGAL_STATUS_AUDIT.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_LEGAL_STATUS_AUDIT := dummy;
  end if;
END;
/

-- Trigger to insert to audit table on LS delete 
/
CREATE OR REPLACE TRIGGER CAPS.TDBR_LEGAL_STATUS 
BEFORE DELETE
ON CAPS.LEGAL_STATUS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE 
  idStage NUMBER;
  idPersonCreator NUMBER;
BEGIN
  BEGIN
  select id_event_stage, id_event_person 
  into idStage, idPersonCreator 
  from CAPS.event where id_event = :OLD.ID_LEGAL_STAT_EVENT;
  EXCEPTION WHEN OTHERS THEN NULL;
  END;
  insert into CAPS.LEGAL_STATUS_AUDIT(
                ID_LEGAL_STATUS_AUDIT,
                ID_LEGAL_STAT_EVENT, 
                ID_PERSON, 
                ID_CASE,
                CD_LEGAL_STAT_CNTY, 
                CD_LEGAL_STAT_STATUS, 
                DT_LEGAL_STAT_STATUS_DT, 
                IND_CSUP_SEND, 
                CD_COURT_NBR, 
                DT_LEGAL_STAT_CRT_ODR_EXP_DT, 
                DT_LEGAL_STAT_CUS_EXP_DT, 
                DT_LEGAL_STAT_P_M_DUE_DT, 
                IND_LEGAL_STAT_RISK, 
                ID_STAGE,
                ID_PERSON_CREATED_BY,
                DT_USER_ACTION,
                DT_LAST_UPDATE,
                CD_USER_ACTION
    ) values (
                0,
                :OLD.ID_LEGAL_STAT_EVENT, 
                :OLD.ID_PERSON, 
                :OLD.ID_CASE,
                :OLD.CD_LEGAL_STAT_CNTY, 
                :OLD.CD_LEGAL_STAT_STATUS, 
                :OLD.DT_LEGAL_STAT_STATUS_DT, 
                :OLD.IND_CSUP_SEND, 
                :OLD.CD_COURT_NBR, 
                :OLD.DT_LEGAL_STAT_CRT_ODR_EXP_DT, 
                :OLD.DT_LEGAL_STAT_CUS_EXP_DT, 
                :OLD.DT_LEGAL_STAT_P_M_DUE_DT, 
                :OLD.IND_LEGAL_STAT_RISK, 
                idStage,
                idPersonCreator,
                SYSDATE,
                sysdate,
                'D'
               );
END; 
/

-- Event List: enable delete button for Legal Status List
UPDATE CAPS.TASK
SET IND_TASK_DELETE = '1'
WHERE TXT_3RD_TAB = 'LEGAL_STATUS_EVENTLIST';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (920, 'SacwisRev4', 'Release 4.1 - DBCR 16024');

commit;


