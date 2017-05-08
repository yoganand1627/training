--STGAP00015542 - MR-058 Case Review Extend length of text areas

alter table caps.case_review modify TXT_SUMMARY_COMMENT varchar2(4000);

alter table caps.case_review_item modify TXT_COMMENTS varchar2(4000);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (578, 'SacwisRev3', 'Release 3.32 - DBCR 15542');

commit;

