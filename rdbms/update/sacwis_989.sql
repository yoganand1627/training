--STGAP00016106 - Release(4.2) MR-075 Column name change

-- columns name change for resource
alter table CAPS.CAPS_RESOURCE rename column IND_IVE_REIMBURSABLE to IND_HOME_IVE_REIMBURSABLE;

COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_HOME_IVE_REIMBURSABLE IS 'Indicate whether home is IV-E Reimbursable.';


-- columns name change for resource_history
ALTER TABLE CAPS.RESOURCE_HISTORY rename column IND_IVE_REIMBURSABLE to IND_HOME_IVE_REIMBURSABLE;

COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_HOME_IVE_REIMBURSABLE IS 'Indicate whether home is IV-E Reimbursable.';


-- columns name change for resource_history_audit
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT rename column IND_IVE_REIMBURSABLE to IND_HOME_IVE_REIMBURSABLE;

COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_HOME_IVE_REIMBURSABLE IS 'Indicate whether home is IV-E Reimbursable.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (990, 'SacwisRev4', 'Release 4.2 - DBCR 16106');

commit;


