--STGAP00016173 - Release(4.2.1) Activate UDR FC Children Rpt

-- Activate Foster Care Children UDR Report
--  SMS 94015

Update caps.reports
 set ind_rpt_page = 'Y'
 where nm_rpt_sqr_name = 'UDRFosterCareChildrenRept';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1034, 'SacwisRev4', 'Release 4.2.1 - DBCR 16173');

commit;


