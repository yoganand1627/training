--STGAP00016188 - Release(4.3) Update message for MIC -Defect #112542

--CAPTA 4.3 - Updating messages

update caps.message
set txt_message = '''Where did the Maltreatment occur?'' selection indicates a candidate for a Special Investigation Call Type that may require a Placement/Non-Placement Provider. Click ''Cancel'' to go back and complete the Special Investigation and the Placement/Non-Placement Provider sections. Click ''Ok'' to Save and Submit'
where txt_message_name = 'MSG_INT_ALLEG_LOC_MAL_SPCL_INV';


update caps.message
set txt_message = 'The Date of Alleged Incident and Alleged Maltreator Relationship provided indicate a Maltreatment in Care situation, according to the Legal Status of the child.  Please verify the allegation occurred while the child was in care.'
where txt_message_name = 'MSG_ALLEG_DT_MALTREAT_IN_CARE';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1048, 'SacwisRev4', 'Release 4.3 - DBCR 16188');

commit;

