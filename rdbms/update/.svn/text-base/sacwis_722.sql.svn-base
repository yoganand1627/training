--STGAP00015756 - Release(3.5) CAPTA: Update codes tables


update caps.codes_tables set decode = ' Atty/GAL' where code = '352' and code_type = 'CRELATYP';


update caps.codes_tables set decode = ' Atty/GAL' where code = 'GX' and code_type = 'CSRCRPTR';


update caps.codes_tables set decode = ' Atty/GAL' where code = 'GX' and code_type = 'CRPTRINT';


update caps.codes_tables set decode = ' Atty/GAL' where code = 'GX' and code_type = 'CRELCOL2';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (723, 'SacwisRev3', 'Release 3.5 - DBCR 15756');

commit;


