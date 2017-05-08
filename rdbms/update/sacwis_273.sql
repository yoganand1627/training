-- change STGAP00007007
insert into CAPS.REPORTS (DT_LAST_UPDATE, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE) values (sysdate, 'PendingIncidents', '00', 7, 'A', 'Pending Incidents', 'ondport', 'P', 'W', 'A list of pending investigations and the days outstanding from the intake date.  Generated for a specific county.', 'Investigation', 'Y');
insert into CAPS.REPORTS (DT_LAST_UPDATE, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE) values (sysdate, 'FPRMonthlyStatistics', '00', 7, 'A', 'Family Preservation Monthly Statistics ', 'ondport', 'P', 'W', 'Multiple statistics reported for ongoing cases in the county within the month. Generated for a specific county and service month with an optional unit parameter.', 'Ongoing', 'Y');
insert into CAPS.REPORTS (DT_LAST_UPDATE, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE) values (sysdate, 'CaseloadListing', '00', 7, 'A', 'Caseload Listing (Worker)', 'ondport', 'L', 'W', 'A list of active cases currently assigned to the case manager. ', 'Administration', 'Y');
insert into CAPS.REPORTS (DT_LAST_UPDATE, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE) values (sysdate, 'CaseloadListingCounty', '00', 7, 'A', 'Caseload Listing (County)', 'ondport', 'L', 'W', 'A comprehensive view of all caseloads in a county grouped by unit then by case manager.  Generated for a specific county with an optional unit parameter.', 'Administration', 'Y');
insert into CAPS.REPORTS (DT_LAST_UPDATE, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE) values (sysdate, 'AfcarsDischarge', '00', 7, 'A', 'Foster Care Discharge', 'ondport', 'P', 'W', 'A list of children who exited foster care during the reporting month.  Generated for a specific county and service month.', 'Foster Care', 'Y');
insert into CAPS.REPORTS (DT_LAST_UPDATE, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE) values (sysdate, 'FosterHomeInquiry', '00', 7, 'A', 'Foster Home Inquiry', 'ondport', 'P', 'W', 'Outstanding inquiries of people interested in becoming foster parents.  ', 'Resource Development', 'Y');
INSERT INTO CAPS.REPORTS ( DT_LAST_UPDATE, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) VALUES ( sysdate, 'OverStandardofPromptness', '00', 7, 'A', 'Over Standard of Promptness', 'ondport', 'P', 'W', 'A list of foster care cases that have been opened for more than 45 days without an approved eligibility determination.  Generated for a specific county.', 'Eligibility', 'Y'); 

update CAPS.REPORT_PARAMETER set NM_RPT_SQR_NAME = 'AfcarsDischarge' where NM_RPT_SQR_NAME = 'afcarsdischarge';
update CAPS.REPORT_PARAMETER set NM_RPT_SQR_NAME = 'CaseloadListing' where NM_RPT_SQR_NAME = 'caseloadlisting';
update CAPS.REPORT_PARAMETER set NM_RPT_SQR_NAME = 'CaseloadListingCounty' where NM_RPT_SQR_NAME = 'caseloadlistingcounty';
update CAPS.REPORT_PARAMETER set NM_RPT_SQR_NAME = 'FPRMonthlyStatistics' where NM_RPT_SQR_NAME = 'fprmonthlystatistics';
update CAPS.REPORT_PARAMETER set NM_RPT_SQR_NAME = 'PendingIncidents' where NM_RPT_SQR_NAME = 'pendingincidents';
update CAPS.REPORT_PARAMETER set NM_RPT_SQR_NAME = 'FosterHomeInquiry' where NM_RPT_SQR_NAME = 'fosterhomeinquiry';
update CAPS.REPORT_PARAMETER set NM_RPT_SQR_NAME = 'OverStandardofPromptness' where NM_RPT_SQR_NAME = 'OverStandardOfPromptness';

delete from CAPS.REPORTS where NM_RPT_SQR_NAME = 'afcarsdischarge';
delete from CAPS.REPORTS where NM_RPT_SQR_NAME = 'caseloadlisting';
delete from CAPS.REPORTS where NM_RPT_SQR_NAME = 'caseloadlistingcounty';
delete from CAPS.REPORTS where NM_RPT_SQR_NAME = 'fprmonthlystatistics';
delete from CAPS.REPORTS where NM_RPT_SQR_NAME = 'pendingincidents';
delete from CAPS.REPORTS where NM_RPT_SQR_NAME = 'fosterhomeinquiry';
delete from CAPS.REPORTS where NM_RPT_SQR_NAME = 'OverStandardOfPromptness';

UPDATE caps.report_parameter SET report_parameter.NM_RPT_PARM_NAME='STAFFID',report_parameter.TXT_RPT_PARM_TYPE='NUMBER' WHERE NM_RPT_SQR_NAME IN (
SELECT NM_RPT_SQR_NAME FROM caps.Reports WHERE ind_rpt_page = 'Y') AND nm_rpt_parm_label='Staff ID';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (274, 'SacwisRev2', 'static table updates - Report tables');                        
commit;

