--STGAP00014829 - MR-024 Need to move the purpose values to the new

--As per MR-024 the contact detail page is changed to offer the user an option 
--to select multiple purpose values for a single contact. For the existing Contact 
--records there is only one purpose value associated with each contact and it is 
--saved on the contact table. As per the new changes to the contact detail page 
--the purpose values on the contact detail page are saved into/ retrieved from the 
--CONTACT_CBX table. Need to create a SQL script that writes the purpose value for 
--each existing contact record into the CONTACT_CBX table.

--STGAP00014590 - Per STGAP00014326  MR-024 , Add new Column to CONTACT table. 

alter table caps.contact add (dt_entered_on date);
comment on column caps.contact.dt_entered_on is 'Records the date on which contact was entered in SHINES';

alter table caps.contact_cbx modify cd_contact_cbx varchar2(4);

--Per MR- 024, Add new columns to CONTACT table.
alter table caps.contact add (nm_contacted_by varchar2(25)) ;
alter table caps.contact add (cd_contacted_by varchar2(4));
alter table caps.contact add (cd_contact_narrative varchar2(4));

comment on column caps.contact.nm_contacted_by is 'Per MR- 024, used to record the Name of the person who made the contact.';
comment on column caps.contact.cd_contacted_by is 'Used to record the Code of the person who made the contact.';
comment on column caps.contact.cd_contact_narrative is 'Used to record type of narrative associated with a contact record.';

insert into caps.contact_cbx
(id_contact_event, cd_cbx_code_type, cd_contact_cbx)
select id_event, 'CCNTPURP', cd_contact_purpose
from   caps.contact
where cd_contact_purpose is not null;

update caps.contact
set cd_contact_narrative='PCV'
where cd_contact_narrative is null and cd_contact_type like '%PVC%';

update caps.contact set
cd_contact_narrative='STD'
where cd_contact_narrative is null;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (519, 'SacwisRev3', 'Release 3.2 - DBCRs 14829');

commit;


