--STGAP00015814 - Release(3.43) Message for Contact Search List - Add Contact Std

Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60716,   'MSG_CONTACT_PCS_REQUIRED',
   'New contacts cannot be added without a contact standard after 14 days from the start of the ONG and FCF stages.', 500, 700, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (767, 'SacwisRev3', 'Release 3.43 - DBCR 15814');

commit;

