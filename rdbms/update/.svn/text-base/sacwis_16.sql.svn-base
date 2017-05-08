/
declare
   v_exists       number;
   v_person       number;
   v_unit         number;

cursor all_units is
  select u.id_unit, u.id_person
    from caps.unit u;
begin
  for au_rec in all_units loop
    v_person := au_rec.id_person;
    v_unit   := au_rec.id_unit;
    select count(*) into v_exists from caps.unit_emp_link where id_unit=v_unit and id_person=v_person;
    if (v_exists = 0) then
      INSERT INTO caps.unit_emp_link
      (id_unit_emp_link, dt_last_update, id_unit, id_person, cd_unit_member_role, cd_unit_member_in_out)
      VALUES
      (0, SYSDATE, v_unit, v_person, '30','IN');
    end if;
  end loop;
end;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (17, 'SacwisRev1', 'Updating UNIT_EMP_LINK table for new unit and person values.');

commit;
