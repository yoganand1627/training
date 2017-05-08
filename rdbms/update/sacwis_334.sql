-- Release 2.5 
-- Standard Alter Table SQL

ALTER TABLE CAPS.SVC_AUTH_VALID MODIFY(AMT_AUTH_VALID_AMT_REQ  NUMBER(10,2))
;
ALTER TABLE CAPS.SVC_AUTH_VALID MODIFY(AMT_AUTH_VALID_AMT_USED  NUMBER(10,2))
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

--change STGAP00009185
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CLHECOT', 'FDP', 'Final Disposition');

--change STGAP00009186
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CCLOSFCC', 'DJJ', 'DJJ Closure');

--change STGAP00009187
insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate, '60440','MSG_STG_CLOS_SUB_120','Child''s Legal Status must be either: Not In DFCS Custody - No Longer Committed to DJJ or DJJ Aftercare', '760','500','N');

--change STGAP00009191
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CMALCODE', 'E3', 'Domestic Violence', null, sysdate);

--change STGAP00009193
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CPERMEVT', 'RUI', 'REU');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CPERMEVT', 'LLR', 'LFWR');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CPERMEVT', 'ADA', 'ADO');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CPERMEVT', 'FCO', 'LTFC');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CPERMEVT', 'LAE', 'EMAN');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CPERMEVT', 'GDS', 'GDS');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CPERMEVT', 'NOS', 'NOS');

--change STGAP00009195
insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate, '60441','MSG_ALLEG_DEL_CNFRM','Deleting this allegation will delete all selected determiantion factors in the corresponding Determination Factor section.', '760','500','N');

--change STGAP00009199
update caps.message
set txt_message = 'You have selected a person already existing in SHINES.  Instead of adding a new person, use the selected person by clicking Relate to Case or search again.'
where txt_message_name = 'MSG_CMN_RELATE_NOT_ADD';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (335, 'SacwisRev2', 'static table updates');                        
commit;
