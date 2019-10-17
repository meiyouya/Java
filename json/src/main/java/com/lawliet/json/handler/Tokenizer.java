package com.lawliet.json.handler;

import com.lawliet.json.bean.Token;
import com.lawliet.json.bean.TokenList;
import com.lawliet.json.bean.TokenType;

import java.io.IOException;
import java.util.ArrayList;

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

        }
    }
}
