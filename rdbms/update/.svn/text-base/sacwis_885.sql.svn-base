--STGAP00015979 - Release(4.0) MR-067 Update message text and insert lookup data

-- STGAP00015979  MR-067 Update message text and insert reporting year lookup table

update caps.message
set txt_message = 'Your survey will close within %ld days. Please complete before %s.', txt_message_name = trim(txt_message_name)
where nbr_message = 60759;

update caps.message
set txt_message = 'Your survey will close within %ld days on %s.'
where nbr_message = 60763;

insert into caps.nytd_base_follow_up_lookup (id_nytd_base_follow_up_lookup, nytd_baseline_year, nytd_followup_19_year, nytd_followup_21_year)
values (0, 2011, 2013, 2015);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (886, 'SacwisRev4', 'Release 4.0 - DBCR 15979');

commit;


