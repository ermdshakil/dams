package com.dams.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewsDto {
	
	private Long reviewId;
	private Long patient;
	private Long doctor;
	private int rating;
	private String review_text;
	private Timestamp createdAt;


}
