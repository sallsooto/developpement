/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app =angular.module("RendeVousApp",[]);
app.controller("RVController",function($scope,$http){

    $scope.findPatient=function(){
        $http({
            url:'angular',
            method :'get',
            params :{numPiece :$scope.numPiece}
               
        }).then(function(response){
        	console.log(response.data);
            $scope.numPiece=response.data.numPiece;
            $scope.nomComplet=response.data.nomComplet;
            $scope.adresse=response.data.adresse;
            $scope.Telephone=response.data.telephone;
            $scope.dateNaissance=response.data.dateNaissance;
            
            
        });
        
    }; 
        $scope.findListMedecin=function(){
        	console.log($scope.idservice);
            $http({
                url:'listMedecin',
                method :'get',
                params :{idservice :$scope.idservice}
                   
            }).then(function(response){
            	if(response.data != null && response.date!=""){
            		alert(response.data[0]+"jhijhmoh");
            		
            	}
                $scope.listMedecin=response.data;                                          
            });
          };
  
});


