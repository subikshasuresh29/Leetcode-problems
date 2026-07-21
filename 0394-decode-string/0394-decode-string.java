class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> str = new Stack<>();
        String curr = "";
        int num = 0;
        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '[') {
                count.push(num);
                str.push(curr);
                num = 0;
                curr = "";
            }
            else if (ch == ']') {
                int times = count.pop();
                StringBuilder temp = new StringBuilder(str.pop());

                while (times-- > 0)
                    temp.append(curr);

                curr = temp.toString();
            }
            else {
                curr += ch;
            }
        }
        return curr;
    }
}