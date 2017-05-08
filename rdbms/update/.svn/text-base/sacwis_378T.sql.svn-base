-- Add columns to PERSON to support Adoption Enhancements 

--STGAP00010070 - Changes to data model for design finalization . This is the dbcr to hold all the changes related to design finalization for Adoptions.


alter table caps.person add (IND_ADOPT_AFCARS_SENT VARCHAR2(1));
comment on column caps.person.IND_ADOPT_AFCARS_SENT is 'Indicator if the child has been reported in the adoption afcars file.';

alter table caps.EXCHANGE_HOME add (NBR_AGENCY_CONTRACT_CODE varchar2(3));
comment on column caps.exchange_home.nbr_agency_contract_code is 'Number of the agency''s contract code with the SAU.';

update CAPS.EXCHANGE_HOME set CD_SEV_MENTAL_RETARDATION = null;
alter table CAPS.EXCHANGE_HOME drop column CD_SEV_MENTAL_RETARDATION;
alter table CAPS.EXCHANGE_HOME add (CD_SEV_MENTAL_RETARDATION varchar2(2));

update caps.codes_tables
set decode = 'Child Hx of Sexual Abuse'
where code_type = 'CADBKRNF'
and code = '09';

alter table caps.adoption_subsidy add (ID_SPC_NEEDS_DET  NUMBER(16));
alter table caps.adoption_subsidy add constraint FK_ADO_SUB_SPC_NDS_DETER
   foreign key  (ID_SPC_NEEDS_DET) 
   references caps.special_needs_determination (id_event);

alter table caps.ADO_INFO_CBX_SENT drop constraint FK_CBX_SENT_ADO_INFO;
alter table caps.ADO_INFO_CBX_SENT rename column ID_ADO_INFO to ID_INFO_CHAR;
alter table caps.ADO_INFO_CBX_SENT add constraint FK_CBX_SENT_ADO_INFO foreign key
(ID_INFO_CHAR) references caps.ADO_INFO_CBX(ID_INFO_CHAR);

alter table caps.ADO_INFO add (IND_FP_ADO  varchar2(1));
comment on column caps.ADO_INFO.IND_FP_ADO is 'Yes or No Value to indicate if the foster parents intend to adopt the child.';

alter table caps.ADO_INFO add (TXT_COUNTY_CONS_COMMENT varchar2(300));
comment on column  caps.ADO_INFO.TXT_COUNTY_CONS_COMMENT is 'Field will be used by county to specified families that have been considered for adoption.' ;

update caps.codes_tables
set decode = 'Foster/Adoptive Parent'
where code = 'AF'
and code_type in ('CRELPRN2','CRELCOL2','CRPTRINT','CSRCRPTR','CRELVICT');

update caps.codes_tables
set decode = 'Adoptive Parent'
where code = 'PT'
and code_type in ('CRELVICT','CRPTRINT');

update caps.codes_tables
set dt_end = sysdate
where code in ('19', '201','200')
and code_type = 'CLNCHAR2';

alter table caps.EXCHANGE_CHILD add (TXT_BIRTH_NAME VARCHAR2(30));
comment on column caps.EXCHANGE_CHILD.TXT_BIRTH_NAME is 'Birth name of the child if there was a dissolution';

alter table caps.EXCHANGE_CHILD add (TXT_CHILD_IS_LINKED VARCHAR2(500));
comment on column caps.EXCHANGE_CHILD.TXT_CHILD_IS_LINKED is 'Comments for Child is Linked' ;

alter table caps.EXCHANGE_CHILD add (TXT_CHILD_PLACED_WITH       VARCHAR2(500));
comment on column caps.EXCHANGE_CHILD.TXT_CHILD_PLACED_WITH is 'Comments for Child is Placed With';

alter table caps.INITIAL_MEDICAID_APP add (TXT_ICAMA_COMMENTS   VARCHAR2 (300));
comment on column caps.INITIAL_MEDICAID_APP.TXT_ICAMA_COMMENTS is 'Inter-state comments';

alter table caps.NON_INCIDENT_AFCARS_INFO 
 add (IND_MENTAL_RETARDATION  VARCHAR2(1));
comment on column caps.NON_INCIDENT_AFCARS_INFO.IND_MENTAL_RETARDATION is 'Indicator if the child has the characteristic Mental Retardation';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (CD_SEV_MENTAL_RETARDATION  VARCHAR2(2));
comment on column caps.NON_INCIDENT_AFCARS_INFO.CD_SEV_MENTAL_RETARDATION  is 'Severity level of the characteristic Mental Retardation';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (IND_VISUAL_HEARING_IMP   VARCHAR2 (1));
comment on column caps.NON_INCIDENT_AFCARS_INFO.IND_VISUAL_HEARING_IMP  is 'Indicator if the child has the characteristic Visual or Hearing Impaired';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (CD_SEV_VISUAL_HEARING_IMP   VARCHAR2 (2));
comment on column caps.NON_INCIDENT_AFCARS_INFO.CD_SEV_VISUAL_HEARING_IMP  is 'Severity level of the characteristic Visual or Hearing Impaired';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (IND_PHYSICALLY_DISABLED  VARCHAR2(1));
comment on column caps.NON_INCIDENT_AFCARS_INFO.IND_PHYSICALLY_DISABLED  is 'Indicator if the child has the characteristic Physically Disabled';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (CD_SEV_PHYSICALLY_DISABLED   VARCHAR2(2));
comment on column caps.NON_INCIDENT_AFCARS_INFO.CD_SEV_PHYSICALLY_DISABLED is 'Severity level of the characteristic Physically Disabled';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (IND_EMOTIONALLY_DIST   VARCHAR2 (1));
comment on column caps.NON_INCIDENT_AFCARS_INFO.IND_EMOTIONALLY_DIST is 'Indicator if the child has the characteristic Emotionally Disturbed';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (CD_SEV_EMOTIONALLY_DIST   VARCHAR2(2));
comment on column caps.NON_INCIDENT_AFCARS_INFO.CD_SEV_EMOTIONALLY_DIST is 'Severity level of the characteristic Emotionally Disturbed';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (IND_OTHER_MED  VARCHAR2 (1));
comment on column caps.NON_INCIDENT_AFCARS_INFO.IND_OTHER_MED is 'Indicator if the child has the characteristic Other Medical Diagnosis';

alter table caps.NON_INCIDENT_AFCARS_INFO 
add (CD_SEV_OTHER_MED   VARCHAR2(2));
comment on column caps.NON_INCIDENT_AFCARS_INFO.CD_SEV_OTHER_MED  is 'Severity level of the characteristic Other Medical Diagnosis';


{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
{ call dbms_utility.compile_schema('ORS') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (379, 'SacwisRev3', 'Release 3.0 - DBCR 10070');
commit;

