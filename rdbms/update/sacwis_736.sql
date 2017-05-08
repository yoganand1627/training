--STGAP00015777 - Release(3.5) Per STGAP00015776: update messages for Legal Actio

--Per STGAP00015776-  we need to change the txt_message to change Person List to Person Detail--

--Message 1:

UPDATE caps.message m
SET m.TXT_MESSAGE = 'No CASA or Atty/ GAL has been entered on the stage Person Detail with an active assignment at the time of this Legal Action.  Please select the No representation (CASA or Atty/ GAL) assigned checkbox below, or add or update the appropriate representation information through Persons.'
WHERE m.NBR_MESSAGE = 60648;

--Message 2:

UPDATE caps.message m
SET m.TXT_MESSAGE = 'A CASA or Atty/ GAL has been entered on the Person Detail with an active assignment at the time of this Legal Action.  Please deselect the No representation (CASA or Atty/ GAL) assigned checkbox, or if necessary enter a date unassigned for the existing CASA or Atty/ GAL in the Person Detail.'
WHERE m.NBR_MESSAGE = 60649;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (737, 'SacwisRev3', 'Release 3.5 - DBCR 15777');


commit;
 
