--STGAP00015574 - Release(N/A) DBCR: Populate PORTAL_METAPHOR

--This dbcr inserts the rows required to support the Portal Metaphor for the 3.4 release.

--Note that the script deletes then adds to clear any test rows in the various databases.

DELETE FROM CAPS.PORTAL_METAPHOR;
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_L1_IMG_INACTIVE, TXT_L1_IMG_ACTIVE) VALUES (10,'/workload/PortalChildList/displayChildListAll','MY_TASKS_CHILD_LIST','My Tasks','Tb_MyTasks_0.gif','Tb_MyTasks_1.gif');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_L1_IMG_INACTIVE, TXT_L1_IMG_ACTIVE) VALUES (20,'/workload/PortalChildList/displayChildListAll','CASE','Case','Tb_Case_0.gif','Tb_Case_1.gif');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_L1_IMG_INACTIVE, TXT_L1_IMG_ACTIVE) VALUES (30,'/admin/VendorStaffList/displayVendorStaffList','ADMIN','Admin','Tb_Admin_0.gif','Tb_Admin_1.gif');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (100,'/workload/PortalChildList/displayChildListAll','CHILD_LIST_ALL','Children In Care');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (110,'/resource/FacAgencyHomesList/displayFacAgencyList','FAC_AGENCY_LIST','Facilities/Agencies');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (120,'/workload/PortalChildList/displayChildList','CHILD_LIST_SPECIFIC','Children List');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (130,'/resource/FacAgencyHomesList/displayHomesList','HOMES_LIST','Homes List');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (140,'/person/PortalChildDetail/displayPortalChildDetail','PORTAL_CHILD_DETAIL','Portal Child Detail');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (150,'/admin/VendorStaffList/displayVendorStaffList','STAFF_LIST','Staff List');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (160,'/admin/VendorStaffList/displayPendingVendorStaffList','PENDING_STAFF_LIST','Pending Staff List');
INSERT INTO CAPS.PORTAL_METAPHOR (ID_TAB, TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB) VALUES (170,'/admin/VendorStaffDetail/displayVendorStaffDetail','VENDOR_STAFF_DETAIL','Staff Detail');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (597, 'SacwisRev3', 'Release N/A - DBCR 15574');

commit;

