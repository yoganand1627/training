--STGAP00010823 - DBCR to update Home Information Races/Ethnicities

-- insert all races into into home_race
INSERT INTO caps.home_race
SELECT NULL, ID_RESOURCE, CD_FA_HOME_INT_ETHNICITY FROM caps.FA_HOME_INT_ETHNIC ;


-- insert all ethnicities into into home_race
INSERT INTO caps.home_ethnicity
SELECT  NULL, ID_RESOURCE, CD_FA_HOME_INT_ETHNICITY FROM caps.FA_HOME_INT_ETHNIC ;

-- drop constraints before updating will recreate the constraint after removing the duplicates

alter table caps.home_race drop constraint pk_home_race;
alter table caps.home_ethnicity drop constraint pk_home_ethnicity;

-- update home races

update caps.home_race set cd_race='AA' where cd_race in ('AH','AI','AU');
update caps.home_race set cd_race='AN' where cd_race in ('AS','AT','AN');
update caps.home_race set cd_race='BK' where cd_race in ('BH','BL','BU');
update caps.home_race set cd_race='UD' where cd_race in ('MU','MN','MH','UH','UI','UN');
update caps.home_race set cd_race='WT' where cd_race in ('HW','WU','WH');
update caps.home_race set cd_race='BW' where cd_race in ('BV','BW','BN');
update caps.home_race set cd_race='HP' where cd_race in ('HH','HI','HU');

-- update home ethnicities

update caps.home_ethnicity set cd_ethnicity='HS' where cd_ethnicity in ('AH','BH','BV','MH','HH','AS','UH','HW');
update caps.home_ethnicity set cd_ethnicity='NH' where cd_ethnicity in ('AT','UI','WH','AI','BL','BW','MN','HI');
update caps.home_ethnicity set cd_ethnicity='UT' where cd_ethnicity in ('UN','AU','AN','BU','BN','HU','WU','MU');

-- remove duplicate home races
DELETE FROM caps.home_race A WHERE ROWID > (
     SELECT MIN(ROWID) FROM caps.home_race B
   WHERE A.CD_RACE= B.CD_RACE AND A.ID_RESOURCE = B.ID_RESOURCE);

-- remove duplicate home ethnicities
DELETE FROM caps.home_ethnicity A WHERE ROWID > (
     SELECT MIN(ROWID) FROM caps.home_ethnicity B
   WHERE A.CD_ethnicity= B.CD_ethnicity AND A.ID_RESOURCE = B.ID_RESOURCE);

-- recreate the indexes
alter table caps.home_race add constraint PK_HOME_RACE PRIMARY KEY (ID_RESOURCE,CD_RACE) using index tablespace index01;
alter table caps.home_ethnicity add constraint PK_HOME_ETHNICITY PRIMARY KEY (ID_RESOURCE,CD_ETHNICITY) using index tablespace index01;



--STGAP00010857 - STAGE_PROG RECORD needed for CFACLOSE den

INSERT INTO caps.STAGE_PROG (ID_STAGE_PROG, CD_STAGE_PROG_STAGE, CD_STAGE_PROG_PROGRAM, CD_STAGE_PROG_RSN_CLOSE, IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, TXT_STAGE_PROG_EVNT_DESC) 
VALUES (0, 'FAD', 'CPS', 'DEN', '0', 'STG', 'COMP', 'F/A Home Stage Closed');


--STGAP00010884 - New code for code type = CPL so that there are on

insert into caps.CODES_TABLES (CODE_TYPE, CODE, DECODE) values ('CPL', 300, 'Family Hx of Drug and Alcohol Abuse');
insert into caps.CODES_TABLES (CODE_TYPE, CODE, DECODE) values ('CPL', 301, 'Family Hx of Mental Illness');
insert into caps.CODES_TABLES (CODE_TYPE, CODE, DECODE) values ('CPL', 303, 'Child Hx of Sexual Abuse');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (399, 'SacwisRev3', 'Release 3.0 - DBCRs 10823,10857,10884');

commit;


