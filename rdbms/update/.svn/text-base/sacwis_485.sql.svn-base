--STGAP00014397 - Add columns to YOUTH_REPORT_DTL

ALTER TABLE CAPS.YOUTH_REPORT_DTL
ADD (
        TXT_ACAD_SUPPORT varchar2(500 char),
        TXT_PS_EDU_SUPPORT varchar2(500 char),
        TXT_CAREER_PREP varchar2(500 char),
        TXT_BDGT_FIN_MGT varchar2(500 char),
        TXT_HEALTH_EDU varchar2(500 char),
        TXT_MENTORING varchar2(500 char),
        TXT_RM_BRD_FIN varchar2(500 char),
        TXT_OTH_FINANCE varchar2(500 char),
        TXT_EMP_PROG_VOC varchar2(500 char),
        TXT_HOUSING_EDU varchar2(500 char),
        TXT_FAM_MARR_EDU varchar2(500 char),
        TXT_SUPER_IL varchar2(500 char),
        TXT_EDU_FINANCE varchar2(500 char),
        IND_FC_STATUS_SERVICES varchar2(1));

--STGAP00014418 - DBCR- MR-20 Safety Resource

alter table caps.safety_resource add (dt_request_recvd date);
alter table caps.safety_resource add (dt_home_visit date);

create table caps.sr_child_consider_plcmnt
(id_sr_child_considered number(16) not null,
id_sr_event number(16),
dt_last_update date,
id_person number(16), constraint pk_sr_child_consider_plcmnt primary key (id_sr_child_considered) using index tablespace index01)
tablespace data01;

grant select,update,insert,delete on caps.sr_child_consider_plcmnt to capson,capsbat,ops$datafix;
grant select on caps.sr_child_consider_plcmnt to operator;

create index caps.ind_sr_child_consider_plcmnt_1 on caps.sr_child_consider_plcmnt(id_sr_event) tablespace index01;
create index caps.ind_sr_child_consider_plcmnt_2 on caps.sr_child_consider_plcmnt(id_person) tablespace index01;

CREATE SEQUENCE  CAPS.SEQ_sr_child_consider_plcmnt  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_sr_child_consider_plcmnt  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_sr_child_consider_plcmnt 
BEFORE UPDATE
ON CAPS.sr_child_consider_plcmnt
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_sr_child_consider_plcmnt
BEFORE INSERT
ON CAPS.sr_child_consider_plcmnt
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.id_sr_child_considered=0 then
    SELECT SEQ_sr_child_consider_plcmnt.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.id_sr_child_considered := dummy;
  end if;
END;
/



--STGAP00014419 - MR-20 Add new message


update caps.message set txt_message_name = 'MSG_SRP_DELETE' where nbr_message = 60430;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (486, 'SacwisRev3', 'Release 3.2 - DBCRs 14397,14418,14419,14426');

commit;

