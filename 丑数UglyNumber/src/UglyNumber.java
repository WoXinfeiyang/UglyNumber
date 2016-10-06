import java.util.Scanner;
/**
 * �ļ����ƣ�����ָOffer���������Թپ������ͱ����(�����)��������34������
 * ʱ�䣺2016-8-19 14:00
 * ˵����1����Ŀ����ֻ��������2��3��5������Ϊ����(Ugly Number).ϰ���ϰ�1���ɵ�һ��������
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
