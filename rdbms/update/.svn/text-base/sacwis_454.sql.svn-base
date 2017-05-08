--STGAP00013340 - DBCR for invoice Detail

--Note:  no impact to ado conversion

--Add Provider Invoice Number column to INVOICE table

alter table caps.invoice add (nbr_inv_provider varchar2(12));
comment on column caps.invoice.nbr_inv_provider is 'Provider Invoice Number';


--STGAP00013251 - Insert data in Codes table for Case Review

--Note:  no impact to ado conversion



INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CCSRTYPE','RT1','Targeted Review',SYSDATE);


INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CCSRTYPE','RT2','Second Level Review',SYSDATE);


INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CCSRTYPE','RT3','Peer To Peer Review',SYSDATE);


INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CCSRTYPE','RT4','Sample Review',SYSDATE);


UPDATE CAPS.CODES_TABLES SET DECODE = 'Delete Case Review' WHERE CODE = 'PK' AND CODE_TYPE = 'CSECATTR';



--STGAP00013252 - Update the question Text for the Case Review

--Note:  no impact to ado conversion


UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP
SET TXT_QUESTION =
'If response time frame was not met, were there timely and concerted diligent efforts made and documented(concerted diligent efforts refer to going to extreme measures to locate the child victims)?'
WHERE CD_QUESTION  = 'Q08' ;


--STGAP00013279 - DBCR for  invoice search, Payment approval

--Note:  no impact to ado conversion


UPDATE caps.message
SET TXT_MESSAGE = 'Please enter a Region and Invoice Year.'
WHERE NBR_MESSAGE = 25504 AND TXT_MESSAGE_NAME = 'MSG_INVOICE_REQ_FIELD';


INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60523,'MSG_INV_YEAR_REQ','Year is required when searching by a specific Month.',700,500,'N');



--STGAP00013341 - Per MR-033 Add new row to Codes_Tables

--Note:  no impact to ado conversion


INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CINVSRTP','RCS','Relative Care Subsidy',SYSDATE);



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (455, 'SacwisRev3', 'Release 3.1 - DBCRs 13330,13251,13252,13279,13340,13341');

commit;


