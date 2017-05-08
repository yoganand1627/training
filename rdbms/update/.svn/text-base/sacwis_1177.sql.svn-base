--STGAP00017808 - Release(5.1) Add Region Param to Foster Care 14 and Older Rpt

 --Foster Care 14 and Older Statewide execution Capability
--Add Region Parameter and modify the sequence of the County and Staff Id parameters.                         -- Modify SHINES report Launch page description
--ClearQuest #: STGAP00017806
--ASR #: ASR11108


update CAPS.report_parameter
set nbr_rpt_parm_seq = '3'
where nm_rpt_sqr_name = 'FosterCareAge14AndOlder'
and nm_rpt_parm_name = 'STAFFID';

update CAPS.report_parameter
set nbr_rpt_parm_seq = '2',
   ind_required = 'N'
where nm_rpt_sqr_name = 'FosterCareAge14AndOlder'
and nm_rpt_parm_name = 'COUNTYCD';


INSERT INTO CAPS.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FosterCareAge14AndOlder','00','1','2','REGIONCD', 'CHAR', 'N', 'Region');


UPDATE CAPS.reports
set nm_rpt_desc = 'A list of children in foster care age 14 and older in the county. Generated for optional region, county, and/or case manager parameters.'
where nm_rpt_sqr_name = 'FosterCareAge14AndOlder';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1178, 'SacwisRev5', 'Release 5.1 - DBCR 17808');

commit;

