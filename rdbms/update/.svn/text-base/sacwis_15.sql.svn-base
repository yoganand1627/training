alter table caps.unit drop constraint uk1_unit;
drop index caps.uk1_unit;

UPDATE caps.unit SET cd_unit_region = '03A' WHERE cd_unit_region = '003';
UPDATE caps.unit SET cd_unit_region = '03B' WHERE cd_unit_region = '510';

/
declare
   v_region       varchar2(3) ;
   v_nbr_unit         varchar2(2) ;
   v_ind          varchar2(1);
   v_county       varchar2(3);
   v_counter      number;
   v_reccnt       number;
   v_unit         number;
cursor all_cps_region_counties is
  select u.id_unit, u.dt_last_update, u.nbr_unit, u.cd_unit_region, u.cd_unit_program,
u.id_person, u.id_unit_parent, u.cd_unit_specialization, c.code county
from caps.unit u, caps.codes_tables c
where u.CD_UNIT_REGION = c.DECODE
and code_type='CCNTYREG'
and cd_unit_program='CPS'
order by nbr_unit, cd_unit_region;
begin

 
v_counter := 1000;

for acrc_rec in all_cps_region_counties loop
                v_region := acrc_rec.cd_unit_region;
                v_nbr_unit := acrc_rec.nbr_unit;
		v_county := acrc_rec.county;
		v_unit   := acrc_rec.id_unit;
				
		v_ind := NULL;
		select count(*) into v_reccnt from caps.unit where nbr_unit=v_nbr_unit and cd_unit_region=v_region and cd_unit_program='CPS' and cd_county is null;
				
				
		if (v_reccnt = 1) then
			update caps.unit set cd_county=v_county where unit.id_unit=v_unit;
		else
			v_counter := v_counter + 1;
			insert into caps.unit values (v_counter, acrc_rec.dt_last_update, acrc_rec.nbr_unit, acrc_rec.cd_unit_region, acrc_rec.cd_unit_program,
				acrc_rec.id_person, acrc_rec.id_unit_parent, acrc_rec.cd_unit_specialization, acrc_rec.county);
		end if;
				
end loop;

end;
/

create sequence caps.temp_county
start with 1
increment by 2
cycle
maxvalue 321;

update caps.unit set cd_county=caps.temp_county.nextval where cd_county is null;

drop sequence caps.temp_county;

update caps.unit set cd_county='127' where id_unit=415;

alter table caps.unit add constraint uk1_unit unique (NBR_UNIT,CD_UNIT_REGION,CD_COUNTY);

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (16, 'SacwisRev1', 'Updating UNIT table');
                         
commit;