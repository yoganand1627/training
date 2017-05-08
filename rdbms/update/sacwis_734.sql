--STGAP00015772 - Release(3.5) Per CAPTA - insert new messages for Event List

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60681,
   'MSG_CDNFSI_OVER_18',
   'A new Child Death/Near Fatality/Serious Injury Report cannot be generated for a child over 18.  If necessary, copy the prior report to make updates.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (735, 'SacwisRev3', 'Release 3.5 - DBCR 15772');


commit;
 
