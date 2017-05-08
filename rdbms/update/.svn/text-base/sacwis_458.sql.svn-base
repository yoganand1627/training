--STGAP00013417 DBCR Add Messages for STGAP00012588

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60525,'MSG_INT_REASON_DOD_REQ','The DOD and Reason for Death are required on Person Detail Page when Child Death is selected on Intake Information.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60526,'MSG_INT_TYPE_REQ','The Child Death needs to be selected on Intake Information when the DOD and Reason for Death are entered on Person Detail Page.', 
700,500,'N');


--STGAP00013422 DBCR Case Review Update Questions, Items, Sec Attr

DELETE FROM CAPS.CASE_REVIEW_QUES_LOOKUP;


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q01',SYSDATE,
'Of all of the investigations received on this case during the period of review, was a face to face contact made with the child(ren) (who is/are the subject of the alleged maltreatment) within the assigned time frame or was there documentation that concerted diligent efforts were made to locate the child(ren) within the assigned response time frame?  (Timeliness of initiating reports of child maltreatment).'
,01,'SFTIT1', 'M', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q02',SYSDATE,
'Does the intake clearly identify child victim, caretakers and allegations?'
,02,'SFTIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q03',SYSDATE,
'Were the following screens checked, reviewed and results documented?'
,03,'SFTIT1', 'S', 'Y',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q04',SYSDATE,
'Based on information available, was the appropriate case disposition and time frame assigned?'
,04,'SFTIT1', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q05',SYSDATE,
'Did the supervisor approve the intake and assign it to the investigator timely?'
,05,'SFTIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q06',SYSDATE,
'Were all the screenings and prior history reviewed and significant findings documented?'
,06,'SFTIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q07',SYSDATE,
'Was the assigned response time met for each identified child victim?'
,07,'SFTIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q08',SYSDATE,
'If response time frame was not met, were there timely and concerted diligent efforts made and documented(concerted diligent efforts refer to going to extreme measures to locate the child victims)?'
,08,'SFTIT1', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q09',SYSDATE,
'Within the previous 6 months, has this case been without a substantiation of maltreatment?    (Absence of recurrence of maltreatment)'
,09,'SFTIT2', 'M', 'N',
'YNA', 'Question Help');
															 
INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q10',SYSDATE,
'If the current investigation is substantiated, did any of the prior substantiation investigations within the last 6 months involve a different perpetrator?'
,10,'SFTIT2', 'S', 'N',
'YNA', 'Question Help');

															 
INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q11',SYSDATE,
'If the current investigation is substantiated, did any of the prior substantiation investigations within the last 6 months involve a different allegation?'
,11,'SFTIT2', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q12',SYSDATE,
'If the family had a prior family preservation case, does documentation support that adequate services were provided to resolve risk to the family prior to case closure?'
,12,'SFTIT2', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q13',SYSDATE,
'Does documentation indicate that a FTM was held prior to case closure in Family Preservation cases to develop a discharge plan for the family?'
,13,'SFTIT2', 'S', 'N',
'YNA', 'Question Help');

															 
															 
INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q14',SYSDATE,
'During the period under review, did the agency make concerted efforts to provide services to the family to prevent child(ren)''s entry into foster care or their re-entry after a reunification? 
<br>For example: 
<br>Were services appropriate? 
<br>Safety assessed and addressed on an ongoing basis? 
<br>Services provided to non-custodial parents? 
<br>Risk factors such as domestic violence addressed? 
<br>Or was the risk so great that an emergency removal was warranted? 
<br>(Services to family to protect child(ren) in home and prevent removal or re-entry into foster care).'
,14,'SFTIT3', 'M', 'N',
'YNA', 'Question Help');

															 
INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q15',SYSDATE,
'Were needed and available services provided at a frequency and quality necessary to support the child in their own home, safety resource or foster home?'
,15,'SFTIT3', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q16',SYSDATE,
'Does documentation support that reasonable efforts were provided to prevent the child from being removed form their birth home, relative home or foster home?'
,16,'SFTIT3', 'D', 'N',
'YNA', 'Question Help');
														 
															 
INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q17',SYSDATE,
'Is there documentation that cases were staffed and services initiated timely when cases were transferred between programs/counties?'
,17,'SFTIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q18',SYSDATE,
'If the case was closed, was the family provided with linkages to appropriate resources to address any identified needs?'
,18,'SFTIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q19',SYSDATE,
'Does the case record contain a current valid court order/authority for placement?'
,19,'SFTIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q20',SYSDATE,
'During the period under review, was there a concerted effort to assess and address risk and safety concerns to the child in their own home or in the home of a safety resource or foster home?
<br>For example:
<br>o initial assessment
<br>o all safety plans identify risk and appropriate services to address risk
<br>o allegations should have been substantiated based on the evidence in the file
<br>o all adult household members(age 16 and older) assessed (including all intake screening on newly identified household members)
<br>o ongoing assessment for safety including family engagement in services to address  identified concerns
<br>o case closed appropriately                                 
<br>o Foster Home Policy Infraction concerns
<br>(Risk assessment and safety management)'
,20,'SFTIT4', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q21',SYSDATE,
'Is there clear documentation that a separate face to face interview was conducted with each parent/and or caregiver as well any other adult household member, including a discussion of all allegations?'
,21,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q22',SYSDATE,
'Is there clear documentation that a separate face to face interview was conducted with the alleged perpetrator, including a discussion of all allegations?'
,22,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q23',SYSDATE,
'Is there clear documentation that each child subject to the report or foster child was observed and interviewed privately?'
,23,'SFTIT4', 'D', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q24',SYSDATE,
'If there were allegations of physical abuse on a child under the age of four, was the child examined for injuries per policy?'
,24,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q25',SYSDATE,
'If the child is under age one, regardless of allegations, is there documentation to support the child was undressed and observed for injuries?'
,25,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q26',SYSDATE,
'Were all other children subject to the care of the alleged perpetrator observed and interviewed during the course of the investigation/assessment?'
,26,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q27',SYSDATE,
'In diversion cases, was the parent/caregiver contacted and provided with an explanation of concerns?'
,27,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q28',SYSDATE,
'Does documentation support that the frequency and quality of contacts with knowledgeable and credible collaterals were sufficient to assess safety and risk (regardless of placement; birth home, relative, foster home, institution, etc.)?'
,28,'SFTIT4', 'D', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q29',SYSDATE,
'Does documentation support that professional providers of services who may be knowledgeable about the alleged maltreatment of the child or needs of the family preservation plan were interviewed?'
,29,'SFTIT4', 'D', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q30',SYSDATE,
'Was the original safety assessment appropriate?'
,30,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');		
														 
															 
INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q31',SYSDATE,
'Does the documentation support that the ongoing assessment of safety is accurate (regardless of placement type)?'
,31,'SFTIT4', 'D', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q32',SYSDATE,
'Is the safety plan adequate to address identified safety issues?'
,32,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q33',SYSDATE,
'If overnight unsupervised visitation is occurring between the child and parent, did the Court approve the visitation?'
,33,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q34',SYSDATE,
'If a safety resource was utilized, was the appropriate resource assessment completed within 72 hours and located in the record?'
,34,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q35',SYSDATE,
'Do the risk assessment or re-assessment and documentation support the assigned level of intervention/support?'
,35,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q36',SYSDATE,
'Was there evidence of supervisory input including case staffing documentation, supervisory approvals required by policy, approval of case closures?'
,36,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q37',SYSDATE,
'For open diversion cases, foster care cases and family preservation cases, when new significant safety concerns were identified was a timely CPS referral made?'
,37,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q38',SYSDATE,
'Was a CPS alert issued timely and located in the case file when a family could not be located or moved during the course of an open case?'
,38,'SFTIT4', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q39',SYSDATE,
'Does the risk assessment indicators show that risk of further maltreatment is sufficiently reduced and there is no evidence that the child is unsafe or unprotected prior to case closure?'
,39,'SFTIT4', 'D', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q40',SYSDATE,
'If parents are non-compliant with their case plans, has the agency sought legal interventions with the court to gain compliance?'
,40,'SFTIT4', 'D', 'N',
'YNA', 'Question Help');






INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q41',SYSDATE,
'Within the past 12 months of current removal date, has this been the only episode of foster care for this child? (Foster care re-entries)'
,41,'PERIT1', 'M', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q42',SYSDATE,
'If the child had a prior episode of foster care, was there evidence of after care services being provided or a discharge plan discussed with the parents?'
,42,'PERIT1', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q43',SYSDATE,
'Does documentation reflect the agency made concerted and reasonable efforts to prevent the subsequent removal?'
,43,'PERIT1', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q44',SYSDATE,
'If the family had a prior foster care case, does documentation support that adequate services were provided to resolve risk to the family prior to reunification and case closure?'
,44,'PERIT1', 'S', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q45',SYSDATE,
'Does the child have a stable placement (not more than 1 placement)  or if there are subsequent moves does documentation support each move to be in the best interest (planned, purposeful moves related to achieving the child''s goal, death of foster parent, foster parents move to another state) of the child and consistent with achieving the child''s permanency goal? (Does not include trial home visits, runaway, visitations, pre-placements, hospitalizations, respite care or camps). (Even if the child has a single placement, if the placement does not meet the child''s needs or is not considered stable this item is not a strength and should be marked no). (Stability of foster care placement)'
,45,'PERIT2', 'M', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q46',SYSDATE,
'If the child has had a foster home disruption, is there evidence the case manager provided resources to the caregiver to prevent the disruption?'
,46,'PERIT2', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q47',SYSDATE,
'If the child has had multiple placements moves, are the moves in the child''s best interest and/or achievement of their permanency?'
,47,'PERIT2', 'D', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q48',SYSDATE,
'Is there evidence of planning and pre-placement visits prior to the child''s move to a new placement?'
,48,'PERIT2', 'S', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q49',SYSDATE,
'Did the agency select an appropriate permanency goal for the child in a timely manner (including the designation of a concurrent plan)?  Things to consider are as follows:
 <br>o permanency goal identified in the case file, case plan and court order 
 <br>o was the goal established timely (within 60 days of initially coming into care, and 
 <br>o subsequent determinations based on ASFA,
 <br>o is the goal appropriate to meet the needs of the child and the circumstances of the case)?  
 <br>(Permanency goal for child)'
,49,'PERIT3', 'M', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q50',SYSDATE,
'Is the current identified permanency plan appropriate for the child based on the case file review?'
,50,'PERIT3', 'D', 'N',
'YNA', 'Question Help');	

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q51',SYSDATE,
'Is the identified permanency goal consistent throughout the file review (documentation, case plan, court orders, SHINES, AFCARS, etc.)?'
,51,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q52',SYSDATE,
'Is there a judicial determination regarding reasonable efforts within 60 days of the date the child was removed (must be child specific and meaningful)?'
,52,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q53',SYSDATE,
'If there is a Voluntary Placement Agreement, was the agreement signed by parent/legal guardian and an agency representative?'
,53,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q54',SYSDATE,
'Does the court order contain a judicial finding of Contrary to the Welfare, signed by the Judge?  The judicial determination regarding "contrary to the welfare" must be made in the first court ruling that sanctions the child''s removal. The physical removal from the home must coincide with the judicial ruling of "contrary to the welfare."'
,54,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q55',SYSDATE,
'If the child is removed from the home before March 27, 2000, is the Contrary to the Welfare finding stated in a court order (signed by the Judge) issued within 6 months of the child''s removal? Or is there a removal petition filed within 6 months of the child''s removal that results in a judicial finding of contrary to the welfare?'
,55,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q56',SYSDATE,
'If the child is removed from the home on or after March 27, 2000, is the Contrary to the Welfare finding stated in the removal court order and signed by the Judge?'
,56,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q57',SYSDATE,
'Is there a judicial finding of Reasonable Efforts to Prevent Removal or Reasonable Efforts to Reunify Child and Family in the court order signed by the Judge?  For a judicial removal, there must be a determination to the effect that the State agency made reasonable efforts to prevent the removal of the child from the home or that reasonable efforts were not necessary. If the child was removed before March 27, 2000, the requirement may be satisfied with a judicial finding that "reasonable efforts were made to reunify" the child and family after removal.'
,57,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q58',SYSDATE,
'Is there a timely extension (hearing held) of custody (prior to the expiration of previous order)?'
,58,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q59',SYSDATE,
'Is there a judicial determination regarding reasonable efforts to finalize the permanency plan, within 12 months of the date of initial removal or within the most recent 12 month period where there is a subsequent order?<br>(Reasonable efforts must be child specific and meaningful to one of the five Federal Permanency Plans<br> (1) Reunification, <br>(2) adoption, <br>(3) guardianship, <br>(4) live with a fit and willing relative and <br>(5) another planned permanent living arrangement.'
,59,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q60',SYSDATE,
'If required by ASFA or if the case is appropriate, has the agency filed a petition for TPR (if case is not appropriate for TPR then NA should be selected)?'
,60,'PERIT3', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q61',SYSDATE,
'If the child has been in care 15 out of the last 22 months and the agency has not filed TPR, has the agency documented compelling?'
,61,'PERIT3', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q62',SYSDATE,
'Are the services being provided consistent with the identified permanency goal(s)?'
,62,'PERIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q63',SYSDATE,
'Did the agency make concerted efforts to achieve reunification, guardianship or permanent placement with relatives in a timely manner?<br>Consider the time the child has been in foster care, the identified permanency plan, etc., are there any reasons prohibiting the case from having been resolved within 12 months child on trial home visit etc. (Reunification, guardianship, or permanent placement with relatives)'
,63,'PERIT4', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q64',SYSDATE,
'Were identified services provided in a timely manner?'
,64,'PERIT4', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q65',SYSDATE,
'Are the services being provided consistent with reunification, guardianship or permanent placement with relatives?'
,65,'PERIT4', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q66',SYSDATE,
'If the agency has identified a concurrent plan, is there documentation supporting the work toward efforts to achieve both of the goals?'
,66,'PERIT4', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q67',SYSDATE,
'If the child has been in care 12 months or more and reunification remains the permanency plan, is it the appropriate plan for the child?'
,67,'PERIT4', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q68',SYSDATE,
'If so, has the parent made diligent efforts to complete their case plan or are there barriers which prohibited the agency from providing a required service prior to reunification?'
,68,'PERIT4', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q69',SYSDATE,
'Did the agency make concerted efforts to achieve a finalized adoption? 
<br>Consider: 
<br>o was adoption identified as a concurrent plan in a timely manner
<br>o concerted effort to locate absent parents at the beginning and throughout the case
<br>o was adoption achieved within 24 months from the date the child entered into foster care, or
<br>o documented ongoing efforts of the agency to locate an adoptive home for a special needs child yet no home has been located
(Adoption)
<br>IF PERMANENCY HAS NOT BEEN ACHIEVED IN 24 MONTHS AND CHILD IS NOT SIGNIFICANTLY SPECIAL NEEDS THIS ITEM IS A NO.  IF CHILD IS SPECIAL NEEDS AND THERE IS NOT CONCERTED EFFORTS TO RECRUIT A PERMANENT HOME, THEN THIS ITEM IS A NO.'
,69,'PERIT5', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP ) 
VALUES ('Q70',SYSDATE,
'If the child has been in care 15 out of 22 months, has the agency filed a petition on both parents for TPR?'
,70,'PERIT5', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q71',SYSDATE,
'Is current TPR ruling under appeal?'
,71,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q72',SYSDATE,
'If siblings with TPR are placed in separate adoptive homes, do you have a waiver?'
,72,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q73',SYSDATE,
'Upon completion of one parent''s TPR, did the agency initiate an adoption assistance application?'
,73,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q74',SYSDATE,
'Does documentation support the child has been prepared for adoption?'
,74,'PERIT5', 'S', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q75',SYSDATE,
'Does the case plan include goals related to adoption?'
,75,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q76',SYSDATE,
'If the agency has identified a concurrent plan, is there documentation supporting the work toward efforts to achieve both of the goals?'
,76,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q77',SYSDATE,
'Was the child life history initiated timely?'
,77,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q78',SYSDATE,
'Have the foster parents been provided timely notice of the plan to submit TPR, the option to adopt and their rights?'
,78,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q79',SYSDATE,
'For children in care with adoption as a permanency plan without an identified resource  does documentation support diligent efforts to recruit an adoptive family (special needs and non-special needs children)?'
,79,'PERIT5', 'D', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q80',SYSDATE,
'Did the agency make diligent efforts to overcome any delays in the legal process which were within their control?'
,80,'PERIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q81',SYSDATE,
'APPLA:  Did the agency make a concerted effort to ensure the child is prepared to make a transition from foster care and that the child has a commitment for a "permanent living arrangement" with their current caregiver (includes long-term care facilities)? There must be documented commitment via case narrative or long-term foster care agreement. (Another planned permanent living arrangement)'
,81,'PERIT6', 'M', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q82',SYSDATE,
'If the planned goal is "Another Planned Permanent Living Arrangement", does the court order specify the plan and the compelling reasons for this option?'
,82,'PERIT6', 'S', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q83',SYSDATE,
'If the agency has identified a concurrent plan, is there documentation supporting the work toward efforts to achieve both of the goals?'
,83,'PERIT6', 'S', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q84',SYSDATE,
'Is there a signed form indicating or documentation that supports the caregivers'' commitment to the child until he/she is emancipated from foster care?'
,84,'PERIT6', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q85',SYSDATE,
'Is the child connected and actively involved in developing skills related to Independent Living (could come from other sources besides ILP)?'
,85,'PERIT6', 'D', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q86',SYSDATE,
'Does documentation support the involvement of the youth in permanency planning and case planning including the WTLP?'
,86,'PERIT6', 'S', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q87',SYSDATE,
'If the child has expressed a desire to not be adopted, does documentation reflect that the agency provided the child with adequate information and counseling to make an informed decision?'
,87,'PERIT6', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q88',SYSDATE,
'Did the agency make concerted efforts to ensure the child''s foster care placement was close to the parents in order to facilitate face to face contacts between the child and parent? If the child is not placed in close proximity, is the placement based on child''s needs and intended to ensure the child''s case plan goals are met?
<br>Consider:
<br>o same community, county, state (less than 1 hour travel time)
<br>(if whereabouts of the parents are unknown was there documented diligent efforts to locate the parents) 
<br>(Proximity of foster care placement)'
,88,'PERIT7', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q89',SYSDATE,
'Is there documentation indicating the child needs specialized treatment which is not available within their community?'
,89,'PERIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q90',SYSDATE,
'Is the child placed with a relative who is in close proximity to their parent/sibling/community?'
,90,'PERIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q91',SYSDATE,
'Is the child placed in a setting designed to help achieve their case plan goal which is not in close proximity to their parent/sibling community?'
,91,'PERIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q92',SYSDATE,
'Does agency documentation reflect efforts to place child in close proximity to their parent/sibling/community?'
,92,'PERIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q93',SYSDATE,
'If child is not placed in close proximity, does documentation reflect ongoing efforts to secure a placement in close proximity to the parent?'
,93,'PERIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q94',SYSDATE,
'Did the agency make concerted efforts to ensure that all siblings living in foster care were placed together unless a separation was necessary to meet the needs of one of the siblings?
<br>(specialized foster care, abusive to one another, different fathers and places with paternal family members, size of the sibling group i.e. five or more children and attempts are made to place them in close proximity to one another)
<br>(Placement with siblings)'
,94,'PERIT8', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q95',SYSDATE,
'Is there documentation indicating it would not be in a child''s best interest to be placed with their sibling?'
,95,'PERIT8', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q96',SYSDATE,
'Does agency documentation reflect efforts to place siblings together and if not together, in close proximity to one another?'
,96,'PERIT8', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q97',SYSDATE,
'If siblings are separated, does documentation reflect ongoing efforts to secure a placement where all siblings can be placed together, unless treatment indicated...if so then this answer would be NA.'
,97,'PERIT8', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q98',SYSDATE,
'Did the agency make concerted efforts to ensure that visitation between the child and mother, father and/or siblings is of sufficient frequency and quality (adequate length of time) to promote continuity in the child''s relationship to these close family members (exceptions may consider documented information that indicates contact is not in the child''s best interest)?  
<br>If the whereabouts of the parents are unknown, there should be documentation of diligent efforts to locate the parents.  
<br>If parents are incarcerated, did the agency promote other forms of contact including letters, telephone calls and visits when possible?
<br>(Visiting with parents and siblings in foster care)'
,98,'PERIT9', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q99',SYSDATE,
'Does the case plan identify specific visitation between child and parents as well as siblings not placed within foster care?'
,99,'PERIT9', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q100',SYSDATE,
'Does the documentation support agency effort to encourage and assist the family to ensure the visits occur?'
,100,'PERIT9', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q101',SYSDATE,
'Does documentation support agency efforts to promote visitation between siblings not placed within the same foster home?'
,101,'PERIT9', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q102',SYSDATE,
'If child is placed in a relative home, does documentation support the parent child visitation is being supervised by the caregiver in the least restrictive environment possible?'
,102,'PERIT9', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q103',SYSDATE,
'If a parent is incarcerated, is there documentation of the agency''s efforts to facilitate contact between parent and child?'
,103,'PERIT9', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q104',SYSDATE,
'Does documentation support the agency''s effort to promote and encourage a relationship between the parent and child during visitation (this addresses quality of the visit)?'
,104,'PERIT9', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q105',SYSDATE,
'Did the agency make concerted efforts to  maintain the child''s important connections to their  neighborhood, faith, community, language, extended family, tribe (was sufficient information obtained to determine if the child may be eligible for tribal membership), school and friends? (Preserving connections)'
,105,'PERIT10', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q106',SYSDATE,
'Does documentation support the agency''s effort to keep the child in the same school?'
,106,'PERIT10', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q107',SYSDATE,
'Does documentation support the agency''s effort for the child to maintain relationships with "fictive" family?'
,107,'PERIT10', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q108',SYSDATE,
'Does documentation support the efforts of the agency to keep the child connected to their heritage?'
,108,'PERIT10', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q109',SYSDATE,
'Does documentation support the agency''s effort to keep the child linked to the family''s religious affiliation?'
,109,'PERIT10', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q110',SYSDATE,
'Does documentation support the agency efforts to continue the child within the same community (placement, Boys and Girls Club, health department, medical providers etc?)'
,110,'PERIT10', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q111',SYSDATE,
'If the child is Native American, is there documentation in the case file that the agency took appropriate steps to identify the child''s Native American heritage?'
,111,'PERIT10', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q112',SYSDATE,
'Prior to emancipation, does documentation support the agency''s attempt to facilitate a connection for the child to appropriate adults and services in the community?'
,112,'PERIT10', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q113',SYSDATE,
'Did the agency make concerted efforts to place the child with relatives (maternal/paternal) whenever possible (was there evidence that relatives had been considered and ruled out or were unwilling to be considered)? Is the child currently placed in a stable relative placement (even if the child has a relative placement if the placement does not meet the child''s needs or is not considered stable this item is not a strength and should be marked no)? (Relative placement)'
,113,'PERIT11', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q114',SYSDATE,
'Does documentation support that a thorough diligent search was completed for maternal and paternal family members?'
,114,'PERIT11', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q115',SYSDATE,
'Does documentation reflect case manager utilized information from the diligent search to develop support services for the child and family?'
,115,'PERIT11', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q116',SYSDATE,
'Does documentation reflect evaluations of extended family members or family members'' decisions not to be evaluated for placement of the child?'
,116,'PERIT11', 'S', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q117',SYSDATE,
'Does documentation support services being provided to relative placements and safety resources?'
,117,'PERIT11', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q118',SYSDATE,
'Does the case file contain 72 hour evaluations for safety resources for Family Preservation cases and/or full home evaluations/ICPC evaluations for relative placements and/or relative foster home cases?'
,118,'PERIT11', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q119',SYSDATE,
'Does documentation reflect the relative caregivers'' acknowledgement of their right to become a relative foster home as well as discussion and consideration of the associated requirements?'
,119,'PERIT11', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q120',SYSDATE,
'Other than visitation, did the agency make concerted efforts to promote, support and/or maintain positive relationships between the child in foster care with his/her mother, father or caregiver from whom they were removed?
<br>o exceptions include cases with TPR, abandoned child in which parents can not be located, whereabouts of parents are unknown and the agency has documented diligent efforts to locate the parents, contact with the parents has been determined to not be in the best interest of the child, parents are deceased, etc.
<br>(Relationship of child in care with parents)'
,120,'PERIT12', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q121',SYSDATE,
'Does documentation reflect parental involvement in child''s school activities inclusive of IEP, extracurricular events, etc.?'
,121,'PERIT12', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q122',SYSDATE,
'Does documentation support parental involvement in child''s medical decisions?'
,122,'PERIT12', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q123',SYSDATE,
'Does documentation support the agency encouraged the parent(s) to maintain other forms of contact with their child, family counseling, letters, phone calls etc.?'
,123,'PERIT12', 'S', 'N',
'YNA', 'Question Help');




INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q124',SYSDATE,
'Did the agency make concerted efforts to assess (formal or informal) the needs of the child(ren), parents and/or foster parents/caregiver to identify the services necessary to achieve case plan goals and adequately address the issues which necessitated the agency''s involvement with the family? Did the agency provide the appropriate services? (if either question is answered "no," then this item is no). (Needs and services of child, parents, foster parents)'
,124,'WLLIT1', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q125',SYSDATE,
'Was an FTM conducted which clearly demonstrates the inclusion of family members, child (if developmentally and age appropriate/school age), caregivers, stakeholders and service providers (within 9 calendar days of date of removal for foster care and 45 days of initial family preservation staffing for Family Preservation cases)?'
,125,'WLLIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q126',SYSDATE,
'Was information obtained from, as well as shared with agency resources (OFI, CRS, etc.)?  (This information may be in the FTM or narrative).'
,126,'WLLIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q127',SYSDATE,
'Does documentation support the development of the case plan/family plan from information gleaned during the FTM, from assessments, deprivation findings and with the inclusion of family members?'
,127,'WLLIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q128',SYSDATE,
'Are the findings from assessments (substance abuse assessments, psychological, CCFA, developmental, mental health, etc.) incorporated into the case plan?'
,128,'WLLIT1', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q129',SYSDATE,
'Is the agency providing services at a frequency and quality to enable the family to meet the identified case plan goals?  If not, is there documentation as to why the service cannot be provided or why the recommendation cannot be followed?'
,129,'WLLIT1', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q130',SYSDATE,
'Are services provided by external partners being monitored for quality and frequency?'
,130,'WLLIT1', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q131',SYSDATE,
'Does documentation support ongoing discussion of case plans, goals, services provided and progress toward case outcomes with parents, children, caregivers (relatives, foster parents, guardians, fictive kin) and service providers?'
,131,'WLLIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q132',SYSDATE,
'Were subsequent FTMs held when needed ( newly identified needs, change in permanency plans etc.)?'
,132,'WLLIT1', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q133',SYSDATE,
'Were needed services initiated timely?'
,133,'WLLIT1', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q134',SYSDATE,
'Prior to emancipation, does documentation support the agency''s attempts to prepare the child for employment, securing housing and/or continuing education services?'
,134,'WLLIT1', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q135',SYSDATE,
'Did the agency make concerted efforts to involve parents and children (if developmentally appropriate) in the case planning process on an ongoing basis?
<br>o consulted with the child and parents
<br>o involved in periodic reviews
<br>o used terms and language a child can understand
<br>o is there a case plan in the file (signature alone does not indicate involvement)
<br>(Child and family involvement in case planning)'
,135,'WLLIT2', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q136',SYSDATE,
'Does documentation indicate that family members were involved in decisions regarding case planning, service delivery and frequency of services?'
,136,'WLLIT2', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q137',SYSDATE,
'Does documentation and case planning reflect that case plans were periodically reviewed per policy and with the inclusion of the children, parents, caregivers and service providers?'
,137,'WLLIT2', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q138',SYSDATE,
'Is there documentation to support that the family preservation case plan was developed immediately following the FTM?  (if no FTM occurred within at least 90 days of the receipt of the referral.)'
,138,'WLLIT2', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q139',SYSDATE,
'Is there documentation to support the original foster care case plan was completed within 30 days of the child''s date of removal (reviewed with parent and signature requested)?'
,139,'WLLIT2', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q140',SYSDATE,
'Does documentation reflect that families were provided a copy of the initial safety plan, case plan and any subsequent plans developed?'
,140,'WLLIT2', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q141',SYSDATE,
'Did the case manager make contact, with the child(ren), which was of sufficient frequency and quality to ensure safety, permanency and well-being of the child and promote achievement of case goals (must meet at least the minimum monthly policy requirement; if the child has special needs or placement is not stable, contact should be more frequent)? (Caseworker visits with child)'
,141,'WLLIT3', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q142',SYSDATE,
'Was the frequency and quality of the contacts between the caseworker and the child(ren) purposeful and sufficient to address issues pertaining to safety, permanency, well-being and to promote achievement of family support strategies (must at least meet minimum policy standards)?'
,142,'WLLIT3', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q143',SYSDATE,
'Did documentation reflect that private and individual contacts were made with the child(ren)?'
,143,'WLLIT3', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q144',SYSDATE,
'Does documentation reflect child was seen monthly in their home or place of residence?'
,144,'WLLIT3', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q145',SYSDATE,
'If the child was on run-away status, did documentation support ongoing diligent attempts to locate the child?'
,145,'WLLIT3', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q146',SYSDATE,
'Did the case manager make contacts with mother(s) and father(s) of the children that were of sufficient frequency and quality to ensure safety, permanency and well-being of the child and promote achievement of case goals? (Caseworker visits with parents)'
,146,'WLLIT4', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q147',SYSDATE,
'Was the frequency and quality of the contacts between the caseworker and the mother(s) purposeful and sufficient to address issues pertaining to safety, permanency, well-being and to promote achievement of family support strategies (must at least meet minimum policy standards)?'
,147,'WLLIT4', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q148',SYSDATE,
'Was the frequency and quality of the contacts between the caseworker and the father(s) purposeful and sufficient to address issues pertaining to safety, permanency, well-being and to promote achievement of family support strategies (must at least meet minimum policy standards)?'
,148,'WLLIT4', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q149',SYSDATE,
'Was the frequency and quality of the contacts between the caseworker and the original caregiver purposeful and sufficient to address issues pertaining to safety, permanency, well-being and to promote achievement of family support strategies (must at least meet minimum policy standards)?'
,149,'WLLIT4', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q150',SYSDATE,
'Did contacts with parents include discussions related to services being provided by providers, case progress, consequences of not completing case plan goals?'
,150,'WLLIT4', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q151',SYSDATE,
'If mother(s) whereabouts were unknown, did documentation reflect an ongoing diligent effort to locate mother and/her extended family?'
,151,'WLLIT4', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q152',SYSDATE,
'If father(s) whereabouts were unknown, did documentation reflect an ongoing diligent effort to locate father(s) and his/their extended family?'
,152,'WLLIT4', 'D', 'N',
'YNA', 'Question Help');



INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q153',SYSDATE,
'If educational needs were identified in the case were they addressed appropriately? (This includes both placement and family preservation cases, if the child is in foster care educational needs must always be clearly assessed). (Educational needs of the child)'
,153,'WLLIT5', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q154',SYSDATE,
'If identified or observed as a need, does documentation support that the child''s educational needs were addressed (including the action taken, caretaker input, child input, collateral input)?'
,154,'WLLIT5', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q155',SYSDATE,
'Have the birth parents been engaged in the educational plan for the child(ren) as evidenced by involvement in counseling sessions, conversations with case manager regarding needs and progress?'
,155,'WLLIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q156',SYSDATE,
'Have the foster parents  been engaged in the educational plan for the child(ren) as evidenced by involvement in counseling sessions, conversations with case manager regarding needs and progress?'
,156,'WLLIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q157',SYSDATE,
'Is purposeful contact being maintained between the school system and the agency?'
,157,'WLLIT5', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q158',SYSDATE,
'Is there a copy of the educational documentation in the case file (IEP, grades, etc.)?'
,158,'WLLIT5', 'S', 'N',
'YNA', 'Question Help');


INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q159',SYSDATE,
'If physical health needs were identified in the case were they addressed appropriately? (This includes both placement and family preservation cases) If the child is in foster care physical health needs must always be clearly assessed). (Physical health of the child)'
,159,'WLLIT6', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q160',SYSDATE,
'If identified or observed as a need, does documentation support that the child''s physical health needs including dental were addressed (including the action taken, caretaker input, child input, collateral input follow-up appointments, consideration of prescription medications and adverse affects)?'
,160,'WLLIT6', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q161',SYSDATE,
'Were all appropriate children, referred to Babies Can''t Wait per CAPTA requirements?'
,161,'WLLIT6', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q162',SYSDATE,
'Have the birth parents been engaged in the  health treatment plan including dental for the child as evidenced by involvement in counseling sessions, conversations with case manager regarding needs and progress?'
,162,'WLLIT6', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q163',SYSDATE,
'Have the foster parents been engaged in the  health treatment plan including dental for the child as evidenced by involvement in counseling sessions, conversations with case manager regarding needs and progress?'
,163,'WLLIT6', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q164',SYSDATE,
'Is purposeful contact being maintained between the health care providers, including dental and the agency?'
,164,'WLLIT6', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q165',SYSDATE,
'Is there a copy of health care documentation from the providers in the case file (i.e. treatment notes, physical, dental care, etc.)?'
,165,'WLLIT6', 'S', 'N',
'YNA', 'Question Help');



INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q166',SYSDATE,
'If mental health or developmental needs were identified in the case were they addressed appropriately? (This includes both placement and family preservation cases) If the child is in foster care mental health and developmental needs must always be clearly assessed). (Mental/behavioral health of the child)'
,166,'WLLIT7', 'M', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q167',SYSDATE,
'If identified or observed as a need, does documentation support that the child''s mental health needs were addressed (including the action taken, caretaker input, child input, collateral input)?'
,167,'WLLIT7', 'D', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q168',SYSDATE,
'Have the birth parents been engaged in the mental health treatment plan for the child as evidenced by involvement in counseling sessions, conversations with case manager regarding needs and progress?'
,168,'WLLIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q169',SYSDATE,
'Have the foster parents been engaged in the mental health treatment plan for the child as evidenced by involvement in counseling sessions, conversations with case manager regarding needs and progress?'
,169,'WLLIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q170',SYSDATE,
'Is purposeful contact being maintained between the mental health provider and the agency?'
,170,'WLLIT7', 'S', 'N',
'YNA', 'Question Help');

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX,
CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP) 
VALUES ('Q171',SYSDATE,
'Is there a copy of the Mental Health Documentation in the case file?'
,171,'WLLIT7', 'S', 'N',
'YNA', 'Question Help');

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 5'
WHERE CD_ITEM  = 'PERIT1';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 6'
WHERE CD_ITEM  = 'PERIT2';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 7'
WHERE CD_ITEM  = 'PERIT3';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 8'
WHERE CD_ITEM  = 'PERIT4';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 9'
WHERE CD_ITEM  = 'PERIT5';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 10'
WHERE CD_ITEM  = 'PERIT6';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 11'
WHERE CD_ITEM  = 'PERIT7';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 12'
WHERE CD_ITEM  = 'PERIT8';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 13'
WHERE CD_ITEM  = 'PERIT9';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 14'
WHERE CD_ITEM  = 'PERIT10';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 15'
WHERE CD_ITEM  = 'PERIT11';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 16'
WHERE CD_ITEM  = 'PERIT12';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 17'
WHERE CD_ITEM  = 'WLLIT1';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 18'
WHERE CD_ITEM  = 'WLLIT2';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 19'
WHERE CD_ITEM  = 'WLLIT3';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 20'
WHERE CD_ITEM  = 'WLLIT4';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 21'
WHERE CD_ITEM  = 'WLLIT5';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 22'
WHERE CD_ITEM  = 'WLLIT6';

UPDATE CAPS.CASE_REVIEW_ITEM_LOOKUP
SET TXT_ITEM = 'Item 23'
WHERE CD_ITEM  = 'WLLIT7';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q139' AND CD_SURVEY_CODE = 'FPR';

-- last part starts here

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q01');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q01');


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q02');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q02');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INT', 'Q02');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q02');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q03');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q03');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INT', 'Q03');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q03');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q04');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q04');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INT', 'Q04');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q04');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q05');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q05');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INT', 'Q05');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q05');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q06');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q06');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INT', 'Q06');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q06');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q07');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q07');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INT', 'Q07');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q07');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q08');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q08');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INT', 'Q08');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q08');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q09');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q09');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q10');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q10');  

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q11');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q11');   

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q12');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q12');   

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q13');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q13');    


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q14');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q14');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q14');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q14');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q15');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q15');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q15');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q15');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q15');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q16');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q16');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q16');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q16');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q16');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q17');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q17');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q17');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q17');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q17');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q18');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q18');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q18');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q18');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q18');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q19');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q19');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q19');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q19');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q19');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q20');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q20');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q20');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q20');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q21');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q21');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q21');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q21');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q21');	


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q22');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q22');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q22');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q22');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q22');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q23');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q23');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q23');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q23');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q23');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q24');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q24');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q24');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q24');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q24');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q25');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q25');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q25');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q25');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q25');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q26');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q26');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q26');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q26');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q26');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q27');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q27');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q27');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q27');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q27');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q28');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q28');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q28');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q28');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q28');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q29');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q29');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q29');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q29');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q29');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q30');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q30');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q30');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q30');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q30');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q31');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q31');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q31');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q31');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q31');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q32');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q32');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q32');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q32');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q32');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q33');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q33');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q33');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q33');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q33');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q34');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q34');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q34');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q34');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q34');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q35');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q35');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q35');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q35');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q35');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q36');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q36');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q36');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q36');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q36');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q37');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q37');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q37');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q37');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q37');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q38');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q38');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q38');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q38');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q38');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q39');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q39');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q39');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q39');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q39');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q40');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q40');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q40');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q40');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q40');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q41');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q41');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q42');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q42');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q43');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q43');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q44');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q44');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q45');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q45');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q46');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q46');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q47');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q47');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q48');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q48');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q49');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q49');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q50');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q50');		

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q51');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q51');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q52');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q52');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q53');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q53');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q54');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q54');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q55');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q55');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q56');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q56');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q57');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q57');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q58');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q58');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q59');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q59');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q60');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q60');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q61');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q61');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q62');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q62');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q63');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q63');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q64');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q64');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q65');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q65');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q66');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q66');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q67');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q67');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q68');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q68');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q69');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q69');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q70');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q70');		

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q71');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q71');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q72');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q72');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q73');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q73');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q74');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q74');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q75');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q75');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q76');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q76');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q77');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q77');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q78');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q78');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q79');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q79');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q80');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q80');		

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q81');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q81');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q82');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q82');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q83');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q83');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q84');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q84');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q85');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q85');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q86');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q86');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q87');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q87');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q88');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q88');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q89');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q89');			


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q90');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q90');		

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q91');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q91');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q92');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q92');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q93');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q93');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q94');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q94');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q95');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q95');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q96');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q96');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q97');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q97');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q98');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q98');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q99');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q99');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q100');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q100');		

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q101');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q101');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q102');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q102');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q103');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q103');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q104');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q104');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q105');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q105');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q106');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q106');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q107');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q107');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q108');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q108');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q109');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q109');


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q110');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q110');		

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q111');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q111');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q112');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q112');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q113');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q113');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q114');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q114');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q115');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q115');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q116');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q116');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q117');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q117');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q118');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q118');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q119');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q119');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q120');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q120');		

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q121');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q121');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q122');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q122');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q123');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q123');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q124');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q124');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q124');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q125');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q125');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q125');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q126');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q126');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q126');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q127');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q127');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q127');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q128');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q128');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q128');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q129');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q129');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q129');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q130');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q130');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q130');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q131');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q131');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q131');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q132');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q132');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q132');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q133');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q133');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q133');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q134');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q134');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q134');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q135');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q135');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q135');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q136');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q136');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q136');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q137');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q137');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q137');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q138');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q138');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q138');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q139');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q139');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q139');


INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q140');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q140');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q140');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q141');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q141');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q141');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q142');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q142');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q142');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q143');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q143');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q143');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q144');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q144');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q144');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q145');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q145');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q145');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q146');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q146');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q146');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q147');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q147');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q147');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q148');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q148');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q148');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q149');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q149');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q149');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q150');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q150');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q150');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q151');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q151');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q151');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q152');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q152');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q152');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q153');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q153');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q153');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q154');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q154');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q154');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q154');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q155');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q155');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q155');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q156');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q156');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q156');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q157');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q157');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q157');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q158');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q158');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q158');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q159');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q159');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q159');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q160');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q160');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q160');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q160');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q161');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q161');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q161');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q162');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q162');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q162');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q162');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q163');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q163');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q163');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q164');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q164');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q164');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q165');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q165');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q165');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q166');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q166');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q166');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'INV', 'Q167');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q167');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q167');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q167');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q168');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q168');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q168');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q169');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q169');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q169');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q170');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q170');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q170');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'FPR', 'Q171');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q171');

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'ADO', 'Q171');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (459, 'SacwisRev3', 'Release 3.1 - DBCRs 13417,13422');

commit;


