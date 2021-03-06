-- change STGAP00004700
--these are no longer used now that RBWO is in place

update caps.codes_tables
set dt_end = sysdate
where code_type = 'CPOCTYPE'
and code in ('A3','L1','L2','L3','L4','L5','L6');

-- change STGAP00004734
-- Code is TOS but design document lists code is supposed to be 97. There is an error when trying to
-- save a code of TOS because it tries to save into a field that is only 2 bytes.

update caps.codes_tables set code='97' where code_type='CREGIONS' AND code='TOS';

-- change STGAP00004761
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57404','57404 - Initial Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57405','57405 - Annual Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57417','57417 - Supplemental Supervision',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57504','57504 - Initial Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57505','57505 - Annual Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57517','57517 - Supplemental Supervision',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57704','57704 - Initial Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57705','57705 - Annual Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57708','57708 - In-Hospital Care',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57717','57717 - Supplemental Supervision',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57904','57904 - Initial Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57905','57905 - Annual Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57908','57908 - In-Hospital Care',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57911','57911 - Child Restraint Devices',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CADDONLI','57917','57917 - Supplemental Supervision',SYSDATE);

-- change STGAP00004763
UPDATE  CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE CODE_TYPE IN('CGLSVCCD','CATOFSVC') AND CODE LIKE '06%';  

UPDATE  CAPS.CODES_TABLES SET CODE='1212',DT_END = NULL WHERE CODE_TYPE = 'CGLSVCCD' AND CODE LIKE '0605'
AND DECODE ='Relative Care Homes';  

UPDATE  CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE CODE_TYPE = 'CGLSVCCD' AND CODE LIKE '0102'
AND DECODE ='DFCS Adoption Homes'; 

UPDATE  CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE CODE_TYPE = 'CGLSVCCD' AND CODE LIKE '0104'
AND DECODE ='Non-DFCS Adoption Homes'; 

UPDATE  CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE CODE_TYPE = 'CGLSVCCD' AND CODE LIKE '0103'
AND DECODE ='DFCS Foster/Adoptive Homes';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (233, 'SacwisRev2', 'static updates');                        
commit;
