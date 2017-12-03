package test1;

//Please don't change class name 'Main'
import java.util.Scanner;


class Main {

public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in))
		{
			int n = s.nextInt();
			int d = s.nextInt();
			int k = s.nextInt();
			int j = s.nextInt();
			
			//������� �ۼ��� �ּ���
			int[] array = new int[n];
			array[0] = 1;
			if(d == 1) {
				for(int i=0; i<n; i++){
					array[i] = i+1;
				}
			}else {
				for(int i = 1; i<n; i++) {
					array[i] = n+1-i;
				}
			}
			
			//d�� 1�� ���
			//ù��° Ż���� : R1 = 1+k
			//�ι�° Ż���� : (1+k)+(k+j) = R1+(k+j) = R2
			//n��° Ż���� : Rn = Rn-1+(k+j)
			//k = j*(i-1)+k
			int K = k%n;
			int[] array1 = new int[n--];
			//array1[K] = Ż��
			System.arraycopy(array, K+1, array1, 1, n-K);
			System.arraycopy(array, 0, array1, n-K+1, K);
			array = array1.clone();
			
			while(n > 1) {
				k += j;
				K = k%n;
				if(K==0) {
					array[n--] = 0;
					continue;
				}
				for(int i=0; i<array1.length; i++) {
					array1[i] = 0;
				}
				System.arraycopy(array, K+1, array1, 1, n-K);
				System.arraycopy(array, 1, array1, n-K+1, K-1);
				array = array1.clone();
				n--;
			}
			
			
			System.out.print(array[1]);
			
			
		}
		
}
}
