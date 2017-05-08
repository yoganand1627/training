--STGAP00015831 - Release(3.5) CAPTA_CDNFSI Add table CHLD_DTH_NR_FLTY_SERI_INJ

-- Add new table to hold CD/NF/SI Page values

create table CAPS.CHLD_DTH_NR_FLTY_SERI_INJ
(id_event number(16) not null,
dt_last_update date not null,
id_child number(16) not null,
id_case number(16) not null,
comments_cause_death varchar2(500),
county_of_death varchar2(3),
autopsy_completed varchar2(1),
comments_autopsy varchar2(500),
death_preventable varchar2(1),
comments_death_preventable varchar2(500),
report_submitted_within_24hrs varchar2(1),
comments_report_submitted varchar2(500),
constraint pk_CHLD_DTH_NR_FLTY_SERI_INJ primary key(id_event) ) tablespace data01;

create index caps.ind_CHLD_DTH_NR_1 on CAPS.CHLD_DTH_NR_FLTY_SERI_INJ(id_child) tablespace index01;
create index caps.ind_CHLD_DTH_NR_2 on CAPS.CHLD_DTH_NR_FLTY_SERI_INJ(id_case) tablespace index01;

grant select,update,insert,delete on caps.CHLD_DTH_NR_FLTY_SERI_INJ to capson,capsbat,ops$datafix;

grant select  on caps.CHLD_DTH_NR_FLTY_SERI_INJ to operator,shinesdm;


/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_CHLD_DTH_NR_FLTY_SERI_INJ 
BEFORE UPDATE
ON CAPS.CHLD_DTH_NR_FLTY_SERI_INJ
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CHLD_DTH_NR_FLTY_SERI_INJ
BEFORE INSERT
ON CAPS.CHLD_DTH_NR_FLTY_SERI_INJ
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/



comment on table caps.CHLD_DTH_NR_FLTY_SERI_INJ is 'This table is used to record the data entered on CD/NF/SI report Page.';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.id_event is 'Primary Key';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.dt_last_update is 'Used to record the last updated date';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.id_child is 'Used to record the idChild for whom the report is created';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.id_case is 'Used to record the case id';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.COMMENTS_CAUSE_DEATH is 'Comments recorded for cause of death';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.COUNTY_OF_DEATH is 'County code entering on the report';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.AUTOPSY_COMPLETED is 'Used to record if the Autopsy was completed';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.COMMENTS_AUTOPSY is 'Comments recorded for Autopsy completed';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.DEATH_PREVENTABLE is 'Used to record if death was preventable';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.COMMENTS_DEATH_PREVENTABLE is 'Comments recorded for death preventable';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.REPORT_SUBMITTED_WITHIN_24HRS is 'Used to record if the report was submitted within 24hrs';
comment on column caps.CHLD_DTH_NR_FLTY_SERI_INJ.COMMENTS_REPORT_SUBMITTED is 'Comments recorded for submitted within 24hrs';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (776, 'SacwisRev3', 'Release 3.5 - DBCR 15831');

commit;


