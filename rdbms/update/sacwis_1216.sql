--STGAP00018076 - Release(5.2) Codes_Tables update - Region Restructuring

--Update codes_tables to end date regions 16 and 17
--Remap codes_tables for new county/region assignment
--For MR 105: STGAP00018067
--4/13/12 htvo: remove the update on codes tables CSECATTR. This change is not complete and needs to be reviewed. New resolution may be needed.

update caps.codes_tables set dt_end = sysdate
where code_type in ('CREGIONS','CSVCRGNS','CREGOFF')
and code in ('16','17');

Update CAPS.codes_tables set dt_end = sysdate
where code_type = 'CREGDIV' and code in ('016','017');

--Update CAPS.codes_tables set dt_end = sysdate
--where code_type = 'CSECATTR' and code in ('DM','DN');


Update CAPS.codes_tables set decode = '01'
where code_type = 'CCNTYREG' and code = '129';

Update CAPS.codes_tables set decode = '09'
where code_type = 'CCNTYREG' and code = '235';

Update CAPS.codes_tables set decode = '14'
where code_type = 'CCNTYREG' and code = '121';

Update CAPS.codes_tables set decode = '13'
where code_type = 'CCNTYREG' and code = '247';

Update CAPS.codes_tables set decode = '13'
where code_type = 'CCNTYREG' and code = '063';

Update CAPS.codes_tables set decode = '04'
where code_type = 'CCNTYREG' and code = '113';

Update CAPS.codes_tables set decode = '13'
where code_type = 'CCNTYREG' and code = '151';

Update CAPS.codes_tables set decode = '03'
where code_type = 'CCNTYREG' and code = '057';

Update CAPS.codes_tables set decode = '03'
where code_type = 'CCNTYREG' and code = '097';

Update CAPS.codes_tables set decode = '15'
where code_type = 'CCNTYREG' and code = '067';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1217, 'SacwisRev5', 'Release 5.2 - DBCR 18076');

commit;
