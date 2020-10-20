#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<malloc.h>

typedef struct fat
{
 char fname[30];
 int start,length,flag;
 struct fat *link;
}fat;
fat* first=NULL;

typedef struct fbl
{
 int start,length;
 struct fbl *link;
}fbl;
fbl *f1=NULL;

int blocks;


void disp_dir();
void disp_free_space();
fat* append(fat*);

void main()
{
 int ch,bno,f;
 char fn[30];
 fbl *p;
 fat *q;
 clrscr();

 printf("\nEnter maximum number of blocks to allocate: ");
 scanf("%d",&blocks);
 f1=(fbl*)malloc(sizeof(fbl));
 f1->start=0;
 f1->length=blocks;
 f1->link=NULL;
 while(1)
	{
	 f=1;
	 printf("\n\n\n\nMENU:\n1.INSERTION\n2.DELETION\n3.DISPLAY\n4.EXIT\nEnter your choice: ");
	 scanf("%d",&ch);
	 switch(ch)
	       {
		case 1: printf("\n\nEnter the file name:");
			scanf("%s",fn);
			printf("Enter the file size in number of blocks:");
			scanf("%d",&bno);
			for(p=f1;p!=NULL;p=p->link)
			   {
			    if(p->length>=bno)
			      break;
			   }
			if(p==NULL)
			    printf("\nNot enough space...");
			else
			   {
			    q=(fat *)malloc(sizeof(fat));
			    strcpy(q->fname,fn);
			    q->length=bno;
			    q->start=p->start;
			    q->flag=0;
			    q->link=NULL;
			    first=append(q);
			    p->start+=bno;
			    p->length-=bno;
			    printf("\nFile is placed in free space...");
			   }
			break;

		case 2: printf("\n\nEnter the file name to be deleted:");
			scanf("%s",fn);
			for(q=first;q!=NULL;q=q->link)
			   {
			    if(strcmp(q->fname,fn)==0)
			      {
			       f=0;
			       break;
			      }
			   }
			if(f==1)
			   printf("\nThe given file doesn't exist...");
			else
			   {
			    q->flag=1;
			    p=(fbl*)malloc(sizeof(fbl));
			    p->start=q->start;
			    p->length=q->length;
			    p->link=NULL;
			    for(;f1->link!=NULL;f1=f1->link)
				;
			    f1->link=p;
			    printf("\nThe given file is deleted from the disk...");
			   }
			break;

		case 3: disp_dir();
			disp_free_space();
			break;

		case 4: exit(0);
		}
	}
	//return 0;
}

void disp_dir()
{
 fat* p;
 printf("\nDisk List:");
 printf("\nName\tStart\tLength");
 for(p=first;p!=NULL;p=p->link)
    {
     if(p->flag==0)
	printf("\n%s\t%d\t%d",p->fname,p->start,p->length);
    }
}

void disp_free_space()
{
 fbl *q;
 printf("\n\nFree Block-space List:");
 printf("\nStart\tLength");
 for(q=f1;q!=NULL;q=q->link)
     printf("\n%d\t%d",q->start,q->length);

}

fat* append(fat* f)
{
 fat* s;
 if(first==NULL)
   {
    first=(fat *)malloc(sizeof(fat));
    first=f;
   }
 else
   {
    for(s=first;s->link!=NULL;s=s->link)
       ;
    s->link=f;
    s=f;
   }
 return first;
}
