--STGAP00016039 - Release(4.1) MR=053 Update FCR event and deprivation date

UPDATE CAPS.FCE_APPLICATION
SET dt_removal_date = TO_DATE( nbr_court_month || '/01/' || nbr_court_year, 'MM/DD/YYYY')
WHERE (nbr_court_month is not null AND nbr_court_month <> 0)
AND (nbr_court_year is not null AND nbr_court_year <> 0);

UPDATE CAPS.CODES_TABLES
SET decode = 'Foster Care Reimbursability Determination'
WHERE code_type = 'CEVNTTYP'
AND code = 'FCR';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (932, 'SacwisRev4', 'Release 4.1 - DBCR 16039');

commit;

