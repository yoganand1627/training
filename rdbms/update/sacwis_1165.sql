--STGAP00017675 - Release(5.0) MR-095 Custody: Update Custody mapping table

-- Per STGAP00017635
-- Update Custody mapping for 'Great Niece' in Sibling category
-- from 'Other Relative' to 'Great Niece'

update caps.stage_pers_rel_map_custody
set cd_stage_pers_rel_next_stage = 'GN'
where  CD_STAGE_PERS_REL_PK = 'Sibling'
and CD_STAGE_PERS_REL_CURR_STAGE = 'GN';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1166, 'SacwisRev5', 'Release 5.0 - DBCR 17675');

commit;
