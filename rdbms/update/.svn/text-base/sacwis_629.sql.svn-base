--STGAP00015628 - Release(3.4) Adding New column to capture the dissolution date


--Adding new column to the ADO_INFO Table to capture the Date when needed.

ALTER TABLE CAPS.ADO_INFO
ADD (DT_DISRUPT TIMESTAMP);

COMMENT ON COLUMN CAPS.ADO_INFO.DT_DISRUPT IS 'Date the The Adoption was Disrupted.' ;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (630, 'SacwisRev3', 'Release 3.4 - DBCR 15628');

commit;

