--STGAP00012866 - Need to grant access for new data type & function

--Note:   no impact to ado model


--Need to grant access to 2 new database objects from a prior dbcr to other application users:


grant execute on caps.to_string to operator,capson,capsbat,ops$datafix;
grant execute on caps.collection_char1 to operator,capson,capsbat,ops$datafix;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (447, 'SacwisRev3', 'Release 3.1 - DBCR 12866');

commit;


