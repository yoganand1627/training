--STGAP00015913 - Release(3.6) --Per SMS#54782 Add new error message

--Per SMS#54782 Add new error message

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60751,'MSG_CNS_REQD_IF_DOD',
       'One or more children associated to the Intake Report have a Date of Death entered on their Person Detail page but there is not an associated Child Death report. Please generate the Child Death report and approve before stage closure.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (836, 'SacwisRev3', 'Release 3.6 - DBCR 15913');

commit;

