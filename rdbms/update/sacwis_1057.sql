--STGAP00016258 - Release(Undetermined) 4.3.1 New Legal Status for Runaway

--This insert statement adds a new legal status choice to the options on the Legal Status Detail page. This value is "Not In DFCS Custody - Runaway" and is to be used for tracking discharges from care where the court has removed responsibility for DFCS to provide care to a child due to the child's pro
--longed status of runaway (placement). In response to this new field, we will update the AFCARS Foster Care program to map this new discharge status as instructed by ACF during their AFCARS review in June 2011.

insert into caps.codes_tables  (code_type, code, decode, dt_end, dt_last_update) values ('CLEGSTAT', 'NCR', 'Not In DFCS Custody - Runaway', '', sysdate);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1058, 'SacwisRev4', 'Release Undetermined - DBCR 16258');

commit;

