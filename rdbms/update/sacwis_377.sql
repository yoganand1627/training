-- STGAP00010120 - Exchange Child detail - Need new codes table value

-- Codes Table entries for the code type - CTPRCODE

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CTPRCODE', '01', 'Court Order', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CTPRCODE', '02', 'Deceased', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CTPRCODE', '03', 'Voluntary Release', null, sysdate);

-- Codes Table entries for the code type - CADEXCLD --
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '02', 'Withdrawn (Family Only)', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '03', 'Denied (Family Only)', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '04', 'Other (Family Move/Ch Mar U18)', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '06', 'Child Over 18 Not Placed', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '07', 'Child Deceased (Under 18)', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '08', 'Custody To Relative', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '09', 'Custody To Guardian', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '10', 'Custody Returned to Parent', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '11', 'Overturned on Appeal', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '12', 'Parent Released Independent', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', '13', 'Custody to 3rd Party', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADEXCLD', 'UK', 'Unknown', null, sysdate);

-- STGAP00010122 - PERSON ChAR: CODES TABLE CHANGE

INSERT INTO  CAPS.CODES_TABLES (DECODE, CODE_TYPE, CODE) VALUES ('History of Sexual Abuse','OTH', '202');


-- STGAP00010135 - Exchange Child Detail

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values(SYSDATE, 60476, 'MSG_UNLINK_BEFORE_PLACEMENT',
 'Unlink all homes except the one where the child is being placed before updating the Non-Availability Reason Code.', 700, 500, 'N');

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values(SYSDATE, 60477, 'MSG_CMN_BEFORE_DOB', 'This date cannot be before the child''s date of birth.', 700, 500, 'N');




insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (378, 'SacwisRev3', 'Release 3.X - DBCRs 10120,10122,10135');

commit;


