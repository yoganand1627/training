--STGAP00009733 - Change Message Text Name

UPDATE CAPS.MESSAGE SET TXT_MESSAGE_NAME = 'MSG_SEC_TOO_MANY_DESIGNATORS'
   WHERE TXT_MESSAGE_NAME = 'MSG_SEC_TOO_MANY DESIGNATORS';


--STGAP00009769 - End date two fields in the code table

UPDATE CAPS.CODES_TABLES
  SET DT_END = '7/28/2008'
   WHERE CODE_TYPE = 'CNUMTYPE' AND
                CODE IN ('AFCARS ID', 'UID Tool ID');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (367, 'SacwisRev2', 'Release 2.6 - DBCRs 9733,9769');

commit;


