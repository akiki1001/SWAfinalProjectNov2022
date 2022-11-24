package ReviewService.dto;

import ReviewService.ReviewDomain.Review;

public class ReviewAdapter {
    public static Review getReview(ReviewDto reviewDto) {
        Review review = new Review(
                reviewDto.getIsbn(),
                reviewDto.getRating(),
                reviewDto.getCustomerName(),
                reviewDto.getDescription()
        );
        return review;
    }

    public static ReviewDto getReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto(
                review.getIsbn(),
                review.getRating(),
                review.getCustomerName(),
                review.getDescription()
                 );
        return reviewDto;
    }
}
