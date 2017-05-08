--STGAP00015233 - SQR - Change report desciption on launch page

-- Change Report description on launch page to read past tense and not present tense for Child Involvement in Case Planning - ONG
-- DEV #  STGAP00014619

update caps.reports
set nm_rpt_desc = 'A list of active Ongoing cases that do not have child involvement in case planning (CP). Generated for a specific month with optional region, county, and unit parameters.'
where nm_rpt_sqr_name = 'ChildWithoutInvolvementInCasePlanningONG'
and NM_RPT_SQR_VER = '00';




insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (517, 'SacwisRev3', 'Release 3.2 - DBCR 15233');

commit;


