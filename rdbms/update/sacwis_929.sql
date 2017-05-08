--STGAP00016037 - Release(4.1) MR-53 Add additional Alloc and SON columns

--12/01/2010
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_PERSON_ALLOC_SNGL_1 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_PERSON_ALLOC_MUTUAL NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_PERSON_ALLOC_SNGL_2 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_EARNED_LESS_STD_DEDUCT NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_EARNED_LESS_ALL_DEDUCT NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_NET_EARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_NET_EARNED_INCOME_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add CD_STD_TEST_SURP_DEFCT VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add CD_ELIG_SURP_DEFCT_CRTFD_GRP VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add CD_ELIG_SURP_DEFCT_CHILD VARCHAR2(3) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME_LESS_30 NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME_LESS_THIRD NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_GROSS_UNEARNED_INCOME NUMBER(16,2) null;



comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_PERSON_ALLOC_SNGL_1 is 'Multi-purpose column used to record the number of ineligible person(s) to whom money can be allocated for a single parent, multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_PERSON_ALLOC_MUTUAL is 'Multi-purpose column used to record the number of ineligible person(s) to whom money can be allocated for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_PERSON_ALLOC_SNGL_2 is 'Multi-purpose column used to record the number of ineligible person(s) to whom money can be allocated for multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_EARNED_LESS_STD_DEDUCT is 'The Gross Earned Income less the total Standard Earned Income Deduction of the Certified Group for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_EARNED_LESS_ALL_DEDUCT is 'The Gross Earned Income less the total Earned Income Deductions, including the 30 1/3, of the Certified Group for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_NET_EARNED_INCOME is 'The Net Earned Income of the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_NET_EARNED_INCOME is 'The Net Earned Income of the Child';
comment on column CAPS.FCE_ELIGIBILITY.CD_STD_TEST_SURP_DEFCT is 'Indicates whether there''s a surplus or deficit for the Standard of Need Test' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_ELIG_SURP_DEFCT_CRTFD_GRP is 'Indicates whether there''s a surplus or deficit in the AFDC Eligibility Test' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_ELIG_SURP_DEFCT_CHILD is 'Indicates whether there''s a surplus or deficit in the IV-E Eligibility Test' ;
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_30 is 'The $30 deduction given to the eligible person with earned income';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_THIRD is 'The 1/3 deduction for the eligible person with earned income';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_LESS_30 is 'The Countable Income of the person less $30';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_LESS_THIRD is 'The Countable Income of the person less $30 less 1/3 deduction';
comment on column CAPS.FCE_PERSON.AMT_GROSS_UNEARNED_INCOME is 'The Gross Unearned Income of the person';
comment on column CAPS.FCE_PERSON.AMT_GROSS_EARNED_INCOME is 'The Gross Earned Income of the person';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (930, 'SacwisRev4', 'Release 4.1 - DBCR 16037');

commit;




