--STGAP00015525 - Messages for Portal Login Page

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60588, 'MSG_PORTAL_PWD_MATCH','New passwords do not match.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60589, 'MSG_PORTAL_PWD_STANDARDS','The new password does not match standards: the password must be at least 8 characters, alphanumeric, include upper
and lower case, include both numeric and alphabetical characters, and not start with the word ''password''.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60590, 'MSG_PORTAL_PWD_EXPIRED','Your password has expired.  Please ask your administrator to reset your password.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60591, 'MSG_PORTAL_PWD_LOCKED','Your account has been locked due to multiple unsuccessful login attempts. Please ask your administrator to reset your password.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60592, 'MSG_PORTAL_LOGIN_CONFIRM','<TEXT to be determined warning user of security/privacy responsibilities>. Click OK to continue to login or Cancel to abort login.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60593, 'MSG_PORTAL_SEC_QUES_INCORRECT','The response to the security question is incorrect.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60594, 'MSG_PORTAL_USER_LINK','Your account is not actively linked to any resource on the portal. Please contact your administrator.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60595, 'MSG_PORTAL_REG_CONFIRM','Thank you for registering. A confirmation has been sent to the e-mail address provided. You will be notified via e-mail when your registration is completed.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60596, 'MSG_PORTAL_USER_RELOCKED','Your account has re-locked due to an unsuccessful attempt to respond to a security question or set a new password. Please ask your administrator to reset your password.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60597, 'MSG_PORTAL_REG_APRV_PROV_CONFIRM','The SHINES Portal is currently only to be used by approved RBWO providers at this time.  If you are not an
approved provider do not register. Click OK to continue to register or Cancel to cancel your registration.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60598, 'MSG_PORTAL_LOGIN_PENDING','Your registration is still pending. Please follow up with your administrator.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60599, 'MSG_PORTAL_TEMP_LOGIN','You logged in using a temporary password. Please answer your security question and set a new password to complete login.',500,700,'N');


INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60600, 'MSG_PORTAL_EMAIL_ERROR','The e-mail address entered has not been registered for access to the portal.',500,700,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (573, 'SacwisRev3', 'Release Undetermined - DBCR 15525');

commit;


