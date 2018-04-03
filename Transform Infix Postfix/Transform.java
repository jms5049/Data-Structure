
public class Transform {
	private ArrayStack stack;
	/* 구현에 필요한 변수는 임의로 선언할 것 */

	public String[] infixToPostfix(String[] args) {
		// 중위식을 후위식으로 변환한 결과를 String 배열로 반환하는 코드를 작성하고,
		// 마지막에 변환된 후위식을 출력함.
		int i, k = 0;
		String temp;

		stack = new ArrayStack(args.length);

		String[] postfix = new String[args.length]; // 새로운 배열 postfix **생성 크기는
													// 원래 배열과 같다.

		for (i = 0; i < args.length; i++) { // 기존 배열을 하나씩 넣어본다.

			if ((args[i].length() == 1 && "ASMD()".indexOf(args[i]) >= 0)) { // 연산자라면

				if (stack.isEmpty()) {// 스택 안에 들어있는 연산자가 ( 이라면 넘어가라
					// 연산자 이고 스택이 비어잇다면
					stack.push(args[i]); // 그 해당 배열 i의 값을 push 해줘서 스택에 저장한다.
				} else {
					while (!stack.isEmpty() && ")".indexOf(args[i]) >= 0) { // 스택이 비지 않았고 연산자이고 ")"이라면

						if (!stack.isEmpty() && precedence((String) stack.peek()) == 9) { // 스택 안에 들어있는 연산자가 "(" 이라면 꺼내라

							temp = (String) stack.pop(); // 임시변수 temp에 "(" 를 넣어버린다.

							break;

						} else {
							postfix[k] = (String) stack.pop();
							k++;
						}

					}
					while (!stack.isEmpty() && precedence(args[i]) <= precedence((String) stack.peek())) {
						// 연산자 i 와 stack에 들어가잇는 연산자와 비교

						if (!stack.isEmpty() && precedence((String) stack.peek()) == 9) { // 스택 안에 들어있는 연산자가 "(" 이라면 넘어가라
							break;
						}

						else {
							postfix[k] = (String) stack.pop();// 연산자 i의 우선순위가 stack에 있는 연산자보다 작다면 stack에 있는 연산자를 뺴온다
							k++;
						}
					}

					if (")".indexOf(args[i]) != 0) { // 연산자가 ")" 이 아니라면 스택에 push해라
						stack.push(args[i]); // 그 다음 연산자 i를 stack에 집어 넣는다.
					}

					while (!stack.isEmpty() && precedence(args[i]) > precedence((String) stack.peek())) {

						stack.push(args[i]); // 연산자 i의 우선순위가 stack에 있는 연산자 보다 크다면 연산자 i를 집어넣는다.

					}
				}
			} else { // 연산자가 아니면 배열에 저장한다.
				postfix[k] = args[i];
				k++;
			}

		}

		while (!stack.isEmpty()) { // 스택에 남아있는 연산기호들을 모두 pop 해준다
			postfix[k] = (String) stack.pop();
			k++;
		}

		String[] resize = postfix; // 괄호 연산 할떄에 처음 배열과 postfix 배열의 크기가 달라서 null값이 출력되는 불상사를 막기위해 사이즈를 변경한다.
		postfix = new String[k];
		System.arraycopy(resize, 0, postfix, 0, k);

		System.out.print("변환된 후위식: ");
		for (k = 0; k < postfix.length; k++) {
			System.out.print(postfix[k] + " ");
		}
		System.out.println("");

		return postfix;
	}

	public int precedence(String token) {
		// 연산자의 우선 순위를 반환하는 함수 작성
		// 연산자 우선 순위 *,/ > +,- > (,)
		// 들어갈떄의 우선순위 이다 ** 나갈떄는 다르니 설정을 해두자.

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
