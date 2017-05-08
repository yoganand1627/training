--STGAP00017880 - Release(5.1) No Plcmt Relative/Non-Relative Rsc add reg param

--No Placements Relative/Non-Relative Resource List Statewide execution capability
--Add County Parameter and Modify SHINES report Launch page description
--ClearQuest #: STGAP00017873
--ASR #: ASR11260


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('NonPlacementRelativeResourceList','00','3','3', 'COUNTYCD', 'CHAR', 'N', 'County');


UPDATE caps.reports
set nm_rpt_desc = 'A list of active relative/non-relative resources without any approved placements according to the region tha                              t maintains the resource. Generated for a specific home/facility type and optional region and county parameters.'
where nm_rpt_sqr_name = 'NonPlacementRelativeResourceList';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1200, 'SacwisRev5', 'Release 5.1 - DBCR 17880');

commit;
