package server.data.employees;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import server.data.products.Product;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "employee", path = "employees", excerptProjection = EmployeeResponse.class)
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
