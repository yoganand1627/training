----  DBCR  STGAP00017706
----  De-activating Monthly Family Management Report

update caps.reports set ind_rpt_page = 'N' where nm_rpt_sqr_name = 'MonthlyFamilyManagement' and nm_rpt_sqr_ver ='00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1170, 'SacwisRev5', 'Release 5.0 - DBCR 17706');

commit;