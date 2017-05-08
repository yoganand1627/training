--STGAP00015892 - Release(Undetermined) SQR: Update report name (Health Kenny A)

-- Per Colleen's request: change wording 'healthcheck' to 'heath check' on Children with Overdue Healthchecks (Kenny A) report

update caps.reports set txt_rpt_full_name = 'Children With Overdue Health Checks' ,
 nm_rpt_desc = 'A list of foster children in DFCS custody with overdue health check(s) or upcoming due in the next 60 calendar days. Generated for a specific county with optional unit and case manager parameters.'
where nm_rpt_sqr_name = 'ChildrenWithOverdueHealthchecks' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (816, 'SacwisRev3', 'Release Undetermined - DBCR 15892');

commit;



