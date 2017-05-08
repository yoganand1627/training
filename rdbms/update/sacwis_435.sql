--STGAP00012472 - Home Information - Need a new date field

alter table caps.home_applicant_info add (dt_applied date) ;
comment on column caps.home_applicant_info.dt_applied is 'Date of application';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (436, 'SacwisRev3', 'Release 3.0 - DBCR 12472');

commit;


