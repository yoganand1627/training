--STGAP00015916 - Release(3.6) MR-66: Update Custody  Message

--Updates on 6/04/2010
update caps.message set txt_message = 'The Removal Date is earlier than the Alleged Incident Date. This indicates a Maltreatment in Care situation. Please verify the dates are correct.' where txt_message_name = 'MSG_SUB_REM_DATE_WARN';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (839, 'SacwisRev3', 'Release 3.6 - DBCR 15916');

commit;


