--STGAP00017841 - Release(5.1) RBWO Active Plcmts Statewide execution Capability

--RBWO Active Placements Statewide execution Capability
--Add Region Parameter and modify the sequence of the County parameter.
-- Modify SHINES report Launch page description
--ClearQuest #: STGAP00017813
--ASR #: ASR11134


update caps.report_parameter
set nbr_rpt_parm_seq = '2',
   ind_required = 'N'
where nm_rpt_sqr_name = 'RBWOActivePlacements'
and nm_rpt_parm_name = 'COUNTYCD';



INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('RBWOActivePlacements','00','1','2','REGIONCD', 'CHAR', 'N', 'Region');

--New wording
UPDATE caps.reports
set nm_rpt_desc = 'A list of all children currently placed in Room, Board, and Watchful Oversight (RBWO) placements. Generated for optional region and county parameters.'
where nm_rpt_sqr_name = 'RBWOActivePlacements';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1181, 'SacwisRev5', 'Release 5.1 - DBCR 17841');

commit;
