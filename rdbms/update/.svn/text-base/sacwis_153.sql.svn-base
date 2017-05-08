
-- Standard Alter Table SQL

ALTER TABLE CAPS.CASE_BUDGET_LIMIT MODIFY(CD_SVC_CODE  VARCHAR2(6))
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00001931
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CINVTYPE', 'EDS', 'Emergency Payment - Delivered Service', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CINVTYPE', 'EFC', 'Emergency Payment - Foster Care', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CINVTYPE', 'EAA', 'Emergency Payment - Adoption Assistance', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CINVTYPE', 'EAD', 'Emergency Payment - Administrative', SYSDATE);

-- change STGAP00001932
-- This fixes the region to county mappings for the new 17 regions.  this was created based of a pdf file sent on 4/9/2007.
-- first make all the decodes 2 characters instead of 3 characters.  keep the right most two characters.

update caps.codes_tables set decode = SUBSTR(decode, -2, 2) where code_type = 'CCNTYREG';

update caps.codes_tables set decode = '03' where code_type = 'CCNTYREG' and code = '015';
update caps.codes_tables set decode = '17' where code_type = 'CCNTYREG' and code = '057';
update caps.codes_tables set decode = '16' where code_type = 'CCNTYREG' and code = '063';
update caps.codes_tables set decode = '17' where code_type = 'CCNTYREG' and code = '067';
update caps.codes_tables set decode = '14' where code_type = 'CCNTYREG' and code = '089';
update caps.codes_tables set decode = '17' where code_type = 'CCNTYREG' and code = '097';
update caps.codes_tables set decode = '16' where code_type = 'CCNTYREG' and code = '113';
update caps.codes_tables set decode = '03' where code_type = 'CCNTYREG' and code = '115';
update caps.codes_tables set decode = '13' where code_type = 'CCNTYREG' and code = '121';
update caps.codes_tables set decode = '03' where code_type = 'CCNTYREG' and code = '129';
update caps.codes_tables set decode = '15' where code_type = 'CCNTYREG' and code = '135';
update caps.codes_tables set decode = '03' where code_type = 'CCNTYREG' and code = '143';
update caps.codes_tables set decode = '16' where code_type = 'CCNTYREG' and code = '151';
update caps.codes_tables set decode = '03' where code_type = 'CCNTYREG' and code = '223';
update caps.codes_tables set decode = '03' where code_type = 'CCNTYREG' and code = '233';
update caps.codes_tables set decode = '15' where code_type = 'CCNTYREG' and code = '247';

-- change STGAP00001933
UPDATE caps.codes_tables  SET  CODE_TYPE ='CMALCODE'  WHERE  CODE_TYPE ='CMLTTYP';
update caps.codes_tables set DECODE = 'Munchausen''s' where code = 'P11' and code_type = 'CMALCODE';

-- change STGAP00001936
UPDATE CAPS.CODES_TABLES SET DECODE = 'Associate''s Degree'
WHERE CODE_TYPE = 'CHIGHEDU'
AND CODE = 'AD';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Bachelor''s Degree'
WHERE CODE_TYPE = 'CHIGHEDU'
AND CODE = 'BD';

-- change STGAP00001941
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '010' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '020' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '030' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '040' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '050' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '060' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '070' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '080' AND CODE_TYPE = 'CCLOSPAD';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '010' AND CODE_TYPE = 'CCLOSADO';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '020' AND CODE_TYPE = 'CCLOSADO';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '030' AND CODE_TYPE = 'CCLOSADO';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '040' AND CODE_TYPE = 'CCLOSADO';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '050' AND CODE_TYPE = 'CCLOSADO';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = '060' AND CODE_TYPE = 'CCLOSADO';

-- change STGAP00001944
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60267, 'MSG_INV_MAL_CODE_SUBST'
,'If the Maltreatment Code is O1, the Disposition must be Unsubstantiated',760,500,'N');

-- change STGAP00001939
UPDATE CAPS.CODES_TABLES SET DECODE = 'With Non Related Person (not boarding)'
WHERE CODE = 'NON' AND CODE_TYPE = 'CLIVARR';

-- UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
-- WHERE CODE = 'ADU' AND CODE_TYPE = 'CLIVARR';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = 'HLS' AND CODE_TYPE = 'CLIVARR';

-- UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
-- WHERE CODE = 'MAT' AND CODE_TYPE = 'CLIVARR';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = 'UNK' AND CODE_TYPE = 'CLIVARR';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Judaism'
WHERE CODE = 'CJ' AND CODE_TYPE = 'CRELIGNS';

UPDATE CAPS.CODES_TABLES SET DT_END = null
WHERE CODE = 'JW' AND CODE_TYPE = 'CRELIGNS';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRELIGNS', 'MU', 'Muslim');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRELIGNS', 'BU', 'Buddhist');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRELIGNS', 'HU', 'Hindu');

UPDATE CAPS.CODES_TABLES SET DECODE = 'Abuse/Neglect - In open case'
WHERE CODE = 'ABN' AND CODE_TYPE = 'CRSNFDTH';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Abuse/Neglect - In closed case'
WHERE CODE = 'ABO' AND CODE_TYPE = 'CRSNFDTH';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Abuse/Neglect - No prior case'
WHERE CODE = 'ABP' AND CODE_TYPE = 'CRSNFDTH';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = 'NAB' AND CODE_TYPE = 'CRSNFDTH';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'NCE', 'Natural Cause');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'ADH', 'Accidental Death');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'DAR', 'Drug and/or Alcohol Related');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'HOM', 'Homicide');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'SUD', 'Suicide');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'MED', 'Medical');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'DOM', 'Domestic Violence');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRSNFDTH', 'MTY', 'Military Related');

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = 'AA' AND CODE_TYPE = 'CRPTRINT';

UPDATE CAPS.CODES_TABLES SET DT_END = null, DECODE = 'Precond. Adop. Par'
WHERE CODE = 'AP' AND CODE_TYPE = 'CRPTRINT';

UPDATE CAPS.CODES_TABLES SET DECODE = 'First Cousin'
WHERE CODE = 'CO' AND CODE_TYPE = 'CRPTRINT';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'BF', 'Biological Father');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'BM', 'Biological Mother');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'LM', 'Legal Mother');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'LF', 'Legal Father');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'PF', 'Putative Father');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'MP', 'Putative Mother');

UPDATE CAPS.CODES_TABLES SET DECODE = 'Day Care Fac./Prov'
WHERE CODE = 'DC' AND CODE_TYPE = 'CRPTRINT';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Other Family Member'
WHERE CODE = 'FM' AND CODE_TYPE = 'CRPTRINT';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Guidance Counselor'
WHERE CODE = 'GP' AND CODE_TYPE = 'CRPTRINT';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Parole/Probtn Ofcr.'
WHERE CODE = 'PO' AND CODE_TYPE = 'CRPTRINT';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'PM', 'Paramour');

UPDATE CAPS.CODES_TABLES SET DT_END = ''
WHERE CODE = 'PY' AND CODE_TYPE = 'CRPTRINT';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = 'VC' AND CODE_TYPE = 'CRPTRINT';

-- UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
-- WHERE CODE = 'TC' AND CODE_TYPE = 'CRPTRINT';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'FC', 'First Cousin Once Removed');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'GS', 'Step-grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'G2', 'Great Grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'G3', 'Great Great Grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'G4', 'Great Great Great Grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'HS', 'Half Sibling');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'CG', 'Child of Legal Guardian');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'GN', 'Great Niece');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'N2', 'Great Great niece');

UPDATE CAPS.CODES_TABLES SET DECODE = 'Great Nephew'
WHERE CODE = 'GW' AND CODE_TYPE = 'CRPTRINT';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'W2', 'Great Great Nephew');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'NS', 'Non parent spouse');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT', 'SM', 'Self/Minor Parent');

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = 'AA' AND CODE_TYPE = 'CSRCRPTR';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE = 'AM' AND CODE_TYPE = 'CSRCRPTR';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Biological Father', DT_END  = NULL
WHERE CODE = 'BF' AND CODE_TYPE = 'CSRCRPTR';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Biological Mother' , DT_END  = NULL
WHERE CODE = 'BM' AND CODE_TYPE = 'CSRCRPTR';

UPDATE CAPS.CODES_TABLES SET DECODE = 'First Cousin'
WHERE CODE = 'CO' AND CODE_TYPE = 'CSRCRPTR';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'FP', 'Foster Parent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'GR', 'Guidance Counselor');

UPDATE CAPS.CODES_TABLES SET DECODE = 'Legal Father', DT_END  = NULL
WHERE CODE = 'LF' AND CODE_TYPE = 'CSRCRPTR';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Parole/Probtn Ofcr./DJJ Ofcr'
WHERE CODE = 'PO' AND CODE_TYPE = 'CSRCRPTR';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'PM', 'Paramour');

UPDATE CAPS.CODES_TABLES SET DECODE = 'Putative Father'
WHERE CODE = 'PF' AND CODE_TYPE = 'CSRCRPTR';

UPDATE CAPS.CODES_TABLES SET DECODE = 'SAAG'
WHERE CODE = 'AA' AND CODE_TYPE = 'CSRCRPTR';

UPDATE CAPS.CODES_TABLES SET DECODE = 'First Cousin Once Removed'
WHERE CODE = 'FC' AND CODE_TYPE = 'CSRCRPTR';

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'GS', 'Step-grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'G2', 'Great Grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'G3', 'Great Great Grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'G4', 'Great Great Great Grandparent');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'HS', 'Half Sibling');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'CG', 'Child of Legal Guardian');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'GN', 'Great Niece');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'N2', 'Great Great Niece');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'GW', 'Great Nephew');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'W2', 'Great Great Nephew');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'NS', 'Non parent spouse');

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE)
VALUES ('CSRCRPTR', 'SM', 'Self/Minor Parent');

UPDATE CAPS.CODES_TABLES SET CODE = 'JD'
WHERE CODE_TYPE = 'CSRCRPTR' AND DECODE = 'Judge';

UPDATE CAPS.CODES_TABLES SET DECODE = 'View Level of Care Events'
WHERE CODE = 'LOC' AND CODE_TYPE = 'CPERVIEW';

UPDATE CAPS.CODES_TABLES SET DECODE = 'View Removal Events', DT_END = NULL
WHERE CODE = 'REM' AND CODE_TYPE = 'CPERVIEW';

-- change STGAP00001946
UPDATE CAPS.CODES_TABLES SET DECODE = 'Unit Approver'
WHERE CODE = '40' AND CODE_TYPE = 'CUNMBRRL';

-- change STGAP00001949
UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate both an understanding and an ability to support the child''s special needs.' 
WHERE code_type='CSPGOLLD' 
AND code='ATL'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn and demonstrate safe and age-appropriate approaches to control the child''s behavior.' 
WHERE code_type='CSPGOLLD' 
AND code='CBP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate a willingness and ability to protect the child from harm.' 
WHERE code_type='CSPGOLLD' 
AND code='CWC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn to cope with, understand, and manage the child''s behavior.' 
WHERE code_type='CSPGOLLD' 
AND code='MCB'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate an understanding of the child''s limitations.' 
WHERE code_type='CSPGOLLD' 
AND code='RDF'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will identify and address the issues causing the child''s delinquent behavior' 
WHERE code_type='CSPGOLLD' 
AND code='REC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn and apply realistic expectations for the child''s age and development capabilities.' 
WHERE code_type='CSPGOLLD' 
AND code='RLE'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will provide protection and safety for the child.' 
WHERE code_type='CSPGOLLD' 
AND code='STC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will identify the cause(s) of the child''s disruptive behavior and learn to manage the behavior(s).' 
WHERE code_type='CSPGOLLD' 
AND code='UNC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will identify and provide caregivers for the child in the absence of the primary caregiver.' 
WHERE code_type='CSPGOLLD' 
AND code='USH'; 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','UTB','Caregiver will ensure that the child follows all conditions of probation.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','UTS','Caregiver will support the child''s academic pursuits.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','UTB','CV',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','UTS','CV',SYSDATE); 

UPDATE CAPS.CODES_TABLES 
SET DT_END=TO_DATE('01/01/2006', 'MM/DD/YYYY') 
WHERE code_type='CSPGOLLD' 
AND code IN ('LSN','ABD','AOR','BRM','BSH','CAF','CFC','COP','FNI','LCC','LTC','OBT',
'PGC','PRP','PRS','SDH','SWG','NIN','STS','EFS','MSS','SAS','STS','EFS','MSS','SAS','STS','DWS','SCA','SHS'); 

UPDATE CAPS.CODES_TABLES 
SET DT_END=TO_DATE('01/01/2006', 'MM/DD/YYYY') 
WHERE code_type='CSPGOLAC' 
AND code IN ('LSN','ABD','AOR','BRM','BSH','CAF','CFC','COP','FNI','LCC','LTC','OBT',
'PGC','PRP','PRS','SDH','SWG','NIN','STS','EFS','MSS','SAS','STS','DWS','SCA','SHS'); 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate the ability to communicate with their spouse or support system when managing everyday problems.' 
WHERE code_type='CSPGOLLD' 
AND code='ATC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will actively participate in therapy to understand how their abuse/neglect affects their parenting practices.' 
WHERE code_type='CSPGOLLD' 
AND code='CAH'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will follow through on medical appointments and/or medications that assist in fulfilling their caregiver responsibilities' 
WHERE code_type='CSPGOLLD' 
AND code='CAN'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will actively demonstrate their ability to live a drug/alcohol free lifestyle.' 
WHERE code_type='CSPGOLLD' 
AND code='DFI'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will become and remain drug free.' 
WHERE code_type='CSPGOLLD' 
AND code='DSS'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate an ability to express their anger in ways that do not hurt their child(ren) or others.' 
WHERE code_type='CSPGOLLD' 
AND code='HRE'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn and demonstrate an understanding of child development and age-appropriate expectations in order to assume a responsible caregiver role.' 
WHERE code_type='CSPGOLLD' 
AND code='MCN'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will enhance their own ability to cope with daily stresses of care giving.' 
WHERE code_type='CSPGOLLD' 
AND code='MSB'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn to exercise sufficient self-control to provide child with a sense of stability, fairness, and order.' 
WHERE code_type='CSPGOLLD' 
AND code='NCP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn new behaviors that promote cooperation, stability, and a sense of self-worth among family members.' 
WHERE code_type='CSPGOLLD' 
AND code='PRD'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will identify the cause(s) of the child acting out and learn new skills to teach the child appropriate ways of expressing him/herself. ' 
WHERE code_type='CSPGOLLD' 
AND code='RDE'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Couple will identify and work on resolving differences with each other in order to provide a stable home environment for the child(ren).' 
WHERE code_type='CSPGOLLD' 
AND code='ROC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn new behaviors that promote a positive self-image in the child' 
WHERE code_type='CSPGOLLD' 
AND code='SCC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will identify and implement goals that will establish him/herself as a responsible adult.' 
WHERE code_type='CSPGOLLD' 
AND code='SPT'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will manage income to meet the family basic needs' 
WHERE code_type='CSPGOLLD' 
AND code='SUI'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn and practice age-appropriate discipline.' 
WHERE code_type='CSPGOLLD' 
AND code='UAD'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn to give and accept appropriate affection, demonstrating an ability to bond with the child.' 
WHERE code_type='CSPGOLLD' 
AND code='AAT'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate the ability to put the wants, needs, and desires of self and children ahead of those of spouse.' 
WHERE code_type='CSPGOLLD' 
AND code='DIP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate an ability to follow medical advice.' 
WHERE code_type='CSPGOLLD' 
AND code='FMA'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate an ability to secure basic necessities such as food, clothing, shelter, medical care, and supervision for the child.' 
WHERE code_type='CSPGOLLD' 
AND code='GPC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will show more patience with the child(ren).' 
WHERE code_type='CSPGOLLD' 
AND code='GRP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate the ability to provide child with adequate care and nurturance.' 
WHERE code_type='CSPGOLLD' 
AND code='PRC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate the ability to maintain regular contact with the child in the home of the caregiver.' 
WHERE code_type='CSPGOLLD' 
AND code='RGV'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will provide food, shelter, clothing and age related supervision for the child.' 
WHERE code_type='CSPGOLLD' 
AND code='SEN'; 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','ULP','Caregiver and child will work together to help child acquire independent living skills to prepare him/herself for adult responsibilities and/or expectations.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','ULP','QC',SYSDATE);

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn skills that assist in reducing the effects of drugs on the child.' 
WHERE code_type='CSPGOLLD' 
AND code='MEF'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate the ability to protect child from abuse/neglect and will show concern for child''s future safety.' 
WHERE code_type='CSPGOLLD' 
AND code='PRO'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will gain an understanding of how the family history of maltreatment has influenced the family''s current situation.' 
WHERE code_type='CSPGOLLD' 
AND code='SAP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn appropriate ways to deal with stress.' 
WHERE code_type='CSPGOLLD' 
AND code='CPN'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will understand the cycle of violence and learn ways to protect themselves and their child(ren).' 
WHERE code_type='CSPGOLLD' 
AND code='CPT'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will maintain housing that is safe and free of environmental hazards and provide protection, food, and shelter for the child and family.' 
WHERE code_type='CSPGOLLD' 
AND code='MHA'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will obtain skills that teach them how to identify and build adult relationships that are emotionally and physically positive.' 
WHERE code_type='CSPGOLLD' 
AND code='MSH'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will only engage in activities that are law abiding.' 
WHERE code_type='CSPGOLLD' 
AND code='MST'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn and demonstrate crisis intervention skills.' 
WHERE code_type='CSPGOLLD' 
AND code='PCN'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn how to identify and manage situation that may be harmful to the safety and well-being of the child(ren).' 
WHERE code_type='CSPGOLLD' 
AND code='SPH'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will learn how to identify family stressors and implement strategies to reduce stress.' 
WHERE code_type='CSPGOLLD' 
AND code='UCS'; 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','USB','Child will learn, demonstrate, and practice non-sexually abusive behavior with his siblings and all other minors.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','USB','HE',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','UUR','Child will cooperate with the rules of the household and treat other household members with respect.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','UUR','HE',SYSDATE);

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate an understanding of the cycle of violence and be proactive in securing safety for the family.' 
WHERE code_type='CSPGOLLD' 
AND code='DIS'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will develop a support system.' 
WHERE code_type='CSPGOLLD' 
AND code='DSP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will develop adult relationships that enhance self-esteem and support a positive outlook. ' 
WHERE code_type='CSPGOLLD' 
AND code='DST'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate the ability to maintain supportive relationships that are beneficial to the family situation.' 
WHERE code_type='CSPGOLLD' 
AND code='FRP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will build and maintain relationships that support the development of the child(ren).' 
WHERE code_type='CSPGOLLD' 
AND code='GDP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will build and maintain relationships with other law-abiding citizens.' 
WHERE code_type='CSPGOLLD' 
AND code='NMO'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Family will develop relationships in their community that support the emotional and physical needs of the family as a whole.' 
WHERE code_type='CSPGOLLD' 
AND code='UST'; 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','UXL','Child will abide by all local, state, and federal laws.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','UXL','SE',SYSDATE);

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will actively cooperate in fulfilling the agreed upon safety plan to address the safety concern(s) and control the risk of abuse or neglect.' 
WHERE code_type='CSPGOLLD' 
AND code='CSC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will identify pattern(s) of abuse/neglect and learn skills to implement positive change.' 
WHERE code_type='CSPGOLLD' 
AND code='CTH'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Caregiver will demonstrate an understanding of how his/her own history has affected the care of the child.' 
WHERE code_type='CSPGOLLD' 
AND code='CTK'; 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','CUD','Caregiver will cooperate with DFCS in implementing and completing the case plan.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','CUD','RI',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLLD','CUF','DFCS case manager will assist caregiver with acquiring resources to complete case plan.',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CSPGOLAC','CUF','RI',SYSDATE);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (154, 'SacwisRev2', 'static updates');

commit;


