--STGAP00016048 - Release(4.1) MR-053 Add new field for FCE_REVIEW


ALTER TABLE CAPS.FCE_REVIEW
ADD (DT_EXTNSION_PROVIDED_12_MNTHS DATE);

COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_EXTNSION_PROVIDED_12_MNTHS IS 'Continuance date of 12 months custody extension provided.';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (940, 'SacwisRev4', 'Release 4.1 - DBCR 16048');

commit;

