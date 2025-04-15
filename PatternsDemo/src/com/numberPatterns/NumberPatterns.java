package com.numberPatterns;

public class NumberPatterns {

	public static void numberPattern1(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print("1 ");

			}
			System.out.println();
		}
	}

	public static void numberPattern2(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(i + " ");

			}
			System.out.println();
		}
	}

	public static void numberPattern3(int n) {

		for (int i = 1, p = n; i <= n; i++, p--) {

			for (int j = 1; j <= i; j++) {

				System.out.print(p + " ");

			}
			System.out.println();
		}
	}

	public static void numberPattern4(int n) {

		for (int i = 1, p = 0; i <= n; i++, p += 2) {

			for (int j = 1; j <= i; j++) {

				System.out.print(p + " ");

			}
			System.out.println();
		}
	}

	public static void numberPattern5(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				if (i % 2 == 0)
					System.out.print("2 ");
				else
					System.out.print("1 ");

			}
			System.out.println();
		}
	}

	public static void numberPattern6(int n) {

		int p = 1;
		for (int i = 1; i < n; i++, p++) {

			for (int j = i; j < n; j++) {

				System.out.print(" ");
			}

			for (int j = 1; j < i; j++) {

				System.out.print(p);
			}
			for (int j = 1; j <= i; j++) {

				System.out.print(p);
			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++, p++) {

			for (int j = 1; j < i; j++) {

				System.out.print(" ");
			}

			for (int j = i; j < n; j++) {

				System.out.print(p);
			}
			for (int j = i; j <= n; j++) {

				System.out.print(p);
			}
			System.out.println();
		}
	}

	public static void numberPattern7(int n) {

		int p = 1;
		for (int i = 1; i < n; i++, p++) {

			for (int j = i; j < n; j++) {

				System.out.print(" ");
			}

			for (int j = 1; j < i; j++) {

				System.out.print(p);
			}
			for (int j = 1; j <= i; j++) {

				System.out.print(p);
			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++, p--) {

			for (int j = 1; j < i; j++) {

				System.out.print(" ");
			}

			for (int j = i; j < n; j++) {

				System.out.print(p);
			}
			for (int j = i; j <= n; j++) {

				System.out.print(p);
			}
			System.out.println();
		}
	}

	public static void numberPattern8(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1, x = 1; j <= i; j++, x++) {

				System.out.print(x + " ");

			}
			System.out.println();
		}
	}

	public static void numberPattern9(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j < i; j++) {

				System.out.print(" ");

			}

			for (int j = i, x = 1; j <= n; j++, x++) {

				System.out.print(x);

			}
			System.out.println();
		}
	}

	public static void numberPattern10(int n) {

		for (int i = 1; i <= n; i++) {

			int x = 1;

			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j < i; j++, x++) {

				System.out.print(x);

			}

			for (int j = 1; j <= i; j++, x++) {

				System.out.print(x);

			}

			System.out.println();

		}
	}

	public static void numberPattern11(int n) {

		for (int i = 1, k = n; i <= n; i++, k--) {

			int p = k;

			for (int j = 1; j < i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j <= n; j++, p--) {

				System.out.print(p);

			}

			System.out.println();

		}
	}

	public static void numberPattern12(int n) {

		for (int i = 1; i <= n; i++) {

			int p = 1;

			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j < i; j++, p++) {

				System.out.print(p);

			}

			for (int j = 1; j <= i; j++, p--) {

				System.out.print(p);

			}

			System.out.println();

		}
	}

	public static void numberPattern13(int n) {

		int p = 1;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(p);
				p++;

			}

			System.out.println();

		}
	}

	public static void main(String[] args) {

		int n = 5;

		numberPattern1(n);
		System.out.println();

		numberPattern2(n);
		System.out.println();

		numberPattern3(n);
		System.out.println();

		numberPattern4(n);
		System.out.println();

		numberPattern5(n);
		System.out.println();

		numberPattern6(n);
		System.out.println();

		numberPattern7(n);
		System.out.println();

		numberPattern8(n);
		System.out.println();

		numberPattern9(n);
		System.out.println();

		numberPattern10(n);
		System.out.println();

		numberPattern11(n);
		System.out.println();

		numberPattern12(n);
		System.out.println();

		numberPattern13(n);
		
//		1 
//		1 1 
//		1 1 1 
//		1 1 1 1 
//		1 1 1 1 1 
//
//		1 
//		2 2 
//		3 3 3 
//		4 4 4 4 
//		5 5 5 5 5 
//
//		5 
//		4 4 
//		3 3 3 
//		2 2 2 2 
//		1 1 1 1 1 
//
//		0 
//		2 2 
//		4 4 4 
//		6 6 6 6 
//		8 8 8 8 8 
//
//		1 
//		2 2 
//		1 1 1 
//		2 2 2 2 
//		1 1 1 1 1 
//
//		    1
//		   222
//		  33333
//		 4444444
//		555555555
//		 6666666
//		  77777
//		   888
//		    9
//
//		    1
//		   222
//		  33333
//		 4444444
//		555555555
//		 4444444
//		  33333
//		   222
//		    1
//
//		1 
//		1 2 
//		1 2 3 
//		1 2 3 4 
//		1 2 3 4 5 
//
//		12345
//		 1234
//		  123
//		   12
//		    1
//
//		    1
//		   123
//		  12345
//		 1234567
//		123456789
//
//		54321
//		 4321
//		  321
//		   21
//		    1
//
//		    1
//		   121
//		  12321
//		 1234321
//		123454321
//
//		1
//		23
//		456
//		78910
//		1112131415

	}
}
