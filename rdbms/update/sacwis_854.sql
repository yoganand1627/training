--STGAP00015938 - Release(3.6) MR-066 Change to codes table

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CSPECREQ', 'CDNC', 'Child Death-Not in Care');

update caps.codes_tables set decode = 'Child Death', codes_tables.DT_END = sysdate where code = 'CD' and code_type = 'CSPECREQ';

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CSPECREQ', 'NFNC', 'Near Fatality-Not in Care');

update caps.codes_tables set decode = 'Near Fatality' , codes_tables.DT_END = sysdate where code = 'NF' and code_type = 'CSPECREQ';

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CSPECREQ', 'SINC', 'Serious Injury-Not in Care');

update caps.codes_tables set decode = 'Serious Injury' , codes_tables.DT_END = sysdate where code = 'SI' and code_type = 'CSPECREQ';

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMAL', '017', 'Victim''s Home (Non-Foster Home)');

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMAL', '018', 'F/A Home-DFCS');

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMAL', '019', 'F/A Home-Non DFCS (CPA)');

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMAL', '020', 'Residential Facility (CCI)');

update caps.codes_tables set decode = 'Victim''s Home' , codes_tables.DT_END = sysdate where code = '001' and code_type = 'CLOCMAL';

update caps.codes_tables set decode = 'Family Foster Home-DFCS' , codes_tables.DT_END = sysdate where code = '007' and code_type = 'CLOCMAL';

update caps.codes_tables set decode = 'Family Foster Home-Non DFCS' , codes_tables.DT_END = sysdate where code = '008' and code_type = 'CLOCMAL';

update caps.codes_tables set decode = 'Residential Treatment Facility' , codes_tables.DT_END = sysdate where code = '011' and code_type = 'CLOCMAL';

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMALT', '017', 'Victim''s Home (Non-Foster Home)');

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMALT', '018', 'F/A Home-DFCS');

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMALT', '019', 'F/A Home-Non DFCS (CPA)');

INSERT INTO caps.codes_tables
(code_type, code, decode )
values('CLOCMALT', '020', 'Residential Facility (CCI)');

update caps.codes_tables set decode = 'Victim''s Home' , codes_tables.DT_END = sysdate where code = '001' and code_type = 'CLOCMALT';

update caps.codes_tables set decode = 'Family Foster Home-DFCS' , codes_tables.DT_END = sysdate where code = '007' and code_type = 'CLOCMALT';

update caps.codes_tables set decode = 'Family Foster Home-Non DFCS' , codes_tables.DT_END = sysdate where code = '008' and code_type = 'CLOCMALT';

update caps.codes_tables set decode = 'Residential Treatment Facility' , codes_tables.DT_END = sysdate where code = '011' and code_type = 'CLOCMALT';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (855, 'SacwisRev3', 'Release 3.6 - DBCR 15938');

commit;


