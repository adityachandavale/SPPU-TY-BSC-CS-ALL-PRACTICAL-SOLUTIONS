#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char variant1[50][50];
int varcnt=0;

char optab[15][8]={"STOP","ADD","SUB","MUL","MOVER","MOVEM","COMP","BC","DIV","READ","PRINT","DS","DC","START","END"};
char regtab[4][5]={"AREG","BREG","CREG","DREG"};
char reloptab[6][4]={"LT","LE","EQ","GT","GE","ANY"};

char instruction[30],t1[10],t2[10],t3[10],t4[10];

char fname[30];
int start,flag;
int op,r,ind;
int lc,pc,n;
int symcnt;

struct symtab{
	char symbol[10];
	int address,define,used,length,value;
}symtab[40];


int searchoptab(char t[]){

	int i;
	for(i=0;i<15;i++){
		if(strcasecmp(optab[i],t)==0)
			return i;
		}
	return -1;
}

int searchregtab(char t[]){

	int i;
	for(i=0;i<4;i++){
		if(strcasecmp(regtab[i],t)==0)
			return i+1;
		}
	return -1;
}

int searchreloptab(char t[]){

	int i;
	for(i=0;i<6;i++){
		if(strcasecmp(reloptab[i],t)==0)
			return i+1;	
		}
	return -1;
}
 int searchsymtab(char t[]){

	int i;
	for(i=0;i<symcnt;i++){
		if(strcasecmp(symtab[i].symbol,t)==0)
			return i;	
		}

		i=symcnt;
		strcpy(symtab[i].symbol,t);
		symcnt++;
		return i;
}

int issymbol(char sym[]){
	if(searchoptab(sym)==-1 || searchregtab(sym)==-1 || searchreloptab(sym)==-1 )
		return 1;
	else{
		return 0;
	}
}

void updatesymbol(char sym[]){
	ind=searchsymtab(sym);
	symtab[ind].used=1;
}

void definesymbol(char sym[]){

	ind=searchsymtab(sym);
	if(symtab[ind].define==0){
		symtab[ind].define=1;
		symtab[ind].address=lc;
	}
	if(op==11){
		int i,l;
		l=symtab[ind].length=atoi(t3);
		symtab[ind].value=0;
		sprintf(variant1[varcnt++],"(DL,02) (C,%d)",l);
		for(i=0;i<l;i++)
			lc++;
			lc--;
	}
	else if(op==12){
		symtab[ind].length=1;
		symtab[ind].value=atoi(t3);
		sprintf(variant1[varcnt++],"(DL,01) (C,%d)",symtab[ind].value);
	}
}			

void case1(char t1[])
{

	
	op=searchoptab(t1);
		if(op==0)
			sprintf(variant1[varcnt++], "(IS,00)");
		else if(op==14){
			lc--;
			flag=1;
			sprintf(variant1[varcnt++], "(AD,02)");
			return;
		}
		else if(op==13)
          {
		lc=-1;
		sprintf(variant1[varcnt++],"(AD,01)");

		}
                 else printf("Invalid opcode or imperative statement");
}

void case2(char t1[],char t2[])
{
	r=0;
	op=searchoptab(t1);
	if(op==9 || op==10)
	{
 		 if(issymbol(t2))
 			updatesymbol(t2);
			sprintf(variant1[varcnt++],"(IS,%d),%s",op,t3);
		}
		else if(op==13){
			start=lc=atoi(t2);
			sprintf(variant1[varcnt++],"(AD,01) (C,%d)",start);
			lc--;
		}
		else if(op==14){
			ind=searchsymtab(t2);
			if(symtab[ind].define==1)
				pc=symtab[ind].address;
		}
	else{
		if(issymbol(t1)) 
 			{
			op=searchoptab(t2);
				if(op==0)
				{
					definesymbol(t1);
					case1(t2);
				}
	       	     } else printf("Invalid Register Number");
 
	  }
}

	
void case3(char t1[],char t2[],char t3[])
 
     {

	op=searchoptab(t1);
	if(op>0 && op<7 || op==8)
		r=searchregtab(t2);
		if(r>0 && r<5)
          {
			if(issymbol(t3))
				updatesymbol(t3);
				sprintf(variant1[varcnt++],"(IS,%d) %s %s",op,t2,t3);
		}
	else if(op==7)
        {
		r=searchreloptab(t2);
		if(r>=1 && r<=6)
        {
			if(issymbol(t3))
				updatesymbol(t3);
				sprintf(variant1[varcnt++],"(IS,%d) %s %s",op,t2,t3);
		}
	}
	else
       {
		if(issymbol(t1))
          {
			op=searchoptab(t2);
 		if(op==9 ||op==10) 
 	 	{
			definesymbol(t1);
			case2(t2,t3);
		}
	
   }  else printf("invalid condition code");
          }
}

void case4(char t1[],char t2[],char t3[],char t4[])
       {
	if(issymbol(t1))
	{
		op=searchoptab(t2);
		if(op>0 && op<9)
		{
			definesymbol(t1);
			case3(t2,t3,t4);
		}
            else printf("undefined symbol");
    }
}	

int main(int argc,char *argv[]){

	FILE *fp;
	int i,n;
	if(argc==2)
		strcpy(fname,argv[1]);
	else{
			printf("\nEnter the source name: ");
			scanf("%s",fname);
		}
	fp=fopen(fname,"r");
	if(fp==NULL){
		printf("FILE NOT FOUND");
		return 0;
	}
	else{
		while(!feof(fp) && flag==0){
			fgets(instruction,40,fp);
			n=sscanf(instruction,"%s%s%s%s",t1,t2,t3,t4);

			switch(n){
				case 1:case1(t1);
						break;
				case 2:case2(t1,t2);
						break;
				case 3:case3(t1,t2,t3);
						break;
				case 4:case4(t1,t2,t3,t4);
						break;
				default :printf("\nINVALID INPUT\n");
			}
		lc++;
		}
		fclose(fp);
	}
printf("\n**SYMBOL TABLE**");
printf("\nSYMBOL\tADDRESS\tDEFINE\tUSED\tLENGTH\tVALUE");
for(i=0;i<symcnt;i++){
	printf("\n%s\t%d\t%d\t%d\t%d\t%d\n",symtab[i].symbol,symtab[i].address,symtab[i].define,symtab[i].used,symtab[i].value,symtab[i].length);
}

printf("\n VARIENT 1:\n");
for(i=0;i<varcnt;i++)
	printf("%s\n",variant1[i]);
	return 0;
}		





