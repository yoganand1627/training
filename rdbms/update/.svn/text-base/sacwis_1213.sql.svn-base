--STGAP00018030 - Release(5.1) To hide the FC children 15/22 from system test

--- To de-activate/hide  the report from system test
-- STGAP00018030

update caps.reports set ind_rpt_page= 'N' where nm_rpt_sqr_name ='FCChildrenWithoutTPR' and nm_rpt_sqr_ver = '00' ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1214, 'SacwisRev5', 'Release 5.1 - DBCR 18030');

commit;
