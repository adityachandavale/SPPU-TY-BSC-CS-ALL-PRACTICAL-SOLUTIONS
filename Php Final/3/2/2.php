<?php
$name=$_POST['name'];
$flag=0;
$dom=new DOMDocument();
$dom->load('.xml');
$allbooks=$dom->getElementsByTagName("Book");
foreach($allbooks as $book){
$bookname=$book->getElementsByTagName("BookName");
$booknamevalue=$bookname->item(0)->nodeValue;
if((strcmp($booknamevalue,$name))==0){
$flag=1;
break;
}
}
if($flag==1){
$bookno=$book->getElementsByTagName("BookNo");
$booknovalue=$bookno->item(0)->nodeValue;
$authorname=$book->getElementsByTagName("AuthorName");
$authornamevalue=$authorname->item(0)->nodeValue;
$price=$book->getElementsByTagName("Price");
$pricevalue=$price->item(0)->nodeValue;
$year=$book->getElementsByTagName("Year");
$yearvalue=$year->item(0)->nodeValue;
echo "BOOK NO : ".$booknovalue."<br />";
echo "AUTHOR NAME : ".$authornamevalue."<br />";
echo "PRICE : ".$pricevalue."<br />";
echo "YEAR : ".$yearvalue."<br />";
}else
echo "Book not found";
?>