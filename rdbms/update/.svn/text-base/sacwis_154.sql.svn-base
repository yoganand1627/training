
-- Standard Alter Table SQL

ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD NM_POLICY_HOLDER VARCHAR2(50)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00001955
UPDATE CAPS.CODES_TABLES SET CODE = 'VS' WHERE DECODE = 'Vital Statistics Record' AND CODE_TYPE = 'CCHKTYPE';
UPDATE CAPS.CODES_TABLES SET CODE = 'SV' WHERE DECODE = 'SAVE System' AND CODE_TYPE = 'CCHKTYPE';
UPDATE CAPS.CODES_TABLES SET CODE = 'PH' WHERE DECODE = 'Prior CPS History' AND CODE_TYPE = 'CCHKTYPE';
UPDATE CAPS.CODES_TABLES SET CODE = '91' WHERE DECODE = '911 Check' AND CODE_TYPE = 'CCHKTYPE';

-- change STGAP00001961
UPDATE CAPS.CODES_TABLES SET DECODE='Boarding County'
WHERE CODE_TYPE='CPLCMTIN'
AND CODE='070';

-- change STGAP00001960
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60268, 'MSG_PLCMT_CHILD_12_GROUP','A child under 12 can only be placed in a group setting if approved by the Family Services Director.  Please record the appropriate waiver',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60269, 'MSG_PLCMT_HOME_LIC_CAP'
,'Placing the child will exceed the placement''s capacity.  Please record the appropriate waiver',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60270, 'MSG_PLCMT_HOME_LIC_CH_AGE'
,'Placing the child will place the Foster Home out of IV-E compliance.  Please record the appropriate waiver',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60271, 'MSG_PLCMT_CONCURR_LENGTH','End Date must be no more than 14 days form Start Date for Concurrent Placements',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60272, 'MSG_PLCMT_RESP_LENGTH','End Date must be not be more than 5 days from the Start Date for Respite placements',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60273, 'MSG_PLCMT_TEMP_END_DATE_REQ','An end date is required to Save Concurrent and Respite temporary placements',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60274, 'MSG_PLCMT_FC_PER_DIEM_REQ','An approved, active Regular or Special foster Care Per Diem, or Specialized Foster Care Rate is required for a foster care placement',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60275, 'MSG_PLCMT_REL_SUP_REQ','An approved, active Enhanced Relative Rate, Relative Care Subsidy, Enhanced Relative Care Subsidy, Subsidized Guardianship, or Enhanced Subsidized Guardianship Payment of Care must exist for paid relative placement',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60276, 'MSG_PLCMT_NON_REL_SUP_REQ','An approved, active Non-Relative Subsidized Guardianship, or Non-Relative Enhanced Subsidized Guardianship Payment of Care must exist for paid non-relative placement',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60277, 'MSG_PLCMT_TEMP_TYPE_REQ','Temporary Placement Type is required',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60278, 'MSG_PLCMT_TEMP_COM_REQ','Temporary Placement comments are required',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60279, 'MSG_PLCMT_WAIVER_REQ','Waiver required is indicated.  Please select a waiver',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60280, 'MSG_PLCMT_WAIVER_TYPE_REQ','Please enter if the waiver needed belongs to this case or do the placement resource',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60281, 'MSG_PLCMT_WAIVER_RES_REQ','A resource must be selected before selecting a Home waiver',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60282, 'MSG_PLCMT_PERM_REP_REQ','Placement is not marked as Intended to be Permanent.  Please enter the next Permanency Report Due Date',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60283, 'MSG_PLCMT_TRIAL_HOME_PLCMT_BEGIN_REQ','Enter the Court Ordered Begin Date for the Trial Home Visit',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60284, 'MSG_PLCMT_TRIAL_HOME_PARENT','Placement Type must be Parent for Trial Home Visit',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60285, 'MSG_PLCMT_TRIAL_HOME_END_REQ','Enter the Court Ordered End Date for the Trial Home Visit',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60286, 'MSG_PLCMT_ADO_TYPE_REQ','An adoptive placement type has been selected.  Please enter the Adoption Type',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60287, 'MSG_PLCMT_CHECK_NO_COM_REQ','One or more items in the Placement checklist were answered "no".  Please enter comments',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60288, 'MSG_PLCMT_TRAUMA_COM_REQ','Trauma occurred during placement move.  Please enter comments',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60289, 'MSG_PLCMT_SIB_CARE_REQ','Answer to if child is able to stay with siblings is not N/A.  Please note number of siblings in care',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60290, 'MSG_PLCMT_SIB_REQ','Answer to if child is able to stay with siblings is not N/A.  Please note number of siblings placed with child',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60291, 'MSG_PLCMT_SIB_NO_REAS_REQ','Please record the reason child was not placed with siblings',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60292, 'MSG_PLCMT_SB_NO_COMM_REQ','Please record comments on why the child was not placed with siblings',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60293,'MSG_PLCMT_ADO_TRANS_REQ','Comments on child''s transition to adoptive home required for adoptive placements',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60294,'MSG_PLCMT_CCFA_NO_REAS_REQ','Please record the reason why CCFA recommendations were not used in placing the child',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60295,'MSG_PLCMT_CCFA_NO_COMM_REQ','Please record comments on why CCFA recommendations were not used in placing the child',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60296,'MSG_PLCMT_REFUS_REASON_REQ','Please enter reason placement was refused',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60297,'MSG_PLCMT_REMOV_REASON_REQ','Please enter reason child was removed',760,500,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (155, 'SacwisRev2', 'static updates');

commit;
