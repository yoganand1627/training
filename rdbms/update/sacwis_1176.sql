--STGAP00017788 - Release(N/A) Creating new sequence for Imaging

-- Droping the sequence SHINES_UCM_TX_SEQ created in STGAP00017784 and creating new one following naming convention

DROP SEQUENCE caps.SHINES_UCM_TX_SEQ;

-- Per ClearQuest STGAP00017712 need to create SEQ_SHINES_UCM_TX sequence to pass this unique value as a TransactionID to UCM while uploading the file

CREATE SEQUENCE CAPS.SEQ_SHINES_UCM_TX
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20;

grant select on CAPS.SEQ_SHINES_UCM_TX to capsbat,capson,ops$datafix,shinesdm;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1177, 'SacwisRev5', 'Release N/A - DBCR 17788');

commit;
