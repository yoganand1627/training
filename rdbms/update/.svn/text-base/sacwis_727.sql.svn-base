--STGAP00015764 - Release(3.5) Message got into two lines causing Javascript Err

-- Please make sure the TXT_MESSAGE is in one line.
UPDATE CAPS.MESSAGE SET TXT_MESSAGE ='The selected parameters would return over 65000 rows.  Please narrow the report criteria.'
Where NBR_MESSAGE = 60664;

UPDATE CAPS.MESSAGE SET TXT_MESSAGE ='Errors Only must be selected when performing an error activity search using From and To Dates.'
Where NBR_MESSAGE = 60661;

UPDATE CAPS.MESSAGE SET TXT_MESSAGE ='All must be selected for Open/Closed Stages when performing an error activity search using From and To Dates.'
Where NBR_MESSAGE = 60662;

UPDATE CAPS.MESSAGE SET TXT_MESSAGE ='Error Active From and To Dates must be selected when searching All Open and Closed Stages.'
Where NBR_MESSAGE = 60663;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (728, 'SacwisRev3', 'Release 3.5 - DBCR 15764');

commit;

