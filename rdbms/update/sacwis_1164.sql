--STGAP00017649 - Release(5.0) Update Visitation Event Status from PEND to PROC

update caps.event set cd_event_status = 'PROC' where txt_event_descr='Visitation Plan' and cd_event_status='PEND';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1165, 'SacwisRev5', 'Release 5.0 - DBCR 17649');

commit;
