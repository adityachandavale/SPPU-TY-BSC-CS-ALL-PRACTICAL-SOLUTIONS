#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char ia[10];
int n,ns,nf,i,j,curr,r;
int s[10][10];
int f[10];
int flag=0;

char str[20];
char ch;


int check(char ch)
{
	int i,a=-1;
	for(i=0;i<n;i++)
	{
		if(ch==ia[i])
			a=i;	
	}	
	return a;
}


int main(void)
{
	
	printf("Enter no of input alphabets ");
	scanf("%d",&n);

	printf("Enter no of states ");
	scanf("%d",&ns);



	for(i=0;i<n;i++)
	{
		printf("Enter  input alphabet ");
		scanf("%c",&ia[i]);
		scanf("%c",&ia[i]);
	}
	for(i=0;i<ns;i++)
	{
		for(j=0;j<n;j++)
		{
			printf("Enter %d,%c element",i,ia[j]);
			scanf("%d",&s[i][j]);
		}
	}
	printf("Enter no of Final  states ");
	scanf("%d",&nf);
	for(i=0;i<nf;i++)
	{
		printf("Enter %dth final state ",i+1);
		scanf("%d",&f[i]);
	}
	
        do
	{
		printf("Enter string ");
		scanf("%s",&str);
		
		curr=0;
		
		for(i=0;str[i]!='\0';i++)
		{
			r=check(str[i]);

			if(r==-1)
			{
				printf("\nInvalid input alphabets \n");
				return;
			}
			else
				curr=s[curr][r];
		}
			for(i=0;i<nf;i++)
			if(curr==f[i])
				flag=1;

			if(flag==0)
				printf("Invalid String\n");
			else
				printf("Valid String\n");
	
		printf("Do you want to continue y/n or Y/N ");
		scanf("%c",&ch);
		scanf("%c",&ch);
	}while(ch=='y' || ch=='Y');					
}
