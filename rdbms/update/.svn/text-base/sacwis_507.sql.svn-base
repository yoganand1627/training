--STGAP00014956 - ADO_SUBSIDY_RATE - Add CD_PRE_POST_RATETYPE

alter table caps.ado_subsidy_rate add cd_pre_post_ratetype varchar2(3);
comment on column caps.ado_subsidy_rate.cd_pre_post_ratetype is 'Pre/Post Rate Type Code';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (508, 'SacwisRev3', 'Release 3.2 - DBCR 14956');

commit;


