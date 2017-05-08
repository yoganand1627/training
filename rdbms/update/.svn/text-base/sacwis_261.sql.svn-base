-- Update Views SQL

CREATE OR REPLACE VIEW CAPS.CATTEMP AS
SELECT CODE, DECODE, DT_END
FROM CODES_TABLES
WHERE CODE_TYPE='CATTEMP'
;

grant select,insert,update,delete on CAPS.CATTEMP to capson, capsbat;
grant select on CAPS.CATTEMP to operator;

CREATE OR REPLACE VIEW CAPS.CRMRSNAC AS
SELECT CODE, DECODE, DT_END
FROM CODES_TABLES
WHERE CODE_TYPE='CRMRSNAC'
;

grant select,insert,update,delete on CAPS.CRMRSNAC to capson, capsbat;
grant select on CAPS.CRMRSNAC to operator;

CREATE OR REPLACE VIEW CAPS.CTMPLTYP AS
SELECT CODE, DECODE, DT_END
FROM CODES_TABLES
WHERE CODE_TYPE='CTMPLTYP'
;

grant select,insert,update,delete on CAPS.CTMPLTYP to capson, capsbat;
grant select on CAPS.CTMPLTYP to operator;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                       values (262, 'SacwisRev2', 'three new codes_tables views');
commit;
