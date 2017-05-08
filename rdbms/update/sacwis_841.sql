--STGAP00015923 - Release(3.6) MR-66: Update duplicate allegation messages

--Updates on 6/09/2010
update caps.message set txt_message = 'Duplicate Record Exists. You must modify either Alleged Maltreated Child, Maltreatment Type, Maltreatment Code or Alleged Maltreator Relashionship in order to save this Allegation.' where txt_message_name = 'MSG_INT_MOD_ALLG';
update caps.message set txt_message = 'Your data has been saved. To save a new Allegation, modify either Alleged Maltreated Child, Maltreatment Type, Maltreatment Code or Alleged Maltreator Relashionship and click Add or Continue.' where txt_message_name = 'MSG_INT_ALLG_ADD';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (842, 'SacwisRev3', 'Release 3.6 - DBCR 15923');

commit;

