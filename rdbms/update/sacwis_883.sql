--STGAP00015978 - Release(4.0) MR-067: NYTD Survey Add New MESSAGE

--STGAP00015978
--MR-067: NYTD Survey Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60770,'MSG_PORTAL_OTHER_SITE',
'Please enter your User Name of Other Site.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60771,'MSG_PORTAL_CONTACT_BY_TEXT',
'Can DFCS contact you by text? needs to be answered if Cell is selected as the phone type.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (884, 'SacwisRev4', 'Release 4.0 - DBCR 15978');

commit;


