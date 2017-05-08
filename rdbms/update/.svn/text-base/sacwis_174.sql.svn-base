
ALTER TABLE SACWISIFC.INVOICE_OUTBOUND ADD ID_LINE_ITEM NUMBER(16) DEFAULT 0 NOT NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00002605 revisited
UPDATE caps.CODES_TABLES 
SET DECODE='Transfer to Another Agency' 
WHERE CODE='TAA' 
and code_type = 'CCLOSFCC';

-- change STGAP00002671
DELETE FROM CAPS.METAPHOR WHERE TXT_TAB IN ('Non-Title IV-E Checklist', 'Foster Care Review');

-- change STGAP00002675
update caps.codes_tables
set dt_end = to_date('01/01/2006','MM/DD/YYYY')
where code = '98'
and code_type = 'CREGIONS'; 

-- change STGAP00002677
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60332, 'MSG_SVC_AUTH_DETAIL_REQ', 'At least one Service Authorization Detail record is required to save and submit.', '500', '700', 'N');

-- change STGAP00002689
UPDATE CAPS.TASK SET txt_event_detail_url='/subcare/RelativeCareAssessment/displayRelativeCareAssessment'
WHERE cd_task='9466';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (175, 'SacwisRev2', 'static updates, new field in sacwisifc invoice outbound'); 
                         
commit;


