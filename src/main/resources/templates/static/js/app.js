/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("MyApp",[]);
app.controller("addRendezVousController",function($scope,$http){
	$scope.changePrescritVisibilityStatus = function(){
		if(!$scope.prescritFieldManager.value){
			$scope.prescritField="";
		}
	};	
});	
app.controller("addRendezVousController",function($scope,$http){
	 $scope.calendarDate = ""
	 $scope.findMedecinByService = function(){
		 console.log("aliiiiiiiiiiiiiiiiii "+$scope.service_id);
	 $http({
        url : 'getMedecinsByService',
        method : 'get',
        params : {service_id : $scope.service_id}
    }).then(function(response){
   	 if(response.data != null && response.data != ""){
   		 $scope.listMedecins = response.data;
   		 $scope.no_medecin = false;
   	 }
   	 else{
   		 $scope.no_medecin = true
   	 }
    });
};
	 $scope.findListMedecin=function(){
     	console.log("ayaleh"+$scope.service_id);
         $http({
             url:'listMedecin',
             method :'get',
             params :{service_id :$scope.service_id}
                
         }).then(function(response){
         	if(response.data != null && response.date!=""){
         		$scope.no_medecin = false;
         		 $scope.listMedecin=response.data;    
         	}
             else{
            	 $scope.no_medecin = true
             }
         });
       };
	
       $scope.findPatient=function(){
           $http({
               url:'angular',
               method :'get',
               params :{numPiece :$scope.numPiece}
                  
           }).then(function(response){
           	console.log(response.data);
               $scope.nomComplet=response.data.nomComplet;
               $scope.adresse=response.data.adresse;
               $scope.Telephone=response.data.telephone;
               $scope.dateNaissance=response.data.dateNaissance;
               $scope.nationalite=response.data.nationalite;
               
           });
           
       }; 
	$scope.getCalendar = function(){
		console.log( $scope.medecinChoisie);
		$http({
	        url : 'calendar',
	        method : 'get',
	        params : { medecinChosie : $scope.medecinChoisie , datePatern : $scope.calendarDate}
	    }).then(function(response){
	   		console.log(response.data);
		   	 if(response.data != null && response.data != ""){
		   		 $scope.dataCalendar = response.data;
		   	 }
		   	 else{
		   		console.log("pas donne dans datacalandar");
		   	 }
	    });
	};
});


