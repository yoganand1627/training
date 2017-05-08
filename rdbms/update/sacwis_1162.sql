--STGAP00017594 - Release(5.0) Create new placement columns for certified resourc

ALTER TABLE caps.placement ADD (NM_CASE_MNGR_RSRC VARCHAR (30));

ALTER TABLE caps.placement ADD (NM_SUP_RSRC VARCHAR (30));

ALTER TABLE caps.placement ADD (ID_CASE_MNGR_RSRC NUMBER (16, 0));

ALTER TABLE caps.placement ADD (ID_SUP_RSRC NUMBER (16, 0));

ALTER TABLE CAPS.PLACEMENT ADD
      CONSTRAINT FK_ID_CASE_MNGR_RSRC
      FOREIGN KEY (ID_CASE_MNGR_RSRC)
      REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE);

ALTER TABLE CAPS.PLACEMENT ADD
      CONSTRAINT FK_ID_SUP_RSRC
      FOREIGN KEY (ID_SUP_RSRC)
      REFERENCES CAPS.CAPS_RESOURCE(ID_RESOURCE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1163, 'SacwisRev5', 'Release 5.0 - DBCR 17594');

commit;
