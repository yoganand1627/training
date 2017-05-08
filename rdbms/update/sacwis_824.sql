--STGAP00015902 - Release(3.6) Per SMS#42496 add rows to errorlist table

--INV stage
insert into caps.error_list
(nbr_message, txt_prgm_cd, txt_stage_cd, id_tab)
values (60738, 'CPS', 'INV', 450);

-- FCC/SUB
insert into caps.error_list
(nbr_message, txt_prgm_cd, txt_stage_cd, id_tab)
values (60739, 'CPS', 'SUB', 450);

--FPR
insert into caps.error_list
(nbr_message, txt_prgm_cd, txt_stage_cd, id_tab)
values (60739, 'CPS', 'FPR', 450);

--FSU
insert into caps.error_list
(nbr_message, txt_prgm_cd, txt_stage_cd, id_tab)
values (60739, 'CPS', 'FSU', 450);

--ADO
insert into caps.error_list
(nbr_message, txt_prgm_cd, txt_stage_cd, id_tab)
values (60739, 'CPS', 'ADO', 450);

--PAD
insert into caps.error_list
(nbr_message, txt_prgm_cd, txt_stage_cd, id_tab)
values (60739, 'CPS', 'PAD', 450);

--PFC
insert into caps.error_list
(nbr_message, txt_prgm_cd, txt_stage_cd, id_tab)
values (60739, 'CPS', 'PFC', 450);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (825, 'SacwisRev3', 'Release 3.6 - DBCR 15902');

commit;

