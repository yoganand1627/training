--STGAP00017149 - Release(5.0) ECEM 5.0: constraint msg and misc updates

ALTER TABLE CAPS.UAS_PROGRAM_CODE_MTNT  MODIFY (CD_UAS VARCHAR2(3 BYTE));
ALTER TABLE CAPS.UAS_PROGRAM_CODE_MTNT  MODIFY (CD_PROGRAM_TYPE VARCHAR2(3 BYTE));

ALTER TABLE CAPS.UAS_ENT_CODE_MTNT  MODIFY (CD_ENT_CODE VARCHAR2(2 BYTE));
ALTER TABLE CAPS.UAS_ENT_CODE_MTNT ADD (CD_SVC_CODE VARCHAR2(7 BYTE));
ALTER TABLE CAPS.UAS_ENT_CODE_MTNT ADD (ID_EQUIV NUMBER(16));
alter table  caps.uas_ent_code_mtnt add constraint FK_UAS_ENT_ID_EQUIV foreign key (ID_EQUIV) references caps.equivalency(ID_EQUIV);

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60938,'MSG_ARC_CONSTR_DATE2',
'Please enter a date in the format MM/DD/YYYY or MMDDYYYY.',
700,500,'N');

update CAPS.METAPHOR
set TXT_TAB_URL = '/financials/UASProgramCodeMaintenance/addUASProgramCode'
where id_tab=1545;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1128, 'SacwisRev5', 'Release 5.0 - DBCR 17149');

commit;
