#include<stdio.h>
#include<conio.h>
void main(){
	
	int mem[3],ref[20],k,i,j,min=99,n,victim,fault=0;
	clrscr();
	printf("\n Enter no of Reference string");
	scanf("%d",&n);

	printf("\n Enter The Ref. string");
			for(i=0;i<n;i++)
			{
				printf("\n reference[%d]",i);
				scanf("%d",&ref[i]);
			}

		for(i=0;i<n;i++){
			min=99;
				for(j=0;j<3;j++){
					if(mem[j]==ref[i]){
						printf("\n No page fault at %d",i);
						break;
					}

					if(mem[j]==0){
						mem[j]=ref[i];
						fault++;
						printf("\n Page fault at %d",i);
						break;
					}

				}
		if(j==3){
			for(k=0;k<3;k++)
				for(j=i-1;j>=0;j--)
					if(mem[k]==ref[j]){
						if(min>j){
							min=j;
							victim=k;
						}
						break;
					}
			
		mem[victim]=ref[i];
		fault++;
		printf("\n Page fault at %d",i);
		}
		for(j=0;j<3;j++)
			if(mem[j]!=0)
			printf("\n %d",mem[j]);
		}
		printf("\n Page fault = %d ",fault);
		getch();
}