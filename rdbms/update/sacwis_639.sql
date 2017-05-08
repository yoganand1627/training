--STGAP00015639 - Release(Undetermined) Portal Audit Tables

--Please see the attachment for the creation of new audit tables for the portal application

--Portal Audit table
CREATE TABLE CAPS.PORTAL_AUDIT 
   (	ID_PORTAL_AUDIT NUMBER(16,0) NOT NULL ENABLE, 
	DT_USER_ACTION DATE NOT NULL ENABLE, 
	ID_PERSON NUMBER(16,0), 
	TXT_IP_ADDRESS VARCHAR2(15 BYTE), 
	ID_COMMAND NUMBER(16,0), 
	NBR_MESSAGE NUMBER(6,0), 
	ID_CASE NUMBER(16,0), 
	ID_STAGE NUMBER(16,0), 
	ID_EVENT NUMBER(16,0),
	ID_USER NUMBER(16,0),
	ID_RESOURCE NUMBER(16,0),
	ID_PARENT_RSRC NUMBER(16,0),
	CONSTRAINT PK_PORTAL_AUDIT PRIMARY KEY (ID_PORTAL_AUDIT)
  	USING INDEX 
	TABLESPACE INDEX01  ENABLE) 
  	TABLESPACE DATA01 ;
 

   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_PORTAL_AUDIT IS 'Primary key for PORTAL AUDIT table';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.DT_USER_ACTION IS 'Date of user action';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_PERSON IS 'ID of the person involved in this transaction.';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.TXT_IP_ADDRESS IS 'Source IP Address of the user in the transaction';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_COMMAND IS 'Identifier from PORTAL Command table';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.NBR_MESSAGE IS 'Message id association with this audit record';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_CASE IS 'Case ID asssociated with this command.';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_STAGE IS 'ID of the Stage associated with this audit record';
 
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_EVENT IS 'ID of the Stage associated with this event';
   
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_USER IS 'User ID accessed the record';
   
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_RESOURCE IS 'Child Resource ID';
   
   COMMENT ON COLUMN CAPS.PORTAL_AUDIT.ID_PARENT_RSRC IS 'Parent Resource ID';
 
   COMMENT ON TABLE CAPS.PORTAL_AUDIT  IS 'PORTAL Audit table tracks the execution of certain commands';
 

CREATE SEQUENCE  CAPS.SEQ_PORTAL_AUDIT  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_PORTAL_AUDIT  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PORTAL_AUDIT 
BEFORE INSERT
ON CAPS.PORTAL_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  IF (:NEW.ID_PORTAL_AUDIT IS NULL OR :NEW.ID_PORTAL_AUDIT = 0) THEN
    SELECT  SEQ_PORTAL_AUDIT.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :NEW.ID_PORTAL_AUDIT := dummy;
  END IF;
END;
/

grant select,update,insert,delete on CAPS.PORTAL_AUDIT to capson,capsbat,ops$datafix;
grant select on caps.PORTAL_AUDIT to operator;


--Portal Login Audit table
CREATE TABLE CAPS.PORTAL_LOGIN_AUDIT 
   (	ID_PORTAL_LOGIN_AUDIT NUMBER(16,0) NOT NULL ENABLE, 
	DT_USER_ACTION DATE NOT NULL ENABLE, 
	TXT_USER_EMAIL VARCHAR2(320 BYTE),
	ID_USER NUMBER(16,0),
	NBR_MESSAGE NUMBER(6,0),	
	TXT_IP_ADDRESS VARCHAR2(15 BYTE), 
	IND_LOGIN_SUCCESS VARCHAR2(1 BYTE),
	CONSTRAINT PK_PORTAL_LOGIN_AUDIT PRIMARY KEY (ID_PORTAL_LOGIN_AUDIT)
	  	USING INDEX 
		TABLESPACE INDEX01  ENABLE) 
  	TABLESPACE DATA01 ;

   COMMENT ON COLUMN CAPS.PORTAL_LOGIN_AUDIT.ID_PORTAL_LOGIN_AUDIT IS 'Primary key for PORTAL LOGIN AUDIT table';
 
   COMMENT ON COLUMN CAPS.PORTAL_LOGIN_AUDIT.DT_USER_ACTION IS 'Date of user action';
 
   COMMENT ON COLUMN CAPS.PORTAL_LOGIN_AUDIT.TXT_USER_EMAIL IS 'Email id used by the person involved in this transaction.';
   
   COMMENT ON COLUMN CAPS.PORTAL_LOGIN_AUDIT.ID_USER IS 'User ID accessed the record';
   
   COMMENT ON COLUMN CAPS.PORTAL_LOGIN_AUDIT.NBR_MESSAGE IS 'Message id association with this audit record';
   
   COMMENT ON COLUMN CAPS.PORTAL_LOGIN_AUDIT.TXT_IP_ADDRESS IS 'Source IP Address of the user in the transaction';
   
   COMMENT ON COLUMN CAPS.PORTAL_LOGIN_AUDIT.IND_LOGIN_SUCCESS IS 'Indicator for successful or unsuccessful login by the user in the transaction';
   
CREATE SEQUENCE  CAPS.SEQ_PORTAL_LOGIN_AUDIT  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_PORTAL_LOGIN_AUDIT  to capsbat,capson,ops$datafix;

/
  CREATE OR REPLACE TRIGGER CAPS.TIBR_PORTAL_LOGIN_AUDIT 
BEFORE INSERT
ON CAPS.PORTAL_LOGIN_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :NEW.DT_USER_ACTION := SYSDATE;
  IF (:NEW.ID_PORTAL_LOGIN_AUDIT IS NULL OR :NEW.ID_PORTAL_LOGIN_AUDIT = 0) THEN
    SELECT  SEQ_PORTAL_LOGIN_AUDIT.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :NEW.ID_PORTAL_LOGIN_AUDIT := dummy;
  END IF;
END;  
/


grant select,update,insert,delete on CAPS.PORTAL_LOGIN_AUDIT to capson,capsbat,ops$datafix;
grant select on caps.PORTAL_LOGIN_AUDIT to operator;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (640, 'SacwisRev3', 'Release Undetermined - DBCR 15639');

commit;



