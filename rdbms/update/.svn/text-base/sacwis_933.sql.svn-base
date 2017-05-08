--STGAP00016041 - Release(4.1) MR74-53 AFCARS ELIG: update removal rsn, message

-- MR-074 AFCARS: remapping removal reasons: new codes, update code, and end date code.
-- Child-related removal reason: new codes to replace child characteristics mapping to removal reason
insert into caps.codes_tables
values('CCREMRSN', 'CCA', 'Alcohol Abuse', null, sysdate);
insert into caps.codes_tables
values('CCREMRSN', 'CDA', 'Drug Abuse', null, sysdate);
insert into caps.codes_tables
values('CCREMRSN', 'CDI', 'Child''s Disability', null, sysdate);
insert into caps.codes_tables
values('CCREMRSN', 'CBP', 'Child''s Behavioral Problem', null, sysdate);

-- Parent-related removal reason
-- update decode
update caps.codes_tables
set decode = 'Sexual Abuse'
where code = 'SAR' and code_type = 'CREMFRHR';
update caps.codes_tables
set decode = 'Physical Abuse'
where code = 'PAR' and code_type = 'CREMFRHR';
-- end date code
update caps.codes_tables
set dt_end = sysdate
where code in ('EAR', 'MNR', 'NPR', 'NSR', 'PHR', 'TAB', 'TAC', 'TAD', 'TAA') and code_type = 'CREMFRHR';
-- new removal type - this is not actual removal, not reported to AFCARS
insert into caps.codes_tables
values('CREMT', 'ST', 'Short Term Emergency Care (Care up to 7 days)', null, sysdate);
-- Parent-related new removal reason: replace caretaker characteristics
insert into caps.codes_tables
values('CREMFRHR', 'ALC', 'Alcohol Abuse', null, sysdate);
insert into caps.codes_tables
values('CREMFRHR', 'DEA', 'Death', null, sysdate);
insert into caps.codes_tables
values('CREMFRHR', 'DRU', 'Drug Abuse', null, sysdate);
insert into caps.codes_tables
values('CREMFRHR', 'INA', 'Inadequate Housing', null, sysdate);
insert into caps.codes_tables
values('CREMFRHR', 'INC', 'Incarcerated ', null, sysdate);
insert into caps.codes_tables
values('CREMFRHR', 'UNA', 'Caretaker''s Inability to Cope Due to Illness or Other Reason', null, sysdate);
insert into caps.codes_tables
values('CREMFRHR', 'NEG', 'Neglect', null, sysdate);

update caps.message
set txt_message = 'Removal Reason must be selected for this type of removal.'
where txt_message_name = 'MSG_SEL_RMVL_REASON';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (934, 'SacwisRev4', 'Release 4.1 - DBCR 16041');

commit;



