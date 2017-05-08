-- Change STGAP00006462
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60376, 'MSG_MAL_REL_REQUIRED', 'The Maltreator Relationship is required when selecting an Alleged Maltreator.', '500', '700', 'N');

-- Change STGAP00006464
UPDATE CAPS.MESSAGE
SET TXT_MESSAGE ='The Service is a Variable Unit Rate, please enter Unit Rate.'
WHERE TXT_MESSAGE_NAME = 'MSG_AMT_REQD'
AND TXT_MESSAGE ='The Service is a Variable Unit Rate, please enter Amount.';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (260, 'SacwisRev2', 'static table updates');  
commit;
