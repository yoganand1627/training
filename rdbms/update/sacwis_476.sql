--STGAP00014139 - MR-040 Updates to the questions

--Note:   no impact to ado model


--There are some updates to the survey questions questions on the case review page as per the comments from UAT testing team.


DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q09' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q09' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q10' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q11' AND CD_SURVEY_CODE = 'DIV';

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q13','1');

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q116' AND CD_SURVEY_CODE = 'FPR';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q117' AND CD_SURVEY_CODE = 'FPR';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'ONG-Fmily Plan Client Comments
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q140';

	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP,CD_VERSION) 
VALUES ('Q172',SYSDATE,
'Does documentation support that a thorough diligent search was completed for maternal and paternal family members?'
,172,'WLLIT2', 'D', 'N',
'YNA', 'Person Detail-diligent search
Log of Contacts-diligent search contact type
Contact Detail 
Contact Narrative
', '1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q172','1');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP,CD_VERSION) 
VALUES ('Q173',SYSDATE,
'Does documentation reflect case manager utilized information from the diligent search to develop support services for the child and family?'
,173,'WLLIT2', 'S', 'N',
'YNA', 'Family Plan
Contact Detail 
Contact Narrative
Person Detail-diligent search
', '1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q173','1');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP,CD_VERSION) 
VALUES ('Q174',SYSDATE,
'Does documentation reflect evaluations of extended family members or family members. decisions not to be evaluated for placement of the child?'
,174,'WLLIT2', 'S', 'N',
'YNA', 'Person Detail-diligent search Contact Detail 
Contact Narrative
gent search
', '1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q174','1');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP,CD_VERSION) 
VALUES ('Q175',SYSDATE,
'Does documentation support services being provided to relative placements and safety resources?'
,175,'WLLIT2', 'S', 'N',
'YNA', 'Services Authorizations
External Documentation
Contact Detail 
Contact Narrative
', '1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q175','1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q154','1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q156','1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q160','1');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q161','1');

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q162' AND CD_SURVEY_CODE = 'INV';

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION, CD_VERSION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q167','1');

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
' Foster Parent/Safety Resource
Contact Detail 
Contact Narrative
FCC-Child Plan
FCC-child plan-health status
'
WHERE CD_QUESTION  = 'Q169';





--STGAP00014156 - Script to Recalculate Open Slots

--Note:  no impact to ado model


-------------------------------------------------------------------------------
--  Filename:  Recalculate-Open-Slots.sql
--
--             The update query will recalculate the number of
--             Open Slots for each Resource in the CAPS_RESOURCE table. 
--             It will retrieve the total number of placements
--             for each Resource and subtract it from its Capacity
--             to calculate the number of Open Slots
--
--             Recalculate-Open-Slots
------------------------------------------------------------------------------

/
DECLARE

nbr_open_slots_var 	NUMBER(4);
nbr_active_placements	NUMBER(4);
CURSOR caps_resource_cur IS SELECT cr.NBR_RSRC_FACIL_CAPACITY, cr.ID_RESOURCE 
FROM CAPS.CAPS_RESOURCE cr WHERE cr.CD_RSRC_FACIL_TYPE IN ('70', '71') ORDER BY cr.ID_RESOURCE;
caps_resource_cur_rec caps_resource_cur%rowtype;

BEGIN
-- loop thru all of the Resources in the table.
FOR caps_resource_cur_rec IN caps_resource_cur LOOP

SELECT COUNT(1) INTO nbr_active_placements FROM CAPS.PLACEMENT p 
WHERE p.DT_PLCMT_START <= SYSDATE 
AND p.ID_RSRC_FACIL = caps_resource_cur_rec.ID_RESOURCE
AND p.CD_PLCMT_ACT_PLANNED = 'A' 
AND p.DT_PLCMT_END > SYSDATE 
AND p.ID_PLCMT_EVENT in (SELECT e.ID_EVENT FROM CAPS.EVENT e WHERE e.CD_EVENT_TYPE = 'PLA');

UPDATE CAPS.CAPS_RESOURCE r SET r.NBR_RSRC_OPEN_SLOTS = greatest(caps_resource_cur_rec.NBR_RSRC_FACIL_CAPACITY - nbr_active_placements,0)
WHERE r.ID_RESOURCE = caps_resource_cur_rec.ID_RESOURCE;

end loop;


end;

/
     

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (477, 'SacwisRev3', 'Release 3.1 - DBCRs 14139,14156');

commit;


