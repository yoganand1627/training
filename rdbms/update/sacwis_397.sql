--STGAP00010826 - Change primary key to composite key

-- HOME RACE BEGINS HERE

drop sequence caps.seq_home_race;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_HOME_RACE
BEFORE INSERT
ON CAPS.HOME_RACE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
END;
/

alter table caps.home_race drop constraint pk_home_race;
alter table caps.home_race drop column id_home_race;
alter table caps.home_race add constraint PK_HOME_RACE PRIMARY KEY (ID_RESOURCE,CD_RACE) using index tablespace index01;


-- undo begins here

-- alter table caps.home_race drop constraint pk_home_race;
-- alter table caps.home_race add (id_home_race number(16));
-- alter table caps.home_race add constraint PK_HOME_RACE PRIMARY KEY (ID_HOME_RACE) using index tablespace index01;

-- CREATE SEQUENCE  CAPS.SEQ_HOME_RACE  
-- MINVALUE 1 MAXVALUE 999999999999999999999999999 
-- INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

-- grant select on caps.seq_home_race to capson,capsbat,ops$datafix;


-- CREATE OR REPLACE TRIGGER CAPS.TIBR_HOME_RACE 
-- BEFORE INSERT
-- ON CAPS.HOME_RACE
-- REFERENCING OLD AS OLD NEW AS NEW
-- FOR EACH ROW
-- DECLARE
   -- dummy number;
-- BEGIN
-- :NEW.DT_LAST_UPDATE := sysdate;
-- if :NEW.ID_HOME_RACE=0 then
--SELECT SEQ_HOME_RACE.NEXTVAL INTO dummy  FROM DUAL;
--:NEW.ID_HOME_RACE := dummy;
--  end if;
--END;
--/


-- purge dba_recyclebin; 

--- HOME ETHNICITY BEGINS HERE

drop sequence caps.seq_home_ethnicity; 

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_HOME_ETHNICITY 
BEFORE INSERT
ON CAPS.HOME_ETHNICITY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
END;
/

alter table caps.home_ethnicity drop constraint pk_home_ethnicity;
alter table caps.home_ethnicity drop column id_home_ethnicity;
alter table caps.home_ethnicity add constraint PK_HOME_ETHNICITY PRIMARY KEY (ID_RESOURCE,CD_ETHNICITY) using index tablespace index01;

-- undo begins here

-- alter table caps.home_ETHNICITY drop constraint pk_home_ETHNICITY;
-- alter table caps.home_ETHNICITY add (id_home_ETHNICITY number(16));
-- alter table caps.home_ETHNICITY add constraint PK_HOME_ETHNICITY PRIMARY KEY (ID_HOME_ETHNICITY) using index tablespace index01;

-- CREATE SEQUENCE  CAPS.SEQ_HOME_ETHNICITY  
-- MINVALUE 1 MAXVALUE 999999999999999999999999999 
-- INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

-- grant select on caps.seq_home_ETHNICITY to capson,capsbat,ops$datafix;

-- CREATE OR REPLACE TRIGGER CAPS.TIBR_HOME_ETHNICITY 
-- BEFORE INSERT
-- ON CAPS.HOME_ETHNICITY
-- REFERENCING OLD AS OLD NEW AS NEW
-- FOR EACH ROW
-- DECLARE
-- dummy number;
-- BEGIN
-- :NEW.DT_LAST_UPDATE := sysdate;
-- if :NEW.ID_HOME_ETHNICITY=0 then
-- SELECT SEQ_HOME_ETHNICITY.NEXTVAL INTO dummy  FROM DUAL;
-- :NEW.ID_HOME_ETHNICITY := dummy;
-- end if;
-- END;
-- /



-- purge dba_recyclebin; 


--STGAP00010792 - update task 3rd level tab for ADOPTION ASSISTANCE


update caps.task set TXT_3RD_TAB = 'ADOPTION_ASSISTANCE_APPLICATION_EVENTLIST' where
CD_TASK in (8610, 9100, 8532, 8352);


--STGAP00010796 - Per STGAP00010735, Add 2 new messages for use



Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE,60489,'MSG_DISRP_NARR_REQ','Please complete the Adoption Disruption Narrative for an adoption disruption.', 500, 700, 'N');


Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60490,   'MSG_FH_CONV_REQ','A Foster Home Conversion is required to select a Foster Home with Placement Type of Adoptive Home.', 500, 700, 'N');


--STGAP00010821 - New Codes needed for Home Information Changes

-- First 2 insert statements have been excluded per Ronnie Phelps
--INSERT INTO CODES_TABLES VALUES('CFACLOSE', 'AFS', 'Adoption Finalized With Subsidies', NULL, SYSDATE);

--INSERT INTO CODES_TABLES VALUES('CFACLOSE', 'AFN', 'Adoption Finalized Without Subsidies', NULL, SYSDATE);


INSERT INTO CAPS.CODES_TABLES VALUES('CFACLOSE', 'DEN', 'Denied', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CLNCHAR2', '300', 'Family Hx of Drug and Alcohol Abuse', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CLNCHAR2', '301', 'Family Hx of Mental Illness', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CLNCHAR2', '302', 'Family HX of Mental Retardation', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CLNCHAR2', '303', 'Child Hx of Sexual Abuse', NULL, SYSDATE);



--STGAP00010834 - new message for fa home search

insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
values
   (SYSDATE, 60491, 'MSG_AGE_MIN_LESS_MAX', 'Minimum Age must be less than or equal to Maximum Age', 500, 730, 'N');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (398, 'SacwisRev3', 'Release 3.0 - DBCRs 10792,10796,10821,10826,10834');

commit;

