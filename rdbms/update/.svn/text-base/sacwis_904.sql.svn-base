--STGAP00016002 - Release(4.01) Update customized message to record check message

--Update case watch customized message to be record check specific message
UPDATE caps.CODES_TABLES
SET DECODE = 'There is one or more Principal or Member of Primary Caretaker''s Household upon whom a current Records Check has not been completed.'
WHERE CODE_TYPE = 'CCASEERR'
AND CODE = 'CUS';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (905, 'SacwisRev4', 'Release 4.01 - DBCR 16002');

commit;


