--STGAP00015695 - Release(3.41) Update Case Factor Help Text

--Update help text. 

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Special Investigation Resource ID:</b><br>Special investigation are recorded.by selecting the Special Investigation Call Type and update the Placement Provider Section on the Intake Information page...The Placement Provider section is used for associating a resource to the intake.  The case manager will enter in the Resource Name, and select the type from a drop down.  They will click the Search button, and be presented with the Resource Search Results List to choose possible resources.  Once they select a resource and click continue they are returned to the Intake Information page with the available information. '
WHERE TXT_CASE_WATCH_FACTOR = 'INV_SPEC_INV_RSRC_HELP';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (677, 'SacwisRev3', 'Release 3.41 - DBCR 15695');

commit;

