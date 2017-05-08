--STGAP00015747 - Release(3.5) UDR Case Watch Updated DBCR

UPDATE CAPS.REPORT_PARAMETER SET IND_REQUIRED = 'N' WHERE NM_RPT_SQR_NAME = 'UDRCaseWatchActRept';
UPDATE CAPS.REPORT_PARAMETER SET NM_RPT_PARM_LABEL = 'Error Types' WHERE NM_RPT_SQR_NAME = 'UDRCaseWatchActRept' AND NM_RPT_PARM_NAME = 'ERRWARNTYP';
Delete CAPS.codes_tables WHERE code_type = 'COPCLSTG' and code = 'OPNAFS';
UPDATE CAPS.CODES_TABLES SET decode = 'Closed Stages Only (AFCARS Only)'    WHERE code_type = 'COPCLSTG' and code = 'CLDAFS';
UPDATE CAPS.CODES_TABLES SET decode = 'Active Warnings Only' WHERE code_type = 'CERRWARN' and code = 'WAR';
Update CAPS.Reports set NM_RPT_DESC = 'This is a generated list that will allow users to review the list of case errors and warnings across multiple stages, caseloads, regions and counties. Lists may be modified to view data for specific units and case managers. Use the From and To date parameters to view prior historical activity.'
Where NM_RPT_SQR_NAME = 'UDRCaseWatchActRept';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (719, 'SacwisRev3', 'Release 3.5 - DBCR 15747');

commit;


