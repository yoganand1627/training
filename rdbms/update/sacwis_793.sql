--STGAP00015857 - Release(3.5) changing column name for child death form

--Column name for newer forms should be ID_DOCUMENT_TEMPLATE not ID_DOCUMENT_TABLE

alter table CAPS.CHILD_DEATH_NARR DROP COLUMN ID_DOCUMENT_TABLE;

alter table CAPS.CHILD_DEATH_NARR ADD ID_DOCUMENT_TEMPLATE NUMBER (16);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (794, 'SacwisRev3', 'Release 3.5 - DBCR 15857');

commit;

