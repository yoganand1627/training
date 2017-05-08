--STGAP00016153 - Release(4.3) Modify Edu Detail Rpt Launch Page Description

--Education detail report launch page description modification.
-- SMS # 94000

update caps.reports set nm_rpt_desc = 'A list of children (ages 5-17) in ONG stage open for 30 days or more and/or children (ages 5-20) in FCF in care for 30 days or more without an Education Detail page or page has not been updated in the past 12 months. Generated for optional Stage Type, Region, County
, Unit and Staff ID parameters.'
where nm_rpt_sqr_name = 'EducationDetail' and
nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1024, 'SacwisRev4', 'Release 4.3 - DBCR 16153');

commit;

