package ReviewService.ReviewService;

import ReviewService.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    //public List<ReviewDto> getAllReview();
    public ReviewDto addReview(ReviewDto reviewDto);
    //public ReviewDto updateReview(ReviewDto reviewDto, Long reviewNumber);
    //public ReviewDto deleteReview(Long reviewNumber);

}
