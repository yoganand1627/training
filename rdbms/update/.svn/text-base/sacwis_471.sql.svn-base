--STGAP00013995 - Create Tables for Case Review Sample Batch Job

--Note:  no impact to conversion


CREATE TABLE CAPS.SUPERVISOR_SAMPLING
   (    CD_UNIT_REGION VARCHAR2(3 BYTE),
        DECODE VARCHAR2(370 BYTE),
        NBR_UNIT VARCHAR2(2 BYTE),
        SUPERVISOR VARCHAR2(25 BYTE),
        CASE_MANAGER VARCHAR2(25 BYTE),
        NM_STAGE VARCHAR2(25 BYTE),
        CD_STAGE VARCHAR2(3 BYTE),
        ID_STAGE NUMBER(16,0),
        ID_CASE NUMBER(16,0),
        SUPERVISOR_ID NUMBER(16,0)
   ) tablespace data01;

   create index caps.supervisor_sampling_index on caps.supervisor_sampling(case_manager) tablespace index01;

   GRANT SELECT on CAPS.SUPERVISOR_SAMPLING to CAPSON, CAPSBAT;

   CREATE TABLE CAPS.DIRECTOR_SAMPLING
   (    CD_STAGE_REGION VARCHAR2(2 BYTE),
        COUNTY VARCHAR2(370 BYTE),
        NM_STAGE VARCHAR2(25 BYTE),
        CD_STAGE VARCHAR2(3 BYTE),
        ID_STAGE NUMBER(16,0),
        ID_CASE NUMBER(16,0),
        CNTYDIR_PERS_ID NUMBER(16,0)
   ) tablespace data01;

   create index caps.idx_director_sampling on caps.director_sampling(CNTYDIR_PERS_ID) tablespace index01;

   GRANT SELECT on CAPS.DIRECTOR_SAMPLING to CAPSON, CAPSBAT;

     CREATE TABLE CAPS.BATCH_JOB_QUERIES
   (    ID NUMBER(16,0) NOT NULL ENABLE,
        JOB_NAME VARCHAR2(20 BYTE) NOT NULL ENABLE,
        JOB_STEP NUMBER(5,0) NOT NULL ENABLE,
        STEP_QUERY CLOB NOT NULL ENABLE,
         CONSTRAINT BATCH_JOB_QUERIES_PK PRIMARY KEY (ID)
   ) tablespace data01;

   GRANT SELECT on CAPS.BATCH_JOB_QUERIES to CAPSON, CAPSBAT;

insert into caps.batch_parameters (NM_BATCH_PROGRAM, NM_BATCH_PARAMETER, DT_PARAM_EFFECTIVE, DT_PARAM_EXPIRED, TXT_PARAMETER_VALUE)
  values ( 'CASRVJOB', 'jobQuery', to_date('05/01/2009', 'MM/DD/YYYY'), to_date('12/31/2012', 'MM/DD/YYYY'), 'select id, job_name, step_query from batch_job_queries where job_name=''CASRVJOB'' order by job_step' );

insert into caps.batch_parameters (NM_BATCH_PROGRAM, NM_BATCH_PARAMETER, DT_PARAM_EFFECTIVE, DT_PARAM_EXPIRED, TXT_PARAMETER_VALUE)
  values ( 'CSRVDRJB', 'jobQuery', to_date('05/01/2009', 'MM/DD/YYYY'), to_date('12/31/2012', 'MM/DD/YYYY'), 'select id, job_name, step_query from batch_job_queries where job_name=''CSRVDRJB'' order by job_step' );

insert into caps.batch_parameters (NM_BATCH_PROGRAM, NM_BATCH_PARAMETER, DT_PARAM_EFFECTIVE, DT_PARAM_EXPIRED, TXT_PARAMETER_VALUE)
  values ( 'CASRVJOB', 'beginDt', to_date('05/01/2009', 'MM/DD/YYYY'), to_date('12/31/2012', 'MM/DD/YYYY'), '05/2009' );

insert into caps.batch_parameters (NM_BATCH_PROGRAM, NM_BATCH_PARAMETER, DT_PARAM_EFFECTIVE, DT_PARAM_EXPIRED, TXT_PARAMETER_VALUE)
  values ( 'CSRVDRJB', 'beginDt', to_date('05/01/2009', 'MM/DD/YYYY'), to_date('12/31/2012', 'MM/DD/YYYY'), '05/2009' );


--STGAP00013992 - Adding CD_VERSION column to the Tables Case Review

--Note:   no impact to conversion

alter table caps.CASE_REVIEW_CBX_LOOKUP add (cd_version number);
alter table caps.CASE_REVIEW_CBX_LOOKUP drop constraint pk_CASE_REVIEW_CBX_LOOKUP;
drop index caps.pk_CASE_REVIEW_CBX_LOOKUP;
update caps.case_review_cbx_lookup set cd_version = 1;
alter table caps.CASE_REVIEW_CBX_LOOKUP add constraint pk_CASE_REVIEW_CBX_LOOKUP primary key (CD_QUESTION,CD_VERSION,CD_CBX_QUESTION);

alter table caps.CASE_REVIEW_QUES_LOOKUP add (cd_version number); 
alter table caps.CASE_REVIEW_QUES_LOOKUP drop constraint pk_CASE_REVIEW_QUES_LOOKUP;
drop index caps.pk_CASE_REVIEW_QUES_LOOKUP;
update caps.case_review_ques_lookup set cd_version = 1;
alter table caps.CASE_REVIEW_QUES_LOOKUP add constraint pk_CASE_REVIEW_QUES_LOOKUP primary key (CD_QUESTION,CD_VERSION);

alter table caps.CASE_REVIEW_QUES_RESPONSE add (cd_version number); 
alter table caps.CASE_REVIEW_CBX_RESPONSE add (cd_version number);
alter table caps.CASE_REVIEW_SURVEY add (cd_version number); 

update caps.case_review_survey set cd_version = 1;


--STGAP00013972 - DBCR Case review message update

--Note:  no impact to conversion


update caps.message set txt_message = 'Once the Case Review is marked Complete no further changes can be made.  Confirm by pressing OK.  If further changes are required, press Cancel and uncheck the Complete box.' where txt_message_name = 'MSG_CSR_CFRM_COMP';



--STGAP00013978 - Add CCNTYDIR to Codes Tables

--Note:   no impact to conversion


insert into caps.codes_tables values ('CCNTYDIR','001',8832053, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','003',8002257, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','005',8002287, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','007',8002251, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','009',8002155, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','011',8002103, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','013',8002134, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','015',9031081, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));                                         
insert into caps.codes_tables values ('CCNTYDIR','017',8002259, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','019',8002260, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','021',8002156, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','023',8002216, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','025',8002261, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','027',8002262, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','029',8002289, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','031',8002290, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','033',8002176, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','035',8002113, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','037',8002247, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));    
insert into caps.codes_tables values ('CCNTYDIR','039',8002291, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','043',8002223, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','045',8002116, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','047',8002059, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','049',8002265, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','051',9030664, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','053',8002192, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','055',8002086, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','057',8541915, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','059',10437972, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','061',9031555 , to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','063',8002326, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','065',8002257, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','067',7500314, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','069',8002271, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','071',8002249, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','073',11412582, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','075',8832073, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','077',9444073, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','079',8002157, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','081',8002194, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','083',8002086, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','085',8002096, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','087',8002245, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','089',8002321, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','091',8002218, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','093',8002194, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','095',8002246, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));               
insert into caps.codes_tables values ('CCNTYDIR','097',5607537, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','099',8002247, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','101',8002274, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','103',8002293, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','105',8002137, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','107',8002223, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','109',8002220, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','111',9031023, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','113',8002120, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','115',8002108, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','117',8002096, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','119',8002097, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','121',8002298, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','123',9013290, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','125',11404422, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','127',8002288, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','129',8002090, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','131',8002248, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','133',8002146, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','135',8002323, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','137',8002102, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','139',8002099, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','141',8002180, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','143',8002110, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','145',8002193, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','147',8002097, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','149',8002116, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','151',8002332, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','153',8002158, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','155',8002260, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','157',10438976, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','159',8002142, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','161',8832056, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','163',11404422, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','165',8002185, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));        
insert into caps.codes_tables values ('CCNTYDIR','167',8002222, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','169',8002159, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','171',10437977, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','173',8002262, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','175',9714483, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','177',11465135, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','179',8002295, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','181',8002182, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','183',8002296, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));   
insert into caps.codes_tables values ('CCNTYDIR','185',8002281, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','187',8002106, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','193',8002193, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','195',8002147, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','197',8002192, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','189',8002183, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','191',8002295, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));  
insert into caps.codes_tables values ('CCNTYDIR','199',11594580, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','201',8831922, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','205',8002251, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','207',8002160, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','209',8002224, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR', '211',8002142, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','213',9443894, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','215',8002203, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','217',10438187, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','219',8002146, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','221',8002147, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','223',9443856, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','225',8002161, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','227',8002091, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','229',8002258, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','231',8002123, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','233',8002112, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','235',10437863, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','237',8002163, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','239',9031555, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','241',8002102, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','243',8002205, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','245',8002184, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','247',8002323, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','249',8002193, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','251',8002185, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','253',8831922, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','255',9443926, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','257',8002103, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR', '259',8002205, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','261',9013377, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','263',8002209, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','265',8002180, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','267',8002220, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','269',8002209, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','271',8002218, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','273',8002253, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','275',9021135, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','277',8002285, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','279',11397117, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','281',10438122, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCNTYDIR','283',8002224, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','285',8002122, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','287',8002259, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','289',8002164, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','291',10438122, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','293',8002123, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','295',8002092, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','297',10437942, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','299',8002265, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','301',8002183, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','303',8002186, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','305',8002234, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','307',8002205, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','309',8002218, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','311',8002106, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','313',8002093, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','315',8002236, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','317',8002182, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','319',8002164, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));
insert into caps.codes_tables values ('CCNTYDIR','321',8832075, to_date('05/01/2009','MM/DD/YYYY'), to_date('12/31/2012','MM/DD/YYYY'));


-- STGAP00014001 - DBCR Security Profiles update for Case Review

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '000'
WHERE CD_SECURITY_CLASS_NAME = 'SENSITIVE_CASE'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '000'
WHERE CD_SECURITY_CLASS_NAME = 'ORS_PRU MAINT'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'CASE_MANAGER'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'CONTRACT_LEAD'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'CONTRACTED_CBO'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'COUNTY_MGMNT'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'DJJ_AFCARS'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'DPTY_CNTY_DRCTR'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'FSCL_SVC_ST_STF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'IT HELP DESK'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_01'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_02'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_03'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_04'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_05'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_06'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_07'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_08'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_09'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_10'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_11'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_12'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_13'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_14'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_15'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_16'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_17'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_99'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MED_BILL_MGMT'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MED_BILL_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'MES_PROG_ASST'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'OFI SCREENER'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'ORS_PRU MAINT'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'REGNL_ACCT_MGMT'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'REGNL_ACCT_STF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'REGNL_SS_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'REG_FAM_IND_MGT'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'REG_FAM_IND_STF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'RSRC_DVLPR'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'SAU_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'SENSITIVE_CASE'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'SAU_SEALED'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '00'
WHERE CD_SECURITY_CLASS_NAME = 'SHINES_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'SS_ADMIN_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'STATE_OFC_CONS'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'STATE_OFC_MGMT'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'SUPERVISOR'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'SYS_ADMIN'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'UNIT_TEAM_LEAD'
and length(TXT_SECURITY_CLASS_PROFIL) = 93;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (472, 'SacwisRev3', 'Release 3.1 - DBCRs 13972,13978,13992,13995,14001');

commit;


