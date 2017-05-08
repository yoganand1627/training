--STGAP00015729 - Release(3.5) MR-057 New Messages

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60651,'MSG_FCCP_REU_FOR_CON','Policy requires Reunification to be the primary permanency plan for a Concurrent Plan, unless the agency is ordered by the court to use Adoption, Guardianship, Live with Fit and Willing Relatives, APPLA Through Long Term Foster Care or APPLA Through Emanc
ipation [against the agency''s recommendation].',
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60652,'MSG_FCCP_NON_APPLA_FOR_CON','Concurrent planning policy does not allow for APPLA to be selected as a concurrent permanency plan, unless ordered  by the court [against the agency''s recommendation].',
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60653,'MSG_FCCP_PPP_SPP_DIFFERENT','The Permanency Plan and the Concurrent Permanency Plan can not be same.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (704, 'SacwisRev3', 'Release 3.5 - DBCR 15729');

commit;

