--STGAP00015779 - Release(3.5) SQR: update name and description PIP reports

--To rename PIP reports and update their description to be consistent through out

--Datafix: INCPS0000021484

-- Update PIP report name and description
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item10 APPLA Exception Cases', NM_RPT_DESC = 'A list of active Foster Care children with permanency goal of APPLA whose goal has not been met. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'APPLAExceptionList' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item10 APPLA Summary', NM_RPT_DESC = 'Captures DFCS'' effort in achieving APPLA permanency goal. Percentage of meeting APPLA as a whole as well as each of APPLA components is listed. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'APPLASummary' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 FC: Children W/O Involvement (CP) List', NM_RPT_DESC = 'A list of active Foster Care cases without child involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningFCC' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 FC: Children W/O Involvement (CP) Status', NM_RPT_DESC = 'Summary view of active Foster Care cases without child involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningStatusFCC' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 FC: Parent(s) W/O Involvement (CP) List', NM_RPT_DESC = 'A list of active, reunification Foster Care cases without parent involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningFCC' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 FC: Parent(s) W/O Involvement (CP) Status', NM_RPT_DESC = 'Summary view of active, reunification Foster Care cases without parent involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningStatusFC' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 ONG: Children W/O Involvement (CP) List', NM_RPT_DESC = 'A list of active Ongoing cases without child involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningONG' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 ONG: Children W/O Involvement (CP) Status', NM_RPT_DESC = 'Summary view of active ONG cases without child involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ChildInvolvementInCasePlanningStatusONG' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 ONG: Parent(s) W/O Involvement (CP) List', NM_RPT_DESC = 'A list of active Ongoing cases without parent involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningONG' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item18 ONG: Parent(s) W/O Involvement (CP) Status', NM_RPT_DESC = 'Summary view of active ONG cases without parent involvement in case planning (CP) for the past six months. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningStatusONG' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item20 FC: Cases W/O Case Mgr Parent Visit List', NM_RPT_DESC = 'A list of active, reunification Foster Care cases where parents were not contacted face to face for the purpose of case manager parent visit in the month. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'CasesWithoutCaseManagerParentVisitsFCC' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item20 FC: Cases W/O Case Mgr Parent Visit Status', NM_RPT_DESC = 'Summary view of active, reunification Foster Care cases without at least one face to face, case manager parent visit made to every parent in the month. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'CasemanagerParentVisitStatusFC' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item20 ONG: Cases W/O Case Mgr Parent Visit List', NM_RPT_DESC = 'A list of active Ongoing cases where parents were not contacted face to face for the purpose of case manager parent visit in the month. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'CasesWithoutCasemanagerParentVisitsONG' and NM_RPT_SQR_VER = '00';
update CAPS.REPORTS set TXT_RPT_FULL_NAME = 'Item20 ONG: Cases W/O Case Mgr Parent Visit Status', NM_RPT_DESC = 'Summary view of active ONG cases without at least one face to face, case manager parent visit made to every parent in the month. Generated for a specific month with optional region, county, and unit parameters.' where NM_RPT_SQR_NAME = 'CasemanagerParentVisitStatusONG' and NM_RPT_SQR_VER = '00';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (738, 'SacwisRev3', 'Release 3.5 - DBCR 15779');



commit;
 
