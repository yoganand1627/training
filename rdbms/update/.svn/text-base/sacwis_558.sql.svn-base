--STGAP00015475 - Update CREMCHCT UNA for Unable to Cope

--Please update the decode value from the CREMCHCT code type.  The decode value with the corresponding code value of UNA should be changed from 'Unable to cope' to 'Caretaker's Inability to Cope Due to Illness or Other Reason'.

--This revised decode label is the exact language used in the AFCARS FC file for reporting and is a more appropriate choice of words for documentation of voluntary placements.

update caps.codes_tables set decode='Caretaker''s Inability to Cope Due to Illness or Other Reason' where code_type='CREMCHCT' and code='UNA';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (559, 'SacwisRev3', 'Release 3.3 - DBCR 15475');

commit;

