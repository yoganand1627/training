--STGAP00017096 - Release(5.0) Creating DBCR's for Safety Roundtable Form

create table caps.SAFETY_ROUNDTABLE_NARR
(ID_EVENT NUMBER(16) not null,
dt_last_update date not null,
ID_CASE NUMBER(16),
NARRATIVE LONG RAW,
ID_DOCUMENT_TEMPLATE NUMBER(16),
CONSTRAINT PK_SAFETY_ROUNDTABLE_NARR PRIMARY KEY (ID_EVENT) using index tablespace index01,
CONSTRAINT FK_SAFETY_ROUNDTABLE_NARR_CASE FOREIGN KEY (ID_CASE)
   REFERENCES CAPS.CAPS_CASE(ID_CASE) ENABLE) tablespace data01 ;

grant select,update,insert,delete on caps.SAFETY_ROUNDTABLE_NARR to capson,capsbat,ops$datafix;

grant select on caps.SAFETY_ROUNDTABLE_NARR to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SAFETY_ROUNDTABLE_NARR
BEFORE UPDATE
ON CAPS.SAFETY_ROUNDTABLE_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SAFETY_ROUNDTABLE_NARR
BEFORE INSERT
ON CAPS.SAFETY_ROUNDTABLE_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

COMMENT ON TABLE CAPS.SAFETY_ROUNDTABLE_NARR IS
'Contains the narrative blob for the Safety Roundtable Narrative.' ;

COMMENT ON COLUMN CAPS.SAFETY_ROUNDTABLE_NARR.DT_LAST_UPDATE IS
'Date of insert or last update' ;

--Creating DBCR's needed for Safety Roundtable Form and Event.

INSERT INTO CAPS.TASK ( CD_TASK, CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE,
CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW,
IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE,
TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER,
IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK,
IND_STAGE_CLOSURE ) VALUES (
'8665', 'COMP', 'SRT'
, 'CCMN51W', NULL, 'FPR', 'CPS', 'CCMN65W', NULL, '1', '1', NULL, '1', NULL, '1', '0'
, '0', '1', NULL, 'Safety Roundtable', 'CASE_CASESEARCH', 'CHILD_PLANS_EVENTLIST'
, 'SAFETY_ROUNDTABLE_EVENTLIST', '/admin/OutputLaunch/displayInitOutputLaunch', 3, '0', '0'
, '0');

--select * from metaphor order by DT_LAST_UPDATE desc

INSERT INTO caps.METAPHOR
(id_tab, txt_tab_url, txt_tab_constant, txt_tab,  dt_last_update )
VALUES
(1775, '/workload/EventSearch/displayEventList' ,       'SAFETY_ROUNDTABLE_EVENTLIST' ,
'Safety Roundtable' ,    sysdate);

--select * from codes_Tables where code = 'SRT'

insert into caps.codes_tables (code_type, code, decode )
values('CEVNTDOC' , 'SRT' , 'SAFETYROUNDTABLE');

insert into caps.codes_tables (code_type, code, decode)
values ( 'CEVNTTBL', 'SRT', 'SAFETY_ROUNDTABLE_NARR');


insert into caps.codes_tables (code_type, code, decode)
values ( 'CEVNTTYP', 'SRT', 'Safety Roundtable');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1102, 'SacwisRev5', 'Release 5.0 - DBCR 17096');

commit;
