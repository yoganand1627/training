
--STGAP00015958 - Release(4.0) MR-70: Batch Alerts Create new tables

--Per MR-70 Batch Alerts add new table YRPP_LINK

CREATE TABLE CAPS.YRPP_LINK
(ID_YRPP_LINK Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_PORTAL_USER Number(16,0) not null,
ID_YRD Number(16,0) null,
IND_NYTD_SURVEY_COMPLETE Varchar2(1) null,
IND_NYTD_GREET_EMAIL_SENT Varchar2(1) not null,
NYTD_BASELINE_YEAR Number(4,0) not null,
CONSTRAINT PK_YRPP_LINK PRIMARY KEY(ID_YRPP_LINK),
CONSTRAINT FK_PORTAL_USER FOREIGN KEY (ID_PORTAL_USER)
   REFERENCES CAPS.PORTAL_USER(ID_USER),
CONSTRAINT FK_YRD FOREIGN KEY (ID_YRD)
   REFERENCES CAPS.YOUTH_REPORT_DTL(ID_YOUTH_REPORT_DTL)
 ) tablespace data01;

create index caps.FK_PORTAL_USER on CAPS.YRPP_LINK(ID_PORTAL_USER) tablespace index01;
create index caps.FK_YRD on CAPS.YRPP_LINK(ID_YRD) tablespace index01;


comment on table CAPS.YRPP_LINK is 'The link table between YOUTH_REPORT_DTL and PORTAL_USER tables' ;
comment on column CAPS.YRPP_LINK.ID_YRPP_LINK is 'Primary Key' ;
comment on column CAPS.YRPP_LINK.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.YRPP_LINK.ID_PORTAL_USER is 'records the Portal User ID. Foreign key to PORTAL_USER.ID_USER' ;
comment on column CAPS.YRPP_LINK.ID_YRD is 'Records Youth Report Detail ID. Foreign key to YOUTH_REPORT_DTL.ID_YOUTH_REPORT_DTL' ;
comment on column CAPS.YRPP_LINK.IND_NYTD_SURVEY_COMPLETE is 'Indicates whether all questions of the NYTD Survey have been answered' ;
comment on column CAPS.YRPP_LINK.IND_NYTD_GREET_EMAIL_SENT is 'Indicates whether the NYTD Greeting Email and Password have been sent out to Baseline Youth' ;
comment on column CAPS.YRPP_LINK.NYTD_BASELINE_YEAR is 'Records the year that the outcome data is collected for NYTD Baseline Youth' ;

grant select,update,insert,delete on caps.YRPP_LINK to capson,capsbat,ops$datafix;
grant select on caps.YRPP_LINK to operator,shinesdm;

create sequence caps.SEQ_YRPP_LINK NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_YRPP_LINK to capson,capsbat,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_YRPP_LINK
BEFORE UPDATE
ON CAPS.YRPP_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_YRPP_LINK
BEFORE INSERT
ON CAPS.YRPP_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy  number(16);
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
   IF (:new.ID_YRPP_LINK = 0) THEN
	SELECT	SEQ_YRPP_LINK.NEXTVAL
	INTO	dummy
	FROM	DUAL;
	:new.ID_YRPP_LINK := dummy;
   END IF;
END;
/


--Per MR-70 Batch Alerts add new table NYTD_BASE_FOLLOW_UP_LOOKUP

CREATE TABLE CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP
(ID_NYTD_BASE_FOLLOW_UP_LOOKUP Number(16,0) not null,
DT_LAST_UPDATE Date not null,
NYTD_BASELINE_YEAR Number(4,0) not null,
NYTD_FOLLOWUP_19_YEAR Number(4,0) not null,
NYTD_FOLLOWUP_21_YEAR Number(4,0) not null,
CONSTRAINT PK_NYTD_BASE_FOLLOW_UP_LOOKUP PRIMARY KEY(ID_NYTD_BASE_FOLLOW_UP_LOOKUP)
 ) tablespace data01;


comment on table CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP is 'The lookup table of NYTD 19 yrs old followup year as well as 21 yrs old follow up year for a Baselie year' ;
comment on column CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP.ID_NYTD_BASE_FOLLOW_UP_LOOKUP is 'Primary Key' ;
comment on column CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP.NYTD_BASELINE_YEAR is 'Records the year that the outcome data is collected for NYTD Baseline Youth' ;
comment on column CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP.NYTD_FOLLOWUP_19_YEAR is 'Records the year outcome data is to be collected for Baseline Youth turning 19 years old' ;
comment on column CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP.NYTD_FOLLOWUP_21_YEAR is 'Records the year outcome data is to be collected for Baseline Youth turning 21 years old' ;

grant select,update,insert,delete on caps.NYTD_BASE_FOLLOW_UP_LOOKUP to capson,capsbat,ops$datafix;
grant select on caps.NYTD_BASE_FOLLOW_UP_LOOKUP to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_NYTD_BASE_FOLLOW_UP_LOOKUP  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_NYTD_BASE_FOLLOW_UP_LOOKUP to capson,capsbat,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_NYTD_BASE_FOLLW_UP_LOOKUP
BEFORE UPDATE
ON CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_NYTD_BASE_FOLLW_UP_LOOKUP
BEFORE INSERT
ON CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy  number(16);
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
   IF (:new.ID_NYTD_BASE_FOLLOW_UP_LOOKUP = 0) THEN
	SELECT	SEQ_NYTD_BASE_FOLLOW_UP_LOOKUP.NEXTVAL
	INTO	dummy
	FROM	DUAL;
	:new.ID_NYTD_BASE_FOLLOW_UP_LOOKUP := dummy;
   END IF;
END;
/


--Per MR-70 Batch Alerts add new table BATCH_ALERT_PARAMS

CREATE TABLE CAPS.BATCH_ALERT_PARAMS
(ID_BATCH_ALERT_PARAMS Number(4,0) not null,
DT_LAST_UPDATE Date not null,
NYTD_BASELINE_YEAR Number(4,0) not null,
ALERT_EMAIL_STEP_NAME Varchar2(40) not null,
IND_RUN Varchar2(1) not null,
CONSTRAINT PK_BATCH_ALERT_PARAMS PRIMARY KEY(ID_BATCH_ALERT_PARAMS)
 ) tablespace data01;

comment on table CAPS.BATCH_ALERT_PARAMS is 'Contains the data to indicate if a specific Batch Alert or Email Process needs to run' ;
comment on column CAPS.BATCH_ALERT_PARAMS.ID_BATCH_ALERT_PARAMS is 'Primary Key' ;
comment on column CAPS.BATCH_ALERT_PARAMS.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.BATCH_ALERT_PARAMS.NYTD_BASELINE_YEAR is 'Records the year that the outcome data is collected for NYTD Baseline Youth' ;
comment on column CAPS.BATCH_ALERT_PARAMS.ALERT_EMAIL_STEP_NAME is 'Records the process name of the batch Step' ;
comment on column CAPS.BATCH_ALERT_PARAMS.IND_RUN is 'Indicates whether the Step needs to process data' ;

grant select,update,insert,delete on caps.BATCH_ALERT_PARAMS to capson,capsbat,ops$datafix;
grant select on caps.BATCH_ALERT_PARAMS to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_BATCH_ALERT_PARAMS  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_BATCH_ALERT_PARAMS to capson,capsbat,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_BATCH_ALERT_PARAMS
BEFORE UPDATE
ON CAPS.BATCH_ALERT_PARAMS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_BATCH_ALERT_PARAMS
BEFORE INSERT
ON CAPS.BATCH_ALERT_PARAMS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number(16);
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
   IF (:new.ID_BATCH_ALERT_PARAMS = 0) THEN
	SELECT	SEQ_BATCH_ALERT_PARAMS.NEXTVAL
	INTO	dummy
	FROM	DUAL;
	:new.ID_BATCH_ALERT_PARAMS := dummy;
   END IF;
END;
/


--BACKOUT
--drop TABLE CAPS.YRPP_LINK;
--drop sequence caps.SEQ_YRPP_LINK ;
--drop TABLE CAPS.NYTD_BASE_FOLLOW_UP_LOOKUP;
--drop SEQUENCE  CAPS.SEQ_NYTD_BASE_FOLLOW_UP_LOOKUP;
--drop TABLE CAPS.BATCH_ALERT_PARAMS;
--drop SEQUENCE  CAPS.SEQ_BATCH_ALERT_PARAMS;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (866, 'SacwisRev3', 'Release 4.0 - DBCR 15958');

commit;



