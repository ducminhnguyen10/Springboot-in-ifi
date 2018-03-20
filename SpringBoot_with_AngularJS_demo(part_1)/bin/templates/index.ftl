<!DOCTYPE html>
 
<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="../static/css/app.css" rel="stylesheet"/>
        <link href="../static/css/bootstrap.css" rel="stylesheet"/>
    </head>
    <body>
 
        <div ui-view></div>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.3/angular-ui-router.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/localforage/1.6.0/localforage.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.11/ngStorage.min.js"></script>
        <script src="../static/js/app.js"></script>
        <script src="../static/js/ProductService.js"></script>
        <script src="../static/js/ProductController.js"></script>
    </body>
</html>