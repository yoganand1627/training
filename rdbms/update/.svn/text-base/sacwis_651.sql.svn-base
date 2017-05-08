--STGAP00015663 - Release(3.4) Need to end date 619 and 620 service codes

--Need to end date the 619 and 620 service codes

update caps.codes_tables
set dt_end = '12/01/2009'
where code_type in
('CADDONLI', 'CSVCCODE', 'CPROGCDE', 'CPRGAREA', 'CPRGCODE', 'CFLSVLNK')
and (code like '619%' or code like '620%');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (652, 'SacwisRev3', 'Release 3.4 - DBCR 15663');

commit;

