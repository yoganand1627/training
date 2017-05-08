--STGAP00016130 - Release(4.3) CAPTA-4.3:Add RC Summary tab to application

--Please use the below sql statement to update the metaphor table:

INSERT INTO CAPS.METAPHOR
(id_tab,
txt_tab_url,
txt_tab_constant,
txt_tab,
dt_last_update)
VALUES
(1075,
'/person/RecordsCheckSummary/displayRecordsCheckSummary',
'RECORDS_CHECK_SUMMARY',
'RC Summary',
SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1009, 'SacwisRev4', 'Release 4.3 - DBCR 16130');

commit;

