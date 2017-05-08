
-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.DIVERSION_CONCLUSION_NARR
(
    ID_EVENT             NUMBER(16) NOT NULL,
    DT_LAST_UPDATE       DATE       NOT NULL,
    ID_CASE              NUMBER(16)     NULL,
    NARRATIVE            LONG RAW       NULL,
    ID_DOCUMENT_TEMPLATE NUMBER(16)     NULL,
    CONSTRAINT PK_DIVERSION_CONCLUSION_NARR
    PRIMARY KEY (ID_EVENT)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.DIVERSION_CONCLUSION_NARR IS
'Contains the narrative blob for the Diversion Conclusion Narrative.'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION_NARR.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSBAT
;
GRANT INSERT ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSBAT
;
GRANT SELECT ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSBAT
;
GRANT UPDATE ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSBAT
;
GRANT DELETE ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSON
;
GRANT INSERT ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSON
;
GRANT SELECT ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSON
;
GRANT UPDATE ON CAPS.DIVERSION_CONCLUSION_NARR TO CAPSON
;
GRANT SELECT ON CAPS.DIVERSION_CONCLUSION_NARR TO OPERATOR
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.DIVERSION_CONCLUSION_NARR 
    ADD CONSTRAINT FK_DIVERSION_CONC_NARR_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_DIVERSION_CONCLUSION_NARR
BEFORE INSERT
ON CAPS.DIVERSION_CONCLUSION_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := SYSDATE;
   SELECT ID_CASE
   INTO  :NEW.ID_CASE
   FROM  EVENT
   WHERE  ID_EVENT = :NEW.ID_EVENT;
 EXCEPTION
 WHEN OTHERS THEN
   IF SQL%NOTFOUND THEN
     :NEW.ID_CASE := NULL;
   END IF;
 END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_DIVERSION_CONCLUSION_NARR
BEFORE UPDATE
ON CAPS.DIVERSION_CONCLUSION_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
    :NEW.DT_LAST_UPDATE := SYSDATE;
 END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003797
-- there are 'funny' characters in CLEGSTAT.  This updates them to be normal dashes.  This does not change any codes or decodes. 

update caps.codes_tables
set decode = 'Not In DFCS Custody - Adoption Finalized'
where code = 'NAF'
and code_type = 'CLEGSTAT';

update caps.codes_tables
set decode = 'Not In DFCS Custody - Custody To Other'
where code = 'NCO'
and code_type = 'CLEGSTAT';

update caps.codes_tables
set decode = 'Not In DFCS Custody - Child Turned 18 (No ILP)'
where code = 'NCT'
and code_type = 'CLEGSTAT';

update caps.codes_tables
set decode = 'Not In DFCS Custody - Guardianship'
where code = 'NGP'
and code_type = 'CLEGSTAT';

update caps.codes_tables
set decode = 'Not In DFCS Custody - Parental Custody'
where code = 'NPC'
and code_type = 'CLEGSTAT';

update caps.codes_tables
set decode = 'Not In DFCS Custody - Custody Transferred To Tribe'
where code = 'NTT'
and code_type = 'CLEGSTAT';

update caps.codes_tables
set decode = 'Not In DFCS Custody - Emancipated'
where code = 'NCE'
and code_type = 'CLEGSTAT';

update caps.codes_tables
set decode = 'Not In DFCS Custody - Perm Custody To Relative For Adoption'
where code = 'NCE'
and code_type = 'CLEGSTAT';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (204, 'SacwisRev2', 'static updates, new narrative table');
commit;
