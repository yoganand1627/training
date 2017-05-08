--STGAP00014685 - Add Table,Batch params for NYTD

CREATE TABLE CAPS.NYTD_RANDOM
   (    ID_NYTD_RANDOM NUMBER(16,0) not null,
        DT_LAST_UPDATE DATE not null,
        CD_POPULATION_TYPE VARCHAR2(1) not null,
        ID_PERSON NUMBER(16,0) not null,
        ID_YOUTH_REPORT_DTL NUMBER(16,0) not null,
        DT_RPT_PERIOD_END DATE not null,
        CONSTRAINT PK_NYTD_RANDOM PRIMARY KEY(ID_NYTD_RANDOM)
          using index tablespace index01
   ) tablespace data01;

comment on table CAPS.NYTD_RANDOM is 'Contains data for the NYTD follow up reports, as chosen by the random sampler';

comment on column CAPS.NYTD_RANDOM.ID_NYTD_RANDOM is 'Primary Key';
comment on column CAPS.NYTD_RANDOM.DT_LAST_UPDATE is 'Date of last update';
comment on column CAPS.NYTD_RANDOM.CD_POPULATION_TYPE is 'Population Type (Baseline, Followup)';
comment on column CAPS.NYTD_RANDOM.ID_PERSON is 'ID of the related person';
comment on column CAPS.NYTD_RANDOM.ID_YOUTH_REPORT_DTL is 'ID of the related Youth Report Detail';
comment on column CAPS.NYTD_RANDOM.DT_RPT_PERIOD_END is 'Report Period End';

grant select,update,insert,delete on caps.NYTD_RANDOM to capson,capsbat,ops$datafix;
grant select on caps.NYTD_RANDOM to operator;

CREATE SEQUENCE  CAPS.SEQ_NYTD_RANDOM NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE ;

grant select on CAPS.SEQ_NYTD_RANDOM to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_NYTD_RANDOM 
BEFORE UPDATE
ON CAPS.NYTD_RANDOM
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_NYTD_RANDOM
BEFORE INSERT
ON CAPS.NYTD_RANDOM
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_NYTD_RANDOM=0 then
    SELECT SEQ_NYTD_RANDOM.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_NYTD_RANDOM := dummy;
  end if;
END;
/


insert into caps.batch_parameters
 ( nm_batch_program, nm_batch_parameter, dt_param_effective, dt_param_expired, txt_parameter_value)
 values
 ('NYTDJOB', 'NYTD-END-DATE', to_date('07/01/2009', 'MM/DD/YYYY'),      to_date('12/31/2012', 'MM/DD/YYYY'), '09/30/2009');


insert into caps.batch_parameters
 ( nm_batch_program, nm_batch_parameter, dt_param_effective, dt_param_expired, txt_parameter_value)
 values
 ('NYTDJOB', 'NYTD-BEGIN-DATE', to_date('07/01/2009', 'MM/DD/YYYY'),    to_date('12/31/2012', 'MM/DD/YYYY'), '04/01/2009');


--STGAP00014694 - Update message as per STGAP00014690

update caps.message set txt_message = 'Adding this Non-Recurring Expense will take the child over the spending limit of $%s' where txt_message_name = 'MSG_NON_RECURRING_LIMIT';


--STGAP00014711 - Insert Messages for MR-052

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60561,'MSG_AGMT_CC_SERV_AUTH_EXISTS','An active Special Services- Child Care Service Authorization currently exists.',700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60562,'MSG_AGMT_RESPITE_SERV_AUTH_EXISTS','An active Special Services- Respite Service Authorization currently exists.',700,500,'N');


--STGAP00014717 - Need to add a code type to CodesTable Maintenance

-- Need to give the limited update capability to the Code type CCNTYDIR so that the
-- user can update the county director id when ever there is a change.


INSERT INTO CAPS.CODES_TABLES_INFO VALUES('CCNTYDIR', 'L', 'List of County DirectorIds');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (496, 'SacwisRev3', 'Release 3.2 - DBCRs 14685,14694,14711,14717');

commit;


