
-- Standard Alter Table SQL

ALTER TABLE CAPS.SA_SAFETY_ASSESSMENT ADD TXT_ADDTNL_COMMENTS VARCHAR2(300)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

--change 140
update caps.codes_tables 
set dt_end = sysdate 
where code in ('24H','FVD','M24') 
and code_type = 'CPRIORTY'; 

insert into caps.codes_tables 
(code_type, code, decode, dt_last_update) 
values 
('CPRIORTY','5D','5 Days',sysdate); 

insert into caps.codes_tables 
(code_type, code, decode, dt_last_update) 
values 
('CPRIORTY','24','24 Hours',sysdate); 

insert into caps.codes_tables 
(code_type, code, decode, dt_last_update) 
values 
('CPRIORTY','IM','Immediate 24 Hrs',sysdate);

--change 142
insert into caps.codes_tables 
(code_type, code, decode, dt_last_update) 
values 
('CREGDIV','MBU','DFCS Medicaid Billing Unit', sysdate); 

insert into caps.codes_tables 
(code_type, code, decode, dt_last_update) 
values 
('CREGDIV','OCA','Office of the Child Advocate', sysdate); 

update caps.codes_tables 
set decode = 'Social Services Program Planning and Policy Development' 
where code = 'PPD' 
and code_type = 'CREGDIV';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (104, 'SacwisRev2', 'New field in SA_SAFETY_ASSESSMENT table, static updates');

commit;
