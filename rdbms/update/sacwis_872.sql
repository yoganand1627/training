--STGAP00015966 - Release(4.0) MR-067 Portal_Metaphor update

--STGAP00015966  MR-067 Portal_Metaphor update
Update caps.portal_metaphor
set TXT_L1_IMG_ACTIVE = 'Tb_SurveyDetail_1.gif',
TXT_L1_IMG_INACTIVE = 'Tb_SurveyDetail_0.gif'
where txt_tab_constant = 'PORTAL_SURVEY_DETAIL';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (873, 'SacwisRev4', 'Release 4.0 - DBCR 15966');

commit;

