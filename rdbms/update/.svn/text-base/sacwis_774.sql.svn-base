--STGAP00015827 - Release(3.5) Create the CONTACT_DETAILS view

--  The contact_details view consolidates all contacts per person contacted and displays
--  many of the decoded values on the dropdowns selected on the Contact Detail page.
--  In addition, this view consolidates all of the selected purposes for the
--  contact into a single comma-separated field for ease of use.  This view will be
--  used to create the Caseworker Person Contact List Month report within LENSES.

--Contact ID
--Contact Date
--Method
--Location
--Purposes
--Contacted By
--Contacted By Name
--Actual/Attempted
--Narrative Type
--Entered By
--Entered On

--Parameters to pass
--Contact_Date < (LAST_DAY(TO_DATE('02/2010', 'MM/YYYY'))+1) --contact occurs before first of following month
--Contact_Date >= TO_DATE('02/2010', 'MM/YYYY') --contact occurs on or after first of month
--Case_ID = ''
--ID_PERSON_CONTACTED = ''

CREATE OR REPLACE VIEW CAPS.CONTACT_DETAILS(
Case_ID,
ID_PERSON_CONTACTED,
Contact_ID,
Contact_Date,
Contact_Method,
Contact_Location,
Contacted_By,
Contacted_By_Name,
Ind_Actual_Attempted,
Narrative_Type,
Entered_By,
Entered_On,
Contact_Purposes
) AS
select 
contact_details.Case_ID,
contact_details.ID_PERSON_CONTACTED,
contact_details.Contact_ID,
contact_details.Contact_Date,
contact_details.Contact_Method,
contact_details.Contact_Location,
contact_details.Contacted_By,
contact_details.Contacted_By_Name,
contact_details.Ind_Actual_Attempted,
contact_details.Narrative_Type,
contact_details.Entered_By,
contact_details.Entered_On,
to_string(cast (collect (contact_details.Contact_Purposes) as collection_char1)) as Contact_Purposes
from ( --start of contact_details
        select 
        contact.ID_CASE as Case_ID,
        event_person_link.ID_PERSON as ID_PERSON_CONTACTED,
        contact.ID_EVENT as Contact_ID,
        contact.DT_CONTACT_OCCURRED as Contact_Date,
        CCNTMETH.DECODE as Contact_Method,
        CCNCTLOC.DECODE as Contact_Location,
        CCCONTBY.DECODE as Contacted_By,
        contact.NM_CONTACTED_BY as Contacted_By_Name,
        decode (contact.IND_CONTACT_ATTEMPTED, 'Y','Attempted','Actual') Ind_Actual_Attempted,
        CCONNARR.DECODE as Narrative_Type,
        entered_by.NM_PERSON_FULL as Entered_By,
        contact.DT_ENTERED_ON as Entered_On,
        CCNTPURP.DECODE as Contact_Purposes
        from contact,
        event,
        CCNTMETH, -- used for contact method lookup
        CCNCTLOC, --used for contact location lookup (outer join reqd)
        person entered_by,
        event_person_link, 
        CCNTPURP,
        (select * from codes_tables where codes_tables.CODE_TYPE = 'CCCONTBY') CCCONTBY,
        (select * from codes_tables where codes_tables.CODE_TYPE = 'CCONNARR') CCONNARR,
        (select * from contact_cbx where contact_cbx.CD_CBX_CODE_TYPE = 'CCNTPURP') contact_cbx_purp    --stores the contact purposes  
        where contact.CD_CONTACT_METHOD = CCNTMETH.CODE
        and contact.CD_CONTACT_LOCATION = CCNCTLOC.CODE(+) --outer join reqd
        and contact.CD_CONTACTED_BY = CCCONTBY.CODE(+) --outer join reqd
        and contact.CD_CONTACT_NARRATIVE = CCONNARR.CODE(+) --outer join reqd
        and contact.ID_EVENT = contact_cbx_purp.ID_CONTACT_EVENT(+) --outer join reqd
        and contact_cbx_purp.CD_CONTACT_CBX = CCNTPURP.CODE(+) --outer join reqd
        and contact.ID_EVENT = event.ID_EVENT
        and event.ID_EVENT_PERSON = entered_by.ID_PERSON
        and event_person_link.ID_EVENT = contact.ID_EVENT 
        order by 
        contact.DT_CONTACT_OCCURRED desc,
        contact.ID_EVENT desc,
        CCNTPURP.DECODE asc
        )contact_details        
group by        
contact_details.Case_ID,
contact_details.ID_PERSON_CONTACTED,
contact_details.Contact_ID,
contact_details.Contact_Date,
contact_details.Contact_Method,
contact_details.Contact_Location,
contact_details.Contacted_By,
contact_details.Contacted_By_Name,
contact_details.Ind_Actual_Attempted,
contact_details.Narrative_Type,
contact_details.Entered_By,
contact_details.Entered_On;

grant select,update,insert,delete on CAPS.CONTACT_DETAILS to capson,capsbat,ops$datafix,operator,shinesdm;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (775, 'SacwisRev3', 'Release 3.5 - DBCR 15827');

commit;


