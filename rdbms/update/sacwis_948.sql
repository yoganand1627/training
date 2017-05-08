--STGAP00016057 - Release(4.1) MR-053 FCEA metaphor update

-- Update FCEA tab label
UPDATE caps.metaphor
set txt_tab = 'IV-E Application/Amended/NOC'
where txt_tab_constant = 'APPLICATION_EVENTLIST'
and id_tab = 65;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (949, 'SacwisRev4', 'Release 4.1 - DBCR 16057');

commit;


