--STGAP00016058 - Release(4.1) MR-053 Update task decode for Reimbursability

update caps.task
set txt_task_decode = 'Foster Care Reimbursability Determination'
where cd_task = '3440'
and txt_task_decode = 'Foster Care Review';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (950, 'SacwisRev4', 'Release 4.1 - DBCR 16058');

commit;


