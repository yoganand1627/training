-- Standard Alter Table SQL

ALTER TABLE CAPS.INTAKE_ALLEGATION ADD CD_MALTREATOR_REL VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.ALLEGATION ADD CD_MALTREATOR_REL VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.ALLEGATION_HISTORY ADD CD_MALTREATOR_REL VARCHAR2(2)     NULL
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ALLEGATION
BEFORE INSERT
ON CAPS.ALLEGATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
--------------------------------------------------------------------------------------------------------------------
-- 			VERY SIMILAR to PERSON's triggers (table116.trg)
--------------------------------------------------------------------------------------------------------------------
	dummy		NUMBER;
	dummy2		NUMBER;
	dummy_date	DATE;
BEGIN
	:new.DT_LAST_UPDATE := sysdate;
	IF :new.ID_ALLEGATION = 0 THEN
		SELECT	SEQ_ALLEGATION.NEXTVAL
		INTO	dummy
		FROM dual;
		:new.ID_ALLEGATION := dummy;
	END IF;
--insert into table ALLEGATION_HISTORY if field :new.IND_ALLEG_CANCEL_HIST is not 'Y':
IF nvl(:new.IND_ALLEG_CANCEL_HIST,' ') <> 'Y' THEN
	-- Get next sequence value:
	SELECT SEQ_ALLEG_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;
	INSERT INTO ALLEGATION_HISTORY (
		ID_ALLEG_HISTORY,			DT_LAST_UPDATE,
		ID_ALLEGATION,			ID_ALLEGATION_STAGE,
		ID_VICTIM,				ID_ALLEGED_PERPETRATOR,
		CD_ALLEG_HIST_INCDNT_STG,	TXT_ALLEG_HIST_DURATION,
		CD_ALLEG_HIST_TYPE,		CD_ALLEG_HIST_DISPOSITION,
		CD_ALLEG_HIST_SEVERITY,		DT_ALLEG_HIST_EFFECTIVE,
		DT_ALLEG_HIST_END,       CD_MALTREATOR_REL
	) VALUES (
		dummy2,				sysdate,
		:new.ID_ALLEGATION,			:new.ID_ALLEGATION_STAGE,
		:new.ID_VICTIM,			:new.ID_ALLEGED_PERPETRATOR,
		:new.CD_ALLEG_INCIDENT_STAGE,	:new.TXT_ALLEG_DURATION,
		:new.CD_ALLEG_TYPE,			:new.CD_ALLEG_DISPOSITION,
		:new.CD_ALLEG_SEVERITY,		:new.DT_LAST_UPDATE,
		NULL,                    :new.CD_MALTREATOR_REL
	);
END IF;
	--Must always set this field to NULL regardless what the user enters.
	:new.IND_ALLEG_CANCEL_HIST := NULL;
	SELECT	ID_CASE
	INTO		:new.ID_CASE
	FROM		STAGE
	WHERE		ID_STAGE = :new.ID_ALLEGATION_STAGE;
EXCEPTION
	WHEN OTHERS THEN
		IF SQL%NOTFOUND THEN
			:new.ID_CASE := NULL;
		END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_ALLEGATION
BEFORE UPDATE
ON CAPS.ALLEGATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
 dummy2  NUMBER;
BEGIN
 :NEW.DT_LAST_UPDATE := SYSDATE;
--insert into table ALLEGATION_HISTORY if field :new.IND_ALLEG_CANCEL_HIST is not 'Y':
IF NVL(:NEW.IND_ALLEG_CANCEL_HIST,' ') <> 'Y' THEN
 -- 1st: set END DATE of previous record:
 UPDATE ALLEGATION_HISTORY  AH
 SET  AH.DT_ALLEG_HIST_END    = :NEW.DT_LAST_UPDATE
 WHERE  AH.ID_ALLEGATION = :NEW.ID_ALLEGATION
 AND AH.ID_ALLEG_HISTORY =
   (SELECT MAX(AH2.ID_ALLEG_HISTORY)
   FROM  ALLEGATION_HISTORY AH2
   WHERE  AH2.ID_ALLEGATION = :NEW.ID_ALLEGATION
   AND  AH2.DT_ALLEG_HIST_END = TO_DATE('12/31/4712','MM/DD/YYYY'));
 -- Get next sequence value:
 SELECT SEQ_ALLEG_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;
 INSERT INTO ALLEGATION_HISTORY (
  ID_ALLEG_HISTORY,   DT_LAST_UPDATE,
  ID_ALLEGATION,   ID_ALLEGATION_STAGE,
  ID_VICTIM,    ID_ALLEGED_PERPETRATOR,
  CD_ALLEG_HIST_INCDNT_STG, TXT_ALLEG_HIST_DURATION,
  CD_ALLEG_HIST_TYPE,  CD_ALLEG_HIST_DISPOSITION,
  CD_ALLEG_HIST_SEVERITY,  DT_ALLEG_HIST_EFFECTIVE,
  DT_ALLEG_HIST_END,   CD_MALTREATOR_REL
 )VALUES (
  dummy2,    SYSDATE,
  :NEW.ID_ALLEGATION,   :NEW.ID_ALLEGATION_STAGE,
  :NEW.ID_VICTIM,   :NEW.ID_ALLEGED_PERPETRATOR,
  :NEW.CD_ALLEG_INCIDENT_STAGE, :NEW.TXT_ALLEG_DURATION,
  :NEW.CD_ALLEG_TYPE,   :NEW.CD_ALLEG_DISPOSITION,
  :NEW.CD_ALLEG_SEVERITY,  :NEW.DT_LAST_UPDATE,
  NULL,                :NEW.CD_MALTREATOR_REL
 );
END IF;
 :NEW.IND_ALLEG_CANCEL_HIST := NULL;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00005635
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CCT','19','Domestic Violence', sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CLNCHAR2','19','Domestic Violence', sysdate);

-- change STGAP00005645
UPDATE CAPS.CODES_TABLES SET dt_end=SYSDATE WHERE code_type='CELYINTV' AND code='NA';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (245, 'SacwisRev2', 'static table updates');                        
commit;


