-- change STGAP00005549
UPDATE CAPS.CODES_TABLES SET DECODE='Quarterly' WHERE CODE_TYPE='CFREQ' AND CODE='QRT';

-- change STGAP00005551
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60365, 'SSM_START_FUTURE_SOONER_12', 'The Start Date can be a future date no more than 12 months from the current date.', '700', '500', 'N');

-- change STGAP00005552
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='The child does not have an open eligibility summary with an actual eligibility of Title IV-E or State-Paid.' WHERE NBR_MESSAGE=25585;
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='If Selected Eligibility is ''Title IV-E'' or ''State-Paid'' a Medicaid Class of Assistance is required.' WHERE NBR_MESSAGE=25489;
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='Selected Eligibility of ''Title IV-E'' or ''State-Paid'' requires a Medicaid Class of Assistance to be entered.' WHERE NBR_MESSAGE=25182;

-- change STGAP00005576
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60366, 'MSG_FCE_COMMENT_ELIG_DIFF', 'Please provide Comments as to why the Selected Eligibility chosen is different from the Actual Eligibility.', '500', '700', 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (243, 'SacwisRev2', 'static table updates'); 
commit;
