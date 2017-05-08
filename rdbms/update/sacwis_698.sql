--STGAP00015714 - Release(3.5) Per CAPTA - insert new table

CREATE TABLE Caps.STAGE_REP_LINK
(ID_STAGE_REP_LINK NUMBER(16) NOT NULL,
ID_PERSON NUMBER(16) NOT NULL,
ID_STAGE NUMBER(16) NOT NULL,
DT_LAST_UPDATE DATE NOT NULL,
DT_REP_START DATE NULL,
DT_REP_END DATE NULL,
CONSTRAINT pk_STAGE_REP_LINK primary key(ID_STAGE_REP_LINK) using index tablespace index01,
constraint fk_STAGE_REP_LINK_PERSON foreign key (ID_PERSON) REFERENCES CAPS.PERSON_ENC (ID_PERSON) ENABLE,
constraint fk_STAGE_REP_LINK_STAGE foreign key (ID_STAGE) REFERENCES CAPS.STAGE(ID_STAGE) ENABLE) tablespace data01;

create index caps.IND_STAGE_REP_LINK_1 on Caps.STAGE_REP_LINK(id_person) tablespace index01;
create index caps.IND_STAGE_REP_LINK_2 on Caps.STAGE_REP_LINK(id_stage) tablespace index01;

grant select,update,insert,delete on caps.STAGE_REP_LINK to capson,capsbat,ops$datafix;
grant select on caps.STAGE_REP_LINK to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_STAGE_REP_LINK  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_STAGE_REP_LINK  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE_REP_LINK 
BEFORE UPDATE
ON CAPS.STAGE_REP_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_STAGE_REP_LINK
BEFORE INSERT
ON CAPS.STAGE_REP_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_STAGE_REP_LINK=0 then
    SELECT SEQ_STAGE_REP_LINK.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_STAGE_REP_LINK := dummy;
  end if;
END;
/


comment on column Caps.STAGE_REP_LINK.ID_STAGE_REP_LINK is 'Unique primary key';
comment on column Caps.STAGE_REP_LINK.DT_LAST_UPDATE is 'System date of the last row update';
comment on column Caps.STAGE_REP_LINK.ID_STAGE is 'ID stage of the child';
comment on column Caps.STAGE_REP_LINK.ID_PERSON is 'Id person of child';
comment on column Caps.STAGE_REP_LINK.DT_REP_START is 'Start Date of the legal representation';
comment on column Caps.STAGE_REP_LINK.DT_REP_END is 'End Date of the legal representation';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (699, 'SacwisRev3', 'Release 3.5 - DBCR 15714');

commit;

