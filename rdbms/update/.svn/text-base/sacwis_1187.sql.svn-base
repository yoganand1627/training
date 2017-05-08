--STGAP00017852 - Release(5.1) DB Change Request for CQ# STGAP00017831

-- DB Change Request for MR -102 Service Authorization - Increasing the size of the comment fields to
-- 1000 characters.

ALTER TABLE CAPS.SVC_AUTH_DETAIL
MODIFY (
   TXT_CMMTS VARCHAR2(1000),
   TXT_CMMTS_ADDITIONAL VARCHAR2(1000)
 );

ALTER TABLE CAPS.SERVICE_AUTHORIZATION
MODIFY (
   TXT_SVC_AUTH_COMMENTS VARCHAR2(1000)
 );

ALTER TABLE CAPS.SERVICE_AUTH_AUDIT
MODIFY (
   TXT_SVC_AUTH_AUD_COMMENTS VARCHAR2(1000)
 );

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1188, 'SacwisRev5', 'Release 5.1 - DBCR 17852');

commit;
