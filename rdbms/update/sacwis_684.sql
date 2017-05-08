--STGAP00015709 - Release(3.5) Add two new columns to UNIT_EMP_LINK table

--Add two new columns NBR_ERRORS and NBR_WARNINGS with NUMBER(5,0) to the table UNIT_EMP_LINK

alter table CAPS.UNIT_EMP_LINK add(NBR_ERRORS NUMBER(5,0));

alter table CAPS.UNIT_EMP_LINK add(NBR_WARNINGS NUMBER(5,0));

COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_ERRORS IS 'number of Errors in the stages';

COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_WARNINGS IS 'number of Warnings in the stages';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (685, 'SacwisRev3', 'Release 3.5 - DBCR 15709');

commit;


