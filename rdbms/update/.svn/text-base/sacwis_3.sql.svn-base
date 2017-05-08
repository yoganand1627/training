insert all
   when not exists(select 'x' from caps.codes_tables where code_type='CRSRC' and code='VEH') then
into caps.codes_tables
select 'CRSRC', 'VEH', 'Vehicle', null, sysdate from dual ;
update caps.CODES_TABLES set DT_END = sysdate where CODE = 'MNL' and CODE_TYPE = 'CRSRC'; 
update caps.CODES_TABLES set DT_END = null where CODE = 'XXX' and CODE_TYPE = 'CRSRC'; 
update caps.CODES_TABLES set DECODE = 'Primary Residence' where CODE = 'HOM' and CODE_TYPE = 'CRSRC'; 
update caps.CODES_TABLES set DT_END = null where CODE = 'XXX' and CODE_TYPE = 'CINC'; 
update caps.CODES_TABLES set CODE = 'SSI Claim #' where CODE = 'SSN Claim #' and CODE_TYPE = 'CNUMTYPE'; 
commit;

{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('OPERATOR') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (4, 'SacwisRev1', 'Static table updates to codes_tables; recompile schemas for non-caps users.');
                         
commit;