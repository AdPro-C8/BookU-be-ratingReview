package id.ac.ui.cs.advprog.ratingandreview.controllers;

import id.ac.ui.cs.advprog.ratingandreview.dto.ReviewFormData;
import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import id.ac.ui.cs.advprog.ratingandreview.models.RatingByBookId;
import id.ac.ui.cs.advprog.ratingandreview.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/reviews")
public class ReviewAPI {
    @Autowired
    private ReviewService reviewService;

    @PostMapping()
    public CompletableFuture<ResponseEntity<Review>> createReview(@RequestBody ReviewFormData formData) {
        Review review = new Review.Builder()
                .content(formData.getContent())
                .rating(formData.getRating())
                .user(formData.getUsername())
                .bookId(formData.getBookId())
                .build();
        return reviewService.saveReview(review)
                .thenApply(savedReview -> ResponseEntity.status(201).body(savedReview));
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Review>> getReviewById(@PathVariable Long id) {
        return reviewService.findReviewById(id)
                .thenApply(review -> review != null ? ResponseEntity.ok(review) : ResponseEntity.notFound().build());
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Review>>> getAllReviews() {
        return reviewService.findAllReviews()
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/rating/by/book-id")
    public CompletableFuture<ResponseEntity<List<RatingByBookId>>> getAllRatingsGroupByBookId(
        @RequestParam Optional<String> orderBy)
    {
        if (!orderBy.isPresent()) {
            return reviewService
                    .findAllRatingsGroupByBookId()
                    .thenApply(ResponseEntity::ok);
        } else {
            return reviewService
                .findAllRatingsGroupByBookIdOrderBy(Direction.fromString(orderBy.get()))
                .thenApply(ResponseEntity::ok);
        }
    }
}
