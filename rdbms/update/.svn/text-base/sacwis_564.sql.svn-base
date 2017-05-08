-- STGAP00015510 pdate to message that has control chars

update CAPS.MESSAGE set TXT_MESSAGE = 'Warning:One or more parents may be missing documentation.Please verify that both mother and father have either a TPR Court Order Date, Voluntary Surrender Date, or Date of Death before closing the stage.' where TXT_MESSAGE_NAME = 'MSG_MISSING_PARENT_TPR';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (565, 'SacwisRev3', 'Release 3.3 - DBCR 15510');

commit;


