--STGAP00013458 - New Message Needed for Payment of Care page

--Note:  no impact to ado model

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60527,'MSG_REL_SUB_LEG_STAT_REQ','Legal status must be updated to  Not in DFCS custody - Custody to relative or Custody to Guardinship to enter relative or subsudized guardianship subsides',700,500,'N');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (461, 'SacwisRev3', 'Release 3.1 - DBCR 13458');

commit;


