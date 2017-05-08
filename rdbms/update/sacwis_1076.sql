--STGAP00017047 - Release(5.0) MR-092 Update Task table for new AA Funding

-- MR-092 Update Task table for new AA Funding Summary event list

UPDATE caps.TASK
SET txt_2nd_tab = 'ADOPTION_ASSISTANCE_EVENTLIST'
WHERE cd_task IN ('8620', '9110');

UPDATE caps.TASK
SET IND_TASK_CODE_PREFER = '2'
WHERE cd_task IN ('9103', '9118');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1077, 'SacwisRev5', 'Release 5.0 - DBCR 17047');

commit;
