-- STGAP00010048 - need to update message text

update caps.message m set m.TXT_MESSAGE = 'A FCC stage has been opened from this stage. The selected Risk Finding is inappropriate. You must choose Risk Indicated/Open For Placement as the Risk Finding.' where m.NBR_MESSAGE = 55035;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (375, 'SacwisRev2', 'Release 2.6 - DBCR 10048');

commit;


