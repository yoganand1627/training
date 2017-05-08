--STGAP00015713 - Release(3.5) Per CAPTA - insert new messages for Person Detail

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60644,
   'MSG_CASA_GAL_ASSIGN_DATE_REQ',
   'When adding a person with a relationship of CASA or Atty/Gua Ad Litem the Date Representation Assigned is required.', 700, 500, 'N');


Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60645,
   'MSG_CASA_GAL_ASSIGN_DATE_DELETE',
   'Persons with relationships of CASA or Atty/Gua Ad Litem should not be deleted from the case file.  If the current representative has been reassigned, please update the Date Unassigned to indicate the end of the relationship, and add the child''s new representation to the Person List.', 700, 500,
'N');


Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60646,
   'MSG_CASA_GAL_DATE_ASSIGNED_UNASSIGNED',
   'Date Unassigned should be greater than or equal to Date Representation Assigned.', 700, 500, 'N');


Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60647,
   'MSG_CASA_GAL_INC_DATES',
   'Date assigned or unassigned may only be used for relationships of CASA or Atty/Gua. Ad Litem', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (689, 'SacwisRev3', 'Release 3.5 - DBCR 15713');

commit;

