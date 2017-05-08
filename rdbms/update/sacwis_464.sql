--STGAP00013616 - Reports: standardize parameter name

-- Note: No impact to ado conversion

-- To make parameter name consistent since there is now other part of application is referencing it
-- For defect# STGAP00013472: Unauthorized access to Sensitive Cases through Reports are denied

update caps.report_parameter 
set nm_rpt_parm_name = 'CASEID'
where nm_rpt_sqr_name = 'IncomeResources' and nm_rpt_sqr_ver = '00' and nbr_rpt_parm_seq = 1;

update caps.report_parameter 
set nm_rpt_parm_name = 'PERSONID'
where nm_rpt_sqr_name = 'IncomeResources' and nm_rpt_sqr_ver = '00' and nbr_rpt_parm_seq = 2;

update caps.report_parameter 
set nm_rpt_parm_name = 'STAGEID'
where nm_rpt_sqr_name = 'PlacementLog' and nm_rpt_sqr_ver = '00' and nbr_rpt_parm_seq = 1;


--STGAP00013617 - Reports: Invoice to add parameters and cosmetics

--Note: No impact to ado conversion

-- Susan Morgan (Medicaid Billing Unit) requests 2 additional parameters: invoice type and phase. 
-- Use textbox length 3 for UAS Program code
-- Update Month labels to specify date format
-- Defect # STGAP00013607

update caps.report_parameter 
set nm_rpt_parm_label = 'Begin Month (MM/YYYY)'
where nm_rpt_sqr_name = 'InvoiceList' and nm_rpt_sqr_ver = '00' and nbr_rpt_parm_seq = 1;

update caps.report_parameter 
set nm_rpt_parm_label = 'End Month (MM/YYYY)'
where nm_rpt_sqr_name = 'InvoiceList' and nm_rpt_sqr_ver = '00' and nbr_rpt_parm_seq = 2;

update caps.report_parameter 
set nm_rpt_parm_name = 'CODE3'
where nm_rpt_sqr_name = 'InvoiceList' and nm_rpt_sqr_ver = '00' and nbr_rpt_parm_seq = 7;

update caps.reports
set nm_rpt_desc = 'A detailed view of invoices within a specific date range per client, resource and/or region. Generated for required begin and end month parameters, with at least one of the following client ID, resource ID, or region parameters, and optional county, UAS program, invoice type and phase parameters.'
where nm_rpt_sqr_name = 'InvoiceList' and nm_rpt_sqr_ver = '00';

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('InvoiceList', '00', 8, 3, 'INVTYPECD', 'CHAR', 'N', 'Invoice Type');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('InvoiceList', '00', 9, 3, 'INVPHASECD', 'CHAR', 'N', 'Invoice Phase');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (465, 'SacwisRev3', 'Release 3.02 - DBCRs 13616,13617');

commit;


