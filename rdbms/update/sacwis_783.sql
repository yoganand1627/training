--STGAP00015847 - Release(3.5) Add years to CYEAR and CALENDAR

-- To be in consistence with Lenses system which currently has the high year is 2014. Update request per Bryant Jenkins. CYEAR is used in the online app to display the year. Calendar is used in SQR report to capture date parameter and populate it to the parameter table: report_work.

insert into caps.codes_tables values ('CYEAR', '13', '2013', null, sysdate);
insert into caps.codes_tables values ('CYEAR', '14', '2014', null, sysdate);

INSERT INTO CAPS.CALENDAR(MONTH_NAME, MONTH_NUMBER, YEAR_NUMBER)
SELECT DISTINCT C1.DECODE, C1.CODE, C2.DECODE FROM CAPS.CODES_TABLES C1, CAPS.CODES_TABLES C2
WHERE C1.CODE_TYPE = 'CMONTHS' AND C2.CODE_TYPE = 'CYEAR'
and C2.CODE IN ('13','14')
ORDER BY C2.DECODE, C1.CODE;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (784, 'SacwisRev3', 'Release 3.5 - DBCR 15847');

commit;


