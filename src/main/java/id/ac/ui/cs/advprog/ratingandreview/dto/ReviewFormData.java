package id.ac.ui.cs.advprog.ratingandreview.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewFormData {
    private String content;
    private int rating;
    private String username;
    private UUID bookId;
}
