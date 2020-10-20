function focus(){
f1.name.focus();
}f
unction validateage(){
var no=/^[0-9]+$/; //pattern for 0-9 numbers
var age=document.getElementById("age").value;
if(age==""){
alert("age can't be empty");
document.getElementById("age").focus();
return;
}/
/if((isNan(age)) || (age<1 || age>20)){
if((!age.match(no)) || (age<1 || age>20)){
alert("age must be between 1 and 20");
document.getElementById("age").value="";
document.getElementById("age").focus();
return;
}
}f
unction validatename(){
var name=f1.name.value;
if(name==""){
alert("name can't be empty");
f1.name.focus();
return;
}
}