--STGAP00016077 - Release(4.1.1) MR-53: Nullout IND_REVIEW_CREATED for cnvrtd stage

--02/15/2011
update caps.Eligibility set IND_REVIEW_CREATED = NULL
where ID_ELIG_EVENT in
(select l.ID_ELIG_EVENT from caps.ELIGIBILITY l, caps.event e, caps.stage s
where l.ID_ELIG_EVENT = e.ID_EVENT
and l.DT_ELIG_END = TO_DATE ('12/31/4712','MM/DD/YYYY')
and l.IND_REVIEW_CREATED = 'N'
and l.ID_ELIG_EVENT in (8959934, 8962611, 10407106, 9405411, 9409235, 8962618)
and e.ID_EVENT_STAGE = s.ID_STAGE
and s.DT_STAGE_CLOSE is null
and s.CD_STAGE = 'SUB');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (963, 'SacwisRev4', 'Release 4.1.1 - DBCR 16077');

commit;

