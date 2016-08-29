<html>
<head>
<link rel="stylesheet" href="/css/appstyle.css" type="text/css" />
<script language="javascript" src="/js/angular.min.js"></script>
<script language="javascript" src="/js/app.js"></script>
</head>

<body ng-app="MyCat" ng-controller="MyCatalouge">
<h2>Hello World!</h2>
<table class="table table-stript">
<thead>
<tr>
<th>Product Id</th><th>Product Name</th><th>Product Description</th><th>Category</th><th>Price</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="p in product">
<td>{{p.productId}}</td>
<td>{{p.productName}}</td>
<td>{{p.productDescripion}}</td>
<td>{{p.category}}</td>
<td>{{p.price}}</td>


</tr>
</tbody>




</table>




</body>
</html>
