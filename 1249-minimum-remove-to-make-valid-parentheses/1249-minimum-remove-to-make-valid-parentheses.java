class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder temp = new StringBuilder();
        int open = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                open++;
                temp.append(ch);
            }

            else if(ch == ')'){
                if(open>0){
                    open--;
                    temp.append(ch);
                }
            }

            else{
                temp.append(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        for(int i=temp.length()-1; i>=0; i--){
            char ch = temp.charAt(i);

            if(ch == '(' && open>0){
                open--;
                continue;
            }

            res.append(ch);
        }

        return res.reverse().toString();

        
    }
}