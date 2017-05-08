-- change STGAP00006618
update caps.metaphor set txt_tab_url='/admin/Reports/reportLaunchList' where txt_tab_constant='REPORTS_REPORTLIST';
update caps.metaphor set txt_tab='Report<br>Pick Up' where txt_tab_constant='REPORT_LIST_REPORTLIST';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (264, 'SacwisRev2', 'static table updates');                        
commit;
