--STGAP00014949 - MR-034: Need to update TIBR_ELIGIBILITY

--Need to update the trigger TIBR_ELIGIBILITY to insert into the ADJUSTMENT_REQUEST table

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ELIGIBILITY 
BEFORE INSERT ON CAPS.ELIGIBILITY
FOR EACH ROW

DECLARE
    dummy       NUMBER;
BEGIN
    :new.DT_LAST_UPDATE := SYSDATE;
    -- Mike Bui: 10/06/95: as requested by SUBCARE TCL
    IF (:new.DT_ELIG_END IS NULL) THEN
                :new.DT_ELIG_END := TO_DATE ('12/31/4712','MM/DD/YYYY');
    END IF;
    BEGIN
        SELECT  ID_CASE
        INTO        :new.ID_CASE
        FROM        EVENT
        WHERE       ID_EVENT = :new.ID_ELIG_EVENT;

        -- DBCR STGAP00014949   8/3/2009
        IF nvl(:new.IND_ELIG_WRITE_HISTORY,'N') = 'Y' THEN
              insert into ADJUSTMENT_REQUEST (
                    ID_ADJ_REQ,
                    ID_ADJ_REQ_EVENT,
                    DT_ADJ_REQ_START,
                    DT_ADJ_REQ_END,
                    ID_ADJ_REQ_PERSON,
                    CD_ADJ_REQ_TYPE
                ) VALUES (
                    0,
                    :new.ID_ELIG_EVENT,
                    TO_DATE(:new.DT_ELIG_START,'MM/DD/YYYY'),
                    TO_DATE(:new.DT_ELIG_END,'MM/DD/YYYY'),
                    :new.ID_PERSON,
                    'FCD'
                );
        END IF;

    EXCEPTION
        WHEN OTHERS THEN
            IF SQL%NOTFOUND THEN
                :new.ID_CASE := NULL;
            END IF;
    END;
END;
/

--STGAP00014948 - MR-034: Delete records from Adjustment Request tab

--Need to delete all the records from the adjustment request table AS PART OF MR-034.

DELETE CAPS.ADJUSTMENT_REQUEST;


--STGAP00014958 - Update Codes Tables Decode for CRELVICT

UPDATE CAPS.CODES_TABLES SET DECODE = 'Biological and Legal Father' where CODE_TYPE = 'CRELVICT' AND CODE = 'BB';




insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (506, 'SacwisRev3', 'Release 3.2 - DBCRs 14948,14949,14958,14967');

commit;


