package ReviewService.ReviewWeb;

import ReviewService.ReviewService.ReviewService;
import ReviewService.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

//    @GetMapping
//    public ResponseEntity<List<ReviewDto>> getAllReview(){
//        return ResponseEntity.ok().body(reviewService.getAllReview());
//    }

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody ReviewDto reviewDto){
        reviewService.addReview(reviewDto);
        return ResponseEntity.ok().body(reviewDto);
    }

//    @PutMapping
//    public ResponseEntity<?> updateReview(@RequestBody ReviewDto reviewDto, @PathVariable Long reviewNumber){
//        reviewService.updateReview(reviewDto,reviewNumber);
//        return ResponseEntity.ok().body(reviewDto);
//    }
//    @DeleteMapping
//    public ResponseEntity<?> deleteReview(@PathVariable Long reviewNumber){
//        var bookDto= reviewService.deleteReview(reviewNumber);
//        return ResponseEntity.ok().body(bookDto);
//    }
}
