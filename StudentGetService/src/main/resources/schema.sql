create or replace function get_age(birth_date date)
returns int as '
    begin
        return date_part($$year$$, age(birth_date));
    end;
' language plpgsql;
