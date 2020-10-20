package sy;
public class SyMarks{
private int comp;
private int maths;
private int elect;
public void setSyMarks(int comp,int maths,int elect){
this.comp=comp;
this.maths=maths;
this.elect=elect;
}
public int getCompMarks(){
return comp;
}
public int getMathsMarks(){
return maths;
}
public int getElectMarks(){
return elect;
}
}