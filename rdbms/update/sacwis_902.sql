--STGAP00015999 - Release(4.0) MR-72:Update Records Check messages

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'There is one or more Principal or Member of Primary Caretaker''s Household upon whom a current Records Check has not been completed.'
WHERE TXT_MESSAGE_NAME = 'MSG_RECORDS_CHECK_REQ';

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'There is one or more Principal or Member of Primary Caretaker''s Household upon whom a current Records Check has not been completed. Please click OK to Continue or Cancel to Add Records Check.'
WHERE TXT_MESSAGE_NAME = 'MSG_INT_RECORDS_CHECK_WARN';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (903, 'SacwisRev4', 'Release 4.0 - DBCR 15999');

commit;

