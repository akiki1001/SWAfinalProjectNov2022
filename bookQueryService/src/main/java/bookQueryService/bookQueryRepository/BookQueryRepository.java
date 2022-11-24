package bookQueryService.bookQueryRepository;

import bookQueryService.bookQueryDomain.BookQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookQueryRepository extends MongoRepository<BookQuery,Long> {

    List<BookQuery> findAllByBook_Isbn(Long isbn);


}
