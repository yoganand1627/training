--STGAP00015388 - MR-55 Add Message to prevent Alleg Deletion


INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60583,'MSG_INV_NO_DEL_INT_ALLEG','Allegations created in the Intake Stage can not be deleted in the Investigation Stage',700,500,'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
            values (543, 'SacwisRev3', 'Release 3.21 - DBCR 15388');

commit;

