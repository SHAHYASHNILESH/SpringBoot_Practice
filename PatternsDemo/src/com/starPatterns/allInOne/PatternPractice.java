package com.starPatterns.allInOne;

class PatternPractice {

	public static void numberTrianglePattern(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = i; j <= n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print(i + " ");

			}

			System.out.println();
		}
	}

	public static void increasingTrianglePattern(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = i; j <= n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print("* ");

			}

			System.out.println();
		}
	}

	public static void decreasingTrianglePattern(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j <= n; j++) {

				System.out.print("* ");

			}

			System.out.println();
		}
	}

	public static void trianglePattern(int n) {

		for (int i = 1; i < n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j <= n; j++) {

				System.out.print("* ");

			}

			System.out.println();
		}

		for (int i = 1; i <= n; i++) {

			for (int j = i; j <= n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print("* ");

			}

			System.out.println();
		}

	}

	public static void reverseNumberTrianglePattern(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j <= n; j++) {

				System.out.print(j + " ");

			}

			System.out.println();
		}
	}

	public static void numberChangingPattern(int n) {

		int num = 1;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(num + " ");
				num++;

			}
			System.out.println();
		}
	}

	public static void palindromeTrianglePattern(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void palindromeReverseTrianglePattern(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < n; j++) {
				System.out.print("*");
			}
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void diamondPattern(int n) {

		for (int i = 1; i < n; i++) {

			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < n; j++) {
				System.out.print("*");
			}
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void increasingRightAngledTriangle(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}
			System.out.println();
		}
	}

	public static void decreasingRightAngledTriangle(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j < i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j <= n; j++) {

				System.out.print("*");

			}
			System.out.println();
		}
	}

	public static void pascalTriangle(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = i; j <= n; j++) {

				System.out.print(" ");

			}

			int x = 1;
			for (int j = 1; j <= i; j++) {

				System.out.print(x + " ");
				x = x * (i - j) / j;
				
			}
			System.out.println();
		}
	}

	public static void diamondPattern2(int n) {

		for (int i = 1; i < n; i++) {

			for (int j = i; j <= n; j++) {

				System.out.print("*");

			}

			for (int j = 1; j < i; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j < i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j <= n; j++) {

				System.out.print("*");

			}

			System.out.println();

		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}

			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}

			System.out.println();

		}
		
		
	}
	
	public static void newPattern(int n) {

		for (int i = 1; i < n; i++) {

			for (int j = i; j <= n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print("* ");

			}

			System.out.println();

		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j <= n; j++) {

				System.out.print("* ");

			}

			System.out.println();

		}
	}


	public static void main(String[] args) {

		//	      1 
		//	     2 2 
		//	    3 3 3 
		//	   4 4 4 4 
		//	  5 5 5 5 5 
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		numberTrianglePattern(5);

		// 1
		// 2 3
		// 4 5 6
		// 7 8 9 10
		// 11 12 13 14 15
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		numberChangingPattern(5);

		//	     *
		//	    ***
		//	   *****
		//	  *******
		//	 *********
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		palindromeTrianglePattern(5);

		//		*********
		//		 *******
		//		  *****
		//		   ***
		//		    *
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		palindromeReverseTrianglePattern(5);

		//	     *
		//	    ***
		//	   *****
		//	  *******
		//	 *********
		//	  *******
		//	   *****
		//	    ***
		//	     *
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		diamondPattern(5);

		//		     *
		//		    **
		//		   ***
		//		  ****
		//		 *****
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		increasingRightAngledTriangle(5);

		//		*****
		//		 ****
		//		  ***
		//		   **
		//		    *
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		decreasingRightAngledTriangle(5);

		
		//		 1 2 3 4 5 
		//		  2 3 4 5 
		//		   3 4 5 
		//		    4 5 
		//		     5 
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		reverseNumberTrianglePattern(5);

		
		//	      1 
		//	     1 1 
		//	    1 2 1 
		//	   1 3 3 1 
		//	  1 4 6 4 1 
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		pascalTriangle(5);

		//	      * 
		//	     * * 
		//	    * * * 
		//	   * * * * 
		//	  * * * * * 
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		increasingTrianglePattern(5);

		
		//		 * * * * * 
		//		  * * * * 
		//		   * * * 
		//		    * * 
		//		     * 
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		decreasingTrianglePattern(5);

		
		//		 * * * * * 
		//		  * * * * 
		//		   * * * 
		//		    * * 
		//		     * 
		//		    * * 
		//		   * * * 
		//		  * * * * 
		//		 * * * * * 
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		trianglePattern(5);

		//		**********
		//		****  ****
		//		***    ***
		//		**      **
		//		*        *
		//		**      **
		//		***    ***
		//		****  ****
		//		**********
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		diamondPattern2(5);
		
		
		//	      * 
		//	     * * 
		//	    * * * 
		//	   * * * * 
		//	  * * * * * 
		//	   * * * * 
		//	    * * * 
		//	     * * 
		//	      * 
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		newPattern(5);
	}
}