--STGAP00014300 - Reports: Cases without Parent Involvement - ONG

--Note:   no impact ado stage


-- Update report name to clarify this is an exception report
-- Related defect/DBCR:  Dev# 14123 ;   DBCR:   14125


UPDATE CAPS.REPORTS
SET TXT_RPT_FULL_NAME = 'Cases Without Parent Involvement in CP - ONG',
NM_RPT_DESC = 'A list of active Ongoing cases that did not have parent involvement in case planning (CP). Generated for optional region, county, and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningONG' and NM_RPT_SQR_VER= '00';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (481, 'SacwisRev3', 'Release 3.1 - DBCRs 14300');

commit;


