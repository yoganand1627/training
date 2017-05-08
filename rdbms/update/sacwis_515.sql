--STGAP00015187 - Per STGAP00014573 enddt closure reason APD

--Per STGAP00014573 we do not need the  closure reason of 'Adoptive Parent Death' for Adoption Stage --Closure


UPDATE CAPS.codes_tables 
SET dt_end = sysdate
WHERE code_type = 'CCLOSADO' AND code = 'APD';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (516, 'SacwisRev3', 'Release 3.2 - DBCR 15187');

commit;


