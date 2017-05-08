-- STGAP00010284 - New field needed for child registration event

-- Note: Impacts Ado model: Hold information for Ado info page

alter table caps.ado_info add (ID_EVENT_CHILD_REGISTRATION number(16));
alter table caps.ado_info add constraint FK_ADO_INFO_EVENT_2 foreign key (ID_EVENT_CHILD_REGISTRATION)
references caps.EVENT(ID_EVENT);
comment on column caps.ado_info.ID_EVENT_CHILD_REGISTRATION is 'Field for child registration event';



-- STGAP00010283 - Need New table for adoption sibling group history

-- Note: Impacts Ado model: Hold information for Ado info page

-- A new table needs to be added to for maintaining the sibling group history of the adoption history page.

create table caps.ADO_SIBLING_HISTORY
(
ID_ADO_SIBLING_HISTORY   NUMBER (16) not null,
ID_ADO_INFO_EVENT NUMBER (16) not null,
ID_PERSON NUMBER (16) not null,
ID_EVENT_CHILD_REGISTRATION NUMBER (16),
CD_NON_AVAIL_STATUS varchar(2),
DT_ADO_INFO_COMPLETE date not null, 
ID_SIBLING_GROUP NUMBER (16),
DT_Last_update Date not null,
constraint PK_ADO_SIBLING_HISTORY PRIMARY KEY (ID_ADO_SIBLING_HISTORY)
using index tablespace index01
) tablespace data01;

create index caps.ind_ado_sibling_history_1 on caps.ADO_SIBLING_HISTORY(id_person) tablespace index01;

alter table CAPS.ADO_SIBLING_HISTORY add constraint FK_SIB_HIST_ADO_INFO foreign key (ID_ADO_INFO_EVENT)
references caps.ADO_INFO(ID_EVENT);

alter table CAPS.ADO_SIBLING_HISTORY add constraint FK_SIB_HIST_PERSON foreign key (ID_PERSON)
references caps.PERSON(ID_PERSON);

alter table CAPS.ADO_SIBLING_HISTORY add constraint FK_SIB_HIST_EX_CHILD foreign key (ID_EVENT_CHILD_REGISTRATION)
references caps.EXCHANGE_CHILD(ID_EVENT);

grant select,update,insert,delete on caps.ADO_SIBLING_HISTORY to capson,capsbat,ops$datafix;
grant select on caps.ADO_SIBLING_HISTORY to operator;

CREATE SEQUENCE  CAPS.SEQ_ADO_SIBLING_HISTORY  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_ADO_SIBLING_HISTORY  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_ADO_SIBLING_HISTORY 
BEFORE UPDATE
ON CAPS.ADO_SIBLING_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ADO_SIBLING_HISTORY
BEFORE INSERT
ON CAPS.ADO_SIBLING_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_ADO_SIBLING_HISTORY=0 then
    SELECT SEQ_ADO_SIBLING_HISTORY.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_ADO_SIBLING_HISTORY := dummy;
  end if;
END;
/

-- STGAP00010291 - Exchange Child - Need a new table for the Recruitment Activities

-- Note: Impacts Ado model: new table records the state recruitment activities that are saved on the Exchange Child Detail page.


CREATE TABLE CAPS.EXC_CHILD_ADO_INFO_CBX
(ID_INFO_CHAR NUMBER(16) NOT NULL,
 DT_LAST_UPDATE DATE NOT NULL,       
ID_EVENT NUMBER(16) NOT NULL,           
CD_ADO_INFO_CBX VARCHAR2(3),
CD_CBX_CODE_TYPE VARCHAR2(8),
CONSTRAINT PK_EXC_CHILD_ADO_INFO_CBX PRIMARY KEY(ID_INFO_CHAR)) TABLESPACE DATA01;

ALTER TABLE CAPS.EXC_CHILD_ADO_INFO_CBX ADD CONSTRAINT FK_EXC_CHD_ADO_CBX_EXC_CHD FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EXCHANGE_CHILD(ID_EVENT);

create index caps.IND_EXC_CHILD_ADO_INFO_CBX_1 on CAPS.EXC_CHILD_ADO_INFO_CBX(ID_EVENT) tablespace index01;

comment on table CAPS.EXC_CHILD_ADO_INFO_CBX is 'Records the state recruitment activities that are saved on the Exchange Child Detail page';
comment on column CAPS.EXC_CHILD_ADO_INFO_CBX.ID_EVENT is 'Event Id of the Exchange Child Registration event to which the recruitment activity is associated to';
comment on column CAPS.EXC_CHILD_ADO_INFO_CBX.CD_ADO_INFO_CBX is 'The type of the recruitment activity';
comment on column CAPS.EXC_CHILD_ADO_INFO_CBX.CD_CBX_CODE_TYPE is 'The code type of the activity';

grant select,update,insert,delete on CAPS.EXC_CHILD_ADO_INFO_CBX to capson,capsbat,ops$datafix;
grant select on CAPS.EXC_CHILD_ADO_INFO_CBX to operator;

CREATE SEQUENCE  CAPS.SEQ_EXC_CHILD_ADO_INFO_CBX  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_EXC_CHILD_ADO_INFO_CBX  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_EXC_CHILD_ADO_INFO_CBX 
BEFORE UPDATE
ON CAPS.EXC_CHILD_ADO_INFO_CBX
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EXC_CHILD_ADO_INFO_CBX
BEFORE INSERT
ON CAPS.EXC_CHILD_ADO_INFO_CBX
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_INFO_CHAR=0 then
    SELECT SEQ_EXC_CHILD_ADO_INFO_CBX.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_INFO_CHAR := dummy;
  end if;
END;
/

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (386, 'SacwisRev3', 'Release 3.0 - DBCRs 10283,10284,10291');

commit;

