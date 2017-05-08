--STGAP00015627 - Release(3.4) process_mode in batch_parameters table for NCANDS



--NCANDS batch script needs the ability to run for specified dates like other batch programs. 
--An entry into the batch_parameters table with a process_mode (of 1 or 2) will allow such processing. 
--1 would indicate monthly cumulative build up for the whole federal fiscal year and a 2 would indicate 
--specified start and end dates.

insert into caps.batch_parameters
values ('CINT23B',
             'REPORT-PROCESS-MODE',
             '01/01/2009',
             '12/31/2012',
             '11/16/2009',
             2);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (629, 'SacwisRev3', 'Release 3.4 - DBCR 15627');

commit;

