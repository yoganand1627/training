--STGAP00015390 - Update COTHCNCT code table value

--The Others Contacted drop-down field on the Contact Details page is displaying the option "Foster Parent (DFCS)".  The option should display "Foster Parent".  This problem was created by DBCR sacwis_482.sql as part of STGAP4083 which was deployed in Release 3.2.  The changes should not have been made to the Contact Details page.

--The Code Table needs to be updated for code type="COTHCNCT" code="FOS" so that the decode="Foster Parent".

update caps.codes_tables set decode='Foster Parent' where code_type='COTHCNCT' and code='FOS';

insert into caps.schema_version (id_schema_version, application_version, comments)
            values (544, 'SacwisRev3', 'Release 3.21 - DBCR 15390');

commit;

