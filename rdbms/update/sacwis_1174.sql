--STGAP00017780 - Release(5.01) DB Change Request for ClearQuest STGAP00017735

-- Per ClearQuest STGAP00017735 need to end date the CSVCRGNS_99 in codes_table and to add new code CSVCRGNS_97 for Out of State

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES('CSVCRGNS', '97', 'Out of State', sysdate);

UPDATE CAPS.CODES_TABLES SET DT_END = sysdate WHERE CODE_TYPE = 'CSVCRGNS' AND CODE = '99';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1175, 'SacwisRev5', 'Release 5.01 - DBCR 17780');

commit;
