package series;
public class SquareSeries{
int n;
public SquareSeries(){
this.n=1;
}
public SquareSeries(int n){
this.n=n;
}
public void display(){
int ans=0;
for(int i=1;i<=n;i++){
ans=i*i;
System.out.print(ans+" ");
}
}
}