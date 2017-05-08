--STGAP00011575 - Allow saving of home name with 40 chars in length

--Note:  no impact to ado model

--Allow Home/Resource Name to be saved containing 40 characters in length

ALTER TABLE CAPS.CAPS_RESOURCE MODIFY NM_RESOURCE VARCHAR2(40);


--STGAP00011578 - Table has wrong decode for code CFARSPIT_O

-- Note:  no impact to ado model

--Update the decode for codes table code CFARSPIT_O

UPDATE CAPS.CODES_TABLES SET DECODE = 'Respite Only' WHERE CODE_TYPE = 'CFARSPIT' AND CODE = 'O';


--STGAP00011612 - Per STGAP00010572 Update Codes_Tables

--Note:  no impact on ado model

--Per STGAP00010572

--Need to update Decode field of the Codes_Tables for Code = 'OCHD' and Code_Type = 'COTHER'

--This will remove special character from the decode field and thus will stop \u00A0 being displayed on the Intake Report form.

--SQL Statements :

UPDATE caps.Codes_Tables
SET decode ='Child resides in the same household of a child who died of what may have been child maltreatment'
WHERE code = 'OCHD' AND code_type = 'COTHER';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (415, 'SacwisRev3', 'Release 3.1 - DBCRs 11572,11578,11612');

commit;


