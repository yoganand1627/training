--STGAP00015804 - Release(3.43) --MR-62: Add codes tables for Parent Role

--MR-62: Add codes tables for Parent Role
INSERT INTO CAPS.CODES_TABLES VALUES('CPARROLE', 'FAT', 'Father', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CPARROLE', 'MOT', 'Mother', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CPARROLE', 'CTK', 'Caretaker', NULL, SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (756, 'SacwisRev3', 'Release 3.43 - DBCR 15804');

commit;


