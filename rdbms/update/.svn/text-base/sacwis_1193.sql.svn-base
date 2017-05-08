--STGAP00017860 - Release(5.1) MR-097- Update message for MSG_INV_PLACEMENT_REQ

-- MR-097 Unsubstantiated MIC
--  Clearquest Number - STGAP00017829

update caps.message set txt_message='It is indicated that this is a special investigation on a Placement/Non-Placement Provider.  A selection for Placement/Non-Placement Provider information section is required.' where txt_message_name='MSG_INV_PLACEMENT_REQ';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1194, 'SacwisRev5', 'Release 5.1 - DBCR 17860');

--commit;

