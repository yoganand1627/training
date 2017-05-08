--STGAP00015653 - Release(3.5) Per 40959: Delete rows from Home_Race table

--Per SMS#40959, Need to delete records from Home_Race table for cd_race = 'NH'
--This will prevent NH checkbox being displayed on the ExchangeHomeDetail page under Child Race --Preferences section.

DELETE FROM caps.home_race  WHERE cd_race = 'NH';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (650, 'SacwisRev3', 'Release 3.5 - DBCR 15653');

commit;

