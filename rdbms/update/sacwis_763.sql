--STGAP00015810 - Release(3.5) Per CAPTA: update messages for Person Detail

UPDATE caps.message m
SET m.TXT_MESSAGE = 'When adding a person with a relationship of CASA or GAL Atty or GAL Non-Atty Date Representation Assigned is required.'
WHERE m.NBR_MESSAGE = 60644;


UPDATE caps.message m
SET m.TXT_MESSAGE = 'Date assigned or unassigned may only be used for relationships of CASA or GAL Atty or GAL Non-Atty'
WHERE m.NBR_MESSAGE = 60647;


UPDATE caps.message m
SET m.TXT_MESSAGE = 'Persons with relationships of CASA  or GAL Atty or GAL Non-Atty should not be deleted from the case file.  If the current representative has been reassigned, please update the Date Unassigned to indicate the end of the relationship, and add the child''s new representation to the Person List.'
WHERE m.NBR_MESSAGE = 60645;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (764, 'SacwisRev3', 'Release 3.5 - DBCR 15810');

commit;

