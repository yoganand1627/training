--STGAP00015761 - Release(3.5) CAPTA: Insert new message for Investigation Concl.

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE,60667,
   'MSG_INV_BCW_REF_REQ_1',
   'One or more children under the age do not have a Babies Can Not Wait/Children 1st Referral.  Please navigate to the Children 1st Referral List page for each child under 3 to generate and complete the referrals to Public Health.', 700, 500, 'N');

--Message 2

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60668,
   'MSG_INV_BCW_REF_REQ_2',
   'One or more children under the age of 3 whom have an identified physical impairment or developmental delay does not have a Babies Can Not Wait/Children 1st Referral.  Please navigate to the Children 1st Referral List page for the children with medical conditions to generate and complete the refe
rral to Public Health.', 700, 500, 'N');

--Message 3

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60669,
   'MSG_INV_CDNFSI_REQ',
   'One or more Child Death/Near Fatality/Serious Injury reports is not approved.  Approve the report prior to Saving and Submitting the stage closure.', 700, 500, 'N');

--Message 4

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60670,
   'MSG_INV_CD_ALLEG_DOD_REQ',
   'One or more children associated to an allegation with a severity of Child Death to not have an entered Date of Death.  Enter Date of Death on Person Detail before closing the stage.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (727, 'SacwisRev3', 'Release 3.5 - DBCR 15761');

commit;

