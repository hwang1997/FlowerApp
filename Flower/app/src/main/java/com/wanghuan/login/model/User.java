package com.wanghuan.login.model;

public class User {
    /**
     * code : 0
     * message : 成功
     * data : {"userId":201604,"userName":"赵云","userPassword":"202cb962ac59075b964b07152d234b70","role":1}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userId : 201604
         * loginId: 1447081730
         * userName : 赵云
         * userPassword : 202cb962ac59075b964b07152d234b70
         * role : 1
         */

        private int userId;
        private String loginId;
        private String userName;
        private String userPassword;
        private int role;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userId=" + userId +
                    ", userName='" + userName + '\'' +
                    ", userPassword='" + userPassword + '\'' +
                    ", role=" + role +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
