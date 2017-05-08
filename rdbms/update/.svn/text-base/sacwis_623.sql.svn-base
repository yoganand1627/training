--STGAP00015616 - Release(3.4) DBCR: Update Case Management Tasks

--The attached SQL updates rows in the TASK table for the new second level case 
--management tab used in the FCC, ADO, ONG, and INV stages for direct navigation to
--the Case Watch page.  Tasks in the other stages are unchanged.

UPDATE CAPS.TASK SET TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT_CW' WHERE TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT'
AND CD_TASK_STAGE IN ('SUB','ADO','INV','FPR');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (624, 'SacwisRev3', 'Release 3.4 - DBCR 15616');

commit;

