--STGAP00016102 - Release(4.2) MR-074-2 AFCARS: Legal Status & AA Application msg

-- SMS#97845 - MR-074-2 AFCARS: Legal Status and AA Application page


INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60819,'MSG_ADO_INC_NONINC_STATUS',
'Please indicate the Incident/Non-Incident Status for the child.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60820,'MSG_LEG_STAT_ADO_APP_PEND_ERR',
'All Adoption Assistance Applications, which have been submitted for approval, must be in APRV status in order to finalize the adoption.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60821,'MSG_LEG_STAT_ADO_APP_AGMT_COMP_ERR',
'There must be an active Adoption Assistance Agreement (not Special Services or Non-Recurring) in COMP status linked to a monthly (Basic or Specialized Rate) Adoption Assistance Application in APRV status.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60822,'MSG_LEG_STAT_ADO_APP_AGMT_COMP_ERR_NI',
'There is an active Adoption Assistance Agreement in COMP status, but it should be linked to a monthly (Basic or Specialized Rate) Adoption Assistance Application in APRV status.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60823,'MSG_LEG_STAT_ADO_APP_APRV_ERR_NI',
'There is a monthly (Basic or Specialized Rate) Adoption Assistance Application in APRV status, but there is no Adoption Assistance Agreement in COMP status linked to it.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60824,'MSG_LEG_STAT_ADO_APP_APRV_ERR',
'There must be an Adoption Assistance Application in APRV status, which has an approved or deferred Special Needs Determination, in order to finalize the adoption.', 
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60825,'MSG_LEG_STAT_ADO_APP_AGMT_ERR_NI',
'There must be an Adoption Assistance Application in APRV status, which has an approved, denied or deferred Special Needs Determination, in order to finalize the adoption.', 
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (986, 'SacwisRev4', 'Release 4.2 - DBCR 16102');

commit;


