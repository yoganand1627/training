--STGAP00015768 - Release(3.5) Per CAPTA - insert new messages for Person Charact

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60679,
   'MSG_CHILD_FIRST_INFO',
   'If the child is at risk for poor health or development such as chronic health problems or has developmental delays please complete the Children 1st form to refer the child to Public Health as appropriate.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (732, 'SacwisRev3', 'Release 3.5 - DBCR 15768');


commit;
 
