--STGAP00016052 - Release(4.1) MR-074 AFCARS: removal reason conversion

-- remap old removal reasos/factors to the new AFCARS reasons

-- SMS#81140

-- Abandonment, Physical Abuse, Sexual Abuse: code unchanged
-- NEGLECT: NEG
--(1)
insert into caps.removal_reason (id_removal_event, dt_last_update, cd_removal_reason, id_case) 
(select distinct old.id_removal_event, sysdate, 'NEG', old.id_case 
from caps.removal_reason old
where old.cd_removal_reason in ('PHR','NSR','MNR','TAA','TAB','TAC','TAD','EAR')
and not exists (select 1 from caps.removal_reason r 
                where r.id_removal_event = old.id_removal_event
                and r.cd_removal_reason = 'NEG')
);
-- PARENT: ALCOHOL AND DRUG ABUSE, INADEQUATE HOUSING, INCACERRATED, DEATH  
--(2)
insert into caps.removal_reason (id_removal_event, dt_last_update, cd_removal_reason, id_case)
(select distinct a.id_removal_event, sysdate, a.cd_remov_adult_char, a.id_case from caps.removal_char_adult a
where a.cd_remov_adult_char in ('ALC','DRU','DEA','INC','INA','UNA')
);
--This need to be run after (2): UNA or EMO on removal_char_adult translated to UNA on removal_reason
-- (3): only insert UNA to removal_reason for the same event for EMO if it was not done by UNA
insert into caps.removal_reason (id_removal_event, dt_last_update, cd_removal_reason, id_case)
(select distinct a.id_removal_event, sysdate, 'UNA', a.id_case from caps.removal_char_adult a
where a.cd_remov_adult_char in ('EMO')
and not exists (select 1 from caps.removal_reason r 
                where r.id_removal_event = a.id_removal_event
                and r.cd_removal_reason = 'UNA')
);
-- CHILD: 
-- ALCOHOL ABUSE 112 = CCA - add distinct to catch bad data when there is dup record in child table
insert into caps.removal_reason (id_removal_event, dt_last_update, cd_removal_reason, id_case)
(select distinct id_removal_event, sysdate, 'CCA', id_case from caps.removal_char_child 
where cd_remov_child_char in ('112') and ind_char_child_current = 'Y')
;
-- DRUG ABUSE 113 = CDA
insert into caps.removal_reason (id_removal_event, dt_last_update, cd_removal_reason, id_case)
(select distinct id_removal_event, sysdate, 'CDA', id_case from caps.removal_char_child 
where cd_remov_child_char in ('113') and ind_char_child_current = 'Y');
-- BEHAVIOR = CBP: 
insert into caps.removal_reason (id_removal_event, dt_last_update, cd_removal_reason, id_case)
(select distinct c.id_removal_event, sysdate, 'CBP', c.id_case from caps.removal_char_child c
where c.cd_remov_child_char in 
('110','111','8','10','114','21','30','32','115','39','116','117','66','68','70','118','119','120','121','122','86')
and c.ind_char_child_current = 'Y'
and not exists (select 1 from caps.removal_reason r 
                where r.id_removal_event = c.id_removal_event
                and r.cd_removal_reason = 'CBP'))
;
-- DISABILITY = CDI 21 overlap with BP?
insert into caps.removal_reason (id_removal_event, dt_last_update, cd_removal_reason, id_case)
(select distinct c.id_removal_event, sysdate, 'CDI', c.id_case from caps.removal_char_child c
where c.cd_remov_child_char in 
('18','52','36','84','58','60','75','3','123','124','11','7','13','114','14','127','128','21','22','130','132','59','134','136','64','137','138','139','141',
'40','42','126','131','44','74','110','38','125','97','98','99','100','101','102','103','90','105','106','72','107','80','82','108')
and c.ind_char_child_current = 'Y'
and not exists (select 1 from caps.removal_reason r 
                where r.id_removal_event = c.id_removal_event
                and r.cd_removal_reason = 'CDI'));


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (944, 'SacwisRev4', 'Release 4.1 - DBCR 16052');

commit;

