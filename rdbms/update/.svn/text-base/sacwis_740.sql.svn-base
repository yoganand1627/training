--STGAP00015785 - Release(Undetermined) CAPTA Allegation Detail Codes Tables Insert/Update

-- Adding two columns to the Allegation table
alter table CAPS.ALLEGATION add(DT_PRIOR_NEAR_FATAL_MALTRTMNT DATE);

alter table CAPS.ALLEGATION add(IND_CHILD_DEATH_SEVERITY VARCHAR2(1));

COMMENT ON COLUMN CAPS.ALLEGATION.DT_PRIOR_NEAR_FATAL_MALTRTMNT IS 'Date of prior near fatality maltreatment.';

COMMENT ON COLUMN CAPS.ALLEGATION.IND_CHILD_DEATH_SEVERITY IS 'Indicator whether the serverity is child death.';


Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) 
values ('CSEVERTY','NF','Near Fatality as Certified by a Physician',null,sysdate);

Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) 
values ('CSEVERTY','XX','Not Child Death, Near Fatality, or Serious Injury',null,sysdate);

Update CAPS.CODES_TABLES Set DECODE = 'Serious Injury' Where CODE_TYPE = 'CSEVERTY' and CODE = 'SR';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (741, 'SacwisRev3', 'Release Undetermined - DBCR 15785');

commit;





