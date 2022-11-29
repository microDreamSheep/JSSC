package live.midreamsheep.jssc.lexer.lexers.oprator;

import live.midreamsheep.jssc.pojo.token.Token;
import live.midreamsheep.jssc.pojo.token.TokenTypeEnum;
import live.midreamsheep.jssc.pojo.token.type.ProcessInter;
import live.midreamsheep.jssc.pojo.token.type.operator.OperatorEnum;

import java.util.HashMap;
import java.util.Map;

public class OperatorMapper {

    public static Map<String, ProcessInter> operatorMap = new HashMap<>();

    static {
        operatorMap.put("+",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "+", OperatorEnum.ADD.getKey()));
            return ++pointer;
        });
        operatorMap.put("-",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "-", OperatorEnum.SUB.getKey()));
            return ++pointer;
        });
        operatorMap.put("*",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "*", OperatorEnum.MUL.getKey()));
            return ++pointer;
        });
        operatorMap.put("/",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "/", OperatorEnum.DIV.getKey()));
            return ++pointer;
        });
        operatorMap.put("%",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "%", OperatorEnum.MOD.getKey()));
            return ++pointer;
        });
        operatorMap.put(">",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenTypeEnum.OPERATOR, ">=", OperatorEnum.GE.getKey()));
                return pointer+2;
            }
            if(bytes[pointer+1]=='>'){
                takenList.add(new Token(TokenTypeEnum.OPERATOR, ">>", OperatorEnum.LSH.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenTypeEnum.OPERATOR, ">", OperatorEnum.GT.getKey()));
            return ++pointer;
        });
        operatorMap.put("<",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenTypeEnum.OPERATOR, "<=", OperatorEnum.LE.getKey()));
                return pointer+2;
            }
            if(bytes[pointer+1]=='<'){
                takenList.add(new Token(TokenTypeEnum.OPERATOR, "<<", OperatorEnum.RSH.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "<", OperatorEnum.LT.getKey()));
            return ++pointer;
        });
        operatorMap.put("=",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenTypeEnum.OPERATOR, "==", OperatorEnum.EQUAL.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "=", OperatorEnum.O_EQ.getKey()));
            return ++pointer;
        });
        operatorMap.put("!",(bytes,pointer,takenList)-> {
            if(bytes[pointer+1]=='='){
                takenList.add(new Token(TokenTypeEnum.OPERATOR, "!=", OperatorEnum.NOT_EQ.getKey()));
                return pointer+2;
            }
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "!", OperatorEnum.NE.getKey()));
            return ++pointer;
        });
        operatorMap.put("&",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "&", OperatorEnum.AND.getKey()));
            return ++pointer;
        });
        operatorMap.put("|",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "|", OperatorEnum.OR.getKey()));
            return ++pointer;
        });
        operatorMap.put("^",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "^", OperatorEnum.XOR.getKey()));
            return ++pointer;
        });
        operatorMap.put("~",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "~", OperatorEnum.NOT.getKey()));
            return ++pointer;
        });
        operatorMap.put("?",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, "?", OperatorEnum.TERNARY.getKey()));
            return ++pointer;
        });
        operatorMap.put(":",(bytes,pointer,takenList)-> {
            takenList.add(new Token(TokenTypeEnum.OPERATOR, ":", OperatorEnum.XOR.getKey()));
            return ++pointer;
        });
    }
}
