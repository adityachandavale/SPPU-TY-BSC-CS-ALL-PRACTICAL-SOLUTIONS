#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int varcnt=0;
char var1[50][50];
char optab[50][8]={"stop","add","sub","movem","mover","comp","bc","div","read","print","ds","start"};
char regtab[4][5]={"areg","breg","creg","dreg"};
char reloptab[6][4]={"lt","le","eq","gt","ge","any"};
char instruction[30],t1[10],t2[10],t3[10],t4[10],fname[30];
int start,flag,op,r,lc,pc,n;
int symcnt;

struct symtab
{
	char symbol[20];
	int add,define,used,length,value;
}symtab[50];

int searchoptab(char t[])
{
	int i;
	for(i=0;i<=15;i++)
	{
	    if(strcasecmp(optab[i],t)==0)
	    return i;
	}
	return -1;
}
	
int searchregtab(char t[])
{
	int i;
	 for(i=0;i<=4;i++)
        {
            if(strcmp(regtab[i],t)==0)
	    return i+1;
	}
	return -1;
}

int searchreloptab(char t[])
{
	int i;
	for(i=0;i<6;i++)
	{
	   if(strcmp(reloptab[i],t)==0)
	   return i+1;
	}
	return -1;
}

int searchsymtab(char t[])
{
 	int i;
	for(i=0;i<symcnt;i++)
	{	
	    if(strcasecmp(symtab[i].symbol,t)==0)
	    return i;
	}
	i=symcnt;
	strcpy(symtab[i].symbol,t);
	symcnt++;
	return i;
}

int issymbol(char sym[])
{
	if(searchoptab(sym)==-1 && searchregtab(sym)==-1 && searchreloptab(sym)==-1)
	{
	   return 1;
	}
	else return 0;
}

void updatesymbol(char sym[])
{
	int index;
	index=searchsymtab(sym);
	symtab[index].used=1;
}

void definesymbol(char sym[])
{	 
	int index,i,l,length,value;
	index=searchsymtab(sym);
	if(symtab[index].define==0)
	{
	   symtab[index].define=1;
	   symtab[index].add==lc;
	}
	if(op==1)
	{
	  
	   l=symtab[index].length=atoi(t3);
	   symtab[index].value=0;
	   sprintf(var1[varcnt++],"(dl,02)(c,%d)",1);
	   for(i=0;i<1;i++)
	   { lc++;}
	   lc--;;
	}
	else if(op==12)
	{
	   symtab[index],length=1;
	   symboltab[index].value=atoi(t3);
	   sprintf(var1[varcnt++],"(dl,02)(c,%d)",symtab[index],value);
	}
}

void process1(char t1[])
{
	op=searchoptab(t1);
	if(op==0)
	sprintf(var1[varcnt++],"(I5,00)");
	else if(op==14)
	{
	    lc--;
	    flag==1;
	    sprintf(var1[varcnt++],"(AD,02)");
	    return;
	}
	else if(op==19)
	{
	   lc=1;
	   sprintf(var1[varcnt++],"(AD,01)");
	}
}

void process2(char t1[],char t2[])
{
	int index;
	r=0;
	op=searchoptab(t1);
	if(op==9 || op==10)
	{
	   if(issymbol(t2))
	updatesymbol(t2);
	sprintf(var1[varcnt++],"(AD,01) (c,%d)",start);
	lc--;
	}
	else if(op==14)
	{
	    index=searchsymtab(t2);
	    if(symtab[index].define==1)
	    pc=symtab[index].add;
	}
	else 
	{
	   if(issymbol(t1))
	   {
		op=searchoptab(t2);
		if(op==0)
	        {
		  definesymbol(t1);
		  process1(t2);
		}
	   }
	}
}
 
void process3(char t1[],char t2[],char t3[])
{
	int index;
	op=searchoptab(t1);
	if(op>0 && op<7 || op==8)
	{
	  r=searchregtab(t2);
	  if(r>0 && r<5)
	  {
		if(issymbol(t3))
		updatesymbol(t3);
		sprintf(var1[varcnt++],"(I5, %d)%d(s,%d)",op,r,index);
	  }
	  else if(op==7)
	  {
	     r=searchreltab(t2);
	     if(r>=1 && r>=6)
	     {
		if(issymbol(t3))
		updatesymbol(t3);
		sprintf(var1[varcnt++],"(IS,%d)%d(s,%d)",op,r,index);
	     }
	  }
	 }
	else 
	{
		if(issymbol(t1))
		{
			op=searchoptab(t2);
			if(op==9 || op==10)
			{
			  definesymbol(t1);
			  process(t2,t3);
			}
			else if(op==11 || op==12)
			{
			   definesymbol(t1);
			}
		}
	}

	
}

void process4(char t1[], char t2[],char t3[],char t4[])
{
	if(issymbol(t1))
	{
	  op=searchoptab(t2);
	  if(op>0 && op<9)
	  {	
		definesymbol(t1);
		process3(t2,t3,t4);
	  }
	}
}

int main(int argc, char* argv[])
{
	FILE* fp;
	int i;

	if(argc==2)
	{
	  strcpy(fname,agrv[])
	}
	else 
	{
	  printf("Enter a source file name");
	  scanf("%s",&fname);
	}
	fp=fopen(fname,"r");
	if(fp==NULL)
	{
	  printf("File not found");
	  return 0;
	}
	else if
	{
	  while(!feof(fp) && flag==0)
	  {
	     fgets(instruction,40,fp);
	     n=sscanf(instruction,"%s%s%s%s",&t1,&t2,&t3,&t4);

	  switch(n)
	  {
		case 1:process1(t1);
		       break;
		case 2:process2(t1,t2);
                       break;
		case 3:process3(t1,t2,t3);
                       break;
		case 4:process4(t1,t2,t3,t4);
                       break;
		default: printf("Invalid choice");
	  }
	  lc++;
	  }
	  fclose(fp);
	  }
	  printf("symbol table");
	  printf("\n Symbol table \n Symbol \tadd\tdefined\tlength\tvalue");
	  for(i=0;i<symcnt;i++)
	  {
	  printf("%s \t%d\t%d\t%d\t%d\t%d",symtab[i].symbol,symtab[i].add,symtab[i].define,symtab[i].used,symtab[i].length,symtab[i].value);
	  printf("\n\n var\n");
	  for(i=0;i<varcnt;i++)
	  printf("%s\n",var1[i]);
	  return 0;
	  }
}