-- change STGAP00007124 

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CTITLEA','G1029','OCA',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CEMPJBCL','G1029','Office of Child Advocate',sysdate) ;

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CTITLEA','G1030','UM',sysdate) ;

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CEMPJBCL','G1030','Unit Manager',sysdate) ;

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CTITLEA','G1031','RAC',sysdate) ;

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CEMPJBCL','G1031','Regional Adoptions Coordinator',sysdate) ;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (279, 'SacwisRev2', 'codes tables - new job titles');                        
commit;

