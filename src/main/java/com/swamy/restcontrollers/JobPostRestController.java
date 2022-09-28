package com.swamy.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.documents.JobPost;
import com.swamy.service.JobPostService;

@RestController
@RequestMapping("api/jobs")
@CrossOrigin(origins = {"http://localhost:4200/","https://angular-dev-finder-app.herokuapp.com/"})
public class JobPostRestController {
	
	@Autowired
	private JobPostService jobPostService;
	
	@GetMapping("/")
	public List<JobPost> getJobPosts(){
		return jobPostService.getAllJobPosts();
	}
	
	@PostMapping("/add-job-post")
	public JobPost addJobPost(@RequestBody JobPost jobPost) {
		return jobPostService.addJobPost(jobPost);	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public JobPost deleteJobPost(@PathVariable  String id) {
		return jobPostService.deleteJobPostById(id);
	}
	
	@GetMapping("/role")
	public List<JobPost> getSearchJobPosts(@RequestParam("search") String search){
		return jobPostService.getAllSearchJobPostResults(search);
	}
	
	
	@PutMapping("/job-post/edit/")
	public JobPost modifyJobPost(@RequestBody  JobPost jobPost) {
		return jobPostService.updateJobPost(jobPost);
	}
	
	@DeleteMapping("/delete-all")
	public String deleteAllPosts() {
		return jobPostService.deleteAlJobPosts();
	}
	
	

}
