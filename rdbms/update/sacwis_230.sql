-- Change STGAP00004640
-- Standard Alter Table SQL
ALTER TABLE CAPS.RESOURCE_ADDRESS ADD RESULT VARCHAR2(13)     NULL
;
ALTER TABLE CAPS.RESOURCE_ADDRESS ADD CONFCODE VARCHAR2(1)     NULL
;

-- change STGAP00004638
-- Alter Index SQL
CREATE INDEX CAPS.IND_STAFF_ASGN_HSTRY_2
    ON CAPS.STFF_ASGNMT_HISTORY(ID_CASE,ID_STAGE,ID_FROM_PERSON,ID_TO_PERSON,ID_ENTERED_BY_PERSON)
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

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (231, 'SacwisRev2', 'add index to STFF_ASGNMT_HISTORY, add mapinfo status fields to RESOURCE_ADDRESS');
commit;
