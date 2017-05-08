--STGAP00012920 - Calendar static table

--Note:  no impact to ado model


--Need a calendar static table for the new cross-tab report Every Child Every Month. 
--This report will query all foster care kids (about 12K) and compute some counts for each month of up to 12 months in range.


CREATE TABLE CAPS.CALENDAR
(MONTH_NAME   VARCHAR2(9) NOT NULL,
 MONTH_NUMBER NUMBER(2) NOT NULL,
 YEAR_NUMBER  NUMBER(4) NOT NULL)
TABLESPACE DATA01;

grant select on caps.calendar to operator,capson,capsbat,ops$datafix;

INSERT INTO CAPS.CALENDAR(MONTH_NAME, MONTH_NUMBER, YEAR_NUMBER)
SELECT DISTINCT C1.DECODE, C1.CODE, C2.DECODE FROM CAPS.CODES_TABLES C1, CAPS.CODES_TABLES C2
WHERE C1.CODE_TYPE = 'CMONTHS' AND C2.CODE_TYPE = 'CYEAR' ORDER BY C2.DECODE, C1.CODE;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (448, 'SacwisRev3', 'Release 3.0 - DBCR 12920');

commit;


