--STGAP00016096 - Release(4.2) Updating the report area name for FTMw/oParentalPa

update caps.reports set nm_rpt_area_type='Family Team Meetings'
where nm_rpt_sqr_name = 'FTMWithoutParentalParticipation'
and nm_rpt_sqr_ver =  '00';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (981, 'SacwisRev4', 'Release 4.2 - DBCR 16096');

commit;


