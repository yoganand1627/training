--STGAP00015529 - Add Debug parameter in BATCH_PARAMETERS for AFCARS

insert into caps.batch_parameters
 ( nm_batch_program, nm_batch_parameter, dt_param_effective, dt_param_expired, txt_parameter_value)
 values
 ('AFCADOJB', 'DEBUG', to_date('10/01/2009', 'MM/DD/YYYY'),     to_date('12/31/2020', 'MM/DD/YYYY'), 'false');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (574, 'SacwisRev3', 'Release 3.32 - DBCR 15529');

commit;

