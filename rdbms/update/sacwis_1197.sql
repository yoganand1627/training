--STGAP00017870 - Release(5.1) CPS Intake Log - Add and Modify Parameters

--CPS Intake Log Statewide execution Capability
--Add Region Parameter and modify the sequence of the County and Date  parameters.                         -- Modify SHINES report Launch page description
--ClearQuest #: STGAP00017869
--ASR #: ASR11217

update caps.report_parameter
set nbr_rpt_parm_seq = '4'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'ENDDATE';

update caps.report_parameter
set nbr_rpt_parm_seq = '3'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'STARTDATE';

update caps.report_parameter
set nbr_rpt_parm_seq = '2',
   ind_required = 'N'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'COUNTYCD';

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('CPSIntakeLog','00','1','2','REGIONCD', 'CHAR', 'N', 'Region');

UPDATE caps.reports
set nm_rpt_desc = 'Designed to meet the policy requirements for a call log, this report displays a list of all intakes received within a specified date range for optional region and county parameters.'
where nm_rpt_sqr_name = 'CPSIntakeLog';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1198, 'SacwisRev5', 'Release 5.1 - DBCR 17870');

commit;
