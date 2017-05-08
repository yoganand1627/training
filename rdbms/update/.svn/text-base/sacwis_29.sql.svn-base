
-- Standard Alter Table SQL

ALTER TABLE CAPS.SACWIS_AUDIT RENAME COLUMN DT_LAST_UPDATE TO DT_USER_ACTION
;


-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SACWIS_AUDIT
BEFORE INSERT
ON CAPS.SACWIS_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  IF (:NEW.ID_SACWIS_AUDIT IS NULL OR :NEW.ID_SACWIS_AUDIT = 0) THEN
    SELECT  SEQ_SACWIS_AUDIT.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :NEW.ID_SACWIS_AUDIT := dummy;
  END IF;
END;
/
/
DROP TRIGGER CAPS.TUBR_SACWIS_AUDIT
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (30, 'SacwisRev1', 'rename DT_LAST_UPDATE column in SACWIS_AUDIT');

commit;

