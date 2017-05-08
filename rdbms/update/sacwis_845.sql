--STGAP00015929 - Release(3.6) MR-66: Add codes tables for Res Facility

--Updates on 6/22/2010
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMALT', '011', 'Residential Facility (CCI)');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (846, 'SacwisRev3', 'Release 3.6 - DBCR 15929');

commit;


