--STGAP00017843 - Release(5.1) FC Hm Overdue ReEvaluation Add Statewide Parameter

--Foster Home Overdue ReEvaluation Statewide execution Capability
--Add Region Parameter and modify the sequence of the County, Unit, and Staff Id --parameters.
-- Modify SHINES report Launch page description
--ClearQuest #: STGAP00017837
--ASR #: ASR11180



update caps.report_parameter
set nbr_rpt_parm_seq = '4'
where nm_rpt_sqr_name = 'FosterHomeOverdueReevaluation'
and nm_rpt_parm_name = 'STAFFID';

update caps.report_parameter
set nbr_rpt_parm_seq = '3'
where nm_rpt_sqr_name = 'FosterHomeOverdueReevaluation'
and nm_rpt_parm_name = 'UNIT';

update caps.report_parameter
set nbr_rpt_parm_seq = '2',
   ind_required = 'Y'
where nm_rpt_sqr_name = 'FosterHomeOverdueReevaluation'
and nm_rpt_parm_name = 'COUNTYCD';


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FosterHomeOverdueReevaluation','00','1','2','REGIONCD', 'CHAR', 'N', 'Region');


UPDATE caps.reports
set nm_rpt_desc = 'List of all active DFCS foster homes in the county where the approval end date has passed. Generated for optional region, county, unit, and case manager parameters.'
where nm_rpt_sqr_name = 'FosterHomeOverdueReevaluation';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1182, 'SacwisRev5', 'Release 5.1 - DBCR 17843');

commit;
