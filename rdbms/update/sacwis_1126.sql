--STGAP00017147 - Release(5.0) ECEM Adding DBCR's For CLNCHAR2

-- Adding new verbiage changes for CLNCHAR2

UPDATE CAPS.CODES_TABLES SET DECODE = 'Allergies' WHERE CODE = '106' AND CODE_TYPE = 'CLNCHAR2';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Adoption Dissolution' WHERE CODE = '81' AND CODE_TYPE = 'CLNCHAR2';





--Hearing/Visual Impairment
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('FHI2', '300', 'Family Hx of Drug and Alcohol Abuse', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('FHI2', '301', 'Family Hx of Mental Illness', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('FHI2', '302', 'Family HX of Mental Retardation', null, SYSDATE);



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1127, 'SacwisRev5', 'Release 5.0 - DBCR 17147');

commit;
