--STGAP00016140 - Release(4.3) CAPTA-4.3:Spcl Inv alter column to waiver table

--05/23/2011
ALTER TABLE CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST ADD IND_REMAIN_IN_HOME Varchar2(1) null ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.IND_REMAIN_IN_HOME is 'Indicates whether the child is subjected to the Home Waiver and will remain in the home' ;

-- BACKOUT
--ALTER TABLE CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST drop column IND_REMAIN_IN_HOME;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1016, 'SacwisRev4', 'Release 4.3 - DBCR 16140');

commit;

