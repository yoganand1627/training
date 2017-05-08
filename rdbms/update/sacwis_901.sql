--STGAP00015998 - Release(4.0) Update dates for ERR Rate

-- Update the start/end dates for SMS 64906
-- Original DBCR STGAP00015996 had incorrect dates
         update caps.foster_care_rate fcr
         set fcr.dt_fcare_rt_start = '06/30/2010'
         where cd_fcare_rate_service = '54299';

         update caps.foster_care_rate fcr
         set fcr.dt_fcare_rt_end = '07/01/2011'
         where cd_fcare_rate_service = '54299';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (902, 'SacwisRev4', 'Release 4.0 - DBCR 15998');

commit;


