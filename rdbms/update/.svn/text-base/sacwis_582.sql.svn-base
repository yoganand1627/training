--STGAP00015563 - Release(3.31) Correction to sacwis_578.sql

--The dt_review_complete field was added to wrong table.

--This dbcr corrects the problem.

alter table caps.case_review_item drop column  dt_review_complete ;
alter table caps.case_review add dt_review_complete date;
comment on column caps.case_review.dt_review_complete is 'Date when case review
is completed.';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (583, 'SacwisRev3', 'Release 3.31 - DBCR 15563');

commit;

