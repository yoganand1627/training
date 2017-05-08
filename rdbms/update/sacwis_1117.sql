--STGAP00017133 - Release(5.0) MR-092:Add new column to PERSON_HISTORY table

--Add new column to PERSON_HISTORY table for Person Characteristics
ALTER TABLE CAPS.PERSON_HISTORY ADD IND_IVE_PRIOR_ADOPTION Varchar2(1) null;

comment on column CAPS.PERSON_HISTORY.IND_IVE_PRIOR_ADOPTION  is 'Indicates whether the child was determined to be eligible for Title IV-E in a prior adoption' ;

comment on column CAPS.PERSON_ENC.IND_IVE_PRIOR_ADOPTION  is 'Indicates whether the child was determined to be eligible for Title IV-E in a prior adoption' ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1118, 'SacwisRev5', 'Release 5.0 - DBCR 17133');

commit;
