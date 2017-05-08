-- Release 2.5 
-- Standard Alter Table SQL
--change STGAP00009252 

ALTER TABLE CAPS.NON_COMPLIANCE RENAME COLUMN IND_CAP_CONCURRENCE TO IND_CPA_CONCURRENCE
;
ALTER TABLE CAPS.NON_COMPLIANCE RENAME COLUMN DT_CAP_CONCURRENCE TO DT_CPA_CONCURRENCE
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

--change STGAP00009246 
-- Updates to Codes Tables.
update caps.codes_tables set dt_end = sysdate where code_type = 'CEMLABSE' and code = 'ECPI';

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CEMLABSE', 'ECQB', 'Caretaker demonstrates emotional instability', null, sysdate);

-- New Messages
insert into caps.message 
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate, '60445','MSG_INT_ALLEGATIONS_REQ', 'Allegations are required if there is at least one principal on the Intake with a role of Alleged Maltreator and at least one principal on the Intake with a role of Alleged Victim.', '760','500','N');

insert into caps.message 
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate, '60446','MSG_INT_DETFAC_REQ', 'At least one associated determination factor is required for each type of allegation listed', '760','500','N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (340, 'SacwisRev2', 'static table updates, field names changed');                        
commit;
