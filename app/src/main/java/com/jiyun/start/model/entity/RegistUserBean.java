package com.jiyun.start.model.entity;

public class RegistUserBean {

    /**
     * code : 0
     * message : 成功
     * data : {"nickname":"我是二哥","mobile":"17611457571","photo":null,"id":784,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJmdWF6MTgiLCJzdWIiOiI3ODQiLCJleHAiOjE1MjYwMzYxNzksImlhdCI6MTUyNTQzMTM3OX0.QkX6lSlL9XT9CVzhN_MquRGLwFyUGBI9u_22kdbQx55VFgYe2DEr1-9I1JsS_1i9Zlb1XQm7z1f7rQ4phfQy8w"}
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
         * nickname : 我是二哥
         * mobile : 17611457571
         * photo : null
         * id : 784
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJmdWF6MTgiLCJzdWIiOiI3ODQiLCJleHAiOjE1MjYwMzYxNzksImlhdCI6MTUyNTQzMTM3OX0.QkX6lSlL9XT9CVzhN_MquRGLwFyUGBI9u_22kdbQx55VFgYe2DEr1-9I1JsS_1i9Zlb1XQm7z1f7rQ4phfQy8w
         */

        private String nickname;
        private String mobile;
        private Object photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
