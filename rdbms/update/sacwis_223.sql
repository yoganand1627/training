-- change STGAP00004456 revisited

-- The following indexes need to be rebuilt again:
alter index caps.ind_workload_1 rebuild;
alter index caps.ind_workload_2 rebuild;
alter index caps.ind_workload_3 rebuild;
alter index caps.ind_workload_4 rebuild;
alter index caps.UK_WORKLOAD rebuild;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (224, 'SacwisRev2', 'rebuild moved indexes'); 
commit;
