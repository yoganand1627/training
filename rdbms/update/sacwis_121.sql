
-- Standard Alter Table SQL

ALTER TABLE CAPS.ADO_INFO MODIFY(ID_RESOURCE   NULL)
;
ALTER TABLE CAPS.CPS_INVST_DETAIL MODIFY(CD_ABUSE_STATUS  VARCHAR2(3))
;
ALTER TABLE CAPS.FAMILY_PLAN DROP (NM_ASSGN_JUDGE,IND_INIT_REVIEW,DT_ORIG_SUB,DT_PREV_REV,DT_CURR_REV,CD_PRIM_PERM_PLAN,TXT_PRIM_COMP_RSNS,CD_SECND_PERM_PLAN,TXT_SECND_COMP_RSNS,CD_REV_TYP,TXT_RSNS_PROT,TXT_HARM,DT_PERM_ACHVD,IND_PRNT_PRTCPT,TXT_PRNT_PRTCPT,IND_CHILD_PRTCPT,TXT_CHILD_PRTCPT,IND_PRNT_PRESENT,IND_HEARING_SUB,DT_HEARING_REQSTD,IND_ASSTNC)
;

-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.FCCP_FAMILY
(
    ID_EVENT                 NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE           DATE          NOT NULL,
    ID_CASE                  NUMBER(16)    NOT NULL,
    CD_PLAN_TYPE             VARCHAR2(3)       NULL,
    NM_ASSGN_JUDGE           VARCHAR2(30)      NULL,
    IND_INIT_REVIEW          VARCHAR2(1)       NULL,
    DT_INIT_DUE              DATE              NULL,
    DT_ORIG_SUB              DATE              NULL,
    DT_PREV_REV              DATE              NULL,
    DT_CURR_REV              DATE              NULL,
    DT_NEXT_REV              DATE              NULL,
    CD_PRIM_PERM_PLAN        VARCHAR2(3)       NULL,
    TXT_PRIM_COMP_RSNS       VARCHAR2(300)     NULL,
    CD_SECND_PERM_PLAN       VARCHAR2(3)       NULL,
    TXT_SECND_COMP_RSNS      VARCHAR2(300)     NULL,
    CD_REV_TYP               VARCHAR2(3)       NULL,
    TXT_RSNS_PROT            VARCHAR2(300)     NULL,
    TXT_HARM                 VARCHAR2(300)     NULL,
    DT_PERM_ACHVD            DATE              NULL,
    IND_PRNT_PRTCPT          VARCHAR2(1)       NULL,
    TXT_PRNT_PRTCPT          VARCHAR2(300)     NULL,
    IND_CHILD_PRTCPT         VARCHAR2(1)       NULL,
    TXT_CHILD_PRTCPT         VARCHAR2(300)     NULL,
    IND_PRNT_PRESENT         VARCHAR2(1)       NULL,
    IND_HEARING_SUB          VARCHAR2(1)       NULL,
    DT_HEARING_REQSTD        DATE              NULL,
    IND_ASSTNC               VARCHAR2(1)       NULL,
    DT_BEGIN_AFTERCARE       DATE              NULL,
    DT_END_AFTERCARE         DATE              NULL,
    TXT_RSN_DSCHRG_AFTERCARE VARCHAR2(300)     NULL,
    CONSTRAINT PK_FCCP_FAMILY
    PRIMARY KEY (ID_EVENT)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.FCCP_FAMILY IS
'Foster Care Case Plan Family Detail information'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.FCCP_FAMILY TO CAPSBAT
;
GRANT INSERT ON CAPS.FCCP_FAMILY TO CAPSBAT
;
GRANT SELECT ON CAPS.FCCP_FAMILY TO CAPSBAT
;
GRANT UPDATE ON CAPS.FCCP_FAMILY TO CAPSBAT
;
GRANT DELETE ON CAPS.FCCP_FAMILY TO CAPSON
;
GRANT INSERT ON CAPS.FCCP_FAMILY TO CAPSON
;
GRANT SELECT ON CAPS.FCCP_FAMILY TO CAPSON
;
GRANT UPDATE ON CAPS.FCCP_FAMILY TO CAPSON
;
GRANT SELECT ON CAPS.FCCP_FAMILY TO OPERATOR
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.FCCP_FAMILY 
    ADD CONSTRAINT FK_FFCP_FAMILY_CASE
FOREIGN KEY (ID_CASE)
REFERENCES CAPS.CAPS_CASE (ID_CASE)
ENABLE
;
ALTER TABLE CAPS.FCCP_FAMILY 
    ADD CONSTRAINT FK_FFCP_FAMILY_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_FCCP_FAMILY
BEFORE UPDATE
ON CAPS.FCCP_FAMILY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_FCCP_FAMILY
BEFORE INSERT
ON CAPS.FCCP_FAMILY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 296

INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NCR','Child has been removed from the home on at least 2 previous occasions and reunification services were made available on those occasions',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NVS','Parent has voluntarily surrendered his/her parental rights to the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NAB','Parent has abandoned the child, the identity of the parents cannot be ascertained despite diligent searching or the parent has failed to come forward and claim the child within 3 months',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NDC','The child is a deprived child. The deprivation is current, would continue without DFCS intervention and is caused by the parent. The continued deprivation would likely cause serious physical, mental, emotional, or moral harm to the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NMD','A medically verifiable deficiency of the parents physical, mental, or emotional health of such duration or nature renders the parent unable to provide adequately for the physical, mental, and emotional, or moral condition and needs of the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NPD','Excessive use of or history of chronic unrehabilitated use of intoxicating liquors or drugs has the effect of rendering the parent incapable of providing adequately for the physical, mental, emotional, or moral condition and needs of the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NCV','Conviction of the parent of a felony and imprisonment which has a demonstrable negative effect on the quality of the parent-child relationship',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NEC','Egregious conduct or evidence of past egregious conduct of the parent toward the child or another child of a physically, emotionally, or sexually cruel or abusive nature, including murder;to commit murder or voluntary manslaughter of a child; committing a felony assault that results in serious harm to a child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NPN','Physical, mental, or emotional neglect of the child or evidence of past physical, mental, or emotional neglect of the child or of another child by the parent',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NID','Injury or death of a sibling under circumstances which constitute substantial evidence that such injury or death resulted from parental neglect or abuse',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NPB','Parent has failed to develop and maintain a parental bond with the child in a meaningful, supportive manner for a period of 1 year of more',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NPV','Parent has failed to provide for the care and support of the child as required by law or judicial decree for a period of 1 year or more',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NCO','Parent has failed to comply with a court-ordered plan designed to reunite the child with the parent(s) for a period of 1 year or more',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRUN','NTR','The parental rights to a sibling have been terminated involuntarily',sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (122, 'SacwisRev2', 'static updates, new FCCP_FAMILY table, update FAMILY_PLAN structure');

commit;
