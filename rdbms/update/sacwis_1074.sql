--STGAP00017026 - Release(4.3.2) Per STGAP000135790: Increase column widths

-- Per INCPS000013   Increase column width to resolve system error on save and submit of Intakes


 --Updating "Comments field for Worker Safety Issues under Special Handling section" on Intake Actions page to 4000 characters from 500
ALTER TABLE CAPS.INCOMING_DETAIL MODIFY (TXT_INCMG_WORKER_SAFETY VARCHAR(4000));

--Updating "Comments field for  Sensitive Case in Special Handling section" on Intake Actions page to 4000 characters from 300
ALTER TABLE CAPS.INCOMING_DETAIL MODIFY (TXT_INCMG_SENSITIVE VARCHAR(4000));


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1075, 'SacwisRev4', 'Release 4.3.2 - DBCR 17026');

commit;

