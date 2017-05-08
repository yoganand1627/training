--STGAP00015769 - Release(3.5) Per CAPTA - insert new messages for Stage Closure

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60680,
   'MSG_INV_CDNFSI_APRV',
   'One or more Child Death/Near Fatality/Serious Injury reports is not approved.  Approve the report prior to Saving and Submitting the stage closure.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (733, 'SacwisRev3', 'Release 3.5 - DBCR 15769');


commit;
 
