--STGAP00015811 - Release(3.5) per CAPTA - updare messages for Legal Actions

UPDATE caps.message m
SET m.TXT_MESSAGE = 'No CASA or GAL Atty or GAL Non-Atty  has been entered on the stage Person Detail with an active assignment at the time of this Legal Action.  Please select the No representation (CASA or GAL Atty or GAL Non-Atty) assigned checkbox below, or add or update the appropriate representation information through Persons.'
WHERE m.NBR_MESSAGE = 60648;

UPDATE caps.message m
SET m.TXT_MESSAGE = 'A CASA or GAL Atty or GAL Non-Atty  has been entered on the Person Detail with an active assignment at the time of this Legal Action.  Please deselect the No representation (CASA or GAL-Atty or GAL-Non-Atty ) assigned checkbox, or if necessary enter a date unassigned for the existing CASA or GAL Atty or GAL Non-Atty in the Person Detail.'
WHERE m.NBR_MESSAGE = 60649;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (765, 'SacwisRev3', 'Release 3.5 - DBCR 15811');

commit;

