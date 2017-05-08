--STGAP00011706 - Update Message

--Note:  no impact to ado model

update caps.message m
set m.TXT_MESSAGE = 'Unit and Reg/Div must be blank for Non-DFCS Storage Locations'
where m.ID_MESSAGE = 17055;


--STGAP00011716 - Per STGAP00010409 : Update a message

--Note:  no impact to ado model

--Per STGAP00010409 we need to change the txt_message for the following nbr_message--

UPDATE caps.message m
SET m.TXT_MESSAGE = 'Please select a Program area before Launching this report.'
WHERE m.NBR_MESSAGE = 25558;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (417, 'SacwisRev3', 'Release 3.1 - DBCRs 11706,11716');

commit;


