--STGAP00015631 - Release(3.4) DBCR: Correct white space in message

--Attached SQL updates a message to correct whitespace causing a java script error.

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'The new password does not match standards: the password must be at least 8 characters, alphanumeric, include upper and lower case, include both numeric and alphabetical characters, and not start with the word ''password''.'
WHERE TXT_MESSAGE_NAME = 'MSG_PORTAL_PWD_STANDARDS';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (632, 'SacwisRev3', 'Release 3.4 - DBCR 15631');

commit;

