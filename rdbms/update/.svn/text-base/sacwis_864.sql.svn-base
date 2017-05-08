--STGAP00015959 - Release(4.0) MR-067 DBCR New codes, messages, and metaphor

insert into caps.codes_tables (code_type, code, decode) values ('COUTSTAT', 'NS', 'Not in sample');
insert into caps.codes_tables (code_type, code, decode) values ('CINVACAN', 'D', 'Declined');
insert into caps.codes_tables (code_type, code, decode) values ('CINVACAN', 'K', 'Don''t know');

insert into caps.codes_tables (code_type, code, decode) values ('CCNTPURP', 'NYP', 'NYTD Preparation');
insert into caps.codes_tables (code_type, code, decode) values ('CUSRTYP', 'NYU', 'NYTD User');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60755,'MSG_CMN_YDP_DEATH','Outcome status of ''Death'' has been selected, but a date of death has not been recorded.',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60756,'MSG_CMN_YDP_RUNAWAY','Outcome status of ''Runaway'' has been selected, but current placement is not a ''Runaway'' placement type.',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60757,'MSG_CMN_YDP_OUTCOME_DT_INVALID','Outcome Date should be within 45 days of youth''s birthday.',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60758,'MSG_SURVEY_NOT_COMP_SAVED','Your NYTD survey has been saved, but there are still unanswered question(s).',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60759,'MSG_SURVEY_EST_CLOSE ','Your survey will close within XX days. Please complete before MM/DD/YYYY.',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60760,'MSG_SURVEY_EST_TIME','The survey will take approximately 10 to 20 minutes to complete. Please remember to save your survey responses before logging out.',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60761,'MSG_SURVEY_COMP_SAVED','Your NYTD survey has been saved and is complete. Thank you for your participation.',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60762,'MSG_SURVEY_UNAVAILABLE','DFCS is not currently collecting a NYTD Survey Response.  Please contact your county Independent Living Coordinator if you have questions about NYTD.',700,500,'N');
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60763,'MSG_SURVEY_COMP_EST_CLOSE','Your survey will close within XX days on MM/DD/YYYY.',700,500,'N');

INSERT INTO caps.PORTAL_METAPHOR
(id_tab,
txt_tab_url,
txt_tab_constant,
txt_tab,
dt_last_update)
VALUES
(190,
'/person/PortalSurveyDetail/displayPortalSurveyDetail',
'PORTAL_SURVEY_DETAIL',
'Survey Detail',
SYSDATE);

--Insert into caps.PORTAL_SECURITY_CLASS (CD_SECURITY_CLASS_NAME,TXT_SECURITY_CLASS_PROFIL,IND_RESTRICT,ID_PERSON_MODIFIED_BY) values ('NYTD_USER','001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000','N',5607560);

Insert into caps.PORTAL_SECURITY_CLASS 
(CD_SECURITY_CLASS_NAME,
TXT_SECURITY_CLASS_PROFIL,
IND_RESTRICT,
ID_PERSON_MODIFIED_BY) 
values 
('NYTD_USER',
'001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000',
'N',
NVL((SELECT id_person FROM caps.employee where id_person = 5607560), 2071));


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (865, 'SacwisRev4', 'Release 4.0 - DBCR 15959');

commit;




