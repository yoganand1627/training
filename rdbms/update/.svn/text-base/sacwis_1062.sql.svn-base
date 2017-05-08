--STGAP00016973 - Release(5.0) Modification to My turn Now report description

--DBCR STGAP00016973
-- To modify the report desciption, orientation of the report
-- ClearQuest # STGAP00016534


update CAPS.reports
set txt_rpt_full_name = 'It''s My Turn Now Georgia Exception List',
nm_rpt_orientation = 'P' ,
nm_rpt_desc = 'A list of all children registered with the Adoption Exchange who are legally free for adoption. Generated for optional region and county parameters.'
where nm_rpt_sqr_name = 'MyTurnNowException' and nm_rpt_sqr_ver = '00';




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1063, 'SacwisRev5', 'Release 5.0 - DBCR 16973');

commit;
