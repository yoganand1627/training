
-- change STGAP00001514
INSERT INTO CAPS.METAPHOR
(id_tab,
txt_tab_url,
txt_tab_constant,
txt_tab,
dt_last_update)
VALUES
(1510,
'/person/FAPersonDetail/displayFAPersonDetail',
'FA_PERSON_DETAIL',
'F/A Person',
SYSDATE);

-- change STGAP00001520
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60145, 'MSG_DILSEARCH_OTHER' ,'Please describe when referral type is other.',500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (129, 'SacwisRev2', 'static updates');
                         
commit;