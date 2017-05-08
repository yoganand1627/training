-- STGAP00009553 - Add CODES_TABLES_INFO and CODES_TABLES_HISTORY

create table caps.codes_tables_info
(code_type varchar2(8) not null,
trans_type varchar2(1) not null,
code_type_desc varchar2(45)) tablespace data01;
grant select,insert,update,delete on caps.codes_tables_info to capson,capsbat,ops$datafix;

comment on table caps.codes_tables_info is 'CODES_TABLES_INFO contains one row for each code type in CODES_TABLES that is editable.' ;
comment on column caps.codes_tables_info.code_type is 'Code type in CODES_TABLES';
comment on column caps.codes_tables_info.trans_type is 'Type of edit ability allowed for the code type - full edit or limited edit.';
comment on column caps.codes_tables_info.code_type_desc is 'Brief description of the code type - what it is used for.' ;

create table caps.codes_tables_history
(id_codes_table_history number(16) not null,
code_type varchar2(8) not null,
trans_type varchar2(1),
code varchar2(20) not null,
decode varchar2(370),
id_employee number(16),
dt_end date,
dt_last_update date,
CONSTRAINT "PK_CODES_TABLES_HISTORY" PRIMARY KEY ("ID_CODES_TABLE_HISTORY"))
tablespace data01;
comment on table  caps.codes_tables_history is 'CODES_TABLES_HISTORY contains a transaction history of CODES_TABLES updates that are performed through these maintenance screens.';
comment on column caps.codes_tables_history.id_codes_table_history is 'Uniquely identifies each row in the table.';
comment on column caps.codes_tables_history.code_type is 'Code type in CODES_TABLES';
comment on column caps.codes_tables_history.trans_type is 'Type of edit ability allowed for the code type - full edit or limited edit.';
comment on column caps.codes_tables_history.id_employee is 'Id of the employee  who made the update.';

grant select,update,insert,delete on caps.codes_tables_history to capson,capsbat,ops$datafix;

CREATE SEQUENCE  CAPS.SEQ_CODES_TABLES_HISTORY  NOMINVALUE NOMAXVALUE INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
grant select on caps.seq_codes_tables_history to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CODES_TABLES_HISTORY 
BEFORE UPDATE
ON CAPS.CODES_TABLES_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/


/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CODES_TABLES_HISTORY
BEFORE INSERT
ON CAPS.CODES_TABLES_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_CODES_TABLE_HISTORY=0 then
    SELECT SEQ_CODES_TABLES_HISTORY.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_CODES_TABLE_HISTORY := dummy;
  end if;
END;
/


-- STGAP00009549 - Message for ADAM: previous adoption date
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60466, 'MSG_PRE_ADO_DATE_REQ', 'Please enter a adoption date for the previous adoption', 700, 500, 'N');


-- STGAP00009552 - Batch parameters for NCANDS
Insert all when not exists
(select 'x' from caps.batch_parameters where
NM_BATCH_PROGRAM='CINT23B' and
NM_BATCH_PARAMETER='CINT23-RPT-CURR-START-DT')
then
into caps.BATCH_PARAMETERS
select 
'CINT23B', 'CINT23-RPT-CURR-START-DT', TO_DATE('01/01/2006 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('12/31/4712 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/16/2008 11:55:30', 'MM/DD/YYYY HH24:MI:SS'), '10/01/2007' 
from dual;

Insert all when not exists
(select 'x' from caps.batch_parameters where
NM_BATCH_PROGRAM='CINT23B' and
NM_BATCH_PARAMETER='CINT23-RPT-NEXT-START-DT')
then
into caps.BATCH_PARAMETERS
select
'CINT23B', 'CINT23-RPT-NEXT-START-DT', TO_DATE('01/01/2006 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('12/31/4712 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('06/16/2008 11:55:24', 'MM/DD/YYYY HH24:MI:SS'), '10/01/2008'
from dual;


-- STGAP00009554 - Codes Tables Info - Insert data into static table

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('CSCHMDDL', 'F', 'List of Middle Schools in Georgia');

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('CSCHHIGH', 'F', 'List of High Schools in Georgia');

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('CSCHELEM', 'F', 'List of Elementary Schools in Georgia');

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('CSCHDSTR', 'F', 'List of School Districts in Georgia');

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('CRELIGNS', 'F', 'List of Religions');

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('CLANG', 'F', 'List of Languages');

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('COFCNM', 'L', 'List of Office locations');

INSERT INTO caps.CODES_TABLES_INFO (CODE_TYPE, TRANS_TYPE, CODE_TYPE_DESC)
VALUES('CEMPJBCL', 'L', 'List of Job Titles');

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CCTUPDT','F','Full Update', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CCTUPDT','L','Limited Update', sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (361, 'SacwisRev2', 'Release 2.6 - DBCRs 9549,9552,9553,9554');

commit;


