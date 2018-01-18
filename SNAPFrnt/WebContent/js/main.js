var app = angular.module("Snap", ['ngRoute','ngCookies']);
app.config(function($routeProvider) {
	
    $routeProvider
    .when("/", {
        templateUrl : "User/login.html",
       
    })
   
    .when("/login", {
        templateUrl : "User/login.html",
       
    })
    .when("/register", {
        templateUrl : "User/register.html",
        
    })
   .when("/jobmanage", {
        templateUrl : "Job/jobmanage.html",
        
    })
      .when("/mywall", {
        templateUrl : "pages/mywall.html",
        
    })


    .when("/blog", {
        templateUrl : "pages/home.html",
       
       
    })
  
    
    .when("/newblog", {
        templateUrl : "Blog/newblog.html",
       
       
    })
  
       .when("/newforum", {
        templateUrl : "Forum/newforum.html",
       
       
    })
  
       .when("/newjob", {
        templateUrl : "Job/newjob.html",
       
       
    })
  
    
     .when("/forumview", {
        templateUrl : "Forum/forumview.html",
        controller:"forumcontroller",
        
    })
    
        
     .when("/jobview", {
        templateUrl : "Job/jobview.html",
        controller:"jobcontroller",
        
    })
    
    
    
     .when("/forumrequests", {
        templateUrl : "Forum/forumrequests.html",
       
        
    })
    
    
      .when("/blogrequests", {
        templateUrl : "Blog/blogrequests.html",
       
        
    })
    
    
      .when("/forummanage", {
        templateUrl : "Forum/forummanage.html",
        
    })
    .when("/blogmanage", {
        templateUrl : "Blog/blogmanage.html",
        
    })
    
    
      .when("/blogforedit", {
        templateUrl : "Blog/updateblog.html",
        
    })
    
     .when("/forumforedit", {
        templateUrl : "Forum/updateforum.html",
        
    })
    
     .when("/chat", {
        templateUrl : "chat/chat.html",
        
    })
    .when("/jobforedit", {
        templateUrl : "Job/updatejob.html",
        
    })
     .when("/friendwall", {
        templateUrl : "Friend/friendpreview.html",
        
    })
    .when("/noti", {
        templateUrl : "noti/notifications.html",
  
    })
    
      .when("/blogview", {
        templateUrl : "Blog/blogview.html",
  
    });
   });



   app.run( function ($rootScope, $location, $cookieStore, $http) 
		{
	       
		 $rootScope.$on('$locationChangeStart', function (event, next, current) 
					 {/*
						 console.log("$locationChangeStart")
						    
						 var userPages = ['/myProfile','myFriends','pendingRequests','sentRequests','/upload','/viewUsers','/addBlogs','/addForum','/viewProfile','/viewBlog','/viewForum','/viewForums'];
						 var adminPages = ['/admin','/manageUsers','/manageJobs','/manageEvents','/manageForums','/manageBlogs','/addEvents','/addJobs','/jred','/ered','/appliedJobs'];
						 
						 var currentPage = $location.path();
						 
						 var isUserPage = $.inArray(currentPage, userPages);
						 var isAdminPage = $.inArray(currentPage, adminPages);
						 
						 var isLoggedIn = $rootScope.currentUser.username;
					        
					     console.log("isLoggedIn:" +isLoggedIn)
					     console.log("isUserPage:" +isUserPage)
					     console.log("isAdminPage:" +isAdminPage)
					        
					        if(!isLoggedIn)
					        	{
					        	
					        		if(isUserPage!=-1 || isAdminPage!=-1)  
					        	 	{
						        	  console.log("Navigating to login page:")
						        	  alert("You need to Login first!")
						        	  $location.path('/login');
						         	}
					        	}
					        
							 else //logged in
					        	{
					        	
								 var role = $rootScope.currentUser.role;
								 if(isAdminPage!=-1 && role!='ADMIN' )
									 {
									  alert("You cannot view this page as a " + role )
									  $location.path('/');
									 }
					        	}
					 */});
					 
					 // to keep the user logged in after page refresh
				    $rootScope.currentuser = $cookieStore.get('currentUser') || {};
				   /* if ($rootScope.currentuser)
				    {
				        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentuser; 
				    }*/
		
				});
       