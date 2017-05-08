--STGAP00015893 - Release(Undetermined) Add column to Reports table to indicate batch

-- SMS# 49899 (Financial Exceptions report): add new column to recognize SHINES UDR report generated by batch.

alter table caps.reports add ind_shines_batch varchar2(1) null;

comment on column caps.reports.ind_shines_batch is 'Whether this report is generated by spring batch. It allows the report to remain in pickup list after being picked up by user. This column is best used with NM_RPT_TYPE to indicate an otherwise ordinary online report that is now scheduled by batch.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (817, 'SacwisRev3', 'Release Undetermined - DBCR 15893');

commit;

