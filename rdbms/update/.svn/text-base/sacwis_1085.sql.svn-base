--STGAP00017016 - Release(5.0) Updating database values

update caps.codes_tables
set decode = 'Infant Drug Addiction/Prenatal Drug Exposed'
where code_type = 'CME' and code = '42';

update caps.characteristics_group
set characteristics_group_code = 'DED',
characteristics_group_decode = 'Developmentally Delayed'
where characteristics_code = 141;

--Note This should be committed after STGAP00016998

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1086, 'SacwisRev5', 'Release 5.0 - DBCR 17016');

commit;

