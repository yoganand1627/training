-- All changes for version 2.4 of SHINES

-- change STGAP00007880
-- Create Codes tables entries needed by ORS Searching and details
-- First delete any from a previous attempt at defining the ORS codes
delete from caps.codes_tables where code_type in ('CORSOPFT','CORSOPST','CORSCOPR','CORSCOST','CORSCOTY');

-- ORS Facility Type
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','011', 'Hospital-Short Term', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','012', 'Hospital-Psychiatric', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','013', 'Hospital-Rehabilitation', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','014', 'Hospital-Critical Access Hospitals', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','015', 'Hospital-Long Term', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','016', 'Hospital-Childrens', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','01S', 'Hospital-Licensure Only', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','021', 'Nursing Home (NH)-SNF/NF Dual Cert', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','202', 'Nursing Home (NH)-SNF/NF Distinct Part', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','023', 'Nursing Home (NH)-SNF Only', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','024', 'Nursing Home (NH)-NF Only', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','025', 'Nursing Home (NH)-Licensure Only', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','111', 'Intermediate Care Facility For The Mentally Retarded', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','421', 'Child Caring Institutions', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','431', 'Child Placing Agencies- Adoption', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','432', 'Child Placing Agencies- Foster', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','451', 'Outdoor Therapeutic Programs', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','501', 'Personal Care Home-Licensed', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','503', 'Personal Care Home-State Owned Facility', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','511', 'Community Living Arrangement-Licensed', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','513', 'Community Living Arrangement-State Owned Facility', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','631', 'Drug Abuse Program', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','632', 'Drug Abuse-Narcotic Tx Program', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','651', 'Residential Mental Health Facility', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','661', 'Maternity Home', sysdate);

-- ORS Operating Status
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','00', 'Pending', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','01', 'Active', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','10', 'Closed', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','11', 'Closed', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','12', 'Closed', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','13', 'Closed', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','20', 'Conditional Ops', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPST','21', 'Closed', sysdate);

-- Commplaint Priority
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','A', 'Immediate Jeopardy', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','B', 'Non Immediate Jeopardy High', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','C', 'Non Immediate Jeopardy Medium', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','D', 'Non Immediate Jeopardy Low', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','E', 'Non Immediate Jeopardy Admin Review/ Offsite Investigation', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','F', 'Referral-Immediately', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','G', 'Referral-Other', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOPR','H', 'No Action Necessary', sysdate);

-- Complaint Status
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOST','1', 'Triage/Prioritization', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOST','3', 'Pending Review/Assignment', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOST','4', 'Under Investigation', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOST','5', 'Investigation Completed', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOST','8', 'Closed', sysdate);

-- Complaint Type
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOTY','01', 'Complaint', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSCOTY','02', 'Entity Reported Incident', sysdate);

-- change STGAP00007867
-- INSERTING into METAPHOR
Insert into CAPS.METAPHOR (ID_TAB,TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_L1_IMG_INACTIVE,TXT_L1_IMG_ACTIVE,TXT_FILTER_PATH,DT_LAST_UPDATE) values (1135,'/resource/ResourceORSSearch/','RESOURCE_ORS_SEARCH_SEARCH','ORS Resource<br>Search',null,null,null,to_date('10-MAR-08','DD-MON-RR'));
Insert into CAPS.METAPHOR (ID_TAB,TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_L1_IMG_INACTIVE,TXT_L1_IMG_ACTIVE,TXT_FILTER_PATH,DT_LAST_UPDATE) values (1138,'/resource/ResourceORSDetail/displayResourceORSDetail','RESOURCE_ORS_DETAIL_RESOURCEDETAIL','ORS Resource<br>Detail',null,null,null,to_date('10-MAR-08','DD-MON-RR'));


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (302, 'SacwisRev2', 'static table updates for ORS interface');                        
commit;

