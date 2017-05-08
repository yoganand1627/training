-- Release 2.5 

-- change STGAP00008985
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CTMPLTYP', 'ROD', 'Respite-Over 5 Days', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CTMPLTYP', 'COD', 'Concurrent-Overdue', null, sysdate);

-- change STGAP00008996
Insert into caps.MESSAGE (ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values (0,sysdate,60420,'MSG_INV_DAY_MISMATCH','All day values must match on a foster care invoice.',760,500,'N');
Insert into caps.MESSAGE (ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values (0,sysdate,60421,'MSG_FIN_INV_DTL_PERSON','Person ID does not match line items on this invoice.',760,500,'N');
Insert into caps.MESSAGE (ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values (0,sysdate,60422,'MSG_FIN_INV_DTL_RESOURCE','Resource ID does not match line items on this invoice.',760,500,'N');
Insert into caps.MESSAGE (ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values (0,sysdate,60423,'MSG_FIN_INV_DTL_DAYS','From day or to day do not match other line items on this invoice.',760,500,'N');
Insert into caps.MESSAGE (ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values (0,sysdate,60424,'MSG_FIN_INV_DTL_AMT','Please add the restricted funds or county paid line item before zeroing out state paid per diem',760,500,'N');

-- change STGAP00008998
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
select 'IV-ETimeliness', '00', 7, 'A', 'IV-E Timeliness', 'ondport', 'L', 'W', 'Tracks the progress of the initial Foster Case Eligibility Application (FCEA) for a child from the child''s earliest date of removal on the case to the approval of the initial IV-E Determination. Generated for a specific date range with optional region and county parameters.', 'Foster Care', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='IV-ETimeliness' and nm_rpt_sqr_ver='00');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'IV-ETimeliness', '00', 1, 10, 'BEGINDATE', 'DATE', 'Y', 'Date From'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='IV-ETimeliness' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'IV-ETimeliness', '00', 2, 10, 'ENDDATE', 'DATE', 'Y', 'Date To'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='IV-ETimeliness' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )  
select 'IV-ETimeliness', '00', 3, 3, 'REGIONCD', 'CHAR', 'N', 'Region'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='IV-ETimeliness' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='3');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'IV-ETimeliness', '00', 4, 3, 'COUNTYCD', 'CHAR', 'N', 'County'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='IV-ETimeliness' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='4');


-- change STGAP00009011

Insert into caps.MESSAGE 
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values 
(0,sysdate,60425,'MSG_INT_SAVE_DEATH_DIV_HOUSEHOLD','Can not select a disposition of Diversion when there has been a child''s death in the household',760,550,'N');

Insert into caps.MESSAGE 
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) values 
(0,sysdate,60426,'MSG_INT_SAVE_DEATH_SCREENOUT','Can not select a disposition of Screen Out or Screen Out & Referred when there has been a child''s death',760,550,'N'); 

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (328, 'SacwisRev2', 'static table updates');                        
commit;
