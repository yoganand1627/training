--STGAP00016107 - Release(4.2) MR-075 Add new field

--add new column
ALTER TABLE CAPS.CAPS_RESOURCE
ADD (
      IND_HOLD_PLACEMENTS VARCHAR2(1)
);

COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_HOLD_PLACEMENTS IS 'Indicator to put home on a hold placements status that would set resource status as inactive on approval.';

-- new column for resource_history
ALTER TABLE CAPS.RESOURCE_HISTORY
ADD (
      IND_HOLD_PLACEMENTS VARCHAR2(1)
);

COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_HOLD_PLACEMENTS IS 'Indicator to put home on a hold placements status that would set resource status as inactive on approval.';

-- new column for resource_history_audit
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT
ADD (
      IND_HOLD_PLACEMENTS VARCHAR2(1)
);

COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_HOLD_PLACEMENTS IS 'Indicator to put home on a hold placements status that would set resource status as inactive on approval.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (991, 'SacwisRev4', 'Release 4.2 - DBCR 16107');

commit;

