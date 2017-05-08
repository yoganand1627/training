--STGAP00015646 - Release(3.4) 3.4: Hide Case Watch

--The attached DBCR must be commited prior to 3.4 build to hide the Case Watch page.  Should be committed after confirmation of the 3.4 release date.

--This is part of hiding Case Watch for 3.4, pending 3.4.1

UPDATE CAPS.TASK SET TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT' WHERE TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT_CW';

--Undo see 
--UPDATE CAPS.TASK SET TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT_CW' WHERE TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT'
--AND CD_TASK_STAGE IN ('SUB','ADO','INV','FPR');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (645, 'SacwisRev3', 'Release 3.4 - DBCR 15646');

commit;

