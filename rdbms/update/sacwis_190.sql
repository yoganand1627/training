
-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.BATCH_TST
(
    KEY_ID      VARCHAR2(8)  NOT NULL,
    COMMENTS_TX VARCHAR2(25)     NULL,
    EDIT_DT     DATE             NULL,
    LOAD_IND    VARCHAR2(1)      NULL
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.BATCH_TST IS
'This is a table purely for testing the batch mechanism. It is not a core application table.'
;
GRANT DELETE ON CAPS.BATCH_TST TO CAPSBAT
;
GRANT INSERT ON CAPS.BATCH_TST TO CAPSBAT
;
GRANT SELECT ON CAPS.BATCH_TST TO CAPSBAT
;
GRANT UPDATE ON CAPS.BATCH_TST TO CAPSBAT
;
GRANT DELETE ON CAPS.BATCH_TST TO CAPSON
;
GRANT INSERT ON CAPS.BATCH_TST TO CAPSON
;
GRANT SELECT ON CAPS.BATCH_TST TO CAPSON
;
GRANT UPDATE ON CAPS.BATCH_TST TO CAPSON
;
GRANT SELECT ON CAPS.BATCH_TST TO OPERATOR
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (191, 'SacwisRev2', 'new BATCH_TST table');
commit;
