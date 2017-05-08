--STGAP00015789 - Release(3.5) Add triggers to SCREENING_REF_NARR

--Need triggers to update the DT_LAST_UPDATE field on SCREENING_REF_NARR

grant select on CAPS.SCREENING_REF_NARR to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SCREENING_REF_NARR
BEFORE UPDATE
ON CAPS.SCREENING_REF_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SCREENING_REF_NARR
BEFORE INSERT
ON CAPS.SCREENING_REF_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (742, 'SacwisRev3', 'Release 3.5 - DBCR 15789');

commit;



