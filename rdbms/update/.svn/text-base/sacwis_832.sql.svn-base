--STGAP00015910 - Release(3.6) MR-66: Add column to Allegation (INT, INV)

alter table CAPS.INTAKE_ALLEGATION add (IND_MALTREAT_IN_CARE VARCHAR2 (1));
alter table CAPS.ALLEGATION add (IND_MALTREAT_IN_CARE VARCHAR2 (1));


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (833, 'SacwisRev3', 'Release 3.6 - DBCR 15910');

commit;

