--STGAP00016172 - Release(4.3) Update BATCH_JOB_QUERIES for CAPTA FORG req.

--Update BATCH_JOB_QUERIES for CAPTA FORG req.

grant select on caps.stage to operator;
/
declare
dbcr CLOB;
begin
dbcr := 'select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''INV'' and rownum <=1)
UNION
select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''ONG'' and rownum <=1)
UNION
select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage = ''DIV'' and rownum <=2)
UNION
select a.* from CAPS.director_sampling a
where a.rowid in(
select rowid from CAPS.director_sampling c where
c.CNTYDIR_PERS_ID=a.CNTYDIR_PERS_ID and c.cd_stage IN (''FCC'', ''ADO'') and rownum <=1)
group by a.cd_stage_region,a.county,a.nm_stage,a.cd_stage,a.id_stage,a.id_case,a.CNTYDIR_PERS_ID
order by 1,2,3,4,5,6';

update CAPS.BATCH_JOB_QUERIES set step_query=dbcr where ID=6;

end;
/


/
declare
dbcr CLOB;
begin
dbcr := 'insert into CAPS.director_sampling (CD_STAGE_REGION, COUNTY, NM_STAGE, CD_STAGE, ID_STAGE, ID_CASE, CNTYDIR_PERS_ID)
select CD_STAGE_REGION, County, NM_STAGE, CD_STAGE, ID_STAGE, ID_CASE, CNTYDIR_PERS_ID from (
select stage.CD_STAGE_REGION, ccount.DECODE as County, stage.NM_STAGE, stage.CD_STAGE, stage.ID_STAGE, stage.ID_CASE, CCNTYDIR.DECODE as CNTYDIR_PERS_ID
from CAPS.incoming_detail, CAPS.stage, CAPS.ccount, CAPS.CODES_TABLES CCNTYDIR
where incoming_detail.ID_STAGE = stage.ID_STAGE
and stage.dt_stage_start < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
and (stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'') or stage.dt_stage_close is null)
and ccount.CODE = stage.CD_STAGE_CNTY
and stage.ID_CASE is not null
and incoming_detail.CD_NON_RSDNT_REQ_TYPE is null
and CCNTYDIR.CODE_TYPE = ''CCNTYDIR''
and CCNTYDIR.CODE = stage.CD_STAGE_CNTY
and
(
  not exists ( select * from CAPS.case_review
          where case_review.id_stage = stage.id_stage
          and case_review.ind_complete = ''Y''
          and case_review.CD_BATCH_SAMPLE_TYPE is not null
          and TO_DATE(?, ''MM/YYYY'') <= ADD_MONTHS(TO_DATE(case_review.REVIEW_PERIOD, ''MM/YYYY''),6)
        )
)

UNION


select stage.CD_STAGE_REGION, ccount.DECODE as County, stage.NM_STAGE, stage.CD_STAGE, stage.ID_STAGE, stage.ID_CASE, CCNTYDIR.DECODE as CNTYDIR_PERS_ID
from CAPS.cps_invst_detail, CAPS.stage, CAPS.ccount, CAPS.CODES_TABLES CCNTYDIR
where cps_invst_detail.ID_CPS_INVST_STAGE = stage.ID_STAGE
and ccount.CODE = stage.CD_STAGE_CNTY
and CCNTYDIR.CODE_TYPE = ''CCNTYDIR''
and CCNTYDIR.CODE = stage.CD_STAGE_CNTY
and
( (
     stage.dt_stage_close < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
     and stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'')
   )
  or
   (
    exists ( select *
             from CAPS.stage_link
             where stage_link.ID_PRIOR_STAGE = stage.ID_STAGE
             and stage.DT_STAGE_CLOSE is null
           )
   )
)
and
(
  not exists ( select * from CAPS.case_review
          where case_review.id_stage = stage.id_stage
          and case_review.ind_complete = ''Y''
          and case_review.CD_BATCH_SAMPLE_TYPE is not null
          and TO_DATE(?, ''MM/YYYY'') <= ADD_MONTHS(TO_DATE(case_review.REVIEW_PERIOD, ''MM/YYYY''),6)
        )
)

UNION


select stage.CD_STAGE_REGION, ccount.DECODE as County, stage.NM_STAGE, decode(stage.CD_STAGE, ''FPR'',''ONG'',stage.CD_STAGE), stage.ID_STAGE, stage.ID_CASE, CCNTYDIR.DECODE as CNTYDIR_PERS_ID
from CAPS.stage, CAPS.ccount, CAPS.CODES_TABLES CCNTYDIR
where stage.CD_STAGE = ''FPR''
and ccount.CODE = stage.CD_STAGE_CNTY
and CCNTYDIR.CODE_TYPE = ''CCNTYDIR''
and CCNTYDIR.CODE = stage.CD_STAGE_CNTY
and
( (
     stage.dt_stage_close < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
     and stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'')
   )
  or
   (
     (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1) - stage.DT_STAGE_START >= 60
     and stage.DT_STAGE_CLOSE is null

   )
)
and
(
  not exists ( select * from CAPS.case_review
          where case_review.id_stage = stage.id_stage
          and case_review.ind_complete = ''Y''
          and case_review.CD_BATCH_SAMPLE_TYPE is not null
          and TO_DATE(?, ''MM/YYYY'') <= ADD_MONTHS(TO_DATE(case_review.REVIEW_PERIOD, ''MM/YYYY''),6)
        )
)

UNION


select stage.CD_STAGE_REGION, ccount.DECODE as County, stage.NM_STAGE, stage.CD_STAGE, stage.ID_STAGE, stage.ID_CASE, CCNTYDIR.DECODE as CNTYDIR_PERS_ID
from CAPS.stage, CAPS.ccount, CAPS.CODES_TABLES CCNTYDIR
where stage.CD_STAGE = ''DIV''
and stage.dt_stage_close < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
and stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'')
and ccount.CODE = stage.CD_STAGE_CNTY
and CCNTYDIR.CODE_TYPE = ''CCNTYDIR''
and CCNTYDIR.CODE = stage.CD_STAGE_CNTY
and
(
  not exists ( select * from CAPS.case_review
          where case_review.id_stage = stage.id_stage
          and case_review.ind_complete = ''Y''
          and case_review.CD_BATCH_SAMPLE_TYPE is not null
          and TO_DATE(?, ''MM/YYYY'') <= ADD_MONTHS(TO_DATE(case_review.REVIEW_PERIOD, ''MM/YYYY''),6)
        )
)

UNION


select stage.CD_STAGE_REGION, ccount.DECODE as County, stage.NM_STAGE,
decode(stage.CD_STAGE, ''SUB'',''FCC'',stage.CD_STAGE), stage.ID_STAGE, stage.ID_CASE, CCNTYDIR.DECODE as CNTYDIR_PERS_ID
from CAPS.stage,
CAPS.legal_status_view,
CAPS.CODES_TABLES CCNTYDIR,
CAPS.stage_person_link spl_primary_child,


 ( select cnsrvtrshp_removal.ID_VICTIM, cnsrvtrshp_removal.ID_CASE, max(cnsrvtrshp_removal.DT_REMOVAL) as dt_removal
    from CAPS.cnsrvtrshp_removal
    where cnsrvtrshp_removal.DT_REMOVAL < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
    group by cnsrvtrshp_removal.ID_VICTIM, cnsrvtrshp_removal.ID_CASE
 ) latest_removal,
 CAPS.unit, CAPS.person supervisor, CAPS.person case_manager, CAPS.stage_person_link, CAPS.ccount

where stage.DT_STAGE_CLOSE is null
and stage.CD_STAGE IN (''SUB'',''ADO'')
and legal_status_view.IN_DFCS_CUSTODY = ''Y''
and legal_status_view.DT_LEGAL_STAT_STATUS_DT < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
and legal_status_view.DT_LEGAL_STAT_END >= LAST_DAY(TO_DATE(?, ''MM/YYYY''))
and (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1) - latest_removal.DT_REMOVAL >= 60
and stage.ID_STAGE = spl_primary_child.ID_STAGE
and spl_primary_child.CD_STAGE_PERS_ROLE IN (''PC'')
and spl_primary_child.ID_PERSON = latest_removal.ID_VICTIM
and spl_primary_child.ID_CASE = latest_removal.id_case
and spl_primary_child.ID_PERSON = legal_status_view.ID_PERSON
and spl_primary_child.ID_CASE = legal_status_view.ID_CASE

and stage.ID_UNIT = unit.ID_UNIT
and unit.ID_PERSON = supervisor.ID_PERSON
and stage.ID_STAGE = stage_person_link.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN (''PR'',''HP'')
and stage_person_link.ID_PERSON = case_manager.ID_PERSON
and unit.CD_COUNTY = ccount.CODE
and CCNTYDIR.CODE_TYPE = ''CCNTYDIR''
and CCNTYDIR.CODE = stage.CD_STAGE_CNTY
and not exists ( select *
                     from caps.case_review,
                     caps.stage cr_stage,
                     caps.stage_person_link cr_stage_person_link
                      where case_review.ID_CASE = stage.ID_CASE --this is a join to the outer query by case id
                      and cr_stage_person_link.ID_PERSON = spl_primary_child.ID_PERSON --this is a join to the outer query by person id of FC
                      and cr_stage.ID_STAGE = cr_stage_person_link.ID_STAGE
                      and cr_stage_person_link.cd_stage_pers_role = ''PC''
                      and case_review.ID_STAGE = cr_stage.ID_STAGE
                      and cr_stage.CD_STAGE IN (''SUB'',''ADO'')
                      and case_review.ind_complete = ''Y''
                      and case_review.CD_BATCH_SAMPLE_TYPE is not null -- means either county or supervisor sample
                      and TO_DATE(?, ''MM/YYYY'') <= ADD_MONTHS(TO_DATE(case_review.REVIEW_PERIOD, ''MM/YYYY''),6)
                  )
) ORDER BY DBMS_RANDOM.value';

update CAPS.BATCH_JOB_QUERIES set step_query=dbcr where ID=5;

end;
/



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1036, 'SacwisRev4', 'Release 4.3 - DBCR 16172');

commit;



