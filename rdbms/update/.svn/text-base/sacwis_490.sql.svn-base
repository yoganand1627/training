--STGAP00014593 - DBCR for Safety, Permanency and Well Being Narrative


-- Drop the tables if they exist
--drop table caps.SPWB_CHCK_LIST_LOOKUP;
--drop table caps.SPWB_AGE_GROUP_LOOKUP
--drop sequence caps.SEQ_SPWB_AGE_GROUP_LOOKUP

-- Create the new tables to hold checklist and age groups
create table caps.SPWB_CHCK_LIST_LOOKUP
(
CD_CHCK_LIST VARCHAR2(10) not null,
TXT_CHCK_LIST VARCHAR2(300) not null,
CD_AUDIENCE VARCHAR2 (10),
CD_MAIN_CATEGORY VARCHAR2(10),
CD_SUB_CATEGORY	VARCHAR2(10),
DT_LAST_UPDATE DATE not null,
constraint pk_SPWB_CHCK_LIST_LOOKUP PRIMARY KEY (cd_chck_list) using index tablespace index01) tablespace data01;

comment on table CAPS.SPWB_CHCK_LIST_LOOKUP is 'Static table to store checklist of questions for Safety, Permanency, WellBeing Form';
comment on column caps.SPWB_CHCK_LIST_LOOKUP.CD_CHCK_LIST is 'Code type for checklist question';
comment on column caps.SPWB_CHCK_LIST_LOOKUP.TXT_CHCK_LIST is 'Text for the question';
comment on column caps.SPWB_CHCK_LIST_LOOKUP.CD_SUB_CATEGORY is 'Sub-category for question';
comment on column caps.SPWB_CHCK_LIST_LOOKUP.DT_LAST_UPDATE is 'System Date';
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPWB_CHCK_LIST_LOOKUP
BEFORE UPDATE
ON CAPS.SPWB_CHCK_LIST_LOOKUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

grant select,update,insert,delete on CAPS.SPWB_CHCK_LIST_LOOKUP to capson,capsbat,ops$datafix;
grant select on caps.SPWB_CHCK_LIST_LOOKUP to operator;

create table caps.SPWB_AGE_GROUP_LOOKUP
(
ID_SPWB_AGE_GROUP NUMBER(16) not null,
CD_CHCK_LIST VARCHAR2(10) not null,
NBR_MONTH_MIN NUMBER(16) not null,
NBR_MONTH_MAX NUMBER(16) not null,
DT_LAST_UPDATE DATE not null,
constraint pk_SPWB_AGE_GROUP_LOOKUP PRIMARY KEY (id_spwb_age_group) using index tablespace index01) tablespace data01;

comment on table CAPS.SPWB_AGE_GROUP_LOOKUP is 'Static table to store age ranges for questions in the Safety, Permanency, WellBeing Form';
comment on column caps.SPWB_AGE_GROUP_LOOKUP.ID_SPWB_AGE_GROUP is 'Primary key for lookup table';
comment on column caps.SPWB_AGE_GROUP_LOOKUP.CD_CHCK_LIST is 'Code type for checklist question';
comment on column caps.SPWB_AGE_GROUP_LOOKUP.NBR_MONTH_MIN is 'Minimum age for the question';
comment on column caps.SPWB_AGE_GROUP_LOOKUP.NBR_MONTH_MAX is 'Maximum age for the question';
comment on column caps.SPWB_AGE_GROUP_LOOKUP.DT_LAST_UPDATE is 'System Date';

CREATE SEQUENCE  CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

-- The grant statement below has been added to make the script work with 
-- SQLPlus and the ant script
grant select on caps.person to capson;
/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPWB_AGE_GROUP_LOOKUP
BEFORE UPDATE
ON CAPS.SPWB_AGE_GROUP_LOOKUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SPWB_AGE_GROUP_LOOKUP
BEFORE INSERT
ON CAPS.SPWB_AGE_GROUP_LOOKUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_SPWB_AGE_GROUP=0 then
    SELECT SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL INTO dummy FROM DUAL;
    :NEW.ID_SPWB_AGE_GROUP := dummy;
  end if;
END;
/

grant select,update,insert,delete on CAPS.SPWB_AGE_GROUP_LOOKUP to capson,capsbat,ops$datafix;
grant select on caps.SPWB_AGE_GROUP_LOOKUP to operator;
grant select on CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP  to capsbat,capson,ops$datafix;


DELETE FROM CAPS.SPWB_CHCK_LIST_LOOKUP;
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BSQ1','Did this child have any serious injuries, either before or since coming into your care?', 'BS', SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BSQ2','Does your child have any chronic health conditions?  Do you have all the necessary medication and supplies?','BS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BSQ3','Do you have a First Aid Kit in your home? ','BS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BSQ4','TVs and other pieces of standing furniture secured so that they cannot be pulled over?','BS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BSQ5','Exposed wires or appliance cords in reach of children?','BS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('PFQ1','Are there child safety window guards on all windows above the first floor?','PF',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('PFQ2','Are safety gates installed at the top and bottom of all staircases?','PF',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('STQ1','When you put your child to sleep in his/her crib, do you put them on their stomach or their back? ','ST',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('STQ2','Do you put any soft bedding beneath the baby?','ST',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('STQ3','Do you use pillows or heavy comforters in the crib?','ST',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('STQ4','Does your child ever sleep in bed with you or with other children?','ST',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('STQ5','Are there any window blinds or curtain cords near your baby''s crib or other furniture?','ST',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('STQ6','Do you tie a pacifier around your child''s neck or to his/her clothing with a string or ribbon? ','ST',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('STQ7','Do you ever cover mattresses with plastic or a plastic bag?','ST',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CSQ1','Does crib have any missing, loose, improperly installed or broken hardware?','CS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CSQ2','Are crib slats more than two and three-eighths inches apart?','CS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CSQ3','Are there any corner posts over the end panels of crib?','CS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CSQ4','Do the headboards or footboards have any cutout areas?','CS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CSQ5','Is paint cracked or peeling?','CS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CSQ6','Are there any splinters or rough edges?','CS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CSQ7','Are top rails of crib less than 3/4 of the child''s height? ','CS',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BTQ1','What do you do if the telephone or doorbell rings while you are giving your child a bath?','BT',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BTQ2','Do you use bathtub seats with suction cups?','BT',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('BTQ3','Do you check the water temperature to make sure that the bath is not too hot or too cold?','BT',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CCQ1','Who takes care of your child when you are not home?  How do you know this person? How old is this person? Is there a way for your child to reach you when you are away from home? ','CC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CCQ2','Is there a list of phone numbers for your doctor, local hospital, police, fire department, poison control center and a friend or neighbor near the phone?','CC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('CCQ3','Does this child go to daycare or pre-school?  If so, how many hours per week?  How does your child get there? Who is responsible for drop-off and pick-up?','CC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SAQ1','Who watches your child when they play out-of doors?','SA',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SAQ2','Does your child know what to do if a stranger talks to him or her on the street?','SA',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SAQ3','Does your child know your address and phone number? (Kids this age may know only part of the answer to these questions)','SA',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ1','Who provides supervision for your child when you are not home?  How do you know this person? How old is this person? Is there a way for your child to reach you when you are away from home? ','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ2','When you are not at home, who provides supervision? Is there a way for your youth to reach you when you are away from home?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ3','How does your child/youth get to and from school?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ4','Who watches your child when they play outdoors?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ5','Do you know where your child/youth is when s/he is not at school and away from home?  Is there a way for your youth to reach you when s/he is away from home? ','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ6','Does your child know your address and phone number? ','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ7','Does your child know what to do if a stranger talks to him/her on the street?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ8','Do you feel your youth is able to exhibit good judgment when approached by strangers?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ9','Do you know who your child''s/youth''s friends are?  ','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ10','Is there a list of phone numbers for your doctor, local hospital, police, fire department, poison control center and a friend or neighbor near the phone?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ11','Does your child know what to do in case of an emergency?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ12','Does your child/youth know what to do in case of an emergency?  Does your youth know where smoke alarms and carbon monoxide alarms are located in your home?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ13','Did this child/youth have any serious injuries, either before or since coming into your care?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ14','Does your child/youth have any chronic health conditions?  Do you have the necessary medications, medical equipment, and medical staff support to adequately deal with this condition?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ15','Do you have a First Aid Kit in your home?  Does your child/youth know where it is and how to use it?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ16','Are there child safety window guards on all windows above the first floor?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ17','Does your child wear safety gear, including a helmet, for activities such as cycling, in-line skating, skateboarding or riding a scooter?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ18','Have you explained the concept of date rape to your youth. Have you empowered your youth to resist being pressured or forced into unwanted sexual activity?','SC',SYSDATE,  'CG', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCQ19','Have talked with your youth about the health risks of alcohol, tobacco, and drug abuse. ','SC',SYSDATE,  'CG', 'SAF');


INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ1','Do you ever stay at home by yourself without any grown ups there?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ2','Are you ever left alone without any grown ups around?  What is this like for you?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ3','Are you ever left alone without any grown ups around?  ',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ4','Do you ever sleep over at somebody else''s house?  Do you like this?  Do you do this a little or a lot?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ5','Do you ever stay over at someone else''s house? How often do you do this?  Do you like this?  ',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ6','Who takes care of you if ____________ (caregiver''s name) is not at home?  Do you feel happy or sad when ________ (caregiver''s name) is not at home?  Do you feel happy or sad when ________ (babysitter''s name) comes to stay with you? How come?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ7','Who takes care of you if ____________ ( caregiver''s name) is not at home?  What is it like when this person stays with you? Do you like it? What kinds of things do you do with this person?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ8','Who takes care of you when ____________ (caregiver''s name) is not at home?  How do you feel about staying with this person?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ9','Who provides supervision for you  when ____________(caregiver''s name) is not at home?  How do you feel about staying with this person?  Do you know how to reach _____________(caregiver''s name) when they are away from home?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ10','Do you go to school? Who takes you to school?  Who picks you up from school?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ11','How do you get to and from school?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ12','How do you get to and from school and/or work?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ13','Do any grown ups watch you when you play outside?  Who?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ14','Do any grown ups watch you when you play outside?  ',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ15','Do any adult''s provide supervision for you when you play outdoors?  Does ______________(caregiver''s name) know where you are when you are away from home and not at school?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ16','Does ______________ (caregiver''s name) know where you are when you are away from home and not at school or work?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ17','Do you know what to do if a stranger talks to you and ____________ (caregiver''s name) is not there?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ18','Do you know what to do if a stranger talks to you on the street or asks you to go somewhere with him or her?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ19','Do you know the name of the street that _________ (caregiver''s name)''s house is on?  Do you know the address for _________ (caregiver''s name)''s house?  Do you know telephone number at _________ (caregiver''s name)''s house?  Can you tell me what it is?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ20','Do you know the address and telephone number at _________''s (caregiver''s name) house?  What is it?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ21','Do you know what to do in case of an emergency, like a fire?  Can you tell me what you would do?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ22','Are you able to call _________ (caregiver''s name) when they are not at home?  How do you do this?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ23','Do you know how to reach _____________ (caregiver''s name) when they are away from home?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ24','Do you know where the first aid kit is kept?  Do you know how to use the different items in it?',null, SYSDATE,  'CH', 'SAF');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('SCCQ25','Do you feel safe living with __________ (caregiver''s name)? What are some things that make you feel safe? Are there situations were you feel not safe living with ___________ (caregiver''s name)? What are some of those situations?',null, SYSDATE,  'CH', 'SAF');






INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ1','What is it like for you to care for this youth?  What has been the effect on your family of having this youth placed here?  What did you expect it to be like?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ2','Describe who this child is. What about the child is easiest and most pleasurable?  What is the most difficult aspect of this child for you to deal with?  What are the things about this child that will help him/her in the future?  What will be harder for him/her?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ3','Describe who this young person is.  What about the youth is easiest and most pleasurable? What is the most difficult aspect of caring for this young person?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ4','How has this child/youth changed since coming here?  What do you think about that?  How has the youth/child adjusted to this placement?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ5','What are the goals for this child and his/her family and what do you think/feel about that?  What makes that okay; not okay?  What do you think of the family visits with the child?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ6','What are the goals for this youth and his/her family and what do you think/feel about that?  What makes that okay; not okay?  What do you think of the family visits with the youth? Does this youth maintain contact with his/her siblings?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ7','Is this child is receiving any educational, medical and/or psychological services?  Which ones? How often? Do you think that these services are meeting this child''s needs?  Are there any other services that you think that this child needs?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ8','What are the services this youth is receiving?  What do you think/feel about those?  What do you think that this youth needs?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ9','What things does this child like to do?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ10','To whom do you go if things aren''t going too well?  ',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ11','What are the things you need to support you in the continued care of this child?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ12','Does this child show warmth and affection across a range of interactions and with different people?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ13','Who does this child seek comfort from when s/he is hurt, frightened, or ill?', null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ14','Is this child able to seek you out and accept your help when needed?', null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ15','How does this child comply with your requests and demands?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ16','How is this child''s sleeping pattern? How is this child''s feeding pattern?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ17','How is this child''s sleeping pattern? How are this child''s eating habits?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ18','Have you seen any weight changes since this child has been with you?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ19','Does this child show preference for a particular adult?',null, SYSDATE,  'CG', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCRQ20','How easy is it to soothe this child when s/he is upset?',null, SYSDATE,  'CG', 'WBP');






INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ1','Do you like living at _____________''s (caregiver''s name) house?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ2','How is it for you living at _____________''s house?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ3','What is it like living with them?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ4','Who else lives here with you?  What do you think about these other people who live here?  Do you like living with them? How come?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ5','Do you share a bed with anyone else? If yes ask, who?  Do you like sharing a bed with _______?  How come?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ6','Where do you sleep?  Do you share a room with anyone?  Who? If so, ask: Do you like sharing a room with this person?  How come?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ7','Are there things that you can and can''t do at ____________''s house?  What are some of these things?  What happens if you do something that you are not supposed to do?  Does this happen a little or a lot?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ8','Are there things that you can and can''t do at ____________''s house?  What are some of these rules?  What happens if you break a rule?  How often does this happen?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ9','Are there things that you can and can''t do at ____________''s house?  What are some of these rules?  What happens if you break a rule?  How often does this happen?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ10','Do you know how come you are living here with _____________ (caregiver''s name)?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ11','Do you like _____________ (caregiver''s name)?  How come?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ12','Do you think that _______likes you? How come?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ13','How do you feel about _____________ (caregiver''s name)? How do you think that they feel about you?','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ14','How are your living arrangements','LA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ15','Do you wake up by yourself in the morning or does someone else wake you up?  If it''s someone else, ask: Who?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ16','How do you wake up in the morning?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ17','What do you do in the morning to get ready for school?  Does anybody help you?  If so, what do they do?  What do you do by yourself to get ready in the morning?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ18','What do you do in the morning to get ready for school?  Does anybody help you?  If so, what do they do?  ','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ19','Does anyone make breakfast for you?  Who?  What are some things that you eat for breakfast?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ20','(If child goes to school): Do you bring your lunch with you to school or do you get lunch at school?  What are some things that you eat for lunch?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ21','(If child goes to school): Where do you go after school?  How do you get there?  What do you do after school?  Do you like what you do after school?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ22','Who makes you dinner?  What are some things that you eat for dinner','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ23','What do you do after dinner?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ24','What time do you go to bed?  Does anyone help you to get ready for bed?  If so, what do they do to help you?  ','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ25','What time do you go to bed?  Does anyone help you to get ready for bed?  If so, what do they do? What is bedtime like for you?  ','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ26','What time do you go to bed?  ','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ27','What do you do on Saturday and Sunday?  Who do you do this with?  What do the other people in ________''s house do on Saturdays and Sundays?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ28','(If applicable) Is this the same as what you used to do on weekends when you lived with _______ (previous guardian) or is it different?  What is different about it?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ29','Where do you sleep? Do you share a room with anyone? Who? What is it like for you?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ30','Do you share a bed with anyone else? If so who?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ31','Are there things that you can and can''t do at ____________''s house?  What are some of these rules?  What happens if you break a rule?  How often does this happen?','DR',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ32','Do you play with toys?  What toys do you like playing with? Does anyone else play with toys with you?  Do you have a favorite toy?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ33','Do you like to have stories/books read to you?  Who reads stories/books to you?  Can you tell me the name of a book that you really like?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ34','Do you like to make pictures?  ','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ35','What kinds of things do you like to do for fun (sports, music, art, video games, etc.)?  Do you do these things while you are living with ___________?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ36','What do you do on the weekends?  Who do you do this with?  What do the other people in ________''s house do? If applicable: Is this different from what you used to do on weekends? If so, how is it different?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ37','How do you like to spend your free time? What do you like to do? Who do you do this with?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ38','What are your hobbies?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ39','What sports do you like to play?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ40','Do you like to read? What are your favorite books, magazines?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ41','Are you involved in any cultural group or activity? What could we do to help you be more involved in this?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ42','Are you involved in any after-school or social group? (sports, scouting, hobbies, arts, etc.) What could we do to help you be more involved?','SI',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ43','If you are sad, mad or scared about something that happens at __________''s house, do you tell anyone?  Who?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ44','If you are sad, mad or scared about something that happens at __________''s house, who can you go to?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ45','If you are upset or angry about something that happens at __________''s house, is there anyone that you can go to?  Who?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ46','Do you ever get scared at night?  If so, ask: What do you do when you feel scared at night?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ47','Do you ever get scared at night?  If so, ask: What do you do when this happens? Do you ever go into __________''s room when it happens? If so, ask: What do they do?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ48','Does __________ (caregiver''s name) ever get mad at you?  What happens if __________ gets mad at you?  If ______gets mad, do you feel sad, mad or scared?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ49','Does __________ (caregiver''s name) ever get mad at you?  What happens if __________ gets mad at you?  Does this happen a lot of the time or a little of the time?  What do you feel like when ______gets mad?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ50','What happens when __________ (caregiver''s names) get angry at you, each other, or someone else who lives in your house?  How often do they get angry?  What does it feel like for you when they are angry?  What are some of the things that they get angry about?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ51','Does __________ (caregiver''s name) ever get mad at anyone else who lives with you?  ','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ52','Does __________ ( caregiver''s name) ever get mad at someone else who lives in the house with you?  Does this happen a lot of the time or a little of the time?  What do you feel like when ______gets mad at these other people? What are some of the things that s/he gets angry at other people about?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ53','Is there anyone at __________''s house who makes you feel scared?  ','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ54','Is there anyone at __________''s house or anywhere else who makes you feel scared?  Are there any grown ups or kids who do things that make you feel sad, mad, or scared?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ55','Is there anyone at __________''s house or anywhere else who makes you feel scared?  Are there any grown ups or kids who do things that make you feel sad, mad, scared or confused?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ56','Is there anyone at __________ school who makes you feel scared?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ57','Do you ever get scared when you are playing outside?  If yes, ask: How come?  Do you tell anyone when you feel scared?  Who?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ58','Do you ever get scared when you are playing outside or walking around by _______''s house?  If yes, what are the things that make you scared?  Cay you talk to someone about this?  If so, who?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ59','Do you ever get scared playing in your neighborhood?  If so, what are the things that make you scared?  Is there anyone who you are able to talk to about this?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ60','Do you ever get scared hanging out in your neighborhood?  If so, what are the things that make you scared?  Is there anyone who you are able to talk to about this?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ61','Are there any grown ups or kids who do things that make you feel happy?  ','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ62','Are there any grown ups or kids who do things that make you feel sad?  ','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ63','Are there any grown ups or kids who do things that make you feel mad?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ64','Do you ever wake up in the middle of the night?  If so, ask:  What do you do when this happens?  ','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ65','Do you ever wake up in the middle of the night?  If so, What happens?  ','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ66','If something is really worrying or bothering you, who can you talk to?  If you want to talk to me, do you know how you can do that?  ','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ67','If something is really worrying you, who can you talk to?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ68','If you need to get in touch with me, do you know how to do that?  How?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ69','Are you involved in any religious, spiritual or cultural activities?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ70','Are you involved in a religion? Are you able to participate in services or events connected to your religion?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ71','Are you involved in any cultural group or activity? What could we do to help you be more involved in this?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ72','Are you involved in any after-school or social group? (sports, scouting, hobbies, arts, etc.) What could we do to help you be more involved?','SE',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ73','(If child goes to school or is some form of child care): Do you go to school/day care?  If so, ask: Do you like it? How come?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ74','What do you like to do at school/day care?  Is there anything that you don''t like about school/day care?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ75','Do you go to school?  If so, do you like it? How come? (If child goes to school)','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ76','(If child goes to school): What do you do at school?  Who do you do this with?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ77','What are some of the things that you like the most about school?  What are some of the things that you don''t like so much about school?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ78','How is school?  What grade are you in?  What are some of the things that you like best about school?  What are some of the things that you like the least about school?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ79','Are there any subjects at school, like math or reading that are hard for you?  If so, do you get any kind of special help with these subjects?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ80','Where do you go after school?  How do you get there?  What do you do after school?  Do you like doing this?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ81','What do you like most about school?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ82','What are your favorite subjects? What subjects are difficult for you?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ83','Are you receiving help with these subjects?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ84','Have you thought about what you would like to do after high school?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ85','What types of careers are you interested in?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ86','What are your educational plans after high school?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ87','What types of careers are you interested in?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ88','Have you contacted colleges or vocational schools?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ89','Have you explored your states ETV program as well as other financial aid programs?','ED',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ90','Who do you play with?  What do you do when you play with other kids?  ','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ91','Do you get to see your mommy and/or daddy?  Do you like seeing them? What kinds of things do you do with them?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ92','Do you see your brothers and/or sisters?  Do you like seeing them? What kinds of things do you do with them?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ93','Do you get to see your family?  How is this for you?  Do you see your brothers and/or sisters?  What kinds of things do you do together?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ94','Who are some of your friends?  What do you do with them?  Where do you see them?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ95','Is there anyone you want to see or talk to?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ96','How are visits with your family?  What kinds of things do you with your family on visits? How often do you see them? Do you speak with them on the telephone in between visits?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ97','Do you see your brothers and/or sisters?  How is to see them? Do you see other members of your family e.g., grandparents, aunts, uncles?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ98','Who are your friends?  What do you like to do with them?  Where do you see them?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ99','Is there anyone you want to see or talk to that you do not see now?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ100','Who do you call family?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ101','What are the visits with your family like?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ102','Do you maintain regular contact with your siblings?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ103','How are those contacts going?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ104','How is your family helping you prepare for your future?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ105','Do you have a group of friends you feel close to?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ106','If not, how could we help you develop relationships?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ107','Are you involved with someone special?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ108','Do you have someone in your life that you consider your mentor? What are the qualities that person possesses?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ109','Is there someone who you would like to visit with and cannot?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ110','Do you have a support network to help you when you leave foster care?','FF',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ111','Have you been to see a doctor since you''ve been living with _________?  If so, ask: how come? Can ask: were you sick or did you need to get a shot?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ112','Have you been to see a dentist (a special doctor who looks at your teeth) since you''ve been living with_________?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ113','Have you been to see a doctor since you''ve been living with _________?  What did you see this doctor for? Have you been to any other doctors?  If so, how come?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ114','Have you seen a dentist since you''ve been living with _________?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ115','Have you been to see a doctor since you''ve been living with _________?  What did you see this doctor for? Have you been to any other doctors?  If so, why?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ116','Have you seen a dentist since you''ve been living with _________?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ117','Do you go to see a counselor or therapist?  What is this like for you? Do you know why you are seeing them?  ','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ118','How have you been feeling physically?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ119','Have you seen a doctor or dentist recently?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ120','If you are on medication; do you take it regularly and who administers it?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ121','Have you had any physical reactions?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ122','Do you do any physical exercise?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ123','Are you comfortable with you personal appearance?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ124','Do you have a copy of your medical history?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ125','Do you have a plan for attending to your medical needs after you leave care?','HT',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ126','Do you feel involved in the development of your service plan?','GS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ127','Do you feel listened to by the adults in your life about your future plans?','GS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ128','Have you been given the opportunity to participate in youth leadership activities?','GS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ129','Have you been involved in planning for your discharge from foster care?','GS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ130','Do you feel listened to by the adults in your life?','GS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ131','Has the agency made life skills groups and instruction available to you?','GS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ132','Have you ever worked? What types of jobs have you held?','EM',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ133','What types of jobs have you like best?','EM',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ134','What part of the job did you enjoy most?','EM',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ135','Do you have a resume?','EM',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ136','Do you have forms of identification? social security card, birth certificate?','EM',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ137','Do you participate in any cultural activities?','CA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ138','Have there been opportunities for you to participate in activities specific to your cultural heritage? What types of activities?','CA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ139','What are some things you do that nurture your spirit?  e.g., art, martial arts, meditation, religious classes, going to church, prayer groups, etc.','CA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ140','Are you involved in a religion? Are you able to participate in services or events connected to your religion?','CA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ141','Are you involved in any groups? (sports, scouting, hobbies, arts, etc.) What could we do to help you be more involved?','CA',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ142','What do you like most about yourself?','SS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ143','Are you comfortable: Meeting new people? Speaking up for yourself at home, school, work, or with friends?','SS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ144','Everyone gets angry from time to time. What kinds of things make you angry? What do you do when you get angry? Do you feel that you have a good handle on controlling your anger?','SS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ145','Has the agency made life skills groups and instruction available to you?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ146','Do you feel you are able to manage your money?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ147','Do you have a savings account?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ148','Do you do your own laundry?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ149','Do you cook? What do you like to cook?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ150','Are you able to get around your city or town?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ151','Are you thinking about taking driver''s education and obtaining your driver''s license?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ152','Have you developed a budget for managing your living experiences after you leave care?','LS',SYSDATE,  'CH', 'WBP');
INSERT INTO CAPS.SPWB_CHCK_LIST_LOOKUP (CD_CHCK_LIST, TXT_CHCK_LIST, CD_SUB_CATEGORY, DT_LAST_UPDATE,  CD_AUDIENCE, CD_MAIN_CATEGORY) VALUES ('WPCQ153','Do you need any help in developing household management skills?','LS',SYSDATE,  'CH', 'WBP');


DELETE FROM CAPS.SPWB_AGE_GROUP_LOOKUP;
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BSQ1','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BSQ2','0','18', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BSQ2','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BSQ3','0','18', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BSQ3','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BSQ4','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BSQ5','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'PFQ1','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'PFQ2','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'STQ1','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'STQ2','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'STQ3','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'STQ4','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'STQ5','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'STQ6','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'STQ7','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CSQ1','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CSQ2','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CSQ3','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CSQ4','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CSQ5','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CSQ6','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CSQ7','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BTQ1','0','18', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BTQ1','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BTQ2','0','18', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BTQ2','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BTQ3','0','18', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'BTQ3','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CCQ1','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CCQ2','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'CCQ3','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SAQ1','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SAQ2','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SAQ3','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ1','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ2','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ3','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ4','72','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ5','120','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ6','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ7','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ7','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ9','120','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ10','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ11','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ12','120','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ13','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ14','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ15','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ16','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ17','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ18','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCQ19','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ1','18','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ2','120','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ3','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ4','18','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ5','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ6','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ7','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ8','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ9','120','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ10','18','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ11','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ12','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ13','18','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ14','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ15','120','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ16','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ17','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ18','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SSCQ19','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SSCQ20','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SSCQ21','36','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ22','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ23','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ24','120','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'SCCQ25','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ1','0','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ2','0','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ3','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ4','0','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ5','0','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ6','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ7','0','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ8','84','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ9','0','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ10','0','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ11','0','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ12','0','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ13','0','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ14','18','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ15','18','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ16','0','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ17','36','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ18','0','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ19','0','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCRQ20','0','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ1','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ2','36','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ3','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ4','18','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ5','18','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ6','18','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ7','18','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ8','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ9','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ10','36','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ11','36','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ12','36','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ13','120','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ14','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ15','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ16','84','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ17','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ18','84','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ19','36','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ20','36','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ21','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ22','36','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ23','36','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ24','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ25','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ26','120','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ27','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ28','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ29','84','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ30','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ31','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ32','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ33','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ34','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ35','36','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ36','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ37','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ38','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ39','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ40','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ41','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ42','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ43','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ44','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ45','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ46','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ47','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ48','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ49','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ50','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ51','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ52','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ53','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ54','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ55','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ56','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ57','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ58','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ59','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ60','120','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ61','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ62','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ63','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ64','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ65','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ66','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ67','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ68','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ69','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ70','120','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ71','120','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ72','120','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ73','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ74','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ75','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ76','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ77','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ78','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ79','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ80','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ81','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ82','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ83','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ84','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ85','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ86','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ87','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ88','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ89','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ90','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ91','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ92','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ93','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ94','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ95','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ96','84','120', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ97','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ98','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ99','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ100','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ101','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ102','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ103','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ104','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ105','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ106','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ107','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ108','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ109','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ110','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ111','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ112','18','36', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ113','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ114','36','84', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ115','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ116','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ117','84','156', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ118','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ119','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ120','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ121','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ122','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ123','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ124','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ125','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ126','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ127','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ128','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ129','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ130','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ131','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ132','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ133','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ134','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ135','218','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ136','218','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ137','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ138','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ139','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ140','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ141','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ142','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ143','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ144','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ145','156','216', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ146','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ147','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ148','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ149','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ150','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ151','156','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ152','216','264', SYSDATE);
INSERT INTO CAPS.SPWB_AGE_GROUP_LOOKUP (ID_SPWB_AGE_GROUP, CD_CHCK_LIST, NBR_MONTH_MIN, NBR_MONTH_MAX, DT_LAST_UPDATE) VALUES (CAPS.SEQ_SPWB_AGE_GROUP_LOOKUP.NEXTVAL, 'WPCQ153','216','264', SYSDATE);



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (491, 'SacwisRev3', 'Release 3.2 - DBCR 14593');

commit;


