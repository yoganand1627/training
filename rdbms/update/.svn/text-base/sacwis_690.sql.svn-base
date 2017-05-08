--STGAP00015716 - Release(3.5) Per CAPTA - insert new messages for legal action

Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60648,
   'MSG_NO_CASA_GAL',
   'No CASA or Atty/Gua Ad Litem has been entered on the stage Person List with an active assignment at the time of this Legal Action.  Please select the "No representation (CASA or Atty/Gua Ad Litem) Appointed" checkbox below, or add or update the appropriate representation information through Persons.', 700, 500, 'N');


Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60649,
   'MSG_CASA_GAL_EXISTS',
  'A CASA or Atty/Gua Ad Litem has been entered on the Person List with an active assignment at the time of this Legal Action.  Please deselect the "No representation (CASA or Atty/Gua Ad Litem) appointed" checkbox, or if necessary enter a date unassigned for the existing CASA or Atty/Gua Ad Litem in the Person List.', 700, 500, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (691, 'SacwisRev3', 'Release 3.5 - DBCR 15716');

commit;

