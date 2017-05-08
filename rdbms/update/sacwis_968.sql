--STGAP00016081 - Release(4.2) MR-075 FA Home Reimbursability Enhancement DBCR

-- MR-075 Foster Home Reimbursability Enhancement DBCR


-- add new columns for FA person detail
ALTER TABLE CAPS.PERSON_DTL
ADD (
      DT_LAST_GCIC_RC DATE,
      DT_GCIC_RC_DUE DATE,
      DT_LAST_NCIC_RC DATE,
      DT_NCIC_RC_DUE DATE
);

COMMENT ON COLUMN CAPS.PERSON_DTL.DT_LAST_GCIC_RC IS 'Date of last GCIC record check completed.';
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_GCIC_RC_DUE IS 'Date of next GCIC record check due.';
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_LAST_NCIC_RC IS 'Date of last NCIC record check completed.';
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_NCIC_RC_DUE IS 'Date of next NCIC record check due.';

-- Add new columns for resource
ALTER TABLE CAPS.CAPS_RESOURCE
ADD (
      IND_IVE_REIMBURSABLE VARCHAR2(1),
      DT_REIMBURSABLE_EFFECTIVE DATE,
      DT_REIMBURSABLE_END DATE
);

COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_IVE_REIMBURSABLE IS 'Indicate whether home is IV-E Reimbursable';
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_REIMBURSABLE_EFFECTIVE IS 'Date of when home reimbursability status is effective.';

COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_REIMBURSABLE_END IS 'Date of when home reimbursability status ends.';

-- add new columns for resource_history
ALTER TABLE CAPS.RESOURCE_HISTORY
ADD (
      IND_IVE_REIMBURSABLE VARCHAR2(1),
      DT_REIMBURSABLE_EFFECTIVE DATE,
      DT_REIMBURSABLE_END DATE
);

COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_IVE_REIMBURSABLE IS 'Indicates home is IV-E Reimbursable.';
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_REIMBURSABLE_EFFECTIVE IS 'Date of when home reimbursability status is effective.';
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_REIMBURSABLE_END IS 'Date of when home reimbursability status ends.';

-- add new columns for resource_history_audit
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT
ADD (
      IND_IVE_REIMBURSABLE VARCHAR2(1),
      DT_REIMBURSABLE_EFFECTIVE DATE,
      DT_REIMBURSABLE_END DATE
);

COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_IVE_REIMBURSABLE IS 'Indicates home is IV-E Reimbursable.';
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_REIMBURSABLE_EFFECTIVE IS 'Date of when home reimbursability status is effective.';
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_REIMBURSABLE_END IS 'Date of when home reimbursability status ends.';


-- new placement validation messages
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0, 60815, 'MSG_PLCMT_HOLD','Home is on hold- No additional placements allowed.',700,500,'N');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0, 60816, 'MSG_PLCMT_GRACE_PER_UNAPRV','Verifications for Household Members pending- No additional placements allowed.',700,500,'N');

-- Add new code type to CODES_TABLES
-- New FAD Home statuses
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CFAHMSTA', 'FLG', 'Full Approval 30 Day Grace Period');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CFAHMSTA', 'FSG', 'Full (Special) Approval 30 Day Grace Period');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CFAHMSTA', 'AUN', 'Unapproved');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CFAHMSTA', 'PFG', 'Pending Full Approval 30 Day Grace Period');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CFAHMSTA', 'PSG', 'Pending Full (Special) Approval 30 Day Grace Period');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CFAHMSTA', 'PUN', 'Pending Unapprove');

-- End dating Temporary home status
UPDATE CAPS.codes_tables
SET DT_END = sysdate
where code_type = 'CFAHMSTA'
and code = 'PTA';

UPDATE CAPS.codes_tables
SET DT_END = sysdate
where code_type = 'CFAHMSTA'
and code = 'ATA';

-- new Health Detail Reason
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CARSAPPT', 'DRG', 'Drug Screen');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CARSAPPT', 'HST', 'Health Statement (FAD HH Member)');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CARSAPPT', 'PTB', 'Tubercolosis (TB)');

-- new codes table to 30 Day Compliance Waiver reasons
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CWGPRSN', 'CFM', 'CRC needed on Foster Mother');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CWGPRSN', 'CFF', 'CRC needed on Foster Father');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CWGPRSN', 'CHM', 'CRC needed on Other/New Household Member');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CWGPRSN', 'HFM', 'Health Information needed on Foster Mother');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CWGPRSN', 'HFF', 'Health Information needed on Foster Father');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CWGPRSN', 'HHM', 'Health Information needed on Other/New Household Member');


-- new Policy Waiver type
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CWVRTYP', 'WGP', '30 Day Grace Period Waiver');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (969, 'SacwisRev4', 'Release 4.2 - DBCR 16081');

commit;


