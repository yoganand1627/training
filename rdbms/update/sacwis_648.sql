--STGAP00015652 - Release(3.5) SMS#37253 :Add Column to Temp_child_search_results

alter table caps.temp_child_search_results
add NM_PERSON_MIDDLE VARCHAR2(12);

comment on column caps.temp_child_search_results.NM_PERSON_MIDDLE is 'This column holds person''s middle name.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (649, 'SacwisRev3', 'Release 3.5 - DBCR 15652');

commit;

