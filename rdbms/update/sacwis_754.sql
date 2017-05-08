--STGAP00015803 - Release(3.43) MR-62: Add Parental Role column

ALTER TABLE caps.PARENT_CONTACT_RULE MODIFY (CD_CONTACT_NOT_REQUIRED varchar2(3));
ALTER TABLE caps.PARENT_CONTACT_RULE ADD (CD_PARENTAL_ROLE Varchar2(3));

comment on column CAPS.PARENT_CONTACT_RULE.CD_PARENTAL_ROLE is 'Records the code for the parental role of the person to the child' ;
comment on column CAPS.PPT.ID_CONTACT_STDS_EVENT is 'Records contact standards event id. Foreign key to CONTACT_STANDARDS.ID_CONTACT_STDS_EVENT' ;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (755, 'SacwisRev3', 'Release 3.43 - DBCR 15803');

commit;

