--STGAP00013810 - DBCR MR-50 Codestable

--Note:  no impact to ado conversion


update caps.codes_tables set dt_end = sysdate where code_type = 'CSUBCLOS' and code = 'AR';

update caps.codes_tables set decode = 'Parent legal or financial support cannot be established'
where code_type = 'CSUBCLOS' and code = 'PF';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES('CSUBCLOS','CT','Child Turns 18 and not eligible for continued AA',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES('CSUBCLOS','CL','Child Enlists in Military',SYSDATE);



--STGAP00013837 - MR-50 DBCR Adoption Assitance Agreement Message Up

--Note:   no impact on ado conversion


update caps.message set txt_message = 'Adding this Non-Recurring Expenses will take the child over the spending limit of $%s' where txt_message_name = 'MSG_NON_RECURRING_LIMIT';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (470, 'SacwisRev3', 'Release 3.1 - DBCRs 13810,13837');

commit;


