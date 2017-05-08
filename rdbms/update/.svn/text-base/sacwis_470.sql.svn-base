--STGAP00013891 - MR-50 Add Tiltle to the Type Class Codes table

--Note:   no impact ado conversion

UPDATE CAPS.CODES_TABLES SET DECODE = 'Title IV-E Medicaid Only (GA Child)' WHERE CODE = '26' AND CODE_TYPE = 'CSUBTYPE';


--STGAP00013904 - Update CODES_TABLE decode for CODE = 'TCS' AND 'CSPLSERV'

--Note:   no impact to ado conversion


UPDATE CAPS.CODES_TABLES SET DECODE = 'Therapy/Counseling (UAS 512 Entitlement Code 58b)' WHERE CODE = 'TCS' AND CODE_TYPE = 'CSPLSERV';


--STGAP00013903 - Correct invalid characters in static tables

update caps.codes_tables set decode=replace(decode,chr(191)) where
rtrim(decode) like '%'||chr(191);

update caps.codes_tables set decode=replace(decode,' '||chr(191)||' ',' - ') where
instr(decode,' '||chr(191)||' ') <> 0;

update caps.codes_tables set decode=replace(decode,chr(191),chr(39)) where
instr(decode,chr(191)) <> 0;

update caps.codes_tables set decode='Violent' where decode like chr(39)||'Violent';

update caps.message set txt_message=replace(txt_message,chr(191))
where rtrim(txt_message) like '%'||chr(191);

update caps.message set txt_message=replace(txt_message,chr(191),chr(39))
where instr(txt_message,chr(191)) <> 0;

update caps.message set txt_message_name=replace(txt_message_name,chr(191))
where rtrim(txt_message_name) like '%'||chr(191);

update caps.risk_factors_lookup
set AREA_CONCERN_TXT=replace(AREA_CONCERN_TXT,chr(191),chr(39))
where instr(AREA_CONCERN_TXT,chr(191)) <> 0;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (471, 'SacwisRev3', 'Release 3.1 - DBCRs 13891,13904,13903');

commit;

