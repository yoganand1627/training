--STGAP00016177 - Release(4.3) Adding column to incoming_detail table

--Adding policy violation indicator to incoming detail table.

alter table CAPS.INCOMING_DETAIL add IND_POLICY_VIOLATION VARCHAR2(1) null;

--backout
--alter table CAPS.INCOMING_DETAIL drop column IND_POLICY_VIOLATION ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1040, 'SacwisRev4', 'Release 4.3 - DBCR 16177');

commit;

