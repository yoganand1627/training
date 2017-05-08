--STGAP00015914 - Release(3.6) MR-66: Update Messages and codestables

-- Allegation Detail(Inv)
update caps.codes_tables set decode = 'Victim''s Home (Non-Foster Home)' Where code_type = 'CLOCMALT' and code = '001';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMALT' and code = '003';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMALT' and code = '004';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMALT' and code = '005';
update caps.codes_tables set dt_end = sysdate Where code_type = 'CLOCMALT' and code = '006';
update caps.codes_tables set decode = 'F/A Home-DFCS' Where code_type = 'CLOCMALT' and code = '007';
update caps.codes_tables set decode = 'F/A Home-Non DFCS (CPA)' Where code_type = 'CLOCMALT' and code = '008';
update caps.codes_tables set decode = 'Residential Facility (CCI)' Where code_type = 'CLOCMALT' and code = '011';
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMALT', '012', 'Relative Placement Home (Not Relative F/A Home)');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMALT', '013', 'Non-Residential Facility (Includes Daycare)');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMALT', '014', 'Granny House');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMALT', '015', 'Military Base');
INSERT INTO caps.codes_tables(code_type, code, decode) values('CLOCMALT', '016', 'Non-Relative Placement Home (Not F/A Home)');

--Updates on 5/28/2010
update caps.codes_tables set decode = 'Relative Placement Home (Not Relative F/A Home)' Where code_type = 'CLOCMAL' and code = '012';
update caps.codes_tables set decode = 'Joint Comm. on Accred. for Healthcare Org.' Where code_type = 'CERTIFBY' and code = 'JA';

--Updates on 6/03/2010
update caps.message set txt_message = 'There may be possible duplicates of the home you are trying to add. Please click Ok if all possible duplicates have been ruled out or click Cancel and do a F/A Home search by partial Home Name and narrow the search by including Region or City or Category or Region and County.' where txt_message_name = 'MSG_FAD_DUPLICATE_NOT_ALLOWED';
update caps.message set txt_message = 'The system has determined a Maltreatment in care situation based on Alleged Incident Date recorded on the Allegation Detail page and a child''s ''In Custody'' Legal Status. Selection for the Special Investigation Call Type and Placement/Non-Placement Provider Information sections are required.' where txt_message_name = 'MSG_INT_SPCL_INV_PLACEMENT_REQ';
update caps.message set txt_message = 'There may be possible duplicates of the person you are trying to add. Please click Ok if all possible duplicates have been ruled out or click Cancel and do a Phonetic Person search by Last name and narrow the search by including First Name or Date of Birth or SSN or combination of all.' where txt_message_name = 'MSG_DUPLICATE_NOT_ALLOWED';
update caps.codes_tables set dt_end = null Where code_type = 'CSPECREQ' and code = 'BD';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (837, 'SacwisRev3', 'Release 3.6 - DBCR 15914');

commit;


