--STGAP00015591 - Release(Undetermined) Insert metaphor row and drop constraint

--Need to drop a constraint
alter table caps.PORTAL_USER_VENDOR_LINK DROP Constraint UK1_USER_VENDOR_LINK;

INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB) 
VALUES ('180', '/admin/VendorStaffDetail/displayPendingVendorStaffDetail', 'PENDING_STAFF_DETAIL', 'Pending Staff Detail');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (608, 'SacwisRev3', 'Release Undetermined - DBCR 15591');

commit;

