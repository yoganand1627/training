--STGAP00016196 - Release(4.3) CAPTA-4.3:Fix message and Codestables

--06/27/2011
update caps.message set txt_message = 'A secondary approval is required. Your approval will be recorded once the Save button is pressed'
where txt_message_name = 'MSG_CMN_AUTO_ADD_APRVR';

update caps.codes_tables set decode = 'The foster parent''s spouse was not interviewed during the investigation.' where code_type = 'CPUNOCR' and code = 'NCK';

update caps.codes_tables set decode = 'The interview with the child was not conducted separately and in private, away from the caregiver and other household members.' where code_type = 'CPUNOCR' and code = 'NCG';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1052, 'SacwisRev4', 'Release 4.3 - DBCR 16196');

commit;


