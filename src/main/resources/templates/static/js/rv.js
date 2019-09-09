/**
 * 
 */

$("#btn_suivant").click(function() {
		
	 var ladate= $("#jour1").text();
     var tabdate = ladate.split("/");
     ladate = tabdate[2]+"/"+tabdate[1]+"/"+tabdate[0];
     ladate = new Date(ladate);
     ladate.setDate(ladate.getDate()+6)
     for(var i = 1;i<=5;i++){
         ladate.setDate(ladate.getDate()+1);
         var day = ladate.getDate();
         var month = ladate.getMonth()+1;
         var output = ((''+day).length<2 ? '0' : '') + day + '/' +
             ((''+month).length<2 ? '0' : '') + month + '/' +
             ladate.getFullYear();
         $("#jour"+i).html(output);
     }
     loadtable("gvkjgkj");
	});
$("#btn_precedent").click(function() {
	 var lundiOne=$('#lundiONE').val();
	 
	 var ladate= $("#jour1").text();
	 
	 if(lundiOne != ladate){
		 var tabdate = ladate.split("/");
		    ladate = tabdate[2]+"/"+tabdate[1]+"/"+tabdate[0];
		    ladate = new Date(ladate);
		    ladate.setDate(ladate.getDate()-6)
		    for(var i = 1;i<=5;i++){
		        ladate.setDate(ladate.getDate()-1);
		        var day = ladate.getDate();
		        var month = ladate.getMonth()+1;
		        var output = ((''+day).length<2 ? '0' : '') + day + '/' +
		            ((''+month).length<2 ? '0' : '') + month + '/' +
		            ladate.getFullYear();
		        $("#jour"+i).html(output);
		    }
		    
	 }
	 else{
	    	alert("c pas possible d recule")
	    }
    
	});

function loadtable(date1){
    var formData = {
            ladate : date1
        }
       
        
        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "ajax",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if(result.status == "Done"){
                    

                }
                console.log(result);
            },
            error : function(e) {
                alert("Une erreur est survenue");
                console.log("ERROR: ", e);

            }
        });
}