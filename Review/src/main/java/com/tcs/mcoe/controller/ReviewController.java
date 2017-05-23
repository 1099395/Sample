package com.tcs.mcoe.controller;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import com.spotify.docker.client.exceptions.DockerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.mcoe.model.Review;
import com.tcs.mcoe.repository.ReviewRepository;
import com.tcs.mcoe.utility.reviewValidation;


@RestController
@RequestMapping("/review")
public class ReviewController {

  @Autowired
  private ReviewRepository reviewRepository;
  
  @RequestMapping(method = RequestMethod.POST, value="/createReview")
  public Map<String, Object> getReview(@RequestBody Map<String, Object> reviewMap){
    String productId=(reviewMap.get("productId")==null)?null:reviewMap.get("productId").toString();	
    String description=(reviewMap.get("description")==null)?null:reviewMap.get("description").toString();	
    String reviewTitle=(reviewMap.get("reviewTitle")==null)?null:reviewMap.get("reviewTitle").toString();	
    String detailedReview=(reviewMap.get("detailedReview")==null)?null:reviewMap.get("detailedReview").toString();	
	Double numberOfStars = (reviewMap.get("numberOfStars")==null)?null:Double.parseDouble(reviewMap.get("numberOfStars").toString());
	Map<String, Object> response = new LinkedHashMap<String, Object>();
	
	if(productId==null){
		response.put("productId","productId field is mandatory");
	}
	if(description==null){
		response.put("description","description field is mandatory");
	}
	if(reviewTitle==null){
		response.put("reviewTitle"," reviewTitle  field is mandatory");
	}
	if(detailedReview==null){
		response.put("detailedReview","detailedReview field is mandatory");
	}
	if(numberOfStars==null){
		 response.put("numberOfStars","numberOfStars field is mandatory");
    }
  if( productId!=null && description!=null && reviewTitle!=null && detailedReview!=null && numberOfStars!=null){{
  if(!reviewValidation.isValidproductId(productId))
		{response.put("productid" , "productId should start with p ssucceeded with numbers");
		return response;
	}
	if(!reviewValidation.isValidStars(numberOfStars))
	{
		response.put("stars", "Give stars between 0 and 5");
		return response;
		}
		}
	response.put("review","Review Successful");
	Review review = new Review(productId, description, reviewTitle, detailedReview,numberOfStars);
	response.put("review1", reviewRepository.save(review));
	}
	return response;
   }
  // @RequestMapping(method = RequestMethod.GET, value="/getReview/{reviewName}")
  // public Map<String, Object> getAllReview(@PathVariable("reviewName") String reviewName){
    // Review reviews = reviewRepository.findByReviewName(reviewName);
    // Map<String, Object> response = new LinkedHashMap<String, Object>();
	// response.put("data",reviews);
    // return response;
  // }
 }
  

