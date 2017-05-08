--STGAP00015473 - For Defect #STGAP00015342 changing text for form

--For defect STGAP00015342 the Safety Well being and Permanency Form should be updated with the --suggested changes.  The age groups and verbiage are all stored on static tables.


--updated for #1
update caps.Spwb_Age_Group_Lookup set nbr_month_max = 36 where  id_spwb_age_group = 2;

-- updated for #2
update caps.Spwb_Age_Group_Lookup set nbr_month_max = 120 where  id_spwb_age_group =86;
update caps.Spwb_Age_Group_Lookup set nbr_month_min = 120 where  id_spwb_age_group =87;

-- updated for #3
update caps.Spwb_Chck_List_Lookup set txt_chck_list = 'Do you maintain regular contact with your family and siblings?' where cd_chck_list = 'WPCQ102' ;

--update for #4
update caps.Spwb_Age_Group_Lookup set nbr_month_max = 216 where  id_spwb_age_group =226;

-- update for #5
update caps.Spwb_Chck_List_Lookup set txt_chck_list = 'Do you feel safe living with __________ (caregiver''s name)? What are some things that make you feel safe? Are there situations were you feel not safe living with ___________ (caregiver''s name)? What are some of those situations?'
where cd_chck_list = 'SCCQ25';

-- updates for # 6
update caps.SPWB_CHCK_LIST_LOOKUP set TXT_CHCK_LIST = 'What is it like for you to care for this child/youth?  What has been the effect on your family of having this child/youth placed here?  What did you expect it to be like?'
where CD_CHCK_LIST = 'WPCRQ1';

update caps.SPWB_CHCK_LIST_LOOKUP set TXT_CHCK_LIST = ' Do you ever get scared when you are playing outside or walking around by _______''s house?  If yes, what are the things that make you scared?  Can you talk to someone about this?  If so, who?'
where CD_CHCK_LIST = 'WPCQ58';

update caps.SPWB_CHCK_LIST_LOOKUP set TXT_CHCK_LIST = 'Do you see your brothers and/or sisters?  How is it to see them? Do you see other members of your family e.g., grandparents, aunts, uncles?'
where CD_CHCK_LIST = 'WPCQ97';

update caps.SPWB_CHCK_LIST_LOOKUP set TXT_CHCK_LIST ='What types of jobs have you liked best?'
where CD_CHCK_LIST = 'WPCQ133';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (558, 'SacwisRev3', 'Release 3.3 - DBCR 15473');

commit;

