


app.controller("registercontroller", function ($scope,$location,$http,$rootScope) {
	 $scope.msg = "Register  page";
	 $scope.Users={firstname:'',lastname:'',email:'',password:'',role:'ROLE_USER',isonline:'NO'};
	 $scope.register=function()
	 {
		 console.log("in register controller angualar");
		
		 $http.post("http://localhost:8080/SayhiMiddleware/user/register",$scope.Users).then(function(response){
		 
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
		 $http.post("http://localhost:8080/SayhiMiddleware/user/login",$scope.Users).then(function(response)
				 {
			
			 
			 $scope.Usersdet=response.data;
			 $rootScope.currentuser=response.data;
			 console.log("ROLE"+$rootScope.currentuser.role)
			 $location.path("/blog")
				 });
		 
	 }
	 
});



app.controller("logoutcontroller", function ($scope,$location,$http,$rootScope) {
console.log("in logout controlelr")
	 $scope.logout=function()
	 {
	 
		 console.log( $rootScope.currentuser.email)
			$http.get("http://localhost:8080/SayhiMiddleware/user/logout/"+ $rootScope.currentuser.email)
				.then(function(response)
				{
					 $rootScope.currentuser=null;
					 $location.path("/login")
					
				},function(error)
				{
					
				});
	 
	 }
	 
	 
	 
	 


	
});
