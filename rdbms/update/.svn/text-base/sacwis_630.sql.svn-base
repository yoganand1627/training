--STGAP00015629--Correction to decodes for the new 619 and 620 code
--Need to correct the decode values:

Update caps.codes_tables 
set decode = '61932c - Performance Payment #3'
where code_type in ('CSVCCODE', 'CADDONLI')
and code = '61932c';

Update caps.codes_tables 
set decode = '62032c - Performance Payment #3'
where code_type in ('CSVCCODE', 'CADDONLI')
and code = '62032c';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (631, 'SacwisRev3', 'Release 3.4 - DBCR 15629');

commit;

