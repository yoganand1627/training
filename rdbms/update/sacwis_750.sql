--STGAP00015795 - Release(3.5) CAPTA Message update spelling mistake

--As the message length is big and we don't want the message to get chopped into two lines, I have attached the update statement under attachment section.

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'No has been entered for prior Near Fatality, but one or more prior investigations have included a maltreatment with a severity of Near Fatality for the alleged victim.  Please confirm case history prior to Investigation Conclusion.' 
WHERE txt_message_name = 'MSG_INV_PRIOR_NEAR_FATALITY';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (751, 'SacwisRev3', 'Release 3.5 - DBCR 15795');


commit;
 
