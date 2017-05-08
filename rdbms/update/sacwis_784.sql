--STGAP00015848 - Release(3.43) MR-62: Add new table CS_SUMMARY_COMP_LOOKUP

-- This is a static table. Once loaded, it will rarely be modified

CREATE TABLE CAPS.CS_SUMMARY_COMP_LOOKUP
(
   ID_CS_SUMMARY_COMP_LOOKUP decimal(16) PRIMARY KEY,
   DT_LAST_UPDATE date NOT NULL,
   IND_FATHER_RULE_COMP VARCHAR2(1),
   IND_MOTHER_RULE_COMP VARCHAR2(1),
   IND_CTK_RULE_COMP VARCHAR2(1)
);

comment on table caps.CS_SUMMARY_COMP_LOOKUP is 'This table is used to define the the valid combinations of parent contact rules ';
comment on column caps.CS_SUMMARY_COMP_LOOKUP.ID_CS_SUMMARY_COMP_LOOKUP is 'Primary Key';
comment on column caps.CS_SUMMARY_COMP_LOOKUP.DT_LAST_UPDATE is 'Records the date that the record was last updated';
comment on column caps.CS_SUMMARY_COMP_LOOKUP.IND_FATHER_RULE_COMP is 'A Flag that is used to indicate that Father rule has been recorded. It is used with other flags to define completeness of contact rules for a child.';
comment on column caps.CS_SUMMARY_COMP_LOOKUP.IND_MOTHER_RULE_COMP is 'A Flag that is used to indicate that a Mother rule has been recorded. It is used with other flags to define completeness of contact rules for a child.';
comment on column caps.CS_SUMMARY_COMP_LOOKUP.IND_CTK_RULE_COMP is 'A Flag that is used to indicate that a Caretaker rule has been recorded. It is used with other flags to define completeness of contact rules for a child.';


CREATE SEQUENCE  CAPS.SEQ_CS_SUMMARY_COMP_LOOKUP  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_CS_SUMMARY_COMP_LOOKUP to capson,capsbat,ops$datafix;

grant select,update,insert,delete on caps.CS_SUMMARY_COMP_LOOKUP to capson,capsbat,ops$datafix;

grant select  on caps.CS_SUMMARY_COMP_LOOKUP to operator,shinesdm;


/ 
CREATE OR REPLACE TRIGGER CAPS.TIBR_CS_SUMMARY_COMP_LOOKUP
BEFORE INSERT
ON CAPS.CS_SUMMARY_COMP_LOOKUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:new.ID_CS_SUMMARY_COMP_LOOKUP = 0) OR (:NEW.ID_CS_SUMMARY_COMP_LOOKUP is null) THEN
    SELECT  SEQ_CS_SUMMARY_COMP_LOOKUP.NEXTVAL INTO  dummy FROM  DUAL;
    :new.ID_CS_SUMMARY_COMP_LOOKUP := dummy;
  END IF;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CS_SUMMARY_COMP_LOOKUP
BEFORE INSERT
ON CAPS.CS_SUMMARY_COMP_LOOKUP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


INSERT INTO CAPS.CS_SUMMARY_COMP_LOOKUP (IND_FATHER_RULE_COMP, IND_MOTHER_RULE_COMP, IND_CTK_RULE_COMP) VALUES ('Y', 'Y', 'Y');

INSERT INTO CAPS.CS_SUMMARY_COMP_LOOKUP (IND_FATHER_RULE_COMP, IND_MOTHER_RULE_COMP, IND_CTK_RULE_COMP) VALUES ('Y', 'Y', '');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (785, 'SacwisRev3', 'Release 3.43 - DBCR 15848');

commit;



