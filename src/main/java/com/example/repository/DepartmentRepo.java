package com.example.repository;

import com.example.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepo extends MongoRepository<Department,String>
{

    public Department findByName(String department);

}
