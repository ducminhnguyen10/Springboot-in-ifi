<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Specific Product </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.product.productNumber" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="productName">Product name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.product.productName" id="productName" class="username form-control input-sm" placeholder="Enter your name product" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="dateOfPayment">Date of payment</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.product.dateOfPayment" id="dateOfPayment" class="form-control input-sm" placeholder="Enter your date of payment" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
     
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="price">Price</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.product.price" id="price" class="form-control input-sm" placeholder="Enter your price" required ng-pattern="ctrl.onlyNumbers"/>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.product.productNumber ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled ="myForm.$invalid || myForm.$pristine" />
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Products </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Product number (ID)</th>
                        <th>Product name</th>
                        <th>Date of payment</th>
                        <th>Price</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllProducts()">
                        <td>{{u.productNumber}}</td>
                        <td>{{u.productName}}</td>
                        <td>{{u.dateOfPayment}}</td>
                        <td>{{u.price}}</td>
                        <td><button type="button" ng-click="ctrl.editProduct(u.productNumber)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeProduct(u.productNumber)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>      
            </div>
        </div>
    </div>
</div>