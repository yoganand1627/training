--STGAP00015796 - Release(3.43) MR-62: Add new tables and alter PPT

--Per MR-62 Contact Standards Page add new table CONTACT_STANDARDS

CREATE TABLE CAPS.CONTACT_STANDARDS
(ID_CONTACT_STDS_EVENT Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_CASE Number(16,0) not null,
ID_STAGE Number(16,0) not null,
DT_EFFECTIVE_START Date,
DT_EFFECTIVE_END Date,
IND_SUPER_APPROVAL Varchar2(1),
IND_CM_ACKNOWLEDGE Varchar2(1),
TXT_REASON_FOR_CHANGE Varchar(1000),
CONSTRAINT PK_CONTACT_STANDARDS PRIMARY KEY(ID_CONTACT_STDS_EVENT) using index tablespace index01,
CONSTRAINT FK_CONTACT_STDS_EVENT FOREIGN KEY (ID_CONTACT_STDS_EVENT)
   REFERENCES CAPS.EVENT(ID_EVENT),
CONSTRAINT FK_CONTACT_STDS_CASE FOREIGN KEY (ID_CASE)
   REFERENCES CAPS.CAPS_CASE(ID_CASE),
   CONSTRAINT FK_CONTACT_STDS_STAGE FOREIGN KEY (ID_STAGE)
   REFERENCES CAPS.STAGE(ID_STAGE)
 ) tablespace data01;

create index caps.IND_CONTACT_STANDARDS_1 on CAPS.CONTACT_STANDARDS(id_case) tablespace index01;
create index caps.IND_CONTACT_STANDARDS_2 on CAPS.CONTACT_STANDARDS(id_stage) tablespace index01;


comment on column CAPS.CONTACT_STANDARDS.ID_CONTACT_STDS_EVENT is 'Primary Key' ;
comment on column CAPS.CONTACT_STANDARDS.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.CONTACT_STANDARDS.ID_CASE is 'Records case id. Foreign key to CASE.ID_CASE' ;
comment on column CAPS.CONTACT_STANDARDS.DT_EFFECTIVE_START is 'Records the effective start date of the contact standards' ;
comment on column CAPS.CONTACT_STANDARDS.DT_EFFECTIVE_END is 'Records the effective end date of the contact standards' ;
comment on column CAPS.CONTACT_STANDARDS.IND_SUPER_APPROVAL is 'Indicates if supervisor acknowledges the completeness of the contact standards' ;
comment on column CAPS.CONTACT_STANDARDS.IND_CM_ACKNOWLEDGE is 'Indicates that case managers acknowledge the effect of their decision' ;
comment on column CAPS.CONTACT_STANDARDS.TXT_REASON_FOR_CHANGE is 'Comments to specify the reason for the change to the contact standards' ;

grant select,update,insert,delete on caps.CONTACT_STANDARDS to capson,capsbat,ops$datafix;
grant select on caps.CONTACT_STANDARDS to operator,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CONTACT_STANDARDS
BEFORE UPDATE
ON CAPS.CONTACT_STANDARDS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CONTACT_STANDARDS
BEFORE INSERT
ON CAPS.CONTACT_STANDARDS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


--Per MR-62 Contact Standards Page add new table PARENT_CONTACT_RULE

CREATE TABLE CAPS.PARENT_CONTACT_RULE
(ID_PARENT_CONTACT_RULE Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_CONTACT_STDS_EVENT Number(16,0) not null,
ID_PERSON Number(16,0) not null,
NBR_CONTACTS_PER_MONTH NUMBER(2),
IND_BY_FACE_TO_FACE Varchar2(1),
IND_BY_TELEPHONE Varchar2(1),
IND_BY_EMAIL_CORRSPNDNCE Varchar2(1),
CD_CONTACT_NOT_REQUIRED Varchar2(1),
TXT_JUSTIFICATION Varchar(1000),
IND_PREPOPULATED Varchar2(1),
CONSTRAINT PK_PARENT_CONTACT_RULE PRIMARY KEY(ID_PARENT_CONTACT_RULE) using index tablespace index01,
CONSTRAINT FK_PARENT_CNTCT_RULE_EVENT FOREIGN KEY (ID_CONTACT_STDS_EVENT)
   REFERENCES CAPS.EVENT(ID_EVENT),
CONSTRAINT FK_PARENT_CNTCT_PERSON FOREIGN KEY (ID_PERSON)
   REFERENCES CAPS.PERSON(ID_PERSON)
 ) tablespace data01;

create index caps.IND_PARENT_CONTACT_RULE_1 on CAPS.PARENT_CONTACT_RULE(ID_CONTACT_STDS_EVENT) tablespace index01;
create index caps.IND_PARENT_CONTACT_RULE_2 on CAPS.PARENT_CONTACT_RULE(ID_PERSON) tablespace index01;


comment on column CAPS.PARENT_CONTACT_RULE.ID_PARENT_CONTACT_RULE is 'Primary Key' ;
comment on column CAPS.PARENT_CONTACT_RULE.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.PARENT_CONTACT_RULE.ID_CONTACT_STDS_EVENT is 'Records contact standards event id. Foreign key to CONTACT_STANDARDS.ID_CONTACT_STDS_EVENT' ;
comment on column CAPS.PARENT_CONTACT_RULE.ID_PERSON is 'Records person id of the person who the parent contact rule is for. Foreign key to PERSON.ID_PERSON' ;
comment on column CAPS.PARENT_CONTACT_RULE.NBR_CONTACTS_PER_MONTH is 'Used to record the number of contacts per month' ;
comment on column CAPS.PARENT_CONTACT_RULE.IND_BY_FACE_TO_FACE is 'Indicates an acceptable contact method' ;
comment on column CAPS.PARENT_CONTACT_RULE.IND_BY_TELEPHONE is 'Indicates an acceptable contact method' ;
comment on column CAPS.PARENT_CONTACT_RULE.IND_BY_EMAIL_CORRSPNDNCE is 'Indicates an acceptable contact method' ;
comment on column CAPS.PARENT_CONTACT_RULE.CD_CONTACT_NOT_REQUIRED is 'a code for the reason why contact is not required for the person' ;
comment on column CAPS.PARENT_CONTACT_RULE.TXT_JUSTIFICATION is 'Comments to justify the contact not required reason' ;
comment on column CAPS.PARENT_CONTACT_RULE.IND_PREPOPULATED is 'Indicates parent standard rule was prepopulated rather than manually addded' ;



grant select,update,insert,delete on caps.PARENT_CONTACT_RULE to capson,capsbat,ops$datafix;
grant select on caps.PARENT_CONTACT_RULE to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_PARENT_CONTACT_RULE  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_PARENT_CONTACT_RULE  to capsbat,capson,ops$datafix,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PARENT_CONTACT_RULE
BEFORE UPDATE
ON CAPS.PARENT_CONTACT_RULE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PARENT_CONTACT_RULE
BEFORE INSERT
ON CAPS.PARENT_CONTACT_RULE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_PARENT_CONTACT_RULE=0 then
    SELECT SEQ_PARENT_CONTACT_RULE.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_PARENT_CONTACT_RULE := dummy;
  end if;
END;
/


--Per MR-62 MR-62 Contact Standards Page add new table CONTACT_FOR

CREATE TABLE CAPS.CONTACT_FOR
(ID_CHILD Number(16,0) not null,
ID_PARENT_CONTACT_RULE Number(16,0) not null,
DT_LAST_UPDATE Date not null,
IND_CONTACT_FOR Varchar2(1),
CONSTRAINT PK_CONTACT_FOR PRIMARY KEY(ID_CHILD,ID_PARENT_CONTACT_RULE) using index tablespace index01,
CONSTRAINT FK_CONTACT_FOR_PERSON FOREIGN KEY (ID_CHILD)
   REFERENCES CAPS.PERSON(ID_PERSON),
CONSTRAINT FK_CONTACT_FOR_PARENT_RULE FOREIGN KEY (ID_PARENT_CONTACT_RULE)
 REFERENCES CAPS.PARENT_CONTACT_RULE(ID_PARENT_CONTACT_RULE)
 ) tablespace data01;

create index caps.IND_CONTACT_FOR_1 on CAPS.CONTACT_FOR(ID_CHILD) tablespace index01;

comment on column CAPS.CONTACT_FOR.ID_CHILD is 'Composite Primary Key' ;
comment on column CAPS.CONTACT_FOR.ID_PARENT_CONTACT_RULE is 'Composite Primary Key' ;
comment on column CAPS.CONTACT_FOR.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.CONTACT_FOR.IND_CONTACT_FOR is 'Indicates a child that the contact is for' ;

grant select,update,insert,delete on caps.CONTACT_FOR to capson,capsbat,ops$datafix;
grant select on caps.CONTACT_FOR to operator,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CONTACT_FOR
BEFORE UPDATE
ON CAPS.CONTACT_FOR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CONTACT_FOR
BEFORE INSERT
ON CAPS.CONTACT_FOR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

--Per MR-62 MR-62 Contact Standards Page add new table CHILD_CONTACT_RULE
CREATE TABLE CAPS.CHILD_CONTACT_RULE
(ID_CHILD_CONTACT_RULE Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_CONTACT_STDS_EVENT Number(16,0) not null,
ID_PERSON Number(16,0) not null,
NBR_CONTACTS_PER_MONTH NUMBER(2),
CONSTRAINT PK_CHILD_CONTACT_RULE PRIMARY KEY(ID_CHILD_CONTACT_RULE) using index tablespace index01,
CONSTRAINT FK_CHILD_CONTACT_RULE_EVENT FOREIGN KEY (ID_CONTACT_STDS_EVENT)
   REFERENCES CAPS.EVENT(ID_EVENT),
CONSTRAINT FK_CHILD_CONTACT_RULE_PERSON FOREIGN KEY (ID_PERSON)
   REFERENCES CAPS.PERSON(ID_PERSON)
 ) tablespace data01;

create index caps.IND_CHILD_CONTACT_RULE_1 on CAPS.CHILD_CONTACT_RULE(ID_CONTACT_STDS_EVENT) tablespace index01;
create index caps.IND_CHILD_CONTACT_RULE_2 on CAPS.CHILD_CONTACT_RULE(ID_PERSON) tablespace index01;


comment on column CAPS.CHILD_CONTACT_RULE.ID_CHILD_CONTACT_RULE is 'Primary Key' ;
comment on column CAPS.CHILD_CONTACT_RULE.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.CHILD_CONTACT_RULE.ID_CONTACT_STDS_EVENT is 'Records contact standards event id. Foreign key to CONTACT_STANDARDS.ID_CONTACT_STDS_EVENT' ;
comment on column CAPS.CHILD_CONTACT_RULE.ID_PERSON is 'Records person id of the person who the child contact rule is for. Foreign key to PERSON.ID_PERSON' ;
comment on column CAPS.CHILD_CONTACT_RULE.NBR_CONTACTS_PER_MONTH is 'Used to record the number of contacts per month' ;


grant select,update,insert,delete on caps.CHILD_CONTACT_RULE to capson,capsbat,ops$datafix;
grant select on caps.CHILD_CONTACT_RULE to operator,shinesdm;


CREATE SEQUENCE  CAPS.SEQ_CHILD_CONTACT_RULE  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CHILD_CONTACT_RULE  to capsbat,capson,ops$datafix,shinesdm;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CHILD_CONTACT_RULE
BEFORE UPDATE
ON CAPS.CHILD_CONTACT_RULE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CHILD_CONTACT_RULE
BEFORE INSERT
ON CAPS.CHILD_CONTACT_RULE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_CHILD_CONTACT_RULE=0 then
    SELECT SEQ_CHILD_CONTACT_RULE.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_CHILD_CONTACT_RULE := dummy;
  end if;
END;
/


--Per MR-62 Add column referencing ID_EVENT of CONTACT_STANDARDS table
ALTER TABLE CAPS.PPT ADD (ID_CONTACT_STDS_EVENT Number(16,0) );
ALTER TABLE CAPS.PPT ADD  CONSTRAINT FK_FIRST_REF_CONTACT_STANDARDS FOREIGN KEY (ID_CONTACT_STDS_EVENT) REFERENCES CAPS.CONTACT_STANDARDS(ID_CONTACT_STDS_EVENT);

comment on column CAPS.PPT.ID_CONTACT_STDS_EVENT is 'Foreign Key to CAPS.CONTACT_STANDARDS.ID_CONTACT_STDS_EVENT' ;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (748, 'SacwisRev3', 'Release 3.43 - DBCR 15796');

commit;


