
-- Standard Alter Table SQL

ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_FAMVIOL_01 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_FAMVIOL_02 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_FAMVIOL_03 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_FAMVIOL_04 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_FAMVIOL_05 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_STATUS VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_TYPE_01 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_TYPE_02 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_TYPE_03 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_TYPE_04 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_TYPE_05 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_TYPE_06 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_ABUSE_TYPE_07 VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD CD_MALTREAT_LOC VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.HOME_APPLICANT_CBX ADD CD_HOME_APLCNT_CBX_TYPE VARCHAR2(20)     NULL
;
ALTER TABLE CAPS.HOME_APPLICANT_INFO ADD INQ_REQ_NBR_CHLDRN NUMBER(3)     NULL
;
ALTER TABLE CAPS.PPT_PARTICIPANT MODIFY(CD_PPT_PART_TITLE  VARCHAR2(20))
;
ALTER TABLE CAPS.RESOURCE_CHRCTR MODIFY(CD_RSRC_CHAR_CHRCTR  VARCHAR2(3))
;

-- Drop Referencing Constraint SQL

ALTER TABLE CAPS.ADOPTION_SUBSIDY DROP CONSTRAINT FK_ADPT_SUBSIDY_PAYEE
;
ALTER TABLE CAPS.ADO_INFO DROP CONSTRAINT FK_ADO_INFO_RESOURCE
;
ALTER TABLE CAPS.ADO_INFO_FAMILY DROP CONSTRAINT FK_ADO_INF_FAM_RESOURCE
;
ALTER TABLE CAPS.ALOC DROP CONSTRAINT FK_ALOC_RESOURCE
;
ALTER TABLE CAPS.CAPS_CARETAKER DROP CONSTRAINT FK_CAPS_CARETAKER_RESOURCE
;
ALTER TABLE CAPS.CONTRACT DROP CONSTRAINT FK_CONTRACT_RESOURCE
;
ALTER TABLE CAPS.CONTRACT_COUNTY DROP CONSTRAINT FK_CONTRACT_COUNTY_2
;
ALTER TABLE CAPS.DELVRD_SVC_DTL DROP CONSTRAINT FK_SVC_DTL_RSRC
;
ALTER TABLE CAPS.EDUCATIONAL_HISTORY DROP CONSTRAINT FK_EDHIST_RESOURCE
;
ALTER TABLE CAPS.FACILITY_INVST_DTL DROP CONSTRAINT FK_FACIL_INVST_AFFIL_RESOURCE
;
ALTER TABLE CAPS.FACILITY_INVST_DTL DROP CONSTRAINT FK_FACIL_INVST_FACIL_RESOURCE
;
ALTER TABLE CAPS.FACILITY_LICENSE_TYPE DROP CONSTRAINT FK_FACIL_LIC_TYPE_RESOURCE
;
ALTER TABLE CAPS.FACILITY_LOC DROP CONSTRAINT FK_FACILITY_LOC
;
ALTER TABLE CAPS.HOME_APPLICANT_INFO DROP CONSTRAINT FK_HOME_APP_INFO_RESOURCE
;
ALTER TABLE CAPS.INCOMING_DETAIL DROP CONSTRAINT FK_INCOMING_RESOURCE
;
ALTER TABLE CAPS.INCOMING_DETAIL DROP CONSTRAINT FK_INC_DET_REF_RSC
;
ALTER TABLE CAPS.INCOMING_FACILITY DROP CONSTRAINT FK_INCOMING_FACILITY_RSRC
;
ALTER TABLE CAPS.LAW_ENFORC_ZIP DROP CONSTRAINT FK_LAW_ENFORC_ZIP_RESOURCE
;
ALTER TABLE CAPS.NEEDS_OUTCOMES DROP CONSTRAINT FK_NEEDS_OUTS_RESOURCE
;
ALTER TABLE CAPS.PLACEMENT DROP CONSTRAINT FK_PLCMT_AGENCY
;
ALTER TABLE CAPS.PLACEMENT DROP CONSTRAINT FK_PLCMT_FACIL
;
ALTER TABLE CAPS.PLACEMENT_REFERRAL DROP CONSTRAINT FK_PLACE_REF_RESOURCE
;
ALTER TABLE CAPS.POLICY_WAIVER DROP CONSTRAINT FK_WVR_RSRC
;
ALTER TABLE CAPS.PPA_DELVRD_SVC DROP CONSTRAINT FK_PPA_SVC_RESOURCE
;
ALTER TABLE CAPS.PPA_REPORT DROP CONSTRAINT FK_PPA_REPORT_RSRC
;
ALTER TABLE CAPS.REFERRAL_HOME_LINK DROP CONSTRAINT FK_REFERRAL_HOME_LINK_R
;
ALTER TABLE CAPS.RESOURCE_ADDRESS DROP CONSTRAINT FK_RESOURCE_ADDRESS
;
ALTER TABLE CAPS.RESOURCE_CHRCTR DROP CONSTRAINT FK_RESOURCE_CHRCTR_RSRC
;
ALTER TABLE CAPS.RESOURCE_PHONE DROP CONSTRAINT FK_RESOURCE_PHONE
;
ALTER TABLE CAPS.RESOURCE_SERVICE DROP CONSTRAINT FK_RESOURCE_SERVICE_RESOURCE
;
ALTER TABLE CAPS.RSRC_LINK DROP CONSTRAINT FK_RSRC_LINK_CHILD
;
ALTER TABLE CAPS.RSRC_LINK DROP CONSTRAINT FK_RSRC_LINK_PARENT
;
ALTER TABLE CAPS.SERVICE_AUTHORIZATION DROP CONSTRAINT FK_SVC_AUTH_PROVIDER
;
ALTER TABLE CAPS.SPEC_SVCS DROP CONSTRAINT FK_SPEC_SVCS_RSRC
;

-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.CAPS_RESOURCE DROP CONSTRAINT FK_CAPS_RESOURCE_EVENT
;
ALTER TABLE CAPS.CAPS_RESOURCE DROP CONSTRAINT FK_CAPS_RESOURCE_STAGE
;
ALTER TABLE CAPS.CAPS_RESOURCE DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_CAPS_RESOURCE_1
;
DROP INDEX CAPS.IND_CAPS_RESOURCE_2
;
DROP INDEX CAPS.IND_CAPS_RESOURCE_3
;
DROP INDEX CAPS.IND_CAPS_RESOURCE_4
;
DROP INDEX CAPS.IND_CAPS_RESOURCE_5
;
DROP INDEX CAPS.IND_CAPS_RESOURCE_6
;
DROP INDEX CAPS.IND_REC_RTN_10
;
DROP INDEX CAPS.IND_CAPS_RESOURCE_7
;
ALTER TABLE CAPS.CAPS_RESOURCE RENAME TO CAPS_RESOU_12152006160905000
;
CREATE TABLE CAPS.CAPS_RESOURCE
(
    ID_RESOURCE             NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE          DATE          NOT NULL,
    ID_CASE                 NUMBER(16)        NULL,
    ADDR_RSRC_ST_LN_1       VARCHAR2(30)      NULL,
    ADDR_RSRC_ST_LN_2       VARCHAR2(30)      NULL,
    ADDR_RSRC_CITY          VARCHAR2(20)      NULL,
    CD_RSRC_STATE           VARCHAR2(2)       NULL,
    ADDR_RSRC_ZIP           VARCHAR2(10)      NULL,
    ADDR_RSRC_ATTN          VARCHAR2(30)      NULL,
    CD_RSRC_CNTY            VARCHAR2(3)       NULL,
    CD_RSRC_INVOL_CLOSURE   VARCHAR2(1)       NULL,
    CD_RSRC_CLOSURE_RSN     VARCHAR2(3)       NULL,
    CD_RSRC_SOURCE_INQUIRY  VARCHAR2(3)       NULL,
    CD_RSRC_TYPE            VARCHAR2(2)       NULL,
    CD_RSRC_CAMPUS_TYPE     VARCHAR2(1)       NULL,
    CD_RSRC_MAINTAINER      VARCHAR2(2)       NULL,
    CD_RSRC_SCH_DIST        VARCHAR2(6)       NULL,
    CD_RSRC_OWNERSHIP       VARCHAR2(2)       NULL,
    CD_RSRC_FACIL_TYPE      VARCHAR2(2)       NULL,
    CD_RSRC_HUB             VARCHAR2(2)       NULL,
    CD_RSRC_CERT_BY         VARCHAR2(2)       NULL,
    CD_RSRC_OPER_BY         VARCHAR2(2)       NULL,
    CD_RSRC_SETTING         VARCHAR2(2)       NULL,
    CD_RSRC_PAYMENT         VARCHAR2(2)       NULL,
    CD_RSRC_CATEGORY        VARCHAR2(1)       NULL,
    CD_RSRC_ETHNICITY       VARCHAR2(2)       NULL,
    CD_RSRC_LANGUAGE        VARCHAR2(2)       NULL,
    CD_RSRC_MARITAL_STATUS  VARCHAR2(2)       NULL,
    CD_RSRC_RECMND_REOPEN   VARCHAR2(3)       NULL,
    CD_RSRC_REGION          VARCHAR2(2)       NULL,
    CD_RSRC_RELIGION        VARCHAR2(2)       NULL,
    CD_RSRC_RESPITE         VARCHAR2(1)       NULL,
    CD_RSRC_FA_HOME_STATUS  VARCHAR2(3)       NULL,
    CD_RSRC_FA_HOME_TYPE_1  CHAR(1)           NULL,
    CD_RSRC_FA_HOME_TYPE_2  CHAR(1)           NULL,
    CD_RSRC_FA_HOME_TYPE_3  CHAR(1)           NULL,
    CD_RSRC_FA_HOME_TYPE_4  CHAR(1)           NULL,
    CD_RSRC_FA_HOME_TYPE_5  CHAR(1)           NULL,
    CD_RSRC_FA_HOME_TYPE_6  CHAR(1)           NULL,
    CD_RSRC_FA_HOME_TYPE_7  CHAR(1)           NULL,
    CD_RSRC_STATUS          VARCHAR2(2)       NULL,
    DT_RSRC_MARRIAGE        DATE              NULL,
    DT_RSRC_CLOSE           DATE              NULL,
    DT_RSRC_CERT            DATE              NULL,
    ID_RSRC_FA_HOME_STAGE   NUMBER(16)        NULL,
    ID_RSRC_FA_HOME_EVENT   NUMBER(16)        NULL,
    IND_RSRC_WRITE_HIST     CHAR(1)           NULL,
    IND_RSRC_CARE_PROV      CHAR(1)           NULL,
    IND_RSRC_EMERG_PLACE    CHAR(1)           NULL,
    IND_RSRC_INACTIVE       CHAR(1)           NULL,
    IND_RSRC_TRANSPORT      CHAR(1)           NULL,
    NM_RSRC_LAST_UPDATE     VARCHAR2(25)      NULL,
    NM_RESOURCE             VARCHAR2(30)      NULL,
    NM_RSRC_NAME_INDEX      VARCHAR2(2)       NULL,
    NM_RSRC_CONTACT         VARCHAR2(25)      NULL,
    NBR_RSRC_PHN            VARCHAR2(10)      NULL,
    NBR_RSRC_PHONE_EXT      VARCHAR2(8)       NULL,
    NBR_RSRC_FACIL_CAPACITY NUMBER(4)         NULL,
    NBR_RSRC_FACIL_ACCLAIM  NUMBER(8)         NULL,
    NBR_RSRC_VID            VARCHAR2(14)      NULL,
    NBR_RSRC_CAMPUS_NBR     NUMBER(8)         NULL,
    NBR_RSRC_INT_CHILDREN   NUMBER(3)         NULL,
    NBR_RSRC_INT_FE_AGE_MAX NUMBER(4)         NULL,
    NBR_RSRC_INT_FE_AGE_MIN NUMBER(4)         NULL,
    NBR_RSRC_INT_MA_AGE_MAX NUMBER(4)         NULL,
    NBR_RSRC_INT_MA_AGE_MIN NUMBER(4)         NULL,
    NBR_RSRC_ANNUAL_INCOME  NUMBER(16)        NULL,
    NBR_RSRC_FM_AGE_MAX     NUMBER(4)         NULL,
    NBR_RSRC_FM_AGE_MIN     NUMBER(4)         NULL,
    NBR_RSRC_MA_AGE_MAX     NUMBER(4)         NULL,
    NBR_RSRC_MA_AGE_MIN     NUMBER(4)         NULL,
    NBR_RSRC_OPEN_SLOTS     NUMBER(2)         NULL,
    TXT_RSRC_ADDR_CMNTS     VARCHAR2(80)      NULL,
    TXT_RSRC_COMMENTS       VARCHAR2(300)     NULL,
    CD_RSRC_MHMR_COMP_CODE  VARCHAR2(4)       NULL,
    DT_CCL_UPDATE           DATE              NULL,
    CD_RSRC_MHMR_SITE       VARCHAR2(4)       NULL,
    IND_RSRC_CONTRACTED     CHAR(1)           NULL,
    NM_LEGAL                VARCHAR2(90)      NULL,
    NM_RSRC_CONTACT_TITLE   VARCHAR2(30)      NULL,
    NBR_RSRC_NTNL_PROVIDER  VARCHAR2(20)      NULL,
    ADDR_RSRC_EMAIL         VARCHAR2(70)      NULL,
    ADDR_RSRC_WEBSITE       VARCHAR2(300)     NULL,
    CD_SCHOOL_TYPE          VARCHAR2(3)       NULL,
    CD_PAYMENT_DELIVERY     VARCHAR2(3)       NULL,
    TXT_SPEC_CERT           VARCHAR2(50)      NULL,
    CD_EXCHANGE_STAT        VARCHAR2(3)       NULL,
    IND_WAIVER              VARCHAR2(1)       NULL,
    CD_SCH_DIST             VARCHAR2(3)       NULL,
    CD_ELEM                 VARCHAR2(4)       NULL,
    CD_MIDDLE               VARCHAR2(4)       NULL,
    CD_HIGH                 VARCHAR2(4)       NULL,
    DT_FOST_MANUAL          DATE              NULL,
    DT_FOST_BILL            DATE              NULL,
    IND_SPECIFIC_CHILD      VARCHAR2(1)       NULL,
    DT_LIC_BEGIN            DATE              NULL,
    DT_LIC_END              DATE              NULL,
    TXT_CLOSURE_COMM        VARCHAR2(300)     NULL,
    NDFCS_CERT_ENTITY       VARCHAR2(30)      NULL,
    IND_RSRC_NONDFCS        VARCHAR2(1)       NULL,
    IND_CURR_HM_STDY_EXSTS  VARCHAR2(1)       NULL,
    IND_PREV_FAM_STDY_RQSTD VARCHAR2(1)       NULL
)
TABLESPACE DATA01
NOLOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 6M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
GRANT DELETE ON CAPS.CAPS_RESOURCE TO CAPSBAT
;
GRANT INSERT ON CAPS.CAPS_RESOURCE TO CAPSBAT
;
GRANT SELECT ON CAPS.CAPS_RESOURCE TO CAPSBAT
;
GRANT UPDATE ON CAPS.CAPS_RESOURCE TO CAPSBAT
;
GRANT DELETE ON CAPS.CAPS_RESOURCE TO CAPSON
;
GRANT INSERT ON CAPS.CAPS_RESOURCE TO CAPSON
;
GRANT SELECT ON CAPS.CAPS_RESOURCE TO CAPSON
;
GRANT UPDATE ON CAPS.CAPS_RESOURCE TO CAPSON
;
ALTER TABLE CAPS.RESOURCE_HISTORY DROP CONSTRAINT FK_RESOURCE_HISTORY_EVENT
;
ALTER TABLE CAPS.RESOURCE_HISTORY DROP CONSTRAINT FK_RESOURCE_HISTORY_STAGE
;
ALTER TABLE CAPS.RESOURCE_HISTORY DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_5
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_1
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_2
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_3
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_4
;
DROP INDEX CAPS.IND_REC_RTN_90
;
ALTER TABLE CAPS.RESOURCE_HISTORY RENAME TO RESOURCE_H_12152006160907000
;
CREATE TABLE CAPS.RESOURCE_HISTORY
(
    ID_RESOURCE_HISTORY     NUMBER(16)    NOT NULL,
    ID_RESOURCE             NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE          DATE          NOT NULL,
    ID_CASE                 NUMBER(16)        NULL,
    DT_RSHS_EFFECTIVE       DATE              NULL,
    DT_RSHS_CLOSE           DATE              NULL,
    DT_RSHS_CERT            DATE              NULL,
    DT_RSHS_MARRIAGE        DATE              NULL,
    DT_RSHS_END             DATE          DEFAULT TO_DATE( '12/31/4712', 'MM/DD/YYYY')     NULL,
    ADDR_RSHS_ST_LN_1       VARCHAR2(30)      NULL,
    ADDR_RSHS_ST_LN_2       VARCHAR2(30)      NULL,
    ADDR_RSHS_CITY          VARCHAR2(20)      NULL,
    CD_RSHS_STATE           VARCHAR2(2)       NULL,
    ADDR_RSHS_ZIP           VARCHAR2(10)      NULL,
    ADDR_RSHS_ATTN          VARCHAR2(30)      NULL,
    CD_RSHS_CNTY            VARCHAR2(3)       NULL,
    CD_RSHS_INVOL_CLOSURE   VARCHAR2(1)       NULL,
    CD_RSHS_CLOSURE_RSN     VARCHAR2(3)       NULL,
    CD_RSHS_TYPE            VARCHAR2(2)       NULL,
    CD_RSHS_HUB             VARCHAR2(2)       NULL,
    CD_RSHS_CAMPUS_TYPE     VARCHAR2(1)       NULL,
    CD_RSHS_SOURCE_INQUIRY  VARCHAR2(3)       NULL,
    CD_RSHS_MAINTAINER      VARCHAR2(2)       NULL,
    CD_RSHS_SCH_DIST        VARCHAR2(6)       NULL,
    CD_RSHS_OWNERSHIP       VARCHAR2(2)       NULL,
    CD_RSHS_STATUS          VARCHAR2(2)       NULL,
    CD_RSHS_FACIL_TYPE      VARCHAR2(2)       NULL,
    CD_RSHS_CERT_BY         VARCHAR2(2)       NULL,
    CD_RSHS_OPER_BY         VARCHAR2(2)       NULL,
    CD_RSHS_SETTING         VARCHAR2(2)       NULL,
    CD_RSHS_PAYMENT         VARCHAR2(2)       NULL,
    CD_RSHS_CATEGORY        VARCHAR2(1)       NULL,
    CD_RSHS_ETHNICITY       VARCHAR2(2)       NULL,
    CD_RSHS_LANGUAGE        VARCHAR2(2)       NULL,
    CD_RSHS_MARITAL_STATUS  VARCHAR2(2)       NULL,
    CD_RSHS_RECMND_REOPEN   VARCHAR2(3)       NULL,
    CD_RSHS_REGION          VARCHAR2(2)       NULL,
    CD_RSHS_RELIGION        VARCHAR2(2)       NULL,
    CD_RSHS_RESPITE         VARCHAR2(1)       NULL,
    CD_RSHS_FA_HOME_STATUS  VARCHAR2(3)       NULL,
    CD_RSHS_FA_HOME_TYPE1   CHAR(1)           NULL,
    CD_RSHS_FA_HOME_TYPE2   CHAR(1)           NULL,
    CD_RSHS_FA_HOME_TYPE3   CHAR(1)           NULL,
    CD_RSHS_FA_HOME_TYPE4   CHAR(1)           NULL,
    CD_RSHS_FA_HOME_TYPE5   CHAR(1)           NULL,
    CD_RSHS_FA_HOME_TYPE6   CHAR(1)           NULL,
    CD_RSHS_FA_HOME_TYPE7   CHAR(1)           NULL,
    ID_RSHS_FA_HOME_STAGE   NUMBER(16)        NULL,
    ID_RSHS_FA_HOME_EVENT   NUMBER(16)        NULL,
    IND_RSHS_CARE_PROV      CHAR(1)           NULL,
    IND_RSHS_INACTIVE       CHAR(1)           NULL,
    IND_RSHS_TRANSPORT      CHAR(1)           NULL,
    IND_RSHS_EMERG_PLACE    CHAR(1)           NULL,
    NM_RSHS_RESOURCE        VARCHAR2(30)      NULL,
    NM_RSHS_CONTACT         VARCHAR2(25)      NULL,
    NM_RSHS_LAST_UPDATE     VARCHAR2(25)      NULL,
    NBR_RSHS_VID            VARCHAR2(14)      NULL,
    NBR_RSHS_PHN            VARCHAR2(10)      NULL,
    NBR_RSHS_FACIL_CAPACITY NUMBER(4)         NULL,
    NBR_RSHS_FACIL_ACCLAIM  NUMBER(8)         NULL,
    NBR_RSHS_PHONE_EXT      VARCHAR2(8)       NULL,
    NBR_RSHS_CAMPUS_NBR     NUMBER(8)         NULL,
    NBR_RSHS_ANNUAL_INCOME  NUMBER(16)        NULL,
    NBR_RSHS_FM_AGE_MAX     NUMBER(4)         NULL,
    NBR_RSHS_FM_AGE_MIN     NUMBER(4)         NULL,
    NBR_RSHS_MA_AGE_MAX     NUMBER(4)         NULL,
    NBR_RSHS_MA_AGE_MIN     NUMBER(4)         NULL,
    NBR_RSHS_INT_CHILDREN   NUMBER(3)         NULL,
    NBR_RSHS_INT_FE_AGE_MAX NUMBER(4)         NULL,
    NBR_RSHS_INT_FE_AGE_MIN NUMBER(4)         NULL,
    NBR_RSHS_INT_MA_AGE_MAX NUMBER(4)         NULL,
    NBR_RSHS_INT_MA_AGE_MIN NUMBER(4)         NULL,
    TXT_RSHS_ADDR_CMNTS     VARCHAR2(80)      NULL,
    TXT_RSHS_COMMENTS       VARCHAR2(300)     NULL,
    NBR_RSHS_OPEN_SLOTS     NUMBER(2)         NULL,
    IND_RSHS_WRITE_AUDIT    CHAR(1)       DEFAULT 'N'     NULL,
    CD_RSHS_MHMR_COMP_CODE  VARCHAR2(4)       NULL,
    DT_CCL_UPDATE           DATE              NULL,
    CD_RSRC_MHMR_SITE       VARCHAR2(4)       NULL,
    IND_RSRC_CONTRACTED     CHAR(1)           NULL,
    NM_LEGAL                VARCHAR2(90)      NULL,
    NM_RSRC_CONTACT_TITLE   VARCHAR2(30)      NULL,
    NBR_RSRC_NTNL_PROVIDER  VARCHAR2(20)      NULL,
    ADDR_RSRC_EMAIL         VARCHAR2(70)      NULL,
    ADDR_RSRC_WEBSITE       VARCHAR2(300)     NULL,
    CD_SCHOOL_TYPE          VARCHAR2(3)       NULL,
    CD_PAYMENT_DELIVERY     VARCHAR2(3)       NULL,
    TXT_SPEC_CERT           VARCHAR2(50)      NULL,
    CD_EXCHANGE_STAT        VARCHAR2(3)       NULL,
    IND_WAIVER              VARCHAR2(1)       NULL,
    CD_SCH_DIST             VARCHAR2(3)       NULL,
    CD_ELEM                 VARCHAR2(4)       NULL,
    CD_MIDDLE               VARCHAR2(4)       NULL,
    CD_HIGH                 VARCHAR2(4)       NULL,
    DT_FOST_MANUAL          DATE              NULL,
    DT_FOST_BILL            DATE              NULL,
    IND_SPECIFIC_CHILD      VARCHAR2(1)       NULL,
    DT_LIC_BEGIN            DATE              NULL,
    DT_LIC_END              DATE              NULL,
    TXT_CLOSURE_COMM        VARCHAR2(300)     NULL,
    NDFCS_CERT_ENTITY       VARCHAR2(30)      NULL,
    IND_RSRC_NONDFCS        VARCHAR2(1)       NULL,
    IND_CURR_HM_STDY_EXSTS  VARCHAR2(1)       NULL,
    IND_PREV_FAM_STDY_RQSTD VARCHAR2(1)       NULL
)
TABLESPACE DATA01
NOLOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 6M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
GRANT DELETE ON CAPS.RESOURCE_HISTORY TO CAPSBAT
;
GRANT INSERT ON CAPS.RESOURCE_HISTORY TO CAPSBAT
;
GRANT SELECT ON CAPS.RESOURCE_HISTORY TO CAPSBAT
;
GRANT UPDATE ON CAPS.RESOURCE_HISTORY TO CAPSBAT
;
GRANT DELETE ON CAPS.RESOURCE_HISTORY TO CAPSON
;
GRANT INSERT ON CAPS.RESOURCE_HISTORY TO CAPSON
;
GRANT SELECT ON CAPS.RESOURCE_HISTORY TO CAPSON
;
GRANT UPDATE ON CAPS.RESOURCE_HISTORY TO CAPSON
;
GRANT SELECT ON CAPS.RESOURCE_HISTORY TO OPERATOR
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_AUDIT_2
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_AUDIT_1
;
DROP INDEX CAPS.IND_REC_RTN_91
;
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT RENAME TO RESOURCE_H_12152006160908000
;
CREATE TABLE CAPS.RESOURCE_HISTORY_AUDIT
(
    DT_LAST_UPDATE              DATE          NOT NULL,
    ID_RESOURCE_HISTORY_AUD     NUMBER(16)    NOT NULL,
    ID_AUD_RESOURCE             NUMBER(16)    NOT NULL,
    ID_CASE                     NUMBER(16)        NULL,
    DT_RSHS_AUD_EFFECTIVE       DATE              NULL,
    DT_RSHS_AUD_CLOSE           DATE              NULL,
    DT_RSHS_AUD_CERT            DATE              NULL,
    DT_RSHS_AUD_MARRIAGE        DATE              NULL,
    DT_RSHS_AUD_END             DATE              NULL,
    ADDR_RSHS_AUD_ST_LN_1       VARCHAR2(30)      NULL,
    ADDR_RSHS_AUD_ST_LN_2       VARCHAR2(30)      NULL,
    ADDR_RSHS_AUD_CITY          VARCHAR2(20)      NULL,
    CD_RSHS_AUD_STATE           VARCHAR2(2)       NULL,
    ADDR_RSHS_AUD_ZIP           VARCHAR2(10)      NULL,
    ADDR_RSHS_AUD_ATTN          VARCHAR2(30)      NULL,
    CD_RSHS_AUD_CNTY            VARCHAR2(3)       NULL,
    CD_RSHS_AUD_REC_REASON      VARCHAR2(1)       NULL,
    CD_RSHS_AUD_INVOL_CLOSURE   VARCHAR2(1)       NULL,
    CD_RSHS_AUD_CLOSURE_RSN     VARCHAR2(3)       NULL,
    CD_RSHS_AUD_TYPE            VARCHAR2(2)       NULL,
    CD_RSHS_AUD_HUB             VARCHAR2(2)       NULL,
    CD_RSHS_AUD_CAMPUS_TYPE     VARCHAR2(1)       NULL,
    CD_RSHS_AUD_SOURCE_INQUIRY  VARCHAR2(3)       NULL,
    CD_RSHS_AUD_MAINTAINER      VARCHAR2(2)       NULL,
    CD_RSHS_AUD_SCH_DIST        VARCHAR2(6)       NULL,
    CD_RSHS_AUD_OWNERSHIP       VARCHAR2(2)       NULL,
    CD_RSHS_AUD_STATUS          VARCHAR2(2)       NULL,
    CD_RSHS_AUD_FACIL_TYPE      VARCHAR2(2)       NULL,
    CD_RSHS_AUD_CERT_BY         VARCHAR2(2)       NULL,
    CD_RSHS_AUD_OPER_BY         VARCHAR2(2)       NULL,
    CD_RSHS_AUD_SETTING         VARCHAR2(2)       NULL,
    CD_RSHS_AUD_PAYMENT         VARCHAR2(2)       NULL,
    CD_RSHS_AUD_CATEGORY        VARCHAR2(1)       NULL,
    CD_RSHS_AUD_ETHNICITY       VARCHAR2(2)       NULL,
    CD_RSHS_AUD_LANGUAGE        VARCHAR2(2)       NULL,
    CD_RSHS_AUD_MARITAL_STATUS  VARCHAR2(2)       NULL,
    CD_RSHS_AUD_RECMND_REOPEN   VARCHAR2(3)       NULL,
    CD_RSHS_AUD_REGION          VARCHAR2(2)       NULL,
    CD_RSHS_AUD_RELIGION        VARCHAR2(2)       NULL,
    CD_RSHS_AUD_RESPITE         VARCHAR2(1)       NULL,
    CD_RSHS_AUD_FA_HOME_STATUS  VARCHAR2(3)       NULL,
    CD_RSHS_AUD_FA_HOME_TYPE1   CHAR(1)           NULL,
    CD_RSHS_AUD_FA_HOME_TYPE2   CHAR(1)           NULL,
    CD_RSHS_AUD_FA_HOME_TYPE3   CHAR(1)           NULL,
    CD_RSHS_AUD_FA_HOME_TYPE4   CHAR(1)           NULL,
    CD_RSHS_AUD_FA_HOME_TYPE5   CHAR(1)           NULL,
    CD_RSHS_AUD_FA_HOME_TYPE6   CHAR(1)           NULL,
    CD_RSHS_AUD_FA_HOME_TYPE7   CHAR(1)           NULL,
    ID_RSHS_AUD_FA_HOME_STAGE   NUMBER(16)        NULL,
    ID_RSHS_AUD_FA_HOME_EVENT   NUMBER(16)        NULL,
    IND_RSHS_AUD_CARE_PROV      CHAR(1)           NULL,
    IND_RSHS_AUD_INACTIVE       CHAR(1)           NULL,
    IND_RSHS_AUD_TRANSPORT      CHAR(1)           NULL,
    IND_RSHS_AUD_EMERG_PLACE    CHAR(1)           NULL,
    NM_RSHS_AUD_RESOURCE        VARCHAR2(30)      NULL,
    NM_RSHS_AUD_CONTACT         VARCHAR2(25)      NULL,
    NM_RSHS_AUD_LAST_UPDATE     VARCHAR2(25)      NULL,
    NBR_RSHS_AUD_VID            VARCHAR2(14)      NULL,
    NBR_RSHS_AUD_PHN            VARCHAR2(10)      NULL,
    NBR_RSHS_AUD_FACIL_CAPACITY NUMBER(4)         NULL,
    NBR_RSHS_AUD_FACIL_ACCLAIM  NUMBER(8)         NULL,
    NBR_RSHS_AUD_PHONE_EXT      VARCHAR2(8)       NULL,
    NBR_RSHS_AUD_CAMPUS_NBR     NUMBER(8)         NULL,
    NBR_RSHS_AUD_ANNUAL_INCOME  NUMBER(16)        NULL,
    NBR_RSHS_AUD_FM_AGE_MAX     NUMBER(4)         NULL,
    NBR_RSHS_AUD_FM_AGE_MIN     NUMBER(4)         NULL,
    NBR_RSHS_AUD_MA_AGE_MAX     NUMBER(4)         NULL,
    NBR_RSHS_AUD_MA_AGE_MIN     NUMBER(4)         NULL,
    NBR_RSHS_AUD_INT_CHILDREN   NUMBER(3)         NULL,
    NBR_RSHS_AUD_INT_FE_AGE_MAX NUMBER(4)         NULL,
    NBR_RSHS_AUD_INT_FE_AGE_MIN NUMBER(4)         NULL,
    NBR_RSHS_AUD_INT_MA_AGE_MAX NUMBER(4)         NULL,
    NBR_RSHS_AUD_INT_MA_AGE_MIN NUMBER(4)         NULL,
    NBR_RSHS_AUD_OPEN_SLOTS     NUMBER(2)         NULL,
    TXT_RSHS_AUD_ADDR_CMNTS     VARCHAR2(80)      NULL,
    TXT_RSHS_AUD_COMMENTS       VARCHAR2(300)     NULL,
    IND_RSHS_AUD_WRITE_AUDIT    CHAR(1)       DEFAULT 'N'     NULL,
    CD_RSHS_AUD_MHMR_COMP_CODE  VARCHAR2(4)       NULL,
    DT_CCL_UPDATE               DATE              NULL,
    CD_RSRC_MHMR_SITE           VARCHAR2(4)       NULL,
    IND_RSRC_CONTRACTED         CHAR(1)           NULL,
    NM_LEGAL                    VARCHAR2(90)      NULL,
    NM_RSRC_CONTACT_TITLE       VARCHAR2(30)      NULL,
    NBR_RSRC_NTNL_PROVIDER      VARCHAR2(20)      NULL,
    ADDR_RSRC_EMAIL             VARCHAR2(70)      NULL,
    ADDR_RSRC_WEBSITE           VARCHAR2(300)     NULL,
    CD_SCHOOL_TYPE              VARCHAR2(3)       NULL,
    CD_PAYMENT_DELIVERY         VARCHAR2(3)       NULL,
    TXT_SPEC_CERT               VARCHAR2(30)      NULL,
    CD_EXCHANGE_STAT            VARCHAR2(3)       NULL,
    IND_WAIVER                  VARCHAR2(1)       NULL,
    CD_SCH_DIST                 VARCHAR2(3)       NULL,
    CD_ELEM                     VARCHAR2(4)       NULL,
    CD_MIDDLE                   VARCHAR2(4)       NULL,
    CD_HIGH                     VARCHAR2(4)       NULL,
    DT_FOST_MANUAL              DATE              NULL,
    DT_FOST_BILL                DATE              NULL,
    IND_SPECIFIC_CHILD          VARCHAR2(1)       NULL,
    DT_LIC_BEGIN                DATE              NULL,
    DT_LIC_END                  DATE              NULL,
    TXT_CLOSURE_COMM            VARCHAR2(300)     NULL,
    NDFCS_CERT_ENTITY           VARCHAR2(30)      NULL,
    IND_RSRC_NONDFCS            VARCHAR2(1)       NULL,
    IND_CURR_HM_STDY_EXSTS      VARCHAR2(1)       NULL,
    IND_PREV_FAM_STDY_RQSTD     VARCHAR2(1)       NULL
)
TABLESPACE DATA01
NOLOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 12M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
GRANT DELETE ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSBAT
;
GRANT INSERT ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSBAT
;
GRANT SELECT ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSBAT
;
GRANT UPDATE ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSBAT
;
GRANT DELETE ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSON
;
GRANT INSERT ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSON
;
GRANT SELECT ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSON
;
GRANT UPDATE ON CAPS.RESOURCE_HISTORY_AUDIT TO CAPSON
;
GRANT SELECT ON CAPS.RESOURCE_HISTORY_AUDIT TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.CAPS_RESOURCE(
                               ID_RESOURCE,
                               DT_LAST_UPDATE,
                               ID_CASE,
                               ADDR_RSRC_ST_LN_1,
                               ADDR_RSRC_ST_LN_2,
                               ADDR_RSRC_CITY,
                               CD_RSRC_STATE,
                               ADDR_RSRC_ZIP,
                               ADDR_RSRC_ATTN,
                               CD_RSRC_CNTY,
                               CD_RSRC_INVOL_CLOSURE,
                               CD_RSRC_CLOSURE_RSN,
                               CD_RSRC_SOURCE_INQUIRY,
                               CD_RSRC_TYPE,
                               CD_RSRC_CAMPUS_TYPE,
                               CD_RSRC_MAINTAINER,
                               CD_RSRC_SCH_DIST,
                               CD_RSRC_OWNERSHIP,
                               CD_RSRC_FACIL_TYPE,
                               CD_RSRC_HUB,
                               CD_RSRC_CERT_BY,
                               CD_RSRC_OPER_BY,
                               CD_RSRC_SETTING,
                               CD_RSRC_PAYMENT,
                               CD_RSRC_CATEGORY,
                               CD_RSRC_ETHNICITY,
                               CD_RSRC_LANGUAGE,
                               CD_RSRC_MARITAL_STATUS,
                               CD_RSRC_RECMND_REOPEN,
                               CD_RSRC_REGION,
                               CD_RSRC_RELIGION,
                               CD_RSRC_RESPITE,
                               CD_RSRC_FA_HOME_STATUS,
                               CD_RSRC_FA_HOME_TYPE_1,
                               CD_RSRC_FA_HOME_TYPE_2,
                               CD_RSRC_FA_HOME_TYPE_3,
                               CD_RSRC_FA_HOME_TYPE_4,
                               CD_RSRC_FA_HOME_TYPE_5,
                               CD_RSRC_FA_HOME_TYPE_6,
                               CD_RSRC_FA_HOME_TYPE_7,
                               CD_RSRC_STATUS,
                               DT_RSRC_MARRIAGE,
                               DT_RSRC_CLOSE,
                               DT_RSRC_CERT,
                               ID_RSRC_FA_HOME_STAGE,
                               ID_RSRC_FA_HOME_EVENT,
                               IND_RSRC_WRITE_HIST,
                               IND_RSRC_CARE_PROV,
                               IND_RSRC_EMERG_PLACE,
                               IND_RSRC_INACTIVE,
                               IND_RSRC_TRANSPORT,
                               NM_RSRC_LAST_UPDATE,
                               NM_RESOURCE,
                               NM_RSRC_NAME_INDEX,
                               NM_RSRC_CONTACT,
                               NBR_RSRC_PHN,
                               NBR_RSRC_PHONE_EXT,
                               NBR_RSRC_FACIL_CAPACITY,
                               NBR_RSRC_FACIL_ACCLAIM,
                               NBR_RSRC_VID,
                               NBR_RSRC_CAMPUS_NBR,
                               NBR_RSRC_INT_CHILDREN,
                               NBR_RSRC_INT_FE_AGE_MAX,
                               NBR_RSRC_INT_FE_AGE_MIN,
                               NBR_RSRC_INT_MA_AGE_MAX,
                               NBR_RSRC_INT_MA_AGE_MIN,
                               NBR_RSRC_ANNUAL_INCOME,
                               NBR_RSRC_FM_AGE_MAX,
                               NBR_RSRC_FM_AGE_MIN,
                               NBR_RSRC_MA_AGE_MAX,
                               NBR_RSRC_MA_AGE_MIN,
                               NBR_RSRC_OPEN_SLOTS,
                               TXT_RSRC_ADDR_CMNTS,
                               TXT_RSRC_COMMENTS,
                               CD_RSRC_MHMR_COMP_CODE,
                               DT_CCL_UPDATE,
                               CD_RSRC_MHMR_SITE,
                               IND_RSRC_CONTRACTED,
                               NM_LEGAL,
                               NM_RSRC_CONTACT_TITLE,
                               NBR_RSRC_NTNL_PROVIDER,
                               ADDR_RSRC_EMAIL,
                               ADDR_RSRC_WEBSITE,
                               CD_SCHOOL_TYPE,
                               CD_PAYMENT_DELIVERY,
                               TXT_SPEC_CERT,
                               CD_EXCHANGE_STAT,
                               IND_WAIVER,
                               CD_SCH_DIST,
                               CD_ELEM,
                               CD_MIDDLE,
                               CD_HIGH,
                               DT_FOST_MANUAL,
                               DT_FOST_BILL,
                               IND_SPECIFIC_CHILD,
                               DT_LIC_BEGIN,
                               DT_LIC_END,
                               TXT_CLOSURE_COMM,
                               NDFCS_CERT_ENTITY,
                               IND_RSRC_NONDFCS,
                               IND_CURR_HM_STDY_EXSTS,
                               IND_PREV_FAM_STDY_RQSTD
                              )
                        SELECT 
                               ID_RESOURCE,
                               DT_LAST_UPDATE,
                               ID_CASE,
                               ADDR_RSRC_ST_LN_1,
                               ADDR_RSRC_ST_LN_2,
                               ADDR_RSRC_CITY,
                               CD_RSRC_STATE,
                               ADDR_RSRC_ZIP,
                               ADDR_RSRC_ATTN,
                               CD_RSRC_CNTY,
                               CD_RSRC_INVOL_CLOSURE,
                               CD_RSRC_CLOSURE_RSN,
                               CD_RSRC_SOURCE_INQUIRY,
                               CD_RSRC_TYPE,
                               CD_RSRC_CAMPUS_TYPE,
                               CD_RSRC_MAINTAINER,
                               CD_RSRC_SCH_DIST,
                               CD_RSRC_OWNERSHIP,
                               CD_RSRC_FACIL_TYPE,
                               CD_RSRC_HUB,
                               CD_RSRC_CERT_BY,
                               CD_RSRC_OPER_BY,
                               CD_RSRC_SETTING,
                               CD_RSRC_PAYMENT,
                               CD_RSRC_CATEGORY,
                               CD_RSRC_ETHNICITY,
                               CD_RSRC_LANGUAGE,
                               CD_RSRC_MARITAL_STATUS,
                               CD_RSRC_RECMND_REOPEN,
                               CD_RSRC_REGION,
                               CD_RSRC_RELIGION,
                               CD_RSRC_RESPITE,
                               CD_RSRC_FA_HOME_STATUS,
                               CD_RSRC_FA_HOME_TYPE_1,
                               CD_RSRC_FA_HOME_TYPE_2,
                               CD_RSRC_FA_HOME_TYPE_3,
                               CD_RSRC_FA_HOME_TYPE_4,
                               CD_RSRC_FA_HOME_TYPE_5,
                               CD_RSRC_FA_HOME_TYPE_6,
                               CD_RSRC_FA_HOME_TYPE_7,
                               CD_RSRC_STATUS,
                               DT_RSRC_MARRIAGE,
                               DT_RSRC_CLOSE,
                               DT_RSRC_CERT,
                               ID_RSRC_FA_HOME_STAGE,
                               ID_RSRC_FA_HOME_EVENT,
                               IND_RSRC_WRITE_HIST,
                               IND_RSRC_CARE_PROV,
                               IND_RSRC_EMERG_PLACE,
                               IND_RSRC_INACTIVE,
                               IND_RSRC_TRANSPORT,
                               NM_RSRC_LAST_UPDATE,
                               NM_RESOURCE,
                               NM_RSRC_NAME_INDEX,
                               NM_RSRC_CONTACT,
                               NBR_RSRC_PHN,
                               NBR_RSRC_PHONE_EXT,
                               NBR_RSRC_FACIL_CAPACITY,
                               NBR_RSRC_FACIL_ACCLAIM,
                               NBR_RSRC_VID,
                               NBR_RSRC_CAMPUS_NBR,
                               NBR_RSRC_INT_CHILDREN,
                               NBR_RSRC_INT_FE_AGE_MAX,
                               NBR_RSRC_INT_FE_AGE_MIN,
                               NBR_RSRC_INT_MA_AGE_MAX,
                               NBR_RSRC_INT_MA_AGE_MIN,
                               NBR_RSRC_ANNUAL_INCOME,
                               NBR_RSRC_FM_AGE_MAX,
                               NBR_RSRC_FM_AGE_MIN,
                               NBR_RSRC_MA_AGE_MAX,
                               NBR_RSRC_MA_AGE_MIN,
                               NBR_RSRC_OPEN_SLOTS,
                               TXT_RSRC_ADDR_CMNTS,
                               TXT_RSRC_COMMENTS,
                               CD_RSRC_MHMR_COMP_CODE,
                               DT_CCL_UPDATE,
                               CD_RSRC_MHMR_SITE,
                               IND_RSRC_CONTRACTED,
                               NM_LEGAL,
                               NM_RSRC_CONTACT_TITLE,
                               NBR_RSRC_NTNL_PROVIDER,
                               ADDR_RSRC_EMAIL,
                               ADDR_RSRC_WEBSITE,
                               CD_SCHOOL_TYPE,
                               CD_PAYMENT_DELIVERY,
                               TXT_SPEC_CERT,
                               CD_EXCHANGE_STAT,
                               IND_WAIVER,
                               CD_SCH_DIST,
                               CD_ELEM,
                               CD_MIDDLE,
                               CD_HIGH,
                               DT_FOST_MANUAL,
                               DT_FOST_BILL,
                               IND_SPECIFIC_CHILD,
                               DT_LIC_BEGIN,
                               DT_LIC_END,
                               TXT_CLOSURE_COMM,
                               NULL,
                               NULL,
                               NULL,
                               NULL
                          FROM CAPS.CAPS_RESOU_12152006160905000 
;
COMMIT
;
ALTER TABLE CAPS.CAPS_RESOURCE LOGGING
;
ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.RESOURCE_HISTORY(
                                  ID_RESOURCE_HISTORY,
                                  ID_RESOURCE,
                                  DT_LAST_UPDATE,
                                  ID_CASE,
                                  DT_RSHS_EFFECTIVE,
                                  DT_RSHS_CLOSE,
                                  DT_RSHS_CERT,
                                  DT_RSHS_MARRIAGE,
                                  DT_RSHS_END,
                                  ADDR_RSHS_ST_LN_1,
                                  ADDR_RSHS_ST_LN_2,
                                  ADDR_RSHS_CITY,
                                  CD_RSHS_STATE,
                                  ADDR_RSHS_ZIP,
                                  ADDR_RSHS_ATTN,
                                  CD_RSHS_CNTY,
                                  CD_RSHS_INVOL_CLOSURE,
                                  CD_RSHS_CLOSURE_RSN,
                                  CD_RSHS_TYPE,
                                  CD_RSHS_HUB,
                                  CD_RSHS_CAMPUS_TYPE,
                                  CD_RSHS_SOURCE_INQUIRY,
                                  CD_RSHS_MAINTAINER,
                                  CD_RSHS_SCH_DIST,
                                  CD_RSHS_OWNERSHIP,
                                  CD_RSHS_STATUS,
                                  CD_RSHS_FACIL_TYPE,
                                  CD_RSHS_CERT_BY,
                                  CD_RSHS_OPER_BY,
                                  CD_RSHS_SETTING,
                                  CD_RSHS_PAYMENT,
                                  CD_RSHS_CATEGORY,
                                  CD_RSHS_ETHNICITY,
                                  CD_RSHS_LANGUAGE,
                                  CD_RSHS_MARITAL_STATUS,
                                  CD_RSHS_RECMND_REOPEN,
                                  CD_RSHS_REGION,
                                  CD_RSHS_RELIGION,
                                  CD_RSHS_RESPITE,
                                  CD_RSHS_FA_HOME_STATUS,
                                  CD_RSHS_FA_HOME_TYPE1,
                                  CD_RSHS_FA_HOME_TYPE2,
                                  CD_RSHS_FA_HOME_TYPE3,
                                  CD_RSHS_FA_HOME_TYPE4,
                                  CD_RSHS_FA_HOME_TYPE5,
                                  CD_RSHS_FA_HOME_TYPE6,
                                  CD_RSHS_FA_HOME_TYPE7,
                                  ID_RSHS_FA_HOME_STAGE,
                                  ID_RSHS_FA_HOME_EVENT,
                                  IND_RSHS_CARE_PROV,
                                  IND_RSHS_INACTIVE,
                                  IND_RSHS_TRANSPORT,
                                  IND_RSHS_EMERG_PLACE,
                                  NM_RSHS_RESOURCE,
                                  NM_RSHS_CONTACT,
                                  NM_RSHS_LAST_UPDATE,
                                  NBR_RSHS_VID,
                                  NBR_RSHS_PHN,
                                  NBR_RSHS_FACIL_CAPACITY,
                                  NBR_RSHS_FACIL_ACCLAIM,
                                  NBR_RSHS_PHONE_EXT,
                                  NBR_RSHS_CAMPUS_NBR,
                                  NBR_RSHS_ANNUAL_INCOME,
                                  NBR_RSHS_FM_AGE_MAX,
                                  NBR_RSHS_FM_AGE_MIN,
                                  NBR_RSHS_MA_AGE_MAX,
                                  NBR_RSHS_MA_AGE_MIN,
                                  NBR_RSHS_INT_CHILDREN,
                                  NBR_RSHS_INT_FE_AGE_MAX,
                                  NBR_RSHS_INT_FE_AGE_MIN,
                                  NBR_RSHS_INT_MA_AGE_MAX,
                                  NBR_RSHS_INT_MA_AGE_MIN,
                                  TXT_RSHS_ADDR_CMNTS,
                                  TXT_RSHS_COMMENTS,
                                  NBR_RSHS_OPEN_SLOTS,
                                  IND_RSHS_WRITE_AUDIT,
                                  CD_RSHS_MHMR_COMP_CODE,
                                  DT_CCL_UPDATE,
                                  CD_RSRC_MHMR_SITE,
                                  IND_RSRC_CONTRACTED,
                                  NM_LEGAL,
                                  NM_RSRC_CONTACT_TITLE,
                                  NBR_RSRC_NTNL_PROVIDER,
                                  ADDR_RSRC_EMAIL,
                                  ADDR_RSRC_WEBSITE,
                                  CD_SCHOOL_TYPE,
                                  CD_PAYMENT_DELIVERY,
                                  TXT_SPEC_CERT,
                                  CD_EXCHANGE_STAT,
                                  IND_WAIVER,
                                  CD_SCH_DIST,
                                  CD_ELEM,
                                  CD_MIDDLE,
                                  CD_HIGH,
                                  DT_FOST_MANUAL,
                                  DT_FOST_BILL,
                                  IND_SPECIFIC_CHILD,
                                  DT_LIC_BEGIN,
                                  DT_LIC_END,
                                  TXT_CLOSURE_COMM,
                                  NDFCS_CERT_ENTITY,
                                  IND_RSRC_NONDFCS,
                                  IND_CURR_HM_STDY_EXSTS,
                                  IND_PREV_FAM_STDY_RQSTD
                                 )
                           SELECT 
                                  ID_RESOURCE_HISTORY,
                                  ID_RESOURCE,
                                  DT_LAST_UPDATE,
                                  ID_CASE,
                                  DT_RSHS_EFFECTIVE,
                                  DT_RSHS_CLOSE,
                                  DT_RSHS_CERT,
                                  DT_RSHS_MARRIAGE,
                                  DT_RSHS_END,
                                  ADDR_RSHS_ST_LN_1,
                                  ADDR_RSHS_ST_LN_2,
                                  ADDR_RSHS_CITY,
                                  CD_RSHS_STATE,
                                  ADDR_RSHS_ZIP,
                                  ADDR_RSHS_ATTN,
                                  CD_RSHS_CNTY,
                                  CD_RSHS_INVOL_CLOSURE,
                                  CD_RSHS_CLOSURE_RSN,
                                  CD_RSHS_TYPE,
                                  CD_RSHS_HUB,
                                  CD_RSHS_CAMPUS_TYPE,
                                  CD_RSHS_SOURCE_INQUIRY,
                                  CD_RSHS_MAINTAINER,
                                  CD_RSHS_SCH_DIST,
                                  CD_RSHS_OWNERSHIP,
                                  CD_RSHS_STATUS,
                                  CD_RSHS_FACIL_TYPE,
                                  CD_RSHS_CERT_BY,
                                  CD_RSHS_OPER_BY,
                                  CD_RSHS_SETTING,
                                  CD_RSHS_PAYMENT,
                                  CD_RSHS_CATEGORY,
                                  CD_RSHS_ETHNICITY,
                                  CD_RSHS_LANGUAGE,
                                  CD_RSHS_MARITAL_STATUS,
                                  CD_RSHS_RECMND_REOPEN,
                                  CD_RSHS_REGION,
                                  CD_RSHS_RELIGION,
                                  CD_RSHS_RESPITE,
                                  CD_RSHS_FA_HOME_STATUS,
                                  CD_RSHS_FA_HOME_TYPE1,
                                  CD_RSHS_FA_HOME_TYPE2,
                                  CD_RSHS_FA_HOME_TYPE3,
                                  CD_RSHS_FA_HOME_TYPE4,
                                  CD_RSHS_FA_HOME_TYPE5,
                                  CD_RSHS_FA_HOME_TYPE6,
                                  CD_RSHS_FA_HOME_TYPE7,
                                  ID_RSHS_FA_HOME_STAGE,
                                  ID_RSHS_FA_HOME_EVENT,
                                  IND_RSHS_CARE_PROV,
                                  IND_RSHS_INACTIVE,
                                  IND_RSHS_TRANSPORT,
                                  IND_RSHS_EMERG_PLACE,
                                  NM_RSHS_RESOURCE,
                                  NM_RSHS_CONTACT,
                                  NM_RSHS_LAST_UPDATE,
                                  NBR_RSHS_VID,
                                  NBR_RSHS_PHN,
                                  NBR_RSHS_FACIL_CAPACITY,
                                  NBR_RSHS_FACIL_ACCLAIM,
                                  NBR_RSHS_PHONE_EXT,
                                  NBR_RSHS_CAMPUS_NBR,
                                  NBR_RSHS_ANNUAL_INCOME,
                                  NBR_RSHS_FM_AGE_MAX,
                                  NBR_RSHS_FM_AGE_MIN,
                                  NBR_RSHS_MA_AGE_MAX,
                                  NBR_RSHS_MA_AGE_MIN,
                                  NBR_RSHS_INT_CHILDREN,
                                  NBR_RSHS_INT_FE_AGE_MAX,
                                  NBR_RSHS_INT_FE_AGE_MIN,
                                  NBR_RSHS_INT_MA_AGE_MAX,
                                  NBR_RSHS_INT_MA_AGE_MIN,
                                  TXT_RSHS_ADDR_CMNTS,
                                  TXT_RSHS_COMMENTS,
                                  NBR_RSHS_OPEN_SLOTS,
                                  IND_RSHS_WRITE_AUDIT,
                                  CD_RSHS_MHMR_COMP_CODE,
                                  DT_CCL_UPDATE,
                                  CD_RSRC_MHMR_SITE,
                                  IND_RSRC_CONTRACTED,
                                  NM_LEGAL,
                                  NM_RSRC_CONTACT_TITLE,
                                  NBR_RSRC_NTNL_PROVIDER,
                                  ADDR_RSRC_EMAIL,
                                  ADDR_RSRC_WEBSITE,
                                  CD_SCHOOL_TYPE,
                                  CD_PAYMENT_DELIVERY,
                                  TXT_SPEC_CERT,
                                  CD_EXCHANGE_STAT,
                                  IND_WAIVER,
                                  CD_SCH_DIST,
                                  CD_ELEM,
                                  CD_MIDDLE,
                                  CD_HIGH,
                                  DT_FOST_MANUAL,
                                  DT_FOST_BILL,
                                  IND_SPECIFIC_CHILD,
                                  DT_LIC_BEGIN,
                                  DT_LIC_END,
                                  TXT_CLOSURE_COMM,
                                  NULL,
                                  NULL,
                                  NULL,
                                  NULL
                             FROM CAPS.RESOURCE_H_12152006160907000 
;
COMMIT
;
ALTER TABLE CAPS.RESOURCE_HISTORY LOGGING
;
ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.RESOURCE_HISTORY_AUDIT(
                                        DT_LAST_UPDATE,
                                        ID_RESOURCE_HISTORY_AUD,
                                        ID_AUD_RESOURCE,
                                        ID_CASE,
                                        DT_RSHS_AUD_EFFECTIVE,
                                        DT_RSHS_AUD_CLOSE,
                                        DT_RSHS_AUD_CERT,
                                        DT_RSHS_AUD_MARRIAGE,
                                        DT_RSHS_AUD_END,
                                        ADDR_RSHS_AUD_ST_LN_1,
                                        ADDR_RSHS_AUD_ST_LN_2,
                                        ADDR_RSHS_AUD_CITY,
                                        CD_RSHS_AUD_STATE,
                                        ADDR_RSHS_AUD_ZIP,
                                        ADDR_RSHS_AUD_ATTN,
                                        CD_RSHS_AUD_CNTY,
                                        CD_RSHS_AUD_REC_REASON,
                                        CD_RSHS_AUD_INVOL_CLOSURE,
                                        CD_RSHS_AUD_CLOSURE_RSN,
                                        CD_RSHS_AUD_TYPE,
                                        CD_RSHS_AUD_HUB,
                                        CD_RSHS_AUD_CAMPUS_TYPE,
                                        CD_RSHS_AUD_SOURCE_INQUIRY,
                                        CD_RSHS_AUD_MAINTAINER,
                                        CD_RSHS_AUD_SCH_DIST,
                                        CD_RSHS_AUD_OWNERSHIP,
                                        CD_RSHS_AUD_STATUS,
                                        CD_RSHS_AUD_FACIL_TYPE,
                                        CD_RSHS_AUD_CERT_BY,
                                        CD_RSHS_AUD_OPER_BY,
                                        CD_RSHS_AUD_SETTING,
                                        CD_RSHS_AUD_PAYMENT,
                                        CD_RSHS_AUD_CATEGORY,
                                        CD_RSHS_AUD_ETHNICITY,
                                        CD_RSHS_AUD_LANGUAGE,
                                        CD_RSHS_AUD_MARITAL_STATUS,
                                        CD_RSHS_AUD_RECMND_REOPEN,
                                        CD_RSHS_AUD_REGION,
                                        CD_RSHS_AUD_RELIGION,
                                        CD_RSHS_AUD_RESPITE,
                                        CD_RSHS_AUD_FA_HOME_STATUS,
                                        CD_RSHS_AUD_FA_HOME_TYPE1,
                                        CD_RSHS_AUD_FA_HOME_TYPE2,
                                        CD_RSHS_AUD_FA_HOME_TYPE3,
                                        CD_RSHS_AUD_FA_HOME_TYPE4,
                                        CD_RSHS_AUD_FA_HOME_TYPE5,
                                        CD_RSHS_AUD_FA_HOME_TYPE6,
                                        CD_RSHS_AUD_FA_HOME_TYPE7,
                                        ID_RSHS_AUD_FA_HOME_STAGE,
                                        ID_RSHS_AUD_FA_HOME_EVENT,
                                        IND_RSHS_AUD_CARE_PROV,
                                        IND_RSHS_AUD_INACTIVE,
                                        IND_RSHS_AUD_TRANSPORT,
                                        IND_RSHS_AUD_EMERG_PLACE,
                                        NM_RSHS_AUD_RESOURCE,
                                        NM_RSHS_AUD_CONTACT,
                                        NM_RSHS_AUD_LAST_UPDATE,
                                        NBR_RSHS_AUD_VID,
                                        NBR_RSHS_AUD_PHN,
                                        NBR_RSHS_AUD_FACIL_CAPACITY,
                                        NBR_RSHS_AUD_FACIL_ACCLAIM,
                                        NBR_RSHS_AUD_PHONE_EXT,
                                        NBR_RSHS_AUD_CAMPUS_NBR,
                                        NBR_RSHS_AUD_ANNUAL_INCOME,
                                        NBR_RSHS_AUD_FM_AGE_MAX,
                                        NBR_RSHS_AUD_FM_AGE_MIN,
                                        NBR_RSHS_AUD_MA_AGE_MAX,
                                        NBR_RSHS_AUD_MA_AGE_MIN,
                                        NBR_RSHS_AUD_INT_CHILDREN,
                                        NBR_RSHS_AUD_INT_FE_AGE_MAX,
                                        NBR_RSHS_AUD_INT_FE_AGE_MIN,
                                        NBR_RSHS_AUD_INT_MA_AGE_MAX,
                                        NBR_RSHS_AUD_INT_MA_AGE_MIN,
                                        NBR_RSHS_AUD_OPEN_SLOTS,
                                        TXT_RSHS_AUD_ADDR_CMNTS,
                                        TXT_RSHS_AUD_COMMENTS,
                                        IND_RSHS_AUD_WRITE_AUDIT,
                                        CD_RSHS_AUD_MHMR_COMP_CODE,
                                        DT_CCL_UPDATE,
                                        CD_RSRC_MHMR_SITE,
                                        IND_RSRC_CONTRACTED,
                                        NM_LEGAL,
                                        NM_RSRC_CONTACT_TITLE,
                                        NBR_RSRC_NTNL_PROVIDER,
                                        ADDR_RSRC_EMAIL,
                                        ADDR_RSRC_WEBSITE,
                                        CD_SCHOOL_TYPE,
                                        CD_PAYMENT_DELIVERY,
                                        TXT_SPEC_CERT,
                                        CD_EXCHANGE_STAT,
                                        IND_WAIVER,
                                        CD_SCH_DIST,
                                        CD_ELEM,
                                        CD_MIDDLE,
                                        CD_HIGH,
                                        DT_FOST_MANUAL,
                                        DT_FOST_BILL,
                                        IND_SPECIFIC_CHILD,
                                        DT_LIC_BEGIN,
                                        DT_LIC_END,
                                        TXT_CLOSURE_COMM,
                                        NDFCS_CERT_ENTITY,
                                        IND_RSRC_NONDFCS,
                                        IND_CURR_HM_STDY_EXSTS,
                                        IND_PREV_FAM_STDY_RQSTD
                                       )
                                 SELECT 
                                        DT_LAST_UPDATE,
                                        ID_RESOURCE_HISTORY_AUD,
                                        ID_AUD_RESOURCE,
                                        ID_CASE,
                                        DT_RSHS_AUD_EFFECTIVE,
                                        DT_RSHS_AUD_CLOSE,
                                        DT_RSHS_AUD_CERT,
                                        DT_RSHS_AUD_MARRIAGE,
                                        DT_RSHS_AUD_END,
                                        ADDR_RSHS_AUD_ST_LN_1,
                                        ADDR_RSHS_AUD_ST_LN_2,
                                        ADDR_RSHS_AUD_CITY,
                                        CD_RSHS_AUD_STATE,
                                        ADDR_RSHS_AUD_ZIP,
                                        ADDR_RSHS_AUD_ATTN,
                                        CD_RSHS_AUD_CNTY,
                                        CD_RSHS_AUD_REC_REASON,
                                        CD_RSHS_AUD_INVOL_CLOSURE,
                                        CD_RSHS_AUD_CLOSURE_RSN,
                                        CD_RSHS_AUD_TYPE,
                                        CD_RSHS_AUD_HUB,
                                        CD_RSHS_AUD_CAMPUS_TYPE,
                                        CD_RSHS_AUD_SOURCE_INQUIRY,
                                        CD_RSHS_AUD_MAINTAINER,
                                        CD_RSHS_AUD_SCH_DIST,
                                        CD_RSHS_AUD_OWNERSHIP,
                                        CD_RSHS_AUD_STATUS,
                                        CD_RSHS_AUD_FACIL_TYPE,
                                        CD_RSHS_AUD_CERT_BY,
                                        CD_RSHS_AUD_OPER_BY,
                                        CD_RSHS_AUD_SETTING,
                                        CD_RSHS_AUD_PAYMENT,
                                        CD_RSHS_AUD_CATEGORY,
                                        CD_RSHS_AUD_ETHNICITY,
                                        CD_RSHS_AUD_LANGUAGE,
                                        CD_RSHS_AUD_MARITAL_STATUS,
                                        CD_RSHS_AUD_RECMND_REOPEN,
                                        CD_RSHS_AUD_REGION,
                                        CD_RSHS_AUD_RELIGION,
                                        CD_RSHS_AUD_RESPITE,
                                        CD_RSHS_AUD_FA_HOME_STATUS,
                                        CD_RSHS_AUD_FA_HOME_TYPE1,
                                        CD_RSHS_AUD_FA_HOME_TYPE2,
                                        CD_RSHS_AUD_FA_HOME_TYPE3,
                                        CD_RSHS_AUD_FA_HOME_TYPE4,
                                        CD_RSHS_AUD_FA_HOME_TYPE5,
                                        CD_RSHS_AUD_FA_HOME_TYPE6,
                                        CD_RSHS_AUD_FA_HOME_TYPE7,
                                        ID_RSHS_AUD_FA_HOME_STAGE,
                                        ID_RSHS_AUD_FA_HOME_EVENT,
                                        IND_RSHS_AUD_CARE_PROV,
                                        IND_RSHS_AUD_INACTIVE,
                                        IND_RSHS_AUD_TRANSPORT,
                                        IND_RSHS_AUD_EMERG_PLACE,
                                        NM_RSHS_AUD_RESOURCE,
                                        NM_RSHS_AUD_CONTACT,
                                        NM_RSHS_AUD_LAST_UPDATE,
                                        NBR_RSHS_AUD_VID,
                                        NBR_RSHS_AUD_PHN,
                                        NBR_RSHS_AUD_FACIL_CAPACITY,
                                        NBR_RSHS_AUD_FACIL_ACCLAIM,
                                        NBR_RSHS_AUD_PHONE_EXT,
                                        NBR_RSHS_AUD_CAMPUS_NBR,
                                        NBR_RSHS_AUD_ANNUAL_INCOME,
                                        NBR_RSHS_AUD_FM_AGE_MAX,
                                        NBR_RSHS_AUD_FM_AGE_MIN,
                                        NBR_RSHS_AUD_MA_AGE_MAX,
                                        NBR_RSHS_AUD_MA_AGE_MIN,
                                        NBR_RSHS_AUD_INT_CHILDREN,
                                        NBR_RSHS_AUD_INT_FE_AGE_MAX,
                                        NBR_RSHS_AUD_INT_FE_AGE_MIN,
                                        NBR_RSHS_AUD_INT_MA_AGE_MAX,
                                        NBR_RSHS_AUD_INT_MA_AGE_MIN,
                                        NBR_RSHS_AUD_OPEN_SLOTS,
                                        TXT_RSHS_AUD_ADDR_CMNTS,
                                        TXT_RSHS_AUD_COMMENTS,
                                        IND_RSHS_AUD_WRITE_AUDIT,
                                        CD_RSHS_AUD_MHMR_COMP_CODE,
                                        DT_CCL_UPDATE,
                                        CD_RSRC_MHMR_SITE,
                                        IND_RSRC_CONTRACTED,
                                        NM_LEGAL,
                                        NM_RSRC_CONTACT_TITLE,
                                        NBR_RSRC_NTNL_PROVIDER,
                                        ADDR_RSRC_EMAIL,
                                        ADDR_RSRC_WEBSITE,
                                        CD_SCHOOL_TYPE,
                                        CD_PAYMENT_DELIVERY,
                                        TXT_SPEC_CERT,
                                        CD_EXCHANGE_STAT,
                                        IND_WAIVER,
                                        CD_SCH_DIST,
                                        CD_ELEM,
                                        CD_MIDDLE,
                                        CD_HIGH,
                                        DT_FOST_MANUAL,
                                        DT_FOST_BILL,
                                        IND_SPECIFIC_CHILD,
                                        DT_LIC_BEGIN,
                                        DT_LIC_END,
                                        TXT_CLOSURE_COMM,
                                        NULL,
                                        NULL,
                                        NULL,
                                        NULL
                                   FROM CAPS.RESOURCE_H_12152006160908000 
;
COMMIT
;
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.CAPS_RESOURCE ADD CONSTRAINT PK_CAPS_RESOURCE
PRIMARY KEY (ID_RESOURCE)
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
ALTER TABLE CAPS.RESOURCE_HISTORY ADD CONSTRAINT PK_RESOURCE_HISTORY
PRIMARY KEY (ID_RESOURCE_HISTORY)
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

CREATE INDEX CAPS.IND_CAPS_RESOURCE_1
    ON CAPS.CAPS_RESOURCE(ID_RSRC_FA_HOME_EVENT)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_CAPS_RESOURCE_2
    ON CAPS.CAPS_RESOURCE(ID_RSRC_FA_HOME_STAGE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_CAPS_RESOURCE_3
    ON CAPS.CAPS_RESOURCE(CD_RSRC_TYPE,CD_RSRC_STATUS,NM_RSRC_NAME_INDEX)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_CAPS_RESOURCE_4
    ON CAPS.CAPS_RESOURCE(CD_RSRC_REGION,CD_RSRC_STATUS)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_CAPS_RESOURCE_5
    ON CAPS.CAPS_RESOURCE(CD_RSRC_TYPE,CD_RSRC_STATUS,CD_RSRC_FACIL_TYPE,NM_RSRC_NAME_INDEX)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_CAPS_RESOURCE_6
    ON CAPS.CAPS_RESOURCE(NBR_RSRC_FACIL_ACCLAIM)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_REC_RTN_10
    ON CAPS.CAPS_RESOURCE(ID_CASE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_CAPS_RESOURCE_7
    ON CAPS.CAPS_RESOURCE(NM_RESOURCE,CD_RSRC_FACIL_TYPE,CD_RSRC_CATEGORY,ID_RSRC_FA_HOME_STAGE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_HISTORY_5
    ON CAPS.RESOURCE_HISTORY(DT_RSHS_EFFECTIVE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_HISTORY_1
    ON CAPS.RESOURCE_HISTORY(ID_RSHS_FA_HOME_EVENT)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_HISTORY_2
    ON CAPS.RESOURCE_HISTORY(CD_RSHS_FA_HOME_STATUS)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_HISTORY_3
    ON CAPS.RESOURCE_HISTORY(ID_RSHS_FA_HOME_STAGE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_HISTORY_4
    ON CAPS.RESOURCE_HISTORY(ID_RESOURCE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_REC_RTN_90
    ON CAPS.RESOURCE_HISTORY(ID_CASE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_HISTORY_AUDIT_2
    ON CAPS.RESOURCE_HISTORY_AUDIT(ID_RESOURCE_HISTORY_AUD)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_HISTORY_AUDIT_1
    ON CAPS.RESOURCE_HISTORY_AUDIT(ID_AUD_RESOURCE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_REC_RTN_91
    ON CAPS.RESOURCE_HISTORY_AUDIT(ID_CASE)
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
ALTER VIEW CAPS.CONTRACT_COUNTY_VIEW COMPILE
/
/
DROP TRIGGER CAPS.TIBR_RESOURCE_HISTORY_AUDIT
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_RESOURCE_HISTORY_AUDIT
BEFORE INSERT
ON CAPS.RESOURCE_HISTORY_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
DROP TRIGGER CAPS.TUBR_RESOURCE_HISTORY_AUDIT
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_RESOURCE_HISTORY_AUDIT
BEFORE UPDATE
ON CAPS.RESOURCE_HISTORY_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.ADOPTION_SUBSIDY ADD CONSTRAINT FK_ADPT_SUBSIDY_PAYEE
FOREIGN KEY (ID_ADPT_SUB_PAYEE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.ADO_INFO ADD CONSTRAINT FK_ADO_INFO_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.ADO_INFO_FAMILY ADD CONSTRAINT FK_ADO_INF_FAM_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.ALOC ADD CONSTRAINT FK_ALOC_RESOURCE
FOREIGN KEY (ID_ALOC_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.CAPS_CARETAKER ADD CONSTRAINT FK_CAPS_CARETAKER_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.CONTRACT ADD CONSTRAINT FK_CONTRACT_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.CONTRACT_COUNTY ADD CONSTRAINT FK_CONTRACT_COUNTY_2
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.DELVRD_SVC_DTL ADD CONSTRAINT FK_SVC_DTL_RSRC
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.EDUCATIONAL_HISTORY ADD CONSTRAINT FK_EDHIST_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.FACILITY_INVST_DTL ADD CONSTRAINT FK_FACIL_INVST_AFFIL_RESOURCE
FOREIGN KEY (ID_AFFIL_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.FACILITY_INVST_DTL ADD CONSTRAINT FK_FACIL_INVST_FACIL_RESOURCE
FOREIGN KEY (ID_FACIL_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.FACILITY_LICENSE_TYPE ADD CONSTRAINT FK_FACIL_LIC_TYPE_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.FACILITY_LOC ADD CONSTRAINT FK_FACILITY_LOC
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.HOME_APPLICANT_INFO ADD CONSTRAINT FK_HOME_APP_INFO_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.INCOMING_DETAIL ADD CONSTRAINT FK_INCOMING_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.INCOMING_DETAIL ADD CONSTRAINT FK_INC_DET_REF_RSC
FOREIGN KEY (ID_REFERRED_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.INCOMING_FACILITY ADD CONSTRAINT FK_INCOMING_FACILITY_RSRC
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.LAW_ENFORC_ZIP ADD CONSTRAINT FK_LAW_ENFORC_ZIP_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.NEEDS_OUTCOMES ADD CONSTRAINT FK_NEEDS_OUTS_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.PLACEMENT ADD CONSTRAINT FK_PLCMT_AGENCY
FOREIGN KEY (ID_RSRC_AGENCY)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.PLACEMENT ADD CONSTRAINT FK_PLCMT_FACIL
FOREIGN KEY (ID_RSRC_FACIL)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.PLACEMENT_REFERRAL ADD CONSTRAINT FK_PLACE_REF_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.POLICY_WAIVER ADD CONSTRAINT FK_WVR_RSRC
FOREIGN KEY (ID_WVR_RSRC)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.PPA_DELVRD_SVC ADD CONSTRAINT FK_PPA_SVC_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.PPA_REPORT ADD CONSTRAINT FK_PPA_REPORT_RSRC
FOREIGN KEY (ID_PPA_FACIL)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.REFERRAL_HOME_LINK ADD CONSTRAINT FK_REFERRAL_HOME_LINK_R
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.RESOURCE_ADDRESS ADD CONSTRAINT FK_RESOURCE_ADDRESS
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.RESOURCE_CHRCTR ADD CONSTRAINT FK_RESOURCE_CHRCTR_RSRC
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.RESOURCE_PHONE ADD CONSTRAINT FK_RESOURCE_PHONE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.RESOURCE_SERVICE ADD CONSTRAINT FK_RESOURCE_SERVICE_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.RSRC_LINK ADD CONSTRAINT FK_RSRC_LINK_CHILD
FOREIGN KEY (ID_RSRC_LINK_CHILD)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.RSRC_LINK ADD CONSTRAINT FK_RSRC_LINK_PARENT
FOREIGN KEY (ID_RSRC_LINK_PARENT)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.SERVICE_AUTHORIZATION ADD CONSTRAINT FK_SVC_AUTH_PROVIDER
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.SPEC_SVCS ADD CONSTRAINT FK_SPEC_SVCS_RSRC
FOREIGN KEY (ID_SPEC_SVC_RSRC)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.CAPS_RESOURCE ADD CONSTRAINT FK_CAPS_RESOURCE_EVENT
FOREIGN KEY (ID_RSRC_FA_HOME_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.CAPS_RESOURCE ADD CONSTRAINT FK_CAPS_RESOURCE_STAGE
FOREIGN KEY (ID_RSRC_FA_HOME_STAGE)
REFERENCES CAPS.STAGE (ID_STAGE)
ENABLE
;
ALTER TABLE CAPS.RESOURCE_HISTORY ADD CONSTRAINT FK_RESOURCE_HISTORY_EVENT
FOREIGN KEY (ID_RSHS_FA_HOME_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.RESOURCE_HISTORY ADD CONSTRAINT FK_RESOURCE_HISTORY_STAGE
FOREIGN KEY (ID_RSHS_FA_HOME_STAGE)
REFERENCES CAPS.STAGE (ID_STAGE)
ENABLE
;

-- Materialized View Alter SQL


-- Alter Procedure SQL


-- Alter Package SQL


-- Alter Oracle Object Type SQL


-- Alter Trigger SQL
/
DROP TRIGGER CAPS.TUBR_CAPS_RESOURCE
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CAPS_RESOURCE
BEFORE UPDATE
ON CAPS.CAPS_RESOURCE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
  dummy2    NUMBER;

-- Similar to those triggers of table PERSON
-- Mike Bui 12-JUL-95

BEGIN

-- 05/26/2001 MITSCHCG Added for CLASS project SIR #15684
-- For resource type 70 check whether any of the following columns changed
-- and if changed set the dt_ccl_update to sysdate.

IF :NEW.CD_RSRC_FACIL_TYPE ='70' THEN

IF ((:OLD.CD_RSRC_FACIL_TYPE IS NULL AND :NEW.CD_RSRC_FACIL_TYPE IS NOT NULL)   OR
   (:OLD.CD_RSRC_FACIL_TYPE IS NOT NULL AND :NEW.CD_RSRC_FACIL_TYPE IS NULL)   OR
   (:OLD.CD_RSRC_FACIL_TYPE != :NEW.CD_RSRC_FACIL_TYPE))        OR
   ((:OLD.CD_RSRC_FA_HOME_STATUS IS NULL AND :NEW.CD_RSRC_FA_HOME_STATUS IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_STATUS IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_STATUS IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_STATUS != :NEW.CD_RSRC_FA_HOME_STATUS))        OR
   ((:OLD.CD_RSRC_CATEGORY IS NULL AND :NEW.CD_RSRC_CATEGORY IS NOT NULL)   OR
   (:OLD.CD_RSRC_CATEGORY IS NOT NULL AND :NEW.CD_RSRC_CATEGORY IS NULL)   OR
   (:OLD.CD_RSRC_CATEGORY != :NEW.CD_RSRC_CATEGORY))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_1 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_1 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_1 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_1 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_1 != :NEW.CD_RSRC_FA_HOME_TYPE_1))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_2 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_2 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_2 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_2 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_2 != :NEW.CD_RSRC_FA_HOME_TYPE_2))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_3 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_3 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_3 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_3 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_3 != :NEW.CD_RSRC_FA_HOME_TYPE_3))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_4 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_4 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_4 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_4 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_4 != :NEW.CD_RSRC_FA_HOME_TYPE_4))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_5 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_5 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_5 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_5 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_5 != :NEW.CD_RSRC_FA_HOME_TYPE_5))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_6 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_6 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_6 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_6 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_6 != :NEW.CD_RSRC_FA_HOME_TYPE_6))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_7 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_7 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_7 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_7 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_7 != :NEW.CD_RSRC_FA_HOME_TYPE_7))        OR
   ((:OLD.CD_RSRC_REGION IS NULL AND :NEW.CD_RSRC_REGION IS NOT NULL)   OR
   (:OLD.CD_RSRC_REGION IS NOT NULL AND :NEW.CD_RSRC_REGION IS NULL)   OR
   (:OLD.CD_RSRC_REGION != :NEW.CD_RSRC_REGION))        OR
   ((:OLD.NM_RESOURCE IS NULL AND :NEW.NM_RESOURCE IS NOT NULL)   OR
   (:OLD.NM_RESOURCE IS NOT NULL AND :NEW.NM_RESOURCE IS NULL)   OR
   (:OLD.NM_RESOURCE != :NEW.NM_RESOURCE))        OR
   ((:OLD.NBR_RSRC_FACIL_CAPACITY IS NULL AND :NEW.NBR_RSRC_FACIL_CAPACITY IS NOT NULL)   OR
   (:OLD.NBR_RSRC_FACIL_CAPACITY IS NOT NULL AND :NEW.NBR_RSRC_FACIL_CAPACITY IS NULL)   OR
   (:OLD.NBR_RSRC_FACIL_CAPACITY != :NEW.NBR_RSRC_FACIL_CAPACITY))        OR
   ((:OLD.DT_RSRC_CLOSE IS NULL AND :NEW.DT_RSRC_CLOSE IS NOT NULL)   OR
   (:OLD.DT_RSRC_CLOSE IS NOT NULL AND :NEW.DT_RSRC_CLOSE IS NULL)   OR
   (:OLD.DT_RSRC_CLOSE != :NEW.DT_RSRC_CLOSE))        OR
   ((:OLD.DT_RSRC_CERT IS NULL AND :NEW.DT_RSRC_CERT IS NOT NULL)   OR
   (:OLD.DT_RSRC_CERT IS NOT NULL AND :NEW.DT_RSRC_CERT IS NULL)   OR
   (:OLD.DT_RSRC_CERT != :NEW.DT_RSRC_CERT))        OR
   ((:OLD.ADDR_RSRC_ST_LN_1 IS NULL AND :NEW.ADDR_RSRC_ST_LN_1 IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_1 IS NOT NULL AND :NEW.ADDR_RSRC_ST_LN_1 IS NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_1 != :NEW.ADDR_RSRC_ST_LN_1))        OR
   ((:OLD.ADDR_RSRC_ST_LN_2 IS NULL AND :NEW.ADDR_RSRC_ST_LN_2 IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_2 IS NOT NULL AND :NEW.ADDR_RSRC_ST_LN_2 IS NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_2 != :NEW.ADDR_RSRC_ST_LN_2))        OR
   ((:OLD.ADDR_RSRC_CITY IS NULL AND :NEW.ADDR_RSRC_CITY IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_CITY IS NOT NULL AND :NEW.ADDR_RSRC_CITY IS NULL)   OR
   (:OLD.ADDR_RSRC_CITY != :NEW.ADDR_RSRC_CITY))        OR
   ((:OLD.CD_RSRC_STATE IS NULL AND :NEW.CD_RSRC_STATE IS NOT NULL)   OR
   (:OLD.CD_RSRC_STATE IS NOT NULL AND :NEW.CD_RSRC_STATE IS NULL)   OR
   (:OLD.CD_RSRC_STATE != :NEW.CD_RSRC_STATE))        OR
   ((:OLD.ADDR_RSRC_ZIP IS NULL AND :NEW.ADDR_RSRC_ZIP IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_ZIP IS NOT NULL AND :NEW.ADDR_RSRC_ZIP IS NULL)   OR
   (:OLD.ADDR_RSRC_ZIP != :NEW.ADDR_RSRC_ZIP))        OR
   ((:OLD.CD_RSRC_CNTY IS NULL AND :NEW.CD_RSRC_CNTY IS NOT NULL)   OR
   (:OLD.CD_RSRC_CNTY IS NOT NULL AND :NEW.CD_RSRC_CNTY IS NULL)   OR
   (:OLD.CD_RSRC_CNTY != :NEW.CD_RSRC_CNTY))        OR
   ((:OLD.NBR_RSRC_PHN IS NULL AND :NEW.NBR_RSRC_PHN IS NOT NULL)     OR
   (:OLD.NBR_RSRC_PHN IS NOT NULL AND :NEW.NBR_RSRC_PHN IS NULL)     OR
   (:OLD.NBR_RSRC_PHN != :NEW.NBR_RSRC_PHN))            OR
   ((:OLD.NBR_RSRC_PHONE_EXT IS NULL AND :NEW.NBR_RSRC_PHONE_EXT IS NOT NULL)   OR
   (:OLD.NBR_RSRC_PHONE_EXT IS NOT NULL AND :NEW.NBR_RSRC_PHONE_EXT IS NULL)   OR
   (:OLD.NBR_RSRC_PHONE_EXT != :NEW.NBR_RSRC_PHONE_EXT))        OR
   ((:OLD.NBR_RSRC_FM_AGE_MAX IS NULL AND :NEW.NBR_RSRC_FM_AGE_MAX IS NOT NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MAX IS NOT NULL AND :NEW.NBR_RSRC_FM_AGE_MAX IS NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MAX != :NEW.NBR_RSRC_FM_AGE_MAX))        OR
   ((:OLD.NBR_RSRC_FM_AGE_MIN IS NULL AND :NEW.NBR_RSRC_FM_AGE_MIN IS NOT NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MIN IS NOT NULL AND :NEW.NBR_RSRC_FM_AGE_MIN IS NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MIN != :NEW.NBR_RSRC_FM_AGE_MIN))        OR
   ((:OLD.NBR_RSRC_MA_AGE_MAX IS NULL AND :NEW.NBR_RSRC_MA_AGE_MAX IS NOT NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MAX IS NOT NULL AND :NEW.NBR_RSRC_MA_AGE_MAX IS NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MAX != :NEW.NBR_RSRC_MA_AGE_MAX))        OR
   ((:OLD.NBR_RSRC_MA_AGE_MIN IS NULL AND :NEW.NBR_RSRC_MA_AGE_MIN IS NOT NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MIN IS NOT NULL AND :NEW.NBR_RSRC_MA_AGE_MIN IS NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MIN != :NEW.NBR_RSRC_MA_AGE_MIN))
                    THEN
  :NEW.DT_CCL_UPDATE := SYSDATE;
END IF;

END IF;


  :NEW.DT_LAST_UPDATE := SYSDATE;
  :NEW.NM_RSRC_NAME_INDEX := SUBSTR(:NEW.NM_RESOURCE,0,2);
  --insert into table RESOURCE_HISTORY if field :new.IND_RSRC_WRITE_HIST is 'Y':
  IF NVL(:NEW.IND_RSRC_WRITE_HIST,'N') = 'Y' THEN

  --dbms_output.put_line('0');
  -- 1st: set END DATE of previous record:
  UPDATE RESOURCE_HISTORY  RH
  SET    RH.DT_RSHS_END    = :NEW.DT_LAST_UPDATE
  WHERE  RH.ID_RESOURCE    = :NEW.ID_RESOURCE
  AND    RH.ID_RESOURCE_HISTORY  =
    (SELECT MAX(RH2.ID_RESOURCE_HISTORY)
    FROM   RESOURCE_HISTORY RH2
    WHERE  RH2.ID_RESOURCE= :NEW.ID_RESOURCE
    AND    RH2.DT_RSHS_END = '12/31/4712');

  -- now insert a new record into RESOURCE_HISTORY using data from the OLD record
  -- (not from the NEW record) of CAPS_RESOURCE.  This is different with that
  -- update trigger of table PERSON

  -- Get next sequence value:
  SELECT SEQ_RESOURCE_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;

  --dbms_output.put_line('1 '||TO_CHAR(dummy2) ||' ' ||
  --to_char(:new.dt_last_update) || ' ' ||
  --to_char(:new.id_resource) );
  INSERT INTO RESOURCE_HISTORY (
    ID_RESOURCE_HISTORY,
    DT_RSHS_EFFECTIVE,
    DT_RSHS_END,
    ID_RESOURCE,
    DT_LAST_UPDATE,
    ID_CASE,
    ADDR_RSHS_ST_LN_1,
    ADDR_RSHS_ST_LN_2,
    ADDR_RSHS_CITY,
    ADDR_RSHS_ATTN,
    CD_RSHS_STATE,
    ADDR_RSHS_ZIP,
    CD_RSHS_CNTY,
    NM_RSHS_RESOURCE,
    NM_RSHS_CONTACT,
    CD_RSHS_TYPE,
    CD_RSHS_HUB,
    CD_RSHS_CAMPUS_TYPE,
    NBR_RSHS_PHN,
    NBR_RSHS_CAMPUS_NBR,
    CD_RSHS_MAINTAINER,
    CD_RSHS_SCH_DIST,
    CD_RSHS_OWNERSHIP,
    CD_RSHS_STATUS,
    NM_RSHS_LAST_UPDATE,
    IND_RSHS_TRANSPORT,
    CD_RSHS_FACIL_TYPE,
    NBR_RSHS_FACIL_ACCLAIM,
    CD_RSHS_CERT_BY,
    CD_RSHS_OPER_BY,
    CD_RSHS_SETTING,
    DT_RSHS_CERT,
    DT_RSHS_CLOSE,
    CD_RSHS_PAYMENT,
    NBR_RSHS_FACIL_CAPACITY,
    ID_RSHS_FA_HOME_STAGE,
    ID_RSHS_FA_HOME_EVENT,
    CD_RSHS_CATEGORY,
    CD_RSHS_ETHNICITY,
    CD_RSHS_LANGUAGE,
    CD_RSHS_MARITAL_STATUS,
    CD_RSHS_REGION,
    CD_RSHS_RELIGION,
    CD_RSHS_RESPITE,
    CD_RSHS_RECMND_REOPEN,
    CD_RSHS_FA_HOME_TYPE1,
    CD_RSHS_FA_HOME_TYPE2,
    CD_RSHS_FA_HOME_TYPE3,
    CD_RSHS_FA_HOME_TYPE4,
    CD_RSHS_FA_HOME_TYPE5,
    CD_RSHS_FA_HOME_TYPE6,
    CD_RSHS_FA_HOME_TYPE7,
                CD_RSHS_MHMR_COMP_CODE,
    CD_RSHS_INVOL_CLOSURE,
    CD_RSHS_CLOSURE_RSN,
    CD_RSHS_FA_HOME_STATUS,
    DT_RSHS_MARRIAGE,
    IND_RSHS_CARE_PROV,
    IND_RSHS_EMERG_PLACE,
    IND_RSHS_INACTIVE,
    NBR_RSHS_INT_CHILDREN,
    NBR_RSHS_INT_FE_AGE_MAX,
    NBR_RSHS_INT_FE_AGE_MIN,
    NBR_RSHS_INT_MA_AGE_MAX,
    NBR_RSHS_INT_MA_AGE_MIN,
    NBR_RSHS_ANNUAL_INCOME,
    NBR_RSHS_FM_AGE_MAX,
    NBR_RSHS_FM_AGE_MIN,
    NBR_RSHS_MA_AGE_MAX,
    NBR_RSHS_MA_AGE_MIN,
    NBR_RSHS_PHONE_EXT,
    NBR_RSHS_VID,
                NBR_RSHS_OPEN_SLOTS,
    CD_RSHS_SOURCE_INQUIRY,
    TXT_RSHS_ADDR_CMNTS,
    TXT_RSHS_COMMENTS,
                DT_CCL_UPDATE,
    CD_RSRC_MHMR_SITE,
    IND_RSRC_CONTRACTED,
    NM_LEGAL,
    NM_RSRC_CONTACT_TITLE,
    NBR_RSRC_NTNL_PROVIDER,
    ADDR_RSRC_EMAIL,
    ADDR_RSRC_WEBSITE,
    CD_SCHOOL_TYPE,
    CD_PAYMENT_DELIVERY,
    TXT_SPEC_CERT,
    CD_EXCHANGE_STAT,
    IND_WAIVER,
    CD_SCH_DIST,
    CD_ELEM,
    CD_MIDDLE,
    CD_HIGH,
    DT_FOST_MANUAL,
    DT_FOST_BILL,
    IND_SPECIFIC_CHILD,
    DT_LIC_BEGIN,
    DT_LIC_END,
    TXT_CLOSURE_COMM,
    NDFCS_CERT_ENTITY,
    IND_RSRC_NONDFCS,
    IND_CURR_HM_STDY_EXSTS,
    IND_PREV_FAM_STDY_RQSTD
  ) VALUES (
    dummy2,
    :NEW.DT_LAST_UPDATE,
    NULL,
    :NEW.ID_RESOURCE,
    SYSDATE,
    :NEW.ID_CASE,
    :NEW.ADDR_RSRC_ST_LN_1,
    :NEW.ADDR_RSRC_ST_LN_2,
    :NEW.ADDR_RSRC_CITY,
    :NEW.ADDR_RSRC_ATTN,
    :NEW.CD_RSRC_STATE,
    :NEW.ADDR_RSRC_ZIP,
    :NEW.CD_RSRC_CNTY,
    :NEW.NM_RESOURCE,
    :NEW.NM_RSRC_CONTACT,
    :NEW.CD_RSRC_TYPE,
    :NEW.CD_RSRC_HUB,
    :NEW.CD_RSRC_CAMPUS_TYPE,
    :NEW.NBR_RSRC_PHN,
    :NEW.NBR_RSRC_CAMPUS_NBR,
    :NEW.CD_RSRC_MAINTAINER,
    :NEW.CD_RSRC_SCH_DIST,
    :NEW.CD_RSRC_OWNERSHIP,
    :NEW.CD_RSRC_STATUS,
    :NEW.NM_RSRC_LAST_UPDATE,
    :NEW.IND_RSRC_TRANSPORT,
    :NEW.CD_RSRC_FACIL_TYPE,
    :NEW.NBR_RSRC_FACIL_ACCLAIM,
    :NEW.CD_RSRC_CERT_BY,
    :NEW.CD_RSRC_OPER_BY,
    :NEW.CD_RSRC_SETTING,
    :NEW.DT_RSRC_CERT,
    :NEW.DT_RSRC_CLOSE,
    :NEW.CD_RSRC_PAYMENT,
    :NEW.NBR_RSRC_FACIL_CAPACITY,
    :NEW.ID_RSRC_FA_HOME_STAGE,
    :NEW.ID_RSRC_FA_HOME_EVENT,
    :NEW.CD_RSRC_CATEGORY,
    :NEW.CD_RSRC_ETHNICITY,
    :NEW.CD_RSRC_LANGUAGE,
    :NEW.CD_RSRC_MARITAL_STATUS,
    :NEW.CD_RSRC_REGION,
    :NEW.CD_RSRC_RELIGION,
    :NEW.CD_RSRC_RESPITE,
    :NEW.CD_RSRC_RECMND_REOPEN,
    :NEW.CD_RSRC_FA_HOME_TYPE_1,
    :NEW.CD_RSRC_FA_HOME_TYPE_2,
    :NEW.CD_RSRC_FA_HOME_TYPE_3,
    :NEW.CD_RSRC_FA_HOME_TYPE_4,
    :NEW.CD_RSRC_FA_HOME_TYPE_5,
    :NEW.CD_RSRC_FA_HOME_TYPE_6,
    :NEW.CD_RSRC_FA_HOME_TYPE_7,
                :NEW.CD_RSRC_MHMR_COMP_CODE,
    :NEW.CD_RSRC_INVOL_CLOSURE,
    :NEW.CD_RSRC_CLOSURE_RSN,
    :NEW.CD_RSRC_FA_HOME_STATUS,
    :NEW.DT_RSRC_MARRIAGE,
    :NEW.IND_RSRC_CARE_PROV,
    :NEW.IND_RSRC_EMERG_PLACE,
    :NEW.IND_RSRC_INACTIVE,
    :NEW.NBR_RSRC_INT_CHILDREN,
    :NEW.NBR_RSRC_INT_FE_AGE_MAX,
    :NEW.NBR_RSRC_INT_FE_AGE_MIN,
    :NEW.NBR_RSRC_INT_MA_AGE_MAX,
    :NEW.NBR_RSRC_INT_MA_AGE_MIN,
    :NEW.NBR_RSRC_ANNUAL_INCOME,
    :NEW.NBR_RSRC_FM_AGE_MAX,
    :NEW.NBR_RSRC_FM_AGE_MIN,
    :NEW.NBR_RSRC_MA_AGE_MAX,
    :NEW.NBR_RSRC_MA_AGE_MIN,
    :NEW.NBR_RSRC_PHONE_EXT,
    :NEW.NBR_RSRC_VID,
                :NEW.NBR_RSRC_OPEN_SLOTS,
    :NEW.CD_RSRC_SOURCE_INQUIRY,
    :NEW.TXT_RSRC_ADDR_CMNTS,
    :NEW.TXT_RSRC_COMMENTS,
                :NEW.DT_CCL_UPDATE,
    :NEW.CD_RSRC_MHMR_SITE,
    :NEW.IND_RSRC_CONTRACTED,
    :NEW.NM_LEGAL,
    :NEW.NM_RSRC_CONTACT_TITLE,
    :NEW.NBR_RSRC_NTNL_PROVIDER,
    :NEW.ADDR_RSRC_EMAIL,
    :NEW.ADDR_RSRC_WEBSITE,
    :NEW.CD_SCHOOL_TYPE,
    :NEW.CD_PAYMENT_DELIVERY,
    :NEW.TXT_SPEC_CERT,
    :NEW.CD_EXCHANGE_STAT,
    :NEW.IND_WAIVER,
    :NEW.CD_SCH_DIST,
    :NEW.CD_ELEM,
    :NEW.CD_MIDDLE,
    :NEW.CD_HIGH,
    :NEW.DT_FOST_MANUAL,
    :NEW.DT_FOST_BILL,
    :NEW.IND_SPECIFIC_CHILD,
    :NEW.DT_LIC_BEGIN,
    :NEW.DT_LIC_END,
    :NEW.TXT_CLOSURE_COMM,
    :New.NDFCS_CERT_ENTITY,
    :New.IND_RSRC_NONDFCS,
    :New.IND_CURR_HM_STDY_EXSTS,
    :New.IND_PREV_FAM_STDY_RQSTD);
END IF;


END;
/
/
DROP TRIGGER CAPS.TIBR_CAPS_RESOURCE
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CAPS_RESOURCE
BEFORE INSERT
ON CAPS.CAPS_RESOURCE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
  dummy2    NUMBER;

-- Similar to those triggers of table PERSON
-- Mike Bui 12-JUL-95

BEGIN

-- 05/26/2001 MITSCHCG Added for CLASS project SIR #15684

IF :NEW.CD_RSRC_FACIL_TYPE = '70' THEN
  :NEW.DT_CCL_UPDATE := SYSDATE;
END IF;
--
  :NEW.DT_LAST_UPDATE := SYSDATE;
  :NEW.NM_RSRC_NAME_INDEX := SUBSTR(:NEW.NM_RESOURCE,0,2);
  IF :NEW.ID_RESOURCE=0 THEN
  SELECT SEQ_CAPS_RESOURCE.NEXTVAL INTO dummy  FROM DUAL;
  :NEW.ID_RESOURCE := dummy;
  END IF;

  BEGIN
    SELECT  ID_CASE
    INTO    :NEW.ID_CASE
    FROM    STAGE
    WHERE    ID_STAGE = :NEW.ID_RSRC_FA_HOME_STAGE;
  EXCEPTION
    WHEN OTHERS THEN
      IF SQL%NOTFOUND THEN
        :NEW.ID_CASE := NULL;
      END IF;
  END;

  --insert into table RESOURCE_HISTORY if field :new.IND_RSRC_WRITE_HIST is 'Y':
   IF NVL(:NEW.IND_RSRC_WRITE_HIST,'N') = 'Y' THEN

  -- Get next sequence value:
  SELECT SEQ_RESOURCE_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;

  INSERT INTO RESOURCE_HISTORY (
    ID_RESOURCE_HISTORY,
    DT_RSHS_EFFECTIVE,
    DT_RSHS_END,
    ID_RESOURCE,
    DT_LAST_UPDATE,
    ID_CASE,
    ADDR_RSHS_ST_LN_1,
    ADDR_RSHS_ST_LN_2,
    ADDR_RSHS_CITY,
    ADDR_RSHS_ATTN,
    CD_RSHS_STATE,
    ADDR_RSHS_ZIP,
    CD_RSHS_CNTY,
    NM_RSHS_RESOURCE,
    NM_RSHS_CONTACT,
    CD_RSHS_TYPE,
    CD_RSHS_HUB,
    CD_RSHS_CAMPUS_TYPE,
    NBR_RSHS_PHN,
    NBR_RSHS_CAMPUS_NBR,
    CD_RSHS_MAINTAINER,
    CD_RSHS_SCH_DIST,
    CD_RSHS_OWNERSHIP,
    CD_RSHS_STATUS,
    NM_RSHS_LAST_UPDATE,
    IND_RSHS_TRANSPORT,
    CD_RSHS_FACIL_TYPE,
    NBR_RSHS_FACIL_ACCLAIM,
    CD_RSHS_CERT_BY,
    CD_RSHS_OPER_BY,
    CD_RSHS_SETTING,
    DT_RSHS_CERT,
    DT_RSHS_CLOSE,
    CD_RSHS_PAYMENT,
    NBR_RSHS_FACIL_CAPACITY,
    ID_RSHS_FA_HOME_STAGE,
    ID_RSHS_FA_HOME_EVENT,
    CD_RSHS_CATEGORY,
    CD_RSHS_ETHNICITY,
    CD_RSHS_LANGUAGE,
    CD_RSHS_MARITAL_STATUS,
    CD_RSHS_REGION,
    CD_RSHS_RELIGION,
    CD_RSHS_RESPITE,
    CD_RSHS_RECMND_REOPEN,
    CD_RSHS_FA_HOME_TYPE1,
    CD_RSHS_FA_HOME_TYPE2,
    CD_RSHS_FA_HOME_TYPE3,
    CD_RSHS_FA_HOME_TYPE4,
    CD_RSHS_FA_HOME_TYPE5,
    CD_RSHS_FA_HOME_TYPE6,
    CD_RSHS_FA_HOME_TYPE7,
                CD_RSHS_MHMR_COMP_CODE,
    CD_RSHS_INVOL_CLOSURE,
    CD_RSHS_CLOSURE_RSN,
    CD_RSHS_FA_HOME_STATUS,
    DT_RSHS_MARRIAGE,
    IND_RSHS_CARE_PROV,
    IND_RSHS_EMERG_PLACE,
    IND_RSHS_INACTIVE,
    NBR_RSHS_INT_CHILDREN,
    NBR_RSHS_INT_FE_AGE_MAX,
    NBR_RSHS_INT_FE_AGE_MIN,
    NBR_RSHS_INT_MA_AGE_MAX,
    NBR_RSHS_INT_MA_AGE_MIN,
    NBR_RSHS_ANNUAL_INCOME,
    NBR_RSHS_FM_AGE_MAX,
    NBR_RSHS_FM_AGE_MIN,
    NBR_RSHS_MA_AGE_MAX,
    NBR_RSHS_MA_AGE_MIN,
    NBR_RSHS_PHONE_EXT,
    NBR_RSHS_VID,
                NBR_RSHS_OPEN_SLOTS,
    CD_RSHS_SOURCE_INQUIRY,
    TXT_RSHS_ADDR_CMNTS,
    TXT_RSHS_COMMENTS,
    DT_CCL_UPDATE,
    CD_RSRC_MHMR_SITE,
    IND_RSRC_CONTRACTED,
    NM_LEGAL,
    NM_RSRC_CONTACT_TITLE,
    NBR_RSRC_NTNL_PROVIDER,
    ADDR_RSRC_EMAIL,
    ADDR_RSRC_WEBSITE,
    CD_SCHOOL_TYPE,
    CD_PAYMENT_DELIVERY,
    TXT_SPEC_CERT,
    CD_EXCHANGE_STAT,
    IND_WAIVER,
    CD_SCH_DIST,
    CD_ELEM,
    CD_MIDDLE,
    CD_HIGH,
    DT_FOST_MANUAL,
    DT_FOST_BILL,
    IND_SPECIFIC_CHILD,
    DT_LIC_BEGIN,
    DT_LIC_END,
    TXT_CLOSURE_COMM,
    NDFCS_CERT_ENTITY,
    IND_RSRC_NONDFCS,
    IND_CURR_HM_STDY_EXSTS,
    IND_PREV_FAM_STDY_RQSTD)
 VALUES (
    dummy2,
    :NEW.DT_LAST_UPDATE,
    NULL,
    :NEW.ID_RESOURCE,
    SYSDATE,
    :NEW.ID_CASE,
    :NEW.ADDR_RSRC_ST_LN_1,
    :NEW.ADDR_RSRC_ST_LN_2,
    :NEW.ADDR_RSRC_CITY,
    :NEW.ADDR_RSRC_ATTN,
    :NEW.CD_RSRC_STATE,
    :NEW.ADDR_RSRC_ZIP,
    :NEW.CD_RSRC_CNTY,
    :NEW.NM_RESOURCE,
    :NEW.NM_RSRC_CONTACT,
    :NEW.CD_RSRC_TYPE,
    :NEW.CD_RSRC_HUB,
    :NEW.CD_RSRC_CAMPUS_TYPE,
    :NEW.NBR_RSRC_PHN,
    :NEW.NBR_RSRC_CAMPUS_NBR,
    :NEW.CD_RSRC_MAINTAINER,
    :NEW.CD_RSRC_SCH_DIST,
    :NEW.CD_RSRC_OWNERSHIP,
    :NEW.CD_RSRC_STATUS,
    :NEW.NM_RSRC_LAST_UPDATE,
    :NEW.IND_RSRC_TRANSPORT,
    :NEW.CD_RSRC_FACIL_TYPE,
    :NEW.NBR_RSRC_FACIL_ACCLAIM,
    :NEW.CD_RSRC_CERT_BY,
    :NEW.CD_RSRC_OPER_BY,
    :NEW.CD_RSRC_SETTING,
    :NEW.DT_RSRC_CERT,
    :NEW.DT_RSRC_CLOSE,
    :NEW.CD_RSRC_PAYMENT,
    :NEW.NBR_RSRC_FACIL_CAPACITY,
    :NEW.ID_RSRC_FA_HOME_STAGE,
    :NEW.ID_RSRC_FA_HOME_EVENT,
    :NEW.CD_RSRC_CATEGORY,
    :NEW.CD_RSRC_ETHNICITY,
    :NEW.CD_RSRC_LANGUAGE,
    :NEW.CD_RSRC_MARITAL_STATUS,
    :NEW.CD_RSRC_REGION,
    :NEW.CD_RSRC_RELIGION,
    :NEW.CD_RSRC_RESPITE,
    :NEW.CD_RSRC_RECMND_REOPEN,
    :NEW.CD_RSRC_FA_HOME_TYPE_1,
    :NEW.CD_RSRC_FA_HOME_TYPE_2,
    :NEW.CD_RSRC_FA_HOME_TYPE_3,
    :NEW.CD_RSRC_FA_HOME_TYPE_4,
    :NEW.CD_RSRC_FA_HOME_TYPE_5,
    :NEW.CD_RSRC_FA_HOME_TYPE_6,
    :NEW.CD_RSRC_FA_HOME_TYPE_7,
                :NEW.CD_RSRC_MHMR_COMP_CODE,
    :NEW.CD_RSRC_INVOL_CLOSURE,
    :NEW.CD_RSRC_CLOSURE_RSN,
    :NEW.CD_RSRC_FA_HOME_STATUS,
    :NEW.DT_RSRC_MARRIAGE,
    :NEW.IND_RSRC_CARE_PROV,
    :NEW.IND_RSRC_EMERG_PLACE,
    :NEW.IND_RSRC_INACTIVE,
    :NEW.NBR_RSRC_INT_CHILDREN,
    :NEW.NBR_RSRC_INT_FE_AGE_MAX,
    :NEW.NBR_RSRC_INT_FE_AGE_MIN,
    :NEW.NBR_RSRC_INT_MA_AGE_MAX,
    :NEW.NBR_RSRC_INT_MA_AGE_MIN,
    :NEW.NBR_RSRC_ANNUAL_INCOME,
    :NEW.NBR_RSRC_FM_AGE_MAX,
    :NEW.NBR_RSRC_FM_AGE_MIN,
    :NEW.NBR_RSRC_MA_AGE_MAX,
    :NEW.NBR_RSRC_MA_AGE_MIN,
    :NEW.NBR_RSRC_PHONE_EXT,
    :NEW.NBR_RSRC_VID,
                :NEW.NBR_RSRC_OPEN_SLOTS,
    :NEW.CD_RSRC_SOURCE_INQUIRY,
    :NEW.TXT_RSRC_ADDR_CMNTS,
    :NEW.TXT_RSRC_COMMENTS,
    :NEW.DT_CCL_UPDATE,
    :NEW.CD_RSRC_MHMR_SITE,
    :NEW.IND_RSRC_CONTRACTED,
    :NEW.NM_LEGAL,
    :New.NM_RSRC_CONTACT_TITLE,
    :New.NBR_RSRC_NTNL_PROVIDER,
    :New.ADDR_RSRC_EMAIL,
    :New.ADDR_RSRC_WEBSITE,
    :New.CD_SCHOOL_TYPE,
    :New.CD_PAYMENT_DELIVERY,
    :New.TXT_SPEC_CERT,
    :New.CD_EXCHANGE_STAT,
    :New.IND_WAIVER,
    :New.CD_SCH_DIST,
    :New.CD_ELEM,
    :New.CD_MIDDLE,
    :New.CD_HIGH,
    :New.DT_FOST_MANUAL,
    :New.DT_FOST_BILL,
    :New.IND_SPECIFIC_CHILD,
    :New.DT_LIC_BEGIN,
    :New.DT_LIC_END,
    :New.TXT_CLOSURE_COMM,
    :New.NDFCS_CERT_ENTITY,
    :New.IND_RSRC_NONDFCS,
    :New.IND_CURR_HM_STDY_EXSTS,
    :New.IND_PREV_FAM_STDY_RQSTD);

   END IF;
END;
/
/
DROP TRIGGER CAPS.TUBR_RESOURCE_HISTORY
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_RESOURCE_HISTORY
BEFORE UPDATE
ON CAPS.RESOURCE_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :NEW.DT_LAST_UPDATE := SYSDATE;

  IF :NEW.DT_RSHS_END IS NULL THEN
    :NEW.DT_RSHS_END := TO_DATE('12/31/4712','MM/DD/YYYY');
  END IF;

  INSERT INTO RESOURCE_HISTORY_AUDIT (
    ID_RESOURCE_HISTORY_AUD,
    ID_AUD_RESOURCE,
    DT_RSHS_AUD_EFFECTIVE,
    DT_RSHS_AUD_CLOSE,
    DT_LAST_UPDATE,
    ID_CASE,
    DT_RSHS_AUD_CERT,
    DT_RSHS_AUD_MARRIAGE,
    DT_RSHS_AUD_END,
    ADDR_RSHS_AUD_ST_LN_1,
    ADDR_RSHS_AUD_ST_LN_2,
    ADDR_RSHS_AUD_CITY,
    CD_RSHS_AUD_STATE,
    ADDR_RSHS_AUD_ZIP,
    ADDR_RSHS_AUD_ATTN,
    CD_RSHS_AUD_CNTY,
    CD_RSHS_AUD_INVOL_CLOSURE,
    CD_RSHS_AUD_CLOSURE_RSN,
    CD_RSHS_AUD_TYPE,
    CD_RSHS_AUD_HUB,
    CD_RSHS_AUD_CAMPUS_TYPE,
    CD_RSHS_AUD_SOURCE_INQUIRY,
    CD_RSHS_AUD_MAINTAINER,
    CD_RSHS_AUD_SCH_DIST,
    CD_RSHS_AUD_OWNERSHIP,
    CD_RSHS_AUD_STATUS,
    CD_RSHS_AUD_FACIL_TYPE,
    CD_RSHS_AUD_CERT_BY,
    CD_RSHS_AUD_OPER_BY,
    CD_RSHS_AUD_SETTING,
    CD_RSHS_AUD_PAYMENT,
    CD_RSHS_AUD_CATEGORY,
    CD_RSHS_AUD_ETHNICITY,
    CD_RSHS_AUD_LANGUAGE,
    CD_RSHS_AUD_MARITAL_STATUS,
    CD_RSHS_AUD_RECMND_REOPEN,
    CD_RSHS_AUD_REGION,
    CD_RSHS_AUD_RELIGION,
    CD_RSHS_AUD_RESPITE,
    CD_RSHS_AUD_FA_HOME_STATUS,
    CD_RSHS_AUD_FA_HOME_TYPE1,
    CD_RSHS_AUD_FA_HOME_TYPE2,
    CD_RSHS_AUD_FA_HOME_TYPE3,
    CD_RSHS_AUD_FA_HOME_TYPE4,
    CD_RSHS_AUD_FA_HOME_TYPE5,
    CD_RSHS_AUD_FA_HOME_TYPE6,
    CD_RSHS_AUD_FA_HOME_TYPE7,
                CD_RSHS_AUD_MHMR_COMP_CODE,
    ID_RSHS_AUD_FA_HOME_STAGE,
    ID_RSHS_AUD_FA_HOME_EVENT,
    IND_RSHS_AUD_CARE_PROV,
    IND_RSHS_AUD_INACTIVE,
    IND_RSHS_AUD_TRANSPORT,
    IND_RSHS_AUD_EMERG_PLACE,
    NM_RSHS_AUD_RESOURCE,
    NM_RSHS_AUD_CONTACT,
    NM_RSHS_AUD_LAST_UPDATE,
    NBR_RSHS_AUD_VID,
    NBR_RSHS_AUD_PHN,
    NBR_RSHS_AUD_FACIL_CAPACITY,
    NBR_RSHS_AUD_FACIL_ACCLAIM,
    NBR_RSHS_AUD_PHONE_EXT,
    NBR_RSHS_AUD_CAMPUS_NBR,
    NBR_RSHS_AUD_ANNUAL_INCOME,
    NBR_RSHS_AUD_FM_AGE_MAX,
    NBR_RSHS_AUD_FM_AGE_MIN,
    NBR_RSHS_AUD_MA_AGE_MAX,
    NBR_RSHS_AUD_MA_AGE_MIN,
    NBR_RSHS_AUD_INT_CHILDREN,
    NBR_RSHS_AUD_INT_FE_AGE_MAX ,
    NBR_RSHS_AUD_INT_FE_AGE_MIN,
    NBR_RSHS_AUD_INT_MA_AGE_MAX,
    NBR_RSHS_AUD_INT_MA_AGE_MIN,
    NBR_RSHS_AUD_OPEN_SLOTS,
    TXT_RSHS_AUD_ADDR_CMNTS,
    TXT_RSHS_AUD_COMMENTS,
    IND_RSHS_AUD_WRITE_AUDIT,
    DT_CCL_UPDATE,
    CD_RSRC_MHMR_SITE,
    IND_RSRC_CONTRACTED,
    NM_LEGAL,
    NM_RSRC_CONTACT_TITLE,
    NBR_RSRC_NTNL_PROVIDER,
    ADDR_RSRC_EMAIL,
    ADDR_RSRC_WEBSITE,
    CD_SCHOOL_TYPE,
    CD_PAYMENT_DELIVERY,
    TXT_SPEC_CERT,
    CD_EXCHANGE_STAT,
    IND_WAIVER,
    CD_SCH_DIST,
    CD_ELEM,
    CD_MIDDLE,
    CD_HIGH,
    DT_FOST_MANUAL,
    DT_FOST_BILL,
    IND_SPECIFIC_CHILD,
    DT_LIC_BEGIN,
    DT_LIC_END,
    TXT_CLOSURE_COMM,
    NDFCS_CERT_ENTITY,
    IND_RSRC_NONDFCS,
    IND_CURR_HM_STDY_EXSTS,
    IND_PREV_FAM_STDY_RQSTD
  ) VALUES (
    :NEW.ID_RESOURCE_HISTORY,
    :NEW.ID_RESOURCE,
    :NEW.DT_RSHS_EFFECTIVE,
    :NEW.DT_RSHS_CLOSE,
    :NEW.DT_LAST_UPDATE,
    :NEW.ID_CASE,
    :NEW.DT_RSHS_CERT,
    :NEW.DT_RSHS_MARRIAGE,
    :NEW.DT_RSHS_END,
    :NEW.ADDR_RSHS_ST_LN_1,
    :NEW.ADDR_RSHS_ST_LN_2,
    :NEW.ADDR_RSHS_CITY,
    :NEW.CD_RSHS_STATE,
    :NEW.ADDR_RSHS_ZIP,
    :NEW.ADDR_RSHS_ATTN,
    :NEW.CD_RSHS_CNTY,
    :NEW.CD_RSHS_INVOL_CLOSURE,
    :NEW.CD_RSHS_CLOSURE_RSN,
    :NEW.CD_RSHS_TYPE,
    :NEW.CD_RSHS_HUB,
    :NEW.CD_RSHS_CAMPUS_TYPE,
    :NEW.CD_RSHS_SOURCE_INQUIRY,
    :NEW.CD_RSHS_MAINTAINER,
    :NEW.CD_RSHS_SCH_DIST,
    :NEW.CD_RSHS_OWNERSHIP,
    :NEW.CD_RSHS_STATUS,
    :NEW.CD_RSHS_FACIL_TYPE,
    :NEW.CD_RSHS_CERT_BY,
    :NEW.CD_RSHS_OPER_BY,
    :NEW.CD_RSHS_SETTING,
    :NEW.CD_RSHS_PAYMENT,
    :NEW.CD_RSHS_CATEGORY,
    :NEW.CD_RSHS_ETHNICITY,
    :NEW.CD_RSHS_LANGUAGE,
    :NEW.CD_RSHS_MARITAL_STATUS,
    :NEW.CD_RSHS_RECMND_REOPEN,
    :NEW.CD_RSHS_REGION,
    :NEW.CD_RSHS_RELIGION,
    :NEW.CD_RSHS_RESPITE,
    :NEW.CD_RSHS_FA_HOME_STATUS,
    :NEW.CD_RSHS_FA_HOME_TYPE1,
    :NEW.CD_RSHS_FA_HOME_TYPE2,
    :NEW.CD_RSHS_FA_HOME_TYPE3,
    :NEW.CD_RSHS_FA_HOME_TYPE4,
    :NEW.CD_RSHS_FA_HOME_TYPE5,
    :NEW.CD_RSHS_FA_HOME_TYPE6,
    :NEW.CD_RSHS_FA_HOME_TYPE7,
                :NEW.CD_RSHS_MHMR_COMP_CODE,
    :NEW.ID_RSHS_FA_HOME_STAGE,
    :NEW.ID_RSHS_FA_HOME_EVENT,
    :NEW.IND_RSHS_CARE_PROV,
    :NEW.IND_RSHS_INACTIVE,
    :NEW.IND_RSHS_TRANSPORT,
    :NEW.IND_RSHS_EMERG_PLACE,
    :NEW.NM_RSHS_RESOURCE,
    :NEW.NM_RSHS_CONTACT,
    :NEW.NM_RSHS_LAST_UPDATE,
    :NEW.NBR_RSHS_VID,
    :NEW.NBR_RSHS_PHN,
    :NEW.NBR_RSHS_FACIL_CAPACITY,
    :NEW.NBR_RSHS_FACIL_ACCLAIM,
    :NEW.NBR_RSHS_PHONE_EXT,
    :NEW.NBR_RSHS_CAMPUS_NBR,
    :NEW.NBR_RSHS_ANNUAL_INCOME,
    :NEW.NBR_RSHS_FM_AGE_MAX,
    :NEW.NBR_RSHS_FM_AGE_MIN,
    :NEW.NBR_RSHS_MA_AGE_MAX,
    :NEW.NBR_RSHS_MA_AGE_MIN,
    :NEW.NBR_RSHS_INT_CHILDREN,
    :NEW.NBR_RSHS_INT_FE_AGE_MAX,
    :NEW.NBR_RSHS_INT_FE_AGE_MIN,
    :NEW.NBR_RSHS_INT_MA_AGE_MAX,
    :NEW.NBR_RSHS_INT_MA_AGE_MIN,
    :NEW.NBR_RSHS_OPEN_SLOTS,
    :NEW.TXT_RSHS_ADDR_CMNTS,
    :NEW.TXT_RSHS_COMMENTS,
    :NEW.IND_RSHS_WRITE_AUDIT,
    :NEW.DT_CCL_UPDATE,
    :NEW.CD_RSRC_MHMR_SITE,
    :NEW.IND_RSRC_CONTRACTED,
    :NEW.NM_LEGAL,
    :NEW.NM_RSRC_CONTACT_TITLE,
    :NEW.NBR_RSRC_NTNL_PROVIDER,
    :NEW.ADDR_RSRC_EMAIL,
    :NEW.ADDR_RSRC_WEBSITE,
    :NEW.CD_SCHOOL_TYPE,
    :NEW.CD_PAYMENT_DELIVERY,
    :NEW.TXT_SPEC_CERT,
    :NEW.CD_EXCHANGE_STAT,
    :NEW.IND_WAIVER,
    :NEW.CD_SCH_DIST,
    :NEW.CD_ELEM,
    :NEW.CD_MIDDLE,
    :NEW.CD_HIGH,
    :NEW.DT_FOST_MANUAL,
    :NEW.DT_FOST_BILL,
    :NEW.IND_SPECIFIC_CHILD,
    :NEW.DT_LIC_BEGIN,
    :NEW.DT_LIC_END,
    :NEW.TXT_CLOSURE_COMM,
    :NEW.NDFCS_CERT_ENTITY,
    :NEW.IND_RSRC_NONDFCS,
    :NEW.IND_CURR_HM_STDY_EXSTS,
    :NEW.IND_PREV_FAM_STDY_RQSTD
  );
END;
/
/
DROP TRIGGER CAPS.TIBR_RESOURCE_HISTORY
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_RESOURCE_HISTORY
BEFORE INSERT
ON CAPS.RESOURCE_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
  dummy2    NUMBER;
  dummy_date  DATE;

BEGIN

-- 05/26/2001 MITSCHCG Added column DT_CCL_UPDATE for CLASS project SIR #15684

  :NEW.DT_LAST_UPDATE := SYSDATE;

  IF (:NEW.ID_RESOURCE_HISTORY = 0) OR
       (:NEW.ID_RESOURCE_HISTORY IS NULL) THEN
    SELECT  SEQ_RESOURCE_HISTORY.NEXTVAL
    INTO    dummy
    FROM    DUAL;
    :NEW.ID_RESOURCE_HISTORY := dummy;
  END IF;

  IF :NEW.DT_RSHS_END IS NULL THEN
    :NEW.DT_RSHS_END := TO_DATE('12/31/4712','MM/DD/YYYY');
  END IF;

  IF :NEW.ID_CASE  IS NULL THEN
    BEGIN
      SELECT  ID_CASE
      INTO    :NEW.ID_CASE
      FROM    STAGE
      WHERE    ID_STAGE = :NEW.ID_RSHS_FA_HOME_STAGE;
    EXCEPTION
      WHEN OTHERS THEN
        IF SQL%NOTFOUND THEN
          :NEW.ID_CASE := NULL;
        END IF;
    END;
  END IF;

  INSERT INTO RESOURCE_HISTORY_AUDIT (
    ID_RESOURCE_HISTORY_AUD,
    ID_AUD_RESOURCE,
    DT_RSHS_AUD_EFFECTIVE,
    DT_RSHS_AUD_CLOSE,
    DT_LAST_UPDATE,
    ID_CASE,
    DT_RSHS_AUD_CERT ,
    DT_RSHS_AUD_MARRIAGE,
    DT_RSHS_AUD_END,
    ADDR_RSHS_AUD_ST_LN_1,
    ADDR_RSHS_AUD_ST_LN_2,
    ADDR_RSHS_AUD_CITY,
    CD_RSHS_AUD_STATE,
    ADDR_RSHS_AUD_ZIP,
    ADDR_RSHS_AUD_ATTN,
    CD_RSHS_AUD_CNTY,
    CD_RSHS_AUD_INVOL_CLOSURE,
    CD_RSHS_AUD_CLOSURE_RSN,
    CD_RSHS_AUD_TYPE,
    CD_RSHS_AUD_HUB,
    CD_RSHS_AUD_CAMPUS_TYPE,
    CD_RSHS_AUD_SOURCE_INQUIRY,
    CD_RSHS_AUD_MAINTAINER,
    CD_RSHS_AUD_SCH_DIST,
    CD_RSHS_AUD_OWNERSHIP,
    CD_RSHS_AUD_STATUS,
    CD_RSHS_AUD_FACIL_TYPE,
    CD_RSHS_AUD_CERT_BY,
    CD_RSHS_AUD_OPER_BY,
    CD_RSHS_AUD_SETTING,
    CD_RSHS_AUD_PAYMENT,
    CD_RSHS_AUD_CATEGORY,
    CD_RSHS_AUD_ETHNICITY,
    CD_RSHS_AUD_LANGUAGE,
    CD_RSHS_AUD_MARITAL_STATUS,
    CD_RSHS_AUD_RECMND_REOPEN,
    CD_RSHS_AUD_REGION,
    CD_RSHS_AUD_RELIGION,
    CD_RSHS_AUD_RESPITE,
    CD_RSHS_AUD_FA_HOME_STATUS,
    CD_RSHS_AUD_FA_HOME_TYPE1   ,
    CD_RSHS_AUD_FA_HOME_TYPE2,
    CD_RSHS_AUD_FA_HOME_TYPE3,
    CD_RSHS_AUD_FA_HOME_TYPE4   ,
    CD_RSHS_AUD_FA_HOME_TYPE5,
    CD_RSHS_AUD_FA_HOME_TYPE6,
    CD_RSHS_AUD_FA_HOME_TYPE7,
                CD_RSHS_AUD_MHMR_COMP_CODE,
    ID_RSHS_AUD_FA_HOME_STAGE,
    ID_RSHS_AUD_FA_HOME_EVENT,
    IND_RSHS_AUD_CARE_PROV,
    IND_RSHS_AUD_INACTIVE,
    IND_RSHS_AUD_TRANSPORT,
    IND_RSHS_AUD_EMERG_PLACE,
    NM_RSHS_AUD_RESOURCE,
    NM_RSHS_AUD_CONTACT,
    NM_RSHS_AUD_LAST_UPDATE,
    NBR_RSHS_AUD_VID,
    NBR_RSHS_AUD_PHN,
    NBR_RSHS_AUD_FACIL_CAPACITY,
    NBR_RSHS_AUD_FACIL_ACCLAIM,
    NBR_RSHS_AUD_PHONE_EXT,
    NBR_RSHS_AUD_CAMPUS_NBR,
    NBR_RSHS_AUD_ANNUAL_INCOME,
    NBR_RSHS_AUD_FM_AGE_MAX,
    NBR_RSHS_AUD_FM_AGE_MIN,
    NBR_RSHS_AUD_MA_AGE_MAX,
    NBR_RSHS_AUD_MA_AGE_MIN,
    NBR_RSHS_AUD_INT_CHILDREN,
    NBR_RSHS_AUD_INT_FE_AGE_MAX ,
    NBR_RSHS_AUD_INT_FE_AGE_MIN,
    NBR_RSHS_AUD_INT_MA_AGE_MAX,
    NBR_RSHS_AUD_INT_MA_AGE_MIN,
    NBR_RSHS_AUD_OPEN_SLOTS,
    TXT_RSHS_AUD_ADDR_CMNTS,
    TXT_RSHS_AUD_COMMENTS,
    IND_RSHS_AUD_WRITE_AUDIT,
    DT_CCL_UPDATE,
    CD_RSRC_MHMR_SITE,
    IND_RSRC_CONTRACTED,
    NM_LEGAL,
    NM_RSRC_CONTACT_TITLE,
    NBR_RSRC_NTNL_PROVIDER,
    ADDR_RSRC_EMAIL,
    ADDR_RSRC_WEBSITE,
    CD_SCHOOL_TYPE,
    CD_PAYMENT_DELIVERY,
    TXT_SPEC_CERT,
    CD_EXCHANGE_STAT,
    IND_WAIVER,
    CD_SCH_DIST,
    CD_ELEM,
    CD_MIDDLE,
    CD_HIGH,
    DT_FOST_MANUAL,
    DT_FOST_BILL,
    IND_SPECIFIC_CHILD,
    DT_LIC_BEGIN,
    DT_LIC_END,
    TXT_CLOSURE_COMM,
    NDFCS_CERT_ENTITY,
    IND_RSRC_NONDFCS,
    IND_CURR_HM_STDY_EXSTS,
    IND_PREV_FAM_STDY_RQSTD
  ) VALUES (
    :NEW.ID_RESOURCE_HISTORY,
    :NEW.ID_RESOURCE,
    :NEW.DT_RSHS_EFFECTIVE,
    :NEW.DT_RSHS_CLOSE,
    :NEW.DT_LAST_UPDATE,
    :NEW.ID_CASE,
    :NEW.DT_RSHS_CERT,
    :NEW.DT_RSHS_MARRIAGE,
    :NEW.DT_RSHS_END,
    :NEW.ADDR_RSHS_ST_LN_1,
    :NEW.ADDR_RSHS_ST_LN_2,
    :NEW.ADDR_RSHS_CITY,
    :NEW.CD_RSHS_STATE,
    :NEW.ADDR_RSHS_ZIP,
    :NEW.ADDR_RSHS_ATTN,
    :NEW.CD_RSHS_CNTY,
    :NEW.CD_RSHS_INVOL_CLOSURE,
    :NEW.CD_RSHS_CLOSURE_RSN,
    :NEW.CD_RSHS_TYPE,
    :NEW.CD_RSHS_HUB,
    :NEW.CD_RSHS_CAMPUS_TYPE,
    :NEW.CD_RSHS_SOURCE_INQUIRY,
    :NEW.CD_RSHS_MAINTAINER,
    :NEW.CD_RSHS_SCH_DIST,
    :NEW.CD_RSHS_OWNERSHIP,
    :NEW.CD_RSHS_STATUS,
    :NEW.CD_RSHS_FACIL_TYPE,
    :NEW.CD_RSHS_CERT_BY,
    :NEW.CD_RSHS_OPER_BY,
    :NEW.CD_RSHS_SETTING,
    :NEW.CD_RSHS_PAYMENT,
    :NEW.CD_RSHS_CATEGORY,
    :NEW.CD_RSHS_ETHNICITY,
    :NEW.CD_RSHS_LANGUAGE,
    :NEW.CD_RSHS_MARITAL_STATUS,
    :NEW.CD_RSHS_RECMND_REOPEN,
    :NEW.CD_RSHS_REGION,
    :NEW.CD_RSHS_RELIGION,
    :NEW.CD_RSHS_RESPITE,
    :NEW.CD_RSHS_FA_HOME_STATUS,
    :NEW.CD_RSHS_FA_HOME_TYPE1,
    :NEW.CD_RSHS_FA_HOME_TYPE2,
    :NEW.CD_RSHS_FA_HOME_TYPE3,
    :NEW.CD_RSHS_FA_HOME_TYPE4,
    :NEW.CD_RSHS_FA_HOME_TYPE5,
    :NEW.CD_RSHS_FA_HOME_TYPE6,
    :NEW.CD_RSHS_FA_HOME_TYPE7,
                :NEW.CD_RSHS_MHMR_COMP_CODE,
    :NEW.ID_RSHS_FA_HOME_STAGE,
    :NEW.ID_RSHS_FA_HOME_EVENT,
    :NEW.IND_RSHS_CARE_PROV,
    :NEW.IND_RSHS_INACTIVE,
    :NEW.IND_RSHS_TRANSPORT,
    :NEW.IND_RSHS_EMERG_PLACE,
    :NEW.NM_RSHS_RESOURCE,
    :NEW.NM_RSHS_CONTACT,
    :NEW.NM_RSHS_LAST_UPDATE,
    :NEW.NBR_RSHS_VID,
    :NEW.NBR_RSHS_PHN,
    :NEW.NBR_RSHS_FACIL_CAPACITY,
    :NEW.NBR_RSHS_FACIL_ACCLAIM,
    :NEW.NBR_RSHS_PHONE_EXT,
    :NEW.NBR_RSHS_CAMPUS_NBR,
    :NEW.NBR_RSHS_ANNUAL_INCOME,
    :NEW.NBR_RSHS_FM_AGE_MAX,
    :NEW.NBR_RSHS_FM_AGE_MIN,
    :NEW.NBR_RSHS_MA_AGE_MAX,
    :NEW.NBR_RSHS_MA_AGE_MIN,
    :NEW.NBR_RSHS_INT_CHILDREN,
    :NEW.NBR_RSHS_INT_FE_AGE_MAX,
    :NEW.NBR_RSHS_INT_FE_AGE_MIN,
    :NEW.NBR_RSHS_INT_MA_AGE_MAX,
    :NEW.NBR_RSHS_INT_MA_AGE_MIN,
    :NEW.NBR_RSHS_OPEN_SLOTS,
    :NEW.TXT_RSHS_ADDR_CMNTS,
    :NEW.TXT_RSHS_COMMENTS,
    :NEW.IND_RSHS_WRITE_AUDIT ,
    :NEW.DT_CCL_UPDATE,
    :NEW.CD_RSRC_MHMR_SITE,
    :NEW.IND_RSRC_CONTRACTED,
    :NEW.NM_LEGAL,
    :NEW.NM_RSRC_CONTACT_TITLE,
    :NEW.NBR_RSRC_NTNL_PROVIDER,
    :NEW.ADDR_RSRC_EMAIL,
    :NEW.ADDR_RSRC_WEBSITE,
    :NEW.CD_SCHOOL_TYPE,
    :NEW.CD_PAYMENT_DELIVERY,
    :NEW.TXT_SPEC_CERT,
    :NEW.CD_EXCHANGE_STAT,
    :NEW.IND_WAIVER,
    :NEW.CD_SCH_DIST,
    :NEW.CD_ELEM,
    :NEW.CD_MIDDLE,
    :NEW.CD_HIGH,
    :NEW.DT_FOST_MANUAL,
    :NEW.DT_FOST_BILL,
    :NEW.IND_SPECIFIC_CHILD,
    :NEW.DT_LIC_BEGIN,
    :NEW.DT_LIC_END,
    :NEW.TXT_CLOSURE_COMM,
    :NEW.NDFCS_CERT_ENTITY,
    :NEW.IND_RSRC_NONDFCS,
    :NEW.IND_CURR_HM_STDY_EXSTS,
    :NEW.IND_PREV_FAM_STDY_RQSTD
  );
END;
/

DROP TABLE CAPS.RESOURCE_H_12152006160907000;
DROP TABLE CAPS.RESOURCE_H_12152006160908000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 257
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CFAHMTYP', 'BAS', 'Basic');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CFAHMTYP', 'EMG', 'Emergency');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CFAHMTYP', 'MED', 'Medically Fragile');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CFAHMTYP', 'RES', 'Respite');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CFAHMTYP', 'SFC', 'Specialized Foster Care');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES( 'CFAHMTYP', 'THR', 'Therapeutic');

DELETE FROM CAPS.CODES_TABLES  WHERE CODE_TYPE = 'CDFAHTP1' AND CODE = 'BAS' AND DECODE='Basic';
DELETE FROM CAPS.CODES_TABLES  WHERE CODE_TYPE = 'CDFAHTP2' AND CODE = 'EMG' AND DECODE='Emergency';
DELETE FROM CAPS.CODES_TABLES  WHERE CODE_TYPE = 'CDFAHTP3' AND CODE = 'MED' AND DECODE='Medically Fragile';
DELETE FROM CAPS.CODES_TABLES  WHERE CODE_TYPE = 'CDFAHTP4' AND CODE = 'RES' AND DECODE='Respite';
DELETE FROM CAPS.CODES_TABLES  WHERE CODE_TYPE = 'CDFAHTP5' AND CODE = 'SFC' AND DECODE='Specialized Foster Care';
DELETE FROM CAPS.CODES_TABLES  WHERE CODE_TYPE = 'CDFAHTP6' AND CODE = 'THR' AND DECODE='Therapeutic';

UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'B'  AND DECODE= 'Basic'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'H'  AND DECODE= 'Habilitative'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'P'  AND DECODE= 'Therapeutic'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'R'  AND DECODE= 'Primary Medical Need'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'U'  AND DECODE= 'Group'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'X'  AND DECODE= 'Kin Grandparent'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'Y'  AND DECODE= 'Kin Aunt/Uncle'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFAHMTYP' AND CODE= 'Z'  AND DECODE= 'Kin Other Family'; 

UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CRELIGNS' AND CODE= 'JW'  AND DECODE= 'Jehovah''s Witness'; 

-- change 258
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'AUS', 'Adopt US KIDS (AUK)', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'ADO', 'Adoption', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'EMB', 'EMBRACE', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'FOC', 'Foster Care', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'FOA', 'Foster-Adopt', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'FOH', 'Fostering Hope', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'GFC', 'Georgia’s Forgotten Children', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'MTN', 'My Turn Now', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'REL', 'Relative', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'WED', 'Wednesday’s Child', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CPRGMINT', 'XXX', 'Other', SYSDATE);

UPDATE CAPS.CODES_TABLES SET DT_END= SYSDATE, DT_LAST_UPDATE= SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='TLV';
UPDATE CAPS.CODES_TABLES SET DT_END= SYSDATE, DT_LAST_UPDATE= SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='WDC';
UPDATE CAPS.CODES_TABLES SET DT_END= SYSDATE, DT_LAST_UPDATE= SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='BB';

UPDATE CAPS.CODES_TABLES SET DECODE= 'Adopt US KIDS (AUK)', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='AUS';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Billboard', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='BIL';
UPDATE CAPS.CODES_TABLES SET DECODE= 'DFCS', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='DFC';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Fostering Hope', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='FOH';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Friend', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='FRI';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Georgia’s Forgotten Children', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='GFC';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Internet', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='INT';
UPDATE CAPS.CODES_TABLES SET DECODE= 'My Turn Now', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='MTN';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Other Foster Parents', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='OFP';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Poster', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='POS';
UPDATE CAPS.CODES_TABLES SET DECODE= 'RAC', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='RAC';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Radio Commercial', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='RAD';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Recruitment Event', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='REC';
UPDATE CAPS.CODES_TABLES SET DECODE= 'TV Commercial', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='TVC';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Wednesday’s Child', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='WED';
UPDATE CAPS.CODES_TABLES SET DT_END= NULL, DT_LAST_UPDATE=SYSDATE, DECODE= 'Children Awaiting Parents' WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'CAP';
UPDATE CAPS.CODES_TABLES SET DT_END= NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE='CFASRCIN' AND CODE='XXX';

DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE='CFASRCIN' AND CODE='ADO';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE='CFASRCIN' AND CODE='FOC';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE='CFASRCIN' AND CODE='FOA';

-- change 259
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE,DT_LAST_UPDATE) VALUES('CSECATTR','EM','Modify County Budget Limit',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE,DT_LAST_UPDATE) VALUES('CSECATTR','FA','Resubmit TCM Claims',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE,DT_LAST_UPDATE) VALUES('CSECATTR','FB','Maintain Region 3A',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE,DT_LAST_UPDATE) VALUES('CSECATTR','FC','Maintain Region 3B',SYSDATE);

-- change 260
INSERT INTO CAPS.SECURITY_CLASS(CD_SECURITY_CLASS_NAME,DT_LAST_UPDATE,TXT_SECURITY_CLASS_PROFIL,IND_RESTRICT,ID_PERSON_MODIFIED_BY) VALUES('SEC_FINANCE',SYSDATE,'000000000000000000000000000000011000000000000000000001011100001001001','N',1);

-- change 262
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60088,'MSG_CLIENT_SMILE', 'The Person ID entered is not a valid SMILE client and cannot be manually added to the invoice.', 500, 700, 'N');

-- change 265
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE CODE_TYPE = 'CFACTYP4';

-- change 267
UPDATE CAPS.CODES_TABLES SET DECODE = '552 - Sub. Guardianship and Enhanced Sub. Guardianship' WHERE CODE_TYPE ='CPRGCODE' AND CODE = '552'; 
UPDATE CAPS.CODES_TABLES SET DECODE = '574 - Spec. Foster Care - State Approved Per Diem Waivers' WHERE CODE_TYPE ='CPRGCODE' AND CODE = '574';

-- change 268
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFACTYP4','FAD','Foster/Adoptive Home', SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFACTYP4','CCI','Child Caring Institution',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFACTYP4','CPA','Child Placing Agency',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFACTYP4','SH','Speciality Hospital',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFACTYP4','OTC','Outdoor Therapeutic Camp',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFACTYP4','MH','Maternity HOme',SYSDATE); 

-- change 269
UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE = 'Location address values must be blank for DFCS Storage Locations' 
WHERE ID_MESSAGE ='17046';

UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE = 'Unit, Reg/Div, and Mail Code must be blank for Non-DFCS Storage Locations' 
WHERE ID_MESSAGE ='17055';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (118, 'SacwisRev2', 'static updates, add columns to Resource tables, Home applicant tables');

commit;

