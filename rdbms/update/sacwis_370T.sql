
-- Add 1 columns to PERSON to support Adoption Enhancements 

alter table caps.person add ind_adopt_finalized varchar2(1);
comment on column caps.person.ind_adopt_finalized is 'Indicator if child had a finalized adoption.  This will be used to exclude this child from search results.' ;


-- Add new fields to CAPS_RESOURCE

alter table caps.caps_resource add nbr_rsrc_contact_phn varchar2(10);
alter table caps.caps_resource add nbr_rsrc_contact_phone_ext varchar2(8);

comment on column caps.caps_resource.nbr_rsrc_contact_phn is 'Phone number for private agency case worker';
comment on column caps.caps_resource.nbr_rsrc_contact_phone_ext is 'Extension for private agency case worker';

-- New ADO_INFO_CBX_SENT Table

create table caps.ado_info_cbx_sent
(ID_ADO_INFO_CBX_SENT  number(16) not null,
ID_ADO_INFO number(16), 
DT_LAST_UPDATE date not null, 
DT_ADO_INFO_CBX_SENT date, 
CONSTRAINT PK_ADO_INFO_CBX_SENT PRIMARY KEY (ID_ADO_INFO_CBX_SENT) 
  using index tablespace index01, 
CONSTRAINT FK_CBX_SENT_ADO_INFO FOREIGN KEY (ID_ADO_INFO)
  REFERENCES CAPS.ADO_INFO (ID_EVENT) ENABLE) tablespace data01;

create index caps.ind_id_ado_info on caps.ado_info_cbx_sent(id_ado_info) tablespace index01;

comment on column caps.ado_info_cbx_sent.id_ado_info is 'Foreign Key to ADO_INFO';

grant select,update,insert,delete on caps.ado_info_cbx_sent to capson,capsbat,ops$datafix;
grant select on caps.ado_info_cbx_sent to operator;


CREATE SEQUENCE  CAPS.SEQ_ado_info_cbx_sent  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_ado_info_cbx_sent  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_ado_info_cbx_sent 
BEFORE UPDATE
ON CAPS.ado_info_cbx_sent
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ado_info_cbx_sent
BEFORE INSERT
ON CAPS.ado_info_cbx_sent
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_ado_info_cbx_sent=0 then
    SELECT SEQ_ado_info_cbx_sent.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_ado_info_cbx_sent := dummy;
  end if;
END;
/


-- New ADOPTION_SUBSIDY Fields

alter table caps.adoption_subsidy add dt_adpt_sub_terminated date;
comment on column caps.adoption_subsidy.dt_adpt_sub_terminated is 'Actual end date could differ from the DT_ADPT_SUB_END.' ;

alter table caps.adoption_subsidy add cd_payment_mthd varchar2(3);
comment on column caps.adoption_subsidy.cd_payment_mthd is 'Indicates if payments are to be made directly to the Service Provider or to the adoptive parent.';

alter table caps.adoption_subsidy add IND_DOC_SSI varchar2(1);
comment on column caps.adoption_subsidy.IND_DOC_SSI is 'Indicator if SSI documentation exists.';

alter table caps.adoption_subsidy add TXT_ICAMA_COMMENTS varchar2(300);
comment on column caps.adoption_subsidy.TXT_ICAMA_COMMENTS is 'Inter-state comments';


-- Expand TXT_COMMENTS on CPS_CHECKLIST

alter table CAPS.CPS_CHECKLIST modify (txt_comments varchar2(1000));



-- New Table EXCHANGE_CHILD

create table caps.EXCHANGE_CHILD (
ID_PERSON NUMBER (16) not null,
DT_LAST_UPDATE date not null,
ID_EVENT NUMBER(16) not null,
DT_OUT date,
CD_NON_AVAIL_STATUS VARCHAR(2),
IND_LEGAL_RISK VARCHAR2(1),
DT_NOTIFIED date,
DT_REGISTERED date,
DT_APPROVED date,
DT_RE_REGISTERED date,
TXT_RECRUIT_COMMENT VARCHAR2(500),
IND_MENTAL_RETARDATION VARCHAR2(1),
CD_SEV_MENTAL_RETARDATION date,
IND_VISUAL_HEARING_IMP VARCHAR2(1),
CD_SEV_VISUAL_HEARING_IMP VARCHAR2(2),
IND_PHYSICALLY_DISABLED VARCHAR2(1),
CD_SEV_PHYSICALLY_DISABLED VARCHAR2(2),
IND_EMOTIONALLY_DIST VARCHAR2 (1),
CD_SEV_EMOTIONALLY_DIST VARCHAR2(2),
IND_OTHER_MED VARCHAR2(1),
CD_SEV_OTHER_MED VARCHAR2(2),
IND_FAM_HX_DRUGS_ALCOHOL VARCHAR2(1),
IND_FAM_HX_MENTAL_ILL VARCHAR2(1),
IND_FAM_HX_MR VARCHAR2(1),
IND_CH_HX_SEXUAL_ABUSE VARCHAR2(1),
IND_BIO_IS_LEG_FATHER VARCHAR2 (1 Byte),
DT_CLOSE date,
CD_REASON_CLOSED VARCHAR2(2),
DT_FINAL date,
DT_FINAL_ENTERED date,
TXT_AVAIL_COMMENTS VARCHAR2(500),
TXT_EXPLANATION_NO_PLCMT VARCHAR2(500),
NBR_AFILE VARCHAR2(16),
CONSTRAINT PK_EXCHANGE_CHILD PRIMARY KEY (ID_EVENT) using index tablespace index01,
CONSTRAINT FK_EXCHANGE_CHILD_PERSON FOREIGN KEY (ID_PERSON)
   REFERENCES CAPS.person(ID_PERSON) ) tablespace data01;

comment on column caps.exchange_child.ID_PERSON is 'Id person of child';
comment on column caps.exchange_child.DT_OUT is 'date materials sent for consideration';
comment on column caps.exchange_child.CD_NON_AVAIL_STATUS is 'Child''s availability code';
comment on column caps.exchange_child.IND_LEGAL_RISK is 'Indicator if the child has legal risk';
comment on column caps.exchange_child.DT_NOTIFIED is 'Date SAU was notified of the child being free';
comment on column caps.exchange_child.DT_REGISTERED is 'Date child registered for exchange';
comment on column caps.exchange_child.DT_APPROVED is 'Date child approved for exchange';
comment on column caps.exchange_child.DT_RE_REGISTERED is 'Date child re-registered for exchange';
comment on column caps.exchange_child.TXT_RECRUIT_COMMENT is 'Comment about child recruiting activities';
comment on column caps.exchange_child.IND_MENTAL_RETARDATION is 'Indicator if the child has the characteristic Mental Retardation';
comment on column caps.exchange_child.CD_SEV_MENTAL_RETARDATION is 'Severity level of the characteristic Mental Retardation';
comment on column caps.exchange_child.IND_VISUAL_HEARING_IMP is 'Indicator if the child has the characteristic Visual or Hearing Impaired';
comment on column caps.exchange_child.CD_SEV_VISUAL_HEARING_IMP is 'Severity level of the characteristic Visual or Hearing Impaired';
comment on column caps.exchange_child.IND_PHYSICALLY_DISABLED is 'Indicator if the child has the characteristic Physically Disabled';
comment on column caps.exchange_child.CD_SEV_PHYSICALLY_DISABLED is 'Severity level of the characteristic Physically Disabled';
comment on column caps.exchange_child.IND_EMOTIONALLY_DIST is 'Indicator if the child has the characteristic Emotionally Disturbed';
comment on column caps.exchange_child.CD_SEV_EMOTIONALLY_DIST is 'Severity level of the characteristic Emotionally Disturbed';
comment on column caps.exchange_child.IND_OTHER_MED is 'Indicator if the child has the characteristic Other Medical Diagnosis';
comment on column caps.exchange_child.CD_SEV_OTHER_MED is 'Severity level of the characteristic Other Medical Diagnosis';
comment on column caps.exchange_child.IND_FAM_HX_DRUGS_ALCOHOL is 'Indicator if the child has the characteristic Family History of Drug/Alcohol Abuse';
comment on column caps.exchange_child.IND_FAM_HX_MENTAL_ILL is 'Indicator if the child has the characteristic Family History of Mental Illness';
comment on column caps.exchange_child.IND_FAM_HX_MR is 'Indicator if the child has the characteristic Family History of Mental Retardation';
comment on column caps.exchange_child.IND_CH_HX_SEXUAL_ABUSE is 'Indicator if the child has the characteristic Family History of Sexual Abuse';
comment on column caps.exchange_child.IND_BIO_IS_LEG_FATHER is 'Indicator if the child''s biological father is the same as the legal father';
comment on column caps.exchange_child.DT_CLOSE is 'Date the child was closed without placement';
comment on column caps.exchange_child.CD_REASON_CLOSED is 'Reason child was closed without placement';
comment on column caps.exchange_child.DT_FINAL is 'Date the finalization occurred';
comment on column caps.exchange_child.DT_FINAL_ENTERED is 'Date the finalization was documented';
comment on column caps.exchange_child.TXT_AVAIL_COMMENTS is 'Comments regarding the child''s availablility';
comment on column caps.exchange_child.TXT_EXPLANATION_NO_PLCMT is 'Comments about why the child was closed no placement.';
comment on column caps.exchange_child.NBR_AFILE is 'Afile number for child';

create index CAPS.IND_EXCHANGE_CHILD_PERSON on CAPS.EXCHANGE_CHILD(ID_PERSON)
 tablespace index01;

grant select,update,insert,delete on CAPS.EXCHANGE_CHILD to capson,capsbat,ops$datafix;
grant select on caps.exchange_child to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_EXCHANGE_CHILD 
BEFORE UPDATE
ON CAPS.EXCHANGE_CHILD
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EXCHANGE_CHILD
BEFORE INSERT
ON CAPS.EXCHANGE_CHILD
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/



-- New Table EXCHANGE_CHILD_FAM_LINK

create table caps.EXCHANGE_CHILD_FAM_LINK (
ID_EXCHANGE_CHILD_FAM_LINK number(16) not null,
DT_LAST_UPDATE date not null,
ID_EVENT_HOME_REGISTRATION NUMBER (16) not null,
ID_EVENT_CHILD_REGISTRATION NUMBER (16) not null,
DT_OUT DATE,
IND_LINK_CURRENT VARCHAR(1) not null,
CD_NON_SELECTION_RSN varchar2(2),
CD_NON_AVAIL_CODE VARCHAR2(2),
CONSTRAINT PK_EXCHANGE_CHILD_FAM_LINK PRIMARY KEY (ID_EXCHANGE_CHILD_FAM_LINK)
   using index tablespace index01,
CONSTRAINT FK_EXCHANGE_CHILD_FAM_LK_HM FOREIGN KEY (ID_EVENT_HOME_REGISTRATION) 
   REFERENCES CAPS.EVENT(ID_EVENT) ENABLE,
CONSTRAINT FK_EXCHANGE_CHILD_FAM_LK_CH FOREIGN KEY (ID_EVENT_CHILD_REGISTRATION)
   REFERENCES CAPS.EVENT(ID_EVENT) ENABLE) tablespace data01;

create index caps.IND_EXCHANGE_CHILD_FAM_LINK_1 on caps.EXCHANGE_CHILD_FAM_LINK(ID_EVENT_HOME_REGISTRATION) tablespace index01;
create index caps.IND_EXCHANGE_CHILD_FAM_LINK_2 on caps.EXCHANGE_CHILD_FAM_LINK(ID_EVENT_CHILD_REGISTRATION) tablespace index01;

comment on column caps.exchange_child_fam_link.ID_EXCHANGE_CHILD_FAM_LINK is 'Primary Key of table';
comment on column caps.exchange_child_fam_link.ID_EVENT_HOME_REGISTRATION is 'Event id of the home registration';
comment on column caps.exchange_child_fam_link.ID_EVENT_CHILD_REGISTRATION is 'Event id of the child registration';
comment on column caps.exchange_child_fam_link.DT_OUT is 'Date the family were linked';
comment on column caps.exchange_child_fam_link.IND_LINK_CURRENT is 'Indicator if they are currently linked';
comment on column caps.exchange_child_fam_link.CD_NON_SELECTION_RSN is 'Code that stores non-selection reason';
comment on column caps.exchange_child_fam_link.CD_NON_AVAIL_CODE is 'Availability code change for that specific link';

grant select,update,insert,delete on CAPS.EXCHANGE_CHILD_FAM_LINK to capson,capsbat,ops$datafix;
grant select on caps.EXCHANGE_CHILD_FAM_LINK to operator;

CREATE SEQUENCE  CAPS.SEQ_EXCHANGE_CHILD_FAM_LINK  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_EXCHANGE_CHILD_FAM_LINK  to capsbat,capson,ops$datafix;


/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_EXCHANGE_CHILD_FAM_LINK 
BEFORE UPDATE
ON CAPS.EXCHANGE_CHILD_FAM_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EXCHANGE_CHILD_FAM_LINK
BEFORE INSERT
ON CAPS.EXCHANGE_CHILD_FAM_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_EXCHANGE_CHILD_FAM_LINK=0 then
    SELECT SEQ_EXCHANGE_CHILD_FAM_LINK.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_EXCHANGE_CHILD_FAM_LINK := dummy;
  end if;
END;
/


--New Table EXCHANGE_HOME

create table caps.EXCHANGE_HOME
(ID_RESOURCE NUMBER(16) not null,
DT_LAST_UPDATE date not null,
ID_EVENT NUMBER(16) not null,
DT_APPROVED DATE,
DT_REGISTERED DATE,
DT_RE_REGISTERED DATE,
IND_MENTAL_RETARDATION VARCHAR2 (1),
CD_SEV_MENTAL_RETARDATION DATE,
IND_VISUAL_HEARING_IMP VARCHAR2 (1),
CD_SEV_VISUAL_HEARING_IMP VARCHAR2 (2),
IND_PHYSICALLY_DISABLED VARCHAR2 (1),
CD_SEV_PHYSICALLY_DISABLED VARCHAR2 (2),
IND_EMOTIONALLY_DIST VARCHAR2 (1),
CD_SEV_EMOTIONALLY_DIST VARCHAR2 (2),
IND_OTHER_MED VARCHAR2 (1),
CD_SEV_OTHER_MED VARCHAR2 (2),
IND_FAM_HX_DRUGS_ALCOHOL VARCHAR2 (1),
IND_FAM_HX_MENTAL_ILL VARCHAR2 (1),
IND_FAM_HX_MR VARCHAR2 (1),
IND_CH_HX_SEXUAL_ABUSE VARCHAR2 (1),
CD_NON_AVAIL_STATUS VARCHAR2 (2),
DT_OUT DATE,
TXT_COMMENTS VARCHAR2 (500),
DT_CLOSE DATE,
CD_REASON_CLOSED VARCHAR2(2),
TXT_EXPLANATION VARCHAR2(500),
DT_FINAL DATE,
DT_FINAL_ENTERED DATE,
NBR_CHILD_INTEREST NUMBER(3),
TXT_COMMENTS_INTEREST VARCHAR2(500),
NM_AGNCY_CASEWORKER VARCHAR2(30),
NBR_AGNCY_CONTACT_PHN VARCHAR2(10),
NBR_AGNCY_CONTACT_PHONE_EXT VARCHAR2(8),
TXT_FAMILY_IS_LINKED VARCHAR2(500),
NBR_AFILE VARCHAR2(16),
TXT_CHILD_PLACED_WITH VARCHAR2(500),
CONSTRAINT PK_EXCHANGE_HOME PRIMARY KEY (ID_EVENT)
    using index tablespace index01,
CONSTRAINT FK_EXCHANGE_HOME_RSRC FOREIGN KEY (ID_RESOURCE)
    REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE) ENABLE) tablespace data01;

create index caps.IND_EXCHANGE_HOME_1 on caps.EXCHANGE_HOME(ID_RESOURCE) tablespace index01;

comment on column caps.exchange_home.ID_RESOURCE is 'Resource id of home';
comment on column caps.exchange_home.ID_EVENT is 'Event id of the home registration event';
comment on column caps.exchange_home.DT_APPROVED is 'Date home was approved for the exchange';
comment on column caps.exchange_home.DT_REGISTERED is 'Date home was registered for the exchange';
comment on column caps.exchange_home.DT_RE_REGISTERED is 'Date home was re-registered for the exchange';
comment on column caps.exchange_home.IND_MENTAL_RETARDATION is 'Indicator if the home will accept the characteristic Mental Retardation';
comment on column caps.exchange_home.CD_SEV_MENTAL_RETARDATION is 'Severity level of the characteristic Mental Retardation';
comment on column caps.exchange_home.IND_VISUAL_HEARING_IMP is 'Indicator if the home will accept the characteristic Visual or Hearing Impaired';
comment on column caps.exchange_home.CD_SEV_VISUAL_HEARING_IMP is 'Severity level of the characteristic Visual or Hearing Impaired';
comment on column caps.exchange_home.IND_PHYSICALLY_DISABLED is 'Indicator if the home will accept the characteristic Physically Disabled';
comment on column caps.exchange_home.CD_SEV_PHYSICALLY_DISABLED is 'Severity level of the characteristic Physically Disabled';
comment on column caps.exchange_home.IND_EMOTIONALLY_DIST is 'Indicator if the home will accept the characteristic Emotionally Disturbed';
comment on column caps.exchange_home.CD_SEV_EMOTIONALLY_DIST is 'Severity level of the characteristic Emotionally Disturbed';
comment on column caps.exchange_home.IND_OTHER_MED is 'Indicator if the home will accept the characteristic Other Medical Diagnosis';
comment on column caps.exchange_home.CD_SEV_OTHER_MED is 'Severity level of the characteristic Other Medical Diagnosis';
comment on column caps.exchange_home.IND_FAM_HX_DRUGS_ALCOHOL is 'Indicator if the home will accept the characteristic Family History of Drug/Alcohol Abuse';
comment on column caps.exchange_home.IND_FAM_HX_MENTAL_ILL is 'Indicator if the home will accept the characteristic Family History of Mental Illness';
comment on column caps.exchange_home.IND_FAM_HX_MR is 'Indicator if the home will accept the characteristic Family History of Mental Retardation';
comment on column caps.exchange_home.IND_CH_HX_SEXUAL_ABUSE is 'Indicator if the home will accept the characteristic Child History of Sexual Abuse';
comment on column caps.exchange_home.CD_NON_AVAIL_STATUS is 'Non-Availability Status code';
comment on column caps.exchange_home.DT_OUT is 'Date the home study was sent out to the county';
comment on column caps.exchange_home.TXT_COMMENTS is 'Comments regarding the home study being sent';
comment on column caps.exchange_home.DT_CLOSE is 'Date the home was closed without placement';
comment on column caps.exchange_home.CD_REASON_CLOSED is 'Reason home was closed without placement';
comment on column caps.exchange_home.TXT_EXPLANATION is 'Explanation why the home was closed';
comment on column caps.exchange_home.DT_FINAL is 'Date the finalization occurred';
comment on column caps.exchange_home.DT_FINAL_ENTERED is 'Date the finalization was documented';
comment on column caps.exchange_home.nbr_child_interest is 'Number of children home is interested in';
comment on column caps.exchange_home.txt_comments_interest is 'Comments regarding the home preferences';
comment on column caps.exchange_home.nm_agncy_caseworker is 'Name of the private agency case worker';
comment on column caps.exchange_home.nbr_agncy_contact_phn is 'Phone number for private agency case worker';
comment on column caps.exchange_home.nbr_agncy_contact_phone_ext is 'Extension for private agencycase worker';
comment on column caps.exchange_home.txt_family_is_linked is 'Textbox to keep family is linked information';
comment on column caps.exchange_home.nbr_afile is 'Afile number for the family';
comment on column caps.exchange_home.txt_child_placed_with is 'Textbox to keep child placed with information';

CREATE SEQUENCE  CAPS.SEQ_EXCHANGE_HOME  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_EXCHANGE_HOME  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_EXCHANGE_HOME 
BEFORE UPDATE
ON CAPS.EXCHANGE_HOME
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EXCHANGE_HOME
BEFORE INSERT
ON CAPS.EXCHANGE_HOME
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


grant select,update,insert,delete on CAPS.EXCHANGE_HOME to capson,capsbat,ops$datafix;
grant select on caps.EXCHANGE_HOME to operator;


-- New Table HOME_ETHNICITY

create table caps.HOME_ETHNICITY
(ID_HOME_ETHNICITY NUMBER(16),
DT_LAST_UPDATE DATE,
ID_RESOURCE NUMBER(16),
CD_ETHNICITY VARCHAR2 (2),
CONSTRAINT PK_HOME_ETHNICITY PRIMARY KEY (ID_HOME_ETHNICITY) using index tablespace index01,
CONSTRAINT FK_HOME_ETHNICITY_RESOURCE FOREIGN KEY (ID_RESOURCE)
          REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE) ENABLE ) tablespace data01;

create index caps.IND_HOME_ETHNICITY_1 on caps.HOME_ETHNICITY(ID_RESOURCE) tablespace index01;

comment on column caps.home_ethnicity.ID_HOME_ETHNICITY is 'Primary key of table';
comment on column caps.home_ethnicity.DT_LAST_UPDATE is 'date last updated';
comment on column caps.home_ethnicity.ID_RESOURCE is 'foreign key to id resource';
comment on column caps.home_ethnicity.CD_ETHNICITY is 'ethnicity code';

grant select,update,insert,delete on CAPS.HOME_ETHNICITY to capson,capsbat,ops$datafix;
grant select on caps.HOME_ETHNICITY to operator;


CREATE SEQUENCE  CAPS.SEQ_HOME_ETHNICITY  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_HOME_ETHNICITY  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_HOME_ETHNICITY
BEFORE UPDATE
ON CAPS.HOME_ETHNICITY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_HOME_ETHNICITY
BEFORE INSERT
ON CAPS.HOME_ETHNICITY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_HOME_ETHNICITY=0 then
    SELECT SEQ_HOME_ETHNICITY.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_HOME_ETHNICITY := dummy;
  end if;
END;
/



-- New Table HOME_RACE

create table caps.HOME_RACE
(ID_HOME_RACE NUMBER(16),
DT_LAST_UPDATE DATE,
ID_RESOURCE NUMBER(16),
CD_RACE	VARCHAR2 (2),
CONSTRAINT PK_HOME_RACE PRIMARY KEY (ID_HOME_RACE) using index tablespace index01,
CONSTRAINT FK_HOME_RACE_RESOURCE FOREIGN KEY (ID_RESOURCE)
           REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE) ENABLE ) tablespace data01;

comment on column caps.HOME_RACE.ID_HOME_RACE is 'Primary key of table';
comment on column caps.HOME_RACE.DT_LAST_UPDATE is 'date last updated';
comment on column caps.HOME_RACE.ID_RESOURCE is 'foreign key to id resource';
comment on column caps.HOME_RACE.CD_RACE is 'Race code';

create index caps.IND_HOME_RACE_1 on caps.HOME_RACE(ID_RESOURCE) tablespace index01;

grant select,update,insert,delete on CAPS.HOME_RACE to capson,capsbat,ops$datafix;
grant select on caps.HOME_RACE to operator;

CREATE SEQUENCE  CAPS.SEQ_HOME_RACE  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_HOME_RACE  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_HOME_RACE
BEFORE UPDATE
ON CAPS.HOME_RACE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_HOME_RACE
BEFORE INSERT
ON CAPS.HOME_RACE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_HOME_RACE=0 then
    SELECT SEQ_HOME_RACE.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_HOME_RACE := dummy;
  end if;
END;
/



--New Table NON_INCIDIENT_AFCARS_INFO

create table CAPS.NON_INCIDENT_AFCARS_INFO
(ID_PERSON NUMBER(16) not null,
DT_LAST_UPDATE date not null,
ID_CASE NUMBER(16) not null,
DT_APP_SENT DATE,
CD_CHILD_PLACED_BY VARCHAR2(2),
DT_BM_RIGHT_TERMINATED DATE,
DT_BM_DOB DATE,
CD_BM_TERMINATION_TYPE VARCHAR2(2),
IND_BM_RACE_AA VARCHAR2(1),
IND_BM_RACE_AN VARCHAR2(1),
IND_BM_RACE_BK VARCHAR2(1),
IND_BM_RACE_HP VARCHAR2(1),
IND_BM_RACE_UD VARCHAR2(1),
IND_BM_RACE_WT VARCHAR2(1),
IND_BM_ETHNICITY VARCHAR2(1),
DT_BF_DOB DATE,
DT_BF_RIGHT_TERMINATED DATE,
CD_BF_TERMINATION_TYPE VARCHAR2(2),
IND_BF_RACE_AA VARCHAR2(1),
IND_BF_RACE_AN VARCHAR2(1),
IND_BF_RACE_BK VARCHAR2(1),
IND_BF_RACE_HP VARCHAR2(1),
IND_BF_RACE_UD VARCHAR2(1),
IND_BF_RACE_WT VARCHAR2(1),
IND_BF_ETHNICITY VARCHAR2(1),
NM_BN_FIRST VARCHAR2(12),
NM_BN_MIDDLE VARCHAR2(12),
NM_BN_LAST VARCHAR2(22),
CONSTRAINT PK_NON_INCIDENT_AFCARS_INFO PRIMARY KEY (ID_PERSON)
     using index tablespace index01,
CONSTRAINT FK_NON_INCIDENT_AFCARS_CASE FOREIGN KEY (ID_CASE)
     REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE) tablespace data01;

comment on column caps.non_incident_afcars_info.ID_PERSON is 'child''s person id';
comment on column caps.non_incident_afcars_info.ID_CASE is 'case id associated with case.';
comment on column caps.non_incident_afcars_info.DT_APP_SENT is 'date application sent to family.';
comment on column caps.non_incident_afcars_info.CD_CHILD_PLACED_BY is 'Agency that placed the child';
comment on column caps.non_incident_afcars_info.DT_BM_DOB is 'birth mother''s date of birth';
comment on column caps.non_incident_afcars_info.DT_BM_RIGHT_TERMINATED is 'date birth mother''s rights were terminated.';
comment on column caps.non_incident_afcars_info.CD_BM_TERMINATION_TYPE is 'Type of termination of birth mother''s rights.';
comment on column caps.non_incident_afcars_info.IND_BM_RACE_AA is 'birth mother''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BM_RACE_AN is 'birth mother''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BM_RACE_BK is 'birth mother''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BM_RACE_HP is 'birth mother''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BM_RACE_UD is 'birth mother''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BM_RACE_WT is 'birth mother''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BM_ETHNICITY is 'birth mother''s ethnicity indicator';
comment on column caps.non_incident_afcars_info.DT_BF_DOB is 'birth father''s date of birth';
comment on column caps.non_incident_afcars_info.DT_BF_RIGHT_TERMINATED is 'date birth father''s rights were terminated.';
comment on column caps.non_incident_afcars_info.CD_BF_TERMINATION_TYPE is 'Type of termination of birth father''s rights.';
comment on column caps.non_incident_afcars_info.IND_BF_RACE_AA is 'Birth Father''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BF_RACE_AN is 'Birth Father''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BF_RACE_BK is 'Birth Father''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BF_RACE_HP is 'Birth Father''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BF_RACE_UD is 'Birth Father''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BF_RACE_WT is 'Birth Father''s race indicator';
comment on column caps.non_incident_afcars_info.IND_BF_ETHNICITY is 'Birth Father''s ethnicity indicator';
comment on column caps.non_incident_afcars_info.NM_BN_FIRST is 'birth first name';
comment on column caps.non_incident_afcars_info.NM_BN_MIDDLE is 'birth last name';
comment on column caps.non_incident_afcars_info.NM_BN_LAST is 'birth middle name';


create index caps.IND_NON_INCIDENT_AFCARS_INFO_1 on caps.NON_INCIDENT_AFCARS_INFO(ID_CASE) tablespace index01;

grant select,update,insert,delete on CAPS.NON_INCIDENT_AFCARS_INFO to capson,capsbat,ops$datafix;
grant select on caps.NON_INCIDENT_AFCARS_INFO to operator;


/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_NON_INCIDENT_AFCARS_INFO 
BEFORE UPDATE
ON CAPS.NON_INCIDENT_AFCARS_INFO
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_NON_INCIDENT_AFCARS_INFO
BEFORE INSERT
ON CAPS.NON_INCIDENT_AFCARS_INFO
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


-- New Table SIBLING
create table caps.SIBLING
(id_sibling_group number(16),
dt_last_update date not null,
id_person number(16),
constraint fk_sibling_person foreign key (id_person)
   references caps.person(id_person) enable) tablespace data01;

comment on column caps.sibling.id_sibling_group is 'Group that child belongs to';
comment on column caps.sibling.id_person is 'Child''s person id';

create index caps.IND_SIBLING_1 on CAPS.SIBLING(id_sibling_group) tablespace index01;
create index caps.IND_SIBLING_2 on CAPS.SIBLING(id_person) tablespace index01;

grant select,update,insert,delete on CAPS.SIBLING to capson,capsbat,ops$datafix;
grant select on caps.SIBLING to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_SIBLING 
BEFORE UPDATE
ON CAPS.SIBLING
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SIBLING
BEFORE INSERT
ON CAPS.SIBLING
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

-- New Table SIBLING_GROUP
create table caps.SIBLING_GROUP
(id_sibling_group number(16),
dt_last_update date not null,
nbr_in_group number(2),
nbr_avail number(2),
id_case number(16),
CONSTRAINT PK_SIBLING_GROUP PRIMARY KEY (ID_SIBLING_GROUP) using index tablespace index01,
CONSTRAINT FK_SIBLING_GROUP_CASE FOREIGN KEY (ID_CASE)
   REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE) tablespace data01;

CREATE SEQUENCE  CAPS.SEQ_SIBLING_GROUP  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_SIBLING_GROUP  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_SIBLING_GROUP 
BEFORE UPDATE
ON CAPS.SIBLING_GROUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SIBLING_GROUP
BEFORE INSERT
ON CAPS.SIBLING_GROUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_SIBLING_GROUP=0 then
    SELECT SEQ_SIBLING_GROUP.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_SIBLING_GROUP := dummy;
  end if;
END;
/

create index CAPS.IND_SIBLING_GROUP_1 on CAPS.SIBLING_GROUP(id_case) tablespace index01;

comment on column caps.sibling_group.ID_SIBLING_GROUP is 'Primary key of table';
comment on column caps.sibling_group.NBR_IN_GROUP is 'Number of children in group';
comment on column caps.sibling_group.NBR_AVAIL is 'Number available for adoption.';
comment on column caps.sibling_group.ID_CASE is 'Case the siblings are associated with';

grant select,update,insert,delete on CAPS.SIBLING_GROUP to capson,capsbat,ops$datafix;
grant select on caps.SIBLING_GROUP to operator;


-- New Table SPCL_SVC_AAA_NARR

create table caps.SPCL_SVC_AAA_NARR
(ID_STAGE NUMBER(16) not null,
dt_last_update date not null,
ID_EVENT NUMBER(16) not null,
ID_CASE NUMBER(16),
NARRATIVE LONG RAW,
ID_DOCUMENT_TABLE NUMBER(16),
CONSTRAINT PK_SPCL_SVC_AAA_NARR PRIMARY KEY (ID_EVENT)  using index tablespace index01,
CONSTRAINT FK_SPCL_SVC_STAGE FOREIGN KEY (ID_STAGE)
   REFERENCES CAPS.STAGE(ID_STAGE) ENABLE) tablespace data01;

grant select,update,insert,delete on CAPS.SPCL_SVC_AAA_NARR to capson,capsbat,ops$datafix;
grant select on caps.SPCL_SVC_AAA_NARR to operator;


/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPCL_SVC_AAA_NARR 
BEFORE UPDATE
ON CAPS.SPCL_SVC_AAA_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SPCL_SVC_AAA_NARR
BEFORE INSERT
ON CAPS.SPCL_SVC_AAA_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

create index caps.ind_SPCL_SVC_AAA_NARR_1 on CAPS.SPCL_SVC_AAA_NARR(id_stage) tablespace index01;
create index caps.ind_SPCL_SVC_AAA_NARR_2 on CAPS.SPCL_SVC_AAA_NARR(id_case) tablespace index01;



-- New Fields for SPECIAL_NEEDS_DETERMINATION

alter table caps.SPECIAL_NEEDS_DETERMINATION add cd_payment_mthd varchar2(3) ;
alter table caps.SPECIAL_NEEDS_DETERMINATION add cd_rate_type varchar2(3) ;
alter table caps.SPECIAL_NEEDS_DETERMINATION add ind_basic_rate_req_child varchar2(1) ;
alter table caps.SPECIAL_NEEDS_DETERMINATION add ind_sfc_rbwo_rcvd varchar2(1) ;

comment on column caps.SPECIAL_NEEDS_DETERMINATION.cd_payment_mthd is 'Indicates if payments are to be made directly to the Service Provider or to the adoptive parent.';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.cd_rate_type is 'Indicate if the adoption assistance rate type will be basic or specialized.';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.ind_basic_rate_req_child is 'Indicates if a basic rate is being requested';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.ind_sfc_rbwo_rcvd is 'Indicates if child is receiving a special foster care per-diem';


-- New Table - ADO_ASST_AGREEMENT_NARR

create table caps.ADO_ASST_AGREEMENT_NARR
(ID_STAGE NUMBER(16) not null,
DT_LAST_UPDATE date not null,
ID_EVENT NUMBER(16) not null,
ID_CASE NUMBER(16),
NARRATIVE LONG RAW,
ID_DOCUMENT_TABLE NUMBER(16),
CONSTRAINT PK_ADO_ASST_AGREEMENT_NARR PRIMARY KEY (ID_EVENT) 
   using index tablespace index01,
CONSTRAINT FK_ADO_ASST_AGREE_ID_STAGE FOREIGN KEY (ID_STAGE) 
  REFERENCES CAPS.STAGE(ID_STAGE) ENABLE) tablespace data01;

grant select,update,insert,delete on CAPS.ADO_ASST_AGREEMENT_NARR to capson,capsbat,ops$datafix;
grant select on caps.ADO_ASST_AGREEMENT_NARR to operator;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_ADO_ASST_AGREEMENT_NARR 
BEFORE UPDATE
ON CAPS.ADO_ASST_AGREEMENT_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ADO_ASST_AGREEMENT_NARR
BEFORE INSERT
ON CAPS.ADO_ASST_AGREEMENT_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


create index caps.IND_ADO_ASST_AGREEMENT_NARR_1 on CAPS.ADO_ASST_AGREEMENT_NARR(id_stage) tablespace index01;
create index caps.IND_ADO_ASST_AGREEMENT_NARR_2 on CAPS.ADO_ASST_AGREEMENT_NARR(id_case) tablespace index01;

-- New Table - ADO_ASST_MEM_NARR

create table caps.ADO_ASST_MEM_NARR
(ID_EVENT NUMBER(16) not null,
dt_last_update date not null,
ID_CASE NUMBER(16),
NARRATIVE LONG RAW,
ID_DOCUMENT_TABLE NUMBER(16),
CONSTRAINT PK_ADO_ASST_MEM_NARR PRIMARY KEY (ID_EVENT)
   using index tablespace index01,
CONSTRAINT FK_ADO_ASST_MEM_CASE FOREIGN KEY (ID_CASE)
   REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE) tablespace data01;

create index caps.IND_ADO_ASST_MEM_NARR_1 on CAPS.ADO_ASST_MEM_NARR(id_case) tablespace index01;

grant select,update,insert,delete on CAPS.ADO_ASST_MEM_NARR to capson,capsbat,ops$datafix;
grant select on caps.ADO_ASST_MEM_NARR to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_ADO_ASST_MEM_NARR 
BEFORE UPDATE
ON CAPS.ADO_ASST_MEM_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ADO_ASST_MEM_NARR
BEFORE INSERT
ON CAPS.ADO_ASST_MEM_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

-- New Table - ADO_SUBSIDY_RATE

create table caps.ADO_SUBSIDY_RATE
(ID_ADO_SUBSIDY_RATE NUMBER(16) not null,
dt_last_update date not null,
CD_RATE_TYPE VARCHAR2 (2) not null,
NUM_MIN_AGE NUMBER (4),
NUM_MAX_AGE NUMBER (4),
AMT_ADPT_SUB NUMBER (6,2) not null,
CONSTRAINT PK_ADO_SUBSIDY_RATE PRIMARY KEY (ID_ADO_SUBSIDY_RATE) using index tablespace index01) tablespace data01;

grant select,update,insert,delete on CAPS.ADO_SUBSIDY_RATE to capson,capsbat,ops$datafix;
grant select on caps.ADO_SUBSIDY_RATE to operator;

CREATE SEQUENCE  CAPS.SEQ_ADO_SUBSIDY_RATE  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_ADO_SUBSIDY_RATE  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_ADO_SUBSIDY_RATE 
BEFORE UPDATE
ON CAPS.ADO_SUBSIDY_RATE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ADO_SUBSIDY_RATE
BEFORE INSERT
ON CAPS.ADO_SUBSIDY_RATE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_ADO_SUBSIDY_RATE=0 then
    SELECT SEQ_ADO_SUBSIDY_RATE.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_ADO_SUBSIDY_RATE := dummy;
  end if;
END;
/

comment on column caps.ado_subsidy_rate.ID_ADO_SUBSIDY_RATE is 'Primary key of table';
comment on column caps.ado_subsidy_rate.CD_RATE_TYPE  is 'The type of rate';
comment on column caps.ado_subsidy_rate.NUM_MIN_AGE is 'minum age';
comment on column caps.ado_subsidy_rate.NUM_MAX_AGE is 'maximum age';
comment on column caps.ado_subsidy_rate.AMT_ADPT_SUB is 'Amount of Subsidy';


-- New Table - FOSTER_HOME_CONV

create table caps.FOSTER_HOME_CONV
(ID_RESOURCE NUMBER (16) not null,
dt_last_update date not null,
ID_EVENT NUMBER(16) not null,
ID_ADO_AGENCY NUMBER (16),
DT_INQUIRY DATE,
DT_APPLIED DATE,
DT_APPROVAL DATE,
DT_CLOSURE DATE,
CD_CLOSURE_REASON VARCHAR2 (2),
CD_CONV_APP_STATUS VARCHAR2 (2),
CONSTRAINT PK_FOSTER_HOME_CONV PRIMARY KEY (ID_EVENT)
   using index tablespace index01,
CONSTRAINT FK_FOSTER_HOME_CONV_RSRC FOREIGN KEY (ID_RESOURCE)
   REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE) ENABLE,
CONSTRAINT FK_FOSTER_HOME_CONV_ADO_AGENCY FOREIGN KEY (ID_ADO_AGENCY)
   REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE) ENABLE) tablespace data01;

grant select,update,insert,delete on caps.FOSTER_HOME_CONV to capson,capsbat,ops$datafix;
grant select on caps.FOSTER_HOME_CONV to operator;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_FOSTER_HOME_CONV 
BEFORE UPDATE
ON CAPS.FOSTER_HOME_CONV
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_FOSTER_HOME_CONV
BEFORE INSERT
ON CAPS.FOSTER_HOME_CONV
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

create index caps.ind_FOSTER_HOME_CONV_1 on CAPS.FOSTER_HOME_CONV(id_resource) tablespace index01;

comment on column caps.foster_home_conv.ID_RESOURCE is 'Resource id of foster home';
comment on column caps.foster_home_conv.ID_ADO_AGENCY is 'Resource id of Adoption agency';
comment on column caps.foster_home_conv.DT_INQUIRY is 'Inquiry date for the foster home conversion';
comment on column caps.foster_home_conv.DT_APPLIED is 'Applied date for the foster home conversion';
comment on column caps.foster_home_conv.CD_CLOSURE_REASON is 'Reason for ending foster home conversion';
comment on column caps.foster_home_conv.id_event is 'Event id of the Foster Home Conversion event';
comment on column caps.foster_home_conv.dt_approval is 'Date home was approved';
comment on column caps.foster_home_conv.dt_closure is 'Closure date of the foster home conversion';
comment on column caps.foster_home_conv.cd_conv_app_status is 'Approval status of the home';




--- New fields for INITIAL_MEDICAID_APP table
alter table caps.INITIAL_MEDICAID_APP add IND_ICAMA_ICPC varchar2(1);
alter table caps.INITIAL_MEDICAID_APP add CD_ICAMA_ASSISTANCE_TYPE varchar2(3);
alter table caps.INITIAL_MEDICAID_APP add CD_ADOPTION_TYPE varchar2(3);
alter table caps.INITIAL_MEDICAID_APP add CD_ICAMA_STATE varchar2(3);

comment on column caps.INITIAL_MEDICAID_APP.IND_ICAMA_ICPC is 'Indicator if child receives out of state assistance';
comment on column caps.INITIAL_MEDICAID_APP.CD_ICAMA_ASSISTANCE_TYPE is 'Inter-state assistance type';
comment on column caps.INITIAL_MEDICAID_APP.CD_ADOPTION_TYPE is 'Inter-state adoption type';
comment on column caps.INITIAL_MEDICAID_APP.CD_ICAMA_STATE is 'Inter-state state';

-- New fields for ADO_INFO

alter table caps.ado_info add txt_child_linked varchar2(300);
alter table caps.ado_info add txt_cons_comments varchar2(300);
alter table caps.ado_info add dt_letter_sent date;

comment on column caps.ado_info.txt_cons_comments is 'Field will be used to specify families that may have been considered by county for adopting child.' ;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
{ call dbms_utility.compile_schema('ORS') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (371, 'SacwisRev3', 'Release 3.0 - DBCR 9954 Adoption Enhancements');
commit;

