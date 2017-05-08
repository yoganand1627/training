-- Release 2.5 

-- change STGAP00009150
-- Standard Alter Table SQL

ALTER TABLE CAPS.INCMG_DETERM_FACTORS ADD TXT_PH_ABUSE_CMNTS VARCHAR2(500)     NULL
;
ALTER TABLE CAPS.INCMG_DETERM_FACTORS ADD TXT_NG_ABUSE_CMNTS VARCHAR2(500)     NULL
;
ALTER TABLE CAPS.INCMG_DETERM_FACTORS ADD TXT_EM_ABUSE_CMNTS VARCHAR2(500)     NULL
;
ALTER TABLE CAPS.INCMG_DETERM_FACTORS ADD TXT_SX_ABUSE_CMNTS VARCHAR2(500)     NULL
;
ALTER TABLE CAPS.INCMG_DETERM_FACTORS ADD TXT_OT_ABUSE_CMNTS VARCHAR2(500)     NULL
;

--change STGAP00009141 
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SR_HOUSEHOLD_MEMBERS
BEFORE INSERT
ON CAPS.SR_HOUSEHOLD_MEMBERS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:NEW.ID_SR_HS_MEMBER IS NULL OR :new.ID_SR_HS_MEMBER = 0) THEN
    SELECT  SEQ_SR_HOUSEHOLD_MEMBERS.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :new.ID_SR_HS_MEMBER := dummy;
  END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00009135
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
select 'CPSLegalLog', '00', 31, 'A', 'CPS Legal Log', 'ondport', 'L', 'W', 'List of Legal Status and Legal Action details documented on the Case. Generated for a specific Case Number with an optional Person ID parameter. Leave the Person ID parameter blank to generate Legal Status and Legal Action details of all persons on the Case.', 'Case Printing', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='CPSLegalLog' and nm_rpt_sqr_ver='00');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'CPSLegalLog', '00', 1, 16, 'CASEID', 'NUMBER', 'Y', 'Case ID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='CPSLegalLog' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'CPSLegalLog', '00', 2, 16, 'PERSONID', 'NUMBER', 'N', 'Person ID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='CPSLegalLog' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

--change STGAP00009137
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
select 'IncomeResources', '00', 31, 'A', 'Income Resources', 'ondport', 'L', 'W', 'Details regarding income and resources documented for a person on a case. Generated for a specific Case ID with an optional Person ID parameter.', 'Case Printing', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='IncomeResources' and nm_rpt_sqr_ver='00');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'IncomeResources', '00', 1, 16, 'ID_CASE', 'NUMBER', 'Y', 'Case ID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='IncomeResources' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');


insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'IncomeResources', '00', 2, 16, 'ID_PERSON', 'NUMBER', 'N', 'Person ID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='IncomeResources' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

-- change STGAP00009151
update CAPS.CODES_TABLES set dt_end = sysdate where CODE_TYPE = 'CPHYABSE' and CODE in ('PC4Y', 'PCNP', 'PAMC', 'PBCB','PCPI', 'PMTH');
update CAPS.CODES_TABLES set dt_end = sysdate where CODE_TYPE = 'CNEGLECT' and CODE in ('NCLA', 'NCBN', 'NSMC');

-- MR-011: Updating CODES_TABLES rows
update CAPS.CODES_TABLES set dt_end = sysdate where CODE_TYPE = 'CEMLABSE' and CODE in ('ECPC', 'ECEI', 'ECII');
update CAPS.CODES_TABLES set decode = 'Ongoing History' where CODE_TYPE = 'CEMLABSE' and CODE = 'EOHI';
update CAPS.CODES_TABLES set dt_end = sysdate where CODE_TYPE = 'CSEXABSE' and CODE in ('SCAH', 'SCNP');
update CAPS.CODES_TABLES set decode = 'Alleged Perpetrator has access to the child' where CODE_TYPE = 'CSEXABSE' and CODE = 'SMAC';
update CAPS.CODES_TABLES set decode = 'Allegations of sodomy, vaginal intercourse, or oral sex' where CODE_TYPE = 'CSEXABSE' and CODE = 'SSME';
update CAPS.CODES_TABLES set dt_end = sysdate where CODE_TYPE = 'COTHER' and CODE ='OECC';
update CAPS.CODES_TABLES set decode = 'Child detained by a physician' where CODE_TYPE = 'COTHER' and CODE = 'OCCP';

-- MR-011: Inserting new rows for code type CPHYABSE 
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PC08', 'Child 8 years or younger', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCAC', 'Child left alone', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCAE', 'Serious physical injury or risk of serious physical injury', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCAL', 'Child fearful of parent/caretaker', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCAQ', 'Alleged Perpetrator has access to the child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCBD', 'Non-maltreating caretaker not protective of child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCBL', 'Child injured from the discipline', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCBP', 'Multiple bruises, welts, or marks', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCCD', 'Ongoing History', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCCG', 'Any witnesses to the abuse', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCCK', 'Family members not taking protective action', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCJA', 'Caretaker demonstrates physical instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCKA', 'Immediate medical treatment and/or hospitalization required', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCKD', 'Self referral by child', null, sysdate);

-- MR-011: Inserting new rows for code type CNEGLECT 
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NBBA', 'Caretaker has experienced black outs', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NBBE', 'Caretakers substance abuse affects ability to care for child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NBBL', 'Legal or illegal drugs', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NBBS', 'Children have access to the drugs', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NC1A', 'Child left alone', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NCA1', 'Child under age 13', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NCAD', 'Child afraid to go home', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NCBA', 'Self referral by child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NCBP', 'Child Abandoned', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NCCQ', 'Ongoing History', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NCLQ', 'Caretaker not willing to meet child?s basic needs', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NCNA', 'Child suffering from serious untreated medical condition', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NTAD', 'Child caring for other children', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NTAP', 'Caretaker demonstrates emotional instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NTAV', 'Caretaker demonstrates intellectual instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NTBD', 'Caretaker demonstrates  physical instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNEGLECT', 'NTBP', 'Child does not receive appropriate discipline', null, sysdate);


-- MR-011: Inserting new rows for code type CEMLABSE 
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECAG', 'Child 8 years or younger', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECAL', 'Child under age 13', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECAT', 'Cruel, callous or bizarre punishment alleged', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECBD', 'Child failing to thrive', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECBK', 'Child developmentally delayed', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECBS', 'No bond between caretaker and the child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECCD', 'Child left alone', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECCK', 'Cruel, callous or bizarre punishment/behavior by the caretaker', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECCS', 'Serious emotional damage to child(ren) resulting from parent/caretaker''s actions', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECDD', 'Child present when the violence occurred', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECDK', 'Any family been hurt or assaulted', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECDS', 'Police called to stop assaults', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECED', 'Anyone arrested', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECEK', 'There is a history of DV', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECES', 'Family member stalked or taken anyone hostage', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECFD','Battered parent not able to protect themselves or the children', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECFK', 'Child afraid to be alone', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECFS', 'Child developmentally on target', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECQD', 'Caretaker demonstrates intellectual instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECQS', 'Caretaker demonstrates physical instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'EPAD', 'Parent self reporting and unable to cope', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'EPBD', 'Caretaker feel they will harm or kill the child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'EPCD', 'Caretaker requesting removal of child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'EPDD', 'Caretaker believes child is a religious figure or devil', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'EPED', 'Violence affect the children', null, sysdate);

-- MR-011: Inserting new rows for code type CSEXABSE 
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SAAM', 'Child 8 years or younger', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SABD', 'Child under age 13', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SACD', 'History of abuse', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SPAD', 'Child afraid to go home', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SPBD', 'Sexual exploitation', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SSMT', 'Child left alone', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SSND', 'Non-maltreating caretaker not protective of child', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SSNT', 'There is medical evidence', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SSOD', 'Caretaker demonstrate emotional instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SSOT', 'Caretaker demonstrate intellectual instability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSEXABSE', 'SSPD', 'Caretaker demonstrate physical instability', null, sysdate);

-- MR-011: Inserting new rows for code type COTHER
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COTHER', 'OCDD', 'Request for short-term emergency care', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COTHER', 'OCED', 'Voluntary Placement', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COTHER', 'OCFD', 'Court ordered supervision', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COTHER', 'OCGD', 'Safe place for Newborns', null, sysdate);

-- MR-011: Inserting new Code Type CPDETFAQ 
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ1', 'Have you had previous concerns about the family?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ2', 'What is the developmental status of the child?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ3', 'What cause the parent/caretaker to discipline the child?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ4', 'What was the instrument used in the discipline?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ5', 'Describe the injury (when, location of marks, color, size, shape, fresh or fading)', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ6', 'What part of the body was injured?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ7', 'Where was the child when the abuse occurred?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ8', 'What is the caretaker?s explanation?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ9', 'What is the child?s explanation?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPDETFAQ', 'PFQ10', 'What led to the child?s disclosure or brought the child to your attention?', null, sysdate);

-- MR-011: Inserting new Code Type CNDETFAQ
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ1', 'What specific drugs are being used by the parent/caretaker?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ2', 'What is the frequency of use?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ3', 'Do the children have knowledge of the drug use?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ4', 'Is the baby in the hospital?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ5', 'What is the discharge date?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ6', 'Does the child know what or who to call in a crisis?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ7', 'Child left alone(for how long 1- 2 hrs, 2- 4 hrs, 4-6 hrs, 6-8 hrs)', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ8', 'Did the parent/caretakers say when they would return?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ9', 'How long has the parent/caretaker been gone?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ10', 'Are the alternate caretakers able to provide adequate care for the child?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ11', 'Has there been any recent contact with the parent/caretaker?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ12', 'What is the present physical condition of the child?', null, sysdate);

-- MR-011: Inserting new Code Type CEDETFAQ
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ1', 'What symptoms does the child have that would indicate psychological, emotional, and/or social impairment?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ2', 'How does the child function in school?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ3', 'What has the parent/caretaker done that is harmful?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ4', 'How long has the situation been going on, and what changes have been observed?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ5', 'Who is currently caring for the children?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ6', 'What steps are being taken to prevent the perpetrator access to the home (restraining order, police, shelter)?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ7', 'Is the battered parent/caretaker ever alone?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ8', 'When can we contact the battered caretaker that he/she will most likely be alone?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEDETFAQ', 'EFQ9', 'What is the developmental status of the child?', null, sysdate);

-- MR-011: Inserting new Code Type CSDETFAQ
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSDETFAQ', 'SFQ1', 'Results of medical exam', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSDETFAQ', 'SFQ2', 'To whom did the child disclose the abuse?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSDETFAQ', 'SFQ3', 'Did the child disclose directly to the reporter?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSDETFAQ', 'SFQ4', 'Where was the child when the abuse occurred?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSDETFAQ', 'SFQ5', 'What steps are being taken to prevent further contact between the perpetrator and the child?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSDETFAQ', 'SFQ6', 'Has the child had a medical exam?', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSDETFAQ', 'SFQ7', 'What is the developmental status of the child?', null, sysdate);

-- change STGAP00009152
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPOLVIOL', 'CPU', 'Corporal Punishment', TO_DATE('09-JUN-08', 'DD-MON-RR'));
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPOLVIOL', 'DIS', 'Discipline', TO_DATE('09-JUN-08', 'DD-MON-RR'));
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPOLVIOL', 'DUB', 'Drug Use By F/A Parent', TO_DATE('09-JUN-08', 'DD-MON-RR'));
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPOLVIOL', 'SAB', 'Sexual Abuse', TO_DATE('09-JUN-08', 'DD-MON-RR'));
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPOLVIOL', 'OTH', 'Other', TO_DATE('09-JUN-08', 'DD-MON-RR'));

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (332, 'SacwisRev2', 'static table updates, new fields for Incoming Determ Factors');                        
commit;
