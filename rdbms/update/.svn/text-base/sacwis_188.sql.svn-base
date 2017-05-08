-- Standard Alter Table SQL
ALTER TABLE CAPS.RESOURCE_CHRCTR MODIFY(ID_RESOURCE_SERVICE   NULL)
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003277
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60346, 'MSG_MERGE_OPN_CLD_NOT_ALLOWED', 'Case-To is closed but Case-From is still open. Can not merge an open case to a closed case.', 500, 700, 'N');

-- change STGAP00003287
insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate,'60347','MSG_RSRC_SUB_ALREADY_EXISTS','This resource is already a subcontractor to resource id %ld','700','500','N');

-- change STGAP00003290
delete from caps.metaphor where id_tab = 200;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (189, 'SacwisRev2', 'static updates, make a ID_RESOURCE_SERVICE in RESOURCE_CHRCTR');

commit;
