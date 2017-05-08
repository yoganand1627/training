--STGAP00015577 - Release(3.32) DBCR- Per 38365 delete rows from ErrorList table


-- DBCR- Per 38365 delete rows from ErrorList table

-- Delete ErrorList link  to approval event.
DELETE FROM  caps.error_list
WHERE  cd_task = '7332' AND  id_tab = 1616 AND nbr_message = 60558
AND   txt_prgm_cd = 'CPS'  AND txt_stage_cd = 'INV';


-- Delete ErrorList link  to approval event.
DELETE FROM  caps.error_list
WHERE  cd_task = '7333' AND  id_tab = 1616 AND nbr_message = 60559
AND   txt_prgm_cd = 'CPS'  AND txt_stage_cd = 'FPR';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (596, 'SacwisRev3', 'Release 3.32 - DBCR 15577');

commit;

