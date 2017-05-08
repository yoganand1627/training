--STGAP00009785 - Need to make change to MSG_RISK_FINDING_SUB

update caps.message m
set m.TXT_MESSAGE = 'A FCC stage has been opened from this stage. The selected Risk Finding is inappropriate. You must choose "Risk Indicated/Open For Placement" as the Risk Finding.'
where m.NBR_MESSAGE = 55035;


--STGAP00009797 - Need to create a new Message

insert into caps.message (id_message, dt_last_update, nbr_message, txt_message_name,txt_message, cd_source, cd_presentation, ind_batch)
values ('0', sysdate, '60470', 'MSG_CMN_UNIT_CHILD_NO_PARENT', 'The entered parent unit number is a child of the current unit.  Please enter a different parentunit.', '700', '500', 'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (370, 'SacwisRev2', 'Release 2.6 - DBCRs 9785,9797');

commit;


