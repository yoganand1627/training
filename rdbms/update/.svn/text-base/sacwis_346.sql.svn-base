-- STGAP00009324 - Insert Rows For New Safety Resource Placements Rpt
insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='SafetyResourcePlacements' and nm_rpt_sqr_ver='00') then
   into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
     select 'SafetyResourcePlacements' x, '00', 31, 'A', 'Safety Resource Placements', 'ondport', 'L', 'W', 'List of all children placed in safety resources with active Investigation and Ongoing cases. Generated for a specific county parameter.', 'Safety Resource', 'Y' from dual;


insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='SafetyResourcePlacements' and nm_rpt_sqr_ver='00') then
   into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
     select 'SafetyResourcePlacements', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County' from dual;



--STGAP00009329 - Update CTMPLTYP and CRMRSNAC per system test defect

UPDATE CAPS.CODES_TABLES SET DECODE = 'Respite-Post 5 Days', DT_LAST_UPDATE = SYSDATE WHERE CODE_TYPE = 'CTMPLTYP' AND CODE = 'ROD';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Concurrent-Post Paid Limit', DT_LAST_UPDATE = SYSDATE WHERE CODE_TYPE = 'CTMPLTYP' AND CODE = 'COD';
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_LAST_UPDATE) VALUES ('CRMRSNAC','REP','Respite Placement Ended',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_LAST_UPDATE) VALUES ('CRMRSNAC','REO','Respite/Concurrent Post Paid Limit',SYSDATE);


--STGAP00009332 - Safety Resource: Add additional error messages

INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE,
CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES
(0,60447,'MSG_SRP_SEC_REL','Secondary safety resource relationship is required when a secondary safety resource has been selected.','700','500','N');

INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE,
CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES
(0,60448,'MSG_SRP_PRIM_SEC_MATCH','Primary and secondary safety resource cannot be the same person.','700','500','N');


--STGAP00009334 - Reports: New SQR report entry

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='ActiveTotals' and nm_rpt_sqr_ver='00') then
   INTO caps.REPORTS (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE )
	Select 'ActiveTotals' z, '00', 7, 'A', 'Active Totals', 'ondport', 'P', 'W', 'Monthly case activity totals for the state, region, or county. Generated for a specific month with optional region and county parameters.', 'Administration', 'Y' from dual;


insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ActiveTotals' and nm_rpt_sqr_ver='00') then
   INTO caps.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL)
      select 'ActiveTotals', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ActiveTotals' and nm_rpt_sqr_ver='00') then
   INTO caps.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL)
      select 'ActiveTotals', '00', 2, 3, 'REGIONCD', 'CHAR', 'N', 'Region' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ActiveTotals' and nm_rpt_sqr_ver='00') then
   INTO caps.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL)
      select 'ActiveTotals', '00', 3 z, 3, 'COUNTYCD', 'CHAR', 'N', 'County' from dual;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (347, 'SacwisRev2', 'DBCRs 9324,9329,9332,9334');
commit;


