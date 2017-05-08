--STGAP00015727 - Release(3.5) MR-57:Add msg agreement date cant be in the future

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60650,
   'MSG_PLCMT_DTAGRMNTSIGNED_CAN_NOT_BE_IN_FUTURE',
   'Date Agreement Signed cannot be a future date.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (702, 'SacwisRev3', 'Release 3.5 - DBCR 15727');

commit;

