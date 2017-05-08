--STGAP00015833 - Release(3.5) CAPTA_CDNF Create CHLD_DTH_CAUSE_CBX table

--CAPTA_CDNF Create CHLD_DTH_CAUSE_CBX table

create table CAPS.CHLD_DTH_CAUSE_CBX
(id_chld_dth_cause_cbx number(16) not null,
dt_last_update date not null,
cd_cause_death varchar2(7),
id_chld_death_event number(16) not null,
constraint pk_CHLD_DTH_CAUSE_CBX primary key(id_chld_dth_cause_cbx) ,
constraint fk_CHLD_DTH_EVENT foreign key(id_chld_death_event) 
references caps.chld_dth_nr_flty_seri_inj(id_event) ) tablespace data01;

create index caps.ind_CHLD_DTH_CAUSE_1 on CAPS.CHLD_DTH_CAUSE_CBX(id_chld_death_event) tablespace index01;

comment on table caps.CHLD_DTH_CAUSE_CBX is 'This table is used to record the Cause of death on CD/NF/SI report Page.';
comment on column caps.CHLD_DTH_CAUSE_CBX.id_chld_dth_cause_cbx is 'Primary Key';
comment on column caps.CHLD_DTH_CAUSE_CBX.dt_last_update is 'Used to record the last updated date';
comment on column caps.CHLD_DTH_CAUSE_CBX.id_chld_death_event is 'Records the event id of the cld_death_nr_flty_seri_inj record for which these causes of death have been recorded';

grant select,update,insert,delete on caps.CHLD_DTH_CAUSE_CBX to capson,capsbat,ops$datafix;
grant select on caps.CHLD_DTH_CAUSE_CBX to operator,shinesdm;


CREATE SEQUENCE  CAPS.SEQ_CHLD_DTH_CAUSE_CBX  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CHLD_DTH_CAUSE_CBX  to capsbat,capson,ops$datafix,shinesdm;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CHLD_DTH_CAUSE_CBX
BEFORE UPDATE
ON CAPS.CHLD_DTH_CAUSE_CBX
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CHLD_DTH_CAUSE_CBX
BEFORE INSERT
ON CAPS.CHLD_DTH_CAUSE_CBX
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_CHLD_DTH_CAUSE_CBX=0 then
    SELECT SEQ_CHLD_DTH_CAUSE_CBX.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_CHLD_DTH_CAUSE_CBX := dummy;
  end if;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (777, 'SacwisRev3', 'Release 3.5 - DBCR 15833');

commit;

