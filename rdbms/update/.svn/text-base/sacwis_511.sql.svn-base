--STGAP00015050 - MR-034 Need to update the trigger on eligibility

--Need to update the trigger TIBR_ELIGIBILITY with the following change. 
--The adjustment request end date is written as 12/31/4712. Need to update the trigger to make it system date.


--Need to update the trigger to read:


grant select on caps.person to capson;
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ELIGIBILITY
BEFORE INSERT ON CAPS.ELIGIBILITY
FOR EACH ROW

DECLARE
    dummy       NUMBER;
BEGIN
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
                    nvl(TO_DATE(:new.DT_ELIG_END,'MM/DD/YYYY'),sysdate),
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
    :new.DT_LAST_UPDATE := SYSDATE;
    -- Mike Bui: 10/06/95: as requested by SUBCARE TCL
    IF (:new.DT_ELIG_END IS NULL) THEN
                :new.DT_ELIG_END := TO_DATE ('12/31/4712','MM/DD/YYYY');
    END IF;

END;
/

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (512, 'SacwisRev3', 'Release 3.2 - DBCRs 15050');

commit;


