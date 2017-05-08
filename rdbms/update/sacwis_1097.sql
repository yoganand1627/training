--STGAP00017092 - Release(5.0) MR-095 Person Relationships Add New Table

-- STGAP00017092
-- MR-095 Person Relationships
-- Add New Table STAGE_PERS_REL_MAP_CUSTODY

-- STGAP00017092
-- MR-095 Person Relationships
-- Add New Table STAGE_PERS_REL_MAP_CUSTODY

CREATE TABLE CAPS.STAGE_PERS_REL_MAP_CUSTODY
(ID_STAGE_PERS_REL_MAP_CUSTODY NUMBER(16,0) not null,
DT_LAST_UPDATE date not null,
CD_STAGE_PERS_REL_PK varchar2(20) not null,
CD_STAGE_PERS_REL_CURR_STAGE varchar2(2) not null,
CD_STAGE_PERS_REL_NEXT_STAGE varchar2(2) not null,
CD_PERSON_GENDER varchar2(1) null,
constraint PK_STAGE_PERS_REL_MAP_CUSTODY primary key(ID_STAGE_PERS_REL_MAP_CUSTODY) using index tablespace INDEX01 ENABLE,
constraint "UK1_STAGE_PERS_REL_MAP_CUST" unique ("CD_STAGE_PERS_REL_PK", "CD_STAGE_PERS_REL_CURR_STAGE", "CD_STAGE_PERS_REL_NEXT_STAGE") 
using index tablespace INDEX01 ENABLE) 
tablespace DATA01;

create index caps.IND_STAGE_PERS_REL_MAP_CUSTODY on CAPS.STAGE_PERS_REL_MAP_CUSTODY(CD_STAGE_PERS_REL_PK, CD_STAGE_PERS_REL_CURR_STAGE) tablespace index01;

comment on table CAPS.STAGE_PERS_REL_MAP_CUSTODY is 'Relationship Mapping static table based on the relationships identified on the Person List in the removal stage' ;
COMMENT ON COLUMN CAPS.STAGE_PERS_REL_MAP_CUSTODY.ID_STAGE_PERS_REL_MAP_CUSTODY IS 'A unique identifier located on the STAGE_PERS_REL_MAP_CUSTODY table' ;
comment on column CAPS.STAGE_PERS_REL_MAP_CUSTODY.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.STAGE_PERS_REL_MAP_CUSTODY.CD_STAGE_PERS_REL_PK is 'Code representing the type of a Primary Caretaker in the removal stage' ;
comment on column CAPS.STAGE_PERS_REL_MAP_CUSTODY.CD_STAGE_PERS_REL_CURR_STAGE is 'Code representing the relationship/interest of an individual to the removal stage' ;
comment on column CAPS.STAGE_PERS_REL_MAP_CUSTODY.CD_STAGE_PERS_REL_NEXT_STAGE is 'Code representing the relationship/interest of an individual to the FCC or FCF stage' ;
comment on column CAPS.STAGE_PERS_REL_MAP_CUSTODY.CD_PERSON_GENDER is 'Code representing the Gender of an individual in the removal stage. This field is not needed for most of the mappings except a few cases' ;

grant select,update,insert,delete on caps.STAGE_PERS_REL_MAP_CUSTODY to capson,capsbat,ops$datafix;
grant select on caps.STAGE_PERS_REL_MAP_CUSTODY to operator,shinesdm;

CREATE sequence CAPS.SEQ_STAGE_PERS_REL_MAP_CUST  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_STAGE_PERS_REL_MAP_CUST  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE_PERS_REL_MAP_CUST
BEFORE UPDATE
ON CAPS.STAGE_PERS_REL_MAP_CUSTODY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_STAGE_PERS_REL_MAP_CUST
BEFORE INSERT
ON CAPS.STAGE_PERS_REL_MAP_CUSTODY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_STAGE_PERS_REL_MAP_CUSTODY=0 then
    SELECT CAPS.SEQ_STAGE_PERS_REL_MAP_CUST.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_STAGE_PERS_REL_MAP_CUSTODY := dummy;
  end if;
end;
/

--Insert Relationship Mapping data
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'AB',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PT',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'AU',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'BC',	'BC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'BB',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'BF',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'BM',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'BP',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'BS',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'CG',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'DA',	'SB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'DC',	'DC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'DR',	'DR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'FI',	'FI',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'CO',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'FC',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'FD',	'FD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'FA',	'FA',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'FP',	'FP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'AF',	'AF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'FR',	'FR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'GC',	'NN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'GP',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'G2',	'G3',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'G3',	'G4',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'G4',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'W2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'N2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'GW',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'GN',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'GU',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'GR',	'GR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'HS',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'IC',	'IC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'IP',	'IP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'LF',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'LM',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'MF',	'MF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'NN',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'NS',	'ST',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'XX',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'FM',	'FM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'OP',	'OP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'OR',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'OU',	'OU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PA',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PB',	'PB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PK',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PY',	'PY',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'RP',	'RP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'RD',	'RD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'RN',	'RN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SH',	'SH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SC',	'SC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SL',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SM',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'PR',	'PR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SB',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SO',	'SB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SP',	'BM',	'F'	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SP',	'BF',	'M'	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SR',	'SB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'GS',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'ST',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'SS',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'TP',	'TP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'UK',	'UK',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'UF',	'UF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Parent',	'UH',	'UH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'AB',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PT',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'AU',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'BC',	'BC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'BB',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'BF',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'BM',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'BP',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'BS',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'CG',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'DA',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'DC',	'DC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'DR',	'DR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'FI',	'FI',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'CO',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'FC',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'FD',	'FD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'FA',	'FA',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'FP',	'FP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'AF',	'AF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'FR',	'FR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'GC',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'GP',	'G3',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'G2',	'G4',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'G3',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'G4',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'W2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'N2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'GW',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'GN',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'GU',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'GR',	'GR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'HS',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'IC',	'IC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'IP',	'IP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'LF',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'LM',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'MF',	'MF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'NN',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'NS',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'XX',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'FM',	'FM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'OP',	'OP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'OR',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'OU',	'OU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PA',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PB',	'PB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PK',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PY',	'PY',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'RP',	'RP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'RD',	'RD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'RN',	'RN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SH',	'SH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SC',	'SC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SL',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SM',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'PR',	'PR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SB',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SO',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SP',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SR',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'GS',	'G3',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'ST',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'SS',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'TP',	'TP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'UK',	'UK',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'UF',	'UF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Grandparent',	'UH',	'UH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'AB',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PT',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'AU',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'BC',	'BC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'BB',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'BF',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'BM',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'BP',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'BS',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'CG',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'DA',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'DC',	'DC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'DR',	'DR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'FI',	'FI',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'CO',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'FC',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'FD',	'FD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'FA',	'FA',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'FP',	'FP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'AF',	'AF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'FR',	'FR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'GC',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'GP',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'G2',	'G3',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'G3',	'G4',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'G4',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'W2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'N2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'GW',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'GN',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'GU',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'GR',	'GR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'HS',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'IC',	'IC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'IP',	'IP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'LF',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'LM',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'MF',	'MF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'NN',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'NS',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'XX',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'FM',	'FM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'OP',	'OP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'OR',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'OU',	'OU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PA',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PB',	'PB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PK',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PY',	'PY',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'RP',	'RP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'RD',	'RD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'RN',	'RN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SH',	'SH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SC',	'SC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SL',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SM',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'PR',	'PR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SB',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SO',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SP',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SR',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'GS',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'ST',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'SS',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'TP',	'TP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'UK',	'UK',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'UF',	'UF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Aunt/Uncle',	'UH',	'UH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'AB',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PT',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'AU',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'BC',	'BC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'BB',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'BF',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'BM',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'BP',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'BS',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'CG',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'DA',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'DC',	'DC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'DR',	'DR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'FI',	'FI',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'CO',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'FC',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'FD',	'FD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'FA',	'FA',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'FP',	'FP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'AF',	'AF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'FR',	'FR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'GC',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'GP',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'G2',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'G3',	'G3',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'G4',	'G4',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'W2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'N2',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'GW',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'GN',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'GU',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'GR',	'GR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'HS',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'IC',	'IC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'IP',	'IP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'LF',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'LM',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'MF',	'MF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'NN',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'NS',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'XX',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'FM',	'FM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'OP',	'OP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'OR',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'OU',	'OU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PA',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PB',	'PB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PK',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PY',	'PY',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'RP',	'RP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'RD',	'RD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'RN',	'RN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SH',	'SH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SC',	'SC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SL',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SM',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'PR',	'PR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SB',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SO',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SP',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SR',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'GS',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'ST',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'SS',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'TP',	'TP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'UK',	'UK',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'UF',	'UF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Cousin',	'UH',	'UH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'AB',	'BM',	'F'	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'AB',	'BF',	'M'	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PT',	'PT',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'AU',	'AU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'BC',	'BC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'BB',	'BB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'BF',	'BF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'BM',	'BM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'BP',	'BP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'BS',	'BS',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'CG',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'DA',	'NN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'DC',	'DC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'DR',	'DR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'FI',	'FI',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'CO',	'CO',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'FC',	'FC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'FD',	'FD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'FA',	'FA',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'FP',	'FP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'AF',	'AF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'FR',	'FR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'GC',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'GP',	'GP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'G2',	'G2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'G3',	'G3',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'G4',	'G4',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'W2',	'W2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'N2',	'N2',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'GW',	'GW',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'GN',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'GU',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'GR',	'GR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'HS',	'HS',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'IC',	'IC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'IP',	'IP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'LF',	'LF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'LM',	'LM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'MF',	'MF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'NN',	'NN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'NS',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'XX',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'FM',	'FM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'OP',	'OP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'OR',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'OU',	'OU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PA',	'BM',	'F'	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PA',	'BF',	'M'	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PB',	'PB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PK',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PY',	'PY',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'RP',	'RP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'RD',	'RD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'RN',	'RN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SH',	'SH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SC',	'SC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SL',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SM',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'PR',	'PR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SB',	'SB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SO',	'NN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SR',	'NN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'GS',	'GS',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'ST',	'ST',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'SS',	'SS',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'TP',	'TP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'UK',	'UK',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'UF',	'UF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Sibling',	'UH',	'UH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'AB',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PT',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'AU',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'BC',	'BC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'BB',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'BF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'BM',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'BP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'BS',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'CG',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'DA',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'DC',	'DC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'DR',	'DR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'FI',	'FI',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'CO',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'FC',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'FD',	'FD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'FA',	'FA',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'FP',	'FP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'AF',	'AF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'FR',	'FR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'GC',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'GP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'G2',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'G3',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'G4',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'W2',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'N2',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'GW',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'GN',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'GU',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'GR',	'GR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'HS',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'IC',	'IC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'IP',	'IP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'LF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'LM',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'MF',	'MF',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'NN',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'NS',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'XX',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'FM',	'FM',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'OP',	'OP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'OR',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'OU',	'OU',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PA',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PB',	'PB',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PK',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PY',	'PY',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PF',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'RP',	'RP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'RD',	'RD',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'RN',	'RN',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SH',	'SH',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SC',	'SC',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SL',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SM',	'OR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'PR',	'PR',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SB',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SO',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SP',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SR',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'GS',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'ST',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'SS',	'XX',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'TP',	'TP',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'UK',	'UK',	''	);
Insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'UF',	'UF',	''	);
insert into CAPS.STAGE_PERS_REL_MAP_CUSTODY values (	0,	sysdate,	'Non Related',	'UH',	'UH',	''	);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1098, 'SacwisRev5', 'Release 5.0 - DBCR 17092');

commit;

