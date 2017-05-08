--STGAP00015843 - Release(3.43) DBCR: Update error message for CASA/GAL

--The SQL below updates error message text to be relevant for case where CASA and GAL are both missing:

UPDATE CAPS.CODES_TABLES SET DECODE = 'No CASA or GAL has been identified for the child' WHERE CODE_TYPE = 'CCASEERR' AND CODE = 'CAG';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (781, 'SacwisRev3', 'Release 3.43 - DBCR 15843');

commit;


