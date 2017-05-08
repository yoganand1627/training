--STGAP00015655 - Release(3.4) Add Column and Trigger to NCANDS table

--(1) Add this column to NCANDS:
ALTER TABLE
        CAPS.NCANDS
ADD
       (DT_LAST_UPDATE DATE);

comment on column caps.ncands.DT_LAST_UPDATE is 'Indicates the date when the record was last updated.';


--(2) Add this trigger to update this column:
/
create or replace TRIGGER CAPS.TIBR_NCANDS
BEFORE INSERT
ON CAPS.NCANDS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (647, 'SacwisRev3', 'Release 3.4 - DBCR 15655');

commit;

