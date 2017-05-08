--STGAP00017840 - Release(5.1) MR-097:Update CodesTable for Provider Type

update caps.codes_tables
set decode = 'Relative Enhanced Relative Rate (DFCS  Custody)'
where code_type = 'CFACTYP4'
and code = 'RE';

update caps.codes_tables
set decode = 'Relative (No Payment) (DFCS  Custody)'
where code_type = 'CFACTYP4'
and code = 'RN';

update caps.codes_tables
set decode = 'Relative TANF(DFCS  Custody) '
where code_type = 'CFACTYP4'
and code = 'RT';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1180, 'SacwisRev5', 'Release 5.1 - DBCR 17840');

commit;
