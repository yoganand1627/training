
-- Standard Alter Table SQL

ALTER TABLE CAPS.OUTPUT_LAUNCH_EVENT_LINK ADD IND_CURRENT VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PLACEMENT ADD CD_PLCMT_ADPT_BY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PLACEMENT ADD TXT_ADO_CMNTS VARCHAR2(500)     NULL
;

-- Drop Referencing Constraint SQL


-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.PGM_LCNSRE_TYPS DROP CONSTRAINT FK_PGM_LCNSRE_TYPS_LOC
;
ALTER TABLE CAPS.PGM_LCNSRE_TYPS DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_PGM_LCNSRE_TYPS_1
;
ALTER TABLE CAPS.PGM_LCNSRE_TYPS RENAME TO PGM_LCNSRE_04262007211039000
;
CREATE TABLE CAPS.PGM_LCNSRE_TYPS
(
    ID_LCNSRE_TYPS NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE DATE        NOT NULL,
    CD_PGM_TYPE    VARCHAR2(3)     NULL,
    ID_RESOURCE    NUMBER(16)  NOT NULL
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
COMMENT ON TABLE CAPS.PGM_LCNSRE_TYPS IS
'Stores Program licensure Types for Facility Detail.'
;
COMMENT ON COLUMN CAPS.PGM_LCNSRE_TYPS.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.PGM_LCNSRE_TYPS TO CAPSBAT
;
GRANT INSERT ON CAPS.PGM_LCNSRE_TYPS TO CAPSBAT
;
GRANT SELECT ON CAPS.PGM_LCNSRE_TYPS TO CAPSBAT
;
GRANT UPDATE ON CAPS.PGM_LCNSRE_TYPS TO CAPSBAT
;
GRANT DELETE ON CAPS.PGM_LCNSRE_TYPS TO CAPSON
;
GRANT INSERT ON CAPS.PGM_LCNSRE_TYPS TO CAPSON
;
GRANT SELECT ON CAPS.PGM_LCNSRE_TYPS TO CAPSON
;
GRANT UPDATE ON CAPS.PGM_LCNSRE_TYPS TO CAPSON
;
GRANT SELECT ON CAPS.PGM_LCNSRE_TYPS TO OPERATOR
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_AUDIT_2
;
DROP INDEX CAPS.IND_RESOURCE_HISTORY_AUDIT_1
;
DROP INDEX CAPS.IND_REC_RTN_91
;
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT RENAME TO RESOURCE_H_04262007211041000
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
    CD_RSHS_AUD_FA_HOME_TYPE1   VARCHAR2(3)       NULL,
    CD_RSHS_AUD_FA_HOME_TYPE2   VARCHAR2(3)       NULL,
    CD_RSHS_AUD_FA_HOME_TYPE3   VARCHAR2(3)       NULL,
    CD_RSHS_AUD_FA_HOME_TYPE4   VARCHAR2(3)       NULL,
    CD_RSHS_AUD_FA_HOME_TYPE5   VARCHAR2(3)       NULL,
    CD_RSHS_AUD_FA_HOME_TYPE6   VARCHAR2(3)       NULL,
    CD_RSHS_AUD_FA_HOME_TYPE7   VARCHAR2(3)       NULL,
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
    TXT_RSHS_AUD_ADDR_CMNTS     VARCHAR2(300)     NULL,
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
    CD_ELEM                     VARCHAR2(10)      NULL,
    CD_MIDDLE                   VARCHAR2(10)      NULL,
    CD_HIGH                     VARCHAR2(10)      NULL,
    DT_FOST_MANUAL              DATE              NULL,
    DT_FOST_BILL                DATE              NULL,
    IND_SPECIFIC_CHILD          VARCHAR2(1)       NULL,
    DT_LIC_BEGIN                DATE              NULL,
    DT_LIC_END                  DATE              NULL,
    TXT_CLOSURE_COMM            VARCHAR2(300)     NULL,
    NDFCS_CERT_ENTITY           VARCHAR2(30)      NULL,
    IND_RSRC_NONDFCS            VARCHAR2(1)       NULL,
    IND_CURR_HM_STDY_EXSTS      VARCHAR2(1)       NULL,
    IND_PREV_FAM_STDY_RQSTD     VARCHAR2(1)       NULL,
    RSRC_OTH_SPC_CERTF          VARCHAR2(50)      NULL,
    ID_RESOURCE_HISTORY_AUDIT   NUMBER(16)    NOT NULL
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
INSERT INTO CAPS.PGM_LCNSRE_TYPS(
                                 ID_LCNSRE_TYPS,
                                 DT_LAST_UPDATE,
                                 CD_PGM_TYPE,
                                 ID_RESOURCE
                                )
                          SELECT 
                                 ID_LCNSRE_TYPS,
                                 DT_LAST_UPDATE,
                                 CD_PGM_TYPE,
                                 0
                            FROM CAPS.PGM_LCNSRE_04262007211039000 
;
COMMIT
;
ALTER TABLE CAPS.PGM_LCNSRE_TYPS LOGGING
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
                                        IND_PREV_FAM_STDY_RQSTD,
                                        RSRC_OTH_SPC_CERTF,
                                        ID_RESOURCE_HISTORY_AUDIT
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
                                        NDFCS_CERT_ENTITY,
                                        IND_RSRC_NONDFCS,
                                        IND_CURR_HM_STDY_EXSTS,
                                        IND_PREV_FAM_STDY_RQSTD,
                                        RSRC_OTH_SPC_CERTF,
                                        CAPS.SEQ_RESOURCE_HISTORY_AUDIT.NEXTVAL
                                   FROM CAPS.RESOURCE_H_04262007211041000 
;
COMMIT
;
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.PGM_LCNSRE_TYPS ADD CONSTRAINT PK_PGM_LCNSRE_TYPS
PRIMARY KEY (ID_LCNSRE_TYPS)
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
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT ADD CONSTRAINT PK_RSRC_HISTORY_AUDIT
PRIMARY KEY (ID_RESOURCE_HISTORY_AUDIT)
USING INDEX TABLESPACE INDEX01
            STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
;

-- Add Indexes SQL

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
DROP TRIGGER CAPS.TIBR_RESOURCE_HISTORY_AUDIT
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_RESOURCE_HISTORY_AUDIT
BEFORE INSERT
ON CAPS.RESOURCE_HISTORY_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
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
/
DROP TRIGGER CAPS.TIBR_PGM_LCNSRE_TYPS
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PGM_LCNSRE_TYPS
BEFORE INSERT
ON CAPS.PGM_LCNSRE_TYPS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:NEW.ID_LCNSRE_TYPS IS NULL OR :new.ID_LCNSRE_TYPS = 0) THEN
    SELECT  SEQ_PGM_LCNSRE_TYPS.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :new.ID_LCNSRE_TYPS := dummy;
  END IF;
END;
/
/
DROP TRIGGER CAPS.TUBR_PGM_LCNSRE_TYPS
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PGM_LCNSRE_TYPS
BEFORE UPDATE
ON CAPS.PGM_LCNSRE_TYPS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/


-- Alter Index SQL

CREATE INDEX CAPS.IND_PGM_LCNSRE_TYPS_1
    ON CAPS.PGM_LCNSRE_TYPS(ID_RESOURCE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.PGM_LCNSRE_TYPS ADD CONSTRAINT FK_PGM_LCNSRE_TYPS_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;

-- Alter Trigger SQL
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
    ID_RESOURCE_HISTORY_AUDIT,
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
    IND_PREV_FAM_STDY_RQSTD,
    RSRC_OTH_SPC_CERTF
  ) VALUES (
    0,
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
    :NEW.IND_PREV_FAM_STDY_RQSTD,
    :New.RSRC_OTH_SPC_CERTF
  );
END;
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
    ID_RESOURCE_HISTORY_AUDIT,
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
    IND_PREV_FAM_STDY_RQSTD,
    RSRC_OTH_SPC_CERTF
  ) VALUES (
    0,
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
    :NEW.IND_PREV_FAM_STDY_RQSTD,
    :New.RSRC_OTH_SPC_CERTF
  );
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_RESOURCE_HISTORY_AUDIT
BEFORE INSERT
ON CAPS.RESOURCE_HISTORY_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:NEW.ID_RESOURCE_HISTORY_AUDIT = 0) OR
       (:NEW.ID_RESOURCE_HISTORY_AUDIT IS NULL) THEN
    SELECT  SEQ_RESOURCE_HISTORY_AUDIT.NEXTVAL
    INTO    dummy
    FROM    DUAL;
    :NEW.ID_RESOURCE_HISTORY_AUDIT := dummy;
  END IF;

END;
/

DROP TABLE CAPS.RESOURCE_H_04262007211041000;
DROP TABLE CAPS.PGM_LCNSRE_04262007211039000 ;

alter system set open_cursors=500;

--
delete from caps.policy_link;

-- change STGAP00002089
delete from CAPS.DOCUMENT_TEMPLATE;
delete from CAPS.DOCUMENT_TEMPLATE_TYPE;
drop sequence CAPS.SEQ_DOCUMENT_TEMPLATE;
drop sequence CAPS.SEQ_DOCUMENT_TEMPLATE_TYPE;
CREATE SEQUENCE CAPS.SEQ_DOCUMENT_TEMPLATE
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;
CREATE SEQUENCE CAPS.SEQ_DOCUMENT_TEMPLATE_TYPE
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00002004
UPDATE CAPS.CODES_TABLES 
SET DT_END = TO_DATE('01/01/2007','MM/DD/YYYY')
WHERE CODE_TYPE = 'CLEGCPS'
AND CODE = 'VOL';

UPDATE CAPS.CODES_TABLES 
SET DT_END = TO_DATE('01/01/2007','MM/DD/YYYY')
WHERE CODE_TYPE ='CLEGCPS'
AND CODE = 'VAP';

UPDATE CAPS.CODES_TABLES 
SET DT_END = TO_DATE('01/01/2007','MM/DD/YYYY')
WHERE CODE_TYPE = 'CLHECOT'
AND CODE = 'TPR';

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) 
VALUES('CLEGCPS','VLM','Voluntary Surrrender-Mother',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) 
VALUES('CLEGCPS','VAM','Voluntary Surrender by Adoptive Mother',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) 
VALUES('CLEGCPS','VLF','Voluntary Surrrender-Father',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) 
VALUES('CLEGCPS','VAF','Voluntary Surrender by Adoptive Father',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) 
VALUES('CLHECOT','TPM','TPR-Mother',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) 
VALUES('CLHECOT','TPF','TPR-Father',SYSDATE);

-- change STGAP00002079
--common application
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'COM');
delete from caps.task where cd_Task_event_type = 'COM';
--approval for common app
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('9330','3350','8840'));
delete from caps.task where cd_task in ('9330','3350','8840');
--level of care/service level
delete from caps.error_list where cd_task in (
select cd_task from caps.task where  cd_Task_event_type = 'LOC');
delete from caps.task where  cd_Task_event_type = 'LOC';
--child background summary
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'CBS');
delete from caps.task where cd_Task_event_type = 'CBS';
--approval for child background summary
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('8900','9390','3410'));
delete from caps.task where cd_task in ('8900','9390','3410');
--medical developmental history
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'MDH');
delete from caps.task where cd_Task_event_type = 'MDH';
--approval for medical developmental history
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('3360','8850','9340'));
delete from caps.task where cd_task in ('3360','8850','9340');

--make third level task for service authorization
update caps.task
set txt_3rd_tab = 'SERVICE_AUTHORIZATION_3_EVENTLIST',
ind_task_code_prefer = '3'
where cd_task in ('5640','2310','9020','3020','8530','3520','4190','7100');

--quarterly assessment
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'QAS');
delete from caps.task where cd_Task_event_type = 'QAS';
--approval of quarterly assessment
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('8230'));
delete from caps.task where cd_task in ('8230');
--variance
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'VRN');
delete from caps.task where cd_Task_event_type = 'VRN';
--approval of variance
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('8290'));
delete from caps.task where cd_task in ('8290');
--violation
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'VLT');
delete from caps.task where cd_Task_event_type = 'VLT';
--approval of violation
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('8280'));
delete from caps.task where cd_task in ('8280');
--serious incident
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'SRI');
delete from caps.task where cd_Task_event_type = 'SRI';
--approval of serious incident
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('8270'));
delete from caps.task where cd_task in ('8270');
--corrective action plan
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'CRA');
delete from caps.task where cd_Task_event_type = 'CRA';
--approval of corrective action plan
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('8260'));
delete from caps.task where cd_task in ('8260');

--update text
update caps.task 
set txt_task_decode = 'Close Foster Care Child Stage'
where cd_task = 3270;
--update text
update caps.task 
set txt_task_decode = 'Approve Foster Care Child Stage Closure'
where cd_task = 3240;

--developmental plan
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_Task_event_type = 'DVP');
delete from caps.task where cd_Task_event_type = 'DVP';
--approval of serious incident
delete from caps.error_list where cd_task in (
select cd_task from caps.task where cd_task in ('8250'));
delete from caps.task where cd_task in ('8250');
--all FRE tasks
delete from caps.error_list where cd_task in (
select cd_task FROM caps.TASK WHERE cd_task_stage = 'FRE');
delete FROM caps.TASK WHERE cd_task_stage = 'FRE';
 --all PAL tasks
delete from caps.error_list where cd_task in (
select cd_task FROM caps.TASK WHERE cd_task_stage = 'PAL');
delete FROM caps.TASK WHERE cd_task_stage = 'PAL';
--all AOC tasks
delete from caps.error_list where cd_task in (
select cd_task FROM caps.TASK WHERE cd_task_stage = 'AOC');
delete FROM caps.TASK WHERE cd_task_stage = 'AOC';
--all APS tasks
delete from caps.error_list where cd_task in (
select cd_task FROM caps.TASK WHERE cd_task_stage_program = 'APS');
delete FROM caps.TASK WHERE cd_task_stage_program = 'APS';
--all CCL tasks
delete from caps.error_list where cd_task in (
select cd_task FROM caps.TASK WHERE cd_task_stage_program = 'CCL');
delete FROM caps.TASK WHERE cd_task_stage_program = 'CCL';
--all RCL tasks
delete from caps.error_list where cd_task in (
select cd_task FROM caps.TASK WHERE cd_task_stage_program = 'RCL');
delete FROM caps.TASK WHERE cd_task_stage_program = 'RCL';
--all AFC tasks
delete from caps.error_list where cd_task in (
select cd_task FROM caps.TASK WHERE cd_task_stage_program = 'AFC');
delete FROM caps.TASK WHERE cd_task_stage_program = 'AFC';


-- change STGAP00002080
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'You have indicated the child has a Personal Savings account outside of DFCS.  Please add a resource of type "Savings Account."' where TXT_MESSAGE_NAME 
  = 'MSG_CHILDS_SAVINGS_ACCOUNT_REQ' ; 
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'The question Does the child have a Personal Savings account outside of DFCS? must be answered.' where TXT_MESSAGE_NAME 
  = 'MSG_PERSONAL_SVG_REQ' ;

-- change STGAP00002081
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60314, 'MSG_DT_TSK_COMP_REQ', 'The Goals can not be marked complete until all the tasks are either marked complete or if the task is closed and a court mandated closure date is entered.', '560', '700', 'N');

-- change STGAP00002082
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPRGCOD1','551','551 - Early Intervention and Prevention Services',SYSDATE);

-- change STGAP00002085
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE)
VALUES ('60315', 'MSG_COPY_DILSEARCH', 'Cannot copy a contact for the current Child.');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (163, 'SacwisRev2', 'static updates, schema changes');   

commit;



