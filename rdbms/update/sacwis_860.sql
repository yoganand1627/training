--STGAP00015949 - Release(4.0) MR-068 Add new column and entry in codes table

alter table caps.fccp_family add cd_assgn_judge varchar2(20);

comment on column caps.fccp_family.CD_ASSGN_JUDGE is 'For Assigned Judge field to have value from Codes Table CJUDGES';

INSERT INTO CAPS.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC) VALUES ('CJUDGES', 'F', 'List of Judges');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (861, 'SacwisRev3', 'Release 4.0 - DBCR 15949');

commit;

