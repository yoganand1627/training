-- STGAP00009429 - Inactivate The Cases With Safety Resources Report
update caps.reports
set caps.reports.IND_RPT_PAGE = 'N'
where caps.reports.NM_RPT_SQR_NAME = 'CasesWithSafetyResources'; 

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (353, 'SacwisRev2', 'Release 2.5 - DBCR 9429');
commit;

