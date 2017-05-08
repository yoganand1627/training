--STGAP00016022 - Release(4.1) MR-53 Elig Add new columns, messages and codes

--Per MR-053 Eligibility: Application and Background add columns
alter table CAPS.FCE_APPLICATION add IND_AMENDED_APP VARCHAR2(1) null;

comment on column CAPS.FCE_APPLICATION.IND_AMENDED_APP is 'Indicates if the Application is an Amended Application' ; 

 

--Per MR-053 Eligibility: Income and Expenditures and Worksheet add Allocation columns
alter table CAPS.FCE_ELIGIBILITY add CD_ALLOC_TYPE VARCHAR2(4) null;
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_SNGL_1 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_SPOUSE_ALLOC_SNGL_1 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_CHILD_ALLOC_SNGL_1 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_STD_OF_NEED_ALLOC_SNGL_1 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_ALLOC_SNGL_1 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_ALLOC_ALLOWANCE_SNGL_1 NUMBER(16,2) null;

alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_MUTUAL_1 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_MUTUAL_2 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_SPOUSE_ALLOC_MUTUAL NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_CHILD_ALLOC_MUTUAL NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_STD_OF_NEED_ALLOC_MUTUAL NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_ALLOC_MUTUAL NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_ALLOC_ALLOWANCE_MUTUAL NUMBER(16,2) null;

alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_SNGL_2 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_SPOUSE_ALLOC_SNGL_2 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_CHILD_ALLOC_SNGL_2 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_STD_OF_NEED_ALLOC_SNGL_2 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_ALLOC_SNGL_2 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_ALLOC_ALLOWANCE_SNGL_2 NUMBER(16,2) null;

comment on column CAPS.FCE_ELIGIBILITY.CD_ALLOC_TYPE is 'Indicates the Allocation type' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_SNGL_1 is 'Multi-purpose column used to record the AU member responsible for allocating money out of the assistance unit for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_SPOUSE_ALLOC_SNGL_1 is 'Multi-purpose column used to record the number of ineligible spouse(s) for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_CHILD_ALLOC_SNGL_1 is 'Multi-purpose column used to record the number of ineligible children(en) for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_STD_OF_NEED_ALLOC_SNGL_1 is 'Multi-purpose column used to record the Standard of Need for the # of persons to whom AU member''s income can be allocated for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_ALLOC_SNGL_1 is 'Multi-purpose column used to record the Gross Income of the AU member responsible for allocating money for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_ALLOC_ALLOWANCE_SNGL_1 is 'Multi-purpose column used to record the allocated amount allowed for a single parent, multiple parents or mutual/multiple allocation types' ;

comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_MUTUAL_1 is 'Multi-purpose column used to record one of the AU member responsible for allocating money out of the assistance unit for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_MUTUAL_2 is 'Multi-purpose column used to record the other AU member responsible for allocating money out of the assistance unit for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_SPOUSE_ALLOC_MUTUAL is 'Multi-purpose column used to record the number of ineligible spouse(s) for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_CHILD_ALLOC_MUTUAL is 'Multi-purpose column used to record the number of ineligible children(en) for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_STD_OF_NEED_ALLOC_MUTUAL is 'Multi-purpose column used to record the Standard of Need for the # of persons to whom AU member''s income can be allocated for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_ALLOC_MUTUAL is 'Multi-purpose column used to record the Gross Income of the AU member(s) responsible for allocating money for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_ALLOC_ALLOWANCE_MUTUAL is 'Multi-purpose column used to record the allocated amount allowed for a mutual parents, mutual/single or mutual/multiple allocation types' ;

comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_SNGL_2 is 'Multi-purpose column used to record the AU member responsible for allocating money out of the assistance unit for a multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_SPOUSE_ALLOC_SNGL_2 is 'Multi-purpose column used to record the number of ineligible spouse(s) for a multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_CHILD_ALLOC_SNGL_2 is 'Multi-purpose column used to record the number of ineligible children(en) for a multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_STD_OF_NEED_ALLOC_SNGL_2 is 'Multi-purpose column used to record the Standard of Need for the # of persons to whom AU member''s income can be allocated for multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_ALLOC_SNGL_2 is 'Multi-purpose column used to record the Gross Income of the AU member responsible for allocating money for multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_ALLOC_ALLOWANCE_SNGL_2 is 'Multi-purpose column used to record the allocated amount allowed for multiple parents, mutual/single or mutual/multiple allocation types' ;


--Per MR-053 Eligibility: Income and Expenditures and Worksheet add Deeming columns
alter table CAPS.FCE_ELIGIBILITY add IND_DEEM_RESP_TYPE VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add CD_DEEM_INDIV_REL_1 VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_DEEM_INDIV_1 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add CD_DEEM_INDIV_REL_2 VARCHAR2(3) null;	
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_DEEM_INDIV_2 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_CHILD_NOT_IN_AU NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_TAX_DEPEND_NOT_IN_AU NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_RESPONSE_INDIV NUMBER(1) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_PERSON_SON_LOOKUP NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_TAX_DEPEND_OUT_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_ALIMONY_OUTSIDE_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_GROSS_EARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_NET_EARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_UNEARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_CNT_NET_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_STD_OF_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_LESS_STD_OF_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_LESS_TAX_DEP_OUT_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_LESS_ALIM_CSUP_OUT_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_SURPLUS_OR_DEFICIT NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_TOTAL NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add CD_DEEM_SURPLUS_OR_DEFICIT VARCHAR2(3) null;

comment on column CAPS.FCE_ELIGIBILITY.IND_DEEM_RESP_TYPE is 'Indicates the Deeming type' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_DEEM_INDIV_1 is 'Records the first member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_DEEM_INDIV_REL_1 is 'The ''Deeming'' relationship of the first member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_DEEM_INDIV_2 is 'Records the second member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_DEEM_INDIV_REL_2 is 'The ''Deeming'' relationship of the second member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_CHILD_NOT_IN_AU is 'The number of Responsible Individual''s children who live in the home but are not included in the AU' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_TAX_DEPEND_NOT_IN_AU is 'The number of other dependents in the home who are claimed or could be claimed as tax dependents and are not included in the AU' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_RESPONSE_INDIV is 'The number of Responsible Individuals that are deeming' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_PERSON_SON_LOOKUP is 'The total number of dependents and responsible individuals used to do a Standard of Need lookup in the Deeming budget' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_TAX_DEPEND_OUT_HH is 'The Amount paid to dependents outside the household who are claimed or could be claimed as tax dependents' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_ALIMONY_OUTSIDE_HH is 'Alimony and/or child support paid to person(s) outside of the household' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_GROSS_EARNED_INCOME is 'The Deeming Responsible Individual(s) Gross Earned Income' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_NET_EARNED_INCOME is 'The Deeming Responsible Individual(s) Gross Earned Income less the Standard Earned Income Deduction given to the individual(s)' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_UNEARNED_INCOME is 'The Deeming Responsible Individual(s) Gross Unearned Income' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_CNT_NET_INCOME is 'The Deeming Responsible Individual(s) Net Earned Income plus their Gross Unearned Income' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_STD_OF_NEED is 'The Standard of Need lookup for the total number of dependents and Responsible Individual(s)' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_LESS_STD_OF_NEED is 'The Total Countable Net Income of the Respondible Individuals less the Standard of Need lookup for the total number of dependents and Responsible Individual(s)' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_LESS_TAX_DEP_OUT_HH is 'The Total Countable Net Income less SON Lookup less the amount paid to dependents outside the household who are claimed or could be claimed as tax dependents' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_LESS_ALIM_CSUP_OUT_HH is 'The Total Countable Net Income less SON Lookup less the amount paid to tax dependents less alimony and/or child support paid outside of the household' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_SURPLUS_OR_DEFICIT is 'Either the Surplus or Deficit amount in the Deeming budget' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_TOTAL is 'The Total Deemed Amount if a surplus exists';
comment on column CAPS.FCE_ELIGIBILITY.CD_DEEM_SURPLUS_OR_DEFICIT is 'Indicates whether there''s a surplus or deficit in the Deeming budget' ;


--Per MR-053 Eligibility: Worksheet add Resource Test columns
alter table CAPS.FCE_ELIGIBILITY add AMT_NONEXMPT_RSRC_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_RESOURCE_LIMIT_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_RESOURCE_LIMIT_CHILD NUMBER(16,2) null;

comment on column CAPS.FCE_ELIGIBILITY.AMT_NONEXMPT_RSRC_CRTFD_GRP is 'The Total Nonexempt Resources for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_RESOURCE_LIMIT_CRTFD_GRP is 'The Resource limit amount for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_RESOURCE_LIMIT_CHILD is 'The Resource limit amount for the Child';
comment on column CAPS.FCE_ELIGIBILITY.IND_EQUITY is 'Indicates whether the Certified Group has more than $10,000 in accessible resources';
comment on column CAPS.FCE_ELIGIBILITY.IND_CHILD_EQUITY is 'Indicates whether the Child has more than $10,000 in accessible resources';


--Per MR-053 Eligibility: Worksheet add Gross Income Ceiling Test columns
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GIC_SURP_DEFCT_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GIC_SURP_DEFCT_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add CD_GIC_SURP_DEFCT_CRTFD_GRP VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add CD_GIC_SURP_DEFCT_CHILD VARCHAR2(3) null;

comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_CRTFD_GRP is 'The Gross Income of the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_CHILD is 'The Gross Income of the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_GIC_SURP_DEFCT_CRTFD_GRP is 'Either the Surplus or Deficit amount in the AFDC Gross Income Ceiling Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_GIC_SURP_DEFCT_CHILD is 'Either the Surplus or Deficit amount in the IV-E Gross Income Ceiling Test';
comment on column CAPS.FCE_ELIGIBILITY.CD_GIC_SURP_DEFCT_CRTFD_GRP is 'Indicates whether there''s a surplus or deficit in the AFDC Gross Income Ceiling Test' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_GIC_SURP_DEFCT_CHILD is 'Indicates whether there''s a surplus or deficit in the IV-E Gross Income Ceiling Test' ;


--Per MR-053 Eligibility: Worksheet add SON Test and Budget columns
alter table CAPS.FCE_PERSON add AMT_GROSS_EARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_STD_EARNED_INCOME_DEDUCT NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME_30 NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME_THIRD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CHSUP_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CHSUP_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_DEP_CARE_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_DEP_CARE_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_UNEARNED_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_UNEARNED_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_CHSUP_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_CHSUP_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_DEEMED_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_DEEMED_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_ALLOC_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_ALLOC_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_SURP_DEFCT_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CNT_INCOME_ELIG_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CNT_INCOME_ELIG_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_SURP_DEFCT_ELIG_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_SURP_DEFCT_ELIG_CHILD NUMBER(16,2) null;

comment on column CAPS.FCE_PERSON.AMT_GROSS_EARNED_INCOME is 'The Gross Income of the person';
comment on column CAPS.FCE_PERSON.AMT_STD_EARNED_INCOME_DEDUCT is 'The Standard Earned Income Deduction given to the person, if they have earned income';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME is 'The Gross Income less the Standard Earned Income Deduction given to the person';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_30 is 'The Countable Income of the person less $30';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_THIRD is 'The Countable Income of the person less $30 less 1/3 deduction';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CHSUP_CRTFD_GRP is 'The Child Support amount for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CHSUP_CHILD is 'The Child Support amount for the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_DEP_CARE_STD_NEED is 'Less Child Care amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_DEP_CARE_ELIG is 'Less Child Care amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_UNEARNED_STD_NEED is 'Plus Gross Unearned Income amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_UNEARNED_ELIG is 'Plus Gross Unearned Income amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_CHSUP_CRTFD_GRP is 'Plus Child Support amount for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_CHSUP_CHILD is 'Plus Child Support amount for the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_DEEMED_STD_NEED is 'Plus the Total Deemed  amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_DEEMED_ELIG is 'Plus the Total Deemed  amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_ALLOC_STD_NEED is 'Less the Total Allocated amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_ALLOC_ELIG is 'Less the Total Allocated amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_SURP_DEFCT_STD_NEED is 'Either the Surplus or Deficit amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CNT_INCOME_ELIG_CRTFD_GRP is 'The Total Countable Income for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CNT_INCOME_ELIG_CHILD is 'The Total Countable Income for the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_SURP_DEFCT_ELIG_CRTFD_GRP is 'Either the Surplus or Deficit amount in the Eligibility budget for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_SURP_DEFCT_ELIG_CHILD is 'Either the Surplus or Deficit amount in the Eligibility budget for the Child';


--Per MR-053 Eligibility: Income and Expenditures add new Messages
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60788, SYSDATE, 'MSG_FCE_AMEND_APP_COMMENTS_REQ', 'It is indicated this is an ''Amended Application''.  Please enter comments detailing the change in circumstance.', 500, 700, 'N');


--Per MR-053 Eligibility: Income and Expenditures add new Codes Tables
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'SGLP', 'Single Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MUTP', 'Mutual Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MULP', 'Multiple Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MSGL', 'Mutual/Single');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MMUL', 'Mutual/Multiple');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'STP', 'Stepparent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'MCP', 'Minor Caretaker''s Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'ISP', 'Ineligible Spouse');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'IPT', 'Ineligible Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'ASP', 'Alien Sponsor');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CSPLSDEF', 'SUR', 'Surplus');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CSPLSDEF', 'DEF', 'Deficit');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (918, 'SacwisRev4', 'Release 4.1 - DBCR 16022');

commit;



