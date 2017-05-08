-- STGAP00009601 - Create ops$datafix user in all environments
/
DECLARE

cnt NUMBER;

BEGIN

SELECT COUNT(*) INTO cnt FROM all_users WHERE username='OPS$DATAFIX';

IF cnt = 0 THEN
   execute immediate 'create user ops$datafix identified externally default tablespace data01' ;
   execute immediate 'alter user ops$datafix quota unlimited on data01';
   execute immediate 'alter user ops$datafix quota unlimited on index01';
   execute immediate 'grant resource,connect to ops$datafix';
   execute immediate 'grant create any synonym to ops$datafix';
END IF;
END;
/

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (360, 'SacwisRev2', 'Release 2.5 - DBCR 9601');

commit;


