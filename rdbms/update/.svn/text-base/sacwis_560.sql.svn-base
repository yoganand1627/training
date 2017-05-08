--STGAP00015483 - MR-056 Add and delete column

alter table caps.person_dtl drop column ind_pk_hshd_member;

alter table caps.stage_person_link add CD_PK_HSHD_MEMBER varchar2(3);
comment on column caps.stage_person_link.CD_PK_HSHD_MEMBER is 'Member of Primary Caretaker''s Household' ;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (561, 'SacwisRev3', 'Release 3.3 - DBCR 15483');

commit;
