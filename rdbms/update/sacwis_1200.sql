--STGAP00017881 - Release(5.1) DB Change Request for CQ# STGAP00017878

-- FOLLOWING ARE THE DB CHANGES FOR BREAK FIX DEFECT - STGAP00017878
--        i) ADD A COLUMN SPECIAL_NEEDS_DETERMINATION.IND_AGRMT_TYPE TO INDICATE IF THE AGREEMENT IS INITAL OR AMENDED
--       ii) AND NEW RECORD IN CAPS.MESSAGE TABLE FOR THE VALIDATION MESSAGE FOR ABOVE AGREEMENT TYPE FIELD


ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION
ADD (
   IND_AGRMT_TYPE VARCHAR2(1)
);

COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_AGRMT_TYPE is 'Indicates if Agreement Type is (I)nitial or (A)mended';


INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60958, 'MSG_ADO_INIT_AMND_AGRMT_TYPE','Please indicate the Agreement Type.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1201, 'SacwisRev5', 'Release 5.1 - DBCR 17881');

commit;
