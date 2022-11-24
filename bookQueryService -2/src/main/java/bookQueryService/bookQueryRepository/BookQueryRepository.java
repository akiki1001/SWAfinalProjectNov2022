package bookQueryService.bookQueryRepository;

import bookQueryService.bookQueryDomain.BookQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookQueryRepository extends MongoRepository<BookQuery,Long> {

    BookQuery findAllByBook_Isbn(Long isbn);
}
