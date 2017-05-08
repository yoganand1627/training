--STGAP00015897 - Release(3.6) MR-66: Messages, codestables and columns changes

ALTER TABLE CAPS.INCOMING_DETAIL ADD (IND_INCMG_MALTREAT_IN_CARE Varchar2(1));
comment on column CAPS.INCOMING_DETAIL.IND_INCMG_MALTREAT_IN_CARE is 'Indicates if Maltreatment took place while child(ren) in care';

ALTER TABLE CAPS.CPS_INVST_DETAIL ADD (IND_INV_MALTREAT_IN_CARE Varchar2(1));
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD (ID_RESOURCE Number(16,0) );
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD  CONSTRAINT FK_CPS_INVST_CAPS_RESOURCE FOREIGN KEY (ID_RESOURCE) REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE);
comment on column CAPS.CPS_INVST_DETAIL.ID_RESOURCE is 'Foreign Key to CAPS.CAPS_RESOURCE.ID_RESOURCE' ;
comment on column CAPS.CPS_INVST_DETAIL.IND_INV_MALTREAT_IN_CARE is 'Indicates if Maltreatment took place while child(ren) in care';

-- Backout DDL Changes
--alter table caps.INCOMING_DETAIL drop column IND_INCMG_MALTREAT_IN_CARE;
--alter table caps.CPS_INVST_DETAIL drop column IND_INV_MALTREAT_IN_CARE;
--alter table caps.CPS_INVST_DETAIL drop constraint FK_CPS_INVST_CAPS_RESOURCE;
--alter table caps.CPS_INVST_DETAIL drop column ID_RESOURCE;



-- Allegation Detail(Intake), Allegation Detail(Inv)
-----------------------------------------------------
INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60740,'MSG_ALLEG_DT_MALTREAT_IN_CARE', 'The Date of Alleged Incident provided indicates a Maltreatment in Care situation according to the Legal Status of the child. Please verify the allegation occurred while the child was in care.', 700, 500,'N');

update caps.codes_tables set decode = 'Victim''s Home (Non-Foster Home)' Where code_type = 'CLOCMAL' and code = '001';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMAL' and code = '003';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMAL' and code = '004';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMAL' and code = '005';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMAL' and code = '006';
update caps.codes_tables set decode = 'F/A Home-DFCS' Where code_type = 'CLOCMAL' and code = '007';
update caps.codes_tables set decode = 'F/A Home-Non DFCS (CPA)' Where code_type = 'CLOCMAL' and code = '008';
update caps.codes_tables set decode = 'Residential Facility (CCI)' Where code_type = 'CLOCMAL' and code = '011';
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMAL', '012', 'Relative Placement Home (Not Relative F/A Home DFCS)');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMAL', '013', 'Non-Residential Facility (Includes Daycare)');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMAL', '014', 'Granny House');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMAL', '015', 'Military Base');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMAL', '016', 'Non-Relative Placement Home (Not F/A Home)');


-- Intake Information
---------------------------
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'AH';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'FAH';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'FAHP';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'FH';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'FHP';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'GH';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'ICPC';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'MN';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'MR';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'OT';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'RFAH';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'RH';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'RHE';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'RHP';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'RI';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'RP';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'RPY';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CSPECREQ' and code = 'School Personnel';
update caps.codes_tables set decode = 'Child Death-Not in Care' Where code_type = 'CSPECREQ' and code = 'CD';
update caps.codes_tables set decode = 'Serious Injury-Not in Care' Where code_type = 'CSPECREQ' and code = 'SI';
update caps.codes_tables set decode = 'Near Fatality-Not in Care' Where code_type = 'CSPECREQ' and code = 'NF';
INSERT INTO caps.codes_tables(code_type, code, decode) values('CSPECREQ', 'CDIC', 'Child Death-In Care');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CSPECREQ', 'SIIC', 'Serious Injury-In Care');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CSPECREQ', 'NFIC', 'Near Fatality-In Care');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CSPECREQ', 'MIC', 'Maltreatment in Care (Not CD/NF/SI)');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CSPECREQ', 'MNIC', 'Maltreatment-Not in Care (Facility/Granny House/ Military Base/School-Not CD/NF/SI)');
update caps.codes_tables set decode = 'Specialty Hospital' Where code_type = 'CFACTYP4' and code = 'SH';



-- Intke Actions
---------------------
INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60741,'MSG_INT_SPCL_INV_PLACEMENT_REQ', 'The system has determined a Maltreatment in care situation based on an Allegation''s  Alledged Incident Date and a child''s ''In Custody'' Legal Status. Selection for the Special Investigation Call Type and Placement/Non-Placement Provider Information sections are required.', 700, 500,'N');

INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60748,'MSG_INT_SPCL_INV_REQ', 'The system has determined a Maltreatment in care situation based on an Allegation''s  Alledged Incident Date and a child''s ''In Custody'' Legal Status. Selection for the Special Investigation Call Type is required.', 700, 500,'N');

INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60742,'MSG_INT_ALLEG_LOC_MAL_SPCL_INV', '''Where did the Maltreatment occur?'' selection indicates a candidate for a Special Investigation Call Type that may require a Placement/Non-Placement Provier. Click ''Cancel'' to go back and complete the Special Investigation and the Placement/Non-Placement Provider sections. Click ''Ok'' to Save and Submit', 700, 500,'N');


-- CPS Investigation Conclusion
--------------------------------
update caps.message set txt_message = 'Foster parent notification regarding an advocate is required for Maltreatment in Care.' where txt_message_name = 'MSG_INV_SPCL_NOTIFICATION';

INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60743,'MSG_INV_PLACEMENT_REQ', 'It is indicated that this is a special investigation on a Placement/Non-Placement provider. A selection for Placement/Non-Placement Provider information section is required.', 700, 500,'N');


-- Custody
------------
INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60744,'MSG_SUB_REM_DATE_WARN', 'The Removal Date is earlier than the Alleged Incident Date. This indicates a Maltreatment in Care situation. Please verify this is correct.', 700, 500,'N');


-- Add Home
----------------
INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60745,'MSG_FAD_DUPLICATE_NOT_ALLOWED', 'There may be possible duplicates of the home you are trying to add. Please click Cancel and do a F/A Home search by partial Home Name and narrow the search by including Region or City or Category or Region and County.', 700, 500,'N');


-- Intake Person Detail, Person Detail
--------------------------------------
INSERT INTO caps.codes_tables(code_type, code, decode) values('CRELVICT', 'FD', 'Foster Child');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CSRCRPTR', 'FD', 'Foster Child');

INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60746,'MSG_DUPLICATE_NOT_ALLOWED', 'There may be possible duplicates of the person you are trying to add. Please click Cancel and do a Phonetic Person search by Last name and narrow the search by including First Name or Date of Birth or SSN or combination of all.', 700, 500,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (821, 'SacwisRev3', 'Release 3.6 - DBCR 15897');

commit;


