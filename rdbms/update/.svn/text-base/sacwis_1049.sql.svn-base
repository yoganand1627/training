--STGAP00016191 - Release(4.3) CAPTA4.3: update Provider Allegation Hist message

-- SMS#112297 for CAPTA 4.3: update with the period added at the end of the message per system test finding.
update caps.message
set txt_message = 'No Intake or Investigation records were found for the Provider.'
where txt_message_name = 'MSG_NO_PROV_ALLEG_HISTORY';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1050, 'SacwisRev4', 'Release 4.3 - DBCR 16191');

commit;


