--STGAP00010356 - Revisions to NON_INCIDENT_AFCARS_INFO

alter table caps.NON_INCIDENT_AFCARS_INFO add (CD_PRIMARY_NEED varchar2(2));


alter table caps.NON_INCIDENT_AFCARS_INFO drop column CD_CHILD_PLACED_BY;


alter table caps.NON_INCIDENT_AFCARS_INFO rename column IND_BF_ETHNICITY to CD_BF_ETHNICITY;
alter table caps.NON_INCIDENT_AFCARS_INFO modify (CD_BF_ETHNICITY varchar2(2));

alter table caps.NON_INCIDENT_AFCARS_INFO rename column IND_BM_ETHNICITY to CD_BM_ETHNICITY;
alter table caps.NON_INCIDENT_AFCARS_INFO modify (CD_BM_ETHNICITY varchar2(2));


-- STGAP00010378 - Corrections to ADO fields

alter table caps.foster_home_conv modify (cd_conv_app_status not null);
alter table caps.home_ethnicity modify (dt_last_update not null);
alter table caps.home_ethnicity modify (id_resource not null);
alter table caps.home_ethnicity modify (cd_ethnicity not null);
alter table caps.home_race modify (dt_last_update not null);
alter table caps.home_race modify (id_resource not null);
alter table caps.home_race modify (cd_race not null);
alter table caps.sibling_group modify (nbr_in_group not null);
alter table caps.sibling_group modify (nbr_avail not null);
alter table caps.sibling_group modify (id_case not null);


-- STGAP00010381 - New table to link a child to a foster home conversion

create table caps.FOSTER_HOME_CONV_PER_LINK
(ID_FOSTER_HOME_CONV_PER_LINK NUMBER(16) not null,
ID_FOSTER_HOME_CONV_EVENT NUMBER(16) not null,
ID_PERSON NUMBER(16) not null,
DT_LAST_UPDATE DATE not null,
constraint PK_FOSTER_HOME_CONV_PER_LINK PRIMARY KEY(ID_FOSTER_HOME_CONV_PER_LINK)) tablespace data01;

comment on table caps.FOSTER_HOME_CONV_PER_LINK is 'Table to link a child to a foster home conversion';

create index caps.FOSTER_HOME_CONV_PER_LINK_1 on caps.FOSTER_HOME_CONV_PER_LINK(ID_FOSTER_HOME_CONV_EVENT) tablespace index01;
create index caps.FOSTER_HOME_CONV_PER_LINK_2 on caps.FOSTER_HOME_CONV_PER_LINK(ID_PERSON) tablespace index01;

grant select,update,insert,delete on caps.FOSTER_HOME_CONV_PER_LINK to capson,capsbat,ops$datafix;
grant select on caps.FOSTER_HOME_CONV_PER_LINK to operator;

alter table caps.FOSTER_HOME_CONV_PER_LINK add constraint
FK_HOME_EVENT foreign key (ID_FOSTER_HOME_CONV_EVENT) references caps.FOSTER_HOME_CONV(ID_EVENT);

alter table caps.FOSTER_HOME_CONV_PER_LINK add constraint
FK_FSTR_HM_PERS foreign key (ID_PERSON) references caps.PERSON(ID_PERSON);

CREATE SEQUENCE  CAPS.SEQ_FOSTER_HOME_CONV_PER_LINK NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_FOSTER_HOME_CONV_PER_LINK to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_FOSTER_HOME_CONV_PER_LINK 
BEFORE UPDATE
ON CAPS.FOSTER_HOME_CONV_PER_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_FOSTER_HOME_CONV_PER_LINK
BEFORE INSERT
ON CAPS.FOSTER_HOME_CONV_PER_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_FOSTER_HOME_CONV_PER_LINK=0 then
    SELECT SEQ_FOSTER_HOME_CONV_PER_LINK.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_FOSTER_HOME_CONV_PER_LINK := dummy;
  end if;
END;
/


-- STGAP00010370 - DBCR to allow INT to PAD Stage Progression

update caps.stage_prog set cd_stage_prog_open='PAD'
where cd_stage_prog_stage='INT'
and cd_stage_prog_rsn_close='PA';


-- STGAP00010382 - The following messages need to be added

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60480, ' MSG_ADO_DT_WO_TERMINATION ', 'You have entered an adoptive placement date for a child is not in Permanent Custody of DFCS and/or that has not approved child life history.', 700, 500, 'N');
   
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60481, 'MSG_CHLD_NO_SUB_GROUP', 'At least one sibling is not part of a placement group for adoptive matching. Press OK to continue or Cancel to stay on the current page.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60482, 'MSG_UPDT_SIBLING_GRPS', 'You must specify how the siblings are to be placed before saving the page.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60483, 'MSG_MULTIPLE_PLCMT_GRPS', '%s : exists in more than one placement group.', 700, 500, 'N');


-- STGAP00006539 - Update an error message

UPDATE CAPS.message
SET txt_message = 'Person is not an alleged maltreator with allegations.'
WHERE nbr_message = 8216;


{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
{ call dbms_utility.compile_schema('ORS') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (390, 'SacwisRev3', 'Release 3.0 - DBCRs 10356,10370,10378,10381,10382,10387');
commit;
