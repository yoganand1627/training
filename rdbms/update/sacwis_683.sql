--STGAP00015708 - Release(3.5) Unhide APPLA Summary report

-- Unhide APPLA Summary report. Application development done and scheduled for 3.5 (3/29/2010)

update caps.reports set ind_rpt_page = 'Y' where nm_rpt_sqr_name = 'APPLASummary' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (684, 'SacwisRev3', 'Release 3.5 - DBCR 15708');

commit;

