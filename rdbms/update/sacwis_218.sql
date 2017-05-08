update caps.caps_resource set NM_LEGAL=NM_RESOURCE
where NM_LEGAL is NULL 
OR length(NM_LEGAL) = 0;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (219, 'SacwisRev2', 'Set Legal Names for Resources where empty using Resource Name');

commit;
