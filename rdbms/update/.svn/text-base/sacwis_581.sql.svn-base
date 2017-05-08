--STGAP00015547 - Messages for Portal Login
--The following Unique constraint is not allowing to insert multiple rows in the audit table for the same user. So this needs to be dropped

alter table caps.portal_user_audit DROP CONSTRAINT UK1_PORTAL_USER_AUDIT including indexes;


INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60603, 'MSG_PORTAL_PREV_PWD_MATCH','Your new password should not match your previous 15 passwords.',500,700,'N');

Update CAPS.MESSAGE
SET TXT_MESSAGE = 'Your account has re-locked due to an unsuccessful attempt to respond to a security question or set a new password. Please ask your administrator to reset your password.'
WHERE TXT_MESSAGE_NAME = 'MSG_PORTAL_USER_RELOCKED';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (582, 'SacwisRev3', 'Release Undetermined - DBCR 15547');

commit;


