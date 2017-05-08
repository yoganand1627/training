
--STGAP00017772 - Release(5.1) Add new column to Service Authorization Detail

ALTER TABLE CAPS.SVC_AUTH_DETAIL
ADD (
   TXT_CMMTS_ADDITIONAL VARCHAR2(500)
 );

 comment on column CAPS.SVC_AUTH_DETAIL.TXT_CMMTS_ADDITIONAL  is 'Additional Comment field for Service Authorization Detail';

insert into caps.schema_version(id_schema_version,application_version,comments)
	    values (1174, 'SacwisRev5', 'Release 5.1 - DBCR 17772');

commit;
