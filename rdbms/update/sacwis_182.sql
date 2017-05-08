-- Standard Alter Table SQL

ALTER TABLE CAPS.STAGE MODIFY(CD_STAGE_REASON_CLOSED  DEFAULT NULL)
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003057
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60340, 'MSG_CONFIRM_INIT_APP_TYPE','WARNING:  An Initial Application should only be created if no application exists for the child.  Otherwise a Notification of Change should be completed instead.',500,700,'N');

-- change STGAP00003058
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60341, 'MSG_CONFIRM_NOC_APP_TYPE','WARNING:  A Notification of Change will replace all previously saved data with data from the most recent application, and should only be created if an approved application exists.  Otherwise, an Initial Application should be completed instead.',500,700,'N');

-- change STGAP00003064
UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'Removal Household and Deprivation information has been changed as compared to the most recent application.  Please enter the Effective Date of Deprivation Change.' where NBR_MESSAGE = 60185;

-- change STGAP00003068
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60342, 'MSG_FAD_NO_INCOME_STATUS','Annual Income is required on the Home Demographics section to submit.'
  ,500,700,'N');
  
-- change STGAP00003076
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60343, 'MSG_FAD_CHAR_REQ','The home must be interested in at least one Child Characteristic.'
  ,500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (183, 'SacwisRev2', 'static updates, stage_reason_closed no longer defaults to 0'); 

commit;
