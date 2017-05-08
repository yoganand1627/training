--STGAP00017407 - Release(5.0) ECEM 5.0: Update message per design change

-- update message per design change
update caps.message
set txt_message = 'Entitlement Code cannot be ''99'' when the service type is Foster Care, Relative Care or Adoption and it is not indicated that the Program Code is an Invoice Add On.'
where txt_message_name = 'MSG_ERR_ENT_CD_99';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1153, 'SacwisRev5', 'Release 5.0 - DBCR 17407');

commit;

