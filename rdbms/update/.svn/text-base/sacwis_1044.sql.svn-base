--STGAP00016184 - Release(4.3) Addind & modifying messages for CPS Inv Cnclsn

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60874, SYSDATE, 'MSG_PLCMNT_PROV_REQ', 'Please document the Placement/Non-Placement Provider when the investigation indicates Maltreatment in Care or a Policy Violation.',
 500, 700, 'N');

update caps.message
set txt_message = 'Please enter a value for both the Date Completed and the Date Determination Letter Sent.'
where txt_message_name = 'MSG_DT_DET_LETTER_REQ';

update caps.message
set txt_message = 'It is indicated that this is Maltreatment in Care or a Policy Violation on a Placement/Non-Placement provider.  A selection for Placement/Non-Placement Provider information section is required.'
where txt_message_name = 'MSG_INV_PLACEMENT_REQ';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1045, 'SacwisRev4', 'Release 4.3 - DBCR 16184');

commit;


