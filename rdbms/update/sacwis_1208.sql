--STGAP00017973 - Release(5.1) Modify SHINES Rpt Descriptions

--Modify Shines report Names and Descriptions for the following reports
--Children With Overdue Case Plan  ClearQuest #:  STGAP00017969  ASR #: ASR11360
--Cases Without 6 Month Review ClearQuest #:  STGAP00017970  ASR #: ASR11362

UPDATE caps.reports
set txt_rpt_full_name = 'Children With Overdue Foster Care Case Plan'
where nm_rpt_sqr_name = 'ChildrenWithOverdueCasePLan';

UPDATE caps.reports
set txt_rpt_full_name = '6 Month Review Missing, Due, or Overdue',
    nm_rpt_desc = 'A list of children in DFCS custody in foster care and adoption stages where the most recent case review for the child is either missing, more than 5 months from the report run date or past due. Generated for optional region, county and unit parameters.'
where nm_rpt_sqr_name = 'CasesWithoutPeriodicReview';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1209, 'SacwisRev5', 'Release 5.1 - DBCR 17973');

commit;
