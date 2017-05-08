--STGAP00013330 - Reports: New SQR report - Invoice

--Note:  no impact to ado conversion


-- Enable SQR new Invoice report
-- Add new error message: at least one conditionally required parameters is required
-- DEV# (Java change): STGAP00013329
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME,
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE )
VALUES ('InvoiceList', '00', 7, 'A', 'Invoice', 'ondport', 'L', 'W', 
'A detailed view of invoices within a specific date range per client, resource, and/or region. Generated for required begin and end month parameters, with at least one of the following client ID, resource ID, or region parameters, and optional county and UAS program parameters.', 'Financial Management', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('InvoiceList', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Begin Month');

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, 
NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('InvoiceList', '00', 2, 7, 'MONTHYEAR', 'CHAR', 'Y', 'End Month');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('InvoiceList', '00', 3, 16, 'PERSONID', 'NUMBER', 'C', 'Person ID');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
 NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('InvoiceList', '00', 4, 16, 'RESOURCEID', 'NUMBER', 'C', 'Resource ID');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
 NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('InvoiceList', '00', 5, 2, 'REGIONCD', 'CHAR', 'C', 'Region');

insert into CAPS.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('InvoiceList', '00', 6, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into CAPS.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('InvoiceList', '00', 7, 3, 'UASPROGCD', 'CHAR', 'N', 'UAS Progam');

insert into CAPS.message values 
(0, sysdate, 60524, 'MSG_RPRT_COND_PARAM_REQ','At least one of the conditionally required parameters is required.', '700', '500', 'N');

--STGAP00013349 - Reports: add new param name

--Note:  no impact to ado model


-- Defect#: STGAP00013351
-- added 2 new parameter names with the same Month/Year constraint as MONTHYEAR
-- to fix constraint error message not being able to display the field label. This
-- applies to reports that have 2+ MONTHYEAR fields

-- Current constraint error message displays:
-- undefined -  Field is required. Please enter a value.

-- Will be fixed to display:
-- End Month - Field is required. Please enter a value.
-- Begin Month - Field is required. Please enter a value.


UPDATE CAPS.REPORT_PARAMETER
SET NM_RPT_PARM_NAME = 'STARTMMYYYY'
WHERE NM_RPT_SQR_NAME in ('EveryChildEveryMonth','InvoiceList')
AND NM_RPT_PARM_LABEL = 'Begin Month'
AND NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NM_RPT_PARM_NAME = 'ENDMMYYYY'
WHERE NM_RPT_SQR_NAME in ('EveryChildEveryMonth','InvoiceList')
AND NM_RPT_PARM_LABEL = 'End Month'
AND NM_RPT_SQR_VER = '00';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (456, 'SacwisRev3', 'Release 3.1 - DBCR 13349');

commit;


