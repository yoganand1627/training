--STGAP00016176 - Release(4.3) MR-083 Appending Families Considered comments

-- MR-083 Appending Families Considered comments to County Regional Families Considered comments
-- and deleting Families Considered source comment.

update caps.ado_info
set txt_county_cons_comment = concat(trim(txt_county_cons_comment), chr(13) || ' *** ' || trim(txt_cons_comments) || ' *** '), txt_cons_comments = null
where txt_cons_comments is not null;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1039, 'SacwisRev4', 'Release 4.3 - DBCR 16176');

commit;


