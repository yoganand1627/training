--STGAP00010162 - Exchange Child Detail - Update metaphor table   (3.0)


UPDATE CAPS.METAPHOR SET TXT_TAB_CONSTANT = 'EXCHANGE_CHILD_EVENTLIST' WHERE ID_TAB = '1620';


--STGAP00010171 - Exchange Home Detail - modify task code    (3.0)


update caps.task set CD_TASK_EVENT_STATUS = null, IND_TASK_NEW_USING = 0 where CD_TASK = '8085';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (382, 'SacwisRev3', 'Release 3.0 - DBCRs 10162,10171');

commit;


