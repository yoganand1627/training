--STGAP00015854 - Release(3.5) Adding New codes for the code table

--Adding New codes for the code table so the output launch can display the new Child Death Form

update caps.codes_tables set decode = 'CHILDDEATH'
Where code = 'CNS' and code_type = 'CEVNTDOC' ;


update caps.codes_tables set decode = 'CHILD_DEATH_NARR'
Where code = 'CNS' and code_type = 'CEVNTTBL' ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (792, 'SacwisRev3', 'Release 3.5 - DBCR 15854');

commit;

