--STGAP00012536 - Reports: Update Adoptions reports description

update caps.reports 
set NM_RPT_DESC = 'A list of registered children in consideration whose date out is more than 31 calendar days. Generated for optional region and county parameters. Leave the region and county parameters blank to generate the statewide view of the report. SAU staff security attribute required.'
where  NM_RPT_SQR_NAME = 'ConsiderationOverdue';

update caps.reports 
set NM_RPT_DESC = 'A list of registered children that have not been adopted or adoption happened in the past 60 calendar days. Generated for optional region and county parameters. Leave the region and county parameters blank to generate the statewide view of the report. SAU sealed security attribute required.'
where NM_RPT_SQR_NAME = 'MonthlyChildMangement';

update caps.reports 
set NM_RPT_DESC = 'A list of all active homes registered with the Adoption Exchange. Generated for optional region and county parameters. Leave the region and county parameters blank to generate the statewide view of the report. SAU staff security attribute required.'
where NM_RPT_SQR_NAME = 'MonthlyFamilyManagement';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (438, 'SacwisRev3', 'Release 3.0 - DBCRs 12536');

commit;


