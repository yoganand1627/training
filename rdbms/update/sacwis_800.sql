--STGAP00015866 - Release(3.43) MR-062 Update to the message


update caps.message set TXT_MESSAGE = 'You have entered 0 contacts for %s.  Ensure this meets practice and policy requirements.'
where TXT_MESSAGE_NAME = 'MSG_CS_CHILD_CONTACT_RULE_ZERO';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (801, 'SacwisRev3', 'Release 3.43 - DBCR 15866');

commit;


