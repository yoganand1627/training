--STGAP00014917 - Fix column on stage table

alter table caps.ADO_NEW_NAME add DT_STAGE_CLOSE_TEMP date;
comment on column caps.ADO_NEW_NAME.DT_STAGE_CLOSE_TEMP is 'Holds the stage closure date' ;

alter table caps.stage drop column DT_STAGE_CLOSE_TEMP;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (504, 'SacwisRev3', 'Release 3.2 - DBCR 14917');

commit;


