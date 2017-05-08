--STGAP00017784 - Release(5.1) Per ClearQuest STGAP00017712 create new sequence

-- Per ClearQuest STGAP00017712 need to create SHINES_UCM_TX_SEQ sequence to pass this unique value as a TransactionID to UCM while uploading the file

CREATE SEQUENCE CAPS.SHINES_UCM_TX_SEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20;


-- Please grant appropriate privileges for using this sequence in SHINES

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1176, 'SacwisRev5', 'Release 5.1 - DBCR 17784');

commit;
