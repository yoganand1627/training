
-- Alter Index SQL

CREATE INDEX CAPS.IND_STAFF_ASGN_HSTRY_1
    ON CAPS.STFF_ASGNMT_HISTORY(ID_FROM_PERSON)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (28, 'SacwisRev1', 'add index to STFF_ASGNMT_HISTORY for ID_FROM_PERSON');

commit;
