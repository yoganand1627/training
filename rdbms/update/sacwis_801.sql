--STGAP00015867 - Release(3.43) MR-62: Update message MSG_CS_STDS_NOT_MET

update caps.message set TXT_MESSAGE = 'Parent Contact rules have not been completed for all children. Please review Parent Contact Rules Summary and add any missing Mother or Father or Caretaker.'
where TXT_MESSAGE_NAME = 'MSG_CS_STDS_NOT_MET';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (802, 'SacwisRev3', 'Release 3.43 - DBCR 15867');

commit;
