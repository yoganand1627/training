--STGAP00016187 - Release(4.3) CAPTA-4.3:Add column to SPCL_INVESTIGATION

--06/21/2011
ALTER TABLE CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST ADD CD_CHILD_CONCUR_PLAN Varchar2(3) null ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.CD_CHILD_CONCUR_PLAN is 'records the child''s concurrency plan code' ;

--BACKOUT
--ALTER TABLE CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST DROP COLUMN CD_CHILD_CONCUR_PLAN;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1047, 'SacwisRev4', 'Release 4.3 - DBCR 16187');

commit;


