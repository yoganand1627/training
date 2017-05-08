--STGAP00018073 - Release(5.1) To activate the children 15/22 in FC w/o TPR or VS

-- To activate the report in system test with the modifications
-- DBCR STGAP00018073

update caps.reports set ind_rpt_page= 'Y' where nm_rpt_sqr_name ='FCChildrenWithoutTPR' and nm_rpt_sqr_ver = '00' ;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1216, 'SacwisRev5', 'Release 5.1 - DBCR 18073');

commit;
