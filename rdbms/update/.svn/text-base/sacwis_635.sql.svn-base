--STGAP00015633 - Release(3.4) SQR: Hide APPLA Exception report

-- Hide APPLA Exception Cases report since MR-057 which has changes supporting this report is being delayed past 3.4.

update caps.reports set ind_rpt_page = 'N' where nm_rpt_sqr_name = 'APPLAExceptionList' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (636, 'SacwisRev3', 'Release 3.4 - DBCR 15633');

commit;

