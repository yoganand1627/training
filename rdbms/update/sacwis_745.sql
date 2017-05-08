--STGAP00015786 - Release(3.5) SMS #44704: Update codetype CSVCCODE

update caps.codes_tables set decode = '51033c - Travel/Lodging/Meals' where code = '51033c' and code_type = 'CSVCCODE';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (746, 'SacwisRev3', 'Release 3.5 - DBCR 15786');


commit;
 
