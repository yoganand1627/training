--STGAP00016123 - Release(4.2) MR-075 Update to Grace Waiver decode and messages

--MR-075 Update to Waiver decode
UPDATE CAPS.CODES_TABLES
SET DECODE = '60-90 Day FAD Home Waiver'
where CODE_TYPE = 'CWVRTYP'
and CODE = 'WGP';

--MR-075 Update message
UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Home current status does not warrant a 60-90 Day FAD Home Waiver.'
WHERE TXT_MESSAGE_NAME = 'MSG_FAD_WVR_HOME_INVALID_STATUS';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = '60-90 Day FAD Home Waiver is no longer needed. Home should be closed.'
WHERE TXT_MESSAGE_NAME = 'MSG_FAD_WVR_PERIOD_EXPIRED';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1004, 'SacwisRev4', 'Release 4.2 - DBCR 16123');

commit;


