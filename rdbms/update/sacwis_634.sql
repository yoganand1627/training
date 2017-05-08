--STGAP00015634 - Release(Undetermined) Message for Portal

--Please see the attachment. Make sure that the message is not chopped into two lines.

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60636, 'MSG_PORTAL_VNDR_START_DT','Each Associated Vendor must have a Start Date.',500,700,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (635, 'SacwisRev3', 'Release Undetermined - DBCR 15634');

commit;


