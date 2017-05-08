--STGAP00017160 - Release(5.0) remove special characters from messages

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Effective date cannot be prior to or on the same day as the previous versions effective date.'
WHERE NBR_MESSAGE = 60882;

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'The effective date update you have made results in the effective date and end date to be the same date for the previous versions record. This is not allowed.'
WHERE NBR_MESSAGE = 60883;

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'Effective date must be more than two days after the previous versions effective date.'
WHERE NBR_MESSAGE = 60885;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1134, 'SacwisRev5', 'Release 5.0 - DBCR 17160');

commit;
