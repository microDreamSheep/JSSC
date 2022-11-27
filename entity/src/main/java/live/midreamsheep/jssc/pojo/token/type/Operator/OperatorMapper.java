package live.midreamsheep.jssc.pojo.token.type.Operator;

import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenType;
import live.midreamsheep.jssc.pojo.token.type.ProcessInter;

import java.util.HashMap;
import java.util.Map;

public class OperatorMapper {

    public static Map<String, ProcessInter> operatorMap = new HashMap<>();

    static {
        operatorMap.put("+",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "+", OperatorEnum.ADD.getKey()));
            return ++pointer;
        });
        operatorMap.put("-",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "-", OperatorEnum.SUB.getKey()));
            return ++pointer;
        });
        operatorMap.put("*",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "*", OperatorEnum.MUL.getKey()));
            return ++pointer;
        });
        operatorMap.put("/",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "/", OperatorEnum.DIV.getKey()));
            return ++pointer;
        });
        operatorMap.put("%",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "%", OperatorEnum.MOD.getKey()));
            return ++pointer;
        });
        operatorMap.put(">",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenType.OPERATOR, ">=", OperatorEnum.GE.getKey()));
                return pointer+2;
            }
            if(bytes[pointer+1]=='>'){
                takenList.add(new Token(TokenType.OPERATOR, ">>", OperatorEnum.LSH.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenType.OPERATOR, ">", OperatorEnum.GT.getKey()));
            return ++pointer;
        });
        operatorMap.put("<",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenType.OPERATOR, "<=", OperatorEnum.LE.getKey()));
                return pointer+2;
            }
            if(bytes[pointer+1]=='<'){
                takenList.add(new Token(TokenType.OPERATOR, "<<", OperatorEnum.RSH.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenType.OPERATOR, "<", OperatorEnum.LT.getKey()));
            return ++pointer;
        });
        operatorMap.put("=",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenType.OPERATOR, "==", OperatorEnum.EQUAL.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenType.OPERATOR, "=", OperatorEnum.O_EQ.getKey()));
            return ++pointer;
        });
        operatorMap.put("!",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenType.OPERATOR, "!=", OperatorEnum.NOT_EQ.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenType.OPERATOR, "!", OperatorEnum.NE.getKey()));
            return ++pointer;
        });
        operatorMap.put("&",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "&", OperatorEnum.AND.getKey()));
            return ++pointer;
        });
        operatorMap.put("|",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "|", OperatorEnum.OR.getKey()));
            return ++pointer;
        });
        operatorMap.put("^",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "^", OperatorEnum.XOR.getKey()));
            return ++pointer;
        });
        operatorMap.put("~",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "~", OperatorEnum.NOT.getKey()));
            return ++pointer;
        });
        operatorMap.put("?",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, "?", OperatorEnum.TERNARY.getKey()));
            return ++pointer;
        });
        operatorMap.put(":",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenType.OPERATOR, ":", OperatorEnum.XOR.getKey()));
            return ++pointer;
        });
    }
}
