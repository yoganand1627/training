--STGAP00017123 - Release(5.0) MR-092:Update column to 5 chars for codestable

ALTER TABLE CAPS.aa_funding_reason_elig MODIFY CD_AA_FUNDING_RSN Varchar2(5);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1109, 'SacwisRev5', 'Release 5.0 - DBCR 17123');

commit;
