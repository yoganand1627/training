--STGAP00015609 - Release(3.4) Update Ext. Documentation - Assign NA for old ED.


--External Documentation detail page re-saves on View, even when the case is closed.  All older external documentations need to be assigned an N/A since they currently don't have NA assigned for older external documentation.

UPDATE CAPS.EXT_DOCUMENTATION SET IND_NA_CHECKED = 'Y'
WHERE IND_NA_CHECKED IS NULL AND ID_EXT_DOCUMENTATION NOT IN 
(SELECT ID_EXT_DOCUMENTATION FROM CAPS.EXT_DOC_PERSON_LINK);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (618, 'SacwisRev3', 'Release 3.4 - DBCR 15609');

commit;

