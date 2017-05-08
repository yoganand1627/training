-- STGAP00012407 - Need a new Sequnce on SEQ_TEMP_CHILD_SEARCH_RESULT

CREATE SEQUENCE CAPS.SEQ_TEMP_CHILD_SEARCH_RESULTS
  START WITH 21
  MAXVALUE 1000
  MINVALUE 1
  CYCLE
  CACHE 20
  ORDER;


GRANT SELECT ON  CAPS.SEQ_TEMP_CHILD_SEARCH_RESULTS TO CAPSBAT,CAPSON,OPS$DATAFIX;


--STGAP00012391 - Need Codes Table value for Placement Type

--Note:  new type to support ado conversion

--Need new Placement Type value to enable conversion process  record Medicaid only Adoptive placements.


INSERT ALL when not exists(select 'x' from caps.codes_tables
where code_type='CPLMNTYP' and code='OTA') then
into  caps.codes_tables select 'CPLMNTYP', 'OTA', 'Other Adoptive Home',null a, null b from dual;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (434, 'SacwisRev3', 'Release 3.0 - DBCRs 12391,12407');

commit;



