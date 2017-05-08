--change STGAP00007194
-- Reports: Cosmetics correction

UPDATE caps.reports SET NM_RPT_DESC= 'A detailed view of cases and stages that require conversion validation orgarnized by county, unit, and case manager. Generated for a specific county with optional case manager parameter.' 
WHERE NM_RPT_SQR_NAME = 'StageValidationDetail';

UPDATE caps.reports SET NM_RPT_DESC = 'A count of all TCM claims actually billed by program type (CPS, Safety Resource, Placement, and YPS). Generated for a specifc service month between two specified billing dates, with an optional region parameter.'
WHERE nm_rpt_sqr_name = 'TCMStatewideBillingCounts';

UPDATE caps.report_parameter SET TXT_RPT_PARM_TYPE = 'NUMBER' 
WHERE nm_rpt_sqr_name = 'StageValidationDetail' and nm_rpt_parm_name = 'STAFFID';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (282, 'SacwisRev2', 'Reporting Table Updates To Support Release 2.2');                        
commit;


