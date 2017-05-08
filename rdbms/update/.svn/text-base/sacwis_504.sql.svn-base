--STGAP00014927 - Safety, Permanency and Well Being static data chg

update caps.spwb_age_group_lookup set cd_chck_list='SCCQ19' where cd_chck_list='SSCQ19';
update caps.spwb_age_group_lookup set cd_chck_list='SCCQ20' where cd_chck_list='SSCQ20';
update caps.spwb_age_group_lookup set cd_chck_list='SCCQ21' where cd_chck_list='SSCQ21';

delete from caps.spwb_chck_list_lookup where cd_chck_list='WPCQ9';
delete from caps.spwb_age_group_lookup where cd_chck_list='WPCQ9';

update caps.spwb_age_group_lookup set nbr_month_max = 156 where cd_chck_list in ('WPCQ50','WPCQ55','WPCQ96');

update caps.spwb_age_group_lookup set cd_chck_list='SCQ8' where cd_chck_list='SCQ7' and nbr_month_min=156 and nbr_month_max=264;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (505, 'SacwisRev3', 'Release 3.2 - DBCR 14927');

commit;


