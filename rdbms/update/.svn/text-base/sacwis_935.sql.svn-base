--STGAP00016044 - Release(4.1) MR-53 Add additional column drop 2 columns

--12/05/2010
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_STD_EARNED_INC_DEDUCT NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY drop column AMT_DEEM_LESS_TAX_DEP_OUT_HH;
alter table CAPS.FCE_ELIGIBILITY drop column AMT_DEEM_LESS_ALIM_CSUP_OUT_HH;

comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_STD_EARNED_INC_DEDUCT is 'The Deeming Responsible Individual(s) Standard Earned Income Deduction(s) given to the individual(s)' ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (936, 'SacwisRev4', 'Release 4.1 - DBCR 16044');

commit;


