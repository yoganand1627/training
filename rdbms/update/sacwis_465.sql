--STGAP00013614 - STGAP00012833 CaseReview Changes.

--Note:  no impact to ado conversion


DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q05' AND CD_SURVEY_CODE = 'FPR';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q07' AND CD_SURVEY_CODE = 'FPR';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q08' AND CD_SURVEY_CODE = 'FPR';

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q09');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q09');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q10');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q10');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'DIV', 'Q11');	

INSERT INTO CAPS.CASE_REVIEW_SURVEY (ID_CASE_REVIEW_SURVEY, DT_LAST_UPDATE, CD_SURVEY_TYPE, CD_SURVEY_CODE ,CD_QUESTION) 
VALUES (0, SYSDATE,'CSURSTG', 'SUB', 'Q11');	

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q13' AND CD_SURVEY_CODE = 'INV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q16' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q19' AND CD_SURVEY_CODE = 'DIV';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUESTION = 
'Does the case record contain a current valid court order of protection or authority for placement?'
WHERE CD_QUESTION  = 'Q19';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q27' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q27' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q27' AND CD_SURVEY_CODE = 'ADO';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUESTION = 
'Was the parent/caregiver contacted and provided with an explanation of concerns?'
WHERE CD_QUESTION  = 'Q27';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUESTION = 
'Does documentation support that professional providers of services who may be knowledgeable about the alleged maltreatment of the child or needs of the family were interviewed?'
WHERE CD_QUESTION  = 'Q29';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q30' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q32' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q32' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q32' AND CD_SURVEY_CODE = 'ADO';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q33' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q33' AND CD_SURVEY_CODE = 'INV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q34' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q34' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q34' AND CD_SURVEY_CODE = 'ADO';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q35' AND CD_SURVEY_CODE = 'INV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q35' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q35' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q35' AND CD_SURVEY_CODE = 'ADO';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUESTION = 
'For open cases, when new significant safety concerns were identified was a timely CPS referral made?'
WHERE CD_QUESTION  = 'Q37';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q39' AND CD_SURVEY_CODE = 'DIV';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q39' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q39' AND CD_SURVEY_CODE = 'ADO';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUESTION = 
'Do the risk assessment or re-assessment indicators show that risk of further maltreatment is sufficiently reduced and there is no evidence that the child is unsafe or unprotected prior to case closure?'
WHERE CD_QUESTION  = 'Q39';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q40' AND CD_SURVEY_CODE = 'DIV';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET IND_QUESTION_TYPE = 'S'
WHERE CD_QUESTION  = 'Q84';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q134' AND CD_SURVEY_CODE = 'FPR';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q138' AND CD_SURVEY_CODE = 'SUB';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q138' AND CD_SURVEY_CODE = 'ADO';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION ='Q156' AND CD_SURVEY_CODE = 'FPR';



--STGAP00013629 - STGAP00012833 CaseReview Questions Help Text

--Note:  no impact to ado conversion

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Intake Action Tab, Intake Information Tab, Contact Detail-contact narrative
All identified victim children must be seen within the designated response time
Concerted diligent efforts to locate means going above and beyond and is ongoing until such time as all victims have been seen'
WHERE CD_QUESTION  = 'Q01';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Intake Information Narrative'
WHERE CD_QUESTION  = 'Q02';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail (per each person) record checks tab'
WHERE CD_QUESTION  = 'Q03';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case review'
WHERE CD_QUESTION  = 'Q04';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case review'
WHERE CD_QUESTION  = 'Q05';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail (per each person) record checks tab'
WHERE CD_QUESTION  = 'Q06';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Action Tab, Intake Information Tab, Contact Detail-contact narrative
All identified victim children must be seen within the designated response time
Concerted diligent efforts to locate means going above and beyond and is ongoing until such time as all victims have been seen
'
WHERE CD_QUESTION  = 'Q07';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail, Contact Narrative Launch
Concerted diligent efforts to locate means going above and beyond and is ongoing until such time as all victims have been seen
'
WHERE CD_QUESTION  = 'Q08';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail (oper each child)
Records Check.
Narrative Launch
Case Summary
'
WHERE CD_QUESTION  = 'Q09';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Allegations Tab'
WHERE CD_QUESTION  = 'Q10';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Allegation Tab
Case Summary
File Review
'
WHERE CD_QUESTION  = 'Q11';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q12';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan-Team Meetings Reviews
Log of Contacts
'
WHERE CD_QUESTION  = 'Q13';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Person CharacteristicServices and Referral Checklist
Service Authorizations
Log of Contacts
Safety Assessment
Family Plans
'
WHERE CD_QUESTION  = 'Q14';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q15';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q16';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Investigative Conclusion
Log of Contacts for Staffing
Diversion Conclusion
'
WHERE CD_QUESTION  = 'Q17';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q18';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
Case Management Tab
External Documentation
'
WHERE CD_QUESTION  = 'Q19';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Safety Assessment
Safety Plan
Allegation List
Person List
Person Detail
Log of Contacts
Risk Assessment
Risk Re-assessment
Team Meetings Reviews
Foster Adopt Home Non-compliance documentation tab
Policy Violation CAP tab
'
WHERE CD_QUESTION  = 'Q20';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail
Contact Narratives
'
WHERE CD_QUESTION  = 'Q21';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative'
WHERE CD_QUESTION  = 'Q22';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative'
WHERE CD_QUESTION  = 'Q23';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative'
WHERE CD_QUESTION  = 'Q24';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative'
WHERE CD_QUESTION  = 'Q25';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative'
WHERE CD_QUESTION  = 'Q26';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative'
WHERE CD_QUESTION  = 'Q27';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative 
Risk Assessment'
WHERE CD_QUESTION  = 'Q28';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative'
WHERE CD_QUESTION  = 'Q29';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Assessment
Safety Assessment
'
WHERE CD_QUESTION  = 'Q30';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Risk Reassessment
Log of Contacts
Periodic Case Plan Review
'
WHERE CD_QUESTION  = 'Q31';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Safety Assessment
Safety Plan
'
WHERE CD_QUESTION  = 'Q32';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
Contact Narrative
'
WHERE CD_QUESTION  = 'Q33';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Assessment-
Safety Resource Tab-launch
Log of Contacts
Narrative Contacts
'
WHERE CD_QUESTION  = 'Q34';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Assessments for Investigation
Family Plan for ONG
Contact Detail Contact Narrative
'
WHERE CD_QUESTION  = 'Q35';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q36';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q37';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Summary-Protective Services tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q38';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Assessments for Investigation
Family Plan for ONG
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q39';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions'
WHERE CD_QUESTION  = 'Q40';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Custody Tab in the FCF stage
Person Detail-Records Check
Case Summary
'
WHERE CD_QUESTION  = 'Q41';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meeting Reviews'
WHERE CD_QUESTION  = 'Q42';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q43';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q44';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement tab-Placement Checklist-Placement discussion
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q45';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q46';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement tab-Placement Checklist-Placement discussion
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q47';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement-Placement Discussion
FCC-Placement tab-Placement Checklist-Placement discussion
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q48';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCP-Family Plan (identify curren permanency plan)
Legal Action
FCC-Child Plan-Case Plan Topics
External Documentation
'
WHERE CD_QUESTION  = 'Q49';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCP-Family Plan (identify curren permanency plan)
Legal Action
FCC-Child Plan-Case Plan Topics
'
WHERE CD_QUESTION  = 'Q50';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCP Plan
Legal Actions
External Documentation
'
WHERE CD_QUESTION  = 'Q51';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
External Documentation
'
WHERE CD_QUESTION  = 'Q52';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
Contact Narratives
External Documentation.
'
WHERE CD_QUESTION  = 'Q53';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
External Documentation
'
WHERE CD_QUESTION  = 'Q54';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
Case File review
External Documentation
'
WHERE CD_QUESTION  = 'Q55';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
Case File review
External Documentation
'
WHERE CD_QUESTION  = 'Q56';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
Case File review
External Documentation
'
WHERE CD_QUESTION  = 'Q57';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
External Documentation
'
WHERE CD_QUESTION  = 'Q58';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
External Documentation
'
WHERE CD_QUESTION  = 'Q59';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Child Plan-Case Plan Topics-Non-reunification
Legal Actions
'
WHERE CD_QUESTION  = 'Q60';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Child Plan-Case Plan Topics-Non-reunification
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q61';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan
FCC-Child Plan
Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q62';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File review of both FCF and FCF'
WHERE CD_QUESTION  = 'Q63';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Service Authorization
FCF-Team Meetings Review
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q64';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Service Authorization
FCF-Team Meetings Review
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q65';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF- Family Plan to locate Concurrent Plan
Service Authorization
FCF-Team Meetings Review
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q66';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case file review'
WHERE CD_QUESTION  = 'Q67';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case file review'
WHERE CD_QUESTION  = 'Q68';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Review both the FCF anf FCC stages
Person Detail-diligent search
Person Detail-Person Characteristics-special needs
Legal Actions Page
'
WHERE CD_QUESTION  = 'Q69';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Child Plan-Caseplan topics-non-reunification
Legal Actions
'
WHERE CD_QUESTION  = 'Q70';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q71';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q72';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case recod Review'
WHERE CD_QUESTION  = 'Q73';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Service Authorizations
Contact Detail 
Contact Narrative.
'
WHERE CD_QUESTION  = 'Q74';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Child Plan'
WHERE CD_QUESTION  = 'Q75';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan
FCC-Child Plan
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q76';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q77';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'External Documentation
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q78';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'ADO
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q79';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case File Review'
WHERE CD_QUESTION  = 'Q80';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Youth Detail
WTLP
Placement
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q81';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Legal Actions
External Documentation
'
WHERE CD_QUESTION  = 'Q82';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Child Plan
Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q83';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'External Documentation'
WHERE CD_QUESTION  = 'Q84';


UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-WTLP
Youth Detail
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q85';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-WTLP
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q86';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Service Authorizations
FCC-Child Plan-non-reunification
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q87';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement Checklist
*Ongoing Diligent search for parents (mother and father) if there whereabouts are unknown is required
'
WHERE CD_QUESTION  = 'Q88';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Placement Checklist
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q89';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Placement Checklist
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q90';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Placement Checklist
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q91';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Placement tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q92';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Placement tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q93';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement Checklist
Person Detail-Person Characteristics
Service Authorizations
Placement Tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q94';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement Checklist
Person Detail-Person Characteristics
Service Authorizations
Placement Tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q95';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement Checklist
Person Detail-Person Characteristics
Service Authorizations
Placement Tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q96';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement Checklist
Person Detail-Person Characteristics
Service Authorizations
Placement Tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q97';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Child Plan-Visitation Plan
Contact Log-Parent/Child Visitation
Person detail-diligent search
FCC-Placement Checklist
Person Detail-Person Characteristics
Service Authorizations
Placement Tab
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q98';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF Family Plan
FCC-Visitation Plan
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q99';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q100';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q101';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q102';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q103';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q104';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person List-Person Detail-Tribal and Additional Information
Educational
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q105';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Education
FCC-Placement checklist
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q106';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Visitation Plan
'
WHERE CD_QUESTION  = 'Q107';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q108';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q109';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement-placement checklist
Person Detail-Health detail
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q110';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Tribal and additional information
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q111';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-WTLP
Youth Detail
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q112';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement-Placement list
FCC-Placement-relative care assessment
Contact Detail 
Contact Narrative
Person Detail-diligent search
External Documentation
'
WHERE CD_QUESTION  = 'Q113';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-diligent search
Log of Contacts-diligent search contact type
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q114';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan
FCC-Child Plan
Contact Detail 
Contact Narrative
Person Detail-diligent search
'
WHERE CD_QUESTION  = 'Q115';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-dili Contact Detail 
Contact Narrative
gent search
'
WHERE CD_QUESTION  = 'Q116';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'
Services Authorizations
External Documentation
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q117';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placemetn-Relative Care Assessment
External Documentation
Contact Detail 
Contact Narrative
Search FA Home for assessment
'
WHERE CD_QUESTION  = 'Q118';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Placement-Relative Assessment
'
WHERE CD_QUESTION  = 'Q119';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q120';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Education
FCC-Child Plan_Education
FCC-WTLP-Education
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q121';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'
Contact Detail 
Contact Narrative
Health Log-Narrative
'
WHERE CD_QUESTION  = 'Q122';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q123';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meetings Reviews'
WHERE CD_QUESTION  = 'Q124';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meetings Reviews'
WHERE CD_QUESTION  = 'Q125';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meetings Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q126';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q127';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan
FCC-Child Plan-Needs and Outcomes
FCC-Child Plan-DFCS Standard Goals
ONG-Family Plan
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q128';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meetings Reviews'
WHERE CD_QUESTION  = 'Q129';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meetings Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q130';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q131';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan
FCC-Child Plan-Needs and Outcomes
FCC-Child Plan-DFCS Standard Goals
ONG-Family Plan
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q132';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meetings Reviews'
WHERE CD_QUESTION  = 'Q133';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Team Meetings Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q134';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meeting Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q135';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meeting Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q136';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meeting Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q137';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meeting Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q138';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meeting Reviews
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q139';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCF-Family Plan-Foster Care Participant 
ONG-Fmily Plan Client Comments
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q140';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meetings and Reviews
Person Detail-Characteristic
Risk Assessment and Risk re-assessment
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q141';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meetings and Reviews
Person Detail-Characteristic
Risk Assessment and Risk re-assessment
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q142';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meetings and Reviews
Person Detail-Characteristic
Risk Assessment and Risk re-assessment
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q143';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q144';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Person Characteristics
Contact Detail ?Diligent Search for Runaway (contact purpose)
Contact Narrative
External Documentation
Legal Actions
'
WHERE CD_QUESTION  = 'Q145';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meetings and Reviews
Person Detail-Characteristic
Risk Assessment and Risk re-assessment
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q146';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-other relationship
Family Plan
Family Plan-Team Meetings and Reviews
Person Detail-Characteristic
Risk Assessment and Risk re-assessment
Contact Detail 	
Contact Narrative
'
WHERE CD_QUESTION  = 'Q147';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-other relationship
Family Plan
Family Plan-Team Meetings and Reviews
Person Detail-Characteristic
Risk Assessment and Risk re-assessment
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q148';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan
Family Plan-Team Meetings and Reviews
Person Detail-Characteristic
Risk Assessment and Risk re-assessment
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q149';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan-Team Meetings and Review
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q150';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-diligent search
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q151';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-diligent search
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q152';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Education
ONG-Family Plan
FCC-Child Plan
FCC-WTLP
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q153';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Education
ONG-Family Plan
FCC-Child Plan
FCC-WTLP
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q154';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Education
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q155';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement-Placement Discussion
Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q156';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
External Documentation
'
WHERE CD_QUESTION  = 'Q157';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'External Documentation'
WHERE CD_QUESTION  = 'Q158';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Person Characteristics
Medication
Health log
ONG-Family Plan
FCC-Child Plan
FCC-child plan-health status
External Documentation
Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q159';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Person Characteristics
Medication
Health log
ONG-Family Plan
FCC-Child Plan
FCC-child plan-health status
External Documentation
Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q160';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Family Plan-Services and referrals checklist infant or developmental referrals
External documentation
Log of contacts
Service Authorizations
'
WHERE CD_QUESTION  = 'Q161';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Child Plan
FCC-child plan-health status
'
WHERE CD_QUESTION  = 'Q162';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Child Plan
FCC-child plan-health status
'
WHERE CD_QUESTION  = 'Q163';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Child Plan
FCC-child plan-health status
'
WHERE CD_QUESTION  = 'Q164';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'External Documentation'
WHERE CD_QUESTION  = 'Q165';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Person Characteristics
Medication
Health log
ONG-Family Plan
FCC-Child Plan
FCC-child plan-health status
External Documentation
Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q166';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Person Characteristics
Medication
Health log
ONG-Family Plan
FCC-Child Plan
FCC-child plan-health status
External Documentation
Service Authorizations
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q167';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Child Plan
FCC-child plan-health status
'
WHERE CD_QUESTION  = 'Q168';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Child Plan
FCC-child plan-health status
'
WHERE CD_QUESTION  = 'Q169';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Contact Detail 
Contact Narrative
FCC-Child Plan
FCC-child plan-health status
'
WHERE CD_QUESTION  = 'Q170';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'External Documentation'
WHERE CD_QUESTION  = 'Q171';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (466, 'SacwisRev3', 'Release 3.1 - DBCRs 13614,13629,13653,13697,13638');

commit;


