--STGAP00016135 - Release(4.3) MR-087 New codes and new field

-- Add new columns for PAYMENT_OF_CARE
ALTER TABLE CAPS.PAYMENT_OF_CARE
ADD (
      IND_18_BY_NEXT_CRT_RVW VARCHAR2(1)
);

COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_18_BY_NEXT_CRT_RVW IS 'Indicate child turns 18 prior to next court review.';

-- BACKOUT
--alter table caps.payment_of_care drop column IND_18_BY_NEXT_CRT_RVW;

--MR-087 New codes and new field
-- Add new contact purpose codes
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CCNTPURP', 'RCR', 'Relative Custody Review');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CCNTPURP', 'NCR', 'Non-Relative Custody Review');

-- Add new case data external documentation type
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CEXDOCCD', 'RC', 'Relative Care Subsidy Application and Agreement');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1013, 'SacwisRev4', 'Release 4.3 - DBCR 16135');

commit;

