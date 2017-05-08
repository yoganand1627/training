--STGAP00015555 - Release(3.32) Need to update the ADO_SUBSIDY_RATE table

--Need to update the ADO_SUBSIDY_RATE table to populate CD_PRE_POST_RATETYPE with appropriate values:

UPDATE caps.ADO_SUBSIDY_RATE
SET CD_PRE_POST_RATETYPE = 'PRE'
WHERE ID_ADO_SUBSIDY_RATE IN (1,2,3);

UPDATE caps.ADO_SUBSIDY_RATE
SET CD_PRE_POST_RATETYPE = 'POS'
WHERE ID_ADO_SUBSIDY_RATE IN (4,5,6);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (584, 'SacwisRev3', 'Release 3.32 - DBCR 15555');

commit;
