--STGAP00016033 - Release(4.1) MR-074 AFCARS Phase 1 New Profile Permanency Unit

--- NEW SECURITY PROFILE FOR DELETE A NAF, and possibly maintain LS + modify Pla
-- new attribute, displayed as the last one on the page
insert into caps.codes_tables
values('CSECATTR', 'PP', 'Delete Adoption Finalized Legal Status', null, sysdate);
-- update all existing profile with the new attribute position
update caps.security_class
set txt_security_class_profil = txt_security_class_profil || '0';
-- add new profile, defaulted to the new attribute
insert into caps.security_class
values ('PERMANENCY_UNIT', sysdate
, '00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001'
, 'N'
, NVL((SELECT id_person FROM caps.employee where id_person = 5607560), 2071));
-- turn on Maintain Legal Status (15) and Modify Approved Placement (86) attributes for the new profile
update caps.security_class
set txt_security_class_profil = substr(txt_security_class_profil, 1, 15) || '1' || substr(txt_security_class_profil, 17)
where CD_SECURITY_CLASS_NAME = 'PERMANENCY_UNIT';

update caps.security_class
set txt_security_class_profil = substr(txt_security_class_profil, 1, 86) || '1' || substr(txt_security_class_profil, 88)
where CD_SECURITY_CLASS_NAME = 'PERMANENCY_UNIT';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (926, 'SacwisRev4', 'Release 4.1 - DBCR 16033');

commit;

