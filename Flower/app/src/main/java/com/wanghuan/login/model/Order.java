package com.wanghuan.login.model;

import java.util.List;

public class Order {


    /**
     * code : 0
     * message : 成功
     * data : [{"orderid":880001,"userid":201603,"goodsid":20200001,"buycount":"1","sumprice":138.6,"ordername":"李四","orderphone":"18372608363","orderaddress":"湖北汽车工业学院","pay":1,"state":1,"goods":[{"goodsid":20200001,"goodsname":"手心的挚爱-11朵红玫瑰生日花束","goodsprice":138.6,"goodscount":21,"goodsdes":"热恋、希望与你泛起激情的爱","goodsimg":"2020-04-12/E674D891094C4224A6E4F5B195B08B01.jpg"}],"users":[{"userId":201603,"userName":"张飞","userPassword":"202cb962ac59075b964b07152d234b70","role":1}]},{"orderid":880006,"userid":201603,"goodsid":20200018,"buycount":"2","sumprice":1,"ordername":"李新","orderphone":"18372608365","orderaddress":"华凯大厦1102","pay":0,"state":0,"goods":[{"goodsid":20200018,"goodsname":"安暖相伴-33朵康乃馨鲜花2选1","goodsprice":228,"goodscount":12,"goodsdes":"情话些许,岁月静好,安暖相伴","goodsimg":"2020-04-12/DB960F1D609341AFAF855FD8C74304C2.jpg"}],"users":[{"userId":201603,"userName":"张飞","userPassword":"202cb962ac59075b964b07152d234b70","role":1}]}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderid : 880001
         * userid : 201603
         * goodsid : 20200001
         * buycount : 1
         * sumprice : 138.6
         * ordername : 李四
         * orderphone : 18372608363
         * orderaddress : 湖北汽车工业学院
         * pay : 1
         * state : 1
         * goods : [{"goodsid":20200001,"goodsname":"手心的挚爱-11朵红玫瑰生日花束","goodsprice":138.6,"goodscount":21,"goodsdes":"热恋、希望与你泛起激情的爱","goodsimg":"2020-04-12/E674D891094C4224A6E4F5B195B08B01.jpg"}]
         * users : [{"userId":201603,"userName":"张飞","userPassword":"202cb962ac59075b964b07152d234b70","role":1}]
         */

        private int orderid;
        private int userid;
        private int goodsid;
        private String buycount;
        private float sumprice;
        private String ordername;
        private String orderphone;
        private String orderaddress;
        private int pay;
        private int state;
        private List<GoodsBean> goods;
        private List<UsersBean> users;

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(int goodsid) {
            this.goodsid = goodsid;
        }

        public String getBuycount() {
            return buycount;
        }

        public void setBuycount(String buycount) {
            this.buycount = buycount;
        }

        public float getSumprice() {
            return sumprice;
        }

        public void setSumprice(float sumprice) {
            this.sumprice = sumprice;
        }

        public String getOrdername() {
            return ordername;
        }

        public void setOrdername(String ordername) {
            this.ordername = ordername;
        }

        public String getOrderphone() {
            return orderphone;
        }

        public void setOrderphone(String orderphone) {
            this.orderphone = orderphone;
        }

        public String getOrderaddress() {
            return orderaddress;
        }

        public void setOrderaddress(String orderaddress) {
            this.orderaddress = orderaddress;
        }

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public List<UsersBean> getUsers() {
            return users;
        }

        public void setUsers(List<UsersBean> users) {
            this.users = users;
        }

        public static class GoodsBean {
            /**
             * goodsid : 20200001
             * goodsname : 手心的挚爱-11朵红玫瑰生日花束
             * goodsprice : 138.6
             * goodscount : 21
             * goodsdes : 热恋、希望与你泛起激情的爱
             * goodsimg : 2020-04-12/E674D891094C4224A6E4F5B195B08B01.jpg
             */

            private int goodsid;
            private String goodsname;
            private float goodsprice;
            private int goodscount;
            private String goodsdes;
            private String goodsimg;

            public int getGoodsid() {
                return goodsid;
            }

            public void setGoodsid(int goodsid) {
                this.goodsid = goodsid;
            }

            public String getGoodsname() {
                return goodsname;
            }

            public void setGoodsname(String goodsname) {
                this.goodsname = goodsname;
            }

            public float getGoodsprice() {
                return goodsprice;
            }

            public void setGoodsprice(float goodsprice) {
                this.goodsprice = goodsprice;
            }

            public int getGoodscount() {
                return goodscount;
            }

            public void setGoodscount(int goodscount) {
                this.goodscount = goodscount;
            }

            public String getGoodsdes() {
                return goodsdes;
            }

            public void setGoodsdes(String goodsdes) {
                this.goodsdes = goodsdes;
            }

            public String getGoodsimg() {
                return goodsimg;
            }

            public void setGoodsimg(String goodsimg) {
                this.goodsimg = goodsimg;
            }
        }

        public static class UsersBean {
            /**
             * userId : 201603
             * userName : 张飞
             * userPassword : 202cb962ac59075b964b07152d234b70
             * role : 1
             */

            private int userId;
            private String userName;
            private String userPassword;
            private int role;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
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
        }
    }
}
