--STGAP00016164 - Release(4.3) CAPTA - Add New Security Attributes and Profiles

-- STGAP00016164
-- Add New Security Attributes and Profiles
-- 1.   New Profile: Deputy Director (with new attribute of "Deputy Director")
-- 2.   New Profile: Policy Unit (with new attribute of "Policy Unit")
-- 3.   New Attribute: Modify Safety Resource (add this to the "County Management" profile)
-- 4.   ADD A 1 VALUE FOR THE NEW ATTRIBUTE TO BOTH OF THE NEW PROFILES, 0 VALUE FOR ALL OTHER EXISTING PROFILES.

-- Increase TXT_SECURITY_CLASS_PROFIL field size
-- from 100 to 200 for both in SECURITY_CLASS
-- and SECURITY_CLASS_AUDIT (for trigger) tables
alter table caps.security_class
modify TXT_SECURITY_CLASS_PROFIL varchar2(200);
alter table caps.SECURITY_CLASS_AUDIT
modify TXT_SECURITY_CLASS_PROFIL varchar2(200);

-- new attributes, displayed as the last one on the page
insert into CAPS.codes_tables
values('CSECATTR', 'PQ', 'Deputy Director', null, sysdate);
insert into CAPS.codes_tables
values('CSECATTR', 'PR', 'Policy Unit', null, sysdate);
insert into CAPS.codes_tables
VALUES('CSECATTR', 'PS', 'Modify Safety Resource', NULL, SYSDATE);

-- add new profiles, defaulted to the new attributes
insert into CAPS.security_class
values ('DEPUTY_DIRECTOR', sysdate
, '00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100'
, 'N', NVL((SELECT id_person FROM caps.employee where id_person = 5607560), 2071));
insert into CAPS.security_class
values ('POLICY_UNIT', sysdate
, '00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010'
, 'N', NVL((SELECT id_person FROM caps.employee where id_person = 5607560), 2071));

-- turn on Modify Safety Resource attirbute to the COUNTY_MGMNT profile
update CAPS.security_class
set txt_security_class_profil = txt_security_class_profil || '001'
where cd_security_class_name = 'COUNTY_MGMNT';

-- update all existing profile with the new attribute position
update CAPS.security_class
set txt_security_class_profil = txt_security_class_profil || '000'
where cd_security_class_name <> 'DEPUTY_DIRECTOR'
and cd_security_class_name <> 'POLICY_UNIT'
and cd_security_class_name <> 'COUNTY_MGMNT';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1031, 'SacwisRev4', 'Release 4.3 - DBCR 16164');

commit;

