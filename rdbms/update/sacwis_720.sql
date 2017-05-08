--STGAP00015760 - Release(3.42) MR-60 UPDATE Codes Table for non incident AFCARS

update caps.codes_tables set decode = 'Documented physical/medical condition or mental/emotional disabilities' where code = '06' and code_type = 'CPRSPCLN';

update caps.codes_tables set decode = 'Membership of a sibling group of two placed together where one child is special needs' where code = '04' and code_type = 'CPRSPCLN';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (721, 'SacwisRev3', 'Release 3.42 - DBCR 15760');

commit;

