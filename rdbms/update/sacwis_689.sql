--STGAP00015715 - Release(3.5) per CAPTA - add a new column to Legal_action table

alter table caps.legal_action
add IND_LEGAL_REP_APPOINTED VARCHAR2(1 BYTE);

comment on column caps.legal_action.IND_LEGAL_REP_APPOINTED  is 'This column indicates if legal representation is appointed for the child.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (690, 'SacwisRev3', 'Release 3.5 - DBCR 15715');

commit;


