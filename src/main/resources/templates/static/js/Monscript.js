/**
 * 
 */

document.getElementById("hiddenField").style.display = "none";

function display()
{
	var chk = document.getElementById("chk");
if(chk.checked ==1)
{
        document.getElementById("hiddenField").style.display = "block";
        
}
else{
	document.getElementById("hiddenField").style.display = "none";
}
}   