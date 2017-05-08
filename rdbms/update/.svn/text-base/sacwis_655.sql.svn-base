--STGAP000156645SMS#40965 Add new column to Exchange_Child table

--Per SMS#40965  Add new column  dt_dissoulution  to Exchange_Child table so that the user can 
-- enter the dissolution date in the Closed section of exchange child detail page.

ALTER TABLE caps.exchange_child ADD (DT_DISSOLUTION_CWP DATE NULL); 

COMMENT ON COLUMN caps.exchange_child.DT_DISSOLUTION_CWP IS 'Dissolution Date in the Closed With Placement section';
   
insert into caps.schema_version(id_schema_version,application_version,comments)
            values (656, 'SacwisRev3', 'Release 3.5 - DBCR 15665');

commit;

