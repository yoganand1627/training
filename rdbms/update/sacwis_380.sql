--STGAP00010148 - Change Field Name for Narr table   (2.7)


alter table caps.ado_asst_mem_narr rename column ID_DOCUMENT_TABLE to ID_DOCUMENT_TEMPLATE;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (381, 'SacwisRev2', 'Release 2.7 - DBCRs 10148');

commit;


