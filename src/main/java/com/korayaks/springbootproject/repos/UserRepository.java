package com.korayaks.springbootproject.repos;

import com.korayaks.springbootproject.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<User> getByCustomQuery(String search);
    
    List<User> findByFirstNameOrLastName(String firstName, String lastName);

    Optional<User> findById(String id);

    void deleteById(String id);

    boolean existsById(String id);
}
