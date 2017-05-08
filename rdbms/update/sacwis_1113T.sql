--STGAP00017128 - Release(5.0) MR-092:Add new column to PERSON table

--Add new column to PERSON table for Person Characteristics
ALTER TABLE CAPS.PERSON ADD IND_IVE_PRIOR_ADOPTION Varchar2(1) null ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1114, 'SacwisRev5', 'Release 5.0 - DBCR 17128');

commit;
