
-- Standard Alter Table SQL

ALTER TABLE CAPS.CAPS_CARETAKER ADD DT_END DATE     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD IND_SPE_INVST_PLACE_PROV VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD IND_FOST_PRNT_NOTIFIED VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD DT_FOST_PRNT_NOTIFIED DATE     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD IND_ST_OFF_NOTIFY_RMV_CHILD VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD DT_ST_OFF_NOTIFY_RMV_CHILD DATE     NULL
;
ALTER TABLE CAPS.CPS_INVST_DETAIL ADD DT_ST_OFF_ADVICE_RMV_CHILD DATE     NULL
;
ALTER TABLE CAPS.RESOURCE_ADDRESS ADD NBR_RSRC_ADDR_LAT NUMBER(13)     NULL
;
ALTER TABLE CAPS.RESOURCE_ADDRESS ADD NBR_RSRC_ADDR_LONG NUMBER(13)     NULL
;


-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.PAYMENT_OF_CARE DROP CONSTRAINT FK_PAYMENT_OF_CARE_RESOURCE
;
ALTER TABLE CAPS.PAYMENT_OF_CARE DROP CONSTRAINT FK_PAYMT_OF_CARE_EVENT
;
ALTER TABLE CAPS.PAYMENT_OF_CARE DROP CONSTRAINT FK_POC_CM_PACK_CMP_PERSON
;
ALTER TABLE CAPS.PAYMENT_OF_CARE DROP CONSTRAINT FK_POC_RBWO_REV_AP_PERSON
;
ALTER TABLE CAPS.PAYMENT_OF_CARE DROP CONSTRAINT FK_POC_SO_APRV_PERSON
;
ALTER TABLE CAPS.PAYMENT_OF_CARE DROP CONSTRAINT FK_POC_SPV_PACK_APRV_PERSON
;
ALTER TABLE CAPS.PAYMENT_OF_CARE DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_PAYMENT_OF_CARE_2
;
DROP INDEX CAPS.IND_PAYMENT_OF_CARE_3
;
DROP INDEX CAPS.IND_PAYMENT_OF_CARE_4
;
DROP INDEX CAPS.IND_PAYMENT_OF_CARE_5
;
DROP INDEX CAPS.IND_PAYMENT_OF_CARE_1
;
ALTER TABLE CAPS.PAYMENT_OF_CARE RENAME TO PAYMENT_OF_03222007220258000
;
CREATE TABLE CAPS.PAYMENT_OF_CARE
(
    ID_POC_EVENT            NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE          DATE          NOT NULL,
    CD_POC_TYPE             VARCHAR2(3)       NULL,
    DT_START                DATE          NOT NULL,
    DT_END                  DATE              NULL,
    DT_TERMINATE            DATE              NULL,
    NBR_PER_DIEM            NUMBER(6,2)       NULL,
    NBR_SPEC_PER_DIEM       NUMBER(4,2)       NULL,
    IND_CONCURRENT          VARCHAR2(1)       NULL,
    TXT_CONCUR_P_DIEM       VARCHAR2(300)     NULL,
    TXT_SPEC_PER_DIEM       VARCHAR2(300)     NULL,
    IND_RBWO_TYPE           VARCHAR2(1)       NULL,
    DT_PACKET_COMP          DATE              NULL,
    ID_CM_PACKET_COMP       NUMBER(16)        NULL,
    DT_PACKET_APRV          DATE              NULL,
    ID_SPV_PACKET_APRV      NUMBER(16)        NULL,
    DT_PACKET_SENT          DATE              NULL,
    DT_STAFF_COMPL          DATE              NULL,
    DT_SO_RESP              DATE              NULL,
    ID_SO_APRV              NUMBER(16)        NULL,
    DT_RBWO_APRV            DATE              NULL,
    ID_RBWO_REV_APRV        NUMBER(16)        NULL,
    ID_RESOURCE             NUMBER(16)    NOT NULL,
    IND_RCS_TYPE            VARCHAR2(1)       NULL,
    DT_AGREEMENT            DATE              NULL,
    DT_ANN_REVIEW           DATE              NULL,
    DT_COURT                DATE              NULL,
    IND_INCOME              VARCHAR2(1)       NULL,
    IND_TERMINATE           VARCHAR2(1)       NULL,
    IND_SUSPEND             VARCHAR2(1)       NULL,
    TXT_TERMINATE           VARCHAR2(300)     NULL,
    AMT_SPEC_FC_RBWO_WAIVER NUMBER(7,2)       NULL
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
COMMENT ON TABLE CAPS.PAYMENT_OF_CARE IS
'Records details of a client''s payment of care details for paid placements'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.PAYMENT_OF_CARE TO CAPSBAT
;
GRANT INSERT ON CAPS.PAYMENT_OF_CARE TO CAPSBAT
;
GRANT SELECT ON CAPS.PAYMENT_OF_CARE TO CAPSBAT
;
GRANT UPDATE ON CAPS.PAYMENT_OF_CARE TO CAPSBAT
;
GRANT DELETE ON CAPS.PAYMENT_OF_CARE TO CAPSON
;
GRANT INSERT ON CAPS.PAYMENT_OF_CARE TO CAPSON
;
GRANT SELECT ON CAPS.PAYMENT_OF_CARE TO CAPSON
;
GRANT UPDATE ON CAPS.PAYMENT_OF_CARE TO CAPSON
;
GRANT SELECT ON CAPS.PAYMENT_OF_CARE TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.PAYMENT_OF_CARE(
                                 ID_POC_EVENT,
                                 DT_LAST_UPDATE,
                                 CD_POC_TYPE,
                                 DT_START,
                                 DT_END,
                                 DT_TERMINATE,
                                 NBR_PER_DIEM,
                                 NBR_SPEC_PER_DIEM,
                                 IND_CONCURRENT,
                                 TXT_CONCUR_P_DIEM,
                                 TXT_SPEC_PER_DIEM,
                                 IND_RBWO_TYPE,
                                 DT_PACKET_COMP,
                                 ID_CM_PACKET_COMP,
                                 DT_PACKET_APRV,
                                 ID_SPV_PACKET_APRV,
                                 DT_PACKET_SENT,
                                 DT_STAFF_COMPL,
                                 DT_SO_RESP,
                                 ID_SO_APRV,
                                 DT_RBWO_APRV,
                                 ID_RBWO_REV_APRV,
                                 ID_RESOURCE,
                                 IND_RCS_TYPE,
                                 DT_AGREEMENT,
                                 DT_ANN_REVIEW,
                                 DT_COURT,
                                 IND_INCOME,
                                 IND_TERMINATE,
                                 IND_SUSPEND,
                                 TXT_TERMINATE,
                                 AMT_SPEC_FC_RBWO_WAIVER
                                )
                          SELECT 
                                 ID_POC_EVENT,
                                 DT_LAST_UPDATE,
                                 CD_POC_TYPE,
                                 DT_START,
                                 DT_END,
                                 DT_TERMINATE,
                                 NBR_PER_DIEM,
                                 NBR_SPEC_PER_DIEM,
                                 IND_CONCURRENT,
                                 TXT_CONCUR_P_DIEM,
                                 TXT_SPEC_PER_DIEM,
                                 IND_RBWO_TYPE,
                                 DT_PACKET_COMP,
                                 ID_CM_PACKET_COMP,
                                 DT_PACKET_APRV,
                                 ID_SPV_PACKET_APRV,
                                 DT_PACKET_SENT,
                                 DT_STAFF_COMPL,
                                 DT_SO_RESP,
                                 ID_SO_APRV,
                                 DT_RBWO_APRV,
                                 ID_RBWO_REV_APRV,
                                 ID_RESOURCE,
                                 IND_RCS_TYPE,
                                 DT_AGREEMENT,
                                 DT_ANN_REVIEW,
                                 DT_COURT,
                                 IND_INCOME,
                                 IND_TERMINATE,
                                 IND_SUSPEND,
                                 TXT_TERMINATE,
                                 NULL
                            FROM CAPS.PAYMENT_OF_03222007220258000 
;
COMMIT
;
ALTER TABLE CAPS.PAYMENT_OF_CARE LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CONSTRAINT PK_PAYMENT_OF_CARE
PRIMARY KEY (ID_POC_EVENT)
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

CREATE INDEX CAPS.IND_PAYMENT_OF_CARE_2
    ON CAPS.PAYMENT_OF_CARE(ID_RBWO_REV_APRV)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_PAYMENT_OF_CARE_3
    ON CAPS.PAYMENT_OF_CARE(ID_RESOURCE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_PAYMENT_OF_CARE_4
    ON CAPS.PAYMENT_OF_CARE(ID_SO_APRV)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_PAYMENT_OF_CARE_5
    ON CAPS.PAYMENT_OF_CARE(ID_SPV_PACKET_APRV)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_PAYMENT_OF_CARE_1
    ON CAPS.PAYMENT_OF_CARE(ID_CM_PACKET_COMP)
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
DROP TRIGGER CAPS.TIBR_PAYMENT_OF_CARE
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PAYMENT_OF_CARE
BEFORE INSERT
ON CAPS.PAYMENT_OF_CARE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
DROP TRIGGER CAPS.TUBR_PAYMENT_OF_CARE
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PAYMENT_OF_CARE
BEFORE UPDATE
ON CAPS.PAYMENT_OF_CARE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CONSTRAINT FK_PAYMENT_OF_CARE_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;
ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CONSTRAINT FK_PAYMT_OF_CARE_EVENT
FOREIGN KEY (ID_POC_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CONSTRAINT FK_POC_CM_PACK_CMP_PERSON
FOREIGN KEY (ID_CM_PACKET_COMP)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CONSTRAINT FK_POC_RBWO_REV_AP_PERSON
FOREIGN KEY (ID_RBWO_REV_APRV)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CONSTRAINT FK_POC_SO_APRV_PERSON
FOREIGN KEY (ID_SO_APRV)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CONSTRAINT FK_POC_SPV_PACK_APRV_PERSON
FOREIGN KEY (ID_SPV_PACKET_APRV)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;

DROP TABLE CAPS.PAYMENT_OF_03222007220258000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001785
-- New task codes for Contact events related to new stages
-- > DIV stage
INSERT INTO CAPS.TASK
(CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE,
IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING,
IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE,
TXT_1ST_TAB, TXT_2ND_TAB, TXT_EVENT_DETAIL_URL,
IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE,
CD_TASK_LIST_WINDOW, CD_TASK_TOP_WINDOW)
VALUES
('1510', 'CON', 'DIV', 'CPS', '1',
'1', '1', '1', '0',
'0', '0', '1', 'Contacts/Summaries',
'CASE_CASESEARCH', 'CONTACTS_SUMMARIES_CONTACTSEARCH', '/contacts/ContactSearchListDetail/displayContact',
2, '1', '0', '0',
'CSYS11W', 'CSYS10W');

-- > PFC stage
INSERT INTO CAPS.TASK
(CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE,
IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING,
IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE,
TXT_1ST_TAB, TXT_2ND_TAB, TXT_EVENT_DETAIL_URL,
IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE,
CD_TASK_LIST_WINDOW, CD_TASK_TOP_WINDOW)
VALUES
('6530', 'CON', 'PFC', 'CPS', '1',
'1', '1', '1', '0',
'0', '0', '1', 'Contacts/Summaries',
'CASE_CASESEARCH', 'CONTACTS_SUMMARIES_CONTACTSEARCH', '/contacts/ContactSearchListDetail/displayContact',
2, '1', '0', '0',
'CSYS11W', 'CSYS10W');

-- change STGAP00001787
-- Method of Age Verification
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','ABC','US Birth Certificate',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','AHC','Hospital Certificate',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','ABP','Baptismal Certificate',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','ANC','Naturalization/Citizenship Certificate',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','ACF','Birth Certificate (Foreign)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','AUS','Passport (US)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','ARC','Permanent Resident Card',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CAGEVERF','AEC','Evaluative Conclusion',SYSDATE);

-- Method of Citizenship Verification
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','CBC','US Birth Certificate',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCITIZEN','COC','Certificate of Citizenship (N-560)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','RBH','Record of Birth in US Hospital',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','CID','US Citizen ID Card (I-197 or 179)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','FAD','Final Adoption decree',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','RBA','Report of Birth Abroad/U.S Citizen (FS-240)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','MRS','Official military record of service showing a US place of birth',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','EHR','Extract of US hospital record of birth (created at least 5 years ago)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','CBR','Census Bureau records of Birth/Parentage',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','CRB','Certification of Report of Birth (DS1350)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','NCF','Naturalization Certificate (Foreign)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','USP','US Passport',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','AIC','American Indian Card (Issued by INS)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','CSE','Evidence of civil service employment by US Government',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','NMC','Northern Mariana ID Card',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','BVS','Bureau of Vital Statistics record of Birth/Parentage',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','COB','Confirmation of Birth',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','LHI','Life, Health, or other insurance record showing US place of birth (created at least 5 years ago)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','MRB','Medical Records of Birth/Parentage (created at least 5 years ago)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CCERTVER','ECN','Evaluative Conclusion',SYSDATE);

-- Identity Verification (Adult)
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTAD','CDL','Current driver’s license or state ID bearing picture',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTAD','IDD','Any Identity document described in section 274A of the immigration and Nationality Act',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTAD','CIB','Certificate of Indian Blood',SYSDATE);

-- Identity Verification (Under 16 Only)
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTUN','SIP','School ID with photograph',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTUN','SRD','School record showing date and place of birth of parents',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTUN','DNS','Daycare or nursery school record showing date and place of birth',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTUN','MID','Military dependent ID with photograph',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTUN','CDH','Clinic, doctor, or hospital record showing date of birth',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CIDENTUN','ACI','Affidavit signed under penalty or perjury by a parent or guardian attesting to the child''s identity',SYSDATE);

-- Permanent Resident/Refugee
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CPERMRES','ARR','Alien Registration Receipt Card/I-551 (green card)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CPERMRES','REF','Refugee (I-94)',SYSDATE);

-- Other Qualified Alien
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('COTHRQUA','DRA','Document Reviewed by Attorney',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('COTHRQUA','STV','Student Visa',SYSDATE);

-- Undetermined/Other Alien
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CUDETALN','FBC','Foreign Birth Certificate/Record',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CUDETALN','NDC','No documents',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CUDETALN','CUS','Child found in US under age five, parents unknown',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CUDETALN','UIM','Undocumented Immigrant',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CUDETALN','FOS','Foreign/Other documents - Status unclear',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CUDETALN','LIS','Legal Immigration Status Expired',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update)
VALUES('CUDETALN','UMC','Unaccompanied Minor Child',SYSDATE);

-- change STGAP00001788
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'You have indicated that the judicial determination ''Reasonable Efforts were made to Prevent Removal'' did NOT occur within 60 days of the child''s court-ordered removal from the home. However, the judicial determination date you entered is less than 60 days from the date of the first order of removal.' where TXT_MESSAGE_NAME 
  = 'MSG_FC_TIMEFRAME_INVALID2';
  
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'You have indicated that the judicial determination ''Reasonable Efforts were made to Prevent Removal'' occurred within 60 days of the child''s court-ordered removal from the home. However, the judicial determination date you entered is greater than 60 days from the date of the first order of removal.' where TXT_MESSAGE_NAME 
  = 'MSG_FC_TIMEFRAME_INVALID1';
  
-- change STGAP00001789
UPDATE CAPS.METAPHOR 
SET TXT_FILTER_PATH = 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.PersonDtlShowTab'
WHERE ID_TAB =1570;

-- change STGAP00001796
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','58885a','350.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','58885b','350.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','58886','700.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57372','3000.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57372a','50.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57372b','40.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57372c','200.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57372e','400.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','51871','7500.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','51895a','5000.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','52148e','1500.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','52148f','500.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','55179','500.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57129c','75.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57161d','75.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57161e','400.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57161f','200.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57161g','75.00',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSBGTLMT','57162','100.00',SYSDATE);

-- change STGAP00001798
-- This script end-dates all the "keyed" codes from CCNTPURP and COTHCNCT and inserts new
-- values to be used from now on.  This is a safer approach than DBCR 1784.
-- CCNTPURP "Purpose"
-- CCNTPURP decode modifications
UPDATE CAPS.CODES_TABLES SET DECODE = 'Invited Person to Orientation' WHERE code_type = 'CCNTPURP' AND code = 'IPO';

-- Keys no longer needed, end-date the unused "keyed" values
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2006' WHERE code_type = 'CCNTPURP' AND code LIKE 'D%' AND code <> 'DSR';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2006' WHERE code_type = 'CCNTPURP' AND code LIKE 'K%';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2006' WHERE code_type = 'CCNTPURP' AND code LIKE 'B%';

-- Insert new "un-keyed" values to use from now on
-- 3 useful values already exist (CMC, DSR, IPO) plus 39 inserts = 42 total
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'ACS', 'Adoption - Child Specific Interview', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'CDR', 'Child Daily Routine', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'CPL', 'Case Planning', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'CPR', 'Child Preparation', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'CRP', 'Child Religious Practices', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'CRT', 'Court Action', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'CSA', 'Child Special Skills/Achievements', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'CVS', 'Collateral', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'DIL', 'Diligent Search', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'FAC', 'Facility Visit', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'FBF', 'Foster Parent/Biological Family', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'FMI', 'Family Moves During Investigation', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'FTM', 'Family Team Meeting', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'HAS', 'Home Assessment', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'INP', 'Initial Placement', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'LAW', 'Law Enforcement', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'LEG', 'Legal Trial Preparation', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'MDT', 'MDT', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'MED', 'Medical', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'MON', 'Monitoring', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'NOT', 'Notification', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'PCN', 'Placement', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'PCV', 'Parent Child Visit', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'PPL', 'Pre-Placement', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'RAS', 'Risk Assessment', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'RVW', 'Review', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SIA', 'SI - Administrative Review Packet', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SIB', 'Sibling Visit', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SIS', 'Special Investigation - 48 Hour Staffing', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SNR', 'SI Home Visit - Child in Non-Residential Facility', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SPA', 'SI Home Visit - Child in Private Agency', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SPP', 'SI School Visit - Children in Private or Public School', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SRE', 'Safety Resource', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SRF', 'SI Home Visit - Child in Residential Facility', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SSO', 'SI Home Visit - Child in State Operated Home', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'STF', 'Staffed Case', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'SUP', 'Supervisor Review', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'XSI', 'Special Investigation', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTPURP', 'XXX', 'Other', SYSDATE);

-- COTHCNCT "Others Contacted"

-- Keys no longer needed, end-date the unused "keyed" values
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2006' WHERE code_type = 'COTHCNCT' AND code LIKE 'D%';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2006' WHERE code_type = 'COTHCNCT' AND code LIKE 'K%';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2006' WHERE code_type = 'COTHCNCT' AND code LIKE 'B%';

-- Insert new "un-keyed" values to use from now on; 38 total
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'ADP', 'Adoptive Parent', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'CAS', 'CASA', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'CNS', 'Counselor', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'COR', 'Coroner', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'CRT', 'Court', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'DCP', 'Day Care Provider', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'DHR', 'DHR Staff', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'EDU', 'Educator', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'EMP', 'Employer', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'FAC', 'Facility Director/Supervisor', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'FIW', 'FIW Worker', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'FOS', 'Foster Parent', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'GAL', 'GAL', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'HED', 'Health Department', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'INC', 'Indian Custodian', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'IND', 'Indian Tribe/Council', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'JUV', 'Juvenile Probation', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'LAW', 'Law Enforcement', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'LEG', 'Legal', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'LIC', 'Licensing Authority', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'LRA', 'Landlord/Rental Agency', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'MED', 'Medical', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'MHE', 'Mental Hlth Examiner', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'MHM', 'MHMR Director', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'NEI', 'Neighbor', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'OFF', 'State Office', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'ORS', 'ORS Staff', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'OTR', 'Other Relative', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'PRV', 'Service Provider', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'SAG', 'SAAG', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'SCH', 'School Board', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'SCL', 'School Counselor', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'SOI', 'Bureau of Indian Affairs', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'SPR', 'School Principal', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'SSW', 'School Social Worker', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'SUP', 'Superintendent', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'TCH', 'Teacher', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COTHCNCT', 'USP', 'U.S.P.S', SYSDATE);

-- CCNTMETH "Method" decode modifications
UPDATE CAPS.CODES_TABLES SET DECODE = 'N/A' WHERE code_type = 'CCNTMETH' AND code = 'INA';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Interested/Still Considering' WHERE code_type = 'CCNTMETH' AND code = 'ISC';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Left Message' WHERE code_type = 'CCNTMETH' AND code = 'LEM';
UPDATE CAPS.CODES_TABLES SET DECODE = 'No Answer' WHERE code_type = 'CCNTMETH' AND code = 'NOA';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Not Interested' WHERE code_type = 'CCNTMETH' AND code = 'NOI';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Phone Disconnected' WHERE code_type = 'CCNTMETH' AND code = 'PHD';


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (140, 'SacwisRev2', 'static updates, schema changes');
                         
commit;
