-- change STGAP00006700
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='When the selected UAS Code is PUP, Early Intervention, Prevention Services, Homestead Services or Parent Aide Services the Outcome Type is required' WHERE NBR_MESSAGE='60193';

-- change STGAP00006716

update caps.risk_factors_lookup
set txt_factor = 'CV.FP1 - Is any child four years old or younger or otherwise unable to protect him/herself?'
where cd_factor = 'R01';

-- change STGAP00006717

insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0, sysdate, 60378, 'MSG_FCE_END_DATE_REASON','Please select a reason for ending the eligibility','700','500','N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (266, 'SacwisRev2', 'static table updates');                        
commit;
