--STGAP00017302 - Release(5.0) Creating DBCR to correct decoded values Fa home

-- ECEM 5.0 Dropdown verbiage changes

UPDATE CAPS.CODES_TABLES SET DECODE = 'Tourette''s Disorder' where CODE_TYPE = 'DED2' and CODE = '141';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Asperger''s Disorder' where CODE_TYPE = 'EBD2' and CODE = '125';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Family Hx of Mental Retardation' where CODE_TYPE = 'FHI2' and CODE = '302';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Infant Alcohol Addiction/Prenatal Alcohol Exposed/Fetal Alcohol Syndrome' where CODE_TYPE = 'MED2' and CODE = '40';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1145, 'SacwisRev5', 'Release 5.0 - DBCR 17302');

commit;
