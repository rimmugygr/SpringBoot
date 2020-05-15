package server.data.Products;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource (collectionResourceRel = "product" , path = "product")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
