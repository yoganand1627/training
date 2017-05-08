--STGAP00015544 - MR-058 Case Review Remove Questions

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION = 'Q07' AND CD_SURVEY_CODE = 'INT';

DELETE FROM CAPS.CASE_REVIEW_SURVEY WHERE CD_QUESTION = 'Q08' AND CD_SURVEY_CODE = 'INT';

INSERT INTO CAPS.CASE_REVIEW_QUES_LOOKUP (CD_QUESTION, DT_LAST_UPDATE,TXT_QUESTION,NBR_QUESTION_ORDER,CD_ITEM, IND_QUESTION_TYPE,IND_CBX, CD_SURVEY_QUESTION_TYPE, TXT_QUES_HELP, CD_VERSION )
VALUES ('Q06',SYSDATE, 'Were all the screenings and prior history reviewed and significant findings doc umented?' ,06,'SFTIT1', 'S', 'N', 'YNA', 'Person Detail (per each person) record checks tab', 9999);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (580, 'SacwisRev3', 'Release 3.31 - DBCR 15544');

--commit;
