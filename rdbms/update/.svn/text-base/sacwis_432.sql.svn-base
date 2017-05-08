--STGAP00012395  Need a new temp table for Exchange Child Search

CREATE TABLE CAPS.TEMP_CHILD_SEARCH_RESULTS
(
  ID_EVENT             NUMBER,
  ID_EVENT_STAGE       NUMBER,
  ID_PERSON            NUMBER,
  NM_PERSON_FULL       VARCHAR2(25),
  NM_PERSON_FIRST      VARCHAR2(12),
  NM_PERSON_LAST       VARCHAR2(22),
  DT_PERSON_BIRTH      DATE,
  CD_PERSON_SEX        VARCHAR2(1),
  ID_SIBLING_GROUP     NUMBER,
  CD_NON_AVAIL_STATUS  VARCHAR2(2),
  CD_LEGAL_STAT_CNTY   VARCHAR2(3),
  DT_OUT               DATE,
  NBR_IN_GROUP         NUMBER,
  SEQ_SESSION_ID       NUMBER
) tablespace data01;

grant select,update,insert,delete on CAPS.TEMP_CHILD_SEARCH_RESULTS to capson,capsbat,ops$datafix;
grant select on CAPS.TEMP_CHILD_SEARCH_RESULTS to operator;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (433, 'SacwisRev3', 'Release 3.0 - DBCRs STGAP00012395');

commit;
