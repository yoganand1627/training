--STGAP00015632 - Release(Undetermined) MR-57 Add new column to Placement table

--Need new column for MR-57

ALTER TABLE CAPS.PLACEMENT ADD  (IND_LTFC_PLACEMENT VARCHAR2(1));

comment on column caps.placement.IND_LTFC_PLACEMENT is 'Indicator to indicate if the placement is a Long Term Foster Care Placement.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (633, 'SacwisRev3', 'Release Undetermined - DBCR 15632');

commit;



