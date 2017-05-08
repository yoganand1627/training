--STGAP00015930 - Release(3.6) MR-66: Update facil name-type message on intake

update caps.message set TXT_MESSAGE = 'You must enter a Placement Provider Name before performing a search'
where TXT_MESSAGE_NAME = 'MSG_FACILITY_SEARCH';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (847, 'SacwisRev3', 'Release 3.6 - DBCR 15930');

commit;


