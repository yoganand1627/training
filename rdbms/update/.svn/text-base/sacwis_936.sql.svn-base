--STGAP00016045 - Release(4.1) MR-053 Update metaphor for Reimbursability

--MR-053 Update metaphor for Reimbursability

UPDATE caps.metaphor
set txt_tab = 'Reimbursability'
where txt_tab_constant = 'FC_REVIEW_APPLICATION_FOSTERCAREREVIEW'
and id_tab = 560;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (937, 'SacwisRev4', 'Release 4.1 - DBCR 16045');

commit;

