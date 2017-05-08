--STGAP00015334 - Add PERSON_ID to AFCARS table for AFCARS FC

ALTER TABLE CAPS.AFCARS ADD PERSON_ID number(16);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (529, 'SacwisRev3', 'Release 3.2 - DBCR 15334');

commit;


