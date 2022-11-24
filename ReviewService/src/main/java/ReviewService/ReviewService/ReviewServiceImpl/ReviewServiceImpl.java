package ReviewService.ReviewService.ReviewServiceImpl;

import ReviewService.ReviewIntegration.Sender;
import ReviewService.ReviewService.ReviewService;
import ReviewService.dto.ReviewAdapter;
import ReviewService.dto.ReviewDto;
import net.projectmonkey.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
//    @Autowired
//    private ReviewRepository reviewRepository;

    @Autowired
    private Sender sender;


//    @Override
//    public List<ReviewDto> getAllReview() {
//        return reviewRepository.findAll().stream().map(n-> ReviewAdapter.getReviewDto(n))
//                .collect(Collectors.toList());
//    }

    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
       // reviewRepository.save(ReviewAdapter.getReview(reviewDto));
        sender.send(reviewDto);
        return reviewDto;

    }

//    @Override
//
//    public ReviewDto updateReview(ReviewDto reviewDto, Long reviewNumber) {
//        var review= reviewRepository.findById(reviewNumber).get();
//        if(review==null){
//            throw new NullPointerException("Review not found");
//        }
//        review.setTitle(reviewDto.getTitle());
//        review.setDescription(reviewDto.getDescription());
//        reviewRepository.save(review);
//        return reviewDto;
//    }

//    @Override
//    public ReviewDto deleteReview(Long reviewNumber) {
//       // var review= reviewRepository.findById(reviewNumber).get();
////        if(review==null){
////            throw new NullPointerException("Review not found ");
////        }
//       // var bookDto=ReviewAdapter.getReviewDto(review);
//        //reviewRepository.deleteById(reviewNumber);
//        return bookDto;
//    }
}
