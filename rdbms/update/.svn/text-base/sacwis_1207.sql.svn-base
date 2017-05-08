--STGAP00017982 - Release(5.01) (HOLD)Update a Decode Value for Code_Type CCPTASF1

-- Update a Decode Value for Code_Type CCPTASF1
-- This is a DBCR per STGAP00017923 for R5.03
-- (NOTE: 5.03 is not available from the Release dropdown so Release is marked as 5.01)

update caps.codes_tables
set decode = 'Child is an abandoned infant as set forth in O.C.G.A. Section 15-11-94(b)(3)'
where code = 'COG' and code_type = 'CCPTASF1'
and decode = 'Child is an abandoned infant as set forth in O.C.G.A. Section 15-11-81(b)';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1208, 'SacwisRev5', 'Release 5.01 - DBCR 17982');

commit;
