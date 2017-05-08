
-- Standard Alter Table SQL

ALTER TABLE CAPS.INCOMING_DETAIL ADD CD_INCOMING_WORKER_COUNTY VARCHAR2(3)     NULL
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_WORKER_COUNTY IS
'County Code'
;
ALTER TABLE CAPS.INCOMING_DETAIL ADD ID_INCOMING_SUP NUMBER(16)     NULL
;
ALTER TABLE CAPS.STAGE MODIFY(TXT_STAGE_SPL_INSTRT_CMNT  VARCHAR2(300))
;
alter table caps.employee modify (cd_employee_class varchar2(8));
alter table caps.employee_audit modify (cd_employee_class varchar2(8));
alter table caps.emp_job_history modify (cd_job_class varchar2(8));

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.INCOMING_DETAIL ADD CONSTRAINT FK_INCOMING_SUP_PERSON
FOREIGN KEY (ID_INCOMING_SUP)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };


UPDATE caps.codes_tables 
SET dt_end = TO_DATE('01/01/2006', 'MM/DD/YYYY') 
WHERE dt_end IS NULL 
AND code_type = 'CEMPJBCL'; 
insert into caps.codes_tables values('CEMPJBCL','40805','Accountant 2, Professional',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','40806','Accountant, Paraprofessional',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','40807','Accounting Clerk',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','60104','Administrative Assistant',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','40001','Administrative Ops Coord 2',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','40002','Admin OPS Coord 1',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14606','DFCS Community Resource Spec',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14038','DFCS County Director 2',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14039','DFCS County Director 3',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14032','DFCS County Director 4',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14036','DFCS Deputy County Director 4',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14439','DFCS Economic Support Screener',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14013','DFCS Fam Ind Regional Mgr',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14071','DFCS Field Operations Mgr - CP',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14405','DFCS Medicaid Eligibility Specialist',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14074','DFCS Reg Prog Specialist',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14901','DFCS Regional Resource Coord',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14006','DFCS Services Generalist',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14077','DFCS Services Technician',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14416','Economic Support Admin',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14414','Error Control Specialist',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14113','Family Connection Coordinator',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14412','Family Independence Case Mgr 1',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14454','Family Independence Case Mgr 2',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14456','Family Independence CS MGT ASC',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14413','Family Independence CS MGT SUP',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14114','Family Independence State Prog Mgr',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14108','Family Service Worker 1',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14107','Family Service Worker 2',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','40037','Fiscal Operations Mgr, DFCS',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','50301','Food Service Employee 1',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14411','Fraud Prevention Investigator',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','60111','Office Assistant',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','60106','Office Manager',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14008','Personal Advocate',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','16007','Personnel Representative',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','16801','Personnel Technician 1',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','60122','Program Assistant (DHR)',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','60133','Program Associate (DHR)',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','61804','Program Director 2',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','16087','Project Administrator',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','60114','Secretary, Executive (DHR)',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14202','Social Services Administrator',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203','Social Services Case Manager',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203INT','Social Services Case Manager - Intake',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203INV','Social Services Case Manager - Investigation',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203CPS','Social Services Case Manager - CPS Ongoing',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203FC','Social Services Case Manager - Foster Care',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203ADO','Social Services Case Manager - Adoptions',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203RD','Social Services Case Manager - Resource Development',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203PAD','Social Services Case Manager - Post Adoptive',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203ILP','Social Services Case Manager - Independent Living',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14203M','Social Services Case Manager - Multiple Specialties',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14212','Social Services Case Manager Associate',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14211','Social Services Program Director',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201','Social Services Supervisor',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201INT','Social Services Supervisor - Intake',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201INV','Social Services Supervisor - Investigation',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201CPS','Social Services Supervisor - CPS Ongoing',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201FC','Social Services Supervisor - Foster Care',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201ADO','Social Services Supervisor - Adoptions',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201RD','Social Services Supervisor - Resource Development',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201PAD','Social Services Supervisor - Post Adoptive',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201ILP','Social Services Supervisor - Independent Living',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14201M','Social Services Supervisor - Multiple Specialties',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14231','Social Services Treatment Specialist (DHR)',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14205','Social Services Case Manager, ADV',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','14204','Social Services Specialist',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','16909','Staff Devel/Trng Coord 1',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','61502','Volunteer Resource Coordinator',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','80742','Field Office Position',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','H1401','Social Serv Aide',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','H5001','Food Service Worker',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','H6001','Clerical Worker',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','T1402','Social Serv Tech Worker',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','T1601','Personnel Services Worker',null,to_date('09/08/2006','MM/DD/YYYY'));
insert into caps.codes_tables values('CEMPJBCL','RAC','Regional Adoptions Coordinator',null,to_date('09/08/2006','MM/DD/YYYY'));

create sequence cempjbcl start with 1 increment by 1;

create table caps.temp_cempjbcl (code_type varchar2(8), code varchar2(20), temp_index number);
insert into caps.temp_cempjbcl values('CEMPJBCL','40805',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','40806',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','40807',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','60104',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','40001',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','40002',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14606',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14038',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14039',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14032',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14036',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14439',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14013',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14071',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14405',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14074',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14901',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14006',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14077',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14416',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14414',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14113',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14412',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14454',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14456',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14413',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14114',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14108',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14107',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','40037',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','50301',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14411',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','60111',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','60106',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14008',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','16007',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','16801',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','60122',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','60133',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','61804',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','16087',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','60114',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14202',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203INT',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203INV',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203CPS',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203FC',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203ADO',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203RD',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203PAD',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203ILP',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14203M',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14212',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14211',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201INT',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201INV',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201CPS',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201FC',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201ADO',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201RD',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201PAD',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201ILP',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14201M',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14231',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14205',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','14204',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','16909',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','61502',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','80742',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','H1401',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','H5001',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','H6001',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','T1402',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','T1601',cempjbcl.nextval);
insert into caps.temp_cempjbcl values('CEMPJBCL','RAC',cempjbcl.nextval);

/
declare
	Counter  number;
	MaxCounter  number;
      cursor emp_cursor is
		select id_person from caps.employee ;
begin
	Counter := 1;
      select cempjbcl.currval into MaxCounter from dual;
	for emp_rec in emp_cursor loop
            update caps.emp_job_history set cd_job_class = (select code from caps.temp_cempjbcl where temp_index = Counter) where id_person=emp_rec.id_person ;
		update caps.employee set cd_employee_class = (select code from caps.temp_cempjbcl where temp_index = Counter) where id_person=emp_rec.id_person ;
            Counter := Counter + 1 ;
            if Counter > MaxCounter then
               Counter := 1;
            end if;
	end loop;
commit;
end;
/

drop sequence cempjbcl;

drop table caps.temp_cempjbcl;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (11, 'SacwisRev1', 'Add 2 columns to INCOMING_DETAIL and expanded column in stage, misc static updates to CODES_TABLES, update employee classes.');
                         
commit;
