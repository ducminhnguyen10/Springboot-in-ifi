'use strict';
 
angular.module('crudApp').factory('ProductService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
                loadAllProducts: loadAllProducts,
                getAllProducts: getAllProducts,
                getProduct: getUProduct,
                createProduct: createProduct,
                updateProduct: updateProduct,
                removeProduct: removeProduct
            };
 
            return factory;
 
            function loadAllProducts() {
                console.log('Fetching all products');
                var deferred = $q.defer();
                $http.get(urls.PRODUCT_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all products');
                            $localStorage.products = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading products');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllProducts(){
                return $localStorage.products;
            }
 
            function getProduct(prodcutNumber) {
                console.log('Fetching Product with productNumber :'+productNumber);
                var deferred = $q.defer();
                $http.get(urls.PRODUCT_SERVICE_API + productNumber)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Product with product Number:'+productNumber);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Product with product Number :'+productNumber);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function createProduct(product) {
                console.log('Creating product');
                var deferred = $q.defer();
                $http.post(urls.PRODUCT_SERVICE_API, product)
                    .then(
                        function (response) {
                            loadAllProducts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Product : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function updateProduct(product, productNumber) {
                console.log('Updating Product with product Number '+productNumber);
                var deferred = $q.defer();
                $http.put(urls.PRODUCT_SERVICE_API + productNumber, product)
                    .then(
                        function (response) {
                            loadAllProducts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Product with product Number :'+productNumber);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function removeProduct(productNumber) {
                console.log('Removing Product with product Number '+productNumber);
                var deferred = $q.defer();
                $http.delete(urls.PRODUCT_SERVICE_API + productNumber)
                    .then(
                        function (response) {
                            loadAllProducts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Product with product Number :'+productNumber);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
        }
    ]);