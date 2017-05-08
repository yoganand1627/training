--STGAP00015735 - Release(3.5) MR-057 Update Messages

update CAPS.message set TXT_MESSAGE = 'Policy requires Reunification to be the primary permanency plan for a Concurrent Plan, unless the agency is ordered by the court to use Adoption, Guardianship, Live with Fit and Willing Relatives, APPLA Through Long Term Foster Care or APPLA Through Emancipation [against the agency\''s recommendation].'
where TXT_MESSAGE_NAME = 'MSG_FCCP_REU_FOR_CON';

update CAPS.message set TXT_MESSAGE = 'Concurrent planning policy does not allow for APPLA to be selected as a concurrent permanency plan, unless ordered  by the court [against the agency\''s recommendation].'
where TXT_MESSAGE_NAME = 'MSG_FCCP_NON_APPLA_FOR_CON';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (709, 'SacwisRev3', 'Release 3.5 - DBCR 15735');

commit;


