--STGAP00015745 - Release(3.5) CAPTA: Update message "MSG_NO_CASA_GAL"

--Per CAPTA -  we need to change the txt_message to remove "" from the message and change the value to GAL for the following nbr_message--

UPDATE caps.message m
SET m.TXT_MESSAGE = 'No CASA or Atty/GAL has been entered on the stage Person List with an active assignment at the time of this Legal Action.  Please select the No representation (CASA or Atty/GAL) Appointed checkbox below, or add or update the appropriate representation information through Persons.'
WHERE m.NBR_MESSAGE = 60648;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (717, 'SacwisRev3', 'Release 3.5 - DBCR 15745');

commit;

