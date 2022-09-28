package com.swamy.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.swamy.documents.JobPost;
@Repository
public interface JobPostRepo extends MongoRepository<JobPost, String>{
	
	@Query(value = "{'id': ?0}",delete = true)
	public JobPost deleteJobPostById(String id);
	
	@Query(value = "{'role':?0}")
	public List<JobPost> searchJobPosts(String search);
	
	@Query(value = "{}",delete = true)
	public void deleteAllDocuments();
	

}
