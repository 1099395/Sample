package com.tcs.mcoe.model;

import org.springframework.data.annotation.Id;
// import org.springframework.data.annotation.Range;
 // import java.lang.Object;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="review")
public class Review {
@Id
    private String reviewId;
    private String productId;
    private String description;
    private String reviewTitle;
    private String detailedReview;
	 //@Range(min = (long) 0.0, max = (long) 10.0)
    private double numberOfStars;

  
  public Review(){}
  
  public Review( String productId, String description, String reviewTitle, String detailedReview, double numberOfStars){
    this.productId= productId;
    this.description= description;
    this.reviewTitle= reviewTitle;
    this.detailedReview= detailedReview;
	
    this.numberOfStars=numberOfStars;
  }
  
  public String getReviewId() {
    return reviewId;
  }
  
  public void setReviewId(String reviewId) {
    this.reviewId= reviewId;
  }
  
  public String getProductId() {
    return productId;
  }
  
  public void setProductId(String productId) {
    this.productId= productId;
  }
  
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description= description;
  }
  
  public String getReviewTitle() {
    return reviewTitle;
  }
  public void setReviewTitle(String reviewTitle) {
    this.reviewTitle= reviewTitle;
  }
  
  public String getDetailedReview() {
    return detailedReview;
  }
  public void setDetailedReview(String detailedReview) {
    this.detailedReview= detailedReview;
  }
  
  public double getNumberOfStars() {
    return numberOfStars;
  }
  public void setNumberOfStars(double numberOfStars) {
    this.numberOfStars= numberOfStars;
  }
}

