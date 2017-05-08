--STGAP00017207.sql -  ECEM5.0 Permanency Roundtable Form does not display the word 'Permanency' on the tab

update caps.metaphor
set txt_tab = 'Permanency Roundtable'
where id_tab= 1767;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1150, 'SacwisRev5', 'Release 5.0 - DBCR 17207');

commit;
