--STGAP00015932 - Release(3.6) Create Indexes for all Foreign Keys

--Some tables have foreign keys which are referencing fields that are not indexed.  To improve performance (and minimize the time a table is locked during an update), this dbcr is creating indexes for the foriegn keys.

-- NOTE:  These indexes are not being applied to the training environments because the training environments do not have performance issues and the new indexes would have a significant impact on the disk space requirements in the training database.
insert into caps.schema_version(id_schema_version,application_version,comments)
            values (850, 'SacwisRev3', 'Release 3.6 - DBCR 15932');

commit;

