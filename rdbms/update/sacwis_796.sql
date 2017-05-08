--STGAP00015861 - Release(3.43) MR-62: Drop columns from contact_standards

alter table caps.contact_standards drop column id_case;
alter table caps.contact_standards drop column id_stage;

Update caps.Task set IND_TASK_NEW_USING = '0' where CD_TASK in ('6540', '7025');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (797, 'SacwisRev3', 'Release 3.43 - DBCR 15861');

commit;


