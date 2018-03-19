'task strict';
 
angular.module('crudApp').controller('ProductController',
    ['ProductService', '$scope',  function( ProductService, $scope) {
 
        var self = this;
        self.product = {};
        self.products=[];
 
        self.submit = submit;
        self.loadAllProducts = loadAllProducts;
        self.createProduct = createProduct;
        self.updateProduct = updateProduct;
        self.removeProduct = removeProduct;
        self.editProduct = editProduct;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
 
        function submit() {
            console.log('Submitting');
            if (self.product.productNumber === undefined || self.product.productNumber === null) {
                console.log('Saving New Product', self.product);
                createProduct(self.product);
            } else {
                updateProduct(self.product, self.product.productNumber);
                console.log('Product updated with product number ', self.product.productNumber);
            }
        }
 
        function createProduct(product) {
            console.log('About to create product');
            ProductService.createProduct(product)
                .then(
                    function (response) {
                        console.log('Product created successfully');
                        self.successMessage = 'Product created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.task={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Product');
                        self.errorMessage = 'Error while creating Product: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
 
 
        function updateProduct(product, productNumber){
            console.log('About to update product');
            ProductService.updateProduct(product, productNumber)
                .then(
                    function (response){
                        console.log('Product updated successfully');
                        self.successMessage='Product updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Product');
                        self.errorMessage='Error while updating Product '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
 
 
        function removeProduct(productNumber){
            console.log('About to remove Product with product number'+productNumber);
            ProductService.removeProduct(productNumber)
                .then(
                    function(){
                        console.log('Product '+productNumber + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing product '+productNumber +', Error :'+errResponse.data);
                    }
                );
        }
 
 
        function getAllProducts(){
            return ProductService.getAllProducts();
        }
 
        function editProduct(productNumber) {
            self.successMessage='';
            self.errorMessage='';
            ProductService.getProduct(productNumber).then(
                function (product) {
                    self.product = product;
                },
                function (errResponse) {
                    console.error('Error while removing product ' + productNumber + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.task={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);