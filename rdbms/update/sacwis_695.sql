--STGAP00015723 - Release(3.5) MR-059 Need to add new columns to Invoice_outbound

--Need to add 3 new columns to INVOICE_OUTBOUND

--NBR_ADJ_INVO_PAID_CHECK - NUMBER(10,0)
-- Comments: Column is populated with the check number of the originally paid invoice that is being adjusted(This column is populated only for certain adjustment invoices)

alter table sacwisifc.invoice_outbound add NBR_ADJ_INVO_PAID_CHECK NUMBER(10,0);
comment on column sacwisifc.invoice_outbound.NBR_ADJ_INVO_PAID_CHECK is 'Column is populated with the check number of the originally paid invoice that is being adjusted(This column is populated only for certain adjustment invoices)';

--DT_ADJ_INVO_PAID_CHECK  - DATE
-- Comments: Column is populated with the check date of the originally paid invoice that is being adjusted(This column is populated only for some adjustment invoices)

alter table sacwisifc.invoice_outbound add DT_ADJ_INVO_PAID_CHECK date;
comment on column sacwisifc.invoice_outbound.DT_ADJ_INVO_PAID_CHECK is 'Column is populated with the check date of the originally paid invoice that is being adjusted(This column is populated only for some adjustment invoices)';

--ID_ORIG_REVERSAL_INV NUMBER(16,0)
-- Comments: Column is populated with the invoice Id of the originally paid invoice that is being adjusted(This column is populated only for all adjustment invoices)

alter table sacwisifc.invoice_outbound add ID_ORIG_REVERSAL_INV NUMBER(16,0);
comment on column sacwisifc.invoice_outbound.ID_ORIG_REVERSAL_INV is 'Column is populated with the invoice Id of the originally paid invoice that is being adjusted(This column is populated only for all adjustment invoices)';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (696, 'SacwisRev3', 'Release 3.5 - DBCR 15723');

commit;


