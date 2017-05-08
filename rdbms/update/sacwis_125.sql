-- change 329
insert into caps.codes_tables  (code_type,code,decode)values('CDIVDSPN','NFI','Close - No Further Involvement'); 
insert into caps.codes_tables  (code_type,code,decode)values('CDIVDSPN','RFS','Close - Refer for Services'); 
insert into caps.codes_tables  (code_type,code,decode)values('CDIVDSPN','RFI','Close - Refer for Investigation'); 
insert into caps.codes_tables  (code_type,code,decode)values('CDIVDSPN','TRS','Close - Transfer'); 

-- change 331
UPDATE CAPS.METAPHOR 
SET TXT_TAB_URL='/subcare/ChildPlan/displayFccpChild' 
WHERE TXT_TAB='Child Plan';

-- change 337
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('OTH','199','Expectant Father',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CCT','24','Inadequate Housing',SYSDATE);

-- change 338
UPDATE CAPS.CODES_TABLES SET DECODE = 'Adoption Dissolution' WHERE 
code_type = 'OTH' AND code = '81';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Allergies' WHERE 
code_type = 'CPM' AND code = '106';

-- change 344
UPDATE CAPS.CODES_TABLES 
SET DECODE='Delivered Service' 
WHERE code_type='CINVSRTP' 
AND code='DUR'; 
UPDATE CAPS.CODES_TABLES 
SET DT_END=TO_DATE('01/01/2007', 'MM/DD/YYYY') 
WHERE code_type='CINVSRTP' 
AND code='DSB'; 
UPDATE CAPS.CODES_TABLES 
SET DT_END=TO_DATE('01/01/2007', 'MM/DD/YYYY') 
WHERE code_type='CINVSRTP' 
AND code='DCR'; 
UPDATE CAPS.CODES_TABLES 
SET DECODE='Delivered Service' 
WHERE code_type='CINVTYPE' 
AND code='DUR'; 
UPDATE CAPS.CODES_TABLES 
SET DT_END=TO_DATE('01/01/2007', 'MM/DD/YYYY') 
WHERE code_type='CINVTYPE' 
AND code='DSB'; 
UPDATE CAPS.CODES_TABLES 
SET DT_END=TO_DATE('01/01/2007', 'MM/DD/YYYY') 
WHERE code_type='CINVTYPE' 
AND code='DCR';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (126, 'SacwisRev2', 'static updates');
                         
commit;
