--STGAP00017983 - Release(5.1) STGAP00017983 - DBCR for STGAP00014615

--STGAP00017983
--Attempting to add a custody event for a child already in foster care leads to the following incorrect message: "This child is already in Foster Care Child."

--Should read either "This child is already in Foster Care."  or "This child is already a Foster Care Child."




--DBCR:

Update caps.message
set txt_message = 'This child is already in Foster Care.'
where id_message = 16130
and nbr_message = 8069
and txt_message_name = 'MSG_SUB_SUBC_STAGE_EXISTS';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1210, 'SacwisRev5', 'Release 5.1 - DBCR 17983');

commit;
