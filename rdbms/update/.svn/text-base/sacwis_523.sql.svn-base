
--STGAP00015305 - DBCR -Per STGAP00015300 new message

--Per STGAP00015300, Need to display an error message if the user selects
--CPA/CCI Authorized Designee and does not enter Name of Agency.



INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60576,'MSG_NAME_AGENCY_REQ',
       'In the Contacted By section CPA/CCI Authorized Designee is selected. Please enter Name of Agency.', 700, 500, 'N');
	   
--STGAP00014401 - Per STGAP00014326 MR-024

--Per STGAP00014326 MR-024

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60547,'MSG_CON_NM_REQ', 'In the Contacted By section CPA/CCI Authorized Designee or Other has been selected. Please enter the name.',  700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60548,'MSG_CON_LOC_REQ', 'Announced Face to Face or Unannounced Face to Face is selected as the contact method. Please select a location.',700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60549,'MSG_CNFRM_ON_CHNG','The existing narrative will be deleted and all the information will be lost if the narrative type is changed. Are you sure you want to change the narrative type?',700, 500, 'N');

--STGAP00014516 - DBCR - PerSTGAP00014326 MR24  Insert new Table

-- Per MR - 024 , Add new table Caps .CONTACT_PRIV_CONVER_CBX ,

create table CAPS.CONTACT_PRIV_CONVER_CBX 
(id_contact_priv_conver_cbx number(16) not null,
dt_last_update date not null,
id_contact_event number(16) not null,
id_priv_conver_person number(16) not null,
constraint pk_CONTACT_PRIV_CONVER_CBX primary key(id_contact_priv_conver_cbx) using index tablespace index01,
constraint fk_CONTACT_EVENT foreign key(id_contact_event) references caps.contact(id_event) ) tablespace data01;

comment on table caps.contact_priv_conver_cbx is 'This table is used to record the Contact Private Conversation on the Contact Detail Page.';
comment on column caps.contact_priv_conver_cbx.id_contact_priv_conver_cbx is 'Primary Key';
comment on column caps.contact_priv_conver_cbx.dt_last_update is 'Used to record the last updated date';
comment on column caps.contact_priv_conver_cbx.id_contact_event is 'Records the event id of the contact record for which this private conversation record is created';
comment on column caps.contact_priv_conver_cbx.id_priv_conver_person is 'Records the person involved in private conversation for that contact';

create index caps.fk_contact_priv_conver_event on caps.contact_priv_conver_cbx(id_contact_event) tablespace index01;

grant select,update,insert,delete on caps.contact_priv_conver_cbx to capson,capsbat,ops$datafix;
grant select on caps.contact_priv_conver_cbx to operator;

CREATE SEQUENCE  CAPS.SEQ_contact_priv_conver_cbx  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_contact_priv_conver_cbx  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_contact_priv_conver_cbx 
BEFORE UPDATE
ON CAPS.contact_priv_conver_cbx
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_contact_priv_conver_cbx
BEFORE INSERT
ON CAPS.contact_priv_conver_cbx
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_contact_priv_conver_cbx=0 then
    SELECT SEQ_ado_info_cbx_sent.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_contact_priv_conver_cbx := dummy;
  end if;
END;
/


--Per STGAP00014326 MR- 024  New codes and message

-- Inserting New Message to message table
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60554,'MSG_PUR_REQ','At least one Purpose option is required.',700, 500, 'N');

--Per MR -024 Add new codes for Contact Narrative types

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES ('CCONNARR','STD','Standard',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES ('CCONNARR','PCV','Parent/Child Visitation',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) 
VALUES ('CCONNARR','SPW','Safety, Permanency and Wellbeing',SYSDATE);

--STGAP00014904 - DBCR - Per STGAP00014897 End Date contacttypes

--Per STGAP00014897 End Date the following  Contant Types.

UPDATE CAPS.codes_tables
SET dt_end = sysdate
WHERE code_type = 'CCNTCTYP' AND code IN ('OPVC', 'MPVC', 'LPVC' , 'APTC',  'LPTC' , 'IINQ');


--STGAP00014627 - SQR: New PIP18 - Parent Involvement FCC

-- To enable new report in SHINES. This is the second of the 4 PIP#18 reports:
-- Report Name: Parent Involvement in Case Planning in  FCC stage
-- DEV# STGAP00014617

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, 
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, 
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ParentInvolvementInCasePlanningFCC', '00', 31, 'A', 
'Cases Without Parent Involvement in CP - FCC', 
'ondport', 'L', 'W', 
'A list of active Foster Care cases that did not have parent involvement in case planning (CP). Generated for a specific month with optional region, county, and unit parameters.', 
'CFSR', 'Y');

INSERT INTO caps.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, 
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ParentInvolvementInCasePlanningFCC', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ParentInvolvementInCasePlanningFCC', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ParentInvolvementInCasePlanningFCC', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ParentInvolvementInCasePlanningFCC', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

--STGAP00015051 - SQR: Enable new report Parent Invlvmnt Stat - ONG
-- To enable new report in SHINES: Parent Involvement in Case Planning Status - ONG
-- DEV#: STGAP00015041
-- Related CQ#: STGAP00015035: add new table report_work and new view SQR_PIP18_PARENT_ONG_COUNTS - this DBCR can only be checked in and merged after STGAP00015035 has been fully executed in trunk and 3.2
-- SQL: hold until new table and view enabled in 3.2 sys

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, 
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, 
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ParentInvolvementInCasePlanningStatusONG', '00', 31, 'A', 'Parent Involvement in CP Status - ONG', 
'ondport', 'P', 'W', 'Summary view of parent involvement in ONG case planning (CP) with counts and percentage of cases that should have had parent involvement in CP for each case manager. Generated for a specific month with optional region, county, and unit parameters.', 
'CFSR', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ParentInvolvementInCasePlanningStatusONG', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year (mm/yyyy)');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ParentInvolvementInCasePlanningStatusONG', '00', 2, 2, 'REGIONCD', 'CHAR', 'N','Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ParentInvolvementInCasePlanningStatusONG', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ParentInvolvementInCasePlanningStatusONG', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

--STGAP00015063 - SQR: Enable new report Chiild Invlvmnt - ONG

--To enable new report in SHINES: Child Without Involvment in Case Planning - ONG
--Report Development Defect #: STGAP00014619

---DBCR Statements

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, 
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, 
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ChildWithoutInvolvementInCasePlanningONG', '00', 31, 'A', 
'Cases Without Child Involvement in CP- ONG', 'ondport', 'L', 'W', 
'A list of active Ongoing cases that do not have child involvement in case planning (CP). Generated for a specific month with optional region, county, and unit parameters.', 'CFSR', 'Y');


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) 
values('ChildWithoutInvolvementInCasePlanningONG','00','1','7',
'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values
('ChildWithoutInvolvementInCasePlanningONG','00','2','2','CD_STAGE_REGION', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ChildWithoutInvolvementInCasePlanningONG','00','3','3','CD_STAGE_CNTY', 'CHAR', 'N', 'County');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ChildWithoutInvolvementInCasePlanningONG','00','4','2','NBR_UNIT', 'CHAR', 'N', 'Unit');

--STGAP00015097 - Update DBCR - Child Involvement Case Planning ONG

-- Enable drop down box for the Region/county report parameters to appear in the application 
--Report Development Defect #: STGAP00014619
--Creation of Report DBCR defect #: STGAP00015063

Update caps.report_parameter
set NM_RPT_PARM_NAME = 'REGIONCD'
 WHERE  NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningONG'
 and NM_RPT_SQR_VER = '00'
 and NBR_RPT_PARM_SEQ = 2;


Update caps.report_parameter
set NM_RPT_PARM_NAME = 'COUNTYCD'
 WHERE  NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningONG'
 and NM_RPT_SQR_VER = '00'
 and NBR_RPT_PARM_SEQ = 3;


Update caps.report_parameter
set NM_RPT_PARM_NAME = 'UNIT'
 WHERE  NM_RPT_SQR_NAME = 'ChildWithoutInvolvementInCasePlanningONG'
 and NM_RPT_SQR_VER = '00'
 and NBR_RPT_PARM_SEQ = 4;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (524, 'SacwisRev3', 'Release 3.2 - DBCR 15305,14401, 14516, 14521, 14590, 14627, 15097');

commit;


