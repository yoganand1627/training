--STGAP00016028 - Release(4.1) Add field to allegation history to match allegatio

--Update the allegation_HISTORY table so that it has the new fields that have been added to the allegation table.  Also update the triggers which populate the allegation_HISTORY table


alter table caps.allegation_history add (IND_ALLEG_CANCEL_HIST varchar2(1));
alter table caps.allegation_history add (TXT_EVIDENCE_SUMMARY varchar2(300));
alter table caps.allegation_history add (IND_CRIM_CHRGS_FILED varchar2(1));
alter table caps.allegation_history add (CD_ALLEGED_MAL_LOCATION varchar2(3));
alter table caps.allegation_history add (DT_ALLEGED_INCIDENT date);
alter table caps.allegation_history add (DT_PRIOR_NEAR_FATAL_MALTRTMNT date);
alter table caps.allegation_history add (IND_CHILD_DEATH_SEVERITY varchar2(1));
alter table caps.allegation_history add (IND_MALTREAT_IN_CARE varchar2(1));

grant select on caps.allegation_history to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ALLEGATION 
BEFORE INSERT
ON CAPS.ALLEGATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
--------------------------------------------------------------------------------------------------------------------
--       VERY SIMILAR to PERSON's triggers (table116.trg)
--------------------------------------------------------------------------------------------------------------------
  dummy    NUMBER;
  dummy2    NUMBER;
  dummy_date  DATE;
BEGIN
  :new.DT_LAST_UPDATE := sysdate;
  IF :new.ID_ALLEGATION = 0 THEN
    SELECT  SEQ_ALLEGATION.NEXTVAL
    INTO  dummy
    FROM dual;
    :new.ID_ALLEGATION := dummy;
  END IF;
--insert into table ALLEGATION_HISTORY if field :new.IND_ALLEG_CANCEL_HIST is not 'Y':
IF nvl(:new.IND_ALLEG_CANCEL_HIST,' ') <> 'Y' THEN
  -- Get next sequence value:
  SELECT SEQ_ALLEG_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;
  INSERT INTO ALLEGATION_HISTORY (
    ID_ALLEG_HISTORY,      DT_LAST_UPDATE,
    ID_ALLEGATION,      ID_ALLEGATION_STAGE,
    ID_VICTIM,        ID_ALLEGED_PERPETRATOR,
    CD_ALLEG_HIST_INCDNT_STG,  TXT_ALLEG_HIST_DURATION,
    CD_ALLEG_HIST_TYPE,    CD_ALLEG_HIST_DISPOSITION,
    CD_ALLEG_HIST_SEVERITY,    DT_ALLEG_HIST_EFFECTIVE,
    DT_ALLEG_HIST_END,       CD_MALTREATOR_REL,
    IND_ALLEG_CANCEL_HIST,
    TXT_EVIDENCE_SUMMARY,
    IND_CRIM_CHRGS_FILED,
    CD_ALLEGED_MAL_LOCATION,
    DT_ALLEGED_INCIDENT,
    DT_PRIOR_NEAR_FATAL_MALTRTMNT,
    IND_CHILD_DEATH_SEVERITY,
    IND_MALTREAT_IN_CARE
  ) VALUES (
    dummy2,        sysdate,
    :new.ID_ALLEGATION,      :new.ID_ALLEGATION_STAGE,
    :new.ID_VICTIM,      :new.ID_ALLEGED_PERPETRATOR,
    :new.CD_ALLEG_INCIDENT_STAGE,  :new.TXT_ALLEG_DURATION,
    :new.CD_ALLEG_TYPE,      :new.CD_ALLEG_DISPOSITION,
    :new.CD_ALLEG_SEVERITY,    :new.DT_LAST_UPDATE,
    NULL,                    :new.CD_MALTREATOR_REL,
    :new.IND_ALLEG_CANCEL_HIST,
    :new.TXT_EVIDENCE_SUMMARY,
    :new.IND_CRIM_CHRGS_FILED,
    :new.CD_ALLEGED_MAL_LOCATION,
    :new.DT_ALLEGED_INCIDENT,
    :new.DT_PRIOR_NEAR_FATAL_MALTRTMNT,
    :new.IND_CHILD_DEATH_SEVERITY,
    :new.IND_MALTREAT_IN_CARE
  );
END IF;
  --Must always set this field to NULL regardless what the user enters.
  :new.IND_ALLEG_CANCEL_HIST := NULL;
  SELECT  ID_CASE
  INTO    :new.ID_CASE
  FROM    STAGE
  WHERE    ID_STAGE = :new.ID_ALLEGATION_STAGE;
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
  DT_ALLEG_HIST_END,   CD_MALTREATOR_REL,
    IND_ALLEG_CANCEL_HIST,
    TXT_EVIDENCE_SUMMARY,
    IND_CRIM_CHRGS_FILED,
    CD_ALLEGED_MAL_LOCATION,
    DT_ALLEGED_INCIDENT,
    DT_PRIOR_NEAR_FATAL_MALTRTMNT,
    IND_CHILD_DEATH_SEVERITY,
    IND_MALTREAT_IN_CARE
 )VALUES (
  dummy2,    SYSDATE,
  :NEW.ID_ALLEGATION,   :NEW.ID_ALLEGATION_STAGE,
  :NEW.ID_VICTIM,   :NEW.ID_ALLEGED_PERPETRATOR,
  :NEW.CD_ALLEG_INCIDENT_STAGE, :NEW.TXT_ALLEG_DURATION,
  :NEW.CD_ALLEG_TYPE,   :NEW.CD_ALLEG_DISPOSITION,
  :NEW.CD_ALLEG_SEVERITY,  :NEW.DT_LAST_UPDATE,
  NULL,                :NEW.CD_MALTREATOR_REL,
    :new.IND_ALLEG_CANCEL_HIST,
    :new.TXT_EVIDENCE_SUMMARY,
    :new.IND_CRIM_CHRGS_FILED,
    :new.CD_ALLEGED_MAL_LOCATION,
    :new.DT_ALLEGED_INCIDENT,
    :new.DT_PRIOR_NEAR_FATAL_MALTRTMNT,
    :new.IND_CHILD_DEATH_SEVERITY,
    :new.IND_MALTREAT_IN_CARE
 );
END IF;
 :NEW.IND_ALLEG_CANCEL_HIST := NULL;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (925, 'SacwisRev4', 'Release 4.1 - DBCR 16028');

commit;
