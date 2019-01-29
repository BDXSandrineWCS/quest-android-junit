package fr.wildcodeschool.emailbuilder;

import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class EmailBuilder {
    private String mUserName;
    private String mDomain;
    private String mSubDomain;
    private String mTld;

    /**
     * Email validation pattern.
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9\\-]{1,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private EmailBuilder() {
    }

    /**
     * Formats and returns the build email
     *
     * @return The build email address
     */
    public String getEmail() {

        StringBuilder res =  new StringBuilder();

        if ((null != mUserName)&&(! mUserName.isEmpty())) res.append(mUserName);
        res.append('@');
        if ((null != mDomain)&&(! mDomain.isEmpty())) res.append(mDomain + '.');
        if ((null != mSubDomain)&&(! mSubDomain.isEmpty())) res.append(mSubDomain + '.');
        if ((null != mTld)&&(! mTld.isEmpty())) res.append(mTld);
        if (res.toString().equals("@")) return "";
        int l = res.length()-1;
        if ('.' == res.charAt(l)) res.deleteCharAt(l);
        return  res.toString();

    }

    /**
     * Validates if the given input is a valid email address.
     *
     * @param email The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Nested builder class
     */
    static class Builder {
        private EmailBuilder mEmailBuilder;

        public Builder() {
            mEmailBuilder = new EmailBuilder();
        }

        public Builder setUserName(String pUserName) {
            mEmailBuilder.mUserName = pUserName;
            return this;
        }

        public Builder setDomain(String pDomain) {
            mEmailBuilder.mDomain = pDomain;
            return this;
        }

        public Builder setSubDomain(String pSubDomain) {
            mEmailBuilder.mSubDomain = pSubDomain;
            return this;
        }

        public Builder setTld(String pTld) {
            mEmailBuilder.mTld = pTld;
            return this;
        }

        public EmailBuilder build() {
            return mEmailBuilder;
        }
    }
}
