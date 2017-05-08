--STGAP00015669 - Release(3.41) Update CAPS.NCANDS_ELEMENT_HELP

--Update elements on the CAPS.NCANDS_ELEMENT_HELP Table.

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Maltreatment-3 Type</b><br>See definitions for maltreatment 1 above.<br>This field is blank for non-victims and children without a third maltreatment type'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_MAL_3';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Maltreatment-4 Type</b><br>See definitions for maltreatment 1 above.<br>This field is blank for non-victims and children without a fourth maltreatment type'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_MAL_4';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Maltreatment-1 Disposition Level</b><br>If the allegation is Substantiated, NCANDS reports Substantiated, if Unsubstantiated reports Unsubstantiated, and for Unable to Determine reports Closed No Finding.  For children being reported as household members where there are no allegations NCANDS reports No Alleged Maltreatment.'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_MALDISP_1';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Maltreatment-2 Disposition Level</b><br>If the allegation is Substantiated, NCANDS reports Substantiated, if Unsubstantiated reports Unsubstantiated, and for Unable to Determine reports Closed No Finding.  This field is blank for non-victims and children without a further on maltreatment type.'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_MALDISP_2';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Maltreatment-3 Disposition Level</b><br>If the allegation is Substantiated, NCANDS reports Substantiated, if Unsubstantiated reports Unsubstantiated, and for Unable to Determine reports Closed No Finding.  This field is blank for non-victims and children without a further on maltreatment type.'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_MALDISP_3';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>Maltreatment-4 Disposition Level</b><br>If the allegation is Substantiated, NCANDS reports Substantiated, if Unsubstantiated reports Unsubstantiated, and for Unable to Determine reports Closed No Finding.  This field is blank for non-victims and children without a further on maltreatment type.'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_MALDISP_4';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (659, 'SacwisRev3', 'Release 3.41 - DBCR 15669');

commit;



