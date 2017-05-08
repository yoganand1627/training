--STGAP00015671 - Release(3.41) Update CAPS.NCANDS/AFCARS_ELEMENT_HELP - Help Text

--Update elements on the CAPS.NCANDS_ELEMENT_HELP & CAPS.AFCARS_ELEMENT_HELP Tables.

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Has the Child Been Diagnosed with any Other Medical Condition:</b><br>This is indicated when one or more of the following person characteristics was selected for the child in care at the time of report generation:<br><br>Infant Alcohol Addiction, Infant Drug Addiction/Prenatal Drug Exposed, Cognitive Disorder, Intellectual Disability, Learning Disability, Speech Disability, Abnormal Bowel Movement Behavior, AIDS, Asperger''s Disorder, Asthma, Cancer, Diabetes, Eczema, Epilepsy, Hepatitis, HIV Positive, Other Medically Diagnosed, Rheumatic Fever, Heart Disease, Heart Murmur, Allergies, Sexual Transmitted Disease, Sickle Cell Anemia, Terminal Illness, Traumatic Brain Injury, or Tuberculosis.'
WHERE TXT_AFCARS_ELEMENT = 'OTHER_DIAGNOSED_CONDITION';

UPDATE CAPS.NCANDS_ELEMENT_HELP 
SET TXT_NCANDS_ELEMENT_HELP_TEXT = '<b>County of Residence</b><br>NCANDS selects the county code of the child''s primary address most recent prior to the investigation conclusion.'
WHERE TXT_NCANDS_ELEMENT = 'CHILD_CNTY';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (661, 'SacwisRev3', 'Release 3.41 - DBCR 15671');

commit;


