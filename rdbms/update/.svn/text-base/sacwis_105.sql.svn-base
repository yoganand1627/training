
-- change 155 Both R1/R2
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_ALLEGATION 
BEFORE UPDATE ON CAPS.ALLEGATION
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
  DT_ALLEG_HIST_END
 )VALUES (
  dummy2,    SYSDATE,
  :NEW.ID_ALLEGATION,   :NEW.ID_ALLEGATION_STAGE,
  :NEW.ID_VICTIM,   :NEW.ID_ALLEGED_PERPETRATOR,
  :NEW.CD_ALLEG_INCIDENT_STAGE, :NEW.TXT_ALLEG_DURATION,
  :NEW.CD_ALLEG_TYPE,   :NEW.CD_ALLEG_DISPOSITION,
  :NEW.CD_ALLEG_SEVERITY,  :NEW.DT_LAST_UPDATE,
  NULL
 );
END IF;
 :NEW.IND_ALLEG_CANCEL_HIST := NULL;
END;
/

-- change 156 Both R1/R2
UPDATE caps.codes_tables SET dt_end = NULL WHERE code='XXX' AND code_type = 'CCOUNT'; 

INSERT INTO caps.codes_tables 
(code_type, code, DECODE, dt_last_update) 
VALUES 
('CCNTYREG','XXX','99', SYSDATE); 

UPDATE caps.codes_tables SET dt_end = NULL WHERE code = '99' AND code_type = 'CREGIONS'; 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','SAU','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','OCA','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','RC','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','PPD','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','DO','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','CO','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','CS','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','DTS','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','ER','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','ETU','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','FFS','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','ICP','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','OA','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','OIT','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','SDL','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','SP','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','TSU','CPS',1,1,'GEN','XXX'); 


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (106, 'SacwisRev2', 'Fix TUBR_ALLEGATION, static updates');
commit;
