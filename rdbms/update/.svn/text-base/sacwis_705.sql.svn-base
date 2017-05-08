--STGAP00015731 - Release(3.5) Add new messages for Children 1st Referral

--Add new messages for Children 1st Referral

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60656,'MSG_CHF_REF_SENT',
       'Date Referral Sent must be entered prior to marking the referral complete.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60657,'MSG_CHF_PRN_ROI',
       'Please indicate whether or not the parental release of information was signed prior to marking the referral complete.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60658,'MSG_CHF_PHY_ASSMT',
       'A date has been entered for the receipt of the Physician''s Health Summary. Please indicate if the summary recommended further Developmental Assessment.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60659,'MSG_CHF_FUTURE_DATE',
       'No document received or sent date may be a future date.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (706, 'SacwisRev3', 'Release 3.5 - DBCR 15731');

commit;


