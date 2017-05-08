--STGAP00015889 - Release(3.5) Insert new code for Near Fatality

--Per  SMS#48741 Add code for Near Fatality

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CSPECREQ', 'NF', 'Near Fatality');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (814, 'SacwisRev3', 'Release 3.5 - DBCR 15889');

commit;

