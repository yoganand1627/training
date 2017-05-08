--STGAP00017435 - Release(5.0) Updating Other pages drop down for ECEM

-- updating dropdowns for Client chara and resource search page
Update CAPS.CODES_TABLES set DECODE = 'Family Hx of Mental Retardation'
where code_type = 'CLNCHAR2' and code = '302';

update CAPS.CODES_TABLES set DECODE = 'Infant Drug Addiction/Prenatal Drug Exposed'
where code_type = 'MED2' and code = '42';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1155, 'SacwisRev5', 'Release 5.0 - DBCR 17435');

commit;
