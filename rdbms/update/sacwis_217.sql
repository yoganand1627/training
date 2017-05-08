-- Standard Alter Table SQL

ALTER TABLE CAPS.PAYMENT_OF_CARE ADD IND_CCI VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PAYMENT_OF_CARE ADD CD_RBWO_PROGRAM VARCHAR2(1)     NULL
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE_PERSON_LINK
BEFORE UPDATE OR DELETE
ON CAPS.STAGE_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE 
        xNM_STAGE                     STAGE.NM_STAGE%TYPE; 
        xCD_STAGE                     STAGE.CD_STAGE%TYPE; 
        xCD_STAGE_CNTY                STAGE.CD_STAGE_CNTY%TYPE; 
        xCD_STAGE_TYPE                STAGE.CD_STAGE_TYPE%TYPE; 
        xCD_STAGE_REGION              STAGE.CD_STAGE_REGION%TYPE; 
        xCD_STAGE_REASON_CLOSED       STAGE.CD_STAGE_REASON_CLOSED%TYPE; 
        xCD_STAGE_PROGRAM             STAGE.CD_STAGE_PROGRAM%TYPE; 
        xID_UNIT                      UNIT.ID_UNIT%TYPE; 
        oldID_UNIT                    UNIT.ID_UNIT%TYPE; 
        newID_UNIT                    UNIT.ID_UNIT%TYPE; 
        yNBR_UNIT                     UNIT.NBR_UNIT%TYPE; 
        zNM_CASE                      CAPS_CASE.NM_CASE%TYPE; 
        zIND_CASE_SENSITIVE           CAPS_CASE.IND_CASE_SENSITIVE%TYPE; 
        zID_CASE                      CAPS_CASE.ID_CASE%TYPE; 
  xID_WKLD_PERSON          WORKLOAD.ID_WKLD_PERSON%TYPE; 
  xID_WKLD_CASE          WORKLOAD.ID_WKLD_CASE%TYPE; 
  v_ml_user_cntr      NUMBER :=0; 
  v_workload_row      WORKLOAD%ROWTYPE; 
  zNM_PERSON_FIRST    PERSON.NM_PERSON_FIRST%TYPE;

BEGIN 

    
     
   SELECT ID_UNIT 
   INTO   oldID_UNIT 
   FROM   STAGE  S 
   WHERE  S.ID_STAGE = :OLD.ID_STAGE; 


    IF UPDATING 
    THEN 

   SELECT ID_UNIT 
         INTO   newID_UNIT 
        FROM   STAGE  S 
        WHERE  S.ID_STAGE = :NEW.ID_STAGE; 

           :NEW.DT_LAST_UPDATE := SYSDATE; 

        --- 
        --- BSG: Added trigger to populate primary/secondary indicator column 
        --- 
        --- 
        --- KJM  10/03/96: 
        ---      Added trigger to update the WORKLOAD table based on the 
        ---      stage person role. If the role in the update row is PR or SE, 
        ---      update all the associated columns where ID_STAGE = ID_WKLD_STAGE 
        ---      and old.ID_PERSON = WKLOAD.ID_WKLD_PERSON. 
        ---      If the previous role was PR and the new role 
        ---      is HP, then the workload row should be deleted altogether. 
        ---      10/21/96 
        ---      new ELSE IF to handle when role changes from HP to PR - 
        ---      in which case a row must be inserted into workload. 
        --- 
        --- CGM  3/14/2000: 
        ---      Added trigger to update the STAGE_ASSIGN_HISTORY if 
        ---      the role in the update row is HP and the previous record 
        ---      was a PR.  Additionally, it will insert a new 12/31/4612 
        ---      ended record in STAGE_ASSIGN_HISTORY for the HP assignment. 
        --- 
        --- CGM  3/27/2000: 
        ---      Added an addition to the trigger to update STAGE_ASSIGN_HISTORY 
        ---      if the id_person in the update row is different than the 
        ---      previous record.  Additionally, it will insert a new record 
  --- 
        --- NGK  7/27/2005: 
  ---      SIR 23796 - Added section to insert row into DELETE_WORKLOAD_HIST 
  ---      if id_person is APS worker that uses MPS. When APS worker synch, 
  ---   the DELETE_WORKLOAD_HIST table would be referred to get a refresh list 
  ---      of MPS's workload page. 
  --- 
        --- ABG  10/18/2006
    ---      Added calls to Update_Workload_Counts procedure on updating
    ---      right after the WORKLOAD table is updated.


            IF (:NEW.CD_STAGE_PERS_TYPE = 'STF') THEN 
               IF ((:OLD.CD_STAGE_PERS_ROLE = 'PR') AND 
                   (:NEW.CD_STAGE_PERS_ROLE = 'HP')) THEN 
                  BEGIN 
                      UPDATE STAGE_ASSIGN_HISTORY SSH 
                      SET SSH.DT_UNASSGND  = SYSDATE 
                      WHERE SSH.ID_STAGE_PERSON_LINK = :OLD.ID_STAGE_PERSON_LINK 
                      AND   SSH.DT_UNASSGND IS NULL 
                      AND   SSH.ID_PERSON = :OLD.ID_PERSON; 

                  INSERT INTO STAGE_ASSIGN_HISTORY 
             (ID_STG_ASSGN_HSTRY, 
              ID_STAGE_PERSON_LINK, 
          DT_LST_UPDT, 
          ID_STAGE, 
          ID_PERSON, 
          ID_CASE, 
          CD_ROLE, 
          DT_ASSGND, 
          DT_UNASSGND) 
      VALUES  (0, 
              :NEW.ID_STAGE_PERSON_LINK, 
              :NEW.DT_LAST_UPDATE, 
              :NEW.ID_STAGE, 
              :NEW.ID_PERSON, 
              :NEW.ID_CASE, 
              :NEW.CD_STAGE_PERS_ROLE, 
              SYSDATE, TO_DATE('12/31/4712','MM/DD/YYYY')); 

                  EXCEPTION 
                      WHEN OTHERS THEN RAISE; 
                  END; 

            END IF; 
            END IF; 

            IF (:NEW.CD_STAGE_PERS_TYPE = 'STF') THEN 
               IF  (:OLD.ID_PERSON != :NEW.ID_PERSON) THEN 
                   BEGIN 
                   UPDATE STAGE_ASSIGN_HISTORY SSH 
                   SET SSH.DT_UNASSGND  = SYSDATE 
                   WHERE SSH.ID_STAGE_PERSON_LINK = :OLD.ID_STAGE_PERSON_LINK 
                   AND SSH.DT_UNASSGND IS NULL 
                   AND SSH.ID_PERSON = :OLD.ID_PERSON; 

                   INSERT INTO STAGE_ASSIGN_HISTORY 
                          (ID_STG_ASSGN_HSTRY, 
                           ID_STAGE_PERSON_LINK, 
                     DT_LST_UPDT, 
                     ID_STAGE, 
                     ID_PERSON, 
                     ID_CASE, 
                     CD_ROLE, 
                     DT_ASSGND) 
                   VALUES  (0, 
                          :NEW.ID_STAGE_PERSON_LINK, 
                          :NEW.DT_LAST_UPDATE, 
                          :NEW.ID_STAGE, 
                          :NEW.ID_PERSON, 
                          :NEW.ID_CASE, 
                          :NEW.CD_STAGE_PERS_ROLE, 
                          SYSDATE); 

                   EXCEPTION 
                   WHEN OTHERS THEN RAISE; 
               END; 
            END IF; 
            END IF; 

            IF ( ((:NEW.CD_STAGE_PERS_ROLE = 'SE') OR 
                  (:NEW.CD_STAGE_PERS_ROLE = 'PR')) 
                   AND (:OLD.CD_STAGE_PERS_ROLE <> 'HP') ) 
            THEN 

               :NEW.IND_STAGE_PERS_PR_SEC_ASGN := 'Y'; 

                IF (  (:NEW.ID_CASE <> :OLD.ID_CASE)   OR 
                     ( (:OLD.ID_CASE IS NULL) AND (:NEW.ID_CASE <> 0)) ) 
                THEN 
                    BEGIN 

                    SELECT NM_CASE, 
                           IND_CASE_SENSITIVE 
                    INTO   zNM_CASE, 
                           zIND_CASE_SENSITIVE 
                    FROM   CAPS_CASE  C 
                    WHERE  C.ID_CASE  = :NEW.ID_CASE; 



                    UPDATE WORKLOAD W 
                    SET   W.NM_WKLD_CASE               = zNM_CASE, 
                          W.IND_WKLD_CASE_SENSITIVE    = zIND_CASE_SENSITIVE 
                    WHERE W.ID_WKLD_STAGE              = :OLD.ID_STAGE; 
                    END; 

                 END IF; 



                UPDATE  WORKLOAD W 
                SET     W.ID_WKLD_PERSON               = :NEW.ID_PERSON, 
                        W.CD_WKLD_STAGE_PERS_ROLE      = :NEW.CD_STAGE_PERS_ROLE, 
                        W.DT_WKLD_STAGE_PERS_LINK      = :NEW.DT_STAGE_PERS_LINK, 
                        W.DT_LAST_UPDATE               = :NEW.DT_LAST_UPDATE, 
                        W.IND_WKLD_STAGE_PERS_NEW      = :NEW.IND_STAGE_PERS_EMP_NEW, 
                        W.ID_WKLD_CASE                 = :NEW.ID_CASE 
                WHERE   W.ID_WKLD_STAGE                = :OLD.ID_STAGE 
                AND     W.ID_WKLD_PERSON               = :OLD.ID_PERSON; 
        
        
            END IF; 


        --- 
        --- When the role changes from PR to HP, then the STAGE 
        --- itself has been closed, and should no longer appear 
        --- on someone's workload. Delete workload row. 
        --- 


        IF (  (:OLD.CD_STAGE_PERS_ROLE = 'PR') AND 
              (:NEW.CD_STAGE_PERS_ROLE = 'HP')    ) 
        THEN 
            DELETE FROM WORKLOAD W 
            WHERE  W.ID_WKLD_STAGE  =        :OLD.ID_STAGE 
            AND    W.ID_WKLD_PERSON =        :OLD.ID_PERSON; 

        END IF; 

        --- 
        --- If a worker has been changed from HP back to Primary 
        --- on a stage/home/etc, then a row needs to be inserted 
        --- on Workload table - similar code used here as used in 
        --- TIBR.     KJM 10/21/96 
        --- 


        IF (:OLD.CD_STAGE_PERS_ROLE = 'HP' AND 
              (  :NEW.CD_STAGE_PERS_ROLE = 'PR' OR 
                 :NEW.CD_STAGE_PERS_ROLE = 'SE' )  ) 
        THEN 

            BEGIN 

               :NEW.IND_STAGE_PERS_PR_SEC_ASGN := 'Y'; 

                --- Get all the relevant workload data 
                --- together, then insert one complete row 
                --- into the WORKLOAD table. 

                BEGIN 
                  SELECT          ID_CASE 
                  INTO            :NEW.ID_CASE 
                  FROM            STAGE 
                  WHERE           ID_STAGE = :NEW.ID_STAGE; 

                  zID_CASE := :NEW.ID_CASE; 

                EXCEPTION 
                    WHEN OTHERS THEN 
                        IF SQL%NOTFOUND THEN 
                        :NEW.ID_CASE := NULL; 
                        END IF; 
                END; 

                SELECT CD_STAGE, 
                       CD_STAGE_TYPE, 
                       ID_UNIT, 
                       CD_STAGE_REASON_CLOSED, 
                       CD_STAGE_CNTY, 
                       NM_STAGE, 
                       CD_STAGE_REGION, 
                       CD_STAGE_PROGRAM 
                INTO   xCD_STAGE, 
                       xCD_STAGE_TYPE, 
                       xID_UNIT, 
                       xCD_STAGE_REASON_CLOSED, 
                       xCD_STAGE_CNTY, 
                       xNM_STAGE, 
                       xCD_STAGE_REGION, 
                       xCD_STAGE_PROGRAM 
                FROM   STAGE  S 
                WHERE  S.ID_STAGE = :NEW.ID_STAGE; 

        --- 
        --- Get the unit number based on the id unit. 
        --- 

                SELECT NBR_UNIT 
                INTO   yNBR_UNIT 
                FROM   UNIT U 
                WHERE  U.ID_UNIT = xID_UNIT; 

                IF (zID_CASE <> 0) 
                THEN 
                    SELECT NM_CASE, 
                           IND_CASE_SENSITIVE 
                INTO       zNM_CASE, 
                           zIND_CASE_SENSITIVE 
                FROM       CAPS_CASE C 
                WHERE      C.ID_CASE = zID_CASE; 

                ELSE 
                           zNM_CASE               := NULL; 
                           zIND_CASE_SENSITIVE    := NULL; 
                END IF; 

                INSERT INTO WORKLOAD(ID_WKLD_STAGE, 
                                     ID_WKLD_PERSON, 
                                     DT_LAST_UPDATE, 
                                     ID_WKLD_CASE, 
                                     CD_WKLD_STAGE_PERS_ROLE, 
                                     DT_WKLD_STAGE_PERS_LINK, 
                                     IND_WKLD_STAGE_PERS_NEW, 
                                     NM_WKLD_STAGE, 
                                     CD_WKLD_STAGE, 
                                     CD_WKLD_STAGE_CNTY, 
                                     CD_WKLD_STAGE_TYPE, 
                                     CD_WKLD_STAGE_REGION, 
                                     CD_WKLD_STAGE_RSN_CLS, 
                                     CD_WKLD_STAGE_PROGRAM, 
                                     ID_WKLD_UNIT, 
                                     NBR_WKLD_UNIT, 
                                     NM_WKLD_CASE, 
                                     IND_WKLD_CASE_SENSITIVE 
                                     ) 
                VALUES(:NEW.ID_STAGE, 
                                     :NEW.ID_PERSON, 
                                     :NEW.DT_LAST_UPDATE, 
                                     zID_CASE, 
                                     :NEW.CD_STAGE_PERS_ROLE, 
                                     :NEW.DT_STAGE_PERS_LINK, 
                                     :NEW.IND_STAGE_PERS_EMP_NEW, 
                                     xNM_STAGE, 
                                     xCD_STAGE, 
                                     xCD_STAGE_CNTY, 
                                     xCD_STAGE_TYPE, 
                                     xCD_STAGE_REGION, 
                                     xCD_STAGE_REASON_CLOSED, 
                                     xCD_STAGE_PROGRAM, 
                                     xID_UNIT, 
                                     yNBR_UNIT, 
                                     zNM_CASE, 
                                     zIND_CASE_SENSITIVE); 

            END; 

      END IF;

       IF ( (:OLD.ID_PERSON IS NOT NULL) AND (:OLD.ID_PERSON <> 0) ) 
       THEN 
          -- DBCR 4369 on 7/30/2007 adds check to only update workload
          -- counts for human users, and not the artificial account(s)
          -- used by the conversion process.
          SELECT 
             NM_PERSON_FIRST 
          INTO  zNM_PERSON_FIRST 
          FROM PERSON 
          WHERE ID_PERSON = :OLD.ID_PERSON;
          
          IF ( zNM_PERSON_FIRST <> 'Conversion')
          THEN
             Update_Workload_Counts(:OLD.ID_PERSON, oldID_UNIT);
          END IF; 
       END IF; 
     
       IF ( (:NEW.ID_PERSON IS NOT NULL) AND (:NEW.ID_PERSON <> 0) ) 
       THEN 
          -- DBCR 4369 on 7/30/2007 adds check to only update workload
          -- counts for human users, and not the artificial account(s)
          -- used by the conversion process.
          SELECT 
             NM_PERSON_FIRST 
          INTO  zNM_PERSON_FIRST 
          FROM PERSON 
          WHERE ID_PERSON = :NEW.ID_PERSON;
          
          IF ( zNM_PERSON_FIRST <> 'Conversion')
          THEN
             Update_Workload_Counts(:NEW.ID_PERSON, newID_UNIT);
          END IF;
       END IF; 


    ELSIF DELETING 

        THEN 

        --- :new.DT_LAST_UPDATE := SYSDATE; 

   IF :OLD.ID_CASE IS NOT NULL THEN 
   BEGIN 
    SELECT ID_WKLD_PERSON, ID_WKLD_CASE 
    INTO xID_WKLD_PERSON, xID_WKLD_CASE 
    FROM WORKLOAD 
    WHERE ID_WKLD_STAGE = :OLD.ID_STAGE 
    AND CD_WKLD_STAGE IN ('INV','SVC') 
    AND CD_WKLD_STAGE_PERS_ROLE = 'PR' 
    AND CD_WKLD_STAGE_PROGRAM = 'APS'; 
  EXCEPTION 
  WHEN OTHERS THEN 
  NULL; 
  END; 
  IF (xID_WKLD_PERSON IS NOT NULL AND xID_WKLD_CASE IS NOT NULL) THEN 


  INSERT INTO DELETE_CASE_HIST 
    ( 
    ID_DELETE_CASE_HIST, 
    DT_LAST_UPDATE, 
    TABLE_NAME, 
    PK_COLUMN_NAME, 
    PK_VALUE, 
    ID_CASE, 
    ID_PERSON 
    ) 
    VALUES 
    ( 
    NULL, 
    NULL, 
    'STAGE_PERSON_LINK', 
    'ID_STAGE_PERSON_LINK', 
    :OLD.ID_STAGE_PERSON_LINK, 
    xID_WKLD_CASE, 
    xID_WKLD_PERSON 
    ); 
   END IF; 

    END IF; 

        --- If not updating, then deleting. On a delete, if the ROLE is "SE" 
        --- or 'PR' then delete from the WORKLOAD table 
        --- where ID_WKLD_STAGE = ID_STAGE and ID_WKLD_PERSON = ID_PERSON 
        --- (unique key on WORKLOAD table). 
        --- 

        --- 
        --- Additionally, upon delete, if the TYPE is "STF" then 
        --- update the STAGE_ASSIGN_HISTORY table setting the 
        --- DT_STAGE_PERS_UNASSIGNED to SYSDATE (today's date) 
        --- 

        IF (:OLD.CD_STAGE_PERS_TYPE = 'STF') THEN 
            BEGIN 
            UPDATE STAGE_ASSIGN_HISTORY SSH 
            SET SSH.DT_UNASSGND  = SYSDATE 
            WHERE SSH.ID_STAGE_PERSON_LINK = :OLD.ID_STAGE_PERSON_LINK 
            AND SSH.ID_PERSON =  :OLD.ID_PERSON 
            AND SSH.DT_UNASSGND IS NULL; 

            EXCEPTION 
               WHEN OTHERS THEN RAISE; 
            END; 

        END IF; 



        IF ( (:OLD.CD_STAGE_PERS_ROLE = 'SE') OR 
             (:OLD.CD_STAGE_PERS_ROLE = 'PR') ) 
        THEN 

            BEGIN 
            DELETE FROM WORKLOAD W 
            WHERE  W.ID_WKLD_STAGE         = :OLD.ID_STAGE 
            AND    W.ID_WKLD_PERSON        = :OLD.ID_PERSON; 

            EXCEPTION 
               WHEN OTHERS THEN RAISE; 
            END; 

        END IF; 

     -- DBCR 4369 on 7/30/2007 adds check to only update workload
     -- counts for human users, and not the artificial account(s)
     -- used by the conversion process.
     SELECT 
       NM_PERSON_FIRST 
     INTO  zNM_PERSON_FIRST 
     FROM PERSON 
     WHERE ID_PERSON = :OLD.ID_PERSON;
     
     IF ( (:OLD.ID_PERSON IS NOT NULL) AND (:OLD.ID_PERSON <> 0)
           AND ( zNM_PERSON_FIRST <> 'Conversion') ) 
     THEN 
          Update_Workload_Counts(:OLD.ID_PERSON, oldID_UNIT); 
     END IF; 

    END IF; 

    --- This is the end if associated with the IF/THEN at the top 
    --- of trigger where it says "IF UPDATING" 
    

END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_STAGE_PERSON_LINK
BEFORE INSERT
ON CAPS.STAGE_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        dummy                       NUMBER;
        xNM_STAGE                   VARCHAR2(25);
        xCD_STAGE                   VARCHAR2(3);
        xCD_STAGE_CNTY              VARCHAR2(3);
        xCD_STAGE_TYPE              VARCHAR2(5);
        xCD_STAGE_REGION            VARCHAR2(2);
        xCD_STAGE_REASON_CLOSED     VARCHAR2(3);
        xCD_STAGE_PROGRAM           VARCHAR2(3);
        xID_UNIT                    NUMBER(16);
        yNBR_UNIT                   VARCHAR2(2);
        zNM_CASE                    VARCHAR2(25);
        zIND_CASE_SENSITIVE         VARCHAR2(1);
        zID_CASE                    NUMBER(16);
        zNM_PERSON_FIRST            PERSON.NM_PERSON_FIRST%TYPE;

BEGIN
        :NEW.DT_LAST_UPDATE := SYSDATE;

        ---
        --- BSG: Added trigger to populate primary/secondary indicator column
        ---
        --- KJM: Added to this trigger code to write to the WORKLOAD table.
        ---

        IF (:NEW.ID_STAGE_PERSON_LINK = 0) THEN
                SELECT  SEQ_STAGE_PERSON_LINK.NEXTVAL
                INTO    dummy
                FROM    DUAL;
                :NEW.ID_STAGE_PERSON_LINK := dummy;
        END IF;

   BEGIN

        SELECT          ID_CASE
        INTO            :NEW.ID_CASE
        FROM            STAGE
        WHERE           ID_STAGE = :NEW.ID_STAGE;

        zID_CASE := :NEW.ID_CASE;

    EXCEPTION
        WHEN OTHERS THEN
                IF SQL%NOTFOUND THEN
                        :NEW.ID_CASE := NULL;
                END IF;
    END;

        --- mitschcg - 3/6/2000
        --- added a history table of all staff assignments
        --- to a particular stage for reporting purposes

    IF (:NEW.CD_STAGE_PERS_TYPE = 'STF')    THEN
               INSERT INTO STAGE_ASSIGN_HISTORY
                      (ID_STG_ASSGN_HSTRY,
                       ID_STAGE_PERSON_LINK,
                     DT_LST_UPDT,
                     ID_STAGE,
                     ID_PERSON,
                     ID_CASE,
                     CD_ROLE,
                     DT_ASSGND)
              VALUES  (0,
                       :NEW.ID_STAGE_PERSON_LINK,
                       :NEW.DT_LAST_UPDATE,
                       :NEW.ID_STAGE,
                       :NEW.ID_PERSON,
                       :NEW.ID_CASE,
                       :NEW.CD_STAGE_PERS_ROLE,
                       :NEW.DT_STAGE_PERS_LINK);

    END IF;


    IF ((:NEW.CD_STAGE_PERS_ROLE = 'SE') OR
            (:NEW.CD_STAGE_PERS_ROLE = 'PR'))
    THEN

                :NEW.IND_STAGE_PERS_PR_SEC_ASGN := 'Y';

                --- Get all the relevant workload data
                --- together, then insert one complete row
                --- into the WORKLOAD table.

                BEGIN

                  SELECT CD_STAGE,
                       CD_STAGE_TYPE,
                       ID_UNIT,
                       CD_STAGE_REASON_CLOSED,
                       CD_STAGE_CNTY,
                       NM_STAGE,
                       CD_STAGE_REGION,
                       CD_STAGE_PROGRAM
                  INTO   xCD_STAGE,
                       xCD_STAGE_TYPE,
                       xID_UNIT,
                       xCD_STAGE_REASON_CLOSED,
                       xCD_STAGE_CNTY,
                       xNM_STAGE,
                       xCD_STAGE_REGION,
                       xCD_STAGE_PROGRAM
                   FROM   STAGE  S
                   WHERE  S.ID_STAGE = :NEW.ID_STAGE;

                    --- If no row is found, this is an error

                   END;
        ---
        --- Get the unit number based on the id unit.
        ---

        SELECT NBR_UNIT
                INTO   yNBR_UNIT
                FROM   UNIT U
                WHERE  U.ID_UNIT = xID_UNIT;

        IF (zID_CASE <> 0)
          THEN
             SELECT NM_CASE,
                    IND_CASE_SENSITIVE
             INTO   zNM_CASE,
                    zIND_CASE_SENSITIVE
             FROM   CAPS_CASE C
             WHERE  C.ID_CASE = zID_CASE;
          ELSE
             zNM_CASE               := NULL;
             zIND_CASE_SENSITIVE    := NULL;

          END IF;


        INSERT INTO WORKLOAD(ID_WKLD_STAGE,
                                     ID_WKLD_PERSON,
                                     DT_LAST_UPDATE,
                                     ID_WKLD_CASE,
                                     CD_WKLD_STAGE_PERS_ROLE,
                                     DT_WKLD_STAGE_PERS_LINK,
                                     IND_WKLD_STAGE_PERS_NEW,
                                     NM_WKLD_STAGE,
                                     CD_WKLD_STAGE,
                                     CD_WKLD_STAGE_CNTY,
                                     CD_WKLD_STAGE_TYPE,
                                     CD_WKLD_STAGE_REGION,
                                     CD_WKLD_STAGE_RSN_CLS,
                                     CD_WKLD_STAGE_PROGRAM,
                                     ID_WKLD_UNIT,
                                     NBR_WKLD_UNIT,
                                     NM_WKLD_CASE,
                                     IND_WKLD_CASE_SENSITIVE
                                     )
        VALUES(:NEW.ID_STAGE,
                                     :NEW.ID_PERSON,
                                     :NEW.DT_LAST_UPDATE,
                                     zID_CASE,
                                     :NEW.CD_STAGE_PERS_ROLE,
                                     :NEW.DT_STAGE_PERS_LINK,
                                     :NEW.IND_STAGE_PERS_EMP_NEW,
                                     xNM_STAGE,
                                     xCD_STAGE,
                                     xCD_STAGE_CNTY,
                                     xCD_STAGE_TYPE,
                                     xCD_STAGE_REGION,
                                     xCD_STAGE_REASON_CLOSED,
                                     xCD_STAGE_PROGRAM,
                                     xID_UNIT,
                                     yNBR_UNIT,
                                     zNM_CASE,
                                     zIND_CASE_SENSITIVE);

        -- DBCR 4369 on 7/30/2007 adds check to only update workload
        -- counts for human users, and not the artificial account(s)
        -- used by the conversion process.
        SELECT 
           NM_PERSON_FIRST 
        INTO  zNM_PERSON_FIRST 
        FROM PERSON 
        WHERE ID_PERSON = :NEW.ID_PERSON;
    
        IF ( zNM_PERSON_FIRST <> 'Conversion')
        THEN
           UPDATE_WORKLOAD_COUNTS(:NEW.ID_PERSON, xID_UNIT);
        END IF;

     ELSE
            :NEW.IND_STAGE_PERS_PR_SEC_ASGN := 'N';
     END IF;

EXCEPTION
WHEN OTHERS THEN RAISE;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00004347
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
VALUES (60358, 'MSG_VNDR_PEND' ,'The Resource Details can not be updated until Vendor ID is assigned by SMILE', 500, 700, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (218, 'SacwisRev2', 'static updates, new SPL triggers, two new fields in PAYMENT OF CARE');

commit;


