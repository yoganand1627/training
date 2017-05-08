--STGAP00015689 - Release(3.5) Add new column to SVC_AUTH_DETAIL table

-- Add the following column to SVC_AUTH_DETAIL:   ID_SPC_NEEDS_DET decimal(16)

--it may be null, but if populated the value must be populated/reference a valid/existing  entry from the SPECIAL_NEEDS_DETERMINATION table

alter table caps.SERVICE_AUTHORIZATION drop column ID_SPC_NEEDS_DET;

alter table caps.SVC_AUTH_DETAIL add ID_SPC_NEEDS_DET number(16);
alter table caps.SVC_AUTH_DETAIL add constraint FK_SA_SPC_NEEDS_DET 
foreign key (id_spc_needs_det)
references caps.SPECIAL_NEEDS_DETERMINATION(id_event) enable;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (673, 'SacwisRev3', 'Release 3.5 - DBCR 15689');

commit;




