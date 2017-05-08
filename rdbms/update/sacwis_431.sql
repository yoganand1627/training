--STGAP00012315 - Need new code for legal actions

--Note:   no impact to ado model


-- As per application defect - STGAP00012021 Need to end date 'COF' from CLEGLOUT and add it to code type CLEGCPS.


INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CLEGCPS', 'COF', 'Court Order Filed', NULL, SYSDATE);

UPDATE CAPS.CODES_TABLES
SET DT_END = SYSDATE
WHERE CODE_TYPE = 'CLEGLOUT'
AND CODE = 'COF';


--STGAP00012320 - New Message for Legal Actions page

--Note:  no impact to ado model

--As per application defect STGAP00012021 - Need a validation message on Legal Actions

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60517, 'MSG_TPR_REQ', 'Required to select Hearing Type Court Order of TPR when the Action is ''Court Order Filed''', 700, 500, 'N');


--STGAP00012350 - Per STGAP00012348- Add new row to Codes_Tables

--Note:  no impact to ado model

--Per STGAP00012348 we need to insert a new row into the codes_tables  so that Facility Type
--drop-down on the Add Resource/Resource Detail page displays the 'Non DFCS Relative Adoption' option.

INSERT INTO caps.codes_tables ct (ct.CODE_TYPE, ct.CODE, ct.DECODE )
VALUES ('CFACTYP4', 'NR', 'Non DFCS Relative Adoption');


--STGAP00012351 - DBCR - Per STGAP00012290  Insert new message

--Note:   no impact to ado model

--Per STGAP00012290::

--The user should be prevented from entering an ADO placement unless there is an approved AA application has been done.

Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60518,
   'MSG_PLACE_SAVE_ADO_APP_REQ',
   'An approved Adoption Assistance Application is required before saving an Adoptive Home Placement', 700, 500, 'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (432, 'SacwisRev3', 'Release 3.0 - DBCRs 12315,12320,12350,12351');

commit;


