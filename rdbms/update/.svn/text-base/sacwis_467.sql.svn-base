
--STGAP00013745 - MR-50 DBCR Adoption Assitance Agreement
-- Note: Increase column size for two text fields on the agreement

alter table caps.adoption_subsidy modify (TXT_SPCL_ASST_CMNTS varchar2(1000));
alter table caps.adoption_subsidy modify (TXT_ADPT_SUB_RSN varchar2(1000));

--STGAP00013746 - MR-50 DBCR Adoption Assitance Agreement
--Note: no impct to ado conversion

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Adding this Non-Recurring Expenses will take the child over the spending limit of $1500.' 
where TXT_MESSAGE_NAME  = 'MSG_NON_RECURRING_LIMIT' ;

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'You must complete Date Approved before saving.' 
where TXT_MESSAGE_NAME  = 'MSG_ADPT_SUB_DETAIL_INCOMPLETE' ;

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Adoption Assistance service contract must exist before creating subsidy.' 
where TXT_MESSAGE_NAME  = 'MSG_ASV_NO_ASV_CONTRACT' ;

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Selecting this subsidy type will clear some fields on the page.  Continue?' 
where TXT_MESSAGE_NAME  = 'MSG_FAD_SUB_TYPE_CHANGE' ;

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Saving may affect already paid payments.  Continue?' 
where TXT_MESSAGE_NAME  = 'MSG_SUB_AFFECT_PYMT' ;

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'School enrollment must be verified quarterly if the child is between 18 and 21 years old.' 
where TXT_MESSAGE_NAME  = 'MSG_ADO_SCHOOL_VER_REQ' ;

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60529,'MSG_AGMT_START_END_REQD','Both an Agreement Start and Agreement End date are required when an Approved Date has been entered.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60530,'MSG_AGMT_START_BEFORE_SAME_END','The Start date must be before or the same as the End date.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60531,'MSG_AGMT_DATES_WITHIN_APPR_DATES','Special Services Adoption Assistance Agreements Start and End dates must fall within the Approval period of the associated Special Services Adoption Assistance Application.', 
700,500,'N');


INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60532,'MSG_AGMT_BASIC_SPCLD_RATE_EXISTS','An active Basic/Specialized Rate Adoption Assistance Agreement currently exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60533,'MSG_AGMT_NON_RECURR_EXISTS','Non-Recurring %s Adoption Assistance Agreement for %s currently exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60534,'MSG_AGMT_CHILD_CARE_EXISTS','An active Special Services- Child Care Agreement currently exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60535,'MSG_AGMT_RESPITE_EXISTS','An active Special Services- Respite Adoption Assistance Agreement currently exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60536,'MSG_AGMT_MEDICAID_ONLY_GA_CHILD_EXISTS','An active IV-E/ IV-B State Medicaid Only (GA Child) Adoption Assistance Agreement currently exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60537,'MSG_AGMT_MEDICAID_ONLY_GA_CHILD_OVERLAP','Title IV-E/ IV- B State Medicaid Only (GA Child) Adoption Assistance Agreements can not overlap with other Type/Class of Assistance Agreements.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60538,'MSG_AGMT_IVE_EXISTS','An active Title IV- E Adoption Assistance Agreement currently exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60539,'MSG_AGMT_IVB_EXISTS','An active Title IV-B State Adoption Assistance Agreement currently exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60540,'MSG_AGMT_OTHER_SPCL_SERV_COMM_REQD','Other Special Service Please Specify comments are required when Type/Class of Assistance Spec Svc Asst . Other is selected.', 
700,500,'N');


--STGAP00013747 - MR-50 DBCR Adoption Assitance Agreement
--Note: no impct to ado conversion

UPDATE CAPS.CODES_TABLES SET DECODE = 'Title IV-B State Adpt Fin Asst and Medicaid' WHERE CODE = '07' AND CODE_TYPE = 'CSUBTYPE';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Title IV-B State Adpt Fin Asst Only' WHERE CODE = '09' AND CODE_TYPE = 'CSUBTYPE';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Spec Svc Asst - Other (Ent Cd 58d)' WHERE CODE = '21' AND CODE_TYPE = 'CSUBTYPE';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Non-Recurring - Adoption Related Legal Fees (Ent Cd 33a)' WHERE CODE = '22' AND CODE_TYPE = 'CSUBTYPE';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Non-Recurring - Travel (Ent Cd 33c)' WHERE CODE = '23' AND CODE_TYPE = 'CSUBTYPE';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Non-Recurring - Lodging/Meals (Ent Cd 33c)' WHERE CODE = '24' AND CODE_TYPE = 'CSUBTYPE';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Non-Recurring - Physicals for Adoptive Parents (Ent Cd 33b)' WHERE CODE = '25' AND CODE_TYPE = 'CSUBTYPE';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Title IV-B State Medicaid Only (GA Child)' WHERE CODE = '27' AND CODE_TYPE = 'CSUBTYPE';
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES('CSUBTYPE','28','Spec Svc Asst - Dental/Orthodontics (Ent Cd 58c)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES('CSUBTYPE','29','Spec Svc Asst - Medical (Ent Cd 58a)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES('CSUBTYPE','30','Spec Svc Asst - Therapy/Counseling (Ent Cd 58b)',SYSDATE);

UPDATE CAPS.CODES_TABLES SET DECODE = 'Title IV-B State Funded Adoption Assistance (UAS Code 508)' WHERE CODE = 'PST' AND CODE_TYPE = 'CAAFDTYP';
UPDATE CAPS.CODES_TABLES SET DT_END = sysdate WHERE CODE = 'NRC' AND CODE_TYPE = 'CAAFDTYP';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Child Care (UAS 512 Entitlement Code 17)' WHERE CODE = 'DCR' AND CODE_TYPE = 'CSPLSERV';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Dental/Orthodontics (UAS 512 Entitlement Code 58c)' WHERE CODE = 'ORT' AND CODE_TYPE = 'CSPLSERV';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Medical (UAS 512 Entitlement Code 58a)' WHERE CODE = 'MED' AND CODE_TYPE = 'CSPLSERV';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Other (UAS 512 Entitlement Code 58d)' WHERE CODE = 'XXX' AND CODE_TYPE = 'CSPLSERV';

alter table CAPS.SPECIAL_NEEDS_DETERMINATION modify (TXT_PLEASE_SPECIFY varchar2(1000));
alter table CAPS.SPECIAL_NEEDS_DETERMINATION ADD NBR_SP_NEEDS_CHILDREN_REQUEST decimal(5);
alter table CAPS.SPECIAL_NEEDS_DETERMINATION ADD IND_NON_REC_ONLY varchar2(1);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES('CNONREC','LMT','1500',SYSDATE);

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60541,'MSG_ADO_APP_SND_REQ_INIT','Special Needs Determination must be requested on the initial application.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60542,'MSG_ADO_APP_APRV_SPN_REQ','Special Services can only be requested after an initial Special Needs Determination has been approved.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60543,'MSG_ADO_APP_SNC_SS','Please fill in number of Special Needs children for Special Services.', 
700,500,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (468, 'SacwisRev3', 'Release 3.1 - DBCRs 13745,13746,13747');

commit;


