--STGAP00015908 - Release(3.5) MR-064 Contact Standards

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60750,'MSG_CS_ONE_CONTACT_METHOD','You indicated one Contact Standard, you can select only one Method of Contact.  Select the most appropriate Method of Contact for %s',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (831, 'SacwisRev3', 'Release 3.5 - DBCR 15908');

commit;

