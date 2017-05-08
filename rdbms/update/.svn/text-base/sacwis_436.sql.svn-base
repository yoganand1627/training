-- STGAP00012538 - Need to revise index on EXCHANGE_CHILD

-- Note: No impact to conversion

DROP INDEX CAPS.IND_EXCHANGE_CHILD_PERSON;
CREATE INDEX CAPS.IND_EXCHANGE_CHILD_PERSON ON CAPS.EXCHANGE_CHILD (ID_PERSON, CD_NON_AVAIL_STATUS) TABLESPACE INDEX01 ;

create index caps.ind_person_upper_last_name on caps.person_enc (upper(NM_PERSON_LAST)) tablespace index01;

analyze table caps.person_enc compute statistics;

analyze index caps.ind_person_upper_last_name compute statistics;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (437, 'SacwisRev3', 'Release 3.0 - DBCR 12538');

commit;


