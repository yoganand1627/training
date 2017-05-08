--STGAP00015757 - Release(3.5) CAPTA: Update messages

UPDATE caps.message m
SET m.TXT_MESSAGE = 'When adding a person with a relationship of CASA or Atty/GAL the Date Representation Assigned is required.'
WHERE m.NBR_MESSAGE = 60644;


UPDATE caps.message m
SET m.TXT_MESSAGE = 'Persons with relationships of CASA or Atty/GAL should not be deleted from the case file.  If the current representative has been reassigned, please update the Date Unassigned to indicate the end of the relationship, and add the child''s new representation to the Person List.'
WHERE m.NBR_MESSAGE = 60645;

UPDATE caps.message m
SET m.TXT_MESSAGE = 'Date assigned or unassigned may only be used for relationships of CASA or Atty/GAL'
WHERE m.NBR_MESSAGE = 60647;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (724, 'SacwisRev3', 'Release 3.5 - DBCR 15757');

commit;

