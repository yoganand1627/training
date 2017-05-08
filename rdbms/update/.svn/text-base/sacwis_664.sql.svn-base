--STGAP00015678 - Release(3.41) Unend date the 619 and 620 service codes

update caps.codes_tables
set dt_end = null
where code_type in ('CADDONLI', 'CSVCCODE', 'CPROGCDE', 'CPRGAREA', 'CPRGCODE','CFLSVLNK')
and (code like '619%' or code like '620%');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (665, 'SacwisRev3', 'Release 3.41 - DBCR 15678');

commit;

