-- change STGAP00007130 

-- Case Worker Child Visit

delete from caps.report_parameter
where nm_rpt_sqr_name = 'CaseWorkerChildVisit';

delete from caps.reports
where nm_rpt_sqr_name = 'CaseWorkerChildVisit';



INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('CaseWorkerChildVisit', '00', 7, 'A', 'Case Worker Case Visit', 'ondport', 'L', 'W', 'A list of foster care cases with face to face contacts made with the child during the month. Generated for a specific reporting month and county with an optional unit parameter', 'Foster Care', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CaseWorkerChildVisit', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CaseWorkerChildVisit', '00', 2, 3, 'COUNTYCD', 'CHAR', 'Y', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CaseWorkerChildVisit', '00', 3, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

-- Cases Without Child Visit

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('CasesWithoutChildVisit', '00', 7, 'A', 'Cases Without Child Visit', 'ondport', 'L', 'W', 'A list of foster care cases without a face to face contact recorded with the child during the month. Generated for a specific reporting month and county with an optional unit parameter', 'Foster Care', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutChildVisit', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutChildVisit', '00', 2, 3, 'COUNTYCD', 'CHAR', 'Y', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutChildVisit', '00', 3, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

-- On Call Report

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('OnCall', '00', 7, 'A', 'On Call', 'ondport', 'L', 'W', 'On Call schedule for a county including staff contact information. Generated for a specific date range and county.', 'Administration', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('OnCall', '00', 1, 7, 'DATE', 'CHAR', 'Y', 'Start Date');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('OnCall', '00', 2, 7, 'DATE', 'CHAR', 'Y', 'End Date');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('OnCall', '00', 3, 3, 'COUNTYCD', 'CHAR', 'Y', 'County');

-- Overdue Pending Statewide

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('OverduePendingStatewide', '00', 7, 'A', 'Overdue Pending Statewide', 'ondport', 'L', 'W', 'Statewide, region, and county totals of investigation stages pending more than 45 days. This report accepts an optional region parameter.', 'Investigations', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('OverduePendingStatewide', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


-- Overdue Pending Incidents

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('OverduePendingIncidents', '00', 7, 'A', 'Overdue Pending Incidents', 'ondport', 'P', 'W', 'A list of overdue investigations (more than 45 days) and the days pending from the intake date. Generated for a specific county with optional unit and staff parameters.', 'Investigations', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('OverduePendingIncidents', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('OverduePendingIncidents', '00', 2, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('OverduePendingIncidents', '00', 3, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');
 

-- Monthly Family Team Meetings

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('MonthlyFamilyTeamMeetings', '00', 7, 'A', 'Monthly Family Team Meetings', 'ondport', 'L', 'W', 'A list of cases that have had a family team meeting conducted within the reporting month. Generated for a specific reporting month and county with an optional unit parameter.', 'Family Team Meetings', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('MonthlyFamilyTeamMeetings', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('MonthlyFamilyTeamMeetings', '00', 2, 3, 'COUNTYCD', 'CHAR', 'Y', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('MonthlyFamilyTeamMeetings', '00', 3, 2, 'UNIT', 'NUMBER', 'N', 'Unit');


-- Cases Without A Family Team Meeting

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('CasesWithoutFamilyTeamMeeting', '00', 7, 'A', 'Cases Without A Family Team Meeting', 'ondport', 'L', 'W', 'A list of active ongoing and foster care stages that do not have a family team meeting documented. Generated for a specific county with an optional unit parameter.', 'Family Team Meetings', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutFamilyTeamMeeting', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutFamilyTeamMeeting', '00', 2, 2, 'UNIT', 'NUMBER', 'N', 'Unit');


-- Home Facility List

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('HomeFacilityList', '00', 7, 'A', 'Home/Facility List', 'ondport', 'L', 'W', 'A list of active homes and facilities displayed with contact information, approved capacity, and open slots. Generated for a specific home/facility type and region with an optional county parameter.', 'Resource Directory', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('HomeFacilityList', '00', 1, 2, 'FACILITYCD', 'CHAR', 'Y', 'Home/Facility Type');


insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('HomeFacilityList', '00', 2, 2, 'REGIONCD', 'CHAR', 'Y', 'Region');


insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('HomeFacilityList', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');


-- TCMMonthlyBillingStatistics

update caps.reports set NM_RPT_AREA_TYPE = 'TCM' 
where NM_RPT_SQR_NAME = 'TCMMonthlyBillingStatistics';

update caps.reports set IND_RPT_PAGE = 'Y' 
where NM_RPT_SQR_NAME = 'TCMMonthlyBillingStatistics';

-- Intake Monthly Statistics
update caps.reports set NM_RPT_DESC = 'Statistics reported for intakes received in the county within the month. Generated for a specific county and service month.' 
where NM_RPT_SQR_NAME = 'IntakeMonthlyStatistics';

-- Investigation Monthly Statistics
update caps.reports set NM_RPT_DESC = 'Statistics reported for investigations in the county within the month. Generated for a specific county and service month with an optional unit parameter.' 
where NM_RPT_SQR_NAME = 'InvestigationMonthlyStatistics';

-- Investigation Monthly Status
update caps.reports set NM_RPT_DESC = 'Activities reported for investigations in the county within the month. Generated for a specific case manager and service month.' 
where NM_RPT_SQR_NAME = 'InvestigationMonthlyStatus';

-- Pending Incidents
update caps.reports set NM_RPT_DESC = 'A list of open investigations and the days pending from the intake date.  Generated for a specific county with an optional unit parameter.' 
where NM_RPT_SQR_NAME = 'PendingIncidents';

-- Family Preservation Monthly Statistics
update caps.reports set NM_RPT_DESC = 'Statistics reported for ongoing cases in the county within the month. Generated for a specific county and service month with an optional unit parameter.' 
where NM_RPT_SQR_NAME = 'FamilyPreservationMonthlyStatistics';

-- Family Preservation Monthly Status
update caps.reports set NM_RPT_DESC = 'Activities reported for ongoing cases in the county within the month. Generated for a specific case manager and service month with an optional case ID parameter.' 
where NM_RPT_SQR_NAME = 'FamilyPreservationMonthlyStatus';

-- RBWO Active Placements
update caps.reports set NM_RPT_DESC = 'A list of all children currently placed in Room, Board, and Watchful Oversight (RBWO) placements. Generated for a specific county.' 
where NM_RPT_SQR_NAME = 'RBWOActivePlacements';

-- Foster Home Inquiry
update caps.reports set NM_RPT_DESC = 'Outstanding inquiries of people interested in becoming foster parents. Generated for a specific county.' 
where NM_RPT_SQR_NAME = 'FosterHomeInquiry';

-- Cases With Safety Resources
update caps.reports set NM_RPT_DESC = 'A list of all active investigation and ongoing cases with a safety resource. Generated for a specific county with an optional unit parameter.' 
where NM_RPT_SQR_NAME = 'CasesWithSafetyResources';

-- Case History Of Investigations
update caps.reports set NM_RPT_AREA_TYPE = 'Case Printing' 
where NM_RPT_SQR_NAME = 'CaseHistoryOfInvestigations';

-- Placement Log
update caps.reports set NM_RPT_AREA_TYPE = 'Case Printing' 
where NM_RPT_SQR_NAME = 'PlacementLog';


-- change STGAP00007131 
-- Conversion Validation Reports: update parameters

UPDATE CAPS.report_parameter SET nbr_rpt_parm_seq = 1, nm_rpt_parm_name = 'COUNTYCD', nm_rpt_parm_label = 'County' 
WHERE nm_rpt_sqr_name = 'StageValidationDetail' AND nm_rpt_parm_name = 'REGIONCD';
UPDATE CAPS.report_parameter SET nbr_rpt_parm_seq = 2  
WHERE nm_rpt_sqr_name = 'StageValidationDetail' AND nm_rpt_parm_name = 'STAFFID';
UPDATE CAPS.report_parameter SET nbr_rpt_parm_seq = 1
WHERE nm_rpt_sqr_name = 'ValidationStatus' AND nm_rpt_parm_name = 'REGIONCD';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (280, 'SacwisRev2', 'Reporting Table Updates To Support Release 2.2, Update parameters for Conversion Validation Reports');                        
commit;

