-- All changes for version 2.4 of SHINES
-- Standard Alter Table SQL

ALTER TABLE ORS.FACILITY DROP UNIQUE (SHINES_RSRC_ID) DROP INDEX
;
-- Alter Index SQL

CREATE INDEX ORS.IND_FAC_SHINES_ID
    ON ORS.FACILITY(SHINES_RSRC_ID)
TABLESPACE INDEX01;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (309, 'SacwisRev2', 'Index Change on the ORS Schema');                        
commit;
