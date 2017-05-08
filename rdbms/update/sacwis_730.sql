--STGAP00015767 - Release(3.5) Per CAPTA - insert new messages for Allegations DD

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60672,
   'MSG_INV_SEV_DEATH_DOD_REQ',
   'Alleged Victim must have a Date of Death entered on Person Detail when the selected Severity is Child Death.', 700, 500, 'N');

--Message 2

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60673,
   'MSG_INV_SEV_REQ',
   'Severity is required when entering disposition.', 700, 500, 'N');

--Message 3

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60674,
   'MSG_INV_PRIOR_NEAR_FATALITY_REQ',
   'If the child has died, enter whether or not the death was due to a prior maltreatment recorded as a Near Fatality.', 700, 500, 'N');

--Message 4

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60675,
   'MSG_INV_PRIOR_NEAR_FATALITY_DATE_REQ',
   'Yes has been recorded that child death was due to prior maltreatment recorded as a Near Fatality.  Please enter date of the prior maltreatment.', 700, 500, 'N');

--Message 5

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60676,
   'MSG_INV_INC_PRIOR_NEAR_FATALITY_INFO',
   'Child Death has not been marked as the Severity.  Ensure that Yes has not been selected for child death was due to prior maltreatment and that no date of prior maltreatment has been entered.', 700, 500, 'N');

--Message 6

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60677,
   'MSG_INV_INC_PRIOR_NEAR_FATALITY_DATE',
   'You have recorded that Child Death was not due to prior Near Fatality maltreatment.  Do not enter a value for the date of prior near fatality maltreatment.', 700, 500, 'N');

--Message 7

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60678,
   'MSG_INV_PRIOR_NEAR_FATALITY',
   'No has been entered for prior Near Fatality, but one or more prior investigations have included a maltreatment with a severity fo Near Fatality for the alleged victim.  Please confirm case history prior to Investigation Conclusion.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (731, 'SacwisRev3', 'Release 3.5 - DBCR 15767');


commit;
 
