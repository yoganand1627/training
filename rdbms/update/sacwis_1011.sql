--STGAP00016134 - Release(4.3) --Per SMS#108263 Add new error message

--Per SMS#108263 Add new error message

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60852,'MSG_AGE_18_REQD',
       'A person with Relationship of CASA, GAL Atty and GAL Non-Atty cannot be less than 18 yrs of age.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1012, 'SacwisRev4', 'Release 4.3 - DBCR 16134');

commit;

