--STGAP00017158 - Release(5.0) Updating Task Code For SRT

--- Creating DBCR to update 3rd level tab for Safety Roundtable Event.


UPDATE caps.TASK set TXT_2ND_TAB = 'FAMILY_PLANS_EVENTLIST'
where CD_TASK = '8665';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1132, 'SacwisRev5', 'Release 5.0 - DBCR 17158');

commit;
