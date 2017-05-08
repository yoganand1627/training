--STGAP00015543 - MR-058 Add column

alter table caps.case_review_item add dt_review_complete date;
comment on column caps.case_review_item.dt_review_complete is 'Date when case review is completed.';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (579, 'SacwisRev3', 'Release 3.31 - DBCR 15543');

commit;

