--STGAP00015599 - Release(3.4) Remove AFCARS_VIEW

--Remove AFCARS_VIEW as per Bryant Jenkins. This view is no longer needed.

DROP VIEW caps.AFCARS_VIEW;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (611, 'SacwisRev3', 'Release 3.4 - DBCR 15599');

commit;

