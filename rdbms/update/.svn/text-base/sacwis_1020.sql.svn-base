--STGAP00016146 - Release(4.3) Per SMS#108265 Add new error message

--Per SMS#108265 Add new error message

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60860,'MSG_REL_ASSMT_REQD',
       'Before an Enhanced Relative Rate payment of care can be submitted, there must be a Relative Care Assessment in APRV status with Assessment Results indicating that the home was approved.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1021, 'SacwisRev4', 'Release 4.3 - DBCR 16146');

commit;

