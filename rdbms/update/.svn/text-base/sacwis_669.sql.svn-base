--STGAP00015683 - Release(3.41) DBCR: Restore Case Watch task references

--The attached SQL updates the TASK table so that the Case Watch page does not disappear when 
--clicking on other third level tabs under Case Management in stages where the Case Watch page is available.  
--This undoes STGAP15646 which was implemented to hide the Case Watch page for release 3.4, pending exposure of the page in 3.41.

UPDATE CAPS.TASK SET TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT_CW' WHERE TXT_2ND_TAB = 'CASE_MANAGEMENT_CASEMNT'
AND CD_TASK_STAGE IN ('SUB','ADO','INV','FPR');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (670, 'SacwisRev3', 'Release 3.41 - DBCR 15683');

commit;

