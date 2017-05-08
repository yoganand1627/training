--STGAP00015933 - Release(3.6) MR-66: update error message for intake save submit

update caps.message set txt_message = 'The system has determined a Maltreatment in care situation based on an Allegation''s  Alledged Incident Date and a child''s ''In DFCS Care'' Legal Status. Selection for the Special Investigation Call Type and Placement/Non-Placement Provider are required.' where txt_message_name = 'MSG_INT_SPCL_INV_PLACEMENT_REQ';

update caps.message set txt_message = 'It is indicated that this is a special investigation on a Placement/Non-Placement provider. A selection for Placement/Non-Placement Provider is required.' where txt_message_name = 'MSG_INV_PLACEMENT_REQ';

update caps.message set txt_message = 'The system has determined a Maltreatment in care situation based on an Allegation''s  Alledged Incident Date and a child''s ''In DFCS Care'' Legal Status. Selection for the Special Investigation Call Type is required.' where txt_message_name = 'MSG_INT_SPCL_INV_REQ';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (849, 'SacwisRev3', 'Release 3.6 - DBCR 15933');

commit;


