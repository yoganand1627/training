-- All changes for version 2.4 of SHINES

-- change STGAP00007903
UPDATE CAPS.MESSAGE
SET txt_message = 'Family income must be less than $150,000 to qualify for enhanced relative care/guardianship subsidies.'
WHERE nbr_message = 60251
AND txt_message_name = 'MSG_FAM_INC_LESS_150';

-- change STGAP00007940
-- ORS Facility Type
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','441', 'Child Caring Institutions', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CORSOPFT','471', 'Child Care Unknown', sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (306, 'SacwisRev2', 'static table updates');                        
commit;

