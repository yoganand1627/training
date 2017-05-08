--STGAP00016011 - Release(4.0) Add CD_POP_FROM to CONTACT Table

--We need to add a 'CD_POP_FROM' field to the CONTACT table to keep up with contacts that are populated using the Mobile application.


alter table caps.contact add cd_pop_from varchar2(1);
comment on column caps.contact.cd_pop_from is 'Where is the Contact populated from? (i.e. Mobile)';

--backout
--alter table caps.contact drop column cd_pop_from;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (909, 'SacwisRev4', 'Release 4.1 - DBCR 16011');

commit;

