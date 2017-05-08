-- change STGAP00004284
UPDATE CAPS.CODES_TABLES SET DECODE='Home/Other Facility' WHERE CODE='06' AND CODE_TYPE='CRSCTYPE';

-- change STGAP00004306
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60357, 'MSG_EMP_NOT_ASSIGNABLE', 'Selected employee has a job description that is not Case Assignable.', '600', '740', 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (216, 'SacwisRev2', 'static updates');
commit;
