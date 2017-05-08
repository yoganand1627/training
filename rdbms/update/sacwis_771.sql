--STGAP00015828 - Release(3.43) MR-62: Add column to Contact_Rule- drop constraint

ALTER TABLE CAPS.CONTACT_RULE ADD (CD_UNKNOWN_PARENT Varchar2(2));

comment on column CAPS.CONTACT_RULE.CD_UNKNOWN_PARENT is 'Code indicating if the unknown person is an unknown mother or an unknown father' ;

alter table caps.CONTACT_RULE MODIFY ID_PERSON NULL;

INSERT INTO CAPS.CODES_TABLES VALUES('CUNPRENT', 'UF', 'Unknown Father', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CUNPRENT', 'UM', 'Unknown Mother', NULL, SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (772, 'SacwisRev3', 'Release 3.43 - DBCR 15828');

commit;



