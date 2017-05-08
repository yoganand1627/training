--STGAP00017740 - Release(5.0) Increase Data Type size for Table

alter table
   CAPS.portal_security_class
modify
(
   txt_security_class_profil   varchar2(200)
);

alter table
   caps.portal_security_class_audit
modify
(
   txt_security_class_profil   varchar2(200)
);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1172, 'SacwisRev5', 'Release 5.0 - DBCR 17740');
