--STGAP00016022 - Release(4.1) MR-53 Elig Add new columns, messages and codes

--Per MR-053 Eligibility: Application and Background add columns
alter table CAPS.FCE_APPLICATION_ENC add IND_AMENDED_APP VARCHAR2(1) null;

comment on column CAPS.FCE_APPLICATION_ENC.IND_AMENDED_APP is 'Indicates if the Application is an Amended Application' ; 

  CREATE OR REPLACE VIEW CAPS.FCE_APPLICATION (ID_FCE_APPLICATION, ID_EVENT, ID_CASE, ID_STAGE, ID_PERSON, 
ID_LAST_UPDATE_PERSON, ID_MNGNG_CVS_PERSON, ID_OTHER_RELATIVE_PERSON, ID_FCE_ELIGIBILITY, DT_LAST_UPDATE, 
ADDR_HEALTH_ADDR_CITY, ADDR_HEALTH_ADDR_ST_LN_1, ADDR_HEALTH_ADDR_ST_LN_2, ADDR_HEALTH_ADDR_ZIP, 
ADDR_REMOVAL_ADDR_ZIP, ADDR_REMOVAL_CITY, ADDR_REMOVAL_ST_LN_1, ADDR_REMOVAL_ST_LN_2, CD_APPLICATION, 
CD_COUNTY_HOSPITAL, CD_HEALTH_ADDR_STATE, CD_LIVING_MONTH_REMOVAL, CD_NOTA_MOST_RECENT, 
CD_REMOVAL_ADDR_COUNTY, CD_REMOVAL_ADDR_STATE, CD_STATE, DT_APPLICATION_COMPLETE, DT_HEALTH_BEGIN_DATE, 
DT_HEALTH_END_DATE, DT_HOSPITAL_ADMISSION, DT_HOSPITAL_DISCHARGE, DT_NOTIFIED_WORKER, DT_PROOF_AGE_SENT_ES, 
DT_PROOF_CITIZENSHIP_SENT_ES, IND_AGE_VRFD_BAPTISM_CERT, IND_AGE_VRFD_FOREIGN_CERT, 
IND_AGE_VRFD_US_BIRTH_CERT, IND_AGE_JUSTIFIED_EVAL, IND_AGE_VRFD_HOSPITAL_CERT, 
IND_AGE_VRFD_NTRLZTN_CERT, IND_AGE_VRFD_PASSPORT, IND_AGE_VRFD_RESIDENT_CARD, IND_CHILD_SUPPORT_ORDER, 
IND_EVALUATION_CONCLUSION, IND_HOSPITAL, IND_INCOME_ASSISTANCE, IND_LEGAL_DOCS_SENT_ES, 
IND_LIVING_RELATIVE_SIX_MONTH, IND_MANAGING_CVS, IND_MINOR_PARENT, IND_NOTIFIED_DHS_WORKER, 
IND_OTHER_HEALTH_INSURANCE, IND_PROOF_AGE_SENT_ES, IND_PROOF_CITIZENSHIP_SENT_ES, NBR_COURT_MONTH, 
NBR_COURT_YEAR, NBR_HEALTH_GROUP, NBR_HEALTH_POLICY, NBR_LIVING_AT_HOME, NBR_NOTIFIED_DHS_WRKR_PHN, 
NM_HEALTH_COMPANY, NM_HEALTH_EMPLOYEE_NM, NM_HEALTH_EMPLOYER_NM, NM_HEALTH_POLICY_HLDR_NM, NM_HOSPITAL, 
NM_HOSPITAL_CITY, NM_MOTHER_MAIDEN, NM_NOTIFIED_DHS_WRKR_FIRST, NM_NOTIFIED_DHS_WRKR_LAST, 
NM_NOTIFIED_DHS_WRKR_MIDDLE, TXT_INCOME_DTRMNTN_COMMENTS, TXT_LEGAL_DOCS_SENT_ES, 
TXT_MEETS_DD_OR_NOT_COMMENTS, TXT_NO_INCOME_EXPLANATION, TXT_PROOF_AGE_SENT_ES, 
TXT_PROOF_CITIZENSHIP_SENT_ES, IND_AGE_VRFD_SUCCESS_SYSTEM, IND_AGE_VRFD_SAVE_SYSTEM, 
IND_EVAL_REVIEW_EC_ES, IND_MEDICAL_ASSISTANCE, TXT_MONTH_MEDICAL_ASSISTANCE, IND_PRF_PREGNANCY_SENT_ES, 
TXT_PRF_PREGNANCY_SENT_ES, TXT_PRIOR_REMOVAL_MONTHS, IND_PROOF_CHILD_ID_SENT_ES, 
DT_PROOF_CHILD_ID_SENT_ES, TXT_PROOF_CHILD_ID_SENT_ES, DT_PROOF_PREGNANCY_SENT_ES, 
TXT_EMPLOYEE_COMMENTS, DT_LEGAL_DOCS_SENT_ES, DT_REMOVAL_DATE, IND_SPECIFIED_RELATIVE, IND_AMENDED_APP) AS 
  SELECT
 ID_FCE_APPLICATION,
 ID_EVENT,
 ID_CASE,
 ID_STAGE,
 ID_PERSON,
 ID_LAST_UPDATE_PERSON,
 ID_MNGNG_CVS_PERSON,
 ID_OTHER_RELATIVE_PERSON,
 ID_FCE_ELIGIBILITY,
 DT_LAST_UPDATE,
 ADDR_HEALTH_ADDR_CITY,
 ADDR_HEALTH_ADDR_ST_LN_1,
 ADDR_HEALTH_ADDR_ST_LN_2,
 ADDR_HEALTH_ADDR_ZIP,
 ADDR_REMOVAL_ADDR_ZIP,
 ADDR_REMOVAL_CITY,
 ADDR_REMOVAL_ST_LN_1,
 ADDR_REMOVAL_ST_LN_2,
 CD_APPLICATION,
 CD_COUNTY_HOSPITAL,
 CD_HEALTH_ADDR_STATE,
 CD_LIVING_MONTH_REMOVAL,
 CD_NOTA_MOST_RECENT,
 CD_REMOVAL_ADDR_COUNTY,
 CD_REMOVAL_ADDR_STATE,
 CD_STATE,
 DT_APPLICATION_COMPLETE,
 DT_HEALTH_BEGIN_DATE,
 DT_HEALTH_END_DATE,
 DT_HOSPITAL_ADMISSION,
 DT_HOSPITAL_DISCHARGE,
 DT_NOTIFIED_WORKER,
 DT_PROOF_AGE_SENT_ES,
 DT_PROOF_CITIZENSHIP_SENT_ES,
 IND_AGE_VRFD_BAPTISM_CERT,
 IND_AGE_VRFD_FOREIGN_CERT,
 IND_AGE_VRFD_US_BIRTH_CERT,
 IND_AGE_JUSTIFIED_EVAL,
 IND_AGE_VRFD_HOSPITAL_CERT,
 IND_AGE_VRFD_NTRLZTN_CERT,
 IND_AGE_VRFD_PASSPORT,
 IND_AGE_VRFD_RESIDENT_CARD,
 IND_CHILD_SUPPORT_ORDER,
 IND_EVALUATION_CONCLUSION,
 IND_HOSPITAL,
 IND_INCOME_ASSISTANCE,
 IND_LEGAL_DOCS_SENT_ES,
 IND_LIVING_RELATIVE_SIX_MONTH,
 IND_MANAGING_CVS,
 IND_MINOR_PARENT,
 IND_NOTIFIED_DHS_WORKER,
 IND_OTHER_HEALTH_INSURANCE,
 IND_PROOF_AGE_SENT_ES,
 IND_PROOF_CITIZENSHIP_SENT_ES,
 NBR_COURT_MONTH,
 NBR_COURT_YEAR,
 NBR_HEALTH_GROUP,
 CAST(CAPS.DECRYPT(NBR_HEALTH_POLICY) AS VARCHAR2(20))  NBR_HEALTH_POLICY,
 NBR_LIVING_AT_HOME,
 NBR_NOTIFIED_DHS_WRKR_PHN,
 NM_HEALTH_COMPANY,
 NM_HEALTH_EMPLOYEE_NM,
 NM_HEALTH_EMPLOYER_NM,
 NM_HEALTH_POLICY_HLDR_NM,
 NM_HOSPITAL,
 NM_HOSPITAL_CITY,
 NM_MOTHER_MAIDEN,
 NM_NOTIFIED_DHS_WRKR_FIRST,
 NM_NOTIFIED_DHS_WRKR_LAST,
 NM_NOTIFIED_DHS_WRKR_MIDDLE,
 TXT_INCOME_DTRMNTN_COMMENTS,
 TXT_LEGAL_DOCS_SENT_ES,
 TXT_MEETS_DD_OR_NOT_COMMENTS,
 TXT_NO_INCOME_EXPLANATION,
 TXT_PROOF_AGE_SENT_ES,
 TXT_PROOF_CITIZENSHIP_SENT_ES,
 IND_AGE_VRFD_SUCCESS_SYSTEM,
 IND_AGE_VRFD_SAVE_SYSTEM,
 IND_EVAL_REVIEW_EC_ES,
 IND_MEDICAL_ASSISTANCE,
 TXT_MONTH_MEDICAL_ASSISTANCE,
 IND_PRF_PREGNANCY_SENT_ES,
 TXT_PRF_PREGNANCY_SENT_ES,
 TXT_PRIOR_REMOVAL_MONTHS,
 IND_PROOF_CHILD_ID_SENT_ES,
 DT_PROOF_CHILD_ID_SENT_ES,
 TXT_PROOF_CHILD_ID_SENT_ES,
 DT_PROOF_PREGNANCY_SENT_ES,
 TXT_EMPLOYEE_COMMENTS,
 DT_LEGAL_DOCS_SENT_ES,
 DT_REMOVAL_DATE,
 IND_SPECIFIED_RELATIVE,
 IND_AMENDED_APP
FROM CAPS.FCE_APPLICATION_ENC;
 
grant select on caps.fce_application_enc to operator;

/
create or replace TRIGGER CAPS.TISI_FCE_APPLICATION 
INSTEAD OF INSERT
ON CAPS.FCE_APPLICATION
REFERENCING NEW AS NEW
BEGIN
INSERT INTO CAPS.FCE_APPLICATION_ENC (
 ID_FCE_APPLICATION,
 ID_EVENT,
 ID_CASE,
 ID_STAGE,
 ID_PERSON,
 ID_LAST_UPDATE_PERSON,
 ID_MNGNG_CVS_PERSON,
 ID_OTHER_RELATIVE_PERSON,
 ID_FCE_ELIGIBILITY,
 DT_LAST_UPDATE,
 ADDR_HEALTH_ADDR_CITY,
 ADDR_HEALTH_ADDR_ST_LN_1,
 ADDR_HEALTH_ADDR_ST_LN_2,
 ADDR_HEALTH_ADDR_ZIP,
 ADDR_REMOVAL_ADDR_ZIP,
 ADDR_REMOVAL_CITY,
 ADDR_REMOVAL_ST_LN_1,
 ADDR_REMOVAL_ST_LN_2,
 CD_APPLICATION,
 CD_COUNTY_HOSPITAL,
 CD_HEALTH_ADDR_STATE,
 CD_LIVING_MONTH_REMOVAL,
 CD_NOTA_MOST_RECENT,
 CD_REMOVAL_ADDR_COUNTY,
 CD_REMOVAL_ADDR_STATE,
 CD_STATE,
 DT_APPLICATION_COMPLETE,
 DT_HEALTH_BEGIN_DATE,
 DT_HEALTH_END_DATE,
 DT_HOSPITAL_ADMISSION,
 DT_HOSPITAL_DISCHARGE,
 DT_NOTIFIED_WORKER,
 DT_PROOF_AGE_SENT_ES,
 DT_PROOF_CITIZENSHIP_SENT_ES,
 IND_AGE_VRFD_BAPTISM_CERT,
 IND_AGE_VRFD_FOREIGN_CERT,
 IND_AGE_VRFD_US_BIRTH_CERT,
 IND_AGE_JUSTIFIED_EVAL,
 IND_AGE_VRFD_HOSPITAL_CERT,
 IND_AGE_VRFD_NTRLZTN_CERT,
 IND_AGE_VRFD_PASSPORT,
 IND_AGE_VRFD_RESIDENT_CARD,
 IND_CHILD_SUPPORT_ORDER,
 IND_EVALUATION_CONCLUSION,
 IND_HOSPITAL,
 IND_INCOME_ASSISTANCE,
 IND_LEGAL_DOCS_SENT_ES,
 IND_LIVING_RELATIVE_SIX_MONTH,
 IND_MANAGING_CVS,
 IND_MINOR_PARENT,
 IND_NOTIFIED_DHS_WORKER,
 IND_OTHER_HEALTH_INSURANCE,
 IND_PROOF_AGE_SENT_ES,
 IND_PROOF_CITIZENSHIP_SENT_ES,
 NBR_COURT_MONTH,
 NBR_COURT_YEAR,
 NBR_HEALTH_GROUP,
 NBR_HEALTH_POLICY,
 NBR_LIVING_AT_HOME,
 NBR_NOTIFIED_DHS_WRKR_PHN,
 NM_HEALTH_COMPANY,
 NM_HEALTH_EMPLOYEE_NM,
 NM_HEALTH_EMPLOYER_NM,
 NM_HEALTH_POLICY_HLDR_NM,
 NM_HOSPITAL,
 NM_HOSPITAL_CITY,
 NM_MOTHER_MAIDEN,
 NM_NOTIFIED_DHS_WRKR_FIRST,
 NM_NOTIFIED_DHS_WRKR_LAST,
 NM_NOTIFIED_DHS_WRKR_MIDDLE,
 TXT_INCOME_DTRMNTN_COMMENTS,
 TXT_LEGAL_DOCS_SENT_ES,
 TXT_MEETS_DD_OR_NOT_COMMENTS,
 TXT_NO_INCOME_EXPLANATION,
 TXT_PROOF_AGE_SENT_ES,
 TXT_PROOF_CITIZENSHIP_SENT_ES,
 IND_AGE_VRFD_SUCCESS_SYSTEM,
 IND_AGE_VRFD_SAVE_SYSTEM,
 IND_EVAL_REVIEW_EC_ES,
 IND_MEDICAL_ASSISTANCE,
 TXT_MONTH_MEDICAL_ASSISTANCE,
 IND_PRF_PREGNANCY_SENT_ES,
 TXT_PRF_PREGNANCY_SENT_ES,
 TXT_PRIOR_REMOVAL_MONTHS,
 IND_PROOF_CHILD_ID_SENT_ES,
 DT_PROOF_CHILD_ID_SENT_ES,
 TXT_PROOF_CHILD_ID_SENT_ES,
 DT_PROOF_PREGNANCY_SENT_ES,
 TXT_EMPLOYEE_COMMENTS,
 DT_LEGAL_DOCS_SENT_ES,
 DT_REMOVAL_DATE,
 IND_SPECIFIED_RELATIVE,
 IND_AMENDED_APP)
VALUES
(
 :NEW.ID_FCE_APPLICATION,
 :NEW.ID_EVENT,
 :NEW.ID_CASE,
 :NEW.ID_STAGE,
 :NEW.ID_PERSON,
 :NEW.ID_LAST_UPDATE_PERSON,
 :NEW.ID_MNGNG_CVS_PERSON,
 :NEW.ID_OTHER_RELATIVE_PERSON,
 :NEW.ID_FCE_ELIGIBILITY,
 :NEW.DT_LAST_UPDATE,
 :NEW.ADDR_HEALTH_ADDR_CITY,
 :NEW.ADDR_HEALTH_ADDR_ST_LN_1,
 :NEW.ADDR_HEALTH_ADDR_ST_LN_2,
 :NEW.ADDR_HEALTH_ADDR_ZIP,
 :NEW.ADDR_REMOVAL_ADDR_ZIP,
 :NEW.ADDR_REMOVAL_CITY,
 :NEW.ADDR_REMOVAL_ST_LN_1,
 :NEW.ADDR_REMOVAL_ST_LN_2,
 :NEW.CD_APPLICATION,
 :NEW.CD_COUNTY_HOSPITAL,
 :NEW.CD_HEALTH_ADDR_STATE,
 :NEW.CD_LIVING_MONTH_REMOVAL,
 :NEW.CD_NOTA_MOST_RECENT,
 :NEW.CD_REMOVAL_ADDR_COUNTY,
 :NEW.CD_REMOVAL_ADDR_STATE,
 :NEW.CD_STATE,
 :NEW.DT_APPLICATION_COMPLETE,
 :NEW.DT_HEALTH_BEGIN_DATE,
 :NEW.DT_HEALTH_END_DATE,
 :NEW.DT_HOSPITAL_ADMISSION,
 :NEW.DT_HOSPITAL_DISCHARGE,
 :NEW.DT_NOTIFIED_WORKER,
 :NEW.DT_PROOF_AGE_SENT_ES,
 :NEW.DT_PROOF_CITIZENSHIP_SENT_ES,
 :NEW.IND_AGE_VRFD_BAPTISM_CERT,
 :NEW.IND_AGE_VRFD_FOREIGN_CERT,
 :NEW.IND_AGE_VRFD_US_BIRTH_CERT,
 :NEW.IND_AGE_JUSTIFIED_EVAL,
 :NEW.IND_AGE_VRFD_HOSPITAL_CERT,
 :NEW.IND_AGE_VRFD_NTRLZTN_CERT,
 :NEW.IND_AGE_VRFD_PASSPORT,
 :NEW.IND_AGE_VRFD_RESIDENT_CARD,
 :NEW.IND_CHILD_SUPPORT_ORDER,
 :NEW.IND_EVALUATION_CONCLUSION,
 :NEW.IND_HOSPITAL,
 :NEW.IND_INCOME_ASSISTANCE,
 :NEW.IND_LEGAL_DOCS_SENT_ES,
 :NEW.IND_LIVING_RELATIVE_SIX_MONTH,
 :NEW.IND_MANAGING_CVS,
 :NEW.IND_MINOR_PARENT,
 :NEW.IND_NOTIFIED_DHS_WORKER,
 :NEW.IND_OTHER_HEALTH_INSURANCE,
 :NEW.IND_PROOF_AGE_SENT_ES,
 :NEW.IND_PROOF_CITIZENSHIP_SENT_ES,
 :NEW.NBR_COURT_MONTH,
 :NEW.NBR_COURT_YEAR,
 :NEW.NBR_HEALTH_GROUP,
 ENCRYPT(:NEW.NBR_HEALTH_POLICY),
 :NEW.NBR_LIVING_AT_HOME,
 :NEW.NBR_NOTIFIED_DHS_WRKR_PHN,
 :NEW.NM_HEALTH_COMPANY,
 :NEW.NM_HEALTH_EMPLOYEE_NM,
 :NEW.NM_HEALTH_EMPLOYER_NM,
 :NEW.NM_HEALTH_POLICY_HLDR_NM,
 :NEW.NM_HOSPITAL,
 :NEW.NM_HOSPITAL_CITY,
 :NEW.NM_MOTHER_MAIDEN,
 :NEW.NM_NOTIFIED_DHS_WRKR_FIRST,
 :NEW.NM_NOTIFIED_DHS_WRKR_LAST,
 :NEW.NM_NOTIFIED_DHS_WRKR_MIDDLE,
 :NEW.TXT_INCOME_DTRMNTN_COMMENTS,
 :NEW.TXT_LEGAL_DOCS_SENT_ES,
 :NEW.TXT_MEETS_DD_OR_NOT_COMMENTS,
 :NEW.TXT_NO_INCOME_EXPLANATION,
 :NEW.TXT_PROOF_AGE_SENT_ES,
 :NEW.TXT_PROOF_CITIZENSHIP_SENT_ES,
 :NEW.IND_AGE_VRFD_SUCCESS_SYSTEM,
 :NEW.IND_AGE_VRFD_SAVE_SYSTEM,
 :NEW.IND_EVAL_REVIEW_EC_ES,
 :NEW.IND_MEDICAL_ASSISTANCE,
 :NEW.TXT_MONTH_MEDICAL_ASSISTANCE,
 :NEW.IND_PRF_PREGNANCY_SENT_ES,
 :NEW.TXT_PRF_PREGNANCY_SENT_ES,
 :NEW.TXT_PRIOR_REMOVAL_MONTHS,
 :NEW.IND_PROOF_CHILD_ID_SENT_ES,
 :NEW.DT_PROOF_CHILD_ID_SENT_ES,
 :NEW.TXT_PROOF_CHILD_ID_SENT_ES,
 :NEW.DT_PROOF_PREGNANCY_SENT_ES,
 :NEW.TXT_EMPLOYEE_COMMENTS,
 :NEW.DT_LEGAL_DOCS_SENT_ES,
 :NEW.DT_REMOVAL_DATE,
 :NEW.IND_SPECIFIED_RELATIVE,
 :NEW.IND_AMENDED_APP) ;
END;
/

/
create or replace TRIGGER CAPS.TISU_FCE_APPLICATION 
INSTEAD OF UPDATE
ON CAPS.FCE_APPLICATION
REFERENCING NEW AS NEW OLD AS OLD
BEGIN
UPDATE CAPS.FCE_APPLICATION_ENC SET
 ID_FCE_APPLICATION = :NEW.ID_FCE_APPLICATION,
 ID_EVENT = :NEW.ID_EVENT,
 ID_CASE = :NEW.ID_CASE,
 ID_STAGE = :NEW.ID_STAGE,
 ID_PERSON = :NEW.ID_PERSON,
 ID_LAST_UPDATE_PERSON = :NEW.ID_LAST_UPDATE_PERSON,
 ID_MNGNG_CVS_PERSON = :NEW.ID_MNGNG_CVS_PERSON,
 ID_OTHER_RELATIVE_PERSON = :NEW.ID_OTHER_RELATIVE_PERSON,
 ID_FCE_ELIGIBILITY = :NEW.ID_FCE_ELIGIBILITY,
 DT_LAST_UPDATE = :NEW.DT_LAST_UPDATE,
 ADDR_HEALTH_ADDR_CITY = :NEW.ADDR_HEALTH_ADDR_CITY,
 ADDR_HEALTH_ADDR_ST_LN_1 = :NEW.ADDR_HEALTH_ADDR_ST_LN_1,
 ADDR_HEALTH_ADDR_ST_LN_2 = :NEW.ADDR_HEALTH_ADDR_ST_LN_2,
 ADDR_HEALTH_ADDR_ZIP = :NEW.ADDR_HEALTH_ADDR_ZIP,
 ADDR_REMOVAL_ADDR_ZIP = :NEW.ADDR_REMOVAL_ADDR_ZIP,
 ADDR_REMOVAL_CITY = :NEW.ADDR_REMOVAL_CITY,
 ADDR_REMOVAL_ST_LN_1 = :NEW.ADDR_REMOVAL_ST_LN_1,
 ADDR_REMOVAL_ST_LN_2 = :NEW.ADDR_REMOVAL_ST_LN_2,
 CD_APPLICATION = :NEW.CD_APPLICATION,
 CD_COUNTY_HOSPITAL = :NEW.CD_COUNTY_HOSPITAL,
 CD_HEALTH_ADDR_STATE = :NEW.CD_HEALTH_ADDR_STATE,
 CD_LIVING_MONTH_REMOVAL = :NEW.CD_LIVING_MONTH_REMOVAL,
 CD_NOTA_MOST_RECENT = :NEW.CD_NOTA_MOST_RECENT,
 CD_REMOVAL_ADDR_COUNTY = :NEW.CD_REMOVAL_ADDR_COUNTY,
 CD_REMOVAL_ADDR_STATE = :NEW.CD_REMOVAL_ADDR_STATE,
 CD_STATE = :NEW.CD_STATE,
 DT_APPLICATION_COMPLETE = :NEW.DT_APPLICATION_COMPLETE,
 DT_HEALTH_BEGIN_DATE = :NEW.DT_HEALTH_BEGIN_DATE,
 DT_HEALTH_END_DATE = :NEW.DT_HEALTH_END_DATE,
 DT_HOSPITAL_ADMISSION = :NEW.DT_HOSPITAL_ADMISSION,
 DT_HOSPITAL_DISCHARGE = :NEW.DT_HOSPITAL_DISCHARGE,
 DT_NOTIFIED_WORKER = :NEW.DT_NOTIFIED_WORKER,
 DT_PROOF_AGE_SENT_ES = :NEW.DT_PROOF_AGE_SENT_ES,
 DT_PROOF_CITIZENSHIP_SENT_ES = :NEW.DT_PROOF_CITIZENSHIP_SENT_ES,
 IND_AGE_VRFD_BAPTISM_CERT = :NEW.IND_AGE_VRFD_BAPTISM_CERT,
 IND_AGE_VRFD_FOREIGN_CERT = :NEW.IND_AGE_VRFD_FOREIGN_CERT,
 IND_AGE_VRFD_US_BIRTH_CERT = :NEW.IND_AGE_VRFD_US_BIRTH_CERT,
 IND_AGE_JUSTIFIED_EVAL = :NEW.IND_AGE_JUSTIFIED_EVAL,
 IND_AGE_VRFD_HOSPITAL_CERT = :NEW.IND_AGE_VRFD_HOSPITAL_CERT,
 IND_AGE_VRFD_NTRLZTN_CERT = :NEW.IND_AGE_VRFD_NTRLZTN_CERT,
 IND_AGE_VRFD_PASSPORT = :NEW.IND_AGE_VRFD_PASSPORT,
 IND_AGE_VRFD_RESIDENT_CARD = :NEW.IND_AGE_VRFD_RESIDENT_CARD,
 IND_CHILD_SUPPORT_ORDER = :NEW.IND_CHILD_SUPPORT_ORDER,
 IND_EVALUATION_CONCLUSION = :NEW.IND_EVALUATION_CONCLUSION,
 IND_HOSPITAL = :NEW.IND_HOSPITAL,
 IND_INCOME_ASSISTANCE = :NEW.IND_INCOME_ASSISTANCE,
 IND_LEGAL_DOCS_SENT_ES = :NEW.IND_LEGAL_DOCS_SENT_ES,
 IND_LIVING_RELATIVE_SIX_MONTH = :NEW.IND_LIVING_RELATIVE_SIX_MONTH,
 IND_MANAGING_CVS = :NEW.IND_MANAGING_CVS,
 IND_MINOR_PARENT = :NEW.IND_MINOR_PARENT,
 IND_NOTIFIED_DHS_WORKER = :NEW.IND_NOTIFIED_DHS_WORKER,
 IND_OTHER_HEALTH_INSURANCE = :NEW.IND_OTHER_HEALTH_INSURANCE,
 IND_PROOF_AGE_SENT_ES = :NEW.IND_PROOF_AGE_SENT_ES,
 IND_PROOF_CITIZENSHIP_SENT_ES = :NEW.IND_PROOF_CITIZENSHIP_SENT_ES,
 NBR_COURT_MONTH = :NEW.NBR_COURT_MONTH,
 NBR_COURT_YEAR = :NEW.NBR_COURT_YEAR,
 NBR_HEALTH_GROUP = :NEW.NBR_HEALTH_GROUP,
 NBR_HEALTH_POLICY = CAPS.ENCRYPT(:NEW.NBR_HEALTH_POLICY),
 NBR_LIVING_AT_HOME = :NEW.NBR_LIVING_AT_HOME,
 NBR_NOTIFIED_DHS_WRKR_PHN = :NEW.NBR_NOTIFIED_DHS_WRKR_PHN,
 NM_HEALTH_COMPANY = :NEW.NM_HEALTH_COMPANY,
 NM_HEALTH_EMPLOYEE_NM = :NEW.NM_HEALTH_EMPLOYEE_NM,
 NM_HEALTH_EMPLOYER_NM = :NEW.NM_HEALTH_EMPLOYER_NM,
 NM_HEALTH_POLICY_HLDR_NM = :NEW.NM_HEALTH_POLICY_HLDR_NM,
 NM_HOSPITAL = :NEW.NM_HOSPITAL,
 NM_HOSPITAL_CITY = :NEW.NM_HOSPITAL_CITY,
 NM_MOTHER_MAIDEN = :NEW.NM_MOTHER_MAIDEN,
 NM_NOTIFIED_DHS_WRKR_FIRST = :NEW.NM_NOTIFIED_DHS_WRKR_FIRST,
 NM_NOTIFIED_DHS_WRKR_LAST = :NEW.NM_NOTIFIED_DHS_WRKR_LAST,
 NM_NOTIFIED_DHS_WRKR_MIDDLE = :NEW.NM_NOTIFIED_DHS_WRKR_MIDDLE,
 TXT_INCOME_DTRMNTN_COMMENTS = :NEW.TXT_INCOME_DTRMNTN_COMMENTS,
 TXT_LEGAL_DOCS_SENT_ES = :NEW.TXT_LEGAL_DOCS_SENT_ES,
 TXT_MEETS_DD_OR_NOT_COMMENTS = :NEW.TXT_MEETS_DD_OR_NOT_COMMENTS,
 TXT_NO_INCOME_EXPLANATION = :NEW.TXT_NO_INCOME_EXPLANATION,
 TXT_PROOF_AGE_SENT_ES = :NEW.TXT_PROOF_AGE_SENT_ES,
 TXT_PROOF_CITIZENSHIP_SENT_ES = :NEW.TXT_PROOF_CITIZENSHIP_SENT_ES,
 IND_AGE_VRFD_SUCCESS_SYSTEM = :NEW.IND_AGE_VRFD_SUCCESS_SYSTEM,
 IND_AGE_VRFD_SAVE_SYSTEM = :NEW.IND_AGE_VRFD_SAVE_SYSTEM,
 IND_EVAL_REVIEW_EC_ES = :NEW.IND_EVAL_REVIEW_EC_ES,
 IND_MEDICAL_ASSISTANCE = :NEW.IND_MEDICAL_ASSISTANCE,
 TXT_MONTH_MEDICAL_ASSISTANCE = :NEW.TXT_MONTH_MEDICAL_ASSISTANCE,
 IND_PRF_PREGNANCY_SENT_ES = :NEW.IND_PRF_PREGNANCY_SENT_ES,
 TXT_PRF_PREGNANCY_SENT_ES = :NEW.TXT_PRF_PREGNANCY_SENT_ES,
 TXT_PRIOR_REMOVAL_MONTHS = :NEW.TXT_PRIOR_REMOVAL_MONTHS,
 IND_PROOF_CHILD_ID_SENT_ES = :NEW.IND_PROOF_CHILD_ID_SENT_ES,
 DT_PROOF_CHILD_ID_SENT_ES = :NEW.DT_PROOF_CHILD_ID_SENT_ES,
 TXT_PROOF_CHILD_ID_SENT_ES = :NEW.TXT_PROOF_CHILD_ID_SENT_ES,
 DT_PROOF_PREGNANCY_SENT_ES = :NEW.DT_PROOF_PREGNANCY_SENT_ES,
 TXT_EMPLOYEE_COMMENTS = :NEW.TXT_EMPLOYEE_COMMENTS,
 DT_LEGAL_DOCS_SENT_ES = :NEW.DT_LEGAL_DOCS_SENT_ES,
 DT_REMOVAL_DATE = :NEW.DT_REMOVAL_DATE,
 IND_SPECIFIED_RELATIVE = :NEW.IND_SPECIFIED_RELATIVE,
 IND_AMENDED_APP = :NEW.IND_AMENDED_APP
WHERE ID_FCE_APPLICATION = :OLD.ID_FCE_APPLICATION;
END;
/


--Per MR-053 Eligibility: Income and Expenditures and Worksheet add Allocation columns
alter table CAPS.FCE_ELIGIBILITY add CD_ALLOC_TYPE VARCHAR2(4) null;
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_SNGL_1 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_SPOUSE_ALLOC_SNGL_1 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_CHILD_ALLOC_SNGL_1 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_STD_OF_NEED_ALLOC_SNGL_1 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_ALLOC_SNGL_1 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_ALLOC_ALLOWANCE_SNGL_1 NUMBER(16,2) null;

alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_MUTUAL_1 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_MUTUAL_2 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_SPOUSE_ALLOC_MUTUAL NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_CHILD_ALLOC_MUTUAL NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_STD_OF_NEED_ALLOC_MUTUAL NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_ALLOC_MUTUAL NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_ALLOC_ALLOWANCE_MUTUAL NUMBER(16,2) null;

alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_ALLOC_SNGL_2 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_SPOUSE_ALLOC_SNGL_2 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_INELIG_CHILD_ALLOC_SNGL_2 NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_STD_OF_NEED_ALLOC_SNGL_2 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_ALLOC_SNGL_2 NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_ALLOC_ALLOWANCE_SNGL_2 NUMBER(16,2) null;

comment on column CAPS.FCE_ELIGIBILITY.CD_ALLOC_TYPE is 'Indicates the Allocation type' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_SNGL_1 is 'Multi-purpose column used to record the AU member responsible for allocating money out of the assistance unit for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_SPOUSE_ALLOC_SNGL_1 is 'Multi-purpose column used to record the number of ineligible spouse(s) for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_CHILD_ALLOC_SNGL_1 is 'Multi-purpose column used to record the number of ineligible children(en) for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_STD_OF_NEED_ALLOC_SNGL_1 is 'Multi-purpose column used to record the Standard of Need for the # of persons to whom AU member''s income can be allocated for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_ALLOC_SNGL_1 is 'Multi-purpose column used to record the Gross Income of the AU member responsible for allocating money for a single parent, multiple parents or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_ALLOC_ALLOWANCE_SNGL_1 is 'Multi-purpose column used to record the allocated amount allowed for a single parent, multiple parents or mutual/multiple allocation types' ;

comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_MUTUAL_1 is 'Multi-purpose column used to record one of the AU member responsible for allocating money out of the assistance unit for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_MUTUAL_2 is 'Multi-purpose column used to record the other AU member responsible for allocating money out of the assistance unit for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_SPOUSE_ALLOC_MUTUAL is 'Multi-purpose column used to record the number of ineligible spouse(s) for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_CHILD_ALLOC_MUTUAL is 'Multi-purpose column used to record the number of ineligible children(en) for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_STD_OF_NEED_ALLOC_MUTUAL is 'Multi-purpose column used to record the Standard of Need for the # of persons to whom AU member''s income can be allocated for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_ALLOC_MUTUAL is 'Multi-purpose column used to record the Gross Income of the AU member(s) responsible for allocating money for a mutual parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_ALLOC_ALLOWANCE_MUTUAL is 'Multi-purpose column used to record the allocated amount allowed for a mutual parents, mutual/single or mutual/multiple allocation types' ;

comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_ALLOC_SNGL_2 is 'Multi-purpose column used to record the AU member responsible for allocating money out of the assistance unit for a multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_SPOUSE_ALLOC_SNGL_2 is 'Multi-purpose column used to record the number of ineligible spouse(s) for a multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_INELIG_CHILD_ALLOC_SNGL_2 is 'Multi-purpose column used to record the number of ineligible children(en) for a multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_STD_OF_NEED_ALLOC_SNGL_2 is 'Multi-purpose column used to record the Standard of Need for the # of persons to whom AU member''s income can be allocated for multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_ALLOC_SNGL_2 is 'Multi-purpose column used to record the Gross Income of the AU member responsible for allocating money for multiple parents, mutual/single or mutual/multiple allocation types' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_ALLOC_ALLOWANCE_SNGL_2 is 'Multi-purpose column used to record the allocated amount allowed for multiple parents, mutual/single or mutual/multiple allocation types' ;


--Per MR-053 Eligibility: Income and Expenditures and Worksheet add Deeming columns
alter table CAPS.FCE_ELIGIBILITY add IND_DEEM_RESP_TYPE VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add CD_DEEM_INDIV_REL_1 VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_DEEM_INDIV_1 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add CD_DEEM_INDIV_REL_2 VARCHAR2(3) null;	
alter table CAPS.FCE_ELIGIBILITY add ID_PERSON_DEEM_INDIV_2 NUMBER(16,0) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_CHILD_NOT_IN_AU NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_TAX_DEPEND_NOT_IN_AU NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_RESPONSE_INDIV NUMBER(1) null;
alter table CAPS.FCE_ELIGIBILITY add NBR_DEEM_PERSON_SON_LOOKUP NUMBER(2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_TAX_DEPEND_OUT_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_ALIMONY_OUTSIDE_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_GROSS_EARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_NET_EARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_UNEARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_CNT_NET_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_STD_OF_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_LESS_STD_OF_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_LESS_TAX_DEP_OUT_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_LESS_ALIM_CSUP_OUT_HH NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_SURPLUS_OR_DEFICIT NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_DEEM_TOTAL NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add CD_DEEM_SURPLUS_OR_DEFICIT VARCHAR2(3) null;

comment on column CAPS.FCE_ELIGIBILITY.IND_DEEM_RESP_TYPE is 'Indicates the Deeming type' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_DEEM_INDIV_1 is 'Records the first member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_DEEM_INDIV_REL_1 is 'The ''Deeming'' relationship of the first member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.ID_PERSON_DEEM_INDIV_2 is 'Records the second member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_DEEM_INDIV_REL_2 is 'The ''Deeming'' relationship of the second member of the household who is responsible for deeming money into the assistance unit' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_CHILD_NOT_IN_AU is 'The number of Responsible Individual''s children who live in the home but are not included in the AU' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_TAX_DEPEND_NOT_IN_AU is 'The number of other dependents in the home who are claimed or could be claimed as tax dependents and are not included in the AU' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_RESPONSE_INDIV is 'The number of Responsible Individuals that are deeming' ;
comment on column CAPS.FCE_ELIGIBILITY.NBR_DEEM_PERSON_SON_LOOKUP is 'The total number of dependents and responsible individuals used to do a Standard of Need lookup in the Deeming budget' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_TAX_DEPEND_OUT_HH is 'The Amount paid to dependents outside the household who are claimed or could be claimed as tax dependents' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_ALIMONY_OUTSIDE_HH is 'Alimony and/or child support paid to person(s) outside of the household' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_GROSS_EARNED_INCOME is 'The Deeming Responsible Individual(s) Gross Earned Income' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_NET_EARNED_INCOME is 'The Deeming Responsible Individual(s) Gross Earned Income less the Standard Earned Income Deduction given to the individual(s)' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_UNEARNED_INCOME is 'The Deeming Responsible Individual(s) Gross Unearned Income' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_CNT_NET_INCOME is 'The Deeming Responsible Individual(s) Net Earned Income plus their Gross Unearned Income' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_STD_OF_NEED is 'The Standard of Need lookup for the total number of dependents and Responsible Individual(s)' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_LESS_STD_OF_NEED is 'The Total Countable Net Income of the Respondible Individuals less the Standard of Need lookup for the total number of dependents and Responsible Individual(s)' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_LESS_TAX_DEP_OUT_HH is 'The Total Countable Net Income less SON Lookup less the amount paid to dependents outside the household who are claimed or could be claimed as tax dependents' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_LESS_ALIM_CSUP_OUT_HH is 'The Total Countable Net Income less SON Lookup less the amount paid to tax dependents less alimony and/or child support paid outside of the household' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_SURPLUS_OR_DEFICIT is 'Either the Surplus or Deficit amount in the Deeming budget' ;
comment on column CAPS.FCE_ELIGIBILITY.AMT_DEEM_TOTAL is 'The Total Deemed Amount if a surplus exists';
comment on column CAPS.FCE_ELIGIBILITY.CD_DEEM_SURPLUS_OR_DEFICIT is 'Indicates whether there''s a surplus or deficit in the Deeming budget' ;


--Per MR-053 Eligibility: Worksheet add Resource Test columns
alter table CAPS.FCE_ELIGIBILITY add AMT_NONEXMPT_RSRC_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_RESOURCE_LIMIT_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_RESOURCE_LIMIT_CHILD NUMBER(16,2) null;

comment on column CAPS.FCE_ELIGIBILITY.AMT_NONEXMPT_RSRC_CRTFD_GRP is 'The Total Nonexempt Resources for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_RESOURCE_LIMIT_CRTFD_GRP is 'The Resource limit amount for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_RESOURCE_LIMIT_CHILD is 'The Resource limit amount for the Child';
comment on column CAPS.FCE_ELIGIBILITY.IND_EQUITY is 'Indicates whether the Certified Group has more than $10,000 in accessible resources';
comment on column CAPS.FCE_ELIGIBILITY.IND_CHILD_EQUITY is 'Indicates whether the Child has more than $10,000 in accessible resources';


--Per MR-053 Eligibility: Worksheet add Gross Income Ceiling Test columns
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GROSS_INCOME_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GIC_SURP_DEFCT_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_GIC_SURP_DEFCT_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add CD_GIC_SURP_DEFCT_CRTFD_GRP VARCHAR2(3) null;
alter table CAPS.FCE_ELIGIBILITY add CD_GIC_SURP_DEFCT_CHILD VARCHAR2(3) null;

comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_CRTFD_GRP is 'The Gross Income of the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_CHILD is 'The Gross Income of the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_GIC_SURP_DEFCT_CRTFD_GRP is 'Either the Surplus or Deficit amount in the AFDC Gross Income Ceiling Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_GIC_SURP_DEFCT_CHILD is 'Either the Surplus or Deficit amount in the IV-E Gross Income Ceiling Test';
comment on column CAPS.FCE_ELIGIBILITY.CD_GIC_SURP_DEFCT_CRTFD_GRP is 'Indicates whether there''s a surplus or deficit in the AFDC Gross Income Ceiling Test' ;
comment on column CAPS.FCE_ELIGIBILITY.CD_GIC_SURP_DEFCT_CHILD is 'Indicates whether there''s a surplus or deficit in the IV-E Gross Income Ceiling Test' ;


--Per MR-053 Eligibility: Worksheet add SON Test and Budget columns
alter table CAPS.FCE_PERSON add AMT_GROSS_EARNED_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_STD_EARNED_INCOME_DEDUCT NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME_30 NUMBER(16,2) null;
alter table CAPS.FCE_PERSON add AMT_CNTBL_INCOME_THIRD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CHSUP_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CHSUP_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_DEP_CARE_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_DEP_CARE_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_UNEARNED_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_UNEARNED_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_CHSUP_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_CHSUP_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_DEEMED_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_PLUS_DEEMED_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_ALLOC_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_LESS_ALLOC_ELIG NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_SURP_DEFCT_STD_NEED NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CNT_INCOME_ELIG_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_CNT_INCOME_ELIG_CHILD NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_SURP_DEFCT_ELIG_CRTFD_GRP NUMBER(16,2) null;
alter table CAPS.FCE_ELIGIBILITY add AMT_SURP_DEFCT_ELIG_CHILD NUMBER(16,2) null;

comment on column CAPS.FCE_PERSON.AMT_GROSS_EARNED_INCOME is 'The Gross Income of the person';
comment on column CAPS.FCE_PERSON.AMT_STD_EARNED_INCOME_DEDUCT is 'The Standard Earned Income Deduction given to the person, if they have earned income';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME is 'The Gross Income less the Standard Earned Income Deduction given to the person';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_30 is 'The Countable Income of the person less $30';
comment on column CAPS.FCE_PERSON.AMT_CNTBL_INCOME_THIRD is 'The Countable Income of the person less $30 less 1/3 deduction';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CHSUP_CRTFD_GRP is 'The Child Support amount for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CHSUP_CHILD is 'The Child Support amount for the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_DEP_CARE_STD_NEED is 'Less Child Care amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_DEP_CARE_ELIG is 'Less Child Care amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_UNEARNED_STD_NEED is 'Plus Gross Unearned Income amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_UNEARNED_ELIG is 'Plus Gross Unearned Income amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_CHSUP_CRTFD_GRP is 'Plus Child Support amount for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_CHSUP_CHILD is 'Plus Child Support amount for the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_DEEMED_STD_NEED is 'Plus the Total Deemed  amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_PLUS_DEEMED_ELIG is 'Plus the Total Deemed  amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_ALLOC_STD_NEED is 'Less the Total Allocated amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_LESS_ALLOC_ELIG is 'Less the Total Allocated amount for the Eligibility budget';
comment on column CAPS.FCE_ELIGIBILITY.AMT_SURP_DEFCT_STD_NEED is 'Either the Surplus or Deficit amount for the Standard of Need Test';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CNT_INCOME_ELIG_CRTFD_GRP is 'The Total Countable Income for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_CNT_INCOME_ELIG_CHILD is 'The Total Countable Income for the Child';
comment on column CAPS.FCE_ELIGIBILITY.AMT_SURP_DEFCT_ELIG_CRTFD_GRP is 'Either the Surplus or Deficit amount in the Eligibility budget for the Certified Group';
comment on column CAPS.FCE_ELIGIBILITY.AMT_SURP_DEFCT_ELIG_CHILD is 'Either the Surplus or Deficit amount in the Eligibility budget for the Child';


--Per MR-053 Eligibility: Income and Expenditures add new Messages
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60788, SYSDATE, 'MSG_FCE_AMEND_APP_COMMENTS_REQ', 'It is indicated this is an ''Amended Application''.  Please enter comments detailing the change in circumstance.', 500, 700, 'N');


--Per MR-053 Eligibility: Income and Expenditures add new Codes Tables
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'SGLP', 'Single Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MUTP', 'Mutual Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MULP', 'Multiple Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MSGL', 'Mutual/Single');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CALOCTYP', 'MMUL', 'Mutual/Multiple');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'STP', 'Stepparent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'MCP', 'Minor Caretaker''s Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'ISP', 'Ineligible Spouse');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'IPT', 'Ineligible Parent');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMREL', 'ASP', 'Alien Sponsor');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CSPLSDEF', 'SUR', 'Surplus');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CSPLSDEF', 'DEF', 'Deficit');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (918, 'SacwisRev4', 'Release 4.1 - DBCR 16022');

commit;


