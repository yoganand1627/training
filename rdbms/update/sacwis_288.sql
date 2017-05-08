-- All changes for version 2.21 of SHINES

-- change STGAP00007393
-- ValidationStatus report: per STGAP00007390: requested by user (Loudermilk)
update caps.report_parameter set nbr_rpt_parm_seq = 2 where nm_rpt_sqr_name = 'ValidationStatus' and nm_rpt_parm_name = 'REGIONCD';
insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ValidationStatus', '00', 1, 1, 'PHASENBR', 'NUMBER', 'Y', 'Phase');

-- change STGAP00007402
UPDATE caps.REPORTS
SET nm_rpt_area_type = 'Foster Care'
WHERE nm_rpt_sqr_name = 'FosterCareMonthlyStatus' OR nm_rpt_area_type = 'Placement';

UPDATE caps.REPORTS
SET nm_rpt_area_type = 'Intake'
WHERE nm_rpt_sqr_name = 'IntakeMonthlyStatistics';

UPDATE caps.REPORTS
SET nm_rpt_area_type = 'Investigations'
WHERE nm_rpt_sqr_name IN ('InvestigationMonthlyStatistics','InvestigationMonthlyStatus');

-- change STGAP00007417
UPDATE caps.reports
SET ind_rpt_page = 'Y'
WHERE nm_rpt_sqr_name = 'TCMMonthlyBillingStatistics';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (289, 'SacwisRev2', 'static table updates');                        

commit;

