-- change STGAP00002863
UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'Warning - At least one allegation must reference each principal identified as an alleged maltreator or alleged victim.' WHERE nbr_message = 3069;

-- change STGAP00002870
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='You indicated the child is covered by health insurance other than Medicaid.  Please select the child in the ''Principals Covered by Health Insurance Policy'' list.' WHERE NBR_MESSAGE='60125';
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='You indicated the child is covered by health insurance other than Medicaid.  Please acknowledge the Authorization statements in the ''Authorization'' section.' WHERE NBR_MESSAGE='60126';

-- change STGAP00002896
UPDATE CAPS.CODES_TABLES
SET DECODE = 'V'
WHERE
CODE_TYPE = 'CLSRU'
AND
CODE IN ('PVL','TVL');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (179, 'SacwisRev2', 'static updates');                         
commit;
