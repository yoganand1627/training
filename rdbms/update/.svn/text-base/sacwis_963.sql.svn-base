--STGAP00016076 - Release(4.2) Toenable ILPElig rpt run statewide, corrected WTLP

-- Adding new report parameters
-- ITSM # 15177
-- DBCR # STGAP00016076

update caps.reports
 set nm_rpt_desc = 'List of children currently in Foster Care(FCC), Adoption(ADO) or Post Foster Care(PFC) stages eligible for ILP services. Report runs for optional Region, County and Unit parameters.'
 where nm_rpt_sqr_name = 'ILPEligibility'
 and nm_rpt_sqr_ver = '00';

INSERT INTO caps.report_parameter
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ILPEligibility','00','2','3','COUNTYCD', 'CHAR', 'N', 'County');

INSERT INTO caps.report_parameter
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ILPEligibility','00','3','2','UNIT', 'NUMBER', 'N', 'Unit');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (964, 'SacwisRev4', 'Release 4.2 - DBCR 16076');

commit;


