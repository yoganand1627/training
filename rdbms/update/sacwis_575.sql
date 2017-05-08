--STGAP00015540 - MR-058 Case Review Messages

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60601,'MSG_CSR_NOT_BEFORE_DT_REVIEW','The date entered cannot be before the Date of Review.',700,500,'N');

update caps.message
set txt_message = 'Once the Case Review is marked Complete no further changes can be made.  Confirm by pressing OK.  If further changes are required, press Cancel and uncheck the Review Complete check box.' where txt_message_name = 'MSG_CSR_CFRM_COMP';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (576, 'SacwisRev3', 'Release 3.32 - DBCR 15540');

commit;

