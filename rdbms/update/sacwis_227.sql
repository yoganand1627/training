-- change STGAP00004496
-- We need three new records added to the codes table in order to resolve defect STGAP00004111 

insert into caps.Codes_Tables values('CFATRAIN','PSV1','Pre-Service Week 1',NULL,sysdate);
insert into caps.Codes_Tables values('CFATRAIN','PSV2','Pre-Service Week 2',NULL,sysdate);
insert into caps.Codes_Tables values('CFATRAIN','PSV3','Pre-Service Week 3',NULL,sysdate);

-- We will also need to update the existing PRSV Codes decode field to read ' Pre-Cert Pre-Service'

update caps.codes_tables
set decode = 'Pre-Cert Pre-Service'
where code = 'PRSV'
and code_type = 'CFATRAIN';

-- change STGAP00004536
UPDATE CAPS.FCE_IVE_INCOME_LIMIT SET AMT_GROSS_INCOME_CEILING=810.30,AMT_STANDARD_OF_NEED=438 WHERE ID_FCE_IVE_INCOME_LIMIT IN (1,2,3,4,5,6) AND NBR_AGE IN (0,1,2,3,4,5);
UPDATE CAPS.FCE_IVE_INCOME_LIMIT SET AMT_GROSS_INCOME_CEILING=915.75,AMT_STANDARD_OF_NEED=495 WHERE ID_FCE_IVE_INCOME_LIMIT IN (7,8,9,10,11,12,13) AND NBR_AGE IN (6,7,8,9,10,11,12);
UPDATE CAPS.FCE_IVE_INCOME_LIMIT SET AMT_GROSS_INCOME_CEILING=1043.40,AMT_STANDARD_OF_NEED=564 WHERE ID_FCE_IVE_INCOME_LIMIT IN (14) AND NBR_AGE IN (13);

-- change STGAP00004547
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'The region MES Program Assistant not located. Please contact your supervisor.' 
where TXT_MESSAGE_NAME = 'MSG_FCE_MES_PROG_ASST_NOT_FND';

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Remove the person(s) with SSI income from the Assistance Unit.' 
where TXT_MESSAGE_NAME = 'MSG_SSI_APPLICANT';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (228, 'SacwisRev2', 'static updates');                        
commit;
