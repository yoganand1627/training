-- All changes for version 2.4 of SHINES
-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CODES_TABLES
BEFORE UPDATE
ON CAPS.CODES_TABLES
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CODES_TABLES
BEFORE INSERT
ON CAPS.CODES_TABLES
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- change STGAP00008091
update caps.message
set txt_message = 'The CSLI cannot exceed 9999.  No more rows may be added.'
where txt_message_name = 'MSG_NO_CSLI_LEFT';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (313, 'SacwisRev2', 'static table updates, triggers on codes_tables');                        
commit;
