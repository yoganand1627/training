--STGAP00015996 - Release(4.0) Add ERR Foster Care Rate Info

-- Insert rate values for Enhanced Relative Rate (SMS 64906)
    insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('54299', '005', 88.82, '06/30/2010', '07/01/2011');

       insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('54299', '612', 100.38, '06/30/2010', '07/01/2011');

     insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('54299', '13P', 114.36, '06/30/2010', '07/01/2011');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (901, 'SacwisRev4', 'Release 4.0 - DBCR 15996');

commit;



