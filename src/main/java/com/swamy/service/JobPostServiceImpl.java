package com.swamy.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.documents.JobPost;
import com.swamy.repo.JobPostRepo;

@Service
public class JobPostServiceImpl implements JobPostService {
	
	@Autowired
	private JobPostRepo jobPostRepo;
	
	
	public String uniqUUID() {
		UUID randomString= UUID.randomUUID();
		return randomString.toString();
	}

	@Override
	public List<JobPost> getAllJobPosts() {
		List<JobPost> jobPostList = jobPostRepo.findAll();
		return jobPostList;
	}

	@Override
	public JobPost addJobPost(JobPost jobPost) {
		JobPost job=new JobPost();
		job.setId(uniqUUID());
		job.setCompanyName(jobPost.getCompanyName());
		job.setRole(jobPost.getRole());
		job.setSalary(jobPost.getSalary());
		job.setSkills(jobPost.getSkills());
		job.setExperience(jobPost.getExperience());
		JobPost savedPost = jobPostRepo.save(job);
	
		return savedPost;
	}

	@Override
	public JobPost deleteJobPostById(String id) {
		JobPost deletedPost=jobPostRepo.deleteJobPostById(id);
		return deletedPost;
	}

	@Override
	public List<JobPost> getAllSearchJobPostResults(String search) {
		List<JobPost> listOfPosts=jobPostRepo.searchJobPosts(search);
		return listOfPosts;
	}

	@Override
	public JobPost updateJobPost(JobPost jobPost) {
		JobPost updatedPost=jobPostRepo.save(jobPost);
		return updatedPost;
	}

	@Override
	public String deleteAlJobPosts() {
		jobPostRepo.deleteAllDocuments();
		if(getAllJobPosts().size()<1) {
			return "Success fully deleted all Post";
		}
		return "Server Error Occured";
		
	}


}
