--STGAP00016157 - Release(4.3) Add Provider Allegation History tab

--Please use the below sql statement to update the Metaphor table:


INSERT INTO caps.METAPHOR
(id_tab,
txt_tab_url,
txt_tab_constant,
txt_tab,
dt_last_update)
VALUES
(395,
'/resource/ProviderAllgtnHistory/displayProviderAllgtnHistory',
'PROVIDER_ALLGTN_HISTORY',
'PROVIDER ALLEGATION HISTORY',
SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1027, 'SacwisRev4', 'Release 4.3 - DBCR 16157');

commit;

