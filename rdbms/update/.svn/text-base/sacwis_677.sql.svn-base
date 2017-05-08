--STGAP00015690 - Release(3.5) MR-52 Add new messages


-- New Messages per Service Authorization and Referral Detail Detailed Design

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (99331,'MSG_SA_AMT_EXCEEDS_AAA',
       'Service Authorization amount exceeds approved amount of Special Services Adoption Assistance Application.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (99332,'MSG_SA_AMT_WILL_EXCEED_AAA','Adding this  Service Authorization for this amount will exceed the approved amount for the associated Adoption Assistance Application.', 700, 500, 'N');


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (99333,'MSG_SS_APRV', '%s Special Service  has been approved for %s',
    700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (99334,'MSG_NRE_AMT_WILL_EXCEED_NR_LIMIT','Adding this Non-Recurring Expense will exceed Non-Recurring spending limit %s', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (99335,'MSG_SP_SVC_SA_DATES','Special Services Service Authorization Begin and End dates must fall within the Approval period of the associated Special Services Adoption Assistance Application', 700, 500, 'N');


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (99336,'MSG_SVC_DESP_NOT_MATCH','The Service Description does not match the UAS/Entitlement Code on the Service Authorization and Referral Header page',700, 500, 'N');



-- New Messages per Service Authorization and Referral Header Detailed Design

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (99337,'MSG_APRV_ADOPT_PLCMT_REQD','An approved Adoptive Placement is required for this UAS/Entitlement Code.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (678, 'SacwisRev3', 'Release 3.5 - DBCR 15690');

commit;





