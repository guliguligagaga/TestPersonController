package ru.khalizov.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.khalizov.demo.model.Person;

@Service
public interface PersonRepository extends CrudRepository<Person,Long>  {

}
