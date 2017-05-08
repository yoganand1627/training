--STGAP00017146 - Release(5.0) update person characteristics codes

update caps.codes_tables
set code_type = 'EXB1'
where code_type = 'OTH1'
and code = '86';

delete from caps.codes_tables
where code_type = 'OTH1'
and code = '109';

update caps.codes_tables
set code_type = 'EBD1'
where code_type = 'OTH1'
and code = '142';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1126, 'SacwisRev5', 'Release 5.0 - DBCR 17146');

commit;
