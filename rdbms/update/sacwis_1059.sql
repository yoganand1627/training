--STGAP00016276 - Release(4.3) FORG Batch Job Enhancement

--To Accommodate new changes requested by susane Denny

grant select on caps.stage to operator;

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
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''ONG'' and rownum <=0)
UNION
select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''DIV'' and rownum <=5)
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
            values (1060, 'SacwisRev4', 'Release 4.3 - DBCR 16276');

commit;



