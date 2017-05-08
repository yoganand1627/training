--STGAP00015986 - Release(4.0) MR-067: Update portal user profile tab's url

-- Reuse the current conversation instead of defining new for NYTD youth's Profile tab

update caps.portal_metaphor set TXT_TAB_URL = '/admin/VendorStaffDetail/displayUserProfileDetail'
where id_tab = 200;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (892, 'SacwisRev4', 'Release 4.0 - DBCR 15986');

commit;

