--STGAP00015984 - Release(4.0) MR-067 End-date CUSRTYP for NYTD User (NYU)

--STGAP00015984  MR-067 End-date CUSRTYP for NYTD User (NYU)

Update caps.codes_tables
set dt_end = sysdate
where code_type = 'CUSRTYP'
and code = 'NYU';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (890, 'SacwisRev4', 'Release 4.0 - DBCR 15984');

commit;

