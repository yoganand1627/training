--STGAP00015711 - Release(3.5) Per SMS #43769: Update "MSG_AGMT_NON_RECURR_EXIST"

--Per SMS #43769 we need to change the txt_message for the following nbr_message--

UPDATE caps.message m
SET m.TXT_MESSAGE = '%s Adoption Assistance for %s currently exists.'
WHERE m.NBR_MESSAGE = 60533;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (687, 'SacwisRev3', 'Release 3.5 - DBCR 15711');

commit;


