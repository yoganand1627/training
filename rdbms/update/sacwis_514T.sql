--STGAP00015143 - Remove unneeded objects

drop index CAPS.IND_HOME_ETHNICITY_1;
drop index CAPS.IND_HOME_RACE_1;
-- Remove the drop table from the Training script
-- drop table CAPS.CNV_RBWO;
alter table CAPS.ADOPTION_SUBSIDY drop column ID_SPECIAL_NEEDS_DETER;


--STGAP00015097 - Update DBCR - Child Involvement Case Planning ONG

-- Enable drop down box for the Region/county report parameters to appear in the application 
--Report Development Defect #: STGAP00014619
--Creation of Report DBCR defect #: STGAP00015063

Update caps.report_parameter
set NM_RPT_PARM_NAME = 'REGIONCD'
 WHERE  NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningONG'
 and NM_RPT_SQR_VER = '00'
 and NBR_RPT_PARM_SEQ = 2;


Update caps.report_parameter
set NM_RPT_PARM_NAME = 'COUNTYCD'
 WHERE  NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningONG'
 and NM_RPT_SQR_VER = '00'
 and NBR_RPT_PARM_SEQ = 3;


Update caps.report_parameter
set NM_RPT_PARM_NAME = 'UNIT'
 WHERE  NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningONG'
 and NM_RPT_SQR_VER = '00'
 and NBR_RPT_PARM_SEQ = 4;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (515, 'SacwisRev3', 'Release 3.2 - DBCR 15097,15143');

commit;


