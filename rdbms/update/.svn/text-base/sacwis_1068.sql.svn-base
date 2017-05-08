--STGAP00017022 - Release(5.0) Update Its My Turn Now GA Exc. List report name

-- Modification to Its My turn Now report name

--DBCR STGAP00017022
-- To modify the report name
-- ClearQuest # STGAP00017022


update CAPS.reports
set txt_rpt_full_name = 'Its My Turn Now Georgia Exception List'
where nm_rpt_sqr_name = 'MyTurnNowException' and nm_rpt_sqr_ver = '00';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1069, 'SacwisRev5', 'Release 5.0 - DBCR 17022');

commit;


