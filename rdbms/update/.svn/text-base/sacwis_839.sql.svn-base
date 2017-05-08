--STGAP00015917 - Release(3.6) MR-66: End date school personnel code

--Updates on 6/07/2010
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'SP';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (840, 'SacwisRev3', 'Release 3.6 - DBCR 15917');

commit;

