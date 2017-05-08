--STGAP00015990 - Release(4.0) Remove 'Maintain Service Auth' from SHINES_STAFF

-- This turns off SHINES_STAFF's ability to maintain service authorizations
-- that do not belong to the user
update caps.security_class
set txt_security_class_profil='1010101101111001000000111111101111111111111111111111111111001111111111111111111111110100000000000'
where cd_security_class_name='SHINES_STAFF'
;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (894, 'SacwisRev4', 'Release 4.0 - DBCR 15990');

commit;

