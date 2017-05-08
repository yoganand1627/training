--STGAP00016136 - Release(4.3) MR-083 New codes, messages, and table field.

-- Increase fields size for ADO_INFO
ALTER TABLE CAPS.ADO_INFO
MODIFY (
      TXT_STATE_ACT varchar2(1000),
      TXT_CNTY_ACT varchar2(1000),
      TXT_COUNTY_CONS_COMMENT varchar2(2000)
);

-- Add new columns for EXCHANGE_CHILD and increase fields size
ALTER TABLE CAPS.EXCHANGE_CHILD
ADD (
      CD_STATE_ACTIVELY_RECRUITING VARCHAR2(1) DEFAULT 'A'
)
MODIFY (
      TXT_AVAIL_COMMENTS varchar2(2000),
      TXT_RECRUIT_COMMENT varchar2(1000)
);

COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_STATE_ACTIVELY_RECRUITING IS 'Indicate State is actively recruiting for child. CYESNONA code.';

-- BACKOUT
-- ALTER TABLE CAPS.ADO_INFO
-- MODIFY (
-- TXT_STATE_ACT varchar2(300),
-- TXT_CNTY_ACT varchar2(300),
-- TXT_COUNTY_CONS_COMMENT varchar2(300)
-- );

-- ALTER TABLE CAPS.EXCHANGE_CHILD drop column CD_STATE_ACTIVELY_RECRUITING;
-- ALTER TABLE CAPS.EXCHANGE_CHILD  MODIFY (TXT_AVAIL_COMMENTS varchar2(1000),TXT_RECRUIT_COMMENT varchar2(500));



-- MR-083 New codes, messages, and table field. Also updating to increase fields size.
-- Added new codes tables
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CYESNONA', 'Y', 'Yes');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CYESNONA', 'N', 'No');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CYESNONA', 'A', 'N/A');

-- Update state recruitment activity decode
UPDATE CAPS.CODES_TABLES
SET DECODE = 'It''s My Turn Now GA'
where CODE_TYPE = 'CADRACS'
and CODE = 'MTN';

-- New messages
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0, 60853,'MSG_CMN_DUPLICATE_DATE','You cannot enter a duplicate date.',700,500,'N');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60854,'MSG_ARC_CONSTR_PARA2000','Please enter no more than 2000 characters.',700,500,'N');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1014, 'SacwisRev4', 'Release 4.3 - DBCR 16136');

commit;


