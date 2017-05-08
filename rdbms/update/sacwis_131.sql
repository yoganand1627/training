
-- Sequence Alter SQL

DROP SEQUENCE CAPS.SEQ_RESTRICTED_FUNDS
;

-- Standard Alter Table SQL

ALTER TABLE CAPS.FAMILY_PLAN ADD IND_COPIED_PLAN VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_APPLICATION DROP (IND_AGE_VRFD_DHS)
;
ALTER TABLE CAPS.LEGAL_STATUS ADD IND_LEGAL_STAT_RISK CHAR(1)     NULL
;
ALTER TABLE CAPS.PERSON_DTL ADD DT_LAST_MED DATE     NULL
;

-- Drop Referencing Constraint SQL

ALTER TABLE CAPS.FCE_APPLICATION DROP CONSTRAINT FK_FCE_APPLICATION_4
;
ALTER TABLE CAPS.FCE_EXPENDITURES DROP CONSTRAINT FK_FCE_EXP_FCE_ELG
;
ALTER TABLE CAPS.FCE_INCOME DROP CONSTRAINT FK_FCE_INCOME_3
;
ALTER TABLE CAPS.FCE_PERSON DROP CONSTRAINT FK_FCE_PERSON_2
;
ALTER TABLE CAPS.FCE_REASON_NOT_ELIGIBLE DROP CONSTRAINT FK_FCE_REASON_NOT_ELIGIBLE_1
;
ALTER TABLE CAPS.FCE_REVIEW DROP CONSTRAINT FK_FCE_REVIEW_3
;

-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.FCE_ELIGIBILITY DROP CONSTRAINT FK_FCE_ELIGIBILITY_2
;
ALTER TABLE CAPS.FCE_ELIGIBILITY DROP CONSTRAINT FK_FCE_ELIGIBILITY_3
;
ALTER TABLE CAPS.FCE_ELIGIBILITY DROP CONSTRAINT FK_FCE_ELIGIBILITY_4
;
ALTER TABLE CAPS.FCE_ELIGIBILITY DROP CONSTRAINT FK_FCE_ELIGIBILITY_5
;
ALTER TABLE CAPS.FCE_ELIGIBILITY DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_1
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_2
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_3
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_4
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_5
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_6
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_7
;
DROP INDEX CAPS.IND_FCE_ELIGIBILITY_8
;
ALTER TABLE CAPS.FCE_ELIGIBILITY RENAME TO FCE_ELIGIB_02092007214452000
;
CREATE TABLE CAPS.FCE_ELIGIBILITY
(
    ID_FCE_ELIGIBILITY             NUMBER(16)    NOT NULL,
    ID_FCE_APPLICATION             NUMBER(16)        NULL,
    ID_FCE_REVIEW                  NUMBER(16)        NULL,
    ID_FCE_PERSON                  NUMBER(16)        NULL,
    ID_PERSON                      NUMBER(16)        NULL,
    ID_CASE                        NUMBER(16)    NOT NULL,
    ID_STAGE                       NUMBER(16)    NOT NULL,
    ID_ELIGIBILITY_EVENT           NUMBER(16)        NULL,
    ID_LAST_UPDATE_PERSON          NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE                 DATE          NOT NULL,
    AMT_COUNTABLE_INCOME           NUMBER(16,2)      NULL,
    AMT_GROSS_EARNED_CRTFD_GRP     NUMBER(16,2)      NULL,
    AMT_GROSS_UNEARNED_CRTFD_GRP   NUMBER(16,2)      NULL,
    AMT_INCOME_LIMIT               NUMBER(16,2)      NULL,
    AMT_PWE_INCOME                 NUMBER(10,2)      NULL,
    AMT_STEPPARENT_ALIMONY         NUMBER(10,2)      NULL,
    AMT_STEPPARENT_ALLOWANCE       NUMBER(16,2)      NULL,
    AMT_STEPPARENT_APPLIED_INCOME  NUMBER(16,2)      NULL,
    AMT_STEPPARENT_CNTBL_UNEARNED  NUMBER(16,2)      NULL,
    AMT_STEPPARENT_GROSS_EARNED    NUMBER(16,2)      NULL,
    AMT_STEPPARENT_OUTSIDE_PMNT    NUMBER(16,2)      NULL,
    AMT_STEPPARENT_TOTAL_CNTBL     NUMBER(16,2)      NULL,
    AMT_STEPPARENT_WORK_DEDUCT     NUMBER(16,2)      NULL,
    AMT_SSI                        NUMBER(16,2)      NULL,
    IND_ABSENT_MOTHER              VARCHAR2(1)       NULL,
    IND_ABSENT_FATHER              VARCHAR2(1)       NULL,
    CD_ELIGIBILITY_ACTUAL          VARCHAR2(3)       NULL,
    CD_ELIGIBILITY_SELECTED        VARCHAR2(3)       NULL,
    CD_MEDICAID_ELIGIBILITY_TYPE   VARCHAR2(1)       NULL,
    CD_PERSON_CITIZENSHIP          VARCHAR2(3)       NULL,
    CD_BLOC_CHILD                  VARCHAR2(3)       NULL,
    IND_MOTHER_PWE                 VARCHAR2(1)       NULL,
    IND_FATHER_PWE                 VARCHAR2(1)       NULL,
    DT_ELIGIBILITY_END             DATE              NULL,
    DT_REMOVAL_CHILD_ORDERED       DATE              NULL,
    DT_REVIEW_DATE                 DATE              NULL,
    DT_RSNBL_EFFORT_PREVENT_REM    DATE              NULL,
    DT_ELIG_DTRMNTN_START          DATE              NULL,
    IND_ABSENT_ALTRNT_CUSTODY      VARCHAR2(1)       NULL,
    IND_ABSENT_DEPORTED            VARCHAR2(1)       NULL,
    IND_ABSENT_DESERTED            VARCHAR2(1)       NULL,
    IND_ABSENT_DIED                VARCHAR2(1)       NULL,
    IND_ABSENT_DIVORCED            VARCHAR2(1)       NULL,
    IND_ABSENT_HOSPITALIZED        VARCHAR2(1)       NULL,
    IND_ABSENT_INCARCERATED        VARCHAR2(1)       NULL,
    IND_ABSENT_MILITARY_WORK       VARCHAR2(1)       NULL,
    IND_ABSENT_SEPARATED           VARCHAR2(1)       NULL,
    IND_ABSENT_WORK_RELATED        VARCHAR2(1)       NULL,
    IND_CHILD_LIVING_PRNT_6_MNTHS  VARCHAR2(1)       NULL,
    IND_MEETS_DP_OR_NOT_ES         VARCHAR2(1)       NULL,
    IND_MEETS_DP_OR_NOT_SYSTEM     VARCHAR2(1)       NULL,
    IND_CHILD_QUALIFIED_CITIZEN    VARCHAR2(1)       NULL,
    IND_CHILD_SUPPORT_ORDERED      VARCHAR2(1)       NULL,
    IND_CHILD_UNDER_18             VARCHAR2(1)       NULL,
    IND_CTZNSHP_ATTORNEY_REVIEW    VARCHAR2(1)       NULL,
    IND_CTZNSHP_BAPTISMAL_CRTFCT   VARCHAR2(1)       NULL,
    IND_CTZNSHP_BIRTH_CRTFCT_FOR   VARCHAR2(1)       NULL,
    IND_CTZNSHP_BIRTH_CRTFCT_US    VARCHAR2(1)       NULL,
    IND_CTZNSHP_CHLD_FOUND         VARCHAR2(1)       NULL,
    IND_CTZNSHP_CITIZEN_CRTFCT     VARCHAR2(1)       NULL,
    IND_CTZNSHP_EVALUATION         VARCHAR2(1)       NULL,
    IND_CTZNSHP_FOR_DOCUMENTATION  VARCHAR2(1)       NULL,
    IND_CTZNSHP_HOSPITAL_CRTFCT    VARCHAR2(1)       NULL,
    IND_CTZNSHP_NO_DOCUMENTATION   VARCHAR2(1)       NULL,
    IND_CTZNSHP_NTRLZTN_CRTFCT     VARCHAR2(1)       NULL,
    IND_CTZNSHP_PASSPORT           VARCHAR2(1)       NULL,
    IND_CTZNSHP_RESIDENT_CARD      VARCHAR2(1)       NULL,
    IND_ELIGIBILITY_COURT_MONTH    VARCHAR2(1)       NULL,
    IND_ELIGIBLE                   VARCHAR2(1)       NULL,
    IND_EQUITY                     VARCHAR2(1)       NULL,
    IND_HOME_INCOME_AFDC_ELGBLTY   VARCHAR2(1)       NULL,
    IND_OTHER_VERIFICATION         VARCHAR2(1)       NULL,
    IND_PARENTAL_DEPRIVATION       VARCHAR2(1)       NULL,
    IND_PARENT_DISABLED            VARCHAR2(1)       NULL,
    IND_PRS_MANAGING_CVS           VARCHAR2(1)       NULL,
    IND_NARRATIVE_APPROVED         VARCHAR2(1)       NULL,
    CD_PWE_IRREGULAR_UNDER_100     VARCHAR2(1)       NULL,
    IND_REMOVAL_CHILD_ORDERED      VARCHAR2(1)       NULL,
    IND_RSNBL_EFFORT_PRVT_REMOVAL  VARCHAR2(1)       NULL,
    CD_PWE_STEADY_UNDER_100        VARCHAR2(1)       NULL,
    IND_RSDI_VERIFICATION          VARCHAR2(1)       NULL,
    IND_SSI_VERIFICATION           VARCHAR2(1)       NULL,
    NBR_CERTIFIED_GROUP            NUMBER(3)         NULL,
    NBR_PARENTS_HOME               NUMBER(1)         NULL,
    TXT_DETERMINATION_COMMENTS     VARCHAR2(300)     NULL,
    NBR_STEPPARENT_CHILDREN        NUMBER(2)         NULL,
    IND_ABSENT_NEVER_COHABITATED   VARCHAR2(1)       NULL,
    CD_FCE_ELIG_REASON             VARCHAR2(3)       NULL,
    IND_CTZNSHP_US_ID_CARD         VARCHAR2(1)       NULL,
    IND_CTZNSHP_BIRTH_ABROAD       VARCHAR2(1)       NULL,
    IND_CTZNSHP_CONFIRM_BIRTH      VARCHAR2(1)       NULL,
    IND_CTZNSHP_REFUGEE            VARCHAR2(1)       NULL,
    IND_CTZNSHP_STUDENT_VISA       VARCHAR2(1)       NULL,
    IND_CTZNSHP_SAVE_SYSTEM        VARCHAR2(1)       NULL,
    IND_COST_CARE_EXCEED_AMT       VARCHAR2(1)       NULL,
    IND_COST_CARE_OUT_OF_HOME      VARCHAR2(1)       NULL,
    IND_COST_CARE_EMANCIPATION     VARCHAR2(1)       NULL,
    IND_COST_CARE_ADOPTED          VARCHAR2(1)       NULL,
    IND_OTHER_EXPENDITURES         VARCHAR2(1)       NULL,
    IND_CRT_ORDR_BEST_INTRST       VARCHAR2(1)       NULL,
    IND_CRT_ORDR_REUNIFY           VARCHAR2(1)       NULL,
    DT_DEPRIVATION_CHANGED         DATE              NULL,
    TXT_MONTHS_DEPRIVATION         VARCHAR2(50)      NULL,
    TXT_MONTHS_DEP_DISABLED        VARCHAR2(100)     NULL,
    TXT_MONTHS_DEP_UNDER_EMPL      VARCHAR2(100)     NULL,
    TXT_MONTHS_DEP_UNEMP           VARCHAR2(100)     NULL,
    IND_ABSENT_TPR_VOL_RELINQ      VARCHAR2(1)       NULL,
    IND_CTZNSHP_SUCCESS_SYSTEM     VARCHAR2(1)       NULL,
    IND_CTZNSHP_AMER_INDIAN_CRD    VARCHAR2(1)       NULL,
    IND_CTZNSHP_CIVIL_SERVICE_EMP  VARCHAR2(1)       NULL,
    IND_CTZNSHP_NORTH_MARIANA_ID   VARCHAR2(1)       NULL,
    IND_CTZNSHP_FINAL_ADOPT_DECREE VARCHAR2(1)       NULL,
    IND_CTZNSHP_VITAL_BIRTH_RCRD   VARCHAR2(1)       NULL,
    IND_CTZNSHP_MILTRY_BIRTH_RCRD  VARCHAR2(1)       NULL,
    IND_CTZNSHP_US_HSPTL_BRTH_RCRD VARCHAR2(1)       NULL,
    IND_CTZNSHP_LIFE_INS_BRTH_RCRD VARCHAR2(1)       NULL,
    IND_CTZNSHP_CENSUS_BIRTH_RCRD  VARCHAR2(1)       NULL,
    IND_CTZNSHP_MED_BIRTH_RCRD     VARCHAR2(1)       NULL,
    IND_CTZNSHP_RELIG_BIRTH_RCRD   VARCHAR2(1)       NULL,
    IND_CTZNSHP_LOCL_GOV_BRTH_RCRD VARCHAR2(1)       NULL,
    IND_CTZNSHP_LEGL_IMMI_STAT_EXP VARCHAR2(1)       NULL,
    IND_CTZNSHP_UNACC_MINOR_CHILD  VARCHAR2(1)       NULL,
    IND_CTZNSHP_UNDOC_IMMIGRANT    VARCHAR2(1)       NULL
)
TABLESPACE DATA01
NOLOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
GRANT DELETE ON CAPS.FCE_ELIGIBILITY TO CAPSBAT
;
GRANT INSERT ON CAPS.FCE_ELIGIBILITY TO CAPSBAT
;
GRANT SELECT ON CAPS.FCE_ELIGIBILITY TO CAPSBAT
;
GRANT UPDATE ON CAPS.FCE_ELIGIBILITY TO CAPSBAT
;
GRANT DELETE ON CAPS.FCE_ELIGIBILITY TO CAPSON
;
GRANT INSERT ON CAPS.FCE_ELIGIBILITY TO CAPSON
;
GRANT SELECT ON CAPS.FCE_ELIGIBILITY TO CAPSON
;
GRANT UPDATE ON CAPS.FCE_ELIGIBILITY TO CAPSON
;
GRANT SELECT ON CAPS.FCE_ELIGIBILITY TO OPERATOR
;
ALTER TABLE CAPS.RESTRICTED_FUNDS DROP CONSTRAINT FK_RESTR_FUNDS_PERSON
;
ALTER TABLE CAPS.RESTRICTED_FUNDS DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.RESTRICTED_FUNDS RENAME TO RESTRICTED_02092007214453000
;
CREATE TABLE CAPS.RESTRICTED_FUNDS
(
    ID_PERSON      NUMBER(16)   NOT NULL,
    DT_LAST_UPDATE DATE         NOT NULL,
    AMT_CHECK_BAL  NUMBER(13,2)     NULL,
    AMT_SAV_BAL    NUMBER(13,2)     NULL,
    AMT_RES        NUMBER(13,2)     NULL,
    TXT_RES        VARCHAR2(50)     NULL,
    ID_EVENT       NUMBER(16)       NULL
)
TABLESPACE DATA01
NOLOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.RESTRICTED_FUNDS IS
'Holds Data from the Restricted Funds Data'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.RESTRICTED_FUNDS TO CAPSBAT
;
GRANT INSERT ON CAPS.RESTRICTED_FUNDS TO CAPSBAT
;
GRANT SELECT ON CAPS.RESTRICTED_FUNDS TO CAPSBAT
;
GRANT UPDATE ON CAPS.RESTRICTED_FUNDS TO CAPSBAT
;
GRANT DELETE ON CAPS.RESTRICTED_FUNDS TO CAPSON
;
GRANT INSERT ON CAPS.RESTRICTED_FUNDS TO CAPSON
;
GRANT SELECT ON CAPS.RESTRICTED_FUNDS TO CAPSON
;
GRANT UPDATE ON CAPS.RESTRICTED_FUNDS TO CAPSON
;
GRANT SELECT ON CAPS.RESTRICTED_FUNDS TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.FCE_ELIGIBILITY(
                                 ID_FCE_ELIGIBILITY,
                                 ID_FCE_APPLICATION,
                                 ID_FCE_REVIEW,
                                 ID_FCE_PERSON,
                                 ID_PERSON,
                                 ID_CASE,
                                 ID_STAGE,
                                 ID_ELIGIBILITY_EVENT,
                                 ID_LAST_UPDATE_PERSON,
                                 DT_LAST_UPDATE,
                                 AMT_COUNTABLE_INCOME,
                                 AMT_GROSS_EARNED_CRTFD_GRP,
                                 AMT_GROSS_UNEARNED_CRTFD_GRP,
                                 AMT_INCOME_LIMIT,
                                 AMT_PWE_INCOME,
                                 AMT_STEPPARENT_ALIMONY,
                                 AMT_STEPPARENT_ALLOWANCE,
                                 AMT_STEPPARENT_APPLIED_INCOME,
                                 AMT_STEPPARENT_CNTBL_UNEARNED,
                                 AMT_STEPPARENT_GROSS_EARNED,
                                 AMT_STEPPARENT_OUTSIDE_PMNT,
                                 AMT_STEPPARENT_TOTAL_CNTBL,
                                 AMT_STEPPARENT_WORK_DEDUCT,
                                 AMT_SSI,
                                 IND_ABSENT_MOTHER,
                                 IND_ABSENT_FATHER,
                                 CD_ELIGIBILITY_ACTUAL,
                                 CD_ELIGIBILITY_SELECTED,
                                 CD_MEDICAID_ELIGIBILITY_TYPE,
                                 CD_PERSON_CITIZENSHIP,
                                 CD_BLOC_CHILD,
                                 IND_MOTHER_PWE,
                                 IND_FATHER_PWE,
                                 DT_ELIGIBILITY_END,
                                 DT_REMOVAL_CHILD_ORDERED,
                                 DT_REVIEW_DATE,
                                 DT_RSNBL_EFFORT_PREVENT_REM,
                                 DT_ELIG_DTRMNTN_START,
                                 IND_ABSENT_ALTRNT_CUSTODY,
                                 IND_ABSENT_DEPORTED,
                                 IND_ABSENT_DESERTED,
                                 IND_ABSENT_DIED,
                                 IND_ABSENT_DIVORCED,
                                 IND_ABSENT_HOSPITALIZED,
                                 IND_ABSENT_INCARCERATED,
                                 IND_ABSENT_MILITARY_WORK,
                                 IND_ABSENT_SEPARATED,
                                 IND_ABSENT_WORK_RELATED,
                                 IND_CHILD_LIVING_PRNT_6_MNTHS,
                                 IND_MEETS_DP_OR_NOT_ES,
                                 IND_MEETS_DP_OR_NOT_SYSTEM,
                                 IND_CHILD_QUALIFIED_CITIZEN,
                                 IND_CHILD_SUPPORT_ORDERED,
                                 IND_CHILD_UNDER_18,
                                 IND_CTZNSHP_ATTORNEY_REVIEW,
                                 IND_CTZNSHP_BAPTISMAL_CRTFCT,
                                 IND_CTZNSHP_BIRTH_CRTFCT_FOR,
                                 IND_CTZNSHP_BIRTH_CRTFCT_US,
                                 IND_CTZNSHP_CHLD_FOUND,
                                 IND_CTZNSHP_CITIZEN_CRTFCT,
                                 IND_CTZNSHP_EVALUATION,
                                 IND_CTZNSHP_FOR_DOCUMENTATION,
                                 IND_CTZNSHP_HOSPITAL_CRTFCT,
                                 IND_CTZNSHP_NO_DOCUMENTATION,
                                 IND_CTZNSHP_NTRLZTN_CRTFCT,
                                 IND_CTZNSHP_PASSPORT,
                                 IND_CTZNSHP_RESIDENT_CARD,
                                 IND_ELIGIBILITY_COURT_MONTH,
                                 IND_ELIGIBLE,
                                 IND_EQUITY,
                                 IND_HOME_INCOME_AFDC_ELGBLTY,
                                 IND_OTHER_VERIFICATION,
                                 IND_PARENTAL_DEPRIVATION,
                                 IND_PARENT_DISABLED,
                                 IND_PRS_MANAGING_CVS,
                                 IND_NARRATIVE_APPROVED,
                                 CD_PWE_IRREGULAR_UNDER_100,
                                 IND_REMOVAL_CHILD_ORDERED,
                                 IND_RSNBL_EFFORT_PRVT_REMOVAL,
                                 CD_PWE_STEADY_UNDER_100,
                                 IND_RSDI_VERIFICATION,
                                 IND_SSI_VERIFICATION,
                                 NBR_CERTIFIED_GROUP,
                                 NBR_PARENTS_HOME,
                                 TXT_DETERMINATION_COMMENTS,
                                 NBR_STEPPARENT_CHILDREN,
                                 IND_ABSENT_NEVER_COHABITATED,
                                 CD_FCE_ELIG_REASON,
                                 IND_CTZNSHP_US_ID_CARD,
                                 IND_CTZNSHP_BIRTH_ABROAD,
                                 IND_CTZNSHP_CONFIRM_BIRTH,
                                 IND_CTZNSHP_REFUGEE,
                                 IND_CTZNSHP_STUDENT_VISA,
                                 IND_CTZNSHP_SAVE_SYSTEM,
                                 IND_COST_CARE_EXCEED_AMT,
                                 IND_COST_CARE_OUT_OF_HOME,
                                 IND_COST_CARE_EMANCIPATION,
                                 IND_COST_CARE_ADOPTED,
                                 IND_OTHER_EXPENDITURES,
                                 IND_CRT_ORDR_BEST_INTRST,
                                 IND_CRT_ORDR_REUNIFY,
                                 DT_DEPRIVATION_CHANGED,
                                 TXT_MONTHS_DEPRIVATION,
                                 TXT_MONTHS_DEP_DISABLED,
                                 TXT_MONTHS_DEP_UNDER_EMPL,
                                 TXT_MONTHS_DEP_UNEMP,
                                 IND_ABSENT_TPR_VOL_RELINQ,
                                 IND_CTZNSHP_SUCCESS_SYSTEM,
                                 IND_CTZNSHP_AMER_INDIAN_CRD,
                                 IND_CTZNSHP_CIVIL_SERVICE_EMP,
                                 IND_CTZNSHP_NORTH_MARIANA_ID,
                                 IND_CTZNSHP_FINAL_ADOPT_DECREE,
                                 IND_CTZNSHP_VITAL_BIRTH_RCRD,
                                 IND_CTZNSHP_MILTRY_BIRTH_RCRD,
                                 IND_CTZNSHP_US_HSPTL_BRTH_RCRD,
                                 IND_CTZNSHP_LIFE_INS_BRTH_RCRD,
                                 IND_CTZNSHP_CENSUS_BIRTH_RCRD,
                                 IND_CTZNSHP_MED_BIRTH_RCRD,
                                 IND_CTZNSHP_RELIG_BIRTH_RCRD,
                                 IND_CTZNSHP_LOCL_GOV_BRTH_RCRD,
                                 IND_CTZNSHP_LEGL_IMMI_STAT_EXP,
                                 IND_CTZNSHP_UNACC_MINOR_CHILD,
                                 IND_CTZNSHP_UNDOC_IMMIGRANT
                                )
                          SELECT 
                                 ID_FCE_ELIGIBILITY,
                                 ID_FCE_APPLICATION,
                                 ID_FCE_REVIEW,
                                 ID_FCE_PERSON,
                                 ID_PERSON,
                                 ID_CASE,
                                 ID_STAGE,
                                 ID_ELIGIBILITY_EVENT,
                                 ID_LAST_UPDATE_PERSON,
                                 DT_LAST_UPDATE,
                                 AMT_COUNTABLE_INCOME,
                                 AMT_GROSS_EARNED_CRTFD_GRP,
                                 AMT_GROSS_UNEARNED_CRTFD_GRP,
                                 AMT_INCOME_LIMIT,
                                 AMT_PWE_INCOME,
                                 AMT_STEPPARENT_ALIMONY,
                                 AMT_STEPPARENT_ALLOWANCE,
                                 AMT_STEPPARENT_APPLIED_INCOME,
                                 AMT_STEPPARENT_CNTBL_UNEARNED,
                                 AMT_STEPPARENT_GROSS_EARNED,
                                 AMT_STEPPARENT_OUTSIDE_PMNT,
                                 AMT_STEPPARENT_TOTAL_CNTBL,
                                 AMT_STEPPARENT_WORK_DEDUCT,
                                 AMT_SSI,
                                 IND_ABSENT_MOTHER,
                                 IND_ABSENT_FATHER,
                                 CD_ELIGIBILITY_ACTUAL,
                                 CD_ELIGIBILITY_SELECTED,
                                 CD_MEDICAID_ELIGIBILITY_TYPE,
                                 CD_PERSON_CITIZENSHIP,
                                 CD_BLOC_CHILD,
                                 IND_MOTHER_PWE,
                                 IND_FATHER_PWE,
                                 DT_ELIGIBILITY_END,
                                 DT_REMOVAL_CHILD_ORDERED,
                                 DT_REVIEW_DATE,
                                 DT_RSNBL_EFFORT_PREVENT_REM,
                                 DT_ELIG_DTRMNTN_START,
                                 IND_ABSENT_ALTRNT_CUSTODY,
                                 IND_ABSENT_DEPORTED,
                                 IND_ABSENT_DESERTED,
                                 IND_ABSENT_DIED,
                                 IND_ABSENT_DIVORCED,
                                 IND_ABSENT_HOSPITALIZED,
                                 IND_ABSENT_INCARCERATED,
                                 IND_ABSENT_MILITARY_WORK,
                                 IND_ABSENT_SEPARATED,
                                 IND_ABSENT_WORK_RELATED,
                                 IND_CHILD_LIVING_PRNT_6_MNTHS,
                                 IND_MEETS_DP_OR_NOT_ES,
                                 IND_MEETS_DP_OR_NOT_SYSTEM,
                                 IND_CHILD_QUALIFIED_CITIZEN,
                                 IND_CHILD_SUPPORT_ORDERED,
                                 IND_CHILD_UNDER_18,
                                 IND_CTZNSHP_ATTORNEY_REVIEW,
                                 IND_CTZNSHP_BAPTISMAL_CRTFCT,
                                 IND_CTZNSHP_BIRTH_CRTFCT_FOR,
                                 IND_CTZNSHP_BIRTH_CRTFCT_US,
                                 IND_CTZNSHP_CHLD_FOUND,
                                 IND_CTZNSHP_CITIZEN_CRTFCT,
                                 IND_CTZNSHP_EVALUATION,
                                 IND_CTZNSHP_FOR_DOCUMENTATION,
                                 IND_CTZNSHP_HOSPITAL_CRTFCT,
                                 IND_CTZNSHP_NO_DOCUMENTATION,
                                 IND_CTZNSHP_NTRLZTN_CRTFCT,
                                 IND_CTZNSHP_PASSPORT,
                                 IND_CTZNSHP_RESIDENT_CARD,
                                 IND_ELIGIBILITY_COURT_MONTH,
                                 IND_ELIGIBLE,
                                 IND_EQUITY,
                                 IND_HOME_INCOME_AFDC_ELGBLTY,
                                 IND_OTHER_VERIFICATION,
                                 IND_PARENTAL_DEPRIVATION,
                                 IND_PARENT_DISABLED,
                                 IND_PRS_MANAGING_CVS,
                                 IND_NARRATIVE_APPROVED,
                                 CD_PWE_IRREGULAR_UNDER_100,
                                 IND_REMOVAL_CHILD_ORDERED,
                                 IND_RSNBL_EFFORT_PRVT_REMOVAL,
                                 CD_PWE_STEADY_UNDER_100,
                                 IND_RSDI_VERIFICATION,
                                 IND_SSI_VERIFICATION,
                                 NBR_CERTIFIED_GROUP,
                                 NBR_PARENTS_HOME,
                                 TXT_DETERMINATION_COMMENTS,
                                 NBR_STEPPARENT_CHILDREN,
                                 IND_ABSENT_NEVER_COHABITATED,
                                 CD_FCE_ELIG_REASON,
                                 IND_CTZNSHP_US_ID_CARD,
                                 IND_CTZNSHP_BIRTH_ABROAD,
                                 IND_CTZNSHP_CONFIRM_BIRTH,
                                 IND_CTZNSHP_REFUGEE,
                                 IND_CTZNSHP_STUDENT_VISA,
                                 IND_CTZNSHP_SAVE_SYSTEM,
                                 IND_COST_CARE_EXCEED_AMT,
                                 IND_COST_CARE_OUT_OF_HOME,
                                 IND_COST_CARE_EMANCIPATION,
                                 IND_COST_CARE_ADOPTED,
                                 IND_OTHER_EXPENDITURES,
                                 IND_CRT_ORDR_BEST_INTRST,
                                 IND_CRT_ORDR_REUNIFY,
                                 DT_DEPRIVATION_CHANGED,
                                 TXT_MONTHS_DEPRIVATION,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 IND_CTZN_LGL_IMMG_STS_EXP,
                                 IND_CTZN_UNCMPND_MINOR,
                                 IND_CTZN_UNDOC_IMMIGRANT,
                                 IND_CTZNSHP_SUCCESS,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL,
                                 NULL
                            FROM CAPS.FCE_ELIGIB_02092007214452000 
;
COMMIT
;
ALTER TABLE CAPS.FCE_ELIGIBILITY LOGGING
;
ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.RESTRICTED_FUNDS(
                                  ID_PERSON,
                                  DT_LAST_UPDATE,
                                  AMT_CHECK_BAL,
                                  AMT_SAV_BAL,
                                  AMT_RES,
                                  TXT_RES,
                                  ID_EVENT
                                 )
                           SELECT 
                                  ID_PERSON,
                                  DT_LAST_UPDATE,
                                  AMT_CHECK_BAL,
                                  AMT_SAV_BAL,
                                  AMT_RES,
                                  TXT_RES,
                                  NULL
                             FROM CAPS.RESTRICTED_02092007214453000 
;
COMMIT
;
ALTER TABLE CAPS.RESTRICTED_FUNDS LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.FCE_ELIGIBILITY ADD CONSTRAINT PK_FCE_ELIGIBILITY
PRIMARY KEY (ID_FCE_ELIGIBILITY)
USING INDEX TABLESPACE INDEX01
            PCTFREE 10
            INITRANS 2
            MAXTRANS 255
            STORAGE(INITIAL 1M
                    NEXT 1M
                    MINEXTENTS 1
                    MAXEXTENTS UNLIMITED
                    PCTINCREASE 0
                    BUFFER_POOL DEFAULT)
    LOGGING
    ENABLE
    VALIDATE
;
ALTER TABLE CAPS.RESTRICTED_FUNDS ADD CONSTRAINT PK_RESTRICTED_FUNDS
PRIMARY KEY (ID_PERSON)
USING INDEX TABLESPACE INDEX01
            PCTFREE 10
            INITRANS 2
            MAXTRANS 255
            STORAGE(INITIAL 1M
                    NEXT 1M
                    MINEXTENTS 1
                    MAXEXTENTS UNLIMITED
                    PCTINCREASE 0
                    BUFFER_POOL DEFAULT)
    LOGGING
    ENABLE
    VALIDATE
;

-- Add Indexes SQL

CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_1
    ON CAPS.FCE_ELIGIBILITY(ID_FCE_APPLICATION)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_2
    ON CAPS.FCE_ELIGIBILITY(ID_FCE_REVIEW)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_3
    ON CAPS.FCE_ELIGIBILITY(ID_CASE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_4
    ON CAPS.FCE_ELIGIBILITY(ID_ELIGIBILITY_EVENT)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_5
    ON CAPS.FCE_ELIGIBILITY(ID_LAST_UPDATE_PERSON)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_6
    ON CAPS.FCE_ELIGIBILITY(ID_FCE_PERSON)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_7
    ON CAPS.FCE_ELIGIBILITY(ID_STAGE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_ELIGIBILITY_8
    ON CAPS.FCE_ELIGIBILITY(ID_PERSON)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Dependencies SQL
/
DROP TRIGGER CAPS.TIBR_FCE_ELIGIBILITY
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_FCE_ELIGIBILITY
BEFORE INSERT
ON CAPS.FCE_ELIGIBILITY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
dummy number;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;

	IF (:new.ID_FCE_ELIGIBILITY is null or :new.ID_FCE_ELIGIBILITY=0) then
	    SELECT seq_FCE_ELIGIBILITY.nextval INTO dummy FROM dual;
	    :new.ID_FCE_ELIGIBILITY := dummy;
	END IF;

END;
/
/
DROP TRIGGER CAPS.TUBR_FCE_ELIGIBILITY
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_FCE_ELIGIBILITY
BEFORE UPDATE
ON CAPS.FCE_ELIGIBILITY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
DROP TRIGGER CAPS.TIBR_RESTRICTED_FUNDS
/
/
DROP TRIGGER CAPS.TUBR_RESTRICTED_FUNDS
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_RESTRICTED_FUNDS
BEFORE UPDATE
ON CAPS.RESTRICTED_FUNDS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.FCE_APPLICATION ADD CONSTRAINT FK_FCE_APPLICATION_4
FOREIGN KEY (ID_FCE_ELIGIBILITY)
REFERENCES CAPS.FCE_ELIGIBILITY (ID_FCE_ELIGIBILITY)
ENABLE
;
ALTER TABLE CAPS.FCE_EXPENDITURES ADD CONSTRAINT FK_FCE_EXP_FCE_ELG
FOREIGN KEY (ID_FCE_ELIGIBILITY)
REFERENCES CAPS.FCE_ELIGIBILITY (ID_FCE_ELIGIBILITY)
ENABLE
;
ALTER TABLE CAPS.FCE_INCOME ADD CONSTRAINT FK_FCE_INCOME_3
FOREIGN KEY (ID_FCE_ELIGIBILITY)
REFERENCES CAPS.FCE_ELIGIBILITY (ID_FCE_ELIGIBILITY)
ENABLE
;
ALTER TABLE CAPS.FCE_PERSON ADD CONSTRAINT FK_FCE_PERSON_2
FOREIGN KEY (ID_FCE_ELIGIBILITY)
REFERENCES CAPS.FCE_ELIGIBILITY (ID_FCE_ELIGIBILITY)
ENABLE
;
ALTER TABLE CAPS.FCE_REASON_NOT_ELIGIBLE ADD CONSTRAINT FK_FCE_REASON_NOT_ELIGIBLE_1
FOREIGN KEY (ID_FCE_ELIGIBILITY)
REFERENCES CAPS.FCE_ELIGIBILITY (ID_FCE_ELIGIBILITY)
ENABLE
;
ALTER TABLE CAPS.FCE_REVIEW ADD CONSTRAINT FK_FCE_REVIEW_3
FOREIGN KEY (ID_FCE_ELIGIBILITY)
REFERENCES CAPS.FCE_ELIGIBILITY (ID_FCE_ELIGIBILITY)
ENABLE
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD CONSTRAINT FK_FCE_ELIGIBILITY_2
FOREIGN KEY (ID_CASE)
REFERENCES CAPS.CAPS_CASE (ID_CASE)
ENABLE
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD CONSTRAINT FK_FCE_ELIGIBILITY_3
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD CONSTRAINT FK_FCE_ELIGIBILITY_4
FOREIGN KEY (ID_FCE_PERSON)
REFERENCES CAPS.FCE_PERSON (ID_FCE_PERSON)
ENABLE
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD CONSTRAINT FK_FCE_ELIGIBILITY_5
FOREIGN KEY (ID_STAGE)
REFERENCES CAPS.STAGE (ID_STAGE)
ENABLE
;
ALTER TABLE CAPS.RESTRICTED_FUNDS ADD CONSTRAINT FK_RESTR_FUNDS_PERSON
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.RESTRICTED_FUNDS ADD CONSTRAINT FK_RESTR_FUNDS_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_RESTRICTED_FUNDS
BEFORE INSERT
ON CAPS.RESTRICTED_FUNDS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001546
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60155, 'MSG_SPEC_EDU_EXPL_REQ' 
,'Provide comments on why the child needs/previously received special educational services.',500,700,'N'); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60156, 'MSG_EARLY_INV_SERV_EXPL_REQ' 
,'Provide comments on why the child is receiving/previously received early intervention services.',500,700,'N');

-- change STGAP00001551
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) VALUES('CLEGSTAT','NCE','Not In DFCS Custody-Emancipated');
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) VALUES('CLEGSTAT','NPR','Not In DFCS Custody-Perm Custody To Relative For Adoption'); 

-- change STGAP00001552
INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CEVNTTYP', 'RSF', 'Restricted Funds', SYSDATE);

-- change STGAP00001553
-- new metaphor tab
INSERT INTO CAPS.METAPHOR
(id_tab, txt_tab_url,
txt_tab_constant, txt_tab)
VALUES
(1520, '/financials/RestrictedFunds/display',
'RESTRICTED_FUNDS', 'Restricted Funds');

-- new tasks (normal and approval per stages FPR, SUB, ADO, and FSU)
INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE,
IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
VALUES
('3450', 'RSF', 'SUB', 'Restricted Funds',
'CPS', '1', '1',
'1', '0', '0',
'0', '1', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay', 2, '0',
'0', '0');

INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL)
VALUES
('3460', 'APP', 'SUB', 'Approve Restricted Funds',
'CPS', '0', '1',
'1', '0', '0',
'0', '0', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay');

INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE,
IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
VALUES
('4430', 'RSF', 'FSU', 'Restricted Funds',
'CPS', '1', '1',
'1', '0', '0',
'0', '1', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay', 2, '0',
'0', '0');

INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL)
VALUES
('4440', 'APP', 'FSU', 'Approve Restricted Funds',
'CPS', '0', '1',
'1', '0', '0',
'0', '0', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay');

INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE,
IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
VALUES
('7030', 'RSF', 'FPR', 'Restricted Funds',
'CPS', '1', '1',
'1', '0', '0',
'0', '1', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay', 2, '0',
'0', '0');

INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL)
VALUES
('7040', 'APP', 'FPR', 'Approve Restricted Funds',
'CPS', '0', '1',
'1', '0', '0',
'0', '0', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay');

INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE,
IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
VALUES
('8920', 'RSF', 'ADO', 'Restricted Funds',
'CPS', '1', '1',
'1', '0', '0',
'0', '1', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay', 2, '0',
'0', '0');

INSERT INTO CAPS.TASK
(cd_task, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, TXT_TASK_DECODE,
CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_1ST_TAB,
TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL)
VALUES
('8930', 'APP', 'ADO', 'Approve Restricted Funds',
'CPS', '0', '1',
'1', '0', '0',
'0', '0', 'CASE_CASESEARCH',
'PERSON_PERSONLIST', 'RESTRICTED_FUNDS',
'/financials/RestrictedFunds/taskDisplay');

-- change STGAP00001559
UPDATE CAPS.CODES_TABLES
SET DECODE = 'frd01o00'
WHERE CODE_TYPE = 'CEVNTDOC'
AND CODE = 'RVF'
AND DT_END IS NULL;

-- change STGAP00001560
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CEDTYPE','NIS','Not In School',sysdate);

-- change STGAP00001561
INSERT INTO CAPS.MESSAGE (TXT_MESSAGE_NAME, NBR_MESSAGE, TXT_MESSAGE)
VALUES ('MSG_STAGE_OPEN', '60157','A Closure Reason of %s has been selected, but no %s Stage is open on this case.');

-- change STGAP00001569
-- New metaphor tab
INSERT INTO CAPS.METAPHOR
(id_tab, txt_tab_url,
txt_tab_constant, txt_tab)
VALUES
(1540, '/financials/TCMClaimsSearch/displayTCMClaims',
'TCM_CLAIMS_TCMCLAIMS', 'TCM Claims');

-- change STGAP00001577
UPDATE CAPS.TASK SET txt_task_decode = 'Custody'
WHERE txt_2nd_tab = 'CONSERVATORSHIP_REMOVAL_EVENTLIST';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (132, 'SacwisRev2', 'static updates, change RESTRICTED FUNDS and LEGAL_STATUS and FCE');
commit;


