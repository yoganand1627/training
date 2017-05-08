--STGAP00016262 - Release(Undetermined) Per INCPS000013 Increase column width to resolve

-- Per INCPS000013   Increase column width to resolve system error on save and submit of Intakes


 --Updating "Comments regarding screen out or diversion" field to 4000 characters from 500
ALTER TABLE CAPS.STAGE MODIFY (TXT_STAGE_PRIORITY_CMNTS VARCHAR(4000));

--Updating "Special Instructions" comments field to 4000 characters from 300
ALTER TABLE CAPS.STAGE MODIFY (TXT_STAGE_SPL_INSTRT_CMNT VARCHAR(4000));

--Updating "Determination Comments" field to 4000 from 500
ALTER TABLE CAPS.INCMG_DETERM_FACTORS MODIFY (TXT_DET_FAC_CMNTS VARCHAR(4000));


--Updating "Worker Safety" comments field to 4000 from 300
ALTER TABLE CAPS.CAPS_CASE MODIFY (TXT_CASE_WORKER_SAFETY VARCHAR(4000));


--Updating "Sensitive Case" comments field to 4000 from 300
ALTER TABLE CAPS.CAPS_CASE MODIFY (TXT_CASE_SENSITIVE_CMNTS VARCHAR(4000));




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1056, 'SacwisRev4', 'Release 4.3.2 - DBCR 16262');

commit;


