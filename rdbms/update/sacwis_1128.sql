--STGAP00017150 - Release(5.0) create new codes

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('FHI1', '300', 'Family Hx of Drug and Alcohol Abuse', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('FHI1', '301', 'Family Hx of Mental Illness', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('FHI1', '302', 'Family HX of Mental Retardation', null, SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1129, 'SacwisRev5', 'Release 5.0 - DBCR 17150');

commit;
