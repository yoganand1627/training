--STGAP00016151 - Release(4.3) CAPTA-4.3:Spcl Inv Delete Column

--06/03/2011


ALTER TABLE CAPS.SPCL_INVESTIGATION DROP COLUMN IND_RCMND_CPA_CPI_NOT_USED  ;

comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_CPA_CCI_NOT_USED is 'Indicates whether CPA or CCI will not be used for DFCS children' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RECORD_CHK_VIEWED is 'Indicates whether Records Checks have been reviewed' ;

--BACKOUT
--ALTER TABLE CAPS.SPCL_INVESTIGATION add IND_RCMND_CPA_CPI_NOT_USED varchar2(1);

update caps.METAPHOR set TXT_FILTER_PATH = 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.SpclInvShowTab' where TXT_TAB_CONSTANT = 'SPECIAL_INVESTIGATION_SPCLINV';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1023, 'SacwisRev4', 'Release 4.3 - DBCR 16151');

commit;


