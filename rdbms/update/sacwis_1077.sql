--STGAP00017048 - Release(5.0) Updating Task to include the copy functionality

--// Updating two task to allow Coping from the event list for Permanency Roundtable(Output Launch)

Update CAPS.TASK SET IND_TASK_NEW_USING = 1 where
cd_task_event_type = 'PER';

--// Updating Column name to allow the forms architecture to save information.  Table is new so there is no // data in the columns

alter table
   caps.PERM_ROUNDTABLE_NARR
rename column ID_DOCUMENT_TABLE
TO
   ID_DOCUMENT_TEMPLATE;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1078, 'SacwisRev5', 'Release 5.0 - DBCR 17048');

commit;
