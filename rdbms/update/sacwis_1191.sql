--STGAP00017858 - Release(5.1) FC Overdue ReEval -Change County to Opt Parameter

--Foster Home Overdue ReEvaluation Report
-- Make county and optional parameter
--ClearQuest Reference #: STGAP00017837
--ASR #: ASR11180


update caps.report_parameter
set  ind_required = 'N'
where nm_rpt_sqr_name = 'FosterHomeOverdueReevaluation'
and nm_rpt_parm_name = 'COUNTYCD';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1192, 'SacwisRev5', 'Release 5.1 - DBCR 17858');

commit;
