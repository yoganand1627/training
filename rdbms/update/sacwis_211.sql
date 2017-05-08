
-- change STGAP00004097
--Un end date Code AA in CSRCRPTR
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL,
ct.DECODE = 'Case Reading'
WHERE ct.code_type = 'CSRCRPTR' 
AND ct.code = 'AA';

--Un end date Code AA LIKE CRPTRINT
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL 
WHERE ct.code_type = 'CRPTRINT'
AND ct.code = 'AA';

--Un end date Code AA, AG, AN, AT, BY, CA,'CR','CT','EM',
-- FV, GW, GX, IN in CRPTRINT
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL
WHERE ct.code_type = 'CRPTRINT'
AND ct.code IN 
('AA','AG','AN','AT','BY','CA','CR','CT','EM','FV','GW','GX','IN');

--End date Code AC, AM, 'DS','MP','OV','PM' in CRPTRINT
UPDATE caps.codes_tables ct
SET dt_end = SYSDATE
WHERE code_type = 'CRPTRINT'
AND ct.code IN ('AC','AM','DS','MP','OV','PM');

--Un end date code BC in CRELVICT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL, ct.decode = 'Babysitter/Child Care'
WHERE ct.code_type = 'CRELVICT'
AND ct.code = 'BC';

--Un end date code BC in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL, ct.decode = 'Babysitter/Child Care'
WHERE ct.code_type = 'CRPTRINT'
AND ct.code = 'BC';

--Un end date code BF in CRELVICT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL, ct.decode = 'Biological Father'
WHERE ct.code_type = 'CRELVICT'
AND ct.code = 'BF';

--Un end date code BM in CRELVICT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL, ct.decode = 'Biological Mother'
WHERE ct.code_type = 'CRELVICT'
AND ct.code = 'BM';

--Un end date code LF in CRELVICT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL, ct.decode = 'Legal Father'
WHERE ct.code_type = 'CRELVICT'
AND ct.code = 'LF';

--Add Code BP to CRELVICT'
INSERT INTO caps.codes_tables (CODE_TYPE, CODE, DECODE)
VALUES ('CRELVICT','BP','Biological Parent');

--Add Code BP to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT','BP','Biological Parent');

--Add Code BS to CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
VALUES ('CRELVICT','BS','Biological Sibling');

--Add Code BS to 'CRPTRINT'
INSERT INTO caps.codes_tables ct  (CODE_TYPE, CODE, DECODE)
VALUES ('CRPTRINT','BS','Biological Sibling');

--Add Code CG to CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
VALUES ('CRELVICT','CG',' Child of Legal Guardian');

--Update code CO in CRELVICT'
UPDATE caps.codes_tables ct
SET ct.decode = 'First Cousin'
WHERE ct.code_type = 'CRELVICT'
AND ct.code = 'CO';

--Add Code CS to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
 VALUES ('CRPTRINT','CS', 'CASA');

--Add Code DN to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
 VALUES ('CRPTRINT','DN', 'Dentist');

--Un end date code FC, PF, PP, VL in CSRCRPTR'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL
WHERE ct.code_type = 'CSRCRPTR'
AND ct.code IN ('FC','PF','PP','VL');

--Un end date code FC in CRELVICT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL, ct.decode = 'First Cousin Once Removed'
WHERE ct.code_type = 'CRELVICT'
AND ct.code = 'FC';

--Add Code FA to CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
 VALUES ('CRELVICT','FA','Foster Parent (CPA/CCI)');

--Add Code FA to CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
 VALUES ('CRPTRINT','FA','Foster Parent (CPA/CCI)');

--Add Code G2 to CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE)
 VALUES ('CRELVICT','G2','Great Grandparent');

--Add Code G3 to CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','G3','Great Great Grandparent');

--Add Code G4 to CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) VALUES 
('CRELVICT','G4','Great Great Great Grandparent');

--Add Code GN to CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) VALUES 
('CRELVICT','GN','Great Niece');

--Update code GP to Grandparent' in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.decode = 'Grandparent'
WHERE ct.code_type = 'CRPTRINT'
AND ct.code = 'GP';

--Add Code GR and decode Guidance Counselor' to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','GR','Guidance Counselor');

--Add Code GR and decode Guidance Counselor' to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','GR','Guidance Counselor');

--Add Code GS and decode Step-grandparent to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','GS','Step-grandparent');

--Add Code GW and decode Great Nephew to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','GW','Great Nephew');

--Add code HS and decode Half Sibling' to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','HS','Half Sibling');

--Add Code JD and decode Judge to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','JD','Judge');


--Un end date code LA, MH, OS, PB, SA, SF, SG, VC in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL
WHERE ct.code_type = 'CRPTRINT'
AND ct.code IN ('LA','MH','OS','PB','SA','SF','SG','VC');

--Add code LM and decode Legal Mother to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','LM','Legal Mother');

--Add code LM and decode Legal Mother to 'CSRCRPTR'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CSRCRPTR','LM','Legal Mother');

--Add code N2 and decode Great Great Niece to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','N2','Great Great Niece');

--Add Code NC and decode Non-Custodial Parent to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','NC','Non-Custodial Parent');

--Add code NM and decode Other Non-Mandated to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','NM','Other Non-Mandated');

--Add code NS and decode Non parent spouse to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','NS','Non parent spouse');

--Add code OP and decode Other non-related person to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','OP','Other non-related person');

--Add code OP and decode Other non-related person to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','OP','Other non-related person');

--Add code OR and decode Other Relative to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','OR','Other Relative');

--Add code OR and decode Other Relative to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','OR','Other Relative');

--Add code OU and decode Other/Unknown to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','OU','Other/Unknown');

--Add code OU and decode Other/Unknown to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','OU','Other/Unknown');

--Update code PB in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.decode = 'Parole/Probtn Ofcr'
WHERE ct.code_type = 'CRPTRINT'
AND ct.code = 'PB';

--Un end date code PF in CRELVICT'
UPDATE caps.codes_tables ct
SET ct.dt_end = NULL, DECODE = 'Putative Father'
WHERE ct.code_type = 'CRELVICT'
AND ct.code = 'PF';

--End date code PM in CSRCRPTR'
UPDATE caps.codes_tables ct
SET ct.dt_end = SYSDATE
WHERE ct.code_type = 'CSRCRPTR'
AND ct.code = 'PM';

--Update code PO in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.decode = 'Parole/Probtn Ofcr./DJJ Ofcr'
WHERE code_type = 'CRPTRINT'
AND ct.code = 'PO';

--Add code RD and decode Residential Facility Staff (DFCS) to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','RD','Residential Facility Staff (DFCS)');

--Add code RD and decode Residential Facility Staff (DFCS) to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','RD','Residential Facility Staff (DFCS)');

--Add code RN and decode Residential Facility Staff (Non DFCS) to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','RN','Residential Facility Staff (Non DFCS)');

--Add code RN and decode Residential Facility Staff (Non DFCS) to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','RN','Residential Facility Staff (Non DFCS)');

--Update code SF in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.decode = 'DHR Staff'
WHERE ct.code_type = 'CRPTRINT'
AND ct.code = 'SF';

--Update code SG in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.decode = 'SAAG'
WHERE ct.code_type = 'CRPTRINT'
AND ct.code = 'SG';

--Add code SM and decode Self/Minor Parent to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','SM','Self/Minor Parent');

--Add code VL and decode Volunteer to 'CRPTRINT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRPTRINT','VL','Volunteer');

--Add code W2 and decode Great Great Nephew to 'CRELVICT'
INSERT INTO caps.codes_tables ct (CODE_TYPE, CODE, DECODE) 
VALUES ('CRELVICT','W2','Great Great Nephew');

--Update code XX in CRPTRINT'
UPDATE caps.codes_tables ct
SET ct.decode = 'Other'
WHERE ct.code_type = 'CRPTRINT'
AND ct.code = 'XX';

-- change STGAP00004101
UPDATE caps.error_list SET cd_task='9105' WHERE nbr_message=8201 AND txt_stage_cd='PAD';

-- change STGAP00004124
UPDATE caps.Message SET txt_message = 'Please enter County, Effective Date, UAS Program, Entitlement Code, and Payment County.' WHERE id_message = 17145;

-- change STGAP00004136
UPDATE caps.TASK SET txt_event_detail_url='/workload/StageClosure/displayServiceDlvryClosure', txt_task_decode='Close CPS Ongoing Stage' WHERE cd_task='7010';
UPDATE caps.TASK SET txt_event_detail_url='/workload/StageClosure/displayServiceDlvryClosure' WHERE cd_task='7160';

DELETE FROM caps.metaphor WHERE id_tab=320;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (212, 'SacwisRev2', 'static updates');
commit;
