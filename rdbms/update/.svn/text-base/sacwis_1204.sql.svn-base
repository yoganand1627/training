--STGAP00017927 - Release(5.1) Optional Region to Period Finaliz to run statewide

-- To add optional parameter Region to Period Finalization Summary Report, to make it run statewide
-- Add Region Parameter and modify the sequence of the County parameters.
-- Modify SHINES report Launch page description
-- ClearQuest #: STGAP00017817
-- ASR #: ASR11138
-- DBCR STGAP00017927


update caps.reports set nm_rpt_desc = 'A list of counties and the number of adoptions finalized in the counties by month where the date of finalization is within the reporting period. Generated for a specific date range parameter and optional Region and County parameters. This report requires SAU staff security attribute.'
where nm_rpt_sqr_name = 'PeriodFinalizationSummary' and nm_rpt_sqr_ver = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'PeriodFinalizationSummary', '00', 3, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'PeriodFinalizationSummary', '00', 4, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1205, 'SacwisRev5', 'Release 5.1 - DBCR 17927');

commit;
