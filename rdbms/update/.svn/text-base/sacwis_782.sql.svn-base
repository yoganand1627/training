--STGAP00015846 - Release(3.5) CAPTA - Admin Review End CARVSTAT - Approved

update CAPS.CODES_TABLES set DT_END = sysdate where CODE_TYPE = 'CARVSTAT' and CODE = '040';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (783, 'SacwisRev3', 'Release 3.5 - DBCR 15846');

commit;


