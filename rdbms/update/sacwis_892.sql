--STGAP00015988 - Release(4.0) Modify Report Name/Definition on Rpt launch page

-- SMS #: 66385
-- Modify Report name and definition on Report Launch page

update caps.reports
set txt_rpt_full_name = ' NYTD Baseline Survey Status Tracking',
     nm_rpt_desc = 'A list of youth currently in DFCS custody whose 17th birthday occurs during the specified reporting period and/or report month. Generated for optional month/year, region and county parameters.'
where txt_rpt_full_name = 'Baseline Survey Status Tracking';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (893, 'SacwisRev4', 'Release 4.0 - DBCR 15988');

commit;

