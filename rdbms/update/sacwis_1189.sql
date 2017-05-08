--STGAP00017856 - Release(5.1) STGAP00017827(MR-085) Increase column width

--MR-085 Increase size for column cd_icpc_form_type

alter table caps.icpc_detail modify (cd_icpc_form_type varchar2(4));

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1190, 'SacwisRev5', 'Release 5.1 - DBCR 17856');

commit;
