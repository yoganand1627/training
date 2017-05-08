--STGAP00015759 - Release(3.5) MR-059 Need a new table

--Need a new table:

--Table  Name: RerateCompleteDateRange

--Column 1: ID_PERSON (Nullable - Person Id of the person for whom the adjustment is being processed)

--Column 2: DT_COMP_RANGE_START (Nullable - Start date of the adjustment period)

--Column 3: DT_COMP_RANGE_END (Nullable - end date of the adjustment period)

--This table is used only by the batch program to populate interim values. This table is emptied by the batch program every month when the batch runs.

create table caps.RerateCompleteDateRange
(id_person number(16),
DT_COMP_RANGE_START date,
DT_COMP_RANGE_END date) tablespace data01;

comment on table caps.RerateCompleteDateRange is 'This table is used only by the batch program to populate interim values. This table is emptied by the batch program every month when the batch runs.';

grant select,update,insert,delete on CAPS.RerateCompleteDateRange to capson,capsbat,ops$datafix;
grant select on caps.RerateCompleteDateRange to operator,shinesdm;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (726, 'SacwisRev3', 'Release 3.5 - DBCR 15759');



commit;
 
