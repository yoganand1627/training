--STGAP00015595 - Release(3.4) MR-057: Add new columns  to PLACEMENT table

ALTER TABLE
    CAPS.PLACEMENT
ADD
   (
      DT_LTFC_AGREEMENT_SIGNED       DATE,
      IND_CHILD_CONNECT_ADULT        VARCHAR2 (1),
      ID_PERSON_CONNECTED_ADULT      NUMBER (16),
          CONSTRAINT FK_CONNECTED_ADULT FOREIGN KEY (ID_PERSON_CONNECTED_ADULT)
    REFERENCES CAPS.PERSON(ID_PERSON) ENABLE
   );

comment on column caps.placement.DT_LTFC_AGREEMENT_SIGNED is 'Date the Long Term Foster Care Placement Agreement signed.';
comment on column caps.placement.IND_CHILD_CONNECT_ADULT is 'Indicates whether placed child has connected with an adult.';
comment on column caps.placement.ID_PERSON_CONNECTED_ADULT is 'The Person ID of the Connected adult to the child.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (607, 'SacwisRev3', 'Release 3.4 - DBCR 15595');

commit;

