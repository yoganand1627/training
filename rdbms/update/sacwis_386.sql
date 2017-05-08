-- STGAP00010343 - FOSTER_HOME_CONV - increase size of column

alter table CAPS.FOSTER_HOME_CONV modify (CD_CONV_APP_STATUS varchar2(3));

-- STGAP00010344 add narrative tables for adoption
-- CREATE TABLE FH_CONV_NARRATIVE

CREATE TABLE CAPS.FH_CONV_NARRATIVE 
   (	ID_EVENT NUMBER(16,0) NOT NULL ENABLE, 
	DT_LAST_UPDATE DATE NOT NULL ENABLE, 
	ID_CASE NUMBER(16,0), 
	NARRATIVE LONG RAW, 
	ID_DOCUMENT_TEMPLATE NUMBER(16,0), 
	 CONSTRAINT PK_FH_CONV_NARR PRIMARY KEY (ID_EVENT)
              using index tablespace index01
     ) tablespace data01;



create index caps.IND_FH_CONV_NARRATIVE ON CAPS.FH_CONV_NARRATIVE(ID_CASE) TABLESPACE INDEX01;

grant select,update,insert,delete on caps.FH_CONV_NARRATIVE to capson,capsbat,ops$datafix;
grant select on caps.FH_CONV_NARRATIVE to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_FH_CONV_NARRATIVE 
BEFORE INSERT ON CAPS.FH_CONV_NARRATIVE
FOR EACH ROW

BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	SELECT	ID_CASE
	INTO		:new.ID_CASE
	FROM		EVENT
	WHERE		ID_EVENT = :new.ID_EVENT;
EXCEPTION
	WHEN OTHERS THEN
		IF SQL%NOTFOUND THEN
			:new.ID_CASE := NULL;
		END IF;
END;
/

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_FH_CONV_NARRATIVE 
BEFORE UPDATE ON CAPS.FH_CONV_NARRATIVE
FOR EACH ROW

BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/


-- CREATE TABLE DISRUPTION_NARRATIVE

CREATE TABLE CAPS.DISRUPTION_NARRATIVE 
   (	ID_EVENT NUMBER(16,0) NOT NULL ENABLE, 
	DT_LAST_UPDATE DATE NOT NULL ENABLE, 
	ID_CASE NUMBER(16,0), 
	NARRATIVE LONG RAW, 
	ID_DOCUMENT_TEMPLATE NUMBER(16,0), 
	 CONSTRAINT PK_FH_DISRUP_NARR PRIMARY KEY (ID_EVENT)
              using index tablespace index01
     ) tablespace data01;


create index caps.IND_DISRUPTION_NARRATIVE ON CAPS.DISRUPTION_NARRATIVE(ID_CASE) TABLESPACE INDEX01;

grant select,update,insert,delete on caps.DISRUPTION_NARRATIVE to capson,capsbat,ops$datafix;
grant select on caps.DISRUPTION_NARRATIVE to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_DISRUPTION_NARRATIVE 
BEFORE INSERT ON CAPS.DISRUPTION_NARRATIVE
FOR EACH ROW

BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	SELECT	ID_CASE
	INTO		:new.ID_CASE
	FROM		EVENT
	WHERE		ID_EVENT = :new.ID_EVENT;
EXCEPTION
	WHEN OTHERS THEN
		IF SQL%NOTFOUND THEN
			:new.ID_CASE := NULL;
		END IF;
END;
/

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_DISRUPTION_NARRATIVE 
BEFORE UPDATE ON CAPS.DISRUPTION_NARRATIVE
FOR EACH ROW

BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/

--STGAP00010345 - Remove unused trigger

DROP TRIGGER CAPS.TDBR_CONTACT_NARRATIVE;


--STGAP00010305 - Add a new EducationCustomValidation message

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60478, 'MSG_ED_HIST_SCHOOL_NAME_REQUIRED', ' School/Day Care Name is required when Education Type is Day Care, Head Start or School', 700, 500, 'N');


--STGAP00010322 - Codes Table - Foster Home Conversion Status

INSERT INTO CAPS.CODES_TABLES VALUES('CFHCSTTS', 'INQ', 'Inquiry', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CFHCSTTS', 'APP', 'Applicant', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CFHCSTTS', 'PAP', 'Pending Approval', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CFHCSTTS', 'APR', 'Approved', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CFHCSTTS', 'PCL', 'Pending Closure', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CFHCSTTS', 'CLS', 'Closed', null, SYSDATE);


--STGAP00010323 - Codes Table - Foster Home Conversion Closure Reason

INSERT INTO CAPS.CODES_TABLES VALUES('CFHCCLSR', 'CL', 'Closed/No Placement', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CFHCCLSR', 'DN', 'Denied', null, SYSDATE);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (387, 'SacwisRev3', 'Release 3.0 - DBCRs 10305,10322,10323,10343,10344,10345');

commit;


