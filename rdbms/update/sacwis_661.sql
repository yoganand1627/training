--STGAP00015247 - Release(N/A) Update UDR Resource Dev. Report Description

--See STGAP00015190:

--Update the description for the UDR Resource Development report, as follows:

UPDATE CAPS.REPORTS
set NM_RPT_DESC = 'This is a list of Foster, Foster to Adopt, and Adoptive Homes recorded as FAD stages.  This list does not include resources outside of the FAD stage.  This list is further restricted to only homes that were in one of three active statuses as of the last day of the reporting period.'
where NM_RPT_SQR_NAME = 'UDRResourceDevRept'
AND NM_RPT_SQR_VER = '00'
AND NM_RPT_TYPE = 'U'
AND TXT_RPT_FULL_NAME = 'Resource Development';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (662, 'SacwisRev3', 'Release 3.41 - DBCR 15247');

commit;

