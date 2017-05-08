
--STGAP00015974 - Release(4.0) MR-072 Add new column to Stage person link

alter table caps.stage_person_link add DT_PERSON_ADDED_OR_RELATED date;
comment on column caps.stage_person_link.DT_PERSON_ADDED_OR_RELATED is 'The date person was added or related' ;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (880, 'SacwisRev4', 'Release 4.0 - DBCR 15974');

commit;


