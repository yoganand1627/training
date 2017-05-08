--STGAP00016127 - Release(4.2) MR-075 Update messages.

-- MR-075 Update messages.

UPDATE caps.message
set txt_message = 'Medicals are not current. Update documentation or select a home status of ''Pre-Service Training''  for Initial Homes or ''30 Day Grace'' for Homes that have been previously approved.'
where txt_message_name = 'MSG_FAD_MEDICAL_NOT_CURRENT';

UPDATE caps.message
set txt_message = 'GCIC or NCIC Records Checks are not current. Update documentation or select a home status of ''Pre-Service Training'' for Initial Homes or ''30 Day Grace'' for Homes that have been previously approved.'
where txt_message_name = 'MSG_FAD_GCIC_NCIC_NOT_CURRENT';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1008, 'SacwisRev4', 'Release 4.2 - DBCR 16127');

commit;

