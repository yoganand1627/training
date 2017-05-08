--STGAP00015931 - Release(3.6) MR-66: Re-Activate Foster Child codefor custody

update caps.codes_tables set dt_end = null Where code_type = 'CRPTRINT' and code = 'FO';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (848, 'SacwisRev3', 'Release 3.6 - DBCR 15931');

commit;


