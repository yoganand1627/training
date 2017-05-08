
-- Standard Alter Table SQL

ALTER TABLE CAPS.NEEDS_OUTCOMES ADD IND_CCFA_AGENCY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.NEEDS_OUTCOMES ADD IND_CCFA_EDU_ASSMT VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.NEEDS_OUTCOMES ADD TXT_CCFA_EDU_ASSMT VARCHAR2(300)     NULL
;
ALTER TABLE CAPS.NEEDS_OUTCOMES ADD DT_CCFA_EDU_ASSMT DATE     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };


-- Change 257 Revisited
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CADEXCHG', 'RCI', 'Registered - Child Identified');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CADEXCHG', 'RNI', 'Registered - Child Not Identified');

-- Change 263
UPDATE caps.CODES_TABLES SET DT_END = SYSDATE  WHERE CODE_TYPE = 'CERTIFBY';


-- Change 264
INSERT INTO caps.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CERTIFBY','JAC','Joint Commission on Accreditation for Healthcare Organizations',SYSDATE); 

INSERT INTO caps.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CERTIFBY','CAR','Commission on Accereditation for Rehabilitation Facilities',SYSDATE); 

INSERT INTO caps.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CERTIFBY','COA','Council on Accreditation of Services for Children and Families, Inc.',SYSDATE); 

INSERT INTO caps.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CERTIFBY','CQL','Council on Quality Leadership',SYSDATE); 

INSERT INTO caps.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CERTIFBY','OTH','Other/Speciality',SYSDATE);

-- Change 285
insert into CAPS.MESSAGE 
       (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
     Values 
       (0, sysdate, 60091, 'MSG_RSRC_MUST_ADD', 'You must add a new address and phone number before saving a new resource.', 700, 500, 'N');

-- change 286
insert into caps.codes_tables values ('CTXGASTG','FSU','FCF',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','SUB','FCC',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','FPR','ONG',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','ADO','ADO',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','PAD','PAD',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','PFC','PFC',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','INT','INT',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','INV','INV',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','ARI','ARI',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','I' ||Chr(38)|| 'R','I' ||Chr(38)|| 'R',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','SPC','SPC',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','FAD','FAD',null,sysdate); 
insert into caps.codes_tables values ('CTXGASTG','DIV','DIV',null,sysdate);

-- change 287
insert into caps.codes_tables values ('CNIRTYPE','NI','Non-incident DJJ Case',null,sysdate);

-- change 289
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60093, 'MSG_EDU_CCFA_EXP_REQ' 
,'Record why the child''s CCFA Educational Assessment has not been performed.',500,700);

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60092, 'MSG_EDU_CCFA_DATE_REQ' 
,'Enter the date the CCFA Educational Assessment was completed.',500,700);

-- change 290
INSERT INTO CAPS.TASK ( CD_TASK,CD_TASK_EVENT_TYPE,CD_TASK_STAGE,CD_TASK_STAGE_PROGRAM,IND_TASK_EVENT_CREATE,IND_TASK_EVENT_NAVIG,IND_TASK_MULTIPLE_INSTANCE, 
IND_TASK_NEW_USING,IND_TASK_NU_ACROSS_CASE,IND_TASK_RTRV_PRIOR_STAGE,IND_TASK_SHOW_IN_LIST,TXT_TASK_DECODE,TXT_1ST_TAB,TXT_2ND_TAB, 
TXT_3RD_TAB,TXT_EVENT_DETAIL_URL) VALUES 
(2287,'APP','SUB','CPS',0,1,1,0,0,0,0,'Approve Needs And Outcomes','CASE_CASESEARCH','CHILD_PLANS_EVENTLIST','NEEDS_AND_OUTCOMES','/subcare/NeedsAndOutcomes/displayNeedsAndOutcomes');

-- change 292
UPDATE CAPS.CODES_TABLES SET DECODE = 'Inactive' WHERE CODE = '02' AND CODE_TYPE = 'CRSCSTAT';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Closed'   WHERE CODE = '03' AND CODE_TYPE = 'CRSCSTAT';
       
-- change 293
update CAPS.CODES_TABLES set DT_END = null  where CODE = '99' and CODE_TYPE = 'CFACTYP5';

-- change 294
update caps.codes_tables set DECODE = 'Joint Comm. on Accred. for Helathcare Org.' 
where code = 'JAC' and code_type = 'CERTIFBY';

update caps.codes_tables set DECODE = 'Comm. on Accred. for Rehabilitation Facilities' 
where code = 'CAR' and code_type ='CERTIFBY';

update caps.codes_tables set DECODE = 'Council on Accred. of Services for Child. and Families, Inc.' 
where code = 'COA' and code_type = 'CERTIFBY';
      
insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (121, 'SacwisRev2', 'needs_outcomes and static updates');
                         
commit;
