app.controller("registercontroller", function ($scope,$location,$http,$rootScope,$cookieStore) {
	 $scope.msg = "Register  page";
	 $scope.Users={firstname:'',lastname:'',email:'',password:'',role:'ROLE_USER',isonline:'NO'};
	 $scope.register=function()
	 {
		 console.log("in register controller angualar");
		
		 $http.post("http://localhost:9080/Rest/user/register",$scope.Users).then(function(response){
		 
			 console.log("Registerd Successfully")
			 $scope.Users=response.data;
			 $location.path("/login")
								
			},function(error){
				console.error("Error while creating user"+error)
			});
		 
	 }
	 
	 
	 
	 $scope.login=function()
	 {
		 console.log("in login method");
		 $http.post("http://localhost:9080/Rest/user/login",$scope.Users).then(function(response)
				 {
			
			 
			 $scope.Usersdet=response.data;
			 $rootScope.currentuser=response.data;
			 console.log("ROLE"+$rootScope.currentuser.role)
			/* $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentuser;*/
					$cookieStore.put('currentUser', $rootScope.currentuser)
			 $location.path("/blog")
				 });
		 
	 }
	 
});



app.controller("logoutcontroller", function ($scope,$location,$http,$rootScope) {
console.log("in logout controlelr")
	 $scope.logout=function()
	 {
	 
		 console.log( $rootScope.currentuser.email)
			$http.get("http://localhost:9080/Rest/user/logout/"+ $rootScope.currentuser.email)
				.then(function(response)
				{
					 $rootScope.currentuser=null;
					 $location.path("/login")
					
				},function(error)
				{
					
				});
	 
	 }
	 
	 
	 
	 


	
});



	 


	
	 
	 
	 
	 


	
