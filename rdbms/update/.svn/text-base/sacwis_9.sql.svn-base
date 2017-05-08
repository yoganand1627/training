
-- Standard Alter Table SQL

ALTER TABLE CAPS.INCOME_AND_RESOURCES ADD DT_INC_RSRC_MODIFIED DATE     NULL
;
ALTER TABLE CAPS.PERSON ADD TXT_PERSON_OTHER_RELATIONSHIPS VARCHAR2(300)     NULL
;


-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE_PERSON_LINK
BEFORE UPDATE OR DELETE
ON CAPS.STAGE_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        xNM_STAGE                   	STAGE.NM_STAGE%TYPE;
        xCD_STAGE                   	STAGE.CD_STAGE%TYPE;
        xCD_STAGE_CNTY              	STAGE.CD_STAGE_CNTY%TYPE;
        xCD_STAGE_TYPE              	STAGE.CD_STAGE_TYPE%TYPE;
        xCD_STAGE_REGION            	STAGE.CD_STAGE_REGION%TYPE;
        xCD_STAGE_REASON_CLOSED     	STAGE.CD_STAGE_REASON_CLOSED%TYPE;
        xCD_STAGE_PROGRAM           	STAGE.CD_STAGE_PROGRAM%TYPE;
        xID_UNIT                    	UNIT.ID_UNIT%TYPE;
        yNBR_UNIT                   	UNIT.NBR_UNIT%TYPE;
        zNM_CASE                    	CAPS_CASE.NM_CASE%TYPE;
        zIND_CASE_SENSITIVE         	CAPS_CASE.IND_CASE_SENSITIVE%TYPE;
        zID_CASE                    	CAPS_CASE.ID_CASE%TYPE;
	xID_WKLD_PERSON		    	WORKLOAD.ID_WKLD_PERSON%TYPE;
	xID_WKLD_CASE		    	WORKLOAD.ID_WKLD_CASE%TYPE;
	v_ml_user_cntr			NUMBER :=0;
	v_workload_row			workload%rowtype;

BEGIN

    IF UPDATING
    THEN
           :new.DT_LAST_UPDATE := SYSDATE;

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
	---	 the DELETE_WORKLOAD_HIST table would be referred to get a refresh list
	---      of MPS's workload page.
	---


            IF (:new.CD_STAGE_PERS_TYPE = 'STF') THEN
               IF ((:old.CD_STAGE_PERS_ROLE = 'PR') AND
                   (:new.CD_STAGE_PERS_ROLE = 'HP')) THEN
                  BEGIN
                      UPDATE STAGE_ASSIGN_HISTORY SSH
                      SET SSH.DT_UNASSGND  = SYSDATE
                      WHERE SSH.ID_STAGE_PERSON_LINK = :old.ID_STAGE_PERSON_LINK
                      AND   SSH.DT_UNASSGND IS NULL
                      AND   SSH.ID_PERSON = :old.ID_PERSON;

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
		          :new.ID_STAGE_PERSON_LINK,
		          :new.DT_LAST_UPDATE,
		          :new.ID_STAGE,
		          :new.ID_PERSON,
		          :new.ID_CASE,
		          :new.CD_STAGE_PERS_ROLE,
		          SYSDATE, TO_DATE('12/31/4712','MM/DD/YYYY'));

                  EXCEPTION
                      WHEN OTHERS THEN RAISE;
                  END;

            END IF;
            END IF;

            IF (:new.CD_STAGE_PERS_TYPE = 'STF') THEN
               IF  (:old.ID_PERSON != :new.ID_PERSON) THEN
                   BEGIN
                   UPDATE STAGE_ASSIGN_HISTORY SSH
                   SET SSH.DT_UNASSGND  = SYSDATE
                   WHERE SSH.ID_STAGE_PERSON_LINK = :old.ID_STAGE_PERSON_LINK
                   AND SSH.DT_UNASSGND IS NULL
                   AND SSH.ID_PERSON = :old.ID_PERSON;

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
                          :new.ID_STAGE_PERSON_LINK,
                          :new.DT_LAST_UPDATE,
                          :new.ID_STAGE,
                          :new.ID_PERSON,
                          :new.ID_CASE,
                          :new.CD_STAGE_PERS_ROLE,
                          SYSDATE);

                   EXCEPTION
                   WHEN OTHERS THEN RAISE;
               END;
            END IF;
            END IF;

            IF ( ((:new.CD_STAGE_PERS_ROLE = 'SE') OR
                  (:new.CD_STAGE_PERS_ROLE = 'PR'))
                   AND (:old.CD_STAGE_PERS_ROLE <> 'HP') )
            THEN

               :new.IND_STAGE_PERS_PR_SEC_ASGN := 'Y';

                IF (  (:new.ID_CASE <> :old.ID_CASE)   OR
                     ( (:old.ID_CASE IS NULL) AND (:new.ID_CASE <> 0)) )
                THEN
                    BEGIN

                    SELECT NM_CASE,
                           IND_CASE_SENSITIVE
                    INTO   zNM_CASE,
                           zIND_CASE_SENSITIVE
                    FROM   CAPS_CASE  C
                    WHERE  C.ID_CASE  = :new.ID_CASE;



                    UPDATE WORKLOAD W
                    SET   W.NM_WKLD_CASE               = zNM_CASE,
                          W.IND_WKLD_CASE_SENSITIVE    = zIND_CASE_SENSITIVE
                    WHERE W.ID_WKLD_STAGE              = :old.ID_STAGE;
                    END;

                 END IF;



                UPDATE  WORKLOAD W
                SET     W.ID_WKLD_PERSON               = :new.ID_PERSON,
                        W.CD_WKLD_STAGE_PERS_ROLE      = :new.CD_STAGE_PERS_ROLE,
                        W.DT_WKLD_STAGE_PERS_LINK      = :new.DT_STAGE_PERS_LINK,
                        W.DT_LAST_UPDATE               = :new.DT_LAST_UPDATE,
                        W.IND_WKLD_STAGE_PERS_NEW      = :new.IND_STAGE_PERS_EMP_NEW,
                        W.ID_WKLD_CASE                 = :new.ID_CASE
                WHERE   W.ID_WKLD_STAGE                = :old.ID_STAGE
                AND     W.ID_WKLD_PERSON               = :old.ID_PERSON;

            END IF;


        ---
        --- When the role changes from PR to HP, then the STAGE
        --- itself has been closed, and should no longer appear
        --- on someone's workload. Delete workload row.
        ---


        IF (  (:old.CD_STAGE_PERS_ROLE = 'PR') AND
              (:new.CD_STAGE_PERS_ROLE = 'HP')    )
        THEN
            DELETE FROM WORKLOAD W
            WHERE  W.ID_WKLD_STAGE  =        :old.ID_STAGE
            AND    W.ID_WKLD_PERSON =        :old.ID_PERSON;

        END IF;

        ---
        --- If a worker has been changed from HP back to Primary
        --- on a stage/home/etc, then a row needs to be inserted
        --- on Workload table - similar code used here as used in
        --- TIBR.     KJM 10/21/96
        ---


        IF (:old.CD_STAGE_PERS_ROLE = 'HP' AND
              (  :new.CD_STAGE_PERS_ROLE = 'PR' OR
                 :new.CD_STAGE_PERS_ROLE = 'SE' )  )
        THEN

            BEGIN

               :new.IND_STAGE_PERS_PR_SEC_ASGN := 'Y';

                --- Get all the relevant workload data
                --- together, then insert one complete row
                --- into the WORKLOAD table.

                BEGIN
                  SELECT          ID_CASE
                  INTO            :new.ID_CASE
                  FROM            STAGE
                  WHERE           ID_STAGE = :new.ID_STAGE;

                  zID_CASE := :new.ID_CASE;

                EXCEPTION
                    WHEN OTHERS THEN
                        IF SQL%NOTFOUND THEN
                        :new.ID_CASE := NULL;
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
                WHERE  S.ID_STAGE = :new.ID_STAGE;

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
                VALUES(:new.ID_STAGE,
                                     :new.ID_PERSON,
                                     :new.DT_LAST_UPDATE,
                                     zID_CASE,
                                     :new.CD_STAGE_PERS_ROLE,
                                     :new.DT_STAGE_PERS_LINK,
                                     :new.IND_STAGE_PERS_EMP_NEW,
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

        IF (:old.CD_STAGE_PERS_TYPE = 'STF') THEN
            BEGIN
            UPDATE STAGE_ASSIGN_HISTORY SSH
            SET SSH.DT_UNASSGND  = SYSDATE
            WHERE SSH.ID_STAGE_PERSON_LINK = :old.ID_STAGE_PERSON_LINK
            AND SSH.ID_PERSON =  :old.ID_PERSON
            AND SSH.DT_UNASSGND is null;

            EXCEPTION
               WHEN OTHERS THEN RAISE;
            END;

        END IF;



        IF ( (:old.CD_STAGE_PERS_ROLE = 'SE') OR
             (:old.CD_STAGE_PERS_ROLE = 'PR') )
        THEN

            BEGIN
            DELETE FROM WORKLOAD W
            WHERE  W.ID_WKLD_STAGE         = :old.ID_STAGE
            AND    W.ID_WKLD_PERSON        = :old.ID_PERSON;

            EXCEPTION
               WHEN OTHERS THEN RAISE;
            END;

        END IF;

    END IF;

    --- This is the end if associated with the IF/THEN at the top
    --- of trigger where it says "IF UPDATING"

END;
/

-- Synonym Alter SQL

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 19
UPDATE caps.metaphor 
SET txt_l1_img_inactive = 'Tb_Financial_2.gif' 
WHERE id_tab = 600; 

UPDATE caps.metaphor 
SET txt_l1_img_inactive = 'Tb_Resources_2.gif' 
WHERE id_tab = 1130; 

UPDATE caps.metaphor 
SET txt_l1_img_inactive = 'Tb_Reports_2.gif' 
WHERE id_tab = 1100;

-- change 22
update caps.codes_tables 
set dt_end = to_date('01/01/2006','MM/DD/YYYY') 
where CODE_type = 'CABALTYP' 
and CODE in 
('ABAN','EMAB','EXPL','MDNG','MHNG','NEGL','NSUP','PHAB','PHNG','RAPR','SUTH','SXAB','EXPC'); 
insert into caps.codes_tables 
values ('CABALTYP','NN','Neglect',null,to_date('09/05/2006','MM/DD/YYYY')); 
insert into caps.codes_tables 
values ('CABALTYP','EE','Emotional 
Abuse',null,to_date('09/05/2006','MM/DD/YYYY')); 
insert into caps.codes_tables 
values ('CABALTYP','PP','Physical 
Abuse',null,to_date('09/05/2006','MM/DD/YYYY')); 
insert into caps.codes_tables 
values ('CABALTYP','SS','Sexual 
Abuse',null,to_date('09/05/2006','MM/DD/YYYY')); 
insert into caps.codes_tables 
values ('CABALTYP','OO','Other',null,to_date('09/05/2006','MM/DD/YYYY'));

-- change 23
update caps.message 
set TXT_MESSAGE = 'Your data has been saved. To save a new Allegation, modify  at least one required field and click Add or Continue.' 
where NBR_MESSAGE = 25605; 
update caps.message 
set TXT_MESSAGE = 'Duplicate Record Exists. You must modify at least one  required field in order to save this Allegation.' 
where NBR_MESSAGE = 25606;

-- change 26
UPDATE caps.message 
SET txt_message = 'Copy is not available for this event.' 
WHERE nbr_message = 25325; 

UPDATE caps.message 
SET txt_message = 'This Intake is Incomplete. Please Complete before copying' 
WHERE nbr_message = 55147; 

UPDATE caps.message 
SET txt_message = 'Copy is only available for Task To-Do''s' 
WHERE nbr_message = 25570; 

UPDATE caps.message 
SET txt_message = 'Copy is not available when there are no existing To-Do''s.' 
WHERE nbr_message = 25383; 

UPDATE caps.message 
SET txt_message = 'You may select only one row to perform a Copy.' 
WHERE nbr_message = 25346; 

UPDATE caps.message 
SET txt_message = 'Copying not allowed in Family Plan Evaluation.' 
WHERE nbr_message = 5053; 

UPDATE caps.message 
SET txt_message = 'Copying requires selection of the same contact type.' 
WHERE nbr_message = 8408; 

UPDATE caps.message 
SET txt_message = 'Copy is not available for Approval To-Do''s.  An additional approver can be added while approving the event.' 
WHERE nbr_message = 2104; 

UPDATE caps.message 
SET txt_message = 'An error has occurred.  Retry the copy function.' 
WHERE nbr_message = 3115; 

UPDATE caps.message 
SET txt_message = 'Error occurred during copy.  Enter call through assigned workload.' 
WHERE nbr_message = 3116; 

UPDATE caps.message 
SET txt_message = 'You may only select one allegation when performing a Copy.' 
WHERE nbr_message = 25145; 

UPDATE caps.message 
SET txt_message = 'You do not have access to the copy function for this call.' 
WHERE nbr_message = 3098; 

UPDATE caps.message 
SET txt_message = 'Copy not available in this stage for this contact type.' 
WHERE nbr_message = 8413;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (10, 'SacwisRev1', 'Add column to PERSON and INCOME_AND_RESOURCES, misc static updates.');
                         
commit;
