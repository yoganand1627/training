--STGAP00015693 - Release(3.41) Update AFCARS and Case Watch

--Update Help Text. 

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Abandonment:</b><br>This applies if either Abandonment or Refusal to Assume Parental Responsibility was chosen as a removal reason on the custody record for the child''s entry into care.'
WHERE TXT_AFCARS_ELEMENT = 'ABANDONMENT';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>TPR:</b><br>TPR petition is recorded with a Legal Action of type Petition Filed and a Hearing type of TPR for the appropriate relationship to the child.  Ensure that Legal Actions have been included for each child in sibling cases.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_TPR_HELP';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>ILP Coordinator Identified on WTLP:</b><br>Eligible youth reaching 14 years of age are required to have Written Transitional Living Plans and to be referred to Independent Living Services.  Each youth should have an up-to-date WTLP for each case plan review, including up-to-date references to the current Independent Living Coordinator [ILC] for the youth.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_WTLP_COORD_HELP';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Date of Most Recent Diligent Search Contact:</b><br>Diligent searches should be recorded based on continuous search efforts for missing persons.  Record diligent searches for known relatives and non-relatives by first adding them to the Person List in the FCC stage;  then, add Contacts with a purpose of Diligent Search, selecting the relative or non-relative from the Principals/Collaterals Contacted list.  To record search efforts for unknown relatives, add Contacts with a purpose of Diligent Search and document these persons in the Contact Narrative.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_DILIGENT_SEARCH_CNTCT_HELP';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>% of Months ECEM Eligible Contact Has Been Made in the Home this Federal Fiscal Year:</b><br>ECEM standards require that a majority of ECEM contacts for the federal fiscal year of Oct. 1 through Sep. 30 be made in the child''s residence.<br>A child''s residence is defined as the home where the child is residing, whether in-state or out-of-state, and can include the foster home, CCI/CPA, or the home from which the child was removed if the child is on a trial home visit.<br>If a contact made in a child''s home has not been captured, go to contact detail page and make sure "residence," "foster home," "adoptive home," or "facility" has been selected.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_HOME_PERCENT_HELP';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Has the Child Been Seen Every Month Under ECEM Standards this Federal Fiscal Year:</b><br>ECEM standards require children to be seen every full month they are in care..The federal fiscal year is Oct. 1 through Sep. 30.<br>If the result of this indicator inaccurately shows this child as non-ECEM compliant (did not get a purposeful visit every month a visit was required), go to the contact detail page and verify your contacts.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_ECEM_COMPLIANT_HELP';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>% of Months the Child Has Been Seen by DFCS Case Manager This Federal Fiscal Year:</b><br>Children in care are to receive an announced or unannounced, purposeful, face-to-face contact from agency staff all of the months they are in care. The federal fiscal year is Oct. 1 through Sep. 30.
If the result of this indicator is inaccurate, go to contact detail page and verify your contacts.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_DFCS_PERCENT_HELP';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Last Case Plan Review Date:</b><br>"SHINES tracks court or citizen reviews through the following Legal Actions:"<br>Legal Action of Citizen''s Panel Review<br>Legal Action of Panel/Admin<br>Legal Action of Hearing with a Hearing/Court Order Type of Judicial Review<br><br>When entering the most recent review, ensure that one of these is selected as
            the hearing type.  Also, ensure that the legal action is entered for all children in 
            care in each child''s stage.  Finally, if necessary, update the child''s Legal Status, 
            including the Court Order Expiration Date.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_CP_REVIEW_DATE_HELP';


UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Date of Last Permanency Review Hearing:</b><br>SHINES tracks permanency review hearings by looking for the Legal Action of Hearing with a Hearing/Court Order type of Permanency.  When entering the most recent review, ensure that these values are selected.  Also ensure that the legal action is entered for all children in care in each child''s stage.  Finally, if necessary, update the child''s Legal Status, including the Court Order Expiration Date.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_PERM_REVIEW_DATE_HELP';


UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>In Home:</b><br>An ECEM contact is an announced or unannounced, face-to-face, purposeful contact made to a child in foster care or a pre-adoptive placement by an assigned or contracted case manager.<br>For a contact to be considered one that has been made in the home, by ECEM standards, the contact must have occurred where the child resides.<br>A child''s residence is defined as the home where the child is residing, whether in-state or out-of-state, and can include the foster home, CCI/CPA, or the home from which the child was removed if the child is on a trial home visit.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_IN_HOME_HELP';


UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Response Time:</b><br>Response time is met when all alleged victims are seen exactly 24 hours for a 24 hour or immediate 24hour response time and within 5 full weekdays for a 5 day response time.'
WHERE TXT_CASE_WATCH_FACTOR = 'INV_RESPONSE_TM_HELP';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Title IV-A (Aid to Families with Dependent Children/TANF):</b><br>Applies if the foster care child or any person selected as the primary or secondary resource caregiver above, has an Income and Resources entry active during the reporting period with a type of "TANF".'
WHERE TXT_AFCARS_ELEMENT = 'TITLE_IV_A';


UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Has the Child Been Diagnosed with Disability(ies):</b><br>This will be Yes if any of the diagnosis factors below are set to Yes. See individual diagnosis factors below for details. Disabilities should never be Not Yet Diagnosed after 6 months in care.<br><br>Has the Child Been Diagnosed with Mental Retardation?<br><br>Is the Child Visually or Hearing Impaired?<br><br>Is the Child Physically Disabled?<br><br>Is the Child Emotionally Disturbed?<br><br>Has the Child Been Diagnosed with any Other Medical Condition?'
WHERE TXT_AFCARS_ELEMENT = 'CHILD_DISABILITY';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Has the Child Been Diagnosed with Disability(ies):</b><br>This will be Yes if any of the diagnosis factors below are set to Yes. See individual diagnosis factors below for details. Disabilities should never be Not Yet Diagnosed after 6 months in care.'
WHERE TXT_AFCARS_ELEMENT = 'CHILD_DISABILITY';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Date of Latest Removal Transaction Date:</b><br>This value is system-generated and recorded as the date the event occurred.  It is visible on the Custody List page for the Custody record above. This tracks the date the Custody record is actually entered into the system.'
WHERE TXT_AFCARS_ELEMENT = 'REMOVAL_TRANSACTION_DATE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Number of Previous Placement Settings During This Episode:</b><br>This is populated with a count of placement events which have occurred since the most recent removal.  New placement events are counted as moves so long as: <br><br>1) The placement is an actual, as opposed to attempted, placement and not of type respite, concurrent, parental, or runaway<br><br>2) The placement does not fall within the set of placement moves not counted for AFCARS purposes such as returning to the preceding foster placement when leaving a hospital setting.<br><br>For cases predating SHINES, the count of moves occurring before SHINES comes directly from converted data sources.'
WHERE TXT_AFCARS_ELEMENT = 'NUMBER_PLACEMENT_SETTINGS';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Alcohol Abuse(Child):</b><br>This applies if Alcohol Abuse was chosen as a child removal characteristic on the current Custody event for the child. For this to occur, Child Alcohol Abuse must have first been identified as a Person Characteristic for the child.'
WHERE TXT_AFCARS_ELEMENT = 'ALCOHOL_ABUSE_CHILD';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Drug Abuse(Child):</b><br>This applies if Drug Abuse was chosen as a child removal characteristic on the current Custody event for the child. For this to occur, Child Drug Abuse must have first been identified as a Person Characteristic for the child.'
WHERE TXT_AFCARS_ELEMENT = 'DRUG_ABUSE_CHILD';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Is Current Placement Setting Out of State:</b><br>If the address section of the current placement (through the end of the reporting period) indicates that the placement is not in Georgia Yes will be reported, otherwise No will be reported.'
WHERE TXT_AFCARS_ELEMENT = 'OUT_OF_STATE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Most Recent Case Plan Goal:</b><br>The most recent case plan goal is determined from the most recent Foster Care Family Case Plan that is approved and where the child is included on the list of Principals on the Plan. If this is showing blank, validate that the current plan is approved and that the child is included on the plan in the Principals on the Plan section.'
WHERE TXT_AFCARS_ELEMENT = 'MOST_RECENT_CASE_PLAN_GOAL';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Caretaker Family Structure:</b><br>The Family Structure value is set according to the following Person Detail page gender and marital status value combinations for the identified primary caretakers. (Primary caretaker identification rules are described in the year of birth sections below):<br><br>If the first primary caretaker and second primary caretaker are male and female and married, the value reported is Married Couple. <br><br>If the first primary caretaker and second primary caretaker are male and female and not married, the value reported is Unmarried Couple.
<br><br>If only one primary caretaker is identified, and gender is female, the value reported is Single Female.<br><br>If only one primary caretaker is identified, and gender is male, the value reported is Single Male.
<br><br>If only one primary caretaker is identified, and gender is unknown, the value reported is Unable to Determine. <br><br>If the number of primary caretakers is more than two, the value reported is Unable to Determine.
<br><br>If the logic otherwise cannot find a match, AFCARS will report Unable to Determine.<br><br>If the family structure indicates a couple, DOB should be provided for both caretakers.<br><br>When the child has both an active FCC and ADO stage, the relationships from the open Foster Care Child stage is used for the logic.  If an FCC stage is not open, the relationships come from the ADO stage.'
WHERE TXT_AFCARS_ELEMENT = 'CARETAKER_FAMILY_STRUCTURE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 1st Principal Caretaker:</b><br>The Primary Caretaker is identified using the following logic: <br><br>First - Any principal person in the stage who had a relationship of Primary Caretaker at the time of  the most recent removal and who was identified on the Custody page as a member of the home of removal.
<br><br>Second - Any principal person in the current foster care stage (most recent FCC) with a relationship (in order of preference) of Legal Mother, Legal Father, Biological Mother, Biological Father, Putative Father, Parent, Absent Parent, Step Parent, Guardian, or Grandparent.
<br><br>Third - Any principal person in the stage who had a relationship of Primary Caretaker at the time of  the most recent removal, but who was not tied to the removal event on the Custody page as a member of the home of removal. 
<br><br>Fourth - Any principal person in the current foster care stage (most recent FCC) with a relationship (in order of preference) of Aunt/Uncle, Other Family Member, Unrel. Home Mem,  or Self/Minor Parent.
<br><br>When the child has both an active FCC and ADO stage, the relationships are used from the open Foster Care Child stage. If an FCC stage is not open, the relationships come from the ADO stage.'
WHERE TXT_AFCARS_ELEMENT = 'YOB_1ST_PRIN_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 2nd Principal Caretaker:</b><br>The Secondary Caretaker is identified using the following logic (when appropriate, based on marital status): <br><br>First - If a principal person in the stage had a relationship of Primary Caretaker at the time of  the most recent removal and was identified on the Custody page as a member of the home of removal, the Secondary Caretaker is any person with the relationship of Spouse or Paramour to the Primary Caretaker, depending on the Primary Caretaker''s marital status.  
<br><br>Second - Any principal in the current foster care stage with a relationship of Legal Mother, Legal Father, Biological Mother, Biological Father,  Putative Father, Parent, Absent Parent, Step Parent, Guardian, or Grandparent, where the person is different from the person selected as the Primary Caretaker.
<br><br>Third - If any principal in the stage, where the most recent removal was recorded with a relationship of Primary Caretaker,  was not tied to the removal event on Custody, the Secondary Caretaker is any person with the relationship of Spouse or Paramour to the Primary Caretaker, depending on the Primary Caretaker''s marital status.
<br><br>Fourth - Any principal in the current foster care stage with a relationship of Aunt/Uncle, Other Family Member, or Unrel. Home Mem, where the person is different from the person selected as the Primary Caretaker.'
WHERE TXT_AFCARS_ELEMENT = 'YOB_2ND_PRIN_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Parental Rights Termination: Mother:</b><br>If a primary caretaker with a sex of female selected above has a date of death on Person Detail, AFCARS will report that date.  Otherwise it will report: <br><br>1) Date of Legal Action for Legal Action Type of Voluntary Surrender - Mother (VLM) or Voluntary Surrender - Adoptive Mother (VAM)
<br><br>2) Date of Court Order for Legal Action where the Hearing/Court Order Type is TPR-Mother or TPR - Adoptive Mother and the Outcome is TPR Granted 
<br><br>If this date is not appearing for a court ordered TPR, validate the action date, court order date, hearing type, and that the TPR Granted box has been checked for outcomes.'
WHERE TXT_AFCARS_ELEMENT = 'RIGHTS_TERMINATION_MOTHER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Parental Rights Termination: Father:</b><br>If a primary caretaker with a sex of male selected above has a date of death on Person Detail, AFCARS will report that date.  Otherwise it will report:<br><br>1) Date of Legal Action for Legal Action Type of Voluntary Surrender - Legal/Biological Father, Voluntary Surrender - Legal Father, Voluntary Surrender - Biological Father, Voluntary Surrender - Adoptive Father, Voluntary Surrender - Father.
<br><br>2) Date of Court Order for Legal Action where the Hearing/Court Order Type is TPR-Father, TPR - Legal/Biological Father, TPR - Legal Father, TPR - Biological Father, TPR -  Adoptive Father and the Outcome is TPR Granted. <br><br>If this date is not appearing for a court ordered TPR, validate the action date, court order date, hearing type, and that the TPR Granted box has been checked for outcomes.'
WHERE TXT_AFCARS_ELEMENT = 'RIGHTS_TERMINATION_FATHER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Date of Discharge from Foster Care Transaction Date:</b><br>This system-generated date can be seen on the Legal Status List for the Legal Status event that updates the child''s legal status from "in custody" to "not in custody". It is recorded at the time the Legal Status is actually entered into the system and cannot be modified.'
WHERE TXT_AFCARS_ELEMENT = 'DISCHARGE_TRANSACTION_DATE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Reason for Discharge:</b><br>The reason for discharge is primarily derived from the Legal Status selected on the Legal Status event that records the discharge date above.   These are mapped below: 
<br><br>Aftercare/Supervision: Reunification with Parents/Primary Caretakers <br><br>Not In DFCS Custody - Child Turned 18 (No ILP): Emancipation <br><br>Not in DFCS Custody - Child Death: Death of Child <br><br>Not In DFCS Custody - Custody To Other: Transfer to Another Agency
<br><br>Not In DFCS Custody - Custody Transferred To Tribe: Transfer to Another Agency <br><br>Not In DFCS Custody - Emancipated: Emancipation <br><br>Not In DFCS Custody - Guardianship: Guardianship <br><br>Not In DFCS Custody - Parental Custody: Reunification with Parents/Primary Caretakers
<br><br>Not in DFCS Custody - Custody to Relative: Living with Relatives <br><br>Committed To DJJ: Transfer to Another Agency <br><br>ILP Aftercare: Emancipation <br><br>If the child turned 18 without updated legal status, the reason will default to Emancipation.  If the child is discharged due to a trial home visit over the timeframe, the reason will default to Reunification.'
WHERE TXT_AFCARS_ELEMENT = 'REASON_FOR_DISCHARGE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Title IV-E (Foster Care):</b><br>Applies if at any time during the reporting period, an Eligibility Summary entry exists for the child, where the selected eligibility is IV-E.'
WHERE TXT_AFCARS_ELEMENT = 'TITLE_IV_E_FOSTER_CARE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Title IV-A (Aid to Families with Dependent Children/TANF):</b><br>Applies if the foster care child or any person selected as the primary or secondary resource caregiver above, has an Income and Resources entry active during the reporting period with a type of "TANF".'
WHERE TXT_AFCARS_ELEMENT = 'TITLE_IV_A';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Title XIX (Medicaid):</b><br>Applies if at any time during the reporting period an Eligibility Summary entry exists for the child with a class of assistance of F11 - IV-E, F13 - IV-E Adopt, F15 - Newborn, F22 - RSM, F40 - IV-B, F99 - Medically Needy, D02 - State Adopt, P01 - Pregnancy, EMA - Emer. Medical, or XXX - Other.'
WHERE TXT_AFCARS_ELEMENT = 'TITLE_XIX';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Foster Family Structure:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'FOSTER_FAMILY_STRUCTURE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 1st Foster Caretaker:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'YOB_1ST_FOSTER_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 2nd Foster Caretaker:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'YOB_2ND_FOSTER_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 1 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_1ST_FOSTER_CARETAKER_A';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 1 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_1ST_FOSTER_CARETAKER_B';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 1 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_1ST_FOSTER_CARETAKER_C';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 1 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_1ST_FOSTER_CARETAKER_D';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 1 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_1ST_FOSTER_CARETAKER_E';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 1 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_1ST_FOSTER_CARETAKER_F';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Hispanic or Latino Origin:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'HL_ORIGIN_1ST_FOS_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 2 Race</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_2ND_FOSTER_CARETAKER_A';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 2 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_2ND_FOSTER_CARETAKER_B';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 2 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_2ND_FOSTER_CARETAKER_C';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 2 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_2ND_FOSTER_CARETAKER_D';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 2 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_2ND_FOSTER_CARETAKER_E';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>FC Caretaker 2 Race:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'RACE_2ND_FOSTER_CARETAKER_F';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Hispanic or Latino Origin:</b><br>This field is only reported for current placement types of Adoptive, Foster, Relative, Non-Relative or Other Person. If the placement is tied to a resource with a FAD stage this information will come from Marital Status on the Home Information page. For relative and other homes without FAD, it will come from the Caretaker Information page available under the Resource tab.'
WHERE TXT_AFCARS_ELEMENT = 'HL_ORIGIN_2ND_FOS_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Relinquishment:</b><br>This applies if Relinquishment was chosen as a removal reason on the Custody record for the child''s entry into care.'
WHERE TXT_AFCARS_ELEMENT = 'RELINQUISHMENT';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Permanency Goals:</b><br>The child''s permanency goal will be defined by the primary permanency goal on the most recent approved Foster Care Case Plan Family Plan, created within six months of current date,  on which the child was included as a principal. If this is blank or incorrect, verify that the child is chosen on the plan and that the plan is approved. If siblings have different primary goals, they should have different primary plans, not a single concurrent plan.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_PERM_GOALS_HELP';


UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>% of Months the Child Has Been Seen by DFCS Case Manager This Federal Fiscal Year:</b><br>Children in care are to receive an announced or unannounced, purposeful, face-to-face, contact from agency staff all of the months they are in care.
<br>If the result of this indicator is inaccurate, go to contact detail page and verify your contacts.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_DFCS_PERCENT_HELP';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Sex:</b><br>This is derived from the current sex entered for the Primary Child in the stage.  If necessary correct the child''s gender on the Person Detail page.'
WHERE TXT_AFCARS_ELEMENT = 'SEX';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Date of Last Foster Care Discharge:</b><br>This is the date the child was discharged from the last foster care episode immediately prior to the current episode, determined using the most recent legal status date where the child has a legal status of "not in custody" immediately following an "in custody" legal status and the "not in custody" legal status occurred prior to the current removal.<br>In cases where a child remained in a trial home visit for over 6 months without legal discharge this date will be the trial home visit discharge date on Placement.<br>Note that in some cases this may be populated with converted data not associated to a SHINES case record.'
WHERE TXT_AFCARS_ELEMENT = 'LAST_FOSTER_CARE_DISCHARGE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Sex:</b><br>This is derived from the current sex entered for the Primary Child in the stage.  If necessary correct the child''s gender on the Person Detail page.'
WHERE TXT_AFCARS_ELEMENT = 'SEX';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Physical Abuse:</b><br>This applies if Physical Abuse/Risk was chosen as a removal reason on the custody record for the child''s current stay in care.'
WHERE TXT_AFCARS_ELEMENT = 'PHYSICAL_ABUSE';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Abandonment:<b>Abandonment:</b><br>This applies if Abandonment was chosen as a Removal Reason on the Custody record for the child''s entry into care.<br>Abandonment is a refusal to assume parental responsibility.' 
WHERE TXT_AFCARS_ELEMENT = 'ABANDONMENT';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Child''s Behavior Problem:</b><br>This applies if any of the following person characteristics were chosen for the foster child on the Person Characteristics page and then selected on the Custody page as child characteristics contributing to removal:<br>Abnormal Bowel Movement Behavior, Aggressive, Animal Cruelty, Assaultive Behavior, Conduct Disorder, Eating Disorder, Fire Setting, Gang Activity/Affiliation, Has Trouble Sleeping, Inhalant Abuse, Prior Suicide Attempt, Prostitutes, Runs Away, Self Abuse, Sexually Acting Out, Sexually Promiscuous, Steals, Suicide Ideations, Violent, Wets Bed, or Other.'
WHERE TXT_AFCARS_ELEMENT = 'CHILDS_BEHAVIOR_PROBLEM';


UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Current Custody Status:</b><br>SHINES tracks the exit of a child from foster care based on the date of the Legal Status marking that the child is no longer in DFCS custody.  If the child has exited custody, update the Legal Status as soon as possible to ensure that the discharge is recorded, even if the FCC stage remains open due to other factors.
<br>If the result of this indicator is inaccurate, go to contact detail page and verify your contacts.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_CUSTODY_HELP';


UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Caretaker Family Structure:</b><br>The Family Structure value is set according to the following Person Detail page gender and marital status value combinations for the identified primary caretakers (primary caretaker identification rules are described in the year of birth sections below):<br><br>If the first primary caretaker and second primary caretaker are male and female and married, the value reported is Married Couple <br><br>If the first primary caretaker and second primary caretaker are male and female and not married, the value reported is Unmarried Couple <br><br>If only one primary caretaker is identified, and gender is female, the value reported is Single Female<br><br>If only one primary caretaker is identified, and gender is male, the value reported is Single Male.<br><br>If only one primary caretaker is identified, and gender is unknown, the value reported is Unable to Determine <br><br>If the number of primary caretakers is more than two, the value reported is Unable to Determine. <br><br>If the logic otherwise cannot find a match AFCARS will report unable to determine. <br><br>If the family structure indicates a couple DOB should be provided for both caretakers.<br><br>When the child has both an active FCC and ADO stage, the relationships from the open Foster Care Child stage is used for the logic.  If an FCC stage is not open, the relationships come from the ADO stage.'
WHERE TXT_AFCARS_ELEMENT = 'CARETAKER_FAMILY_STRUCTURE';


UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>% of Months ECEM Eligible Contact Has Been Made in the Home this Federal Fiscal Year:</b><br>ECEM standards require that a majority of ECEM contacts for the fiscal year be made in the child''s residence.<br>A child''s residence is defined as the home where the child is residing, whether in-state or out-of-state, and can include the foster home, CCI/CPA, or the home from which the child was removed if the child is on a trial home visit.<br>If a contact made in a child''s home has not been captured, go to contact detail page and make sure "residence," "foster home," "adoptive home," or "facility" has been selected.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_HOME_PERCENT_HELP';


UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Case Manager Contact:</b><br>ECEM contacts may be made by a DFCS case manager or a designee (a case worker, private provider or other party, whether in-state or out-of-state, to whom DFCS has assigned/contracted case management or visitation responsibilities) to meet ECEM frequency standards.<br>However, monitor contacts to the child to ensure enough of them are being made by DFCS case managers to meet CFSR quality standards.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_DFCS_CNTCT_HELP';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Has the Child Been Seen Every Month Under ECEM Standards this Federal Fiscal Year:</b><br>ECEM standards require children to be seen every month they are in care for a full calendar month.<br>If the result of this indicator inaccurately shows this child as non-ECEM compliant (did not get a purposeful visit every month a visit was required), go to the contact detail page and verify your contacts.'
WHERE TXT_CASE_WATCH_FACTOR = 'ECEM_ECEM_COMPLIANT_HELP';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 1st Principal Caretaker:</b><br>The first primary caretaker is identified using the following logic: <br><br>First - Any principal person in the stage where the most recent removal was recorded with a relationship of Primary Caretaker and identified on the Custody page as a part of the removal event as a member of the home of removal. <br><br>Second - Any principal person in the current foster care stage (most recent FCC) with a relationship (in order of preference) of Legal Mother, Legal Father, Biological Mother, Biological Father, Putative Father, Parent, Absent Parent, Step Parent, Guardian, Grandparent. <br><br>Third - Any principal person in the stage where the most recent removal was recorded with a relationship of Primary Caretaker but not tied to the removal event on Custody as member of home of removal. <br><br>Fourth - Any principal person in the current foster care stage (most recent FCC) with a relationship (in order of preference) of Aunt/Uncle, Other Family Member, Unrel. Home Mem, Self/Minor Parent.<br><br>When the child has both an active FCC and ADO stage, the relationships are used from the open Foster Care Child stage.  If an FCC stage is not open, the relationships come from the ADO stage.'
WHERE TXT_AFCARS_ELEMENT = 'YOB_1ST_PRIN_CARETAKER';

UPDATE CAPS.AFCARS_ELEMENT_HELP 
SET TXT_AFCARS_ELEMENT_HELP_TEXT = '<b>Year of Birth: 2nd Principal Caretaker:</b><br>The secondary caretaker is identified using the following logic (when appr. based on marital status): <br><br>First - If any principal in the stage where the most recent removal was recorded with a relationship of Primary Caretaker and identified on the Custody page as a part of the removal event, then select a person with the relationship of Spouse or Paramour depending on the primary caretaker''s marital status. <br><br>Second - Any principal in the current foster care stage with a relationship of Legal Mother, Legal Father, Biological Mother, Biological Father, Putative Father, Parent, Absent Parent, Step Parent, Guardian, Grandparent where the person is different from the person selected as the first caretaker.<br><br>Third - If an principal in the stage where the most recent removal was recorded with a relationship of Primary Caretaker but not tied to the removal event on Custody, then select a person with the relationship of Spouse or Paramour depending on the primary caretaker''s marital status. <br><br>Fourth - Any principal in the current foster care stage with a relationship of Aunt/Uncle, Other Family Member, Unrel. Home Mem, and the person is different from the person selected as the primary caretaker.'
WHERE TXT_AFCARS_ELEMENT = 'YOB_2ND_PRIN_CARETAKER';

UPDATE CAPS.CASE_WATCH_FACTOR_HELP 
SET TXT_CASE_WATCH_FACTOR_HLP_TXT = '<b>Date of Most Recent Screens:</b><br>Children in care are to obtain health screens followed by recurring medical screens to look after the child''s health and wellbeing.'
WHERE TXT_CASE_WATCH_FACTOR = 'FC_HEALTH_SCREENS_HELP';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (676, 'SacwisRev3', 'Release 3.41 - DBCR 15693');

commit;


