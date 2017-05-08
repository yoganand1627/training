--STGAP00018010 - Release(5.1) DBCR: Update and correct Child Death message

update caps.message set txt_message = 'One or more children associated to an allegation with a severity of Child Death do not have an entered Date of Death.  Enter Date of Death and Reason for Death on Person Detail before closing the stage.' where txt_message_name = 'MSG_INV_CD_ALLEG_DOD_REQ';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1212, 'SacwisRev5', 'Release 5.1 - DBCR 18010');

commit;
