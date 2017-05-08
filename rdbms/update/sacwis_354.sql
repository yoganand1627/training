-- STGAP00009513
-- MR-011: Inserting new Code Type CNDETFAQ

DELETE CAPS.CODES_TABLES WHERE CODE_TYPE = 'CNDETFAQ';

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ10', 'What specific drugs are being used by the parent/caretaker?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ11', 'What is the frequency of use?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ12', 'Do the children have knowledge of the drug use?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ13', 'Is the baby in the hospital?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ14', 'What is the discharge date?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ15', 'Does the child know what or who to call in a crisis?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ16', 'Child left alone(for how long 1- 2 hrs, 2- 4 hrs, 4-6 hrs, 6-8 hrs)', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ17', 'Did the parent/caretakers say when they would return?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ18', 'How long has the parent/caretaker been gone?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ19', 'Are the alternate caretakers able to provide adequate care for the child?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ20', 'Has there been any recent contact with the parent/caretaker?', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNDETFAQ', 'NFQ21', 'What is the present physical condition of the child?', null, sysdate);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (355, 'SacwisRev2', 'Release 2.5 - DBCR 9513');
commit;

