--STGAP00017857 - Release(5.1) Modify the Caseloadlisting rpt to run statewide

--Add optional Region Parameter and modify the sequence of the County, Unit,staff ID
---parameters.
-- Modify SHINES report Launch page description
--ClearQuest #: STGAP00017818
--ASR #: ASR11139
-- DBCR STGAP00017857

update caps.reports set nm_rpt_desc = 'A comprehensive view of caseloads for a case manager.  Generated for optional Region, County, Unit and Case Manager parameters.'
where nm_rpt_sqr_name = 'CaseloadListingCounty' and
nm_rpt_sqr_ver = '00';

update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 4
where NM_RPT_SQR_NAME = 'CaseloadListingCounty'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'STAFFID';

update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 3
where NM_RPT_SQR_NAME = 'CaseloadListingCounty'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'UNIT';

update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 2, IND_REQUIRED='N'
where NM_RPT_SQR_NAME = 'CaseloadListingCounty'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'COUNTYCD';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'CaseloadListingCounty', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1191, 'SacwisRev5', 'Release 5.1 - DBCR 17857');

commit;
