--STGAP00017018 - Release(5.0) Creating new security class and increasing buffer

-- Increase TXT_SECURITY_CLASS_PROFIL field size
-- from 100 to 200 for both SECURITY_CLASS
-- and SECURITY_CLASS_AUDIT tables
alter table caps.security_class
modify TXT_SECURITY_CLASS_PROFIL varchar2(200);
alter table caps.SECURITY_CLASS_AUDIT
modify TXT_SECURITY_CLASS_PROFIL varchar2(200);


-- create new security attribute for fiscal operations
insert into CAPS.codes_tables
values('CSECATTR', 'PT', 'Update Contract Period', null, sysdate);
insert into CAPS.codes_tables
values('CSECATTR', 'PU', 'Update Vendor ID', null, sysdate);


-- add new profiles, defaulted to the new attributes
insert into CAPS.security_class
values ('FISC_OPS_MAINT', sysdate
, '00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000'
, 'N', NVL((SELECT id_person FROM caps.employee where id_person = 5607560), 2071));



-- update all existing profiles with the new attribute position
update CAPS.security_class
set txt_security_class_profil = rtrim(txt_security_class_profil) || '0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000'
where cd_security_class_name <> 'FISC_OPS_MAINT';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1068, 'SacwisRev5', 'Release 5.0 - DBCR 17018');

commit;

