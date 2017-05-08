-- STGAP00012699 - Index Change to support Child Searches

drop index caps.ind_legal_status_1;                                  
create index caps.ind_legal_status_1 on caps.legal_status(id_person,dt_legal_stat_status_dt) tablespace index01;
analyze table caps.legal_status compute statistics;
analyze index caps.ind_legal_status_1 compute statistics;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (441, 'SacwisRev3', 'Release 3.0 - DBCRs 12699');

commit;


