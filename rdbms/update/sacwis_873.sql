--STGAP00015968 - Release(4.0) MR-072 add constraint to new table CONTACT_DISCUSS

alter table CAPS.CONTACT_DISCUSSED_CBX add constraint FK_CONTACT_DISCUSSED_PERSON foreign key(id_discussed_person) references caps.person_enc(id_person);

-- BACKOUT
--alter table CAPS.CONTACT_DISCUSSED_CBX drop constraint FK_CONTACT_DISCUSSED_PERSON;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (874, 'SacwisRev4', 'Release 4.0 - DBCR 15968');

commit;

