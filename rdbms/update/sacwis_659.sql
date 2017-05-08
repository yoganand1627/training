--STGAP00015670 - Release(3.41) Invst-Remove "Unable to Determine" from drop down

-- Per SMS #41459

update caps.codes_tables
set dt_end = to_date('12/07/2009', 'MM/DD/YYYY')
where code_type = 'CDISPSTN'
and code='UTD';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (660, 'SacwisRev3', 'Release 3.41 - DBCR 15670');

commit;


