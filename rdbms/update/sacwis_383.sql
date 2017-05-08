--STGAP00010197 - Person Id and Sibling Group Id in the Sibling

alter table caps.sibling modify id_sibling_group not null;
alter table caps.sibling modify id_person not null;
alter table caps.sibling add constraint FK_SIBLING_SIB_GRP FOREIGN KEY (ID_SIBLING_GROUP)
references CAPS.SIBLING_GROUP(ID_SIBLING_GROUP) ;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (384, 'SacwisRev3', 'Release 3.0 - DBCR 10197');

commit;


