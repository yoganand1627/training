--STGAP00015703 - Release(3.5) Unhide APPLA Exception report

-- Unhide APPLA Exception Cases report. Application development done and scheduled for 3.5 (3/29/2010)

update caps.reports set ind_rpt_page = 'Y' where nm_rpt_sqr_name = 'APPLAExceptionList' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (683, 'SacwisRev3', 'Release 3.5 - DBCR 15703');

commit;


