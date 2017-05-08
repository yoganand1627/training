--STGAP00017319 - Release(5.0) update message

update caps.message
set txt_message = 'Kenny A requirements are to be considered when placing the child in this home.  Before proceeding, please talk with your Supervisor to identify the appropriate Kenny A coordinators.'
where nbr_message = 60886;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1146, 'SacwisRev5', 'Release 5.0 - DBCR 17319');

commit;
