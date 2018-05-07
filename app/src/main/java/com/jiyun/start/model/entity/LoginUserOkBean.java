package com.jiyun.start.model.entity;

public class LoginUserOkBean {

    /**
     * code : 0
     * message : 成功
     * data : {"artcircleCount":0,"isPreference":1,"mobile":"17611457571","photo":null,"attentionCount":0,"fansCount":0,"userId":784,"realname":null,"homewokCount":0,"isAuth":-1,"beanAmount":0,"intro":null,"nickname":"我是二哥","coachingCount":0,"userType":1,"favoriteCount":0}
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
         * artcircleCount : 0
         * isPreference : 1
         * mobile : 17611457571
         * photo : null
         * attentionCount : 0
         * fansCount : 0
         * userId : 784
         * realname : null
         * homewokCount : 0
         * isAuth : -1
         * beanAmount : 0
         * intro : null
         * nickname : 我是二哥
         * coachingCount : 0
         * userType : 1
         * favoriteCount : 0
         */

        private int artcircleCount;
        private int isPreference;
        private String mobile;
        private Object photo;
        private int attentionCount;
        private int fansCount;
        private int userId;
        private Object realname;
        private int homewokCount;
        private int isAuth;
        private int beanAmount;
        private Object intro;
        private String nickname;
        private int coachingCount;
        private int userType;
        private int favoriteCount;

        public int getArtcircleCount() {
            return artcircleCount;
        }

        public void setArtcircleCount(int artcircleCount) {
            this.artcircleCount = artcircleCount;
        }

        public int getIsPreference() {
            return isPreference;
        }

        public void setIsPreference(int isPreference) {
            this.isPreference = isPreference;
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

        public int getAttentionCount() {
            return attentionCount;
        }

        public void setAttentionCount(int attentionCount) {
            this.attentionCount = attentionCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getRealname() {
            return realname;
        }

        public void setRealname(Object realname) {
            this.realname = realname;
        }

        public int getHomewokCount() {
            return homewokCount;
        }

        public void setHomewokCount(int homewokCount) {
            this.homewokCount = homewokCount;
        }

        public int getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(int isAuth) {
            this.isAuth = isAuth;
        }

        public int getBeanAmount() {
            return beanAmount;
        }

        public void setBeanAmount(int beanAmount) {
            this.beanAmount = beanAmount;
        }

        public Object getIntro() {
            return intro;
        }

        public void setIntro(Object intro) {
            this.intro = intro;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getCoachingCount() {
            return coachingCount;
        }

        public void setCoachingCount(int coachingCount) {
            this.coachingCount = coachingCount;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(int favoriteCount) {
            this.favoriteCount = favoriteCount;
        }
    }
}
