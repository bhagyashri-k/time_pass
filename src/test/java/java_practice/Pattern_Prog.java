package java_practice;

public class Pattern_Prog {

	public static void main(String[] args) {
	int row=5;
	int col=1;
	int count=1;
	int count1=1;
	for(int i=0; i<=row; i++)
	{
		for(int j=1; j<col; j++)
		{
			if(i==4 && j==4 || i==5)
			{
			System.out.print(count+" ");
			count++;
			}
			else 
			{
				System.out.print(count1+" ");
				count1++;	
			}
		}
		col++;
		System.out.println();
	}
	

	}

}
