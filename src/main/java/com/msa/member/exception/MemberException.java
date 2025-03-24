package com.msa.member.exception;

public class MemberException extends RuntimeException {
    protected Object[] args;

    public MemberException(String message) {
        super(message);
    }

    public MemberException(String message, Object[] args) {
        super(message);
        if(args != null) {
            this.args = args.clone();
        }
    }
}
