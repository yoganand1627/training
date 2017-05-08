--STGAP00012726 - Adoptions reports: update various report

--Note:  no impact to ado model

--  made report description and name consistent between reports, corrected security attribute for
-- Family report, updated Scorecard description with 2 new parameters as change per SAU review.

update caps.reports
set TXT_RPT_FULL_NAME = 'Children With Overdue Life Histories',
NM_RPT_DESC = 'A list of children in Adoption stage with no approved child life history checklist record and it has been more than 60 days since the TPR or Voluntary Surrender of the first parent. Generated for optional region and county parameters. This report requires SAU staff security attribute.' 
where reports.NM_RPT_SQR_NAME = 'ChildrenWithOverdueLifeHistories';

update caps.reports
set NM_RPT_DESC = 'A list of registered children in consideration whose date out is more than 31 calendar days. Generated for optional region and county parameters. This report requires SAU staff security attribute.'
where reports.NM_RPT_SQR_NAME = 'ConsiderationOverdue';

update caps.reports
set NM_RPT_DESC = 'A list of registered children that have not been adopted or adoption happened in the past 60 calendar days. Generated for optional region and county parameters. This report requires SAU sealed security attribute.'
where reports.NM_RPT_SQR_NAME = 'MonthlyChildMangement';

update caps.reports
set TXT_RPT_FULL_NAME = 'Monthly Family Management',
CD_SEC_ATTR = '90',
NM_RPT_DESC = 'A list of all active homes registered with the Adoption Exchange. Generated for optional region and county parameters. This report requires SAU sealed security attribute.'
where reports.NM_RPT_SQR_NAME = 'MonthlyFamilyManagement';

update caps.reports
set NM_RPT_DESC = 'A list of children free for adoption who has not been registered with My Turn Now. Generated for optional region and county parameters. This report requires SAU staff security attribute.'
where reports.NM_RPT_SQR_NAME = 'MyTurnNowException';

update caps.reports
set NM_RPT_DESC = 'A list of counties and compliant level of timely registration of a child within 60 calendar days of the surrender or termination of parental right. Generated for a specific date range parameter of up to 12 months and region and county parameters. This report requires SAU staff security attribute.'
where reports.NM_RPT_SQR_NAME = 'Scorecard';

update caps.reports
set TXT_RPT_FULL_NAME = 'Period Finalization List',
NM_RPT_DESC = 'A list of finalized adoptions where the date final entered is within the reporting period. Generated for a specific date range and optional region and county parameters. This report requires SAU sealed security attribute.'
where reports.NM_RPT_SQR_NAME = 'PeriodFinalizationList';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (442, 'SacwisRev3', 'Release 3.0 - DBCR 12726');

commit;


