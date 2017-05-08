-- Standard Alter Table SQL

ALTER TABLE CAPS.FCCP_DTL_FORM_NARR DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.FCCP_DTL_FORM_NARR ADD ID_EVENT NUMBER(16) DEFAULT 0 NOT NULL
;
ALTER TABLE CAPS.FCCP_DTL_FORM_NARR ADD CONSTRAINT PK_FCCP_DTL_FORM_NARR
PRIMARY KEY (ID_STAGE,ID_EVENT)
USING INDEX TABLESPACE INDEX01
            PCTFREE 10
            INITRANS 2
            MAXTRANS 255
            STORAGE(INITIAL 1M
                    NEXT 1M
                    MINEXTENTS 1
                    MAXEXTENTS UNLIMITED
                    PCTINCREASE 0
                    BUFFER_POOL DEFAULT)
    LOGGING
    ENABLE
    VALIDATE
;

update CAPS.FCCP_DTL_FORM_NARR set id_event=
(select max(e.id_event)
from CAPS.stage s1, CAPS.stage s2, CAPS.event e
where
s1.id_stage = FCCP_DTL_FORM_NARR.ID_STAGE
and s1.id_case=s2.id_case
and s2.cd_stage='FSU'
and s2.id_stage=e.id_event_stage
and e.cd_task='7065');

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.FCCP_DTL_FORM_NARR ADD CONSTRAINT FK_FCCP_DTL_NARR_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_FCCP_DTL_FORM_NARR
BEFORE INSERT
ON CAPS.FCCP_DTL_FORM_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  SELECT  ID_CASE
  INTO    :new.ID_CASE
  FROM    EVENT
  WHERE    ID_EVENT = :new.ID_EVENT;
EXCEPTION
  WHEN OTHERS THEN
    IF SQL%NOTFOUND THEN
      :new.ID_CASE := NULL;
    END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (248, 'SacwisRev2', 'add ID_EVENT to FCCP_DTL_FORM_NARR');                                    
commit;