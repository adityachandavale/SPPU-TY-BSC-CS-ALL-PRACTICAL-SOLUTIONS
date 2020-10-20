package series;
public class PrimeSeries{
int n;
public PrimeSeries(){
this.n=1;
}
public PrimeSeries(int n){
this.n=n;
}
public void display(){
int cnt=0;
int d;
int flag;
int no=2;
//int temp;
do{
//temp=no/2;
d=2;
flag=0;
while(no>d){ //(no>d && d!=temp) //for(d=2;no>d;d++)
if(no%d==0){
flag=1;
break;
}
d++;
}
if(flag==0){
cnt++;
System.out.print(no+" ");
}
no++;
}while(cnt!=n);
}
}