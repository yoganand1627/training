--STGAP00015755 - Release(3.5) Case Review List: update description and parameter

-- Update  Report Launch description and Month/Year parameter to differentiate between review month and reporting month.
-- Related recurring datafix: INCPS0000021127


update CAPS.REPORT_PARAMETER
set NM_RPT_PARM_LABEL = 'Review Period Month/Year (see Report Description)'
where NM_RPT_SQR_NAME = 'CaseReviewList' and NM_RPT_SQR_VER = '00'
and NBR_RPT_PARM_SEQ = 1;

update CAPS.REPORTS
set NM_RPT_DESC = 'A list of cases to be reviewed for a specific review month and type with optional region, county, and unit parameters. Note, for sample reviews, the Review Period is the month prior to the date the sample was generated. A sample generated 11/1/2009 would have a Review Period of 10
/2009.'
where NM_RPT_SQR_NAME = 'CaseReviewList' and NM_RPT_SQR_VER = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (722, 'SacwisRev3', 'Release 3.5 - DBCR 15755');

commit;

