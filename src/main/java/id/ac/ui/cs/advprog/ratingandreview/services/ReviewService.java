package id.ac.ui.cs.advprog.ratingandreview.services;

import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import id.ac.ui.cs.advprog.ratingandreview.models.RatingByBookId;
import id.ac.ui.cs.advprog.ratingandreview.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Async
    public CompletableFuture<Review> saveReview(Review review) {
        return CompletableFuture.completedFuture(reviewRepository.save(review));
    }

    @Async
    public CompletableFuture<Review> findReviewById(Long id) {
        return reviewRepository.findById(id).map(CompletableFuture::completedFuture)
                .orElseGet(() -> CompletableFuture.completedFuture(null));
    }

    @Async
    public CompletableFuture<List<Review>> findAllReviews() {
        return CompletableFuture.completedFuture(reviewRepository.findAll());
    }

    @Async
    public CompletableFuture<List<RatingByBookId>> findAllRatingsGroupByBookId() {
        return CompletableFuture.completedFuture(
                reviewRepository.findByGroupByBookId());
    }

    @Async
    public CompletableFuture<List<RatingByBookId>> findAllRatingsGroupByBookIdOrderBy(Direction direction) {
        if (direction.toString().toLowerCase().equals("asc"))
            return CompletableFuture.completedFuture(
                    reviewRepository.findByGroupByBookIdOrderByAsc());
        else
            return CompletableFuture.completedFuture(
                    reviewRepository.findByGroupByBookIdOrderByDesc());
    }
}
