--STGAP00016999 - Release(5.0) ECEM 5.0: Service Auth Header code conversion


-- ECEM 5.0: This release will allow user to terminate a service online. Services applicable for Service Auth is being hardcoded. So need to switch to using DB approach for real time processing. 
-- This is the current list of manual services for service auth. Some program codes may already be end-dated. 
CREATE TABLE CAPS.SVC_AUTH_UAS_ENT_CODE
(ID_SVC_AUTH_UAS_ENT_CODE NUMBER(16,0) NOT NULL ENABLE,
CD_UAS VARCHAR2(370 BYTE) NOT NULL ENABLE,
CD_ENT VARCHAR2(20 BYTE) NOT NULL ENABLE,
DT_END DATE,
DT_LAST_UPDATE DATE,
CONSTRAINT PK_ID_SVC_AUTH_UAS_ENT_CODE PRIMARY KEY (ID_SVC_AUTH_UAS_ENT_CODE) ENABLE);

grant select,update,insert,delete on caps.SVC_AUTH_UAS_ENT_CODE to capson,capsbat,ops$datafix;
grant select on caps.SVC_AUTH_UAS_ENT_CODE to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE  NOMINVALUE NOMAXVALUE INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;

grant select on CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SVC_AUTH_UAS_ENT_CODE
BEFORE UPDATE
ON CAPS.SVC_AUTH_UAS_ENT_CODE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SVC_AUTH_UAS_ENT_CODE
BEFORE INSERT
ON CAPS.SVC_AUTH_UAS_ENT_CODE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_SVC_AUTH_UAS_ENT_CODE=0 then
    SELECT SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_SVC_AUTH_UAS_ENT_CODE := dummy;
  end if;
END;
/

comment on table caps.SVC_AUTH_UAS_ENT_CODE is 'This is a list filtered service codes applicable for Service Authorization. Modification to UAS (CPRGCOD1) and Entitlment (CENTCODE) codes may cause updates here.';
comment on column caps.SVC_AUTH_UAS_ENT_CODE.CD_UAS is 'This is programs available for service auth corresponding to code type CPRGCOD1';
comment on column caps.SVC_AUTH_UAS_ENT_CODE.CD_ENT is 'This is entitlement code available per selected programs for service auth corresponding to code type CENTCODE';
comment on column caps.SVC_AUTH_UAS_ENT_CODE.DT_END is 'This is end date on corresponding CENTCODE code';


Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '252', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '253', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '450', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '456', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '504', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '504', '10',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '504', '11',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '522', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '522', '10',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '522', '11',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '522', '99',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '513', '12',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '515', '67',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '515', '70',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '511', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '511', '12',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '511', '19',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '511', '29',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '511', '54',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '511', '88',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '12',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '24',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '47',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '56',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '63',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '71',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '80',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '88',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '518', '95',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '48',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '49',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '50',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '51',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '52',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '53',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '54',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '521', '56',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '525', '19',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '525', '20',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '531', '06',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '531', '67',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '531', '68',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '547', '96',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '547', '97',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '551', '79',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '571', '29',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '571', '61',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '571', '62',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '573', '72',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '588', '85',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '588', '86',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '597', 'W1',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '597', 'W2',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '617', '06',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '617', '71',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '617', '74',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '617', '78',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '618', '06',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '618', '71',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '618', '74',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '618', '78',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '698', '41',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '773', '73',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '773', '24',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '774', '74',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '774', 'C9',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '783', '83',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '784', '84',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '784', '57',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', '24',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'R1',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'R2',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'R3',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'R4',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'R5',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'R6',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'R7',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '873', 'S7',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '874', 'S5',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '874', 'S6',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '874', 'S7',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '874', 'S8',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '874', 'S9',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '883', '83',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '883', 'S3',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '883', 'S4',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '884', '84',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '884', 'S1',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '884', 'S2',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '510', '33',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '512', '17',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '512', '57',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '512', '58',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '512', '60',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '512', '77',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '582', '28',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '582', '32',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '582', '42',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '582', '44',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '582', '87',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '582', '89',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '582', '93',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '583', '75',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '585', '76',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '585', '80',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '586', '29',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '586', '78',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '584', '75',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '591', '75',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '576', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '576', '10',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '576', '11',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '576', '99',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '578', '00',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '578', '10',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '578', '11',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '578', '99',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '598', 'W1',  NULL, SYSDATE );
Insert into CAPS.SVC_AUTH_UAS_ENT_CODE values (CAPS.SEQ_SVC_AUTH_UAS_ENT_CODE.NEXTVAL,  '598', 'W2',  NULL, SYSDATE );

insert into caps.schema_version(id_schema_version,application_version,comments)
values (1065, 'SacwisRev5', 'Release 5.0 - DBCR 16999');

commit;