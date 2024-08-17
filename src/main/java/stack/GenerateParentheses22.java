package stack;

import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses22 {
  interface Build {
    void buildStr(int openN, int closeN);
  }
  
  public List<String> generateParenthesis(int n) {
    StringBuilder sb = new StringBuilder(n * 2);
    List<String> res = new ArrayList<>();

    Build builder = new Build() {
      @Override
      public void buildStr(int openN, int closeN) {
        if (closeN == n) {
          res.add(sb.toString());
          return;
        }

        if (openN < n) {
          sb.append("(");
          buildStr(openN + 1, closeN);

          if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
          }
        }

        if (closeN < openN) {
          sb.append(")");
          buildStr(openN, closeN + 1);

          if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
          }
        }
      };
    }; 

    builder.buildStr(0, 0);
    return res;
  }
}