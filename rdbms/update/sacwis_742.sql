--STGAP00015784 - Release(3.42) Update Case Review Sample Batch Director Job

-- PER SMS #45491

grant select on CAPS.BATCH_JOB_QUERIES to operator;
/
declare
  dbcr CLOB;

begin
dbcr := 'select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''INV'' and rownum <=0)
UNION
select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''ONG'' and rownum <=4)
UNION
select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''DIV'' and rownum <=0)
UNION
select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage IN (''FCC'', ''ADO'') and rownum <=0)
group by a.cd_stage_region,a.county,a.nm_stage,a.cd_stage,a.id_stage,a.id_case,a.CNTYDIR_PERS_ID
order by 1,2,3,4,5,6';

update CAPS.BATCH_JOB_QUERIES set step_query=dbcr where ID=6;

end;
/




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (743, 'SacwisRev3', 'Release 3.42 - DBCR 15784');

commit;

