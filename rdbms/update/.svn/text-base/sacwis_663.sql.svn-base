--STGAP00015677 - Release(3.41) Increase column size in Delvrd_svc_dtl table

--Need to alter the size of the field AMT_SVC_DTL_UNIT_RATE from NUMBER(6,2) to NUMBER(7,2).

alter table caps.delvrd_svc_dtl modify AMT_SVC_DTL_UNIT_RATE number(7,2);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (664, 'SacwisRev3', 'Release 3.41 - DBCR 15677');

commit;

