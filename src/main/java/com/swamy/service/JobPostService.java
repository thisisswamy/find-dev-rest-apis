package com.swamy.service;

import java.util.List;

import com.swamy.documents.JobPost;

public interface JobPostService {

	List<JobPost> getAllJobPosts();

	JobPost addJobPost(JobPost jobPost);

	JobPost deleteJobPostById(String id);

	List<JobPost> getAllSearchJobPostResults(String search);

	JobPost updateJobPost(JobPost jobPost);

	String deleteAlJobPosts();

	

}
