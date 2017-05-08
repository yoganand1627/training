--STGAP00015315 - DBCR: Add stage reopen reason for ext doc

--The following adds a stage reopen reason for deleting external documentation or modifying external documentation after the 7 day window has passed for docs added after case closure:

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE) 
VALUES ('CRREOPEN','XDO','Remove/Modify external doc');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (528, 'SacwisRev3', 'Release 3.3 - DBCR 15315');

commit;


