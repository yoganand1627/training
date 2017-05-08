--STGAP00017334 - Release(5.0) update decodes of person characteristics

update caps.codes_tables
set decode = 'Developmentally Delayed/Learning Disability'
where code_type = 'CCHRTCA1'
and code = 'DED1';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Tourette''s Disorder'
where CODE_TYPE = 'DED1'
and CODE = '141';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Asperger''s Disorder'
where CODE_TYPE = 'EBD1'
and CODE = '125';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Family Hx of Mental Retardation'
where CODE_TYPE = 'FHI2'
and CODE = '302';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Infant Alcohol Addiction/Prenatal Alcohol Exposed/Fetal Alcohol Syndrome'
where CODE_TYPE = 'MED1'
and CODE = '40';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Infant Drug Addiction/Prenatal Drug Exposed'
where CODE_TYPE = 'MED1'
and CODE = '42';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1147, 'SacwisRev5', 'Release 5.0 - DBCR 17334');

commit;

