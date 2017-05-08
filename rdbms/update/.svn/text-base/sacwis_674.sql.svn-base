--STGAP00015692 - Release(3.41) DBCR: Case Watch Text Updates

-- The attached SQL updates help text and a warning next for Case Watch.


UPDATE CAPS.CODES_TABLES SET DECODE = 'One or more principals on the current family plan have not been contacted face to face this month.  (Note: If no family plan has been entered in the case this warning will display for all principals.)'
WHERE CODE_TYPE = 'CCASEWAR' AND CODE = 'PCN';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_SOURCE_TEXT = '<a href="javascript:caseWatchNavigation(''navPersonDetail'')">Person Detail</a>',
TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 2nd Principal Caretaker:</b><br>The second principal caretaker is identified based on the person chosen as the secondary caretaker in the other relationships section on the child''s Person Detail record.  In addition, the person must have been chosen as a person in the home at the time of removal.' 
WHERE TXT_AFCARS_ELEMENT_SHORT = 'AFCARS_FC_46';

insert into caps.schema_version (id_schema_version,application_version,comments)
            values (675, 'SacwisRev3', 'Release 3.41 - DBCR 15692');

commit;