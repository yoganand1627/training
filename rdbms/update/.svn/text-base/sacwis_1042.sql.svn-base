--STGAP00016182 - Release(4.3) CAPTA-Update New Security Attributes and Profiles

-- STGAP00016182
-- This DBCR needs to be executed to correct a previous DBCR STGAP00016164
--
-- SMS #109631: CAPTA 4.3 Per CAPTA team's decision, the new security attribute,
-- SEC_POLICY_UNIT, is not needed any more. Therefore, tables updated
-- by DBCR STGAP00016164 need to have the original size (100) for TXT_SECURITY_CLASS_PROFIL
-- and corresponding rows in the codes_tables and security_class table
-- need to be adjusted

-- Add New Security Attributes and Profiles
-- 1.   New Profile: Deputy Director (with new attribute of "Deputy Director")
-- 2.   New Profile: Policy Unit (with new attribute of "Policy Unit")
-- 3.   New Attribute: Modify Safety Resource (add this to the "County Management" profile)
-- 4.   ADD A 1 VALUE FOR THE NEW ATTRIBUTE TO BOTH OF THE NEW PROFILES, 0 VALUE FOR ALL OTHER EXISTING PROFILES.

-- Remove all trailing '0's from the all rows in the security_class.TXT_SECURITY_CLASS_PROFIL
-- so TXT_SECURITY_CLASS_PROFIL only holds 100 instead of 101 slots added by STGAP00016164
update caps.security_class
set txt_security_class_profil = substr(txt_security_class_profil, 1, 100)
where length(txt_security_class_profil) > 100;

-- Turn on the location of 100 instead of 101 for the Modify Safety Resource in the COUNTY_MGMNT profile
-- (This move needs to be done due to the removal of POLICY_UNIT)
update caps.security_class
set txt_security_class_profil = substr(txt_security_class_profil, 1, 99) || '1'
where cd_security_class_name = 'COUNTY_MGMNT';

-- Remove new profile POLICY_UNIT that was added by STGAP00016164
delete from caps.security_class
where cd_security_class_name = 'POLICY_UNIT';



-- Restore TXT_SECURITY_CLASS_PROFIL field size
-- from 200 to 100 in SECURITY_CLASS table
-- NOTE: Per discussion with Van, TXT_SECURITY_CLASS_PROFIL field in the SECURITY_CLASS_AUDIT table
-- will not be reverted to hold the history from the previous update by STGAP00016164
alter table caps.security_class
modify TXT_SECURITY_CLASS_PROFIL varchar2(100);

-- Updated CODES_TABLES
-- 1. Remove new profile POLICY_UNIT that was added by STGAP00016164
delete from caps.codes_tables
where code_type = 'CSECATTR'
and code = 'PR' and decode = 'Policy Unit';
-- 2. Update code of 'Modify Safety Resource' from 'PS' to 'PR'
update caps.codes_tables
set code = 'PR'
where code_type = 'CSECATTR'
and decode = 'Modify Safety Resource';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1043, 'SacwisRev4', 'Release 4.3 - DBCR 16182');

commit;

