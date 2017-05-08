--STGAP00017848 - Release(5.1) Modify the Pending Approvals rpt to statewide

-- To add optional parameter Region to Pending Approvals Report, to make it run statewide
--Add Region Parameter and modify the sequence of the County, Unit parameters.
-- Modify SHINES report Launch page description
--ClearQuest #: STGAP00017812
--ASR #: ASR11136
-- DBCR STGAP00017848

update caps.reports set nm_rpt_desc = 'A list of all approval tasks awaiting authorization from a supervisor. Generated for optional Region, County and Unit parameters.'
where nm_rpt_sqr_name = 'PendingApprovals' and
nm_rpt_sqr_ver = '00';


update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 3
where NM_RPT_SQR_NAME = 'PendingApprovals'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'UNIT';

update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 2, IND_REQUIRED='N'
where NM_RPT_SQR_NAME = 'PendingApprovals'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'COUNTYCD';



INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'PendingApprovals', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1187, 'SacwisRev5', 'Release 5.1 - DBCR 17848');

commit;
