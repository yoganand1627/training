--STGAP00015597 - Release(Undetermined) Disable Trigger

--Disable the following two triggers as it is preventing the delete of a row from the Portal_user and --Portal_user_vendor_link tables.

drop trigger caps.TDBR_PORTAL_USER;
drop trigger caps.TDBR_PORTAL_USR_VNDR_LNK;

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60627, 'MSG_PORTAL_EMAIL_SUBJ1','Thank you for Registering.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60628, 'MSG_PORTAL_EMAIL_REG','Thank you for registering to the SHINES Portal.  You will receive an email upon approval/disapproval by your administrator.',500,700,'N');
  
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60629, 'MSG_PORTAL_EMAIL_SUBJ2','SHINES Portal Registration Status',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60630, 'MSG_PORTAL_EMAIL_APPRV','Your SHINES Portal Registration has been approved.  Use the following information to login: E-mail Address: %s Password: Set during registration.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60631, 'MSG_PORTAL_EMAIL_DISAPPRV','Your SHINES Portal Registration has been disapproved.  If this was done in error, please see your Administrator.',500,700,'N');
  
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60632, 'MSG_PORTAL_EMAIL_SUBJ3','SHINES Portal Temporary Password',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60633, 'MSG_PORTAL_EMAIL_TEMPPWD','Your password for the SHINES Portal has been reset.  Please login using the following temporary password: %s ',500,700,'N');
  


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (614, 'SacwisRev3', 'Release Undetermined - DBCR 15597');

commit;

