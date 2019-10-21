package com.lawliet.json.handler;

import com.lawliet.json.bean.Token;
import com.lawliet.json.bean.TokenList;
import com.lawliet.json.bean.TokenType;
import com.lawliet.json.exceprion.JsonParseException;

import java.io.IOException;

/**
 * @author lawliet.L
 */
public class Tokenizer {

    private CharReader reader;
    private TokenList tokens;

    public TokenList tokenize(CharReader reader) throws IOException {
        this.reader = reader;
        tokens = new TokenList();
        tokenize();
        return tokens;
    }

    private void tokenize() throws IOException {
        Token token;
        do {
            token = start();
            tokens.add(token);
        } while (token.getTokenType() != TokenType.END_DOCUMENT);
    }

    private Token start() throws IOException {
        char ch;
        while (true) {
            if (!reader.hasMore()) {
                return new Token(TokenType.END_DOCUMENT, null);
            }

            ch = reader.next();
            if (!isWhiteSpace(ch)) {
                break;
            }
        }

        switch (ch) {
            case '{':
                return new Token(TokenType.BEGIN_OBJECT,String.valueOf(ch));
            case '}':
                return new Token(TokenType.END_OBJECT,String.valueOf(ch));
            case '[':
                return new Token(TokenType.BEGIN_ARRAY,String.valueOf(ch));
            case ']':
                return new Token(TokenType.END_ARRAY,String.valueOf(ch));
            case ',':
                return new Token(TokenType.SEP_COMMA,String.valueOf(ch));
            case ':':
                return new Token(TokenType.SEP_COLON,String.valueOf(ch));
            case 'n':
                return readNull();
            case '"':
                return readString();
            case 't':
            case 'f':
                return readBoolean();
            case '-':
                return readNumber();
        }

        if (isDigit(ch)) {
            return readNumber();
        }

        throw new JsonParseException("非法字符");
    }

    private Token readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char ch = reader.next();
            // 处理转义字符
            if (ch == '\\') {
                if (!isEscape()) {
                    throw new JsonParseException("非法的特殊字符");
                }
                sb.append('\\');
                ch = reader.peek();
                sb.append(ch);
                // 处理Unicode字符
                if (ch == 'u') {

                }

            }
        }
    }

    private Token readNull() throws IOException {
        if (reader.next() == 'u' && reader.next() == 'l' && reader.next() == 'l') {
            return new Token(TokenType.NULL, "null");
        }
        throw new JsonParseException("非法的json字符串");
    }

    /**
     * 判断是否是特殊字符
     * @return boolean
     * @throws IOException IOException
     */
    private boolean isEscape() throws IOException{
        char ch = reader.next();
        return (ch == '"' || ch == '\\' || ch == 'u' || ch == 'r' || ch == 'n' || ch == 'b' || ch == 't' || ch == 'f');
    }

    /**
     * 判断是否是空白
     * @param ch 字符ch
     * @return boolean
     */
    private boolean isWhiteSpace(char ch) {
        return (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n');
    }

    /**
     * 是否是数字
     * @param ch 字符ch
     * @return boolean
     */
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
