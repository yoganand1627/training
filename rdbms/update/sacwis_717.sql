--STGAP00015746 - Release(3.5) per CAPTA - update message "MSG_CASA_GAL_EXISTS"

--Per CAPTA -  we need to change the txt_message to remove "" from the message and change the value to GAL for the following nbr_message--

UPDATE caps.message m
SET m.TXT_MESSAGE = 'A CASA or Atty/GAL has been entered on the Person List with an active assignment at the time of this Legal Action.  Please deselect the No representation (CASA or Atty/GAL) appointed checkbox, or if necessary enter a date unassigned for the existing CASA or Atty/GAL in the Person Detail.'
WHERE m.NBR_MESSAGE = 60649;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (718, 'SacwisRev3', 'Release 3.5 - DBCR 15746');

commit;

