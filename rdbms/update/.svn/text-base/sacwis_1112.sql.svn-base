--STGAP00017127 - Release(5.0) New table for Visitation Type
create table caps.VISITATION_TYPE
(ID_VISITATION_TYPE NUMBER(16),
DT_LAST_UPDATE DATE,
CD_VISITATION_TYPE varchar2(3),
ID_EVENT NUMBER(16),
CONSTRAINT PK_VISITATION_TYPE PRIMARY KEY (ID_VISITATION_TYPE) using index TABLESPACE DATA01 ENABLE);

comment on column caps.VISITATION_TYPE.ID_VISITATION_TYPE is 'Primary key of table';
comment on column caps.VISITATION_TYPE.DT_LAST_UPDATE is 'Date last updated';
comment on column caps.VISITATION_TYPE.ID_EVENT is 'to EVENT table';
comment on column caps.VISITATION_TYPE.CD_VISITATION_TYPE is 'Code for Visitation Type';

create index caps.IND_VISITATION_TYPE_1 on caps.VISITATION_TYPE(ID_EVENT) tablespace index01;

grant select,update,insert,delete on CAPS.VISITATION_TYPE to capson,capsbat,ops$datafix,shinesdm;
grant select on caps.VISITATION_TYPE to operator;

CREATE SEQUENCE  CAPS.SEQ_VISITATION_TYPE  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_VISITATION_TYPE  to capsbat,capson,ops$datafix;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_VISITATION_TYPE
BEFORE UPDATE
ON CAPS.VISITATION_TYPE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_VISITATION_TYPE
BEFORE INSERT
ON CAPS.VISITATION_TYPE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_VISITATION_TYPE=0 then
    SELECT CAPS.SEQ_VISITATION_TYPE.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_VISITATION_TYPE := dummy;
  end if;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1113, 'SacwisRev5', 'Release 5.0 - DBCR 17127');

commit;
