--STGAP00015676 - Release(3.5) SMS#37447:Add Column to Exchange_Child table

alter table caps.exchange_child
add IND_BIRTH_NAME_CHANGED VARCHAR2(1);

comment on column caps.exchange_child.IND_BIRTH_NAME_CHANGED  is 'This column indicates if the value of Closure Reason has changed.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (668, 'SacwisRev3', 'Release 3.5 - DBCR 15676');

commit;


