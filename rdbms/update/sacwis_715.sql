--STGAP00015744 - Release(3.5) Add New Message and New Col to Children_First_Referral Page

-- New message for Children 1st Referral Page.
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60665,'MSG_CANNOT_SEL_NO',
       'Cannot select No to Release on File, if the Release of Information was originally signed by Parents', 700, 500, 'N');


ALTER TABLE caps.children_first_referral
ADD (Release_on_file VARCHAR2(1));

COMMENT ON COLUMN CAPS.children_first_referral.Release_on_file IS
'Indicate Release on file is Yes (Y), No (N) or Rescinded (R)';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (716, 'SacwisRev3', 'Release 3.5 - DBCR 15744');

commit;

