--STGAP00016174 - Release(4.3) Add new message for Safety Resource Detail

-- Adding New message for Safety Resource Detail
Insert into CAPS.MESSAGE
  (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values
  (0, sysdate, 60870 , 'MSG_SFTY_RSRC_RSN_DNL_REQ', 'Please enter a Reason for Denial and Comments if you are not recommending the Primary Safety Resource for Placement.', 700, 500, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1038, 'SacwisRev4', 'Release 4.3 - DBCR 16174');

commit;

