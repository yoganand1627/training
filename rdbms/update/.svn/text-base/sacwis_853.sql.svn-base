--STGAP00015937 - Release(3.6) New Index for RELATIONSHIP table

--Need an index to improve performance when deleting data based on the ID_RELATED_PERSON field.

create index caps.ind_relationship_2 on caps.relationship(ID_RELATED_PERSON) tablespace index01;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (854, 'SacwisRev3', 'Release 3.6 - DBCR 15937');

commit;


