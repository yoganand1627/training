-- change STGAP00004921
-- Resolution for defect STGAP00004836
-- The reason closed code value for closing FPR(ONG) with Acceptable Risk Reduction is incorrect.
-- This will fix it and allow the case to be closed when approving ONG Closure.
UPDATE CAPS.STAGE_PROG SET CD_STAGE_PROG_RSN_CLOSE='APR' WHERE CD_STAGE_PROG_STAGE='FPR' AND CD_STAGE_PROG_RSN_CLOSE='ARR';

-- change STGAP00004930
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) 
VALUES (60362, 'MSG_SAVE_BEFORE_NAV', 'Page Detail needs to be saved before goals and/or plan participant list can be modified.', '600', '740', 'N');

-- change STGAP00004936
UPDATE CAPS.EQUIVALENCY SET NBR_EQUIV_OBJ_CERT = -0.25 WHERE NBR_EQUIV_OBJ_CERT = 0.25;
UPDATE CAPS.EQUIVALENCY SET NBR_EQUIV_OBJ_PURE = 0.25 WHERE NBR_EQUIV_OBJ_PURE = -0.25;

-- change STGAP00004939
insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate,60363, 'MSG_FCCP_FORM_REQ_SAVE_SUBMIT','Save the Family Foster Care Plan form before Saving and Submitting','700','500','N');

insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate,60364, 'MSG_FCCP_FORM_SAVE_REMINDER','Ensure you have saved the latest copy of the Family Foster Care Plan form','700','500','N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (236, 'SacwisRev2', 'static updates');                        
commit;
