--STGAP00015724 - Release 3.5 - Create SHINESDM User

/
declare
dmuser varchar2(30);
sql_stmt  varchar2(200);
begin
   select username into dmuser from dba_users where username='SHINESDM' ;

   EXCEPTION
     WHEN NO_DATA_FOUND THEN  -- catches all 'no data found' errors
     sql_stmt := 'CREATE USER SHINESDM identified by SHINESDM DEFAULT TABLESPACE DATA01 TEMPORARY TABLESPACE TEMP';
     execute immediate sql_stmt;
     sql_stmt := 'grant CONNECT,resource to SHINESDM';
     execute immediate sql_stmt;
     sql_stmt := 'alter user SHINESDM quota unlimited on DATA01';
     execute immediate sql_stmt;
     sql_stmt := 'alter user SHINESDM quota unlimited on INDEX01';
     execute immediate sql_stmt;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (694, 'SacwisRev3', 'Release 3.5 - DBCR 15724');

commit;

