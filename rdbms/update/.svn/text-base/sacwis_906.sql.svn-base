--STGAP00016009 - Release(Undetermined) Record Check R41 conversion for closed case

--This is to supplement STGAP00016000 and STGAP00016005. It will add  3 new record check types: IM, IC, PS for every PH where the stage that the PH was created in is now closed by the person is still active, ie. belong to a open case. These PHs have not been converted by the original DBCR.
--There will not be overlapping between all populations.

insert into caps.records_check 
(ID_REC_CHECK,DT_LAST_UPDATE,ID_REC_CHECK_PERSON,ID_REC_CHECK_REQUESTOR,ID_STAGE,ID_CASE,CD_REC_CHECK_CHECK_TYPE,CD_REC_CHECK_EMP_TYPE,CD_REC_CHECK_STATUS,DT_REC_CHECK_COMPLETED,DT_REC_CHECK_REQUEST,TXT_REC_CHECK_COMMENTS,IND_RECCHECK_HISTORY,DT_REC_CHECK_CRIM_REL_REC,IND_RECCHK_FPCARD,IND_RECCHK_LIVE_SCAN,DT_RECCHK_FP_CARD_GIVEN,DT_RECCHK_FP_CARD_RETURN,DT_RECCHK_LS_PERFORMED,DT_RECCHK_LSRESULT_REC,IND_RECCHK_REFUSE_INV_CLRNCE,IND_RECCHK_FPCHK_RESULT,IND_RECCHK_RECMNDATN) 
select 0,sysdate,r.ID_REC_CHECK_PERSON,r.ID_REC_CHECK_REQUESTOR,r.ID_STAGE,r.ID_CASE,'IM',r.CD_REC_CHECK_EMP_TYPE,r.CD_REC_CHECK_STATUS,r.DT_REC_CHECK_COMPLETED,r.DT_REC_CHECK_REQUEST,r.TXT_REC_CHECK_COMMENTS,r.IND_RECCHECK_HISTORY,r.DT_REC_CHECK_CRIM_REL_REC,r.IND_RECCHK_FPCARD,r.IND_RECCHK_LIVE_SCAN,r.DT_RECCHK_FP_CARD_GIVEN,r.DT_RECCHK_FP_CARD_RETURN,r.DT_RECCHK_LS_PERFORMED,r.DT_RECCHK_LSRESULT_REC,r.IND_RECCHK_REFUSE_INV_CLRNCE,r.IND_RECCHK_FPCHK_RESULT,r.IND_RECCHK_RECMNDATN
from caps.records_check r, caps.stage s, caps.caps_case c 
where r.id_stage = s.id_stage and s.id_case = c.id_case and 
(c.dt_case_closed is not null and  c.dt_case_closed < to_date('12/31/4712', 'MM/DD/YYYY')) and -- the rc stage and case is closed
r.cd_rec_check_check_type='PH' and
r.id_rec_check_person in -- the person has at least one open case
(select spl.id_person from caps.stage_person_link spl, caps.caps_case c 
 where spl.id_case = c.id_case
 and (c.dt_case_closed is null or c.dt_case_closed=to_date('12/31/4712', 'MM/DD/YYYY')))
 ;
 
insert into caps.records_check 
(ID_REC_CHECK,DT_LAST_UPDATE,ID_REC_CHECK_PERSON,ID_REC_CHECK_REQUESTOR,ID_STAGE,ID_CASE,CD_REC_CHECK_CHECK_TYPE,CD_REC_CHECK_EMP_TYPE,CD_REC_CHECK_STATUS,DT_REC_CHECK_COMPLETED,DT_REC_CHECK_REQUEST,TXT_REC_CHECK_COMMENTS,IND_RECCHECK_HISTORY,DT_REC_CHECK_CRIM_REL_REC,IND_RECCHK_FPCARD,IND_RECCHK_LIVE_SCAN,DT_RECCHK_FP_CARD_GIVEN,DT_RECCHK_FP_CARD_RETURN,DT_RECCHK_LS_PERFORMED,DT_RECCHK_LSRESULT_REC,IND_RECCHK_REFUSE_INV_CLRNCE,IND_RECCHK_FPCHK_RESULT,IND_RECCHK_RECMNDATN) 
select 0,sysdate,r.ID_REC_CHECK_PERSON,r.ID_REC_CHECK_REQUESTOR,r.ID_STAGE,r.ID_CASE,'IC',r.CD_REC_CHECK_EMP_TYPE,r.CD_REC_CHECK_STATUS,r.DT_REC_CHECK_COMPLETED,r.DT_REC_CHECK_REQUEST,r.TXT_REC_CHECK_COMMENTS,r.IND_RECCHECK_HISTORY,r.DT_REC_CHECK_CRIM_REL_REC,r.IND_RECCHK_FPCARD,r.IND_RECCHK_LIVE_SCAN,r.DT_RECCHK_FP_CARD_GIVEN,r.DT_RECCHK_FP_CARD_RETURN,r.DT_RECCHK_LS_PERFORMED,r.DT_RECCHK_LSRESULT_REC,r.IND_RECCHK_REFUSE_INV_CLRNCE,r.IND_RECCHK_FPCHK_RESULT,r.IND_RECCHK_RECMNDATN
from caps.records_check r, caps.stage s, caps.caps_case c 
where r.id_stage = s.id_stage and s.id_case = c.id_case and 
(c.dt_case_closed is not null and  c.dt_case_closed < to_date('12/31/4712', 'MM/DD/YYYY')) and -- the rc stage and case is closed
r.cd_rec_check_check_type='PH' and
r.id_rec_check_person in -- the person has at least one open case
(select spl.id_person from caps.stage_person_link spl, caps.caps_case c 
 where spl.id_case = c.id_case
 and (c.dt_case_closed is null or c.dt_case_closed=to_date('12/31/4712', 'MM/DD/YYYY')))
 ;
 
insert into caps.records_check 
(ID_REC_CHECK,DT_LAST_UPDATE,ID_REC_CHECK_PERSON,ID_REC_CHECK_REQUESTOR,ID_STAGE,ID_CASE,CD_REC_CHECK_CHECK_TYPE,CD_REC_CHECK_EMP_TYPE,CD_REC_CHECK_STATUS,DT_REC_CHECK_COMPLETED,DT_REC_CHECK_REQUEST,TXT_REC_CHECK_COMMENTS,IND_RECCHECK_HISTORY,DT_REC_CHECK_CRIM_REL_REC,IND_RECCHK_FPCARD,IND_RECCHK_LIVE_SCAN,DT_RECCHK_FP_CARD_GIVEN,DT_RECCHK_FP_CARD_RETURN,DT_RECCHK_LS_PERFORMED,DT_RECCHK_LSRESULT_REC,IND_RECCHK_REFUSE_INV_CLRNCE,IND_RECCHK_FPCHK_RESULT,IND_RECCHK_RECMNDATN) 
select 0,sysdate,r.ID_REC_CHECK_PERSON,r.ID_REC_CHECK_REQUESTOR,r.ID_STAGE,r.ID_CASE,'PS',r.CD_REC_CHECK_EMP_TYPE,r.CD_REC_CHECK_STATUS,r.DT_REC_CHECK_COMPLETED,r.DT_REC_CHECK_REQUEST,r.TXT_REC_CHECK_COMMENTS,r.IND_RECCHECK_HISTORY,r.DT_REC_CHECK_CRIM_REL_REC,r.IND_RECCHK_FPCARD,r.IND_RECCHK_LIVE_SCAN,r.DT_RECCHK_FP_CARD_GIVEN,r.DT_RECCHK_FP_CARD_RETURN,r.DT_RECCHK_LS_PERFORMED,r.DT_RECCHK_LSRESULT_REC,r.IND_RECCHK_REFUSE_INV_CLRNCE,r.IND_RECCHK_FPCHK_RESULT,r.IND_RECCHK_RECMNDATN
from caps.records_check r, caps.stage s, caps.caps_case c 
where r.id_stage = s.id_stage and s.id_case = c.id_case and 
(c.dt_case_closed is not null and  c.dt_case_closed < to_date('12/31/4712', 'MM/DD/YYYY')) and -- the rc stage and case is closed
r.cd_rec_check_check_type='PH' and
r.id_rec_check_person in -- the person has at least one open case
(select spl.id_person from caps.stage_person_link spl, caps.caps_case c 
 where spl.id_case = c.id_case
 and (c.dt_case_closed is null or c.dt_case_closed=to_date('12/31/4712', 'MM/DD/YYYY')))
 ; 


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (907, 'SacwisRev4', 'Release Undetermined - DBCR 16009');

commit;



