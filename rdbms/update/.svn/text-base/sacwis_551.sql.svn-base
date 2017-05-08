--STGAP00015447 - MR-051 Update the message text of validation mes

--Need to update the message text for the validation message - MSG_MISSING_PARENT_TPR  as per defect STGAP00015351.

UPDATE CAPS.MESSAGE
SET txt_message = 'Warning:One or more parents may be missing documentation.Please verify that both mother and father ha
ve either a TPR Court Order Date, Voluntary Surrender Date, or Date of Death before closing the stage.'
WHERE TXT_MESSAGE_NAME = 'MSG_MISSING_PARENT_TPR';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (552, 'SacwisRev3', 'Release 3.3 - DBCR 15447');

commit;

