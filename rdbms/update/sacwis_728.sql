--STGAP00015765 - Release(3.5) Add Message for Safety Assmnt no PK Mem Hshld

-- SMS #44832

Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60671,   'MSG_MEM_PK_HSHLD_INFO',
   'Member of Primary Caretaker''s Household is not selected for one or more principals on the person detail page.', 500, 700, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (729, 'SacwisRev3', 'Release 3.5 - DBCR 15765');

commit;

