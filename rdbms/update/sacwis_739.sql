--STGAP00015783 - Release(3.5) Need to update the table name to follow naming con

--Need to update the table name to follow naming conventions.

alter table
  caps.RerateCompleteDateRange
rename to
   ADJ_COMP_DATE_RANGE;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (740, 'SacwisRev3', 'Release 3.5 - DBCR 15783');

commit;
 
