
public class Transform {
	private ArrayStack stack;

	public String[] infixToPostfix(String[] args) {
		
		int i, k = 0;
		String temp;

		stack = new ArrayStack(args.length);

		String[] postfix = new String[args.length];
		for (i = 0; i < args.length; i++) {

			if ((args[i].length() == 1 && "ASMD()".indexOf(args[i]) >= 0)) { // 연산자라면

				if (stack.isEmpty()) {
					stack.push(args[i]);
				} else {
					while (!stack.isEmpty() && ")".indexOf(args[i]) >= 0) {

						if (!stack.isEmpty() && precedence((String) stack.peek()) == 9) { 

							temp = (String) stack.pop();

							break;

						} else {
							postfix[k] = (String) stack.pop();
							k++;
						}

					}
					while (!stack.isEmpty() && precedence(args[i]) <= precedence((String) stack.peek())) {

						if (!stack.isEmpty() && precedence((String) stack.peek()) == 9) { 
							break;
						}

						else {
							postfix[k] = (String) stack.pop();
							k++;
						}
					}

					if (")".indexOf(args[i]) != 0) { 
						stack.push(args[i]); 
					}

					while (!stack.isEmpty() && precedence(args[i]) > precedence((String) stack.peek())) {

						stack.push(args[i]); 

					}
				}
			} else { 
				postfix[k] = args[i];
				k++;
			}

		}

		while (!stack.isEmpty()) {
			postfix[k] = (String) stack.pop();
			k++;
		}

		String[] resize = postfix;
		postfix = new String[k];
		System.arraycopy(resize, 0, postfix, 0, k);

		System.out.print("Transform Postfix: ");
		for (k = 0; k < postfix.length; k++) {
			System.out.print(postfix[k] + " ");
		}
		System.out.println("");

		return postfix;
	}

	public int precedence(String token) {
		
		if (token.equals("M") || token.equals("D"))
			return 4;
		else if (token.equals("A") || token.equals("S"))
			return 2;
		else if (token.equals(")"))
			return 0;
		else if (token.equals("("))
			return 9;
		else // end of string
			return 0;

	}
}
