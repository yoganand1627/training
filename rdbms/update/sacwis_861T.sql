--STGAP00015950 - MR-041 add new column in CLIENT_OUTBOUND

alter table SACWISIFC.CLIENT_OUTBOUND add ID_CLIENT_PREV NUMBER(16,0);

comment on column SACWISIFC.CLIENT_OUTBOUND.ID_CLIENT_PREV is 'SHINES Person Id of the existing, pre-adoptive child';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (862, 'SacwisRev4', 'Release 4.0 - DBCR 15950');

commit;


