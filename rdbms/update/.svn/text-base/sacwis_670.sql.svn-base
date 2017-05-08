--STGAP00015685 - Release(3.5) Add new column to SERVICE_AUTHORIZATION table

-- Add the following column to SERVICE_AUTHORIZATION:   ID_SPC_NEEDS_DET decimal(16)

--it may be null, but if populated the value must be populated/reference a valid/existing  entry from the SPECIAL_NEEDS_DETERMINATION table

alter table caps.SERVICE_AUTHORIZATION add ID_SPC_NEEDS_DET number(16);
alter table caps.SERVICE_AUTHORIZATION add constraint FK_SA_SPC_NEEDS_DET 
foreign key (id_spc_needs_det)
references caps.event(id_event) enable;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (671, 'SacwisRev3', 'Release 3.5 - DBCR 15685');

commit;



