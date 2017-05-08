--STGAP00013494 - Per MR-033 Add new row to Codes_Tables

--Note:   no impact to ado conversion


--For  MR- 033 , per Invoice Detailed Design, add new CINVTYPE code

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES('CINVTYPE','RCS','Relative Care Subsidy',SYSDATE);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (462, 'SacwisRev3', 'Release 3.1 - DBCR 13494');

commit;


