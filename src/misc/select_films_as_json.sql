select row_to_json(r) 
  from (
    select 'de.springbootbuch.mongo.Film' as _class,
           title, 
           release_year as releaseYear,
           (select array_to_json(array_agg(row_to_json(a))) 
              from (
                select first_name as firstName, last_name as lastName
                  from film_actor fa 
                  join actor ac using (actor_id) 
                 where fa.film_id = f.film_id
              ) a
           ) as actors
      from film f
) r;