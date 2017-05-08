-- change STGAP00007023
DELETE FROM CAPS.REPORT_PARAMETER WHERE NM_RPT_SQR_NAME = 'FosterCareDischargeReport';
DELETE FROM CAPS.REPORTS WHERE NM_RPT_SQR_NAME = 'FosterCareDischargeReport';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (277, 'SacwisRev2', 'static table updates - Report tables');                        
commit;

