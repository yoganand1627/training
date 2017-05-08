--STGAP00015614 - Release(3.4) DBCR:New messages for portal

--The attached SQL adds two new messages for Portal.

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60634,'MSG_PORTAL_PWD_EXPIRE','ATTENTION: Your password will expire within %f days.  Please navigate to the Staff Detail page to enter a new password.',
'700','500','N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60635,'MSG_CON_PORTAL_PC_REQ','You must select the child in care as a principal contacted for the purposeful visit',
'700','500','N');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (621, 'SacwisRev3', 'Release 3.4 - DBCR 15614');

commit;

