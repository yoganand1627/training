
--STGAP00014242 - Alter CASE_REVIEW Table for future reports

--Note:  no impact on ado model


alter table caps.case_review add ( ID_FIRST_ASSIGNED_TO NUMBER(16,0),SAMPLE_TYPE VARCHAR2(1) );


--STGAP00014230 - Per STGAP00014198 Insert a row in Message Table.

--Note:   no impact ado model


--Per STGAP00014198, Need to display an error message if the user enters  the re-determination date greater than 12 months from start date on the Eligibility Summary Page



INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60546,'MSG_FCE_REVIEW_DATE_AFTER_12','Re-determination date must be within 12 months after the start date.',700, 500, 'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (479, 'SacwisRev3', 'Release 3.1 - DBCRs 14230,14242');

commit;


