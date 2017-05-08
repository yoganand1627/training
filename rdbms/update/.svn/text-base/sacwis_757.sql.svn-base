--STGAP00015806 - Release(3.5) Update Message Text for MR-061

--Update the message text for MSG_SVC_TOO_MANY_CONTACTS_FOUND to read:

--You have exceeded more than 500 contacts, please narrow your search criteria to generate the Log of Contact Narratives.

update caps.message set TXT_MESSAGE='You have exceeded more than 500 contacts, please narrow your search criteria to generate the Log of Contact Narratives.'
where TXT_MESSAGE_NAME='MSG_SVC_TOO_MANY_CONTACTS_FOUND';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (758, 'SacwisRev3', 'Release 3.5 - DBCR 15806');

commit;

