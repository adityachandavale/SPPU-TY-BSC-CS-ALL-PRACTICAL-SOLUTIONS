#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct node
{
	struct node* prev;
	char data[80];
	struct node* next;
}node;
int cnt=0;
node* head=NULL;
node* last=NULL;
FILE* fp;
char fname[80];
int modify=0;

void create()
{
	node* temp;
	char str[80];
		while(fgets(str,80,fp))
		{
			temp=(node*)malloc(sizeof(node));
			temp->next=NULL;
			temp->prev=NULL;
			strcpy(temp->data,str);
			if(head==NULL)
				head=last=temp;
			else
			{
				last->next=temp;
				temp->prev=last;
				last=temp;
			}
			cnt++;
		}				
}

node* findnode(int pos)
{
	node* temp;
	int i;
	for(i=1,temp=head;i<pos && temp!=NULL;i++,temp=temp->next)
					;
	
	return temp;
}

void print(int n,int m)
{
	if(n>m || m<0 || n<0)
	{
		printf("Invalid\n");
		return;
	}
	else
	{
		node* temp;
		node* p;
		int i;
		p=findnode(n);
		for(temp=p,i=n;temp!=NULL && i<=m;temp=temp->next,i++)
		{ 
			printf(" %d ",i);
			//printf("%s",temp->data);
                        puts(temp->data);
		}
	}
}

void help()
{
	printf("\np:Print\na:Append\ni:Insert\ns:save\nc:copy\nm:move\nd:delete\nf:find\nq:Quit\nh:Help\n");
}

void append()
{
	char str[80];
	node* temp;
	printf("Enter data ");
	fgets(str,80,stdin);
	temp=(node*)malloc(sizeof(node));
	temp->next=NULL;
	temp->prev=NULL;
	strcpy(temp->data,str);
	if(head==NULL)
		head=last=temp;
	else
	{
		last->next=temp;
		temp->prev=last;
		last=temp;
	}
		cnt++;
		modify=1;
}
void insert(char str[],int pos)
{
	int i;
	node* temp;
	node* p;	
	node* newnode;
	
	newnode=(node*)malloc(sizeof(node));
	newnode->next=NULL;
	newnode->prev=NULL;
	strcpy(newnode->data,str);
	//strcat(newnode->data,"\n");
	//printf("\n%s\n",str);
	//printf("\n%s\n",newnode->data);
	if(pos<0 || pos>cnt)
	{
		printf("Invalid position\n");
		return ;
	}
	else
	{
		/*if(pos==1)
		{
			newnode->next=head;
			head->prev=newnode;
			head=newnode;
		}
		else*/
		p=findnode(pos);
		if(pos==cnt)
		{
			last->next=newnode;
			newnode->prev=last;
			last=newnode;
		}
		else
		{
			temp=p->next;
			newnode->next=temp;
			newnode->prev=p;
			p->next=newnode;
			temp->prev=newnode;
		}
		cnt++;
	}		
      //  print(1,cnt);		
	modify=1;
}

void save()
{
	node* temp;
	temp=head;
	fp=fopen(fname,"w");
	while(temp!=NULL)
	{
		fprintf(fp,"%s",temp->data);
		temp=temp->next;
	}
	modify=0;
	printf("File is saved successfully\n");
}

void delete(int m,int n)
{
	node* temp;
	node* p;
	if(m>n | m<0 || n<0 || n>cnt)
		printf("Cannot delete\n");
	else
	{
		if(m==1)
		{
			while(m<=n)
			{
				temp=head;
				head=head->next;
				head->prev=NULL;
				temp->next=NULL;
				free(temp);
				m++;
				cnt--;
			}
		}
		else
		{		
			p=findnode(m-1);
			while(m<=n)
			{
				temp=p->next;
				if(temp!=last)
				{
					p->next=temp->next;
					(temp->next)->prev=p;
				}
				else
					last=temp;
				temp->next=NULL;
				temp->prev=NULL;
				free(temp);
				m++;
				cnt--;
			}
	
		}
		last=head;
		while(last!=NULL)
			last=last->next;
		modify=1;
	}
}

void copy(int m,int n,int o)
{
	node* p;
	int i=1;
	if(m<=0 || n<=0 || o<=0)
		printf("Invalid positions\n");
	else
	{
		p=findnode(m);		
		while(i<=n)
		{
			insert(p->data,o);
			p=p->next;
			o++;	
			i++;
			cnt++;
		}
		modify=1;
	}
}

void move(int m,int n,int o)
{
	copy(m,n,o);
	delete(m,n);
	modify=1;
}

void find(int m,int n,char* a)
{
	node* p;
	node* temp;
	int b=0,i;
	p=findnode(m);
	for(temp=p,i=m;temp!=NULL && i<=n;i++,temp=temp->next)
	{
		if(strstr(temp->data,a))
		{
			printf("%s",temp->data);
			b++;
		}
	}
//	printf("No of occurences of %s are %d\n",a,b);
}
	
void main(int argc,char* argv[])
{
	int n,n1,n2,n3;
	char c,b;
	char str[80],a[80],p[80];
	if(argc==1)
	{
		printf("Enter name of file\n");
		fgets(fname,80,stdin);
	}
	else
		strcpy(fname,argv[1]);
	
	fp=fopen(fname,"r");
	if(fp==NULL)
	{
		printf("File dosen't exits\n");
		append();
	}
	else
	{
		create();
		printf("No of lines is %d\n",cnt);
	}
		help();
		while(1)
		{
			printf("\n$]");
			strcpy(str,"");
			fgets(str,80,stdin);c=' ';
			n=sscanf(str,"%c%d%d%d",&c,&n1,&n2,&n3);
			switch(c)
			{
				case 'p':if(n==1)
						print(1,cnt);
					 else
						print(n1,n2);	
					 break;
				case 'a':append();
					 break;
				case 'i':if(n==2)
					 {
						printf("Enter data ");
					 	fgets(a,80,stdin);
						//printf("%s",a);
						insert(a,n1);
					}
					else
						printf("Invalid command\n");
					 break;
				case 'd':if(n==2)
						delete(n1,n1);
					 else if(n==3)
						delete(n1,n2);
					 else
						printf("Invalid command\n");
					 break;
				case 's':if(modify)
					 save();
					 else
					 printf("File is already saved\n");	
					 break;
				case 'q':if(modify)
					 {
					 printf("Do you want to save the program y/n ");
					 scanf("%c",&b);
					 }
					 if(b=='y' || b=='Y')
						save();
					 	exit(0);
					 break;
				case 'h':help();
					 break;
				case 'c':if(n==3)
					 copy(n1,n1,n2);
					 else if(n==4)
					 copy(n1,n2,n3);
					 else
						printf("Invalid command");
					 break;
				case 'm':if(n==3)
					 move(n1,n1,n2);
					 else if(n==4)
					 move(n1,n2,n3);
					 else
						printf("Invalid command");
					 break;
				case 'f':if(n==3)
					 {
						printf("Enter string to be searched ");
						scanf("%s",p);
						find(n1,n2,p);
					 }
					else if(n==1)
					{
						printf("Enter string to be searched ");
						scanf("%s",p);
						find(1,cnt,p);
					}
					else if(n==2)
					{
						printf("Enter string to be searched ");
						scanf("%s",p);
						find(n1,n1,p);	
					}
					break;
				default:printf("Invalid command\n");
			}	
		}
}
