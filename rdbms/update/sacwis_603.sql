--STGAP00015589 - Release(3.4) For issue SMS37422 remove extra control characters

--For issue SMS37422 remove extra control characters that are causing in database that is causing false page constrain terror


update CAPS.EXCHANGE_CHILD exc1 set TXT_AVAIL_COMMENTS = (select replace(TXT_AVAIL_COMMENTS,chr(10),' ') from CAPS.EXCHANGE_CHILD where ID_EVENT = exc1.ID_EVENT) where LENGTH(exc1.TXT_AVAIL_COMMENTS) > 995;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (604, 'SacwisRev3', 'Release 3.4 - DBCR 15589');

commit;

