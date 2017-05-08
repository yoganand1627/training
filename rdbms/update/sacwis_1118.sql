--STGAP00017135 - Release(5.0) update code

update caps.codes_tables
set decode = 'Infant Drug Addiction/Prenatal Drug Exposed'
where code_type = 'CME'
and code = '42';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1119, 'SacwisRev5', 'Release 5.0 - DBCR 17135');

commit;
