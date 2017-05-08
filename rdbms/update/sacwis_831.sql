--STGAP00015909 - Release(3.6) New Report Financial Exceptions

-- Entry to enable new report in SHINES
-- Dev#: SMS: 49899 request; 51188 project
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME,
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE, IND_SHINES_BATCH )
VALUES ('UDRFinancialExceptionBatchRept', '00', 7, 'U', 'Financial Exceptions', 'ondport', 'L', 'W', 'This is a pre-generated multi-tab spreadsheet report that will allow users to review the lists of all possible errors statewide in various areas affecting Financial Management. Lists may be modified to view data for specific geography and case manager.', 'User Defined Reports', 'Y', 'Y');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (832, 'SacwisRev3', 'Release 3.6 - DBCR 15909');

commit;

