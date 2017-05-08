--STGAP00015575 - Release(3.32) MR-058 Setting dates to dt_review

update caps.case_review cr
set cr.dt_staffed_with_worker = cr.dt_review
where  cr.dt_staffed_with_worker < cr.dt_review
and exists (select 'x' from caps.event e where e.id_event = cr.id_csr_event
            and e.cd_event_status = 'COMP');

update caps.case_review cr
set cr.dt_correction_due = cr.dt_review
where  cr.dt_correction_due < cr.dt_review
and exists (select 'x' from caps.event e where e.id_event = cr.id_csr_event
            and e.cd_event_status = 'COMP');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (595, 'SacwisRev3', 'Release 3.32 - DBCR 15575');

commit;

