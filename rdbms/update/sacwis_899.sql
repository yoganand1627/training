--STGAP00015995 - Release(4.0) MR-067: NYTD Survey Update CODES_TABLES

--MR-067 NYTD Survey Add New CODES_TABLES

DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CSEQNYTD';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES
('CSECQUES', 'S44', 'What is your favorite sport?');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES
('CSECQUES', 'S45', 'What is your favorite hobby?');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES
('CSECQUES', 'S46', 'What is/was your favorite subject in school?');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES
('CSECQUES', 'S47', 'What is your favorite food?');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES
('CSECQUES', 'S48', 'What is your favorite movie?');

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE_TYPE = 'CSECQUES'
AND CODE IN ('S02', 'S05', 'S08', 'S09', 'S10', 'S11', 'S15', 'S19', 'S20', 'S24', 'S33', 'S34', 'S35', 'S38');

UPDATE CAPS.CODES_TABLES
SET DECODE = 'What country would you like to visit?'
WHERE CODE_TYPE = 'CSECQUES' AND CODE = 'S18';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'As a child what did you want to be when you grew up?'
WHERE CODE_TYPE = 'CSECQUES' AND CODE = 'S22';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'What is the last name of your favorite teacher?'
WHERE CODE_TYPE = 'CSECQUES' AND CODE = 'S32';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'What is your favorite type of music?'
WHERE CODE_TYPE = 'CSECQUES' AND CODE = 'S37';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (900, 'SacwisRev4', 'Release 4.0 - DBCR 15995');

commit;

