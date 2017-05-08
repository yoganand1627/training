--STGAP00017891 - Release(5.1) STGAP00016104 Correct Message MSG_MISSING_PARENT

--STGAP00016104
--STGAP00017497
--The message MSG_MISSING_PARENT has a newline character within that breaks the javascript and thus the message is never displayed on the LegalStatusDetails page.

update caps.message
set txt_message = 'One or more parents is missing documentation. All parents must have either a TPR Court Order Date with an outcome of TPR Granted, Voluntary Surrender Action Date, or Date of Death. A parent with a Date of Death must have a relationship of either Biological Mother, Legal Mother, Biological Father, Biological and Legal Father, Legal Father, Putative Father or Biological Parent (with Gender of Male or Female).' 
where txt_message_name = 'MSG_MISSING_PARENT_TPR';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1207, 'SacwisRev5', 'Release 5.1 - DBCR 17891');

commit;
