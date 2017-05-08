--STGAP00015884 - Release(3.5) New Code into CodesTables for GAL Non Atty

--New code for CRPTRINT

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CRPTRINT', 'GY', 'GAL Non-Atty');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (811, 'SacwisRev3', 'Release 3.5 - DBCR 15884');

commit;


