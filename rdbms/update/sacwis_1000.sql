--STGAP00016119 - Release(4.2) Modify Edu Detail rpt launch page description

--Education detail report launch page description modification.
-- SMS # 94000
--STGAP00016119

update caps.reports set nm_rpt_desc = 'A list of children in FCF or ONG stage, of age 5 to 20 years who have been in care for 30 days or more after their 5th birthday with no Education Detail page or Education Detail page not updated for past 12 months. Generated for optional Stage Type, Region, County,
Unit and Staff ID parameters.'
where nm_rpt_sqr_name = 'EducationDetail' and
nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1001, 'SacwisRev4', 'Release 4.2 - DBCR 16119');

commit;

