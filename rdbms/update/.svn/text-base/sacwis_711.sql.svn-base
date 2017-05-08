--STGAP00015741 - Release(3.42) MR-60 New Column for non incident AFCARS

ALTER TABLE CAPS.NON_INCIDENT_AFCARS_INFO
ADD CD_SPC_NDS_CHAR_PRE_POS VARCHAR2(3);

comment on column caps.NON_INCIDENT_AFCARS_INFO.CD_SPC_NDS_CHAR_PRE_POS  is 'Indicates whether Pre March 1, 2010 or Post March 1, 2010 is selected for the Primary Special Needs Types';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (712, 'SacwisRev3', 'Release 3.42 - DBCR 15741');

commit;

