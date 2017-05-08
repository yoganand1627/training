--STGAP00018016 - Release(5.1) CPS Invs Cncls: New Comment field

-- DB Change Request for STGAP00017941 - Adding a new comment field with size 1000 characters
-- for Foster Parent Notified comments.


ALTER TABLE CAPS.CPS_INVST_DETAIL
ADD (
   TXT_FOST_PRNT_NOTIFY_CMNTS VARCHAR2(1000)
);

COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.TXT_FOST_PRNT_NOTIFY_CMNTS is 'Comments about not notifying the Foster Parent about Right to Attorney.';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1213, 'SacwisRev5', 'Release 5.1 - DBCR 18016');

commit;
