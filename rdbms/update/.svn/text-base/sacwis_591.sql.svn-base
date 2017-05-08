--STGAP00015565 - Release(Undetermined) Update Message for Portal

--Please make sure the update statement that I attached is executed as it is (meaning, please don't break the txt_message in to 2 or more lines. Keep it one line) to avoid the Javascript error.

Update CAPS.MESSAGE
SET TXT_MESSAGE = 'Your account has re-locked due to an unsuccessful attempt to respond to a security question or set a new password. Please ask your administrator to reset your password.'
WHERE TXT_MESSAGE_NAME = 'MSG_PORTAL_USER_RELOCKED';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (592, 'SacwisRev3', 'Release Undetermined - DBCR 15565');

commit;

