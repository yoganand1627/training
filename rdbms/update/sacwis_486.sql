--STGAP00014474 - RESOURCE_HISTORY: Correct name field to match size

--reduce size of resource name back to 30 on CAPS_RESOURCE. and  Legal Name to 45

UPDATE CAPS.CAPS_RESOURCE SET NM_RESOURCE = substr(NM_RESOURCE, 1, 30) WHERE LENGTH(NM_RESOURCE) > 30;
ALTER TABLE CAPS.CAPS_RESOURCE MODIFY NM_RESOURCE VARCHAR2(30);

UPDATE CAPS.CAPS_RESOURCE SET NM_LEGAL = substr(NM_LEGAL, 1, 45) WHERE LENGTH(NM_LEGAL) > 45;
ALTER TABLE CAPS.CAPS_RESOURCE MODIFY NM_LEGAL VARCHAR2(45);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (487, 'SacwisRev3', 'Release 3.11 - DBCR 14474');

commit;


