--STGAP00015610 - Release(3.4) DBCR: Addtional Case Watch Metaphor Items

--The attached SQL adds the following to the tab metaphor:

--1) Creates a second version of the Case Maintenance 2nd level tab for direct navigation to the Case Watch page.

--2) Creates a new resource detail 3rd level tab without page break for improved page appearance.

--Creates second level tab for direct navigation to Case Watch instead of case maintenance
INSERT INTO CAPS.METAPHOR (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB)
VALUES (147,'/casemgmt/CaseWatch/displayCaseWatch','CASE_MANAGEMENT_CASEMNT_CW','Case<br>Management');
--Creates 3rd level tab for resource detail without page break
INSERT INTO CAPS.METAPHOR (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB)
VALUES (1760,'/resource/ResourceDetail/displayResourceDetail','RESOURCE_DETAIL_RESOURCEDETAIL_3','Resource Detail');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (619, 'SacwisRev3', 'Release 3.4 - DBCR 15610');

commit;

