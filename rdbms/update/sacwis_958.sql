--STGAP00016072 - MR-53: Update Eligibility IND_REVIEW_CREATED

--2/2/2011
update caps.Eligibility set IND_REVIEW_CREATED = 'N'
where ID_ELIG_EVENT in 
(select l.ID_ELIG_EVENT from caps.ELIGIBILITY l, caps.event e, caps.stage s
where l.ID_ELIG_EVENT = e.ID_EVENT
and l.DT_ELIG_END = TO_DATE ('12/31/4712','MM/DD/YYYY') 
and l.IND_REVIEW_CREATED is null
and e.ID_EVENT_STAGE = s.ID_STAGE
and s.DT_STAGE_CLOSE is null
and s.CD_STAGE = 'SUB');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (959, 'SacwisRev4', 'Release 4.1.1 - DBCR 16072');

commit;

