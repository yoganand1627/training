--STGAP00016095 - Release(4.2) MR-074-2 AFCARS Update AFCARS_ELEMENT_HELP

-- STGAP00016095
-- Update Help Text on the Case Watch Page
-- Table: AFCARS_ELEMENT_HELP

UPDATE CAPS.AFCARS_ELEMENT_HELP
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Parental Rights Termination: Mother:</b><br>If a primary caretaker with a sex of female selected above has a date of death on Person Detail, AFCARS will report that date.  Otherwise it will report: <br><br>1) Most recent Court Action Date for Legal Action Type of Voluntary Surrender - Biological Mother (VLM) or Voluntary Surrender - Adoptive Mother (VAM)
<br><br>2) Most recent Court Order Date  for Legal Action where the Hearing/Court Order Type is TPR-Biological Mother or TPR - Adoptive Mother and the Outcome is TPR Granted.
<br><br>If this date is not appearing for a court ordered TPR, validate the action date, court order date, hearing type, and that the TPR Granted box has been checked for outcomes.'
WHERE TXT_AFCARS_ELEMENT_SHORT in ('AFCARS_FC_47');

UPDATE CAPS.AFCARS_ELEMENT_HELP
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Parental Rights Termination: Father:</b><br>If a primary caretaker with a sex of male selected above has a date of death on Person Detail, AFCARS will report that date.  Otherwise it will report:<br><br>1) Date of Legal Action for Legal Action Type of Voluntary Surrender - Legal/Biological Father, Voluntary Surrender - Legal Father, Voluntary Surrender - Biological Father, Voluntary Surrender - Adoptive Father, Voluntary Surrender - Father.
<br><br>2) Most recent Court Order Date for Legal Action where the Outcome is TPR Granted and the Hearing/Court Order Type is TPR-Father, TPR - Legal/Biological Father, TPR - Legal Father, TPR - Biological Father, TPR - Adoptive Father, TPR - Putative Father. <br><br>If this date is not appearing for a court ordered TPR, validate the action date, court order date, hearing type, and that the TPR Granted box has been checked for outcomes.'
WHERE TXT_AFCARS_ELEMENT_SHORT IN ('AFCARS_FC_48');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (980, 'SacwisRev4', 'Release 4.2 - DBCR 16095');

commit;


