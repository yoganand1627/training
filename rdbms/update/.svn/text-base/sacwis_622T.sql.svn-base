--STGAP00015620 - DBCR: Create Tables for Case Watch

create table caps.CW_SUMMARY		
(ID_STAGE Number(16,0) not null,
ID_CASE	Number(16,0) not null,
DT_LAST_UPDATE Date not null,
DT_LAST_OVERALL_CW_BATCH_RUN Date,
DT_LAST_AFCARS_ERRORS_RUN Date,
DT_LAST_NCANDS_ERRORS_RUN Date,
NBR_OPEN_ERRORS	Number(3),
NBR_OPEN_WARNINGS Number(3),
CONSTRAINT PK_CW_SUMMARY PRIMARY KEY (ID_STAGE) using index tablespace index01,
CONSTRAINT FK_CW_SUMMARY_STAGE FOREIGN KEY (ID_STAGE)
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE,
CONSTRAINT FK_CW_SUMMARY_CASE FOREIGN KEY (ID_CASE)
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE ) tablespace data01;

comment on column caps.cw_summary.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.cw_summary.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.cw_summary.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.cw_summary.DT_LAST_OVERALL_CW_BATCH_RUN is 'Date of last overall CW run against the stage';
comment on column caps.cw_summary.DT_LAST_AFCARS_ERRORS_RUN is 'Date of last AFCARS errors only run against the stage';
comment on column caps.cw_summary.DT_LAST_NCANDS_ERRORS_RUN is 'Date of last NCANDS errors only run against the stage';
comment on column caps.cw_summary.NBR_OPEN_ERRORS is 'Current number of open case errors for the stage';
comment on column caps.cw_summary.NBR_OPEN_WARNINGS is 'Current number of open case warnings for the stage';

create index CAPS.IND_CW_SUMMARY_1 on caps.CW_SUMMARY (ID_CASE) tablespace index01;

grant select,update,insert,delete on CAPS.CW_SUMMARY to capson,capsbat,ops$datafix;
grant select on caps.CW_SUMMARY to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_SUMMARY
BEFORE UPDATE
ON CAPS.CW_SUMMARY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_SUMMARY
BEFORE INSERT
ON CAPS.CW_SUMMARY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
END;
/


create table caps.CW_CASE_ERRORS  
(ID_CW_CASE_ERROR Number(16,0) not null,
DT_LAST_UPDATE Date not null, 
ID_STAGE Number(16,0) not null, 
ID_CASE Number(16,0) not null, 
CD_ERROR varchar2(3) not null, 
IND_AFCARS varchar2(1), 
IND_NCANDS varchar2(1), 
DT_ADDED Date, 
DT_CLEARED Date,
CONSTRAINT PK_CASE_ERRORS PRIMARY KEY (ID_CW_CASE_ERROR) using index tablespace index01,
CONSTRAINT FK_CASE_ERRORS_STAGE FOREIGN KEY (ID_STAGE)
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE,
CONSTRAINT FK_CASE_ERRORS_CASE FOREIGN KEY (ID_CASE)
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE ) tablespace data01;

comment on column caps.cw_case_errors.ID_CW_CASE_ERROR is 'Unique primary key ';
comment on column caps.cw_case_errors.DT_LAST_UPDATE is 'System date of the last row update ';
comment on column caps.cw_case_errors.ID_STAGE is 'SHINES Stage for the Case Watch Factors ';
comment on column caps.cw_case_errors.ID_CASE is 'SHINES Case for the Case Watch factors ';
comment on column caps.cw_case_errors.CD_ERROR is 'Codes table code value of the error ';
comment on column caps.cw_case_errors.IND_AFCARS is 'Indcator if the error is an AFCARS error ';
comment on column caps.cw_case_errors.IND_NCANDS is 'Indicator if the error is an NCANDS error ';
comment on column caps.cw_case_errors.DT_ADDED is 'Date first identified ';
comment on column caps.cw_case_errors.DT_CLEARED is 'Date no longer identified ';

create index CAPS.IND_CW_CASE_ERRORS_1 on caps.CW_CASE_ERRORS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_CASE_ERRORS  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_CASE_ERRORS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_CASE_ERRORS to capson,capsbat,ops$datafix;
grant select on caps.CW_CASE_ERRORS to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_CASE_ERRORS
BEFORE UPDATE
ON CAPS.CW_CASE_ERRORS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_CASE_ERRORS
BEFORE INSERT
ON CAPS.CW_CASE_ERRORS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_CW_CASE_ERROR=0 then
    SELECT SEQ_CW_CASE_ERRORS.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_CW_CASE_ERROR := dummy;
  end if;
END;
/


create table caps.CW_CASE_WARNINGS 
(ID_CW_CASE_WARNING Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
CD_WARNING varchar2(3) not null,
IND_AFCARS varchar2(1),
IND_NCANDS varchar2(1),
DT_ADDED Date,
CONSTRAINT PK_CASE_WARNINGS PRIMARY KEY (ID_CW_CASE_WARNING) using index tablespace index01,
CONSTRAINT FK_CASE_WARNINGS_STAGE FOREIGN KEY (ID_STAGE)
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE,
CONSTRAINT FK_CASE_WARNINGS_CASE FOREIGN KEY (ID_CASE)
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE ) tablespace data01;

comment on column caps.cw_case_warnings.ID_CW_CASE_WARNING is 'Unique primary key ';
comment on column caps.cw_case_warnings.DT_LAST_UPDATE is 'System date of the last row update ';
comment on column caps.cw_case_warnings.ID_STAGE is 'SHINES Stage for the Case Watch Factors ';
comment on column caps.cw_case_warnings.ID_CASE is 'SHINES Case for the Case Watch factors ';
comment on column caps.cw_case_warnings.CD_WARNING is 'Codes table code value of the warning ';
comment on column caps.cw_case_warnings.IND_AFCARS is 'Indicator if the warning is an AFCARS warning ';
comment on column caps.cw_case_warnings.IND_NCANDS is 'Indicator if the warning is an NCANDS warning ';
comment on column caps.cw_case_warnings.DT_ADDED is 'Date first identified ';

create index CAPS.IND_CW_CASE_WARNINGS_1 on caps.CW_CASE_WARNINGS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_CASE_WARNINGS  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_CASE_WARNINGS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_CASE_WARNINGS to capson,capsbat,ops$datafix;
grant select on caps.CW_CASE_WARNINGS to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_CASE_WARNINGS
BEFORE UPDATE
ON CAPS.CW_CASE_WARNINGS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_CASE_WARNINGS
BEFORE INSERT
ON CAPS.CW_CASE_WARNINGS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_CW_CASE_WARNING=0 then
    SELECT SEQ_CW_CASE_WARNINGS.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_CW_CASE_WARNING := dummy;
  end if;
END;
/

CREATE TABLE CAPS.CW_LAST_VIEWED
(ID_CW_LAST_VIEWED Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_EMPLOYEE Number(16,0) not null,
DT_LAST_VIEW Date not null,
CONSTRAINT PK_CW_LAST_VIEWED PRIMARY KEY (ID_CW_LAST_VIEWED) using index tablespace index01, 
CONSTRAINT FK_CW_LAST_VIEWED_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_LAST_VIEWED_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE,
CONSTRAINT FK_CW_LAST_VIEWED_EMPLOYEE FOREIGN KEY (ID_EMPLOYEE) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE) tablespace data01;


comment on column caps.CW_LAST_VIEWED.ID_CW_LAST_VIEWED is 'Unique primary key';
comment on column caps.CW_LAST_VIEWED.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_LAST_VIEWED.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_LAST_VIEWED.ID_CASE is 'SHINES Case for the Case Watch Factors';
comment on column caps.CW_LAST_VIEWED.ID_EMPLOYEE is 'Person ID of the employee viewing the page';
comment on column caps.CW_LAST_VIEWED.DT_LAST_VIEW is 'Date the employee last viewed the Case Watch page';

create index CAPS.IND_CW_LAST_VIEWED_1 on caps.CW_LAST_VIEWED (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_LAST_VIEWED  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ; 

grant select on CAPS.SEQ_CW_LAST_VIEWED  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_LAST_VIEWED to capson,capsbat,ops$datafix;
grant select on caps.CW_LAST_VIEWED to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_LAST_VIEWED 
BEFORE UPDATE 
ON CAPS.CW_LAST_VIEWED 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
   :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 

/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_LAST_VIEWED 
BEFORE INSERT 
ON CAPS.CW_LAST_VIEWED 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
    DECLARE dummy number; 
BEGIN 
    :NEW.DT_LAST_UPDATE := sysdate; 
     if :NEW.ID_CW_LAST_VIEWED=0 then  
           SELECT SEQ_CW_LAST_VIEWED.NEXTVAL INTO dummy  FROM DUAL; 
           :NEW.ID_CW_LAST_VIEWED := dummy; 
     end if; 
END; 
/


CREATE TABLE CAPS.CW_UPCOMING_EVENTS
(ID_CW_UPCOMING_EVENT Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_EVENT Number(16,0),
CD_TASK varchar2(4),
TXT_EVENT varchar2(100),
DT_DUE Date,
NBR_DAYS_UNTIL_DUE Number(3),
IND_ERROR varchar2(1),
CONSTRAINT PK_CW_UPCOMING_EVENTS PRIMARY KEY (ID_CW_UPCOMING_EVENT) using index tablespace index01, 
CONSTRAINT FK_CW_UPCOMING_EVENTS_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_UPCOMING_EVENTS_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE,
CONSTRAINT FK_CW_UPCOMING_EVENTS_EVENT FOREIGN KEY (ID_EVENT) 
           REFERENCES CAPS.EVENT(ID_EVENT) ENABLE ) tablespace data01;


comment on column caps.CW_UPCOMING_EVENTS.ID_CW_UPCOMING_EVENT is 'Unique primary key';
comment on column caps.CW_UPCOMING_EVENTS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_UPCOMING_EVENTS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_UPCOMING_EVENTS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_UPCOMING_EVENTS.ID_EVENT is 'Event ID for the upcoming event';
comment on column caps.CW_UPCOMING_EVENTS.CD_TASK is 'Task code for the event';
comment on column caps.CW_UPCOMING_EVENTS.TXT_EVENT is 'Event description';
comment on column caps.CW_UPCOMING_EVENTS.DT_DUE is 'Date event is due';
comment on column caps.CW_UPCOMING_EVENTS.NBR_DAYS_UNTIL_DUE is 'Number of days until the event is due';
comment on column caps.CW_UPCOMING_EVENTS.IND_ERROR is 'Indicates if the item is within warning range or overdue';

create index CAPS.IND_CW_UPCOMING_EVENTS_1 on caps.CW_UPCOMING_EVENTS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_UPCOMING_EVENTS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_UPCOMING_EVENTS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_UPCOMING_EVENTS to capson,capsbat,ops$datafix;
grant select on caps.CW_UPCOMING_EVENTS to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_UPCOMING_EVENTS 
BEFORE UPDATE 
ON CAPS.CW_UPCOMING_EVENTS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 

/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_UPCOMING_EVENTS 
BEFORE INSERT 
ON CAPS.CW_UPCOMING_EVENTS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
        DECLARE dummy number; 
BEGIN 
       :NEW.DT_LAST_UPDATE := sysdate; 
       
        if :NEW.ID_CW_UPCOMING_EVENT=0 then  
            SELECT SEQ_CW_UPCOMING_EVENTS.NEXTVAL INTO dummy  FROM DUAL; 
            :NEW.ID_CW_UPCOMING_EVENT := dummy; 
        end if; 
END; 
/



CREATE TABLE CAPS.CW_INV_RESP_PER_VICTIM
(ID_CW_INV_RESP_PER_VIC Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_VICTIM Number(16,0) not null,
CD_RESPONSE_TIME varchar2(3),
DT_INTAKE Date,
DT_RESPONSE Date,
NBR_CALC_RESPONSE_TIME Number(4,1),
IND_MISSED_RESPONSE_TIME varchar2(1),
CONSTRAINT PK_CW_INV_RESP_PER_VICTIM PRIMARY KEY (ID_CW_INV_RESP_PER_VIC) using index tablespace index01, 
CONSTRAINT FK_CW_INV_RESP_PER_VIC_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_INV_RESP_PER_VIC_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_INV_RESP_PER_VIC_PERSON FOREIGN KEY (ID_VICTIM) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE ) tablespace data01;


comment on column caps.CW_INV_RESP_PER_VICTIM.ID_CW_INV_RESP_PER_VIC is 'Unique primary key';
comment on column caps.CW_INV_RESP_PER_VICTIM.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_INV_RESP_PER_VICTIM.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_INV_RESP_PER_VICTIM.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_INV_RESP_PER_VICTIM.ID_VICTIM is 'SHINES Person ID of the alleged victim';
comment on column caps.CW_INV_RESP_PER_VICTIM.CD_RESPONSE_TIME is 'Response time identified on the intake';
comment on column caps.CW_INV_RESP_PER_VICTIM.DT_INTAKE is 'Date and time of the intake';
comment on column caps.CW_INV_RESP_PER_VICTIM.DT_RESPONSE is 'Date and time of earliest face to face contact';
comment on column caps.CW_INV_RESP_PER_VICTIM.NBR_CALC_RESPONSE_TIME is 'Calculated response time in days';
comment on column caps.CW_INV_RESP_PER_VICTIM.IND_MISSED_RESPONSE_TIME is 'Indicates if response time was misssed for the individual victim';

create index CAPS.IND_CW_INV_RESP_PER_VICTIM_1 on caps.CW_INV_RESP_PER_VICTIM (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_INV_RESP_PER_VICTIM  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_INV_RESP_PER_VICTIM  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_INV_RESP_PER_VICTIM to capson,capsbat,ops$datafix;
grant select on caps.CW_INV_RESP_PER_VICTIM to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_INV_RESP_PER_VICTIM 
BEFORE UPDATE 
ON CAPS.CW_INV_RESP_PER_VICTIM 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN :
     new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_INV_RESP_PER_VICTIM 
BEFORE INSERT 
ON CAPS.CW_INV_RESP_PER_VICTIM 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
     DECLARE dummy number; 
BEGIN 
     :NEW.DT_LAST_UPDATE := sysdate; 
      if :NEW.ID_CW_INV_RESP_PER_VIC=0 then  
               SELECT SEQ_CW_INV_RESP_PER_VICTIM.NEXTVAL INTO dummy  FROM DUAL; 
               :NEW.ID_CW_INV_RESP_PER_VIC := dummy; 
      end if; 
END; 
/


CREATE TABLE CAPS.CW_INV_ADDL_FACTORS
(ID_CW_INV_ADDL_FACTORS Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_SPEC_INV_RESOURCE Number(16,0),
DT_48_HOUR_STAFFING Date,
IND_SPEC_INV_ERROR varchar2(1),
IND_SPEC_INV_STAFFING_ERR varchar2(1),
CONSTRAINT PK_CW_INV_ADDL_FACTORS PRIMARY KEY (ID_CW_INV_ADDL_FACTORS) using index tablespace index01, 
CONSTRAINT FK_CW_INV_ADDL_FACTORS_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_INV_ADDL_FACTORS_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_INV_ADDL_FACTORS_RSRC FOREIGN KEY (ID_SPEC_INV_RESOURCE) 
           REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE) ENABLE) tablespace data01;


comment on column caps.CW_INV_ADDL_FACTORS.ID_CW_INV_ADDL_FACTORS is 'Unique primary key';
comment on column caps.CW_INV_ADDL_FACTORS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_INV_ADDL_FACTORS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_INV_ADDL_FACTORS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_INV_ADDL_FACTORS.ID_SPEC_INV_RESOURCE is 'SHINES Resource ID of the resource for the special investigation';
comment on column caps.CW_INV_ADDL_FACTORS.DT_48_HOUR_STAFFING is 'Date of the 48 hour special investigation staffing in the investigation';
comment on column caps.CW_INV_ADDL_FACTORS.IND_SPEC_INV_ERROR is 'Indicates if error or warning exists for the special investigation resource ID';
comment on column caps.CW_INV_ADDL_FACTORS.IND_SPEC_INV_STAFFING_ERR is 'Indicates if error or warning exists for the special investigation staffing';

create index CAPS.IND_CW_INV_ADDL_FACTORS_1 on caps.CW_INV_ADDL_FACTORS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_INV_ADDL_FACTORS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_INV_ADDL_FACTORS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_INV_ADDL_FACTORS to capson,capsbat,ops$datafix;
grant select on caps.CW_INV_ADDL_FACTORS to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_INV_ADDL_FACTORS 
BEFORE UPDATE 
ON CAPS.CW_INV_ADDL_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
      :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/
 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_INV_ADDL_FACTORS 
BEFORE INSERT 
ON CAPS.CW_INV_ADDL_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
     DECLARE dummy number; 
BEGIN 
     :NEW.DT_LAST_UPDATE := sysdate; 
      if :NEW.ID_CW_INV_ADDL_FACTORS=0 then  
            SELECT SEQ_CW_INV_ADDL_FACTORS.NEXTVAL INTO dummy  FROM DUAL; 
            :NEW.ID_CW_INV_ADDL_FACTORS := dummy; 
       end if; 
END; 
/


CREATE TABLE CAPS.CW_ONG_CONTACT_STANDARDS
(ID_CW_ONG_CONTACT_STANDARDS Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_PERSON Number(16,0) not null,
CD_PERSON_REL varchar2(3),
DT_FACE_TO_FACE Date,
IND_ERROR varchar2(1),
CONSTRAINT PK_CW_ONG_CONTACT_STANDARDS PRIMARY KEY (ID_CW_ONG_CONTACT_STANDARDS) using index tablespace index01, 
CONSTRAINT FK_CW_ONG_CONTACT_STAND_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_ONG_CONTACT_STAND_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_ONG_CONTACT_STAND_PERSON FOREIGN KEY (ID_PERSON) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE) tablespace data01;


comment on column caps.CW_ONG_CONTACT_STANDARDS.ID_CW_ONG_CONTACT_STANDARDS is 'Unique primary key';
comment on column caps.CW_ONG_CONTACT_STANDARDS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_ONG_CONTACT_STANDARDS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_ONG_CONTACT_STANDARDS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_ONG_CONTACT_STANDARDS.ID_PERSON is 'SHINES Person ID of the principal in the ONG stage';
comment on column caps.CW_ONG_CONTACT_STANDARDS.CD_PERSON_REL is 'Relationship of the person as captured in the ongoing stage';
comment on column caps.CW_ONG_CONTACT_STANDARDS.DT_FACE_TO_FACE is 'Date of the most recent face to face contact with the principal';
comment on column caps.CW_ONG_CONTACT_STANDARDS.IND_ERROR is 'Indicates if error or warning exists for the principal contact';

create index CAPS.IND_CW_ONG_CONTACT_STANDARDS_1 on caps.CW_ONG_CONTACT_STANDARDS (ID_CASE) tablespace index01; 

CREATE SEQUENCE  CAPS.SEQ_CW_ONG_CONTACT_STANDARDS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_ONG_CONTACT_STANDARDS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_ONG_CONTACT_STANDARDS to capson,capsbat,ops$datafix;
grant select on caps.CW_ONG_CONTACT_STANDARDS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_ONG_CONTACT_STANDARDS 
BEFORE UPDATE 
ON CAPS.CW_ONG_CONTACT_STANDARDS 
REFERENCING OLD AS OLD NEW AS NEW FOR EACH ROW 
BEGIN 
      :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 

/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_ONG_CONTACT_STANDARDS 
BEFORE INSERT ON CAPS.CW_ONG_CONTACT_STANDARDS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
       DECLARE dummy number; 
BEGIN 
       :NEW.DT_LAST_UPDATE := sysdate; 
        if :NEW.ID_CW_ONG_CONTACT_STANDARDS=0 then  
             SELECT SEQ_CW_ONG_CONTACT_STANDARDS.NEXTVAL INTO dummy  FROM DUAL; 
             :NEW.ID_CW_ONG_CONTACT_STANDARDS := dummy; 
        end if; 
END; 
/


CREATE TABLE CAPS.CW_ONG_SAFETY_RESOURCE
(ID_CW_ONG_SAFETY_RESOURCE Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_CHILD Number(16,0) not null,
ID_SAFETY_RESOURCE Number(16,0) not null,
DT_START Date,
DT_END Date,
NBR_MONTHS_IN_PLACEMENT Number(3),
IND_ERROR varchar2(1),
CONSTRAINT PK_CW_ONG_SAFETY_RESOURCE PRIMARY KEY (ID_CW_ONG_SAFETY_RESOURCE) using index tablespace index01, 
CONSTRAINT FK_CW_ONG_SFTY_RSRC_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_ONG_SFTY_RSRC_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_ONG_SFTY_RSRC_CHI_PERSON FOREIGN KEY (ID_CHILD) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE,
CONSTRAINT FK_CW_ONG_SFTY_RSRC_SR_PERSON FOREIGN KEY (ID_SAFETY_RESOURCE) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE) tablespace data01;

comment on column caps.CW_ONG_SAFETY_RESOURCE.ID_CW_ONG_SAFETY_RESOURCE is 'Unique primary key';
comment on column caps.CW_ONG_SAFETY_RESOURCE.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_ONG_SAFETY_RESOURCE.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_ONG_SAFETY_RESOURCE.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_ONG_SAFETY_RESOURCE.ID_CHILD is 'SHINES Person ID of the child with the safety resource';
comment on column caps.CW_ONG_SAFETY_RESOURCE.ID_SAFETY_RESOURCE is 'SHINES Person ID of the safety resource';
comment on column caps.CW_ONG_SAFETY_RESOURCE.DT_START is 'Start date of the safety resource placement';
comment on column caps.CW_ONG_SAFETY_RESOURCE.DT_END is 'End date of the safety resource placement';
comment on column caps.CW_ONG_SAFETY_RESOURCE.NBR_MONTHS_IN_PLACEMENT is 'Number of months in the safety resource placement';
comment on column caps.CW_ONG_SAFETY_RESOURCE.IND_ERROR is 'Indicates warning or error for the safety resource placement';

create index CAPS.IND_CW_ONG_SAFETY_RESOURCE_1 on caps.CW_ONG_SAFETY_RESOURCE (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_ONG_SAFETY_RESOURCE  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_ONG_SAFETY_RESOURCE  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_ONG_SAFETY_RESOURCE to capson,capsbat,ops$datafix;
grant select on caps.CW_ONG_SAFETY_RESOURCE to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_ONG_SAFETY_RESOURCE 
BEFORE UPDATE 
ON CAPS.CW_ONG_SAFETY_RESOURCE 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_ONG_SAFETY_RESOURCE 
BEFORE INSERT 
ON CAPS.CW_ONG_SAFETY_RESOURCE 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
    DECLARE dummy number; 
BEGIN 
     :NEW.DT_LAST_UPDATE := sysdate; 
     if :NEW.ID_CW_ONG_SAFETY_RESOURCE=0 then  
             SELECT SEQ_CW_ONG_SAFETY_RESOURCE.NEXTVAL INTO dummy  FROM DUAL; 
             :NEW.ID_CW_ONG_SAFETY_RESOURCE := dummy; 
     end if; 
END; 
/


CREATE TABLE CAPS.CW_ONG_ADDL_FACTORS
(ID_CW_ONG_ADDL_FACTORS Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
DT_LAST_FTM Date,
CD_CURR_RISK_LEVEL varchar2(3),
IND_ERROR_FTM varchar2(1),
IND_ERROR_RISK_LEVEL varchar2(1),
CONSTRAINT PK_CW_ONG_ADDL_FACTORS PRIMARY KEY (ID_CW_ONG_ADDL_FACTORS) using index tablespace index01, 
CONSTRAINT FK_CW_ONG_ADDL_FACTORS_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_ONG_ADDL_FACTORS_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE ) tablespace data01;


comment on column caps.CW_ONG_ADDL_FACTORS.ID_CW_ONG_ADDL_FACTORS is 'Unique primary key';
comment on column caps.CW_ONG_ADDL_FACTORS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_ONG_ADDL_FACTORS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_ONG_ADDL_FACTORS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_ONG_ADDL_FACTORS.DT_LAST_FTM is 'Date of the last family team meeting in the stage';
comment on column caps.CW_ONG_ADDL_FACTORS.CD_CURR_RISK_LEVEL is 'Current risk level as entered on most recent risk re-assessment';
comment on column caps.CW_ONG_ADDL_FACTORS.IND_ERROR_FTM is 'Indicates warning or error for the last FTM date';
comment on column caps.CW_ONG_ADDL_FACTORS.IND_ERROR_RISK_LEVEL is 'Indicates warning or error for the current level of risk';

create index CAPS.IND_CW_ONG_ADDL_FACTORS_1 on caps.CW_ONG_ADDL_FACTORS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_ONG_ADDL_FACTORS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_ONG_ADDL_FACTORS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_ONG_ADDL_FACTORS to capson,capsbat,ops$datafix;
grant select on caps.CW_ONG_ADDL_FACTORS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_ONG_ADDL_FACTORS 
BEFORE UPDATE 
ON CAPS.CW_ONG_ADDL_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
       :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_ONG_ADDL_FACTORS 
BEFORE INSERT ON CAPS.CW_ONG_ADDL_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
      DECLARE dummy number; 
BEGIN 
      :NEW.DT_LAST_UPDATE := sysdate; 
      if :NEW.ID_CW_ONG_ADDL_FACTORS=0 then  
            SELECT SEQ_CW_ONG_ADDL_FACTORS.NEXTVAL INTO dummy  FROM DUAL; 
            :NEW.ID_CW_ONG_ADDL_FACTORS := dummy; 
      end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_HIDDEN_SECTION_ERRORS
(ID_CW_FC_HIDDEN_SECTION_ERR Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
IND_CP_REVIEW_ERROR varchar2(1),
IND_TPR_ERROR varchar2(1),
IND_HEALTH_SCREEN_ERROR varchar2(1),
IND_CI_ERROR varchar2(1),
IND_AFCARS_ERROR varchar2(1),
CONSTRAINT PK_CW_FC_HIDDEN_SECTION_ERR PRIMARY KEY (ID_CW_FC_HIDDEN_SECTION_ERR) using index tablespace index01, 
CONSTRAINT FK_CW_FC_HID_SEC_ERR_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_FC_HID_SEC_ERR_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE ) tablespace data01;


comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.ID_CW_FC_HIDDEN_SECTION_ERR is 'Unique primary key';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.IND_CP_REVIEW_ERROR is 'Indicates if there are errors or warnings in the non-expanded section';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.IND_TPR_ERROR is 'Indicates if there are errors or warnings in the non-expanded section';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.IND_HEALTH_SCREEN_ERROR is 'Indicates if there are errors or warnings in the non-expanded section';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.IND_CI_ERROR is 'Indicates if there are errors or warnings in the non-expanded section';
comment on column caps.CW_FC_HIDDEN_SECTION_ERRORS.IND_AFCARS_ERROR is 'Indicates if there are errors or warnings in the non-expanded section';

create index CAPS.IND_CW_FC_HIDDEN_SECTION_ERR_1 on caps.CW_FC_HIDDEN_SECTION_ERRORS (ID_CASE) tablespace index01; 

CREATE SEQUENCE  CAPS.SEQ_CW_FC_HIDDEN_SECTION_ERR  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_FC_HIDDEN_SECTION_ERR  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_HIDDEN_SECTION_ERRORS to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_HIDDEN_SECTION_ERRORS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_HID_SECTION_ERRORS 
BEFORE UPDATE 
ON CAPS.CW_FC_HIDDEN_SECTION_ERRORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_HID_SECTION_ERRORS 
BEFORE INSERT 
ON CAPS.CW_FC_HIDDEN_SECTION_ERRORS 
REFERENCING OLD AS OLD NEW AS NEW FOR EACH ROW 
        DECLARE dummy number; 
BEGIN :
        NEW.DT_LAST_UPDATE := sysdate; 
        if :NEW.ID_CW_FC_HIDDEN_SECTION_ERR=0 then  
              SELECT SEQ_CW_FC_HIDDEN_SECTION_ERR.NEXTVAL INTO dummy  FROM DUAL; 
              :NEW.ID_CW_FC_HIDDEN_SECTION_ERR := dummy; 
        end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_CP_REVIEW_FACTORS
(ID_CW_FC_CP_REVIEW_FACTORS Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_CURRENT_PLAN_EVENT Number(16,0),
CD_PRIM_PERM_GOAL varchar2(3),
IND_PRIM_PERM_GOAL_ERROR varchar2(1),
CD_CONCUR_PERM_GOAL varchar2(3),
IND_CONCUR_PERM_GOAL_ERROR varchar2(1),
DT_LAST_CASE_PLAN_REVIEW Date,
IND_LAST_CASE_PLAN_REVIEW_ERR varchar2(1),
DT_LAST_PERMANENCY_REVIEW Date,
IND_LAST_PERMANENCY_REVIEW_ERR varchar2(1),
DT_LAST_FTM Date,
IND_ERROR_FTM varchar2(1),
DT_ELIG_DUE_DATE Date,
IND_ELIG_DUE_DATE_ERROR varchar2(1),
CONSTRAINT PK_CW_FC_CP_REVIEW_FACTORS PRIMARY KEY (ID_CW_FC_CP_REVIEW_FACTORS) using index tablespace index01, 
CONSTRAINT FK_CW_FC_CP_REVIEW_FAC_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_FC_CP_REVIEW_FAC_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_FC_CP_REVIEW_FAC_EVENT FOREIGN KEY (ID_CURRENT_PLAN_EVENT) 
           REFERENCES CAPS.EVENT(ID_EVENT) ENABLE) tablespace data01;

comment on column caps.CW_FC_CP_REVIEW_FACTORS.ID_CW_FC_CP_REVIEW_FACTORS is 'Unique primary key';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.ID_CURRENT_PLAN_EVENT is 'The event ID of the current foster care case plan for the child';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.CD_PRIM_PERM_GOAL is 'Current primary permanency plan goal for the child';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.IND_PRIM_PERM_GOAL_ERROR is 'Indicates error or warning related to primary permanency plan goal';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.CD_CONCUR_PERM_GOAL is 'Current secondary permanency plan goal for the child';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.IND_CONCUR_PERM_GOAL_ERROR is 'Indicates error or warning related to current permanency plan goal';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.DT_LAST_CASE_PLAN_REVIEW is 'Date of the most recent case plan review';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.IND_LAST_CASE_PLAN_REVIEW_ERR is 'Indicates error or warning related to case plan review date';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.DT_LAST_PERMANENCY_REVIEW is 'Date of the most recent permanency review';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.IND_LAST_PERMANENCY_REVIEW_ERR is 'Indicates error or warning related to the permanency review date';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.DT_LAST_FTM is 'Date of the last Family Team Meeting';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.IND_ERROR_FTM is 'Indicates error or warning related to the Family Team Meeting date';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.DT_ELIG_DUE_DATE is 'Date eligiblity determination or re-determination is due';
comment on column caps.CW_FC_CP_REVIEW_FACTORS.IND_ELIG_DUE_DATE_ERROR is 'Indicates error or warning related to the eligiblity determination date';

create index CAPS.IND_CW_FC_CP_REVIEW_FACTORS_1 on caps.CW_FC_CP_REVIEW_FACTORS (ID_CASE) tablespace index01; 

CREATE SEQUENCE  CAPS.SEQ_CW_FC_CP_REVIEW_FACTORS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ; 

grant select on CAPS.SEQ_CW_FC_CP_REVIEW_FACTORS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_CP_REVIEW_FACTORS to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_CP_REVIEW_FACTORS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_CP_REVIEW_FACTORS 
BEFORE UPDATE 
ON CAPS.CW_FC_CP_REVIEW_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_CP_REVIEW_FACTORS 
BEFORE INSERT 
ON CAPS.CW_FC_CP_REVIEW_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
     DECLARE dummy number; 
BEGIN 
     :NEW.DT_LAST_UPDATE := sysdate; 
      if :NEW.ID_CW_FC_CP_REVIEW_FACTORS=0 then  
           SELECT SEQ_CW_FC_CP_REVIEW_FACTORS.NEXTVAL INTO dummy  FROM DUAL; 
           :NEW.ID_CW_FC_CP_REVIEW_FACTORS := dummy; 
      end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_TPR_FACTORS
(ID_CW_FC_TPR_FACTORS Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
NBR_IN_CARE_LAST_22 Number(2),
IND_ERROR_IN_CARE_LAST_22 varchar2(1),
IND_IN_CARE_CURRENT varchar2(1),
IND_IN_CARE_CURRENT_MIN_1 varchar2(1),
IND_IN_CARE_CURRENT_MIN_2 varchar2(1),
IND_IN_CARE_CURRENT_MIN_3 varchar2(1),
IND_IN_CARE_CURRENT_MIN_4 varchar2(1),
IND_IN_CARE_CURRENT_MIN_5 varchar2(1),
IND_IN_CARE_CURRENT_MIN_6 varchar2(1),
IND_IN_CARE_CURRENT_MIN_7 varchar2(1),
IND_IN_CARE_CURRENT_MIN_8 varchar2(1),
IND_IN_CARE_CURRENT_MIN_9 varchar2(1),
IND_IN_CARE_CURRENT_MIN_10 varchar2(1),
IND_IN_CARE_CURRENT_MIN_11 varchar2(1),
IND_IN_CARE_CURRENT_MIN_12 varchar2(1),
IND_IN_CARE_CURRENT_MIN_13 varchar2(1),
IND_IN_CARE_CURRENT_MIN_14 varchar2(1),
IND_IN_CARE_CURRENT_MIN_15 varchar2(1),
IND_IN_CARE_CURRENT_MIN_16 varchar2(1),
IND_IN_CARE_CURRENT_MIN_17 varchar2(1),
IND_IN_CARE_CURRENT_MIN_18 varchar2(1),
IND_IN_CARE_CURRENT_MIN_19 varchar2(1),
IND_IN_CARE_CURRENT_MIN_20 varchar2(1),
IND_IN_CARE_CURRENT_MIN_21 varchar2(1),
MO_CURRENT varchar2(6),
MO_CURRENT_MIN_1 varchar2(6),
MO_CURRENT_MIN_2 varchar2(6),
MO_CURRENT_MIN_3 varchar2(6),
MO_CURRENT_MIN_4 varchar2(6),
MO_CURRENT_MIN_5 varchar2(6),
MO_CURRENT_MIN_6 varchar2(6),
MO_CURRENT_MIN_7 varchar2(6),
MO_CURRENT_MIN_8 varchar2(6),
MO_CURRENT_MIN_9 varchar2(6),
MO_CURRENT_MIN_10 varchar2(6),
MO_CURRENT_MIN_11 varchar2(6),
MO_CURRENT_MIN_12 varchar2(6),
MO_CURRENT_MIN_13 varchar2(6),
MO_CURRENT_MIN_14 varchar2(6),
MO_CURRENT_MIN_15 varchar2(6),
MO_CURRENT_MIN_16 varchar2(6),
MO_CURRENT_MIN_17 varchar2(6),
MO_CURRENT_MIN_18 varchar2(6),
MO_CURRENT_MIN_19 varchar2(6),
MO_CURRENT_MIN_20 varchar2(6),
MO_CURRENT_MIN_21 varchar2(6),
IND_CP_ASFA_REG varchar2(1),
IND_CP_ASFA_REG_ERROR varchar2(1),
IND_CP_TPR_COMMENTS varchar2(1),
IND_CP_TPR_COMMENT_ERROR varchar2(1),
CONSTRAINT PK_CW_FC_TPR_FACTORS PRIMARY KEY (ID_CW_FC_TPR_FACTORS) using index tablespace index01, 
CONSTRAINT FK_CW_FC_TPR_FACTORS_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE,
CONSTRAINT FK_CW_FC_TPR_FACTORS_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE ) tablespace data01;


comment on column caps.CW_FC_TPR_FACTORS.ID_CW_FC_TPR_FACTORS is 'Unique primary key';
comment on column caps.CW_FC_TPR_FACTORS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_TPR_FACTORS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_TPR_FACTORS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_TPR_FACTORS.NBR_IN_CARE_LAST_22 is 'Number of months the child has been in care out of the last 22';
comment on column caps.CW_FC_TPR_FACTORS.IND_ERROR_IN_CARE_LAST_22 is 'Error or warning indicator tied to 15 out of 22 measure';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT is 'Indicates if child is in care current month';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_1 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_2 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_3 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_4 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_5 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_6 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_7 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_8 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_9 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_10 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_11 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_12 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_13 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_14 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_15 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_16 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_17 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_18 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_19 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_20 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_IN_CARE_CURRENT_MIN_21 is 'Indicates if child is care 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT is 'Month/year of current month format 3 letter month - two number year';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_1 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_2 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_3 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_4 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_5 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_6 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_7 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_8 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_9 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_10 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_11 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_12 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_13 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_14 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_15 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_16 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_17 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_18 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_19 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_20 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.MO_CURRENT_MIN_21 is 'Month/year of prior month, 1 to 21 months prior';
comment on column caps.CW_FC_TPR_FACTORS.IND_CP_ASFA_REG is 'Indicates if 15 of 22 months is indicated on the current case plan';
comment on column caps.CW_FC_TPR_FACTORS.IND_CP_ASFA_REG_ERROR is 'Indicates warning or error tied to current case plan ASFA flag';
comment on column caps.CW_FC_TPR_FACTORS.IND_CP_TPR_COMMENTS is 'Indicates if TPR comments are included on current child case plan';
comment on column caps.CW_FC_TPR_FACTORS.IND_CP_TPR_COMMENT_ERROR is 'Indicates warning or error tied to TPR comments';

create index CAPS.IND_CW_FC_TPR_FACTORS_1 on caps.CW_FC_TPR_FACTORS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_FC_TPR_FACTORS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_FC_TPR_FACTORS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_TPR_FACTORS to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_TPR_FACTORS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_TPR_FACTORS 
BEFORE UPDATE 
ON CAPS.CW_FC_TPR_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
      :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_TPR_FACTORS 
BEFORE INSERT 
ON CAPS.CW_FC_TPR_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
       DECLARE dummy number; 
BEGIN 
       :NEW.DT_LAST_UPDATE := sysdate; 
        if :NEW.ID_CW_FC_TPR_FACTORS=0 then  
            SELECT SEQ_CW_FC_TPR_FACTORS.NEXTVAL INTO dummy  FROM DUAL; 
            :NEW.ID_CW_FC_TPR_FACTORS := dummy; 
        end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_TPR_BY_ROLE
(ID_CW_FC_TPR_BY_ROLE Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
TXT_TPR_ROLE varchar2(7),
ID_PARENT Number(16,0),
CD_RELATIONSHIP varchar2(3),
DT_TPR_FILED Date,
DT_TPR_VS_GRANTED Date,
DT_DEATH Date,
IND_TPR_ERROR varchar2(1),
CONSTRAINT PK_CW_FC_TPR_BY_ROLE PRIMARY KEY (ID_CW_FC_TPR_BY_ROLE) using index tablespace index01, 
CONSTRAINT FK_CW_FC_TPR_BY_ROLE_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_FC_TPR_BY_ROLE_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_FC_TPR_BY_ROLE_PERSON FOREIGN KEY (ID_PARENT) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE) tablespace data01;

comment on column caps.CW_FC_TPR_BY_ROLE.ID_CW_FC_TPR_BY_ROLE is 'Unique primary key';
comment on column caps.CW_FC_TPR_BY_ROLE.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_TPR_BY_ROLE.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_TPR_BY_ROLE.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_TPR_BY_ROLE.TXT_TPR_ROLE is 'TPR role - Mother or Father';
comment on column caps.CW_FC_TPR_BY_ROLE.ID_PARENT is 'Person ID of the person with a parental relationship to be severed';
comment on column caps.CW_FC_TPR_BY_ROLE.CD_RELATIONSHIP is 'Relationship of person to child as recorded in current stage';
comment on column caps.CW_FC_TPR_BY_ROLE.DT_TPR_FILED is 'Date TPR filed';
comment on column caps.CW_FC_TPR_BY_ROLE.DT_TPR_VS_GRANTED is 'Date TPR or Voluntary Surrender Granted';
comment on column caps.CW_FC_TPR_BY_ROLE.DT_DEATH is 'Date of death of the parent';
comment on column caps.CW_FC_TPR_BY_ROLE.IND_TPR_ERROR is 'Indicator of error or warning for missing TPR information';

create index CAPS.IND_CW_FC_TPR_BY_ROLE_1 on caps.CW_FC_TPR_BY_ROLE (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_FC_TPR_BY_ROLE  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_FC_TPR_BY_ROLE  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_TPR_BY_ROLE to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_TPR_BY_ROLE to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_TPR_BY_ROLE 
BEFORE UPDATE
ON CAPS.CW_FC_TPR_BY_ROLE 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_TPR_BY_ROLE 
BEFORE INSERT 
ON CAPS.CW_FC_TPR_BY_ROLE 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
       DECLARE dummy number; 
BEGIN 
       :NEW.DT_LAST_UPDATE := sysdate; 
        if :NEW.ID_CW_FC_TPR_BY_ROLE=0 then  
                SELECT SEQ_CW_FC_TPR_BY_ROLE.NEXTVAL INTO dummy  FROM DUAL; 
                :NEW.ID_CW_FC_TPR_BY_ROLE := dummy; 
        end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_HEALTH_SCREENS
(ID_CW_FC_HEALTH_SCREENS Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
DT_LAST_MEDICAL Date,
IND_ERROR_LAST_MEDICAL varchar2(1),
DT_LAST_PSYCH Date,
IND_ERROR_LAST_PSYCH varchar2(1),
DT_LAST_DENTAL Date,
IND_ERROR_LAST_DENTAL varchar2(1),
DT_LAST_DEVELOPMENTAL Date,
IND_ERROR_LAST_DEVELOPMENTAL varchar2(1),
CONSTRAINT PK_CW_FC_HEALTH_SCREENS PRIMARY KEY (ID_CW_FC_HEALTH_SCREENS) using index tablespace index01, 
CONSTRAINT FK_CW_FC_HEALTH_SCREENS_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_FC_HEALTH_SCREENS_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE ) tablespace data01;


comment on column caps.CW_FC_HEALTH_SCREENS.ID_CW_FC_HEALTH_SCREENS is 'Unique primary key';
comment on column caps.CW_FC_HEALTH_SCREENS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_HEALTH_SCREENS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_HEALTH_SCREENS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_HEALTH_SCREENS.DT_LAST_MEDICAL is 'Date of most recent medical exam';
comment on column caps.CW_FC_HEALTH_SCREENS.IND_ERROR_LAST_MEDICAL is 'Indicator for errors or warnings related to last medical exam';
comment on column caps.CW_FC_HEALTH_SCREENS.DT_LAST_PSYCH is 'Date of most recent psychological screen';
comment on column caps.CW_FC_HEALTH_SCREENS.IND_ERROR_LAST_PSYCH is 'Indicator for errors or warnings related to last psychological screen';
comment on column caps.CW_FC_HEALTH_SCREENS.DT_LAST_DENTAL is 'Date of most recent dental exam';
comment on column caps.CW_FC_HEALTH_SCREENS.IND_ERROR_LAST_DENTAL is 'Indicator for errors or warnings related to last dental exam';
comment on column caps.CW_FC_HEALTH_SCREENS.DT_LAST_DEVELOPMENTAL is 'Date of most recent developmental assessment';
comment on column caps.CW_FC_HEALTH_SCREENS.IND_ERROR_LAST_DEVELOPMENTAL is 'Indicator for errors or warnings related to last developmental assessment';

create index CAPS.IND_CW_FC_HEALTH_SCREENS_1 on caps.CW_FC_HEALTH_SCREENS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_FC_HEALTH_SCREENS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_FC_HEALTH_SCREENS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_HEALTH_SCREENS to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_HEALTH_SCREENS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_HEALTH_SCREENS 
BEFORE UPDATE 
ON CAPS.CW_FC_HEALTH_SCREENS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
    :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_HEALTH_SCREENS 
BEFORE INSERT 
ON CAPS.CW_FC_HEALTH_SCREENS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
     DECLARE dummy number; 
BEGIN 
     :NEW.DT_LAST_UPDATE := sysdate; 
     if :NEW.ID_CW_FC_HEALTH_SCREENS=0 then  
         SELECT SEQ_CW_FC_HEALTH_SCREENS.NEXTVAL INTO dummy  FROM DUAL; 
         :NEW.ID_CW_FC_HEALTH_SCREENS := dummy; 
     end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_CASA_GAL
(ID_CW_FC_CASA_GAL Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_PERSON Number(16,0) not null,
CD_RELATIONSHIP varchar2(3),
CONSTRAINT PK_CW_FC_CASA_GAL PRIMARY KEY (ID_CW_FC_CASA_GAL) using index tablespace index01, 
CONSTRAINT FK_CW_FC_CASA_GAL_STAGE FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_FC_CASA_GAL_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_FC_CASA_GAL_PERSON FOREIGN KEY (ID_PERSON) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE ) tablespace data01;

comment on column caps.CW_FC_CASA_GAL.ID_CW_FC_CASA_GAL is 'Unique primary key';
comment on column caps.CW_FC_CASA_GAL.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_CASA_GAL.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_CASA_GAL.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_CASA_GAL.ID_PERSON is 'SHINES Person ID of the CASA or GAL';
comment on column caps.CW_FC_CASA_GAL.CD_RELATIONSHIP is 'Relationship of the CASA or GAL to the child';

create index CAPS.IND_CW_FC_CASA_GAL_1 on caps.CW_FC_CASA_GAL (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_FC_CASA_GAL  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_FC_CASA_GAL  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_CASA_GAL to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_CASA_GAL to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_CASA_GAL 
BEFORE UPDATE 
ON CAPS.CW_FC_CASA_GAL 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_CASA_GAL 
BEFORE INSERT 
ON CAPS.CW_FC_CASA_GAL 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
       DECLARE dummy number; 
BEGIN 
       :NEW.DT_LAST_UPDATE := sysdate; 
       if :NEW.ID_CW_FC_CASA_GAL=0 then  
            SELECT SEQ_CW_FC_CASA_GAL.NEXTVAL INTO dummy  FROM DUAL; 
            :NEW.ID_CW_FC_CASA_GAL := dummy; 
       end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_PARENTAL_CONTACTS
(ID_CW_FC_PARENTAL_CONTACTS Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_PARENT Number(16,0) not null,
CD_RELATIONSHIP varchar2(3),
DT_MOST_RECENT_CONTACT Date,
IND_ERROR varchar2(1),
CONSTRAINT PK_CW_FC_PARENTAL_CONTACTS PRIMARY KEY (ID_CW_FC_PARENTAL_CONTACTS) using index tablespace index01, 
CONSTRAINT FK_CW_FC_PARENTAL_CONT_STG FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_FC_PARENTAL_CONT_CASE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_FC_PARENTAL_CONT_PERSON FOREIGN KEY (ID_PARENT) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE) tablespace data01;

comment on column caps.CW_FC_PARENTAL_CONTACTS.ID_CW_FC_PARENTAL_CONTACTS is 'Unique primary key';
comment on column caps.CW_FC_PARENTAL_CONTACTS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_PARENTAL_CONTACTS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_PARENTAL_CONTACTS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_PARENTAL_CONTACTS.ID_PARENT is 'SHINES Person ID of the parent';
comment on column caps.CW_FC_PARENTAL_CONTACTS.CD_RELATIONSHIP is 'Relationship of parent to child';
comment on column caps.CW_FC_PARENTAL_CONTACTS.DT_MOST_RECENT_CONTACT is 'Date of most recent face to face contact with the parent';
comment on column caps.CW_FC_PARENTAL_CONTACTS.IND_ERROR is 'Indcates error or warning tied to date of last parental contact';

create index CAPS.IND_CW_FC_PARENTAL_CONTACTS_1 on caps.CW_FC_PARENTAL_CONTACTS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_FC_PARENTAL_CONTACTS  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_FC_PARENTAL_CONTACTS  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_PARENTAL_CONTACTS to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_PARENTAL_CONTACTS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_PARENTAL_CONTACTS 
BEFORE UPDATE 
ON CAPS.CW_FC_PARENTAL_CONTACTS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
    :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_PARENTAL_CONTACTS 
BEFORE INSERT 
ON CAPS.CW_FC_PARENTAL_CONTACTS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
       DECLARE dummy number; 
BEGIN 
       :NEW.DT_LAST_UPDATE := sysdate; 
       if :NEW.ID_CW_FC_PARENTAL_CONTACTS=0 then  
            SELECT SEQ_CW_FC_PARENTAL_CONTACTS.NEXTVAL INTO dummy  FROM DUAL; 
            :NEW.ID_CW_FC_PARENTAL_CONTACTS := dummy; 
       end if; 
END; 
/


CREATE TABLE CAPS.CW_FC_CI_CONTACT_ADDL_FACTORS
(ID_CW_FC_CI_CNTCT_ADDL_FACT Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_STAGE Number(16,0) not null,
ID_CASE Number(16,0) not null,
ID_ILP_COORDINATOR_ASSIGNED Number(16,0),
IND_ILP_ASSIGNMENT_ERROR varchar2(1),
ID_ILP_COORDINATOR_WTLP Number(16,0),
IND_ILP_WTLP_ERROR varchar2(1),
DT_MOST_RECENT_DILIGENT_SEARCH Date,
IND_DIL_SEARCH_ERROR varchar2(1),
DT_MOST_RECENT_SIBLING_CONTACT Date,
IND_SIB_CONTACT_ERROR varchar2(1),
CONSTRAINT PK_CW_FC_CI_CNTCT_ADDL_FACT PRIMARY KEY (ID_CW_FC_CI_CNTCT_ADDL_FACT) using index tablespace index01, 
CONSTRAINT FK_CW_FC_CI_CNT_ADDL_FACT_STG FOREIGN KEY (ID_STAGE) 
           REFERENCES CAPS.STAGE(ID_STAGE) ENABLE, 
CONSTRAINT FK_CW_FC_CI_CNT_ADDL_FACT_CSE FOREIGN KEY (ID_CASE) 
           REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE, 
CONSTRAINT FK_CW_FC_CI_CNT_ADDL_FACT_P1 FOREIGN KEY (ID_ILP_COORDINATOR_ASSIGNED) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE,
CONSTRAINT FK_CW_FC_CI_CNT_ADDL_FACT_P2 FOREIGN KEY (ID_ILP_COORDINATOR_WTLP) 
           REFERENCES CAPS.PERSON(ID_PERSON) ENABLE) tablespace data01;


comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.ID_CW_FC_CI_CNTCT_ADDL_FACT is 'Unique primary key';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.ID_STAGE is 'SHINES Stage for the Case Watch Factors';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.ID_CASE is 'SHINES Case for the Case Watch factors';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.ID_ILP_COORDINATOR_ASSIGNED is 'Employee Person ID for the ILP coordinator assigned as a secondary to the case';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.IND_ILP_ASSIGNMENT_ERROR is 'Indicator for warning or error tied to ILP coordinator assignment';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.ID_ILP_COORDINATOR_WTLP is 'Employee Person ID for the ILP coordinator assigned on the current approved WTLP';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.IND_ILP_WTLP_ERROR is 'Indicator for warning or error tied to ILP coordinator on WTLP';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.DT_MOST_RECENT_DILIGENT_SEARCH is 'Date of the most recent contact of type Diligent Search';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.IND_DIL_SEARCH_ERROR is 'Indicator for warning or error tied to the date of the most recent diligent search';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.DT_MOST_RECENT_SIBLING_CONTACT is 'Date fo the most recent contact of type "Sibling Visit"';
comment on column caps.CW_FC_CI_CONTACT_ADDL_FACTORS.IND_SIB_CONTACT_ERROR is 'Indicator for warning or error tied to the most recent sibling contact date';

create index CAPS.IND_CW_FC_CI_CNTCT_ADDL_FACT_1 on caps.CW_FC_CI_CONTACT_ADDL_FACTORS (ID_CASE) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_CW_FC_CI_CNTCT_ADDL_FACT  NOMINVALUE NOMAXVALUE INCREMENT 
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CW_FC_CI_CNTCT_ADDL_FACT  to capsbat,capson,ops$datafix;

grant select,update,insert,delete on caps.CW_FC_CI_CONTACT_ADDL_FACTORS to capson,capsbat,ops$datafix;
grant select on caps.CW_FC_CI_CONTACT_ADDL_FACTORS to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CW_FC_CI_CNTCT_ADDL_FACT 
BEFORE UPDATE 
ON CAPS.CW_FC_CI_CONTACT_ADDL_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CW_FC_CI_CNTCT_ADDL_FACT
BEFORE INSERT 
ON CAPS.CW_FC_CI_CONTACT_ADDL_FACTORS 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
      DECLARE dummy number; 
BEGIN 
      :NEW.DT_LAST_UPDATE := sysdate; 
       if :NEW.ID_CW_FC_CI_CNTCT_ADDL_FACT=0 then  
               SELECT SEQ_CW_FC_CI_CNTCT_ADDL_FACT.NEXTVAL INTO dummy  
               FROM DUAL; :NEW.ID_CW_FC_CI_CNTCT_ADDL_FACT := dummy; 
       end if; 
END; 
/


CREATE TABLE CAPS.CASE_WATCH_FACTOR_HELP
(TXT_CASE_WATCH_FACTOR varchar2(30) not null,
DT_LAST_UPDATE Date not null,
TXT_CASE_WATCH_FACTOR_HLP_TXT varchar2(1500),
CONSTRAINT PK_CASE_WATCH_FACTOR_HELP PRIMARY KEY (TXT_CASE_WATCH_FACTOR) using index tablespace index01 ) tablespace data01;


comment on column caps.CASE_WATCH_FACTOR_HELP.TXT_CASE_WATCH_FACTOR is 'Name of case watch factor';
comment on column caps.CASE_WATCH_FACTOR_HELP.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.CASE_WATCH_FACTOR_HELP.TXT_CASE_WATCH_FACTOR_HLP_TXT is 'Help text to display in pop-up when help link is clicked for the factor';

grant select,update,insert,delete on caps.CASE_WATCH_FACTOR_HELP to capson,capsbat,ops$datafix;
grant select on caps.CASE_WATCH_FACTOR_HELP to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CASE_WATCH_FACTOR_HELP 
BEFORE UPDATE ON CAPS.CASE_WATCH_FACTOR_HELP 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
       :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CASE_WATCH_FACTOR_HELP 
BEFORE INSERT 
ON CAPS.CASE_WATCH_FACTOR_HELP 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
       :NEW.DT_LAST_UPDATE := sysdate; 
END; 
/


CREATE TABLE CAPS.AFCARS_ELEMENT_HELP 
(TXT_AFCARS_ELEMENT_SHORT varchar2(30) not null,
DT_LAST_UPDATE Date not null,
NBR_AFCARS_ORDER Number(3) not null,
TXT_AFCARS_ELEMENT varchar2(30),
TXT_AFCARS_ELEMENT_LABEL varchar2(300),
CD_AFCARS_DATA_TYPE varchar2(1),
TXT_AFCARS_CODES_TABLE varchar2(8),
TXT_AFCARS_SOURCE_TEXT varchar2(300),
TXT_AFCARS_ELEMENT_HELP_TEXT varchar2(1500),
CONSTRAINT PK_AFCARS_ELEMENT_HELP PRIMARY KEY (TXT_AFCARS_ELEMENT_SHORT) using index tablespace index01 ) tablespace data01;


comment on column caps.AFCARS_ELEMENT_HELP.TXT_AFCARS_ELEMENT_SHORT is 'Short name i.e. AFCARS_FC_1';
comment on column caps.AFCARS_ELEMENT_HELP.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.AFCARS_ELEMENT_HELP.NBR_AFCARS_ORDER is 'Order of the element in the AFCARS file';
comment on column caps.AFCARS_ELEMENT_HELP.TXT_AFCARS_ELEMENT is 'Name of AFCARS data element';
comment on column caps.AFCARS_ELEMENT_HELP.TXT_AFCARS_ELEMENT_LABEL is 'Element label do be displayed on the SHINES Case Watch page';
comment on column caps.AFCARS_ELEMENT_HELP.CD_AFCARS_DATA_TYPE is 'Data Type - T for Text, D for Date, C for code';
comment on column caps.AFCARS_ELEMENT_HELP.TXT_AFCARS_CODES_TABLE is 'Codes table used to decode AFCARS value on display';
comment on column caps.AFCARS_ELEMENT_HELP.TXT_AFCARS_SOURCE_TEXT is 'HTML text for source column, including javacript references';
comment on column caps.AFCARS_ELEMENT_HELP.TXT_AFCARS_ELEMENT_HELP_TEXT is 'Help text to display in pop-up when help link is clicked for the element';

grant select,update,insert,delete on caps.AFCARS_ELEMENT_HELP to capson,capsbat,ops$datafix;
grant select on caps.AFCARS_ELEMENT_HELP to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_AFCARS_ELEMENT_HELP 
BEFORE UPDATE 
ON CAPS.AFCARS_ELEMENT_HELP 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
        :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_AFCARS_ELEMENT_HELP 
BEFORE INSERT 
ON CAPS.AFCARS_ELEMENT_HELP 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW BEGIN 
      :NEW.DT_LAST_UPDATE := sysdate; 
END; 
/


CREATE TABLE CAPS.NCANDS_ELEMENT_HELP 
(TXT_NCANDS_ELEMENT_SHORT varchar2(30) not null,
DT_LAST_UPDATE Date not null,
NBR_NCANDS_ORDER Number(3) not null,
TXT_NCANDS_ELEMENT varchar2(30),
IND_NCANDS_ELEMENT_ACTIVE varchar2(1),
TXT_NCANDS_ELEMENT_LABEL varchar2(300),
CD_NCANDS_DATA_TYPE varchar2(1),
TXT_NCANDS_CODES_TABLE varchar2(8),
TXT_NCANDS_SOURCE_TEXT varchar2(300),
TXT_NCANDS_ELEMENT_HELP_TEXT varchar2(1500),
CONSTRAINT PK_NCANDS_ELEMENT_HELP PRIMARY KEY (TXT_NCANDS_ELEMENT_SHORT) using index tablespace index01 ) tablespace data01;


comment on column caps.NCANDS_ELEMENT_HELP.TXT_NCANDS_ELEMENT_SHORT is 'Short name i.e. NCANDS_1';
comment on column caps.NCANDS_ELEMENT_HELP.DT_LAST_UPDATE is 'System date of the last row update';
comment on column caps.NCANDS_ELEMENT_HELP.NBR_NCANDS_ORDER is 'Order of the element in the NCANDS file';
comment on column caps.NCANDS_ELEMENT_HELP.TXT_NCANDS_ELEMENT is 'Name of NCANDS data element';
comment on column caps.NCANDS_ELEMENT_HELP.IND_NCANDS_ELEMENT_ACTIVE is 'Indicates if the element is reported in the current NCANDS file';
comment on column caps.NCANDS_ELEMENT_HELP.TXT_NCANDS_ELEMENT_LABEL is 'Element label do be displayed on the SHINES Case Watch page';
comment on column caps.NCANDS_ELEMENT_HELP.CD_NCANDS_DATA_TYPE is 'Data Type - T for Text, D for Date, C for code';
comment on column caps.NCANDS_ELEMENT_HELP.TXT_NCANDS_CODES_TABLE is 'Codes table used to decode NCANDS value on display';
comment on column caps.NCANDS_ELEMENT_HELP.TXT_NCANDS_SOURCE_TEXT is 'HTML text for source column, including javacript references';
comment on column caps.NCANDS_ELEMENT_HELP.TXT_NCANDS_ELEMENT_HELP_TEXT is 'Help text to display in pop-up when help link is clicked for the element';

grant select,update,insert,delete on caps.NCANDS_ELEMENT_HELP to capson,capsbat,ops$datafix;
grant select on caps.NCANDS_ELEMENT_HELP to operator;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_NCANDS_ELEMENT_HELP 
BEFORE UPDATE 
ON CAPS.NCANDS_ELEMENT_HELP 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
BEGIN 
     :new.DT_LAST_UPDATE := SYSDATE; 
END; 
/ 
/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_NCANDS_ELEMENT_HELP 
BEFORE INSERT 
ON CAPS.NCANDS_ELEMENT_HELP 
REFERENCING OLD AS OLD NEW AS NEW 
FOR EACH ROW 
BEGIN 
     :NEW.DT_LAST_UPDATE := sysdate; 
END; 
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (623, 'SacwisRev3', 'Release 3.4 - DBCR 15620');

commit;


