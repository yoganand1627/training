--STGAP00015863 - Release(3.43) MR-62: Add new message to add  PK rule


Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60731,
   'MSG_ADD_CONTACT_RULE_PK',
   'A Parent Contact Rule needs to be added for Primary Caretaker - (%s).', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (799, 'SacwisRev3', 'Release 3.43 - DBCR 15863');

commit;


