-- Release 2.5 
-- Alter Index SQL

CREATE INDEX CAPS.IND_SAFETY_RSRC_CHILD_1
    ON CAPS.SAFETY_RESOURCE_CHILD(ID_CHILD)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

--change STGAP00009204
update caps.codes_tables set decode = concat(decode,'Y') where code in ('01','02','03','04','06') and code_type='CCPSCLED';
update caps.codes_tables set decode = concat(decode,'N') where code in ('05') and code_type='CCPSCLED';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (336, 'SacwisRev2', 'static table updates, new index');                        
commit;
