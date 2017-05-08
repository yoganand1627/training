--STGAP00015981 - Release(4.0) MR-067: Update/Add for Portal Login page

--Update existing message to account for new type of user: NYTD youth, add new message, and new column email address to Person table. These are for modification on the Portal Login page.

-- New column:
ALTER TABLE CAPS.PERSON_DTL
ADD  TXT_PERSON_DTL_EMAIL VARCHAR2(70) ;
COMMENT ON COLUMN CAPS.PERSON_DTL.TXT_PERSON_DTL_EMAIL IS 'RECORD EMAIL THAT APPLIES TO THE PERSON IN GENERAL. INTENDED TO CAPTURE YOUTH CONTACT INFO OST FC';


-- Message:
update caps.message 
set txt_message = 'Your password has expired.  Please reset your password using the reset password hyperlink.'
where nbr_message = 60590;

update caps.message 
set txt_message = 'Your account has been locked due to multiple unsuccessful login attempts.  Please reset your password using the reset password hyperlink.'
where nbr_message = 60591;

update caps.message 
set txt_message = 'Your account has been locked due to unsuccessful attempts to respond to a security question or set a new password. Please reset your password using the reset password hyperlink.'
where nbr_message = 60596;

update caps.message 
set txt_message = 'If you are not an approved RBWO provider do not register.  Click OK to continue to register or Cancel to cancel your registration.'
where nbr_message = 60597;

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60772, 'MSG_PORTAL_CONTACT_ADMIN','If you are unable to reset your password via the reset password hyperlink, please contact the Help Desk.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60773, 'MSG_PORTAL_TMP_PWD_RESET_NOT_ALLOWED','Your profile has temporary password. Please log on to Portal to verify your profile and change your password.',500,700,'N');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (885, 'SacwisRev4', 'Release 4.0 - DBCR 15981');

commit;

