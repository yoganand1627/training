-- change STGAP00004263
UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'The combined monthly income for the family is $0.00. Please explain in the comment box provided.' WHERE TXT_MESSAGE_NAME = 'MSG_NO_COMBINED_INCOME_REQ';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (215, 'SacwisRev2', 'static updates');
commit;
