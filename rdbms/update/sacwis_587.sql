--STGAP00015564 - Release(3.32) DBCR- Per 38365 Insert rows into ErrorList table

--Per 38365 Insert rows into ErrorList table, this will create a hyperlink when an error message is displayed in the --errorlist page.

-- ErrorList link to go to Safety Resource Event in INV stage

INSERT INTO caps.error_list (cd_task, id_tab, nbr_message, txt_prgm_cd, txt_stage_cd)
VALUES ('2277', 1616, 60558, 'CPS', 'INV');

-- ErrorList link to go to Safety Resource Event in ONG/FPR stage
INSERT INTO caps.error_list (cd_task, id_tab, nbr_message, txt_prgm_cd, txt_stage_cd)
VALUES ('7331', 1616, 60559, 'CPS', 'FPR');

-- ErrorList link to go to copied Safety Resource Event in INV stage
INSERT INTO caps.error_list (cd_task, id_tab, nbr_message, txt_prgm_cd, txt_stage_cd)
VALUES ('7332', 1616, 60558, 'CPS', 'INV');

-- ErrorList link to go to Copied Safety Resource Event in ONG/FPR stage
INSERT INTO caps.error_list (cd_task, id_tab, nbr_message, txt_prgm_cd, txt_stage_cd)
VALUES ('7333', 1616, 60559, 'CPS', 'FPR');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (588, 'SacwisRev3', 'Release 3.32 - DBCR 15564');

commit;

