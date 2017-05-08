-- change STGAP00003405
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CEMPJBCL','14232','Treatment Services Supervisor',sysdate);

update caps.codes_tables
set decode = 'Treatment Services Specialist',
dt_end  = null
where code = '14231'
and code_type = 'CEMPJBCL';

-- change STGAP00003408
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','OA','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','APR','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','NLN','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','NLT','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','RTC','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','RPC','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','RGU','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','NLA','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','FCO','Y',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','UTL','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','COO','N',SYSDATE);
INSERT INTO caps.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CACLOSED','XXX','N',SYSDATE);

-- change STGAP00003409
insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0, sysdate, 60348, 'MSG_PUP_CLOSE', 'PUP services must be closed before closing the stage', '700','500','N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (193, 'SacwisRev2', 'static updates');
commit;
