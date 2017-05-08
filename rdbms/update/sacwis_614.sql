--STGAP00015603 - Release(Undetermined) Message for Login Popup in Portal application

--Please use the attached sql to create the message. Again, please do not break txt_message as it will cause the Javascript error while displaying.

Update CAPS.MESSAGE Set TXT_MESSAGE = 'Client information within the SHINES Portal is protected by law and unauthorized disclosure may be subject to prosecution. Click OK to continue to login or Cancel to abort login.' Where TXT_MESSAGE_NAME = 'MSG_PORTAL_LOGIN_CONFIRM';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (615, 'SacwisRev3', 'Release Undetermined - DBCR 15603');

commit;

