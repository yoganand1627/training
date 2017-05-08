-- change STGAP00006992
update CAPS.REPORTS 
set NM_RPT_ORIENTATION ='L' 
where NM_RPT_SQR_NAME='CaseHistoryOfInvestigations';


insert into caps.schema_version (id_schema_version, application_version, comments)
                       values (273, 'SacwisRev2', 'static table updates - Report tables');
commit;