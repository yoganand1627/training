--STGAP00015583 - Release(Undetermined) DBCR: Update existing Ext Doc records for enhancement

--The attached SQL updates the EXT_DOCUMENTATION table to insert default values in
-- the new CD_DOC_CLASS and DT_EXT_DOC_ADDED columns added as a part of ECEM enhancements.

--Resolution is requested as soon as possible to support testing efforts.

UPDATE CAPS.EXT_DOCUMENTATION SET DT_EXT_DOC_ADDED = DT_EXT_DOC_OBTAINED WHERE DT_EXT_DOC_ADDED IS NULL;

UPDATE CAPS.EXT_DOCUMENTATION EX SET EX.CD_DOC_CLASS = (SELECT C.DECODE FROM CAPS.CODES_TABLES C WHERE C.CODE = EX.CD_EXT_DOC_TYPE
AND C.CODE_TYPE = 'CEXDOTTC' AND C.DT_END IS NULL) WHERE EX.CD_DOC_CLASS IS NULL;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (603, 'SacwisRev3', 'Release Undetermined - DBCR 15583');

commit;



