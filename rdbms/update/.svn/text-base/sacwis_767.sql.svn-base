--STGAP00015816 - Release(3.43) Case Watch new error code for Contact Standards

-- Add 2 error codes one for Foster Care stage (SUB and ADO); and one for ONG stage on stages missing Contact Standards (new page per MR-062)

insert into caps.codes_tables
values ('CCASEERR', 'CSF', 'No approved Contact Standard exists for this child.', null, sysdate);
insert into caps.codes_tables
values ('CCASEERR', 'CSO', 'No approved Contact Standard exists for this stage.', null, sysdate);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (768, 'SacwisRev3', 'Release 3.43 - DBCR 15816');

commit;

