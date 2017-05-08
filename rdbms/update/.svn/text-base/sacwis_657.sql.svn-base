--STGAP00015666 - Release(3.41) Update CAPS.NCANDS/AFCARS_ELEMENT_HELP

--On the CAPS.NCANDS/AFCARS_ELEMENT_HELP Table, there are some fields that have misspellings.  So this SQL will update some of the misspelling on the Help Table.

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>County of Residence</b><br>NCANDS selects the county code of the childs primary address most recent prior to the investigation conclusion.'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_CNTY';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Visually or Hearing Impaired - Child</b><br>If person characteristics of Hearing Impaired - Diagnosed or Visually Impaired. Diagnosed were entered for the child prior to Investigation closure the value for this element is yes, otherwise the value is no.'
WHERE TXT_NCANDS_ELEMENT = 'CDVISUAL';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Other Medical Condition - Caretaker(s)</b><br>If for any caretaker a person characteristic of "Other medical condition that significantly affects ability to provide suitable child care environment " was entered prior to Investigation closure NCANDS reports yes for this factor, otherwise the reported value is no.'
WHERE TXT_NCANDS_ELEMENT = 'FCMEDICL';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 1st Principal Caretaker:</b><br>The first primary caretaker is identified using the following logic: <br><br>First - Any principal person in the stage where the most recent removal was recorded with a relationship of Primary Caretaker and identified on the Custody page as a part of the removal event as a member of the home of removal. <br><br>Second - Any principal person in the current foster care stage (most recent FCC) with a relationship (in order of preference) of Legal Mother, Legal Father, Biological Mother, Biological Father, Putative Mother, Putative Father, Parent, Absent Parent, Step Parent, Guardian, Grandparent. <br><br>Third - Any principal person in the stage where the most recent removal was recorded with a relationship of Primary Caretaker but not tied to the removal event on Custody as member of home of removal. <br><br>Fourth - Any principal person in the current foster care stage (most recent FCC) with a relationship (in order of preference) of Aunt/Uncle, Other Family Member, Unrel. Home Mem, Self/Minor Parent.<br><br>When the child has both an active FCC and ADO stage, the relationships are used from the open Foster Care Child stage.  If an FCC stage is not open, the relationships come from the ADO stage.'
WHERE TXT_AFCARS_ELEMENT = 'YOB_1ST_PRIN_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Number of Previous Placement Settings During This Episode:</b><br>This is populated with a count of placement events which have occurred since the most recent removal.  New placement events are counted as moves so long as: <br><br>1) The placement is an actual, as opposed to attempted, placement and not of type respite, concurrent, parental, or runaway<br><br>2) The placement does not fall within the set of placement moves not counted for AFCARS purposes such as returning to the preceding foster placement when leaving a hospital setting.<br><br>For cases predating SHINES go live the count of moves occurring before SHINES comes directly from converted data sources.'
WHERE TXT_AFCARS_ELEMENT = 'NUMBER_PLACEMENT_SETTINGS';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (658, 'SacwisRev3', 'Release 3.41 - DBCR 15666');

commit;



