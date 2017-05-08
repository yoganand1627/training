
--STGAP00017205 - Release(5.0) Updating CodesType CLNCHAR2

-- Updating CLNCHAR2 for ECEM 5.0

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '199', 'Expectant Father', SYSDATE);

UPDATE CAPS.CODES_TABLES SET DECODE ='Infant Alcohol Addiction/Prenatal Alcohol Exposure/Fetal Alcohol Syndrome' WHERE code_type='CLNCHAR2' AND CODE='40';

UPDATE CAPS.CODES_TABLES SET DECODE ='Infant Drug Addiction/Prenatal Drug Exposed' WHERE code_type='CLNCHAR2' AND CODE='42';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1138, 'SacwisRev5', 'Release 5.0 - DBCR 17205');

--commit;

