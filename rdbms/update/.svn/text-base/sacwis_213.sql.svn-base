-- change STGAP00004149
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60356, 'MSG_CCL_PC_REQUIRED', 'This stage requires a Primary Child.', '560', '740', 'N');

-- change STGAP00004167
UPDATE CAPS.METAPHOR SET TXT_TAB_URL = '/multipart/ExternalDcmnttn/displayExtDocList' WHERE ID_TAB = 470;

-- change STGAP00004203
update caps.message set txt_message='The Home Evaluation document must be entered before the home is submitted for approval' where nbr_message=8100;

-- change STGAP00004210
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)   
VALUES (8119, 'MSG_FAD_HOME_APPRV_DTS_REQ' 
,'The Approval Begin and End dates must be entered before the home is submitted for approval',500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (214, 'SacwisRev2', 'static updates');                        
commit;
