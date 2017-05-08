--STGAP00014920 - Update EXT_DOCUMENTATION and EXT_DOC_PERSON_LINK

comment on column caps.EXT_DOCUMENTATION.CD_DOC_CLASS  is 'Captures document class' ;

comment on column caps.EXT_DOCUMENTATION.DT_EXT_DOC_ADDED  is 'Inserts sysdate at the time of the first save of the page';

ALTER table CAPS.EXT_DOC_PERSON_LINK
ADD CONSTRAINT FK_ID_PERSON  FOREIGN KEY (ID_PERSON)
REFERENCES caps.PERSON(ID_PERSON);

ALTER table CAPS.EXT_DOC_PERSON_LINK
ADD CONSTRAINT FK_ID_EXT_DOCUMENTATION FOREIGN KEY (ID_EXT_DOCUMENTATION)
REFERENCES caps.EXT_DOCUMENTATION(ID_EXT_DOCUMENTATION);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (507, 'SacwisRev3', 'Release 3.2 - DBCR 14920');

commit;


