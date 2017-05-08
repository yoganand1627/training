--STGAP00015519 - MR-056: Update Messgs for Unknown

update caps.message set TXT_MESSAGE = 'A %s can not be added because ''Unknown'' has been selected for Member of Primary Caretaker''s Household on Person Detail for: %s'
where TXT_MESSAGE_NAME = 'MSG_UNKNOWN_MBR_HH_NO_ADD';

update caps.message set TXT_MESSAGE = '''Unknown'' is selected for Member of Primary Caretaker''s household on Person Detail for:\n %s'
where TXT_MESSAGE_NAME = 'MSG_INV_MBR_HH_UNKNOWN';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (571, 'SacwisRev3', 'Release 3.3 - DBCR 15519');

commit;

