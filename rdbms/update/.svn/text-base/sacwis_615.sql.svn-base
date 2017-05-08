--STGAP00015604 - Release(3.4) DBCR: Correct whitespace in message

--The attached SQL updates an existing message to remove white space from the message which is causing a JavaScript error on the Portal Login page, preventing users from accessing the Registration page.

UPDATE CAPS.MESSAGE SET 
TXT_MESSAGE = 'The SHINES Portal is currently only to be used by approved RBWO providers at this time.  If you are not an approved provider do not register. Click OK to continue to register or Cancel to cancel your registration.'
WHERE TXT_MESSAGE_NAME = 'MSG_PORTAL_REG_APRV_PROV_CONFIRM';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (616, 'SacwisRev3', 'Release 3.4 - DBCR 15604');

commit;

