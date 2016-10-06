import java.util.Scanner;
/**
 * 文件名称：《剑指Offer：名企面试官精讲典型编程题(纪念版)》面试题34：丑数
 * 时间：2016-8-19 14:00
 * 说明：1、题目：把只含有因子2、3和5的数称为丑数(Ugly Number).习惯上把1当成第一个丑数。
 * */

public class UglyNumber {

	public static int  GetUglyNumber(int number){
		if(number<=0){
			return 0;
		}
		int []pUglyNubers=new int[number];
		pUglyNubers[0]=1;
		int nextUglyIndex=1;
		
		int pMultiply2=0;
		int pMultiply3=0;
		int pMultiply5=0;
		
		while(nextUglyIndex<number){
			int min=Min(pUglyNubers[pMultiply2]*2,pUglyNubers[pMultiply3]*3,pUglyNubers[pMultiply5]*5);
			pUglyNubers[nextUglyIndex]=min;
			
			while(pUglyNubers[pMultiply2]*2<=pUglyNubers[nextUglyIndex]){
				pMultiply2++;
			}
			while(pUglyNubers[pMultiply3]*3<=pUglyNubers[nextUglyIndex]){
				pMultiply3++;
			}
			while(pUglyNubers[pMultiply5]*5<=pUglyNubers[nextUglyIndex]){
				pMultiply5++;
			}
			nextUglyIndex++;
		}
		int result=pUglyNubers[nextUglyIndex-1];
		pUglyNubers=null;
		return result;
	}
	
	private static int Min(int i, int j, int k) {
		int min=i<j?i:j;
		
		return min<k?min:k;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		
		while(in.hasNext()){
			int number=in.nextInt();
			System.out.println(GetUglyNumber(number));		
		}
	}

}
