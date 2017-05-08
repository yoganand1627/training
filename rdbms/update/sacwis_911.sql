--STGAP00016015 - Release(4.1) addingoptional Region to Immgrantrpt to runStatew

-- DBCR STGAP00016015
-- SMS No #80709
-- Add optional region parameter, change county parameter to optional one to run statewide.

update caps.reports set nm_rpt_desc = 'A list of all non-US citizens currently in foster care. Generated for optional region and county parameters. '
where nm_rpt_sqr_name = 'ImmigrantChildrenInFosterCare' and nm_rpt_sqr_ver = '00';

update CAPS.report_parameter
set NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N' where
NM_RPT_SQR_NAME = 'ImmigrantChildrenInFosterCare' and NM_RPT_SQR_VER = '00'
and NM_RPT_PARM_NAME = 'COUNTYCD';

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('ImmigrantChildrenInFosterCare', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (912, 'SacwisRev4', 'Release 4.1 - DBCR 16015');

commit;



