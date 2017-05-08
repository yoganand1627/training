--STGAP00016060 - Release(4.1) MR-53: Add column to Eligibility

--01/12/2011
alter table CAPS.ELIGIBILITY add IND_REVIEW_CREATED VARCHAR2(1) null;

comment on column CAPS.ELIGIBILITY.IND_REVIEW_CREATED is 'Used by the SpringBatch program to indicate if it has created the Reimbursability for this Eligibility' ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (951, 'SacwisRev4', 'Release 4.1 - DBCR 16060');

commit;


