-- Release 2.5 
--change STGAP00009235
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, '60442', 'MSG_CAP_NO_VIOLATION', 'At least one violation type must be selected', '760', '500', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, '60443', 'MSG_SUB_DOC_NOT_COMP', 'The document must be completed before submitting for approval', '760', '500', 'N');

--change STGAP00009229
Update caps.Message 
Set txt_message = 'Deleting this allegation will delete all selected determination factors in the corresponding Determination Factor section.'
Where txt_message_name = 'MSG_ALLEG_DEL_CNFRM'
And nbr_message = '60441';

insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate, '60444','MSG_INT_DETFAC_CMNTS_REQ', 'Comments are required when determination factors are selected.', '760','500','N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (337, 'SacwisRev2', 'static table updates, new index');                        
commit;
