#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct MNT{
	char mname[30];
	int pp;
	int kp;
	int kpdt;
	int mdtp;
	int pntp;
	int apt;
}mnt[10];

struct KPDT
{
	char pname[15],def[15];
}kpdt[15];

struct MDT
{
	char opcode[15],value[35];
}mdt[30];

char pnt[15][30];
char apt[15][30];
int mnt_ptr,pnt_ptr,kpdt_ptr,apt_ptr,mdt_ptr;
int i,j,m,n,k=0;
char fname[20];
char tok1[35],tok2[35],tok3[35];
char buffer[80],temp[20],temp1[20],temp2[20],temp3[20];
FILE *fp;

int searchPNT(char *s)
{
	for(m=0;m<pnt_ptr;m++)
		if(strcmp(pnt[m],s)==0)
			return(m);
	return(-1);
}

int searchKPDT(char *s)
{
	for(m=0;m<kpdt_ptr;m++)
		if(strcmp(kpdt[m].pname,s)==0)
			return(m);
	return(-1);
}

int searchMNT(char *s)
{
	for(m=0;m<mnt_ptr;m++)
		if(strcmp(s,mnt[m].mname)==0)
			return(m);
	return(-1);
}

void displayPNT()
{
	printf("\n\n****************PNT Table****************");
	printf("\nm\tPname");
	printf("\n");
	for(m=0;m<pnt_ptr;m++)
		printf("\n%d\t%s",m,pnt[m]);
	printf("\n");
}

void displayMNT()
{
	printf("\n\n***********MACRO Table************");
	printf("\nm\tMname\tpp\tkp\tMDTP\tKPDT\tPNTP\tAPT");
	printf("\n");
	for(m=0;m<mnt_ptr;m++)
	{
		printf("\n%d\t%s\t%d\t%d\t%d\t%d\t%d\t%d",m,mnt[m].mname,mnt[m].pp,mnt[m].kp,mnt[m].mdtp,mnt[m].kpdt,mnt[m].pntp,mnt[m].apt);
	}
	printf("\n");

}

void displayKPT()
{
	printf("\n\n*************Keyword Parameter Default Table**************");
	printf("\nm\tPname\tDefault");
	printf("\n");
	for(m=0;m<kpdt_ptr;m++)
	{
		printf("\n%d\t%s\t%s",m,kpdt[m].pname,kpdt[m].def);
		printf("\n");
	}
}

void printMDT()
{
	printf("\n\n***************Macro Definition Table****************");
	printf("\n#\tOpcode\tOperand");
	printf("\n********************************");
	printf("%d",mdt_ptr);
	for(m=0;m<mdt_ptr;m++)
		printf("\n%d\t%s\t%s",m,mdt[m].opcode,mdt[m].value);
	printf("\n*********************************");
	getch();
}

void printAPT()
{
	printf("\n***************Actual parameter name table***************");
	printf("\n************************************");
	printf("m\tPName");
	for(m=0;m<pnt_ptr;m++)
		printf("\n%d\t%s",m,apt[m]);
	printf("\n************************************");
	getch();
}

void makeMDT()
{
	m=0;
	if(tok1[0]=='&')
	{
		while(m<strlen(tok1))
		{
			tok1[m]=tok1[m+1];
			m++;
		}
	}
	k=searchPNT(tok1);
	if(k==-1)
		sprintf(temp3,"%s",tok1);
	else
		sprintf(temp3,"(P,%d)",k+1);
	m=0;
	while(m<strlen(tok2))
	{
		tok2[m]=tok2[m+1];
		m++;
	}
	m=0;
	while(m<strlen(tok3))
	{
		tok3[m]=tok3[m+1];
		m++;
	}
	k=searchPNT(tok2);
	if(k==-1)
	{
		printf("\nError: Parameter %s Not Found",tok2);
		exit(0);
	}
	sprintf(temp,"(P,%d)",k+1);
	k=searchPNT(tok3);
	if(k==-1)
	{
		printf("\n Error: Parameter %s not Found",tok3);
		exit(0);
	}
	sprintf(temp1,"%s, (P,%d)",temp,k+1);
	strcpy(mdt[mdt_ptr].opcode,temp3);
	strcpy(mdt[mdt_ptr++].value,temp1);
	//mdt_ptr++;
}

void makeAPT(int n)
{
	i=j=0;
	apt_ptr=mnt[n].pntp;
	strcat(tok2,",");
	while(tok2[j] && tok2[j]!='=')
	{
		if(tok2[j]==',')
		{
			temp[i]='\0';
			i=0;
			strcpy(apt[apt_ptr],temp);
			apt_ptr++;
		}
		else 
			temp[i++]=tok2[j];
		j++;	
	}
	while(tok2[j])
	{
		if(tok2[j]=='=')
		{
			temp[i]='\0';
			i=0;
			apt_ptr=searchPNT(temp);
		}
		else if(tok2[j]==',')
		{
			temp[i]='\0';
			i=0;
			strcpy(apt[apt_ptr++],temp);
		}
		else
			temp[i++]=tok2[j];
		j++;
	}
}

void makeKPDT_PNT(char *s)
{
	int i=0,j=0,k=0;
	strcat(s,",");
	while(*s && *s!='=')
	{
		if(*s==',')
		{
			temp[i]='\0';
			j++;
			i=0;
			k=searchPNT(temp);
			if(k==-1)
				strcpy(pnt[pnt_ptr++],temp);
			else
			{
				printf("Error:Multiple Declaration of Symbol %s in arg list",temp);
				exit(0);
			}
		}
		else if(*s!='&')
			temp[i++]=*s;
		s++;
	}
	mnt[mnt_ptr].pp=j;
	j=0;
	while(*s)
	{
		if(*s=='=')
		{
			temp[i]='\0';
			i=0;
			k=searchPNT(temp);
			if(k==-1)
			{
				strcpy(pnt[pnt_ptr++],temp);
				strcpy(kpdt[kpdt_ptr].pname,temp);
			}
			else
			{
				printf("Error:Multiple Declaration of Symbol%s in arg list",temp);
				exit(0);
			}
		}
		else if(*s==',')
		{
			temp[i]='\0';
			j++;
			i=0;
			strcpy(kpdt[kpdt_ptr++].def,temp);
		}
		else if(*s!='&')
			temp[i++]=*s;
		s++;
	}
	mnt[mnt_ptr].kp=j;
}

void expand(int n)
{
	int a,b,c,MEC,x,p;
	char t[20];
	MEC=mnt[n].mdtp;
	while(strcmp(mdt[MEC].opcode,"MEND")!=0)
	{
		strcpy(temp3,mdt[MEC].opcode);
		strcpy(tok3,temp3);
		if(tok3[0]=='(')
		{
			tok3[strlen(tok3)-1]='\0';
			c=atoi(strstr(tok3,",")+1);
			if(strcmp(apt[c-1],"")==0)
			{
				strcpy(t,pnt[c-1]);
				x=searchKPDT(t);
				strcpy(temp3,kpdt[x].def);
			}
			else
				sprintf(temp3,apt[c-1]);
		}
		sscanf(mdt[MEC].value,"%s %s",tok1,tok2);
		tok2[strlen(tok2)-1]='\0';
		a=atoi(strstr(tok2,",")+1);
		tok1[strlen(tok1)-2]='\0';
		b=atoi(strstr(tok1,",")+1);
		if(strcmp(apt[b-1],"")==0)
		{
			strcpy(t,pnt[b-1]);
			x=searchKPDT(t);
			sprintf(temp,"%s %s",kpdt[x].def,apt[a-1]);
		}
		else
			sprintf(temp,"%s %s",apt[b-1],apt[a-1]);
		printf("%s\t%s\n",temp3,temp);
		MEC++;
	}
}

void separate()
{
	while(fgets(buffer,80,fp))
	{
		n=sscanf(buffer,"%s %s %s",tok1,tok2,tok3);
		if(strcmp(tok1,"MACRO")==0 && n==1)
		{
			fgets(buffer,80,fp);
			sscanf(buffer,"%s %s",tok1,tok2);
			strcpy(mnt[mnt_ptr].mname,tok1);
			mnt[mnt_ptr].kpdt=kpdt_ptr;
			mnt[mnt_ptr].mdtp=mdt_ptr;
			mnt[mnt_ptr].pntp=pnt_ptr;
			makeKPDT_PNT(tok2);
		}
		else if(strcmp(tok1,"MEND")==0 && n==1)
		{
			strcpy(mdt[mdt_ptr].opcode,"MEND");
			strcpy(mdt[mdt_ptr++].value,"");
			mnt_ptr++;
		}
		else if(tok3[0]=='&' && n==3)
			makeMDT();
		else
		{
			k=searchMNT(tok1);
			if(k==-1)
				printf("%s",buffer);
			else
			{
				makeAPT(k);
				expand(k);
			}
		}
	}
}

void main(int argc,char* argv[])
{
	if(argc==2)
		strcpy(fname,argv[1]);
	else
	{
		printf("\nEnter File Name ");
		scanf("%s",fname);
	}
	fp=fopen(fname,"r");
	separate();
	displayMNT();
	displayPNT();
	displayKPT();
	printMDT();
	printAPT();
	fclose(fp);
}