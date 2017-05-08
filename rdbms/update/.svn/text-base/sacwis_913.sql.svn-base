--STGAP00016016 - Release(4.1) MR-074 AFCARS: update, insert messages and new LS

--MR-074 AFCARS: update, insert messages and new LS

-- LS messages for MR-074 AFCARS
UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'The Legal County must be Out of State for this legal status.' 
WHERE TXT_MESSAGE_NAME = 'MSG_CUSTODY_WITH_OTHER_STATE';

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'All parents must have either a TPR Court Order Date with an outcome of TPR Granted, Voluntary Surrender Action Date, or Date of Death.' 
WHERE TXT_MESSAGE_NAME = 'MSG_MISSING_PARENT_TPR';

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60781,'MSG_CHILD_WAS_DISCHARGED_ERR',
'Following a discharge Legal Status, a new in-DFCS custody Legal Status must be entered in a new FCC stage.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60782,'MSG_DUP_NOT_IN_DFCS_ERR',
'A legal status indicating the child is not in the custody of DFCS already exists.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60783,'MSG_DISCHARGE_BEFORE_REMOVAL_ERR',
'The effective date of AFCARS discharge cannot be before the removal date.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60784,'MSG_LEG_STAT_EFF_BEFORE_TPR_VS_DOD_ERR',
'The legal status effective date cannot be before the TPR Court Order/VS date or date of death.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60785,'MSG_LEG_STAT_EFF_BEFORE_DOB_ERR',
'This legal status requires the person''s date of birth and the legal status effective date cannot be before the person was born.', 
700,500,'N');

-- Event List: warning on delete LS
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60786,'MSG_LEGAL_STATUS_DELETE_WARN',
'Warning: deleting the legal status may affect IV-E eligibility, payments, AFCARS reporting, etc. Proceed with caution.', 
700,500,'N');

-- New LS for ICPC children adopted in GA
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES 
('CLEGSTAT', 'NOT', 'Not In DFCS custody - Out of State Child Adopted by Georgia Family');
-- New Stage closure reason for ICPC children adopted in GA
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES 
('CCLOSADO', 'ICA', 'ICPC - Adoption');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (914, 'SacwisRev4', 'Release 4.1 - DBCR 16016');

commit;

