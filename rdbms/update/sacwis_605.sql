--STGAP00015593 - Release(3.4) Add STAGE_ID, CASE_MGR, SUPERVISOR to NCANDS table

--As per Patrick Coogan: "The NCANDS table does not have all of the required fields.  In addition to --PERSON_ID, we had discussed STAGE_ID, which is the decrypted RTPID, CASE_MANAGER, which is --the decrypted WRKRID, and SUPERVISOR, whichis the decrypted SUPRVID.  "

ALTER TABLE
    CAPS.NCANDS
ADD
   (
      STAGE_ID               VARCHAR2 (16),
      CASE_MANAGER   VARCHAR2 (16),
      SUPERVISOR          VARCHAR2 (16)
   );


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (606, 'SacwisRev3', 'Release 3.4 - DBCR 15593');

commit;

