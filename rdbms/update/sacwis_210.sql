
-- change STGAP00004049

UPDATE CAPS.METAPHOR SET TXT_TAB='Intake Report Query' WHERE ID_TAB=120;

-- change STGAP00004062

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CSPECHND','RD','Relatives of DFCS Personnel',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CSPECHND','DP','DFCS Personnel',sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (211, 'SacwisRev2', 'static updates');                        
commit;