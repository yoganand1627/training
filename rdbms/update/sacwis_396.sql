--STGAP00010769 - A date field needs to be added to the STAGE table

ALTER TABLE CAPS.STAGE ADD DT_STAGE_SEALED DATE;


--STGAP00010545 - End Date Hearing Types On Legal Actions Page

update CAPS.CODES_TABLES
set DT_END = sysdate
where CODE_TYPE = 'CLHECOT' and CODE = 'IJR';

update CAPS.CODES_TABLES
set DT_END = sysdate
where CODE_TYPE = 'CLHECOT' and CODE = 'IPR';


--STGAP00010754 - DBCR - Per STGAP00010651  Insert new message

Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60488,   'MSG_RCA_SUPP_REFUSED_COMMENTS_REQ',
   'Comments are required if the caregiver refuses financial support', 500, 700, 'N');


--STGAP00010767 - Replace Immediate Hearing Types w Existing Values

update caps.legal_action
set legal_action.CD_HR_TYP_CRT_ORD = 'JDR'
where legal_action.CD_HR_TYP_CRT_ORD = 'IJR';

update caps.legal_action
set legal_action.CD_HR_TYP_CRT_ORD = 'PRM'
where legal_action.CD_HR_TYP_CRT_ORD = 'IPR';


--STGAP00010768 - (ADAM) Add Codes Table for Non-Incident AFCARS

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '01', 'None Applicable', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '02', 'Racial/Ethnic Background', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '03', 'Age', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '04', 'Membership in Sibling Group', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '05', 'Member of a sibling group of three placed together at the same time', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '06', 'Medical Conditions or Mental, Physical, Emotional Disabilities', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES VALUES('CPRSPCLN', '07', 'Other', NULL, SYSDATE);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (397, 'SacwisRev3', 'Release 3.0 - DBCRs 10769,10545,10754,10767,10768');

commit;


