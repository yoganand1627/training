-- change STGAP00008638 for SACWIS 2.4
CREATE OR REPLACE VIEW CAPS.LEGAL_STATUS_VIEW 
( 
 id_legal_stat_event,
 dt_last_update,
 id_person,
 id_case,
 cd_legal_stat_cnty,
 cd_legal_stat_status,
 dt_legal_stat_status_dt,
 ind_csup_send,
 cd_court_nbr,
 dt_legal_stat_crt_odr_exp_dt,
 dt_legal_stat_cus_exp_dt,
 dt_legal_stat_p_m_due_dt,
 ind_legal_stat_risk,
 ID_EVENT_STAGE,
 dt_legal_stat_end,
 In_DFCS_Custody
) AS 
select legal_status_prime.id_legal_stat_event,
legal_status_prime.dt_last_update,
legal_status_prime.id_person,
legal_status_prime.id_case,
legal_status_prime.cd_legal_stat_cnty,
legal_status_prime.cd_legal_stat_status,
legal_status_prime.dt_legal_stat_status_dt,
legal_status_prime.ind_csup_send,
legal_status_prime.cd_court_nbr,
legal_status_prime.dt_legal_stat_crt_odr_exp_dt,
legal_status_prime.dt_legal_stat_cus_exp_dt,
legal_status_prime.dt_legal_stat_p_m_due_dt,
legal_status_prime.ind_legal_stat_risk, 
event_prime.ID_EVENT_STAGE, 
NVL( (select (min(legal_status.DT_LEGAL_STAT_STATUS_DT)-1)
from legal_status, event
where legal_status.DT_LEGAL_STAT_STATUS_DT > legal_status_prime.DT_LEGAL_STAT_STATUS_DT
and legal_status.ID_LEGAL_STAT_EVENT = event.ID_EVENT
and event.ID_CASE = event_prime.ID_CASE -- joined on ID_CASE here to look within the overall case for the same person.
and legal_status.ID_PERSON = legal_status_prime.ID_PERSON
), to_date('12/31/4712', 'MM/DD/YYYY')) as dt_legal_stat_end,
case 
when legal_status_prime.CD_LEGAL_STAT_STATUS IN ('JCD','PCT','PVL','TCT','TVL','JCP','JCT') -- these legal statuses mean In DFCS Custody
  then 'Y'
  else 'N'
end as In_DFCS_Custody
from legal_status legal_status_prime, event event_prime
where legal_status_prime.ID_LEGAL_STAT_EVENT = event_prime.ID_EVENT
order by legal_status_prime.ID_CASE asc, event_prime.ID_EVENT_STAGE asc, legal_status_prime.ID_PERSON asc
;

grant select on caps.legal_status_view to capson, capsbat, operator;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (320, 'SacwisRev2', 'Updated Legal_status_View');                        
commit;


