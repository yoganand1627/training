-- change STGAP00006864
update caps.CODES_TABLES c
set c.DT_END = NULL
where CODE_TYPE = 'CPHNTYP'
and code = 'CP';

update caps.CODES_TABLES c
set c.DT_END = NULL
where CODE_TYPE = 'CPHNTYP'
and code = 'OC';

-- change STGAP00006870
update caps.CODES_TABLES c
set c.DECODE = 'Exceeds approved capacity'
where CODE_TYPE = 'CWPWRSN'
and code = 'PEL';

-- change STGAP00006893
update caps.codes_tables
set decode = 'Base WO'
where code = 'b'
and decode = 'Base'
and code_type = 'CRBPROGA';

update caps.codes_tables
set decode = 'Max WO'
where code = 'c'
and decode = 'MWO'
and code_type = 'CRBPROGA';

update caps.codes_tables
set decode = 'SBWO'
where code = 'd'
and decode = 'SSMD'
and code_type = 'CRBPROGA';

update caps.codes_tables
set decode = 'SMWO'
where code = 'e'
and decode = 'MSSMD'
and code_type = 'CRBPROGA';

update caps.codes_tables
set decode = 'SMFWO'
where code = 'f'
and decode = 'HMF'
and code_type = 'CRBPROGA';

-- change STGAP00006894
UPDATE CAPS.MESSAGE SET txt_message='Unless designated as Primary Caretaker, Alleged Maltreator must be at least 18 years old. Please make changes before saving.' 
WHERE txt_message_name='MSG_INT_SAVE_CPS_CHILD_AGE';

-- change STGAP00006905
UPDATE CAPS.MESSAGE SET txt_message='You have entered Status as Closed and must enter a value in the Change Of Status Reason section'
WHERE txt_message_name='MSG_CLS_NO_CLO_REASON';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (271, 'SacwisRev2', 'static table updates');                        
commit;

