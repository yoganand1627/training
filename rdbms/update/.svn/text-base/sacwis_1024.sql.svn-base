--STGAP00016154 - Release(4.3) DBCR's for CAPTA 4.3 Release

-- For External Documentation new values added

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES ('CEXDOTYP', 'SX', 'Safety Rsrc Assess. Signature Pg', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES ('CEXDOTYP', 'RX', 'Rel. Care Assess. Signature Pg.', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES ('CEXDOCCD', 'SX', 'Safety Rsrc Assess. Signature Pg', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES ('CEXDOCCD', 'RX', 'Rel. Care Assess. Signature Pg.', SYSDATE);


-- For Allegation Detail
INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES ('CMALCODE', 'P14', 'No Injuries Observed', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES ('CRELVICT', 'RP', 'Relative Placement Provider', SYSDATE);


-- For Safety Resource Assessment error messaging

Insert into CAPS.MESSAGE
  (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values
  (0, sysdate, 60863, 'MSG_SFTY_RSRC_ASSESS_FORM_REQ', 'Please complete the Safety Resource Assessment before submitting the Safety Resource for approval.', 700, 500, 'N');

Insert into CAPS.MESSAGE
  (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values
  (0, sysdate, 60864, 'MSG_SFTY_RSRC_PRIOR_HISTORY_WARN', 'An identified Safety Resource or Safety Resource Household Member has prior history.', 700, 500, 'N');

Insert into CAPS.MESSAGE
  (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values
  (0, sysdate, 60865, 'MSG_SFTY_RSRC_PLCMT_REC_REQ', 'Please provide your recommendation of the Primary Safety Resource for Placement.', 700, 500, 'N');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1025, 'SacwisRev4', 'Release 4.3 - DBCR 16154');

commit;


