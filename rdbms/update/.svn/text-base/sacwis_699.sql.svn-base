--STGAP00015725 - Release(3.5) MR-059 - Need to add new columns to Invocie table

--Need to add 3 new columns to

--NBR_ADJ_INVO_PAID_CHECK - NUMBER(10,0)
-- Comments: Column is populated with the check number of the originally paid invoice that is being adjusted(This column is populated only for certain adjustment invoices)

--DT_ADJ_INVO_PAID_CHECK  - DATE
-- Comments: Column is populated with the check date of the originally paid invoice that is being adjusted(This column is populated only for some adjustment invoices)

--ID_ORIG_REVERSAL_INV NUMBER(16,0)
--Comments: Column is populated with the invoice Id of the originally paid invoice that is being adjusted(This column is populated only for all adjustment invoices)


--All three fields are nullable.

alter table caps.invoice add NBR_ADJ_INVO_PAID_CHECK NUMBER(10,0);
alter table caps.invoice add DT_ADJ_INVO_PAID_CHECK DATE;
alter table caps.invoice add ID_ORIG_REVERSAL_INV NUMBER(16,0);

comment on column caps.invoice.NBR_ADJ_INVO_PAID_CHECK  is 'Column is populated with the check number of the originally paid invoice that is being adjusted(This column is populated only for certain adjustment invoices)';
comment on column caps.invoice.DT_ADJ_INVO_PAID_CHECK  is 'Column is populated with the check date of the originally paid invoice that is being adjusted(This column is populated only for some adjustment invoices)';
comment on column caps.invoice.ID_ORIG_REVERSAL_INV  is 'Column is populated with the invoice Id of the originally paid invoice that is being adjusted(This column is populated only for all adjustment invoices)';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (700, 'SacwisRev3', 'Release 3.5 - DBCR 15725');

commit;

