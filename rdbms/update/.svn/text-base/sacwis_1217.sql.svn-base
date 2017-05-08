--STGAP00018087 - Release(5.1) MSG_REL_SUB_LEG_STAT_REQ: Message has many typos

--The original message has multiple typos.  This query is to just to correct the spellings and structure.

update caps.message
set txt_message = 'Legal status must be updated to Not in DFCS Custody - Custody to Relative or Not in DFCS Custody - Guardianship to enter a Relative Care Subsidy or a Subsidized Guardianship payment of care.'
where txt_message_name = 'MSG_REL_SUB_LEG_STAT_REQ';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1218, 'SacwisRev5', 'Release 5.1 - DBCR 18087');

commit;
