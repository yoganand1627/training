--STGAP00014888 - New external documentation table

-- Create HBM file for the same

CREATE TABLE CAPS.EXT_DOC_PERSON_LINK
(  ID_EXT_DOC_PERSON_LINK NUMBER(16,0) not null,
   DT_LAST_UPDATE DATE not null,
   ID_PERSON NUMBER(16,0) not null,
   ID_EXT_DOCUMENTATION NUMBER(16,0) not null,
CONSTRAINT PK_EXT_DOC_PERSON_LINK PRIMARY KEY (ID_EXT_DOC_PERSON_LINK) 
using index tablespace index01) tablespace data01;

create index caps.ind_EXT_DOC_PERSON_LINK_1 on caps.EXT_DOC_PERSON_LINK(id_person) tablespace index01;
create index caps.ind_EXT_DOC_PERSON_LINK_2 on caps.EXT_DOC_PERSON_LINK(ID_EXT_DOCUMENTATION) tablespace index01;

comment on table caps.EXT_DOC_PERSON_LINK is 'New table for the enhancements to the external documentation page.';
comment on column caps.EXT_DOC_PERSON_LINK.ID_EXT_DOC_PERSON_LINK is 'Primary Key';
comment on column caps.EXT_DOC_PERSON_LINK.DT_LAST_UPDATE is 'Date the record was updated last';
comment on column caps.EXT_DOC_PERSON_LINK.ID_PERSON is 'Identifies Persons on the case';
comment on column caps.EXT_DOC_PERSON_LINK.ID_EXT_DOCUMENTATION is 'Foreign key references table EXT_DOCUMENTATION';

grant select,update,insert,delete on caps.EXT_DOC_PERSON_LINK to capson,capsbat,ops$datafix;
grant select on caps.EXT_DOC_PERSON_LINK to operator;

CREATE SEQUENCE  CAPS.SEQ_EXT_DOC_PERSON_LINK  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_EXT_DOC_PERSON_LINK  to capsbat,capson,ops$datafix;

/ 
CREATE OR REPLACE TRIGGER CAPS.TUBR_EXT_DOC_PERSON_LINK 
BEFORE UPDATE
ON CAPS.EXT_DOC_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EXT_DOC_PERSON_LINK
BEFORE INSERT
ON CAPS.EXT_DOC_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_EXT_DOC_PERSON_LINK=0 then
    SELECT SEQ_EXT_DOC_PERSON_LINK.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_EXT_DOC_PERSON_LINK := dummy;
  end if;
END;
/



--STGAP00014891 - Additional columns to the EXT_DOC table

--New columns for the external documentation table

ALTER TABLE CAPS.EXT_DOCUMENTATION
ADD (CD_DOC_CLASS VARCHAR(3),
          DT_EXT_DOC_ADDED DATE);


--STGAP00014900 - Update Descrptn for Legal Action TPR Hearing Type

UPDATE CAPS.CODES_TABLES SET DECODE = 'TPR - Biological and Legal Father' where
CODE_TYPE = 'CLHECOT' AND CODE = 'TFL';

UPDATE CAPS.CODES_TABLES SET DECODE = 'TPR - Mother' where CODE_TYPE = 'CLHECOT'
 AND CODE = 'TFM';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Voluntary Surrender Biological and Legal
Father' where CODE_TYPE = 'CLEGCPS' AND CODE = 'VSF';

--STGAP00014902 - Correct Description for codes_tables

UPDATE CAPS.CODES_TABLES SET DECODE = 'Physical Evidence' where CODE_TYPE = 'CEX
DOTYP' AND CODE = 'PI';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Illness/Medication' where CODE_TYPE = 'CC
ARECAT' AND CODE = 'PI';



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (503, 'SacwisRev3', 'Release 3.2 - DBCRs 14888,14891,14900,14902');

commit;

