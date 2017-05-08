
-- change 89
UPDATE CAPS.CODES_TABLES 
SET DT_END = TO_DATE(SYSDATE, 'MM/DD/YYYY') 
WHERE CODE_TYPE = 'CDISPSTN' 
AND CODE = 'CRC'  
AND DT_END IS NULL;

-- change 90
UPDATE CAPS.CODES_TABLES 
SET CODE = 'UNS' 
WHERE CODE_TYPE = 'CDISPSTN' 
AND CODE = 'UNSUB' 
AND DT_END IS NULL; 

UPDATE CAPS.CODES_TABLES 
SET CODE = 'SUB' 
WHERE CODE_TYPE = 'CDISPSTN' 
AND DECODE = 'Substantiated' 
AND DT_END IS NULL;

-- change 91
UPDATE CAPS.CODES_TABLES 
SET DT_END=null 
WHERE code_type='CLEGCPS' 
AND code='HRG';

-- change 92
INSERT INTO CAPS.MESSAGE 
(nbr_message, txt_message_name, 
txt_message, 
CD_SOURCE, 
CD_PRESENTATION, 
IND_BATCH) 
VALUES 
(60052, 
'MSG_HR_TYP_CRT_ORD_REQ', 
'A Hearing Type/Court Order is required for Receive Court Order or Hearing legal actions.', 
700, 
500, 
'N');

-- change 93
update caps.codes_tables set code = '3A' where code = '03A' and CODE_TYPE = 'CREGIONS';
update caps.codes_tables set code = '3B' where code = '03B' and CODE_TYPE = 'CREGIONS';

-- change 96
UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='010' ; 

UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='020'; 

UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='030'; 

UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='040'; 

UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='050'; 

UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='070'; 

UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='080'; 

UPDATE CAPS.CODES_TABLES 
SET DT_END='01/01/2006' 
WHERE code_type='CLEGSTAT' 
AND CODE='090'; 

-- change 97
insert into caps.codes_tables (code_type, code, decode) values('CRELPRN2', 'DR', 'Doctor');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (25, 'SacwisRev1', 'static updates');
commit;
