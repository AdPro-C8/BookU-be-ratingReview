package id.ac.ui.cs.advprog.ratingandreview.controllers;
import id.ac.ui.cs.advprog.ratingandreview.dto.ReviewFormData;
import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import id.ac.ui.cs.advprog.ratingandreview.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewAPI {
    @Autowired
    private ReviewService reviewService;
    @PostMapping()
    public ResponseEntity<Review> createReview (@RequestBody ReviewFormData formData) {
        Review review = new Review.Builder()
                .content(formData.getContent())
                .rating(formData.getRating())
                .user(formData.getUsername())
                .build();
        reviewService.saveReview(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.findReviewById(id);
        return review.map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.findAllReviews();
        return ResponseEntity.ok(reviews);
    }

}
