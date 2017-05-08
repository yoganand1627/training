--STGAP00011273 - Update TUBR_STAGE  trigger on the stage table

--Note:  no impact to ado model

--Updated tubr_stage trigger in the stage table to trigger a count on the workload
-- for case manager's out assigned to the unit. Also created a datafix to to clean
-- up workload table.

--Datafix 11303 is related to this defect.

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE
BEFORE UPDATE
ON CAPS.STAGE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE

     zNBR_UNIT       VARCHAR2(2);
	 xID_PERSON    UNIT_EMP_LINK.ID_PERSON%TYPE;
	 v_cd_int VARCHAR2(3) := 'INT';
     v_cd_inv VARCHAR2(3) := 'INV';
     v_cd_div VARCHAR2(3) := 'DIV';
     v_cd_ong VARCHAR2(3) := 'FPR';
     v_cd_fc  VARCHAR2(3) := 'SUB';
     v_cd_ado VARCHAR2(3) := 'ADO';
     v_cd_pad VARCHAR2(3) := 'PAD';
     v_cd_fad  VARCHAR2(3) := 'FAD';
     v_cd_pfc VARCHAR2(3) := 'PFC';

BEGIN
      ---
      --- KJM: Altered trigger to update the WORKLOAD table with
      --- relevant data where ID_STAGE=ID_STAGE  (provided that the
      --- stage is open).
      --- The exception handling has no special cases.
      --- Mitschke 05/19/03 SIR #17193 - during IMPACT testing, it was
      --- noticed by Carolyn Douglass that the comparison to 12/31/4712
      --- was not being handled.  This is being added.

        :NEW.DT_LAST_UPDATE := SYSDATE;

-- SIR#22851
   IF (:NEW.cd_stage_type IS NOT NULL AND :NEW.cd_stage_program IS NULL) THEN
        IF (:NEW.cd_stage_classification = 'LCC') THEN
            :NEW.cd_stage_program :=  'CCL';
        ELSIF (:NEW.cd_stage_classification = 'LRC') THEN
            :NEW.cd_stage_program :=  'RCL';
        ELSE
            :NEW.cd_stage_program :=  :NEW.cd_stage_classification;
   END IF;
   END IF;
-- SIR#22851

        IF ((:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/4712','MM/DD/YYYY'))
           OR (:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/3500','MM/DD/YYYY')) 
       OR (:NEW.DT_STAGE_CLOSE IS NULL))

        THEN

             IF ( (:NEW.ID_UNIT <> :OLD.ID_UNIT) OR
                  ( (:OLD.ID_UNIT IS NULL) AND
                    (:NEW.ID_UNIT <> 0)        ) )
             THEN
                   SELECT NBR_UNIT
                   INTO   zNBR_UNIT
                   FROM   UNIT  U
                   WHERE  U.ID_UNIT = :NEW.ID_UNIT;

                   UPDATE WORKLOAD W
                   SET    W.NBR_WKLD_UNIT  = zNBR_UNIT,
                          W.ID_WKLD_UNIT   = :NEW.ID_UNIT
                   WHERE  W.ID_WKLD_STAGE  = :NEW.ID_STAGE;

             END IF;

             UPDATE WORKLOAD W
             SET  W.CD_WKLD_STAGE                    = :NEW.CD_STAGE,
                  W.CD_WKLD_STAGE_TYPE               = :NEW.CD_STAGE_TYPE,
                  W.CD_WKLD_STAGE_CNTY               = :NEW.CD_STAGE_CNTY,
                  W.CD_WKLD_STAGE_REGION             = :NEW.CD_STAGE_REGION,
                  W.CD_WKLD_STAGE_PROGRAM            = :NEW.CD_STAGE_PROGRAM,
                  W.CD_WKLD_STAGE_RSN_CLS      = :NEW.CD_STAGE_REASON_CLOSED,
                  W.NM_WKLD_STAGE                    = :NEW.NM_STAGE
             WHERE  W.ID_WKLD_STAGE                  = :NEW.ID_STAGE;
			 
		  -- DBCR 11273 ON 11/17/2008 - Retrieves primary case manager's 
		  -- person ID from the workload table and uses that id_person
		  -- to trigger a count on the workload to update unit_emp_link
		  -- table. 

		SELECT ID_WKLD_PERSON
		  INTO xID_PERSON
		  FROM WORKLOAD
		  WHERE ID_WKLD_STAGE = :NEW.ID_STAGE
		  AND CD_WKLD_STAGE_PERS_ROLE = 'PR';
		  
		     IF :NEW.CD_STAGE = v_cd_int
             THEN
                 UPDATE UNIT_EMP_LINK
		       	 SET NBR_INT = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_INT = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
              END IF;
 
             IF :NEW.CD_STAGE = v_cd_div
             THEN
                 UPDATE UNIT_EMP_LINK
		  		 SET NBR_DIV = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_DIV = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
              END IF;
   
             IF :NEW.CD_STAGE = v_cd_inv
             THEN
                 UPDATE UNIT_EMP_LINK
		  		 SET NBR_INV = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_INV = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
             END IF;
   
             IF :NEW.CD_STAGE = v_cd_ong
             THEN
                  UPDATE UNIT_EMP_LINK
		  		  SET NBR_ONG = 1
		  		  WHERE ID_PERSON = xID_PERSON
		  		  AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		  UPDATE UNIT_EMP_LINK
		  		  SET NBR_ONG = 1
		  		  WHERE ID_PERSON = xID_PERSON
		  		  AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
             END IF;
   
            IF :NEW.CD_STAGE = v_cd_fc
            THEN
                 UPDATE UNIT_EMP_LINK
		  		 SET NBR_FC = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_FC = 1
		  		 WHERE ID_PERSON = xID_PERSON
		 		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;
   
            IF :NEW.CD_STAGE = v_cd_ado
            THEN
                 UPDATE UNIT_EMP_LINK
		  		 SET NBR_ADO = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_ADO = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;
   
            IF :NEW.CD_STAGE = v_cd_pad
            THEN
                 UPDATE UNIT_EMP_LINK
		 		 SET NBR_PAD = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_PAD = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;
   
            IF :NEW.CD_STAGE = v_cd_fad
            THEN
                 UPDATE UNIT_EMP_LINK
		  		 SET NBR_FAD = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_FAD = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;
            
            IF :NEW.CD_STAGE = v_cd_pfc
            THEN
                 UPDATE UNIT_EMP_LINK
		  		 SET NBR_PFC = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'IN';
				
		  		 UPDATE UNIT_EMP_LINK
		  		 SET NBR_PFC = 1
		  		 WHERE ID_PERSON = xID_PERSON
		  		 AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;        

        END IF;

        ---
        ---     Mitschcg 03/10/97 SIR request #11028 from Krista Moy/Tim Overend
        ---     to add the following trigger.  On update of stage table,
        ---     if DT_STAGE_CLOSE is max date ('12/31/4712') or is null,
        ---     then set the IND_STAGE_CLOSE to 'N' (the stage is
        ---     not closed), else set the IND_STAGE_CLOSE to 'Y' (the stage
        ---     is closed).

        IF ((:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/4712','MM/DD/YYYY'))
           OR (:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/3500','MM/DD/YYYY')) 
       OR (:NEW.DT_STAGE_CLOSE IS NULL))
        THEN
           :NEW.IND_STAGE_CLOSE := 'N';
        ELSE
           :NEW.IND_STAGE_CLOSE := 'Y';
        END IF;

EXCEPTION
   WHEN OTHERS THEN RAISE;

END;
/


--STGAP00011403 - Reports: INV response time - update parameter

--Note:  no impact to ado model

--Update to report Investigation Response Time: case manager ID parameter #4 needs
-- be a pullback and description updated with the addition of the new parameter

UPDATE CAPS.REPORT_PARAMETER SET NM_RPT_PARM_NAME = 'STAFFID', NM_RPT_PARM_LABEL = 'Staff ID'
WHERE NM_RPT_SQR_NAME = 'InvestigationResponseTimeList' AND NBR_RPT_PARM_SEQ = 4;

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of investigations with response time details where the associated intake record was received during the reporting month
. Generated for a specific month and county with optional unit number and case manager ID parameters.'
WHERE NM_RPT_SQR_NAME = 'InvestigationResponseTimeList';


--STGAP00011427 - Codes table change for Home Information screen

--Note:  no impact to ado model

UPDATE CAPS.codes_tables SET dt_end = SYSDATE WHERE code_type='CFACLOSE' AND code='ADO';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CFACLOSE', 'AFS', 'Adoption Finalized With Subsidies', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CFACLOSE', 'AFN', 'Adoption Finalized Without Subsidies', NULL, SYSDATE);

                INSERT INTO caps.stage_prog
                 (DT_LAST_UPDATE, CD_STAGE_PROG_STAGE,
                CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, IND_STAGE_PROG_CLOSE,
                CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STAGE_TYPE,
                CD_STAGE_PROG_STATUS, CD_STAGE_PROG_TASK, CD_STAGE_PROG_TODO_INFO,
                TXT_STAGE_PROG_EVNT_DESC,
                TXT_STAGE_PROG_TODO_DESC, NBR_STAGE_PROG_DAYS_DUE)
                VALUES (NULL,'FAD','AFS','CPS',0,NULL,'STG',NULL,'COMP',NULL,NULL,
                'F/A Home Stage Closed',NULL,NULL
                );

                INSERT INTO caps.stage_prog
                 (DT_LAST_UPDATE, CD_STAGE_PROG_STAGE,
                CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, IND_STAGE_PROG_CLOSE,
                CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STAGE_TYPE,
                CD_STAGE_PROG_STATUS, CD_STAGE_PROG_TASK, CD_STAGE_PROG_TODO_INFO,
                TXT_STAGE_PROG_EVNT_DESC,
                TXT_STAGE_PROG_TODO_DESC, NBR_STAGE_PROG_DAYS_DUE)
                VALUES (NULL,'FAD','AFN','CPS',0,NULL,'STG',NULL,'COMP',NULL,NULL,
                'F/A Home Stage Closed',NULL,NULL
                );


--STGAP00011429 - Reports: New SQR -Children with Overdue Case Plan

--Note:   no impact to ado model

--Insert rows to reporting's table to enable new SQR reports:

--Name: Children With Overdue Case Plan
--DEV#: STGAP00011010

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='ChildrenWithOverdueCasePLan'
and NM_RPT_SQR_VER='00') THEN
 INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME,
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE )
select 'ChildrenWithOverdueCasePLan' Column1, '00', 7, 'A', 'Children With Overdue Case Plan', 'ondport', 'P', 'W', 'A list of foster children in DFCS custody for more
 than 30 days without a case plan or whose most recent approved case plan has expired. Generated for a specific county with an optional unit parameter.', 'Foster Care', 'Y' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ChildrenWithOverdueCasePLan'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'ChildrenWithOverdueCasePLan', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ChildrenWithOverdueCasePLan'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'ChildrenWithOverdueCasePLan', '00', 2, 3, 'UNITCD', 'CHAR', 'N', 'Unit' from dual;


--STGAP00011462 - Resource : Need new CodesTable value for Facility

--Note:  no impact to ado model

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CFACTYP4', 'NA', 'Non-Incident Private Adoptive Home', null, SYSDATE);

--Need this change to resolve defect -    STGAP00011452.


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (407, 'SacwisRev3', 'Release 3.0 - DBCRs 11273,11403,11427,11429,11462');

commit;


