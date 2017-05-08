--STGAP00015143 - Remove unneeded objects

drop index CAPS.IND_HOME_ETHNICITY_1;
drop index CAPS.IND_HOME_RACE_1;
-- Remove the drop table from the Training script
-- drop table CAPS.CNV_RBWO;
alter table CAPS.ADOPTION_SUBSIDY drop column ID_SPECIAL_NEEDS_DETER;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (515, 'SacwisRev3', 'Release 3.2 - DBCR 15143');

commit;


