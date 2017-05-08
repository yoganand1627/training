--STGAP00017551 - Release(5.0) ECEM 5.0: update F/A Home message

-- STGAP00017295:
update caps.message
set txt_message = 'The F/A Home Search page ONLY retrieves results that match 100% of the search criteria selected.'
where txt_message_name = 'MSG_MATCH_CRITERIA_INF';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1161, 'SacwisRev5', 'Release 5.0 - DBCR 17551');

commit;
