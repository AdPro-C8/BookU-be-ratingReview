package id.ac.ui.cs.advprog.ratingandreview.services;

import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import id.ac.ui.cs.advprog.ratingandreview.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}