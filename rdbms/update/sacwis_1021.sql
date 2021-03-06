--STGAP00016147 - Release(4.3) CAPTA-4.3:Spcl Inv alter,add columns add  messages

--05/26/2011
ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_CONCUR_COMMENTS Varchar2(4000) ;
ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_RCMND_OTHER_COMMENTS Varchar2(4000) ;
ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_RESULTS_48HR_STAFFING Varchar2(4000) NULL ;
ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_NAMES_AGNCY_REP_STAFFING Varchar2(4000) NULL ;
ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_JUST_HME_REMAIN_OPEN Varchar2(4000) ;
ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_STEPS_ASSURE_SAFETY Varchar2(4000) ;

ALTER TABLE CAPS.SPCL_INVESTIGATION ADD IND_RCMND_CPA_CCI_NOT_USED Varchar2(1) null ;
ALTER TABLE CAPS.SPCL_INVESTIGATION ADD IND_RECORD_CHK_VIEWED Varchar2(1) null ;
ALTER TABLE CAPS.SPCL_INVESTIGATION ADD TXT_SYNOPSIS_REC_REVIEWED Varchar2(4000) null ;
ALTER TABLE CAPS.SPCL_INVESTIGATION ADD IND_RCMND_CPA_CPI_NOT_USED Varchar2(1) ; 
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_CPA_CCI_NOT_USED is 'Indicates whether CPA or CCI will not be used for DFCS children' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_CPA_CPI_NOT_USED is 'Indicates whether Records Checks have been reviewed' ;
comment on column CAPS.SPCL_INVESTIGATION.TXT_SYNOPSIS_REC_REVIEWED is 'Comments regarding the Synopsis of records reviewed and how it impacts allegations' ;


--BACKOUT

--ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_CONCUR_COMMENTS Varchar2(500);
--ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_RCMND_OTHER_COMMENTS Varchar2(500) ;
--ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_RESULTS_48HR_STAFFING Varchar2(300) NOT NULL ;
--ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_NAMES_AGNCY_REP_STAFFING Varchar2(300) NOT NULL ;
--ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_JUST_HME_REMAIN_OPEN Varchar2(500);
--ALTER TABLE CAPS.SPCL_INVESTIGATION MODIFY TXT_STEPS_ASSURE_SAFETY Varchar2(500);

--ALTER TABLE CAPS.SPCL_INVESTIGATION drop column IND_RCMND_CPA_CCI_NOT_USED;
--ALTER TABLE CAPS.SPCL_INVESTIGATION drop column IND_RECORD_CHK_VIEWED;
--ALTER TABLE CAPS.SPCL_INVESTIGATION drop column TXT_SYNOPSIS_REC_REVIEWED;
--ALTER TABLE CAPS.SPCL_INVESTIGATION drop column IND_RCMND_CPA_CPI_NOT_USED;

--END BACKOUT

DELETE FROM CAPS.MESSAGE WHERE TXT_MESSAGE_NAME = 'MSG_SO_NON_CONCURR_REQ';

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60861, SYSDATE, 'MSG_CR_RC_REVIEW_REQ', 'Please document that you have reviewed Records Checks.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60862, SYSDATE, 'MSG_CR_RC_REVIEW_SYNOP_REQ', 'Please provide a synopsis of your Records Checks review or comments regarding why no review was done.', 500, 700, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1022, 'SacwisRev4', 'Release 4.3 - DBCR 16147');

commit;
