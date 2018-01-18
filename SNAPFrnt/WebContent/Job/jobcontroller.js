
app.controller("jobcontroller", function ($scope,$http,$location,$rootScope) {
$scope.Job={jobprofile:'',jobdesc:'',qualification:'',salary:''};	

	function fetchAllJobs()
	{
		console.log("fetched all jobs")
		$http.get("http://localhost:9080/Rest/jobs/getAllJobs")

		.then(function(response) {
			$rootScope.jobsdata = response.data;
			console.log("all jobs fetched")
		});
		
		
		console.log("fetched all jobs")
		$http.get("http://localhost:9080/Rest/jobs/myjobs/"+$rootScope.currentuser.userid)

		.then(function(response) {
			$rootScope.myjobs = response.data;
			console.log("all my jobs fetched")
		});
		
		
		
	};
	
	fetchAllJobs();
	
	$scope.insertJobs = function()
	{
		console.log('entered insertJobs');
		$http.post('http://localhost:9080/Rest/jobs/addJob',
				$scope.Job).then(fetchAllJobs(), function(response) {
			console.log("successful jobs entered");
			$location.path("/blog")
		});
	}
	
	
	$scope.applyJob = function(idd)
	{
		console.log('apply job'+idd);
		$http.get('http://localhost:9080/Rest/jobs/applyJob/'+idd+"/"+$rootScope.currentuser.userid).then(fetchAllJobs(), function(response) {
			console.log("successful jobs applied");
			$location.path("/blog")
		});
	}
	
	$scope.getjob = function(idd)
	{
		
		$http.get('http://localhost:9080/Rest/jobs/getJob/'+idd).then(function(response) {
			$rootScope.gjob=response.data;
			console.log($rootScope.gjob.jobprofile+$rootScope.gjob.company)
		
		
	},function(error){
		console.log("Error on retrieving job")
	});
	
		
		
		$scope.deletejob = function(idd)
		{
			
			$http.get('http://localhost:9080/Rest/jobs/getJob/'+idd).then(function(response) {
				
			
			
		},function(error){
			
		});
			
		}	
			
				
				
					
		
		$http.get('http://localhost:9080/Rest/jobs/checkifapplied/'+idd+"/"+$rootScope.currentuser.userid).then(function(response) {
			$rootScope.gcheck=response.data;
			console.log(gcheck)
			
			
			});
		
		
		
		$http.get("http://localhost:9080/Rest/jobs/jobapplicants/"+idd)
		.then(function(response)
		{
			
			$rootScope.jobapps=response.data;
			
			
		},function(error)
		{
			
		});

		
		
		
		$location.path("/jobview")

	}
	
	$rootScope.deletejob = function(idd)
	{
		
		$http.get('http://localhost:9080/Rest/jobs/deleteJob/'+idd).then(function(response) {
			
		
		
	},function(error){
		
	});
		
		$location.path("/blog")
		
	}	
	
	$scope.fetchjobforedit=function(idd)
	{
		
		$http.get("http://localhost:9080/Rest/jobs/getJob/"+idd).then(function(response) {
			console.log('get job for edit method ok'+idd)
			$rootScope.ejob=response.data;
							
				
					});
		$location.path('/jobforedit')
		
		
	}
	
	
	$scope.editjob=function(idd)
	{
		console.log(idd)
	if($scope.Job.jobprofile==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.jobprofile;
			}
		
		if($scope.Job.jobdesc==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.jobdesc;
			}
		
		
		if($scope.Job.qualification==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.qualification;
			}
		
		
		if($scope.Job.salary==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.salary;
			}
		
		
		
		
		$http.get("http://localhost:9080/Rest/jobs/updateJob/"+idd+"/"+$scope.Job.jobprofile+"/"+$scope.Job.jobdesc+"/"+$scope.Job.qualification+"/"+$scope.Job.salary).then(function(response) {
		
			 console.log("job updated successfully");
				
		},function(error){
			console.error("Error while updating job");
		
		});
		
		$location.path("/blog")
		
		
	}
	
	
	
	
	
});