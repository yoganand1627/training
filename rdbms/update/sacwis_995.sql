--STGAP00016112 - Release(4.2) MR-075 Data conversion

-- MR-075 Data conversion
-- Only for open homes
-- Update caps_resource Hold Placement indicator based on
-- home approved status and resource inactive status
update (select R.IND_HOLD_PLACEMENTS, R.IND_RSRC_WRITE_HIST
        from caps.caps_resource r
        join caps.stage s on r.id_rsrc_fa_home_stage = s.id_stage
        where r.cd_rsrc_status <> '01'
        and r.id_rsrc_fa_home_stage = s.id_stage
        and s.dt_stage_close is null
        and r.cd_rsrc_fa_home_status IN ('AFA', 'ASA', 'ATA')) t
set t.IND_HOLD_PLACEMENTS = 'Y', t.IND_RSRC_WRITE_HIST = 'N';

-- Update caps_resource hold placement indicator if home status
-- is not one of pending or approved status, except pending unapproved
update (select R.IND_HOLD_PLACEMENTS, R.IND_RSRC_WRITE_HIST
        from caps.caps_resource r
        join caps.stage s on r.id_rsrc_fa_home_stage = s.id_stage
        where r.cd_rsrc_status <> '01'
        and r.id_rsrc_fa_home_stage = s.id_stage
        and s.dt_stage_close is null
        and r.cd_rsrc_fa_home_status IN ('PUN', 'AUN', 'CSD', 'INQ', 'APP', 'WTL', 'FSG', 'FLG')) t
set t.IND_HOLD_PLACEMENTS = 'Y', t.IND_RSRC_WRITE_HIST = 'N';

-- Update caps_resource hold placement indicator and
-- resource status if home status is not one of
-- pending or approved status and resource status is active
update (select R.IND_HOLD_PLACEMENTS, R.IND_RSRC_WRITE_HIST, R.CD_RSRC_STATUS
        from caps.caps_resource r
        join caps.stage s on r.id_rsrc_fa_home_stage = s.id_stage
        where r.cd_rsrc_status = '01'
        and r.id_rsrc_fa_home_stage = s.id_stage
        and s.dt_stage_close is null
        and r.cd_rsrc_fa_home_status IN ('PUN', 'AUN', 'CSD', 'INQ', 'APP', 'WTL', 'FSG', 'FLG')) t
set t.IND_HOLD_PLACEMENTS = 'Y', t.IND_RSRC_WRITE_HIST = 'N', t.CD_RSRC_STATUS = '02';

-- Update caps_resource to generate IV-Reimbursable status
update (select r.IND_RSRC_WRITE_HIST, r.IND_HOME_IVE_REIMBURSABLE
        from caps.caps_resource r
        join caps.stage s on r.id_rsrc_fa_home_stage = s.id_stage
        where s.dt_stage_close is null
        AND r.ID_RSRC_FA_HOME_STAGE is not null
        AND r.CD_RSRC_FA_HOME_STATUS IN ('AFA', 'ASA', 'PUN', 'AUN', 'CSD', 'INQ', 'APP', 'WTL', 'FLG', 'FSG')) t
set t.IND_RSRC_WRITE_HIST = 'Y'
WHERE t.IND_HOME_IVE_REIMBURSABLE IS NULL;




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (996, 'SacwisRev4', 'Release 4.2 - DBCR 16112');

commit;



