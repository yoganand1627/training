--STGAP00015664- SMS#37348 :Add Column to Exchange_child_detal

alter table caps.exchange_child add IND_RSN_CLOSED_CHANGED VARCHAR2(1 BYTE);

comment on column caps.exchange_child.IND_RSN_CLOSED_CHANGED is 'This column indicates if the value of Closure Reason has changed.';
   
insert into caps.schema_version(id_schema_version,application_version,comments)
            values (655, 'SacwisRev3', 'Release 3.5 - DBCR 15664');

commit;

