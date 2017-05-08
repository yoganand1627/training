--STGAP00015825 - Release(3.5) CAPTA DBCR for Admin Review Page

--Please see the attachment for the DBCR. Make sure the message didn't get chopped in to two different lines.

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60704,'MSG_ARI_DISPOSITION', 'Disposition is required to complete the review.', 700, 500, 'N');
       
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60705,'MSG_ARI_RSN_DISAGREEMENT',
       'Reason for disagreement is required when not agreeing with county disposition.', 700, 500, 'N');
       
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60706,'MSG_ARI_RSN_DISAG_AGREE',
       'Disposition entered is to agree with the County determination.  No reason for disagreement should be entered.', 700, 500, 'N');
       
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60707,'MSG_ARI_SECOND_REV_TYPE',
       'Review Type is required.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60708,'MSG_ARI_THIRD_INTEGRITY',
       'The 3rd level disposition regarding the 2nd level decision and the final decision for the case do not match.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60709,'MSG_ARI_OVERALL_INTEG_1',
       'The overall decision of the review is to not agree with the County determination and that allegations should be unsubstantiated.  Allegations and the Investigation Disposition must be updated to match to unsubstantiated prior to Save and Close. ', 700, 500, 'N');
       
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60710,'MSG_ARI_OVERALL_INTEG_2',
       'The overall decision of the review is to agree with the County determination and that allegations should remain substantiated.  Allegations should be updated so that the overall Investigation Disposition is updated to Substantiated prior to Save and Close.', 700, 500, 'N');
       
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60711,'MSG_ARI_FIRST_LEVEL_REQ',
       'Please select a 1st Level ARI stage or indicate that No 1st Level ARI Stage is appropriate.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60712,'MSG_ARI_FIRST_LEVEL_REQ_2',
       'A first level ARI stage has been indicated.  Please de-select the No 1st Level ARI Stage checkbox.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60713,'MSG_ARI_REVIEW_TYPE_CHANGE',
       'Warning: changing this value will cause all data currently entered on this review to be deleted.  Click OK to Continue or Cancel to stay on this page.', 700, 500, 'N');
       
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60714,'MSG_ARI_SEC_LEVEL_COMPLETE',
       'Once the 2nd level review is saved complete, all data for the 2nd level review, including data on the 2nd Level Decision Form, will become non-modifiable.  Click OK to Continue or Cancel to stay on this page without saving.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60715,'MSG_ARI_FORMS_UPDATE',
       'All form data will become view only on Save and Close.  If necessary launch the forms to update the most recent decision and enter any remaining contact information.  Click OK to Continue or Cancel to stay on this page without Saving.', 700, 500, 'N');

--Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CARVTYPE','030','Child Death/Near Fatality/Serious Injury Review',null,sysdate);
update caps.codes_tables set decode='Child Death/Near Fatality/Serious Injury Review' where code_type='CARVTYPE' and code='030';
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CARVSTAT','060','Closed',null,sysdate);

Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('COVERTUR','FAI','Failure to adequately investigate',null,sysdate);
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('COVERTUR','MIP','Misapplication of policy',null,sysdate);
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('COVERTUR','PDM','Poor decision making',null,sysdate);
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('COVERTUR','XXX','Other',null,sysdate);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (771, 'SacwisRev3', 'Release 3.5 - DBCR 15825');

commit;



