package com.wanghuan.login.model;


import java.io.Serializable;
import java.util.List;

public class Flowers {

    /**
     * code : 0
     * message : 成功
     * data : [{"goodsid":20200001,"goodsname":"手心的挚爱-11朵红玫瑰生日花束","goodsprice":138.6,"goodscount":21,"goodsdes":"热恋、希望与你泛起激情的爱","goodsimg":"2020-04-12/E674D891094C4224A6E4F5B195B08B01.jpg"},{"goodsid":20200002,"goodsname":"在一起吧-11朵红玫瑰鲜花礼盒","goodsprice":118,"goodscount":21,"goodsdes":"热恋、希望与你泛起激情的爱","goodsimg":"2020-04-12/EC264F7E3F6B4F1C89275E69A24BB7C5.jpg"},{"goodsid":20200003,"goodsname":"初恋情人-19朵粉玫瑰+银叶菊花束","goodsprice":178,"goodscount":12,"goodsdes":"感动、爱的宣言、铭记于心 、初恋，喜欢你那灿烂的笑容","goodsimg":"2020-04-12/4443E3E6D5624C319C89816178A3496E.jpg"},{"goodsid":20200004,"goodsname":"与你约定-11朵粉白混搭满天星花束","goodsprice":158,"goodscount":9,"goodsdes":"幸福、幸运。满天星看起来楚楚动人,温柔多情。 在插花时,常用满天星作配材,使花簇更加柔美可人。","goodsimg":"2020-04-12/033AD9021438479EAB759CF367AB4E95.jpg"},{"goodsid":20200005,"goodsname":"青梅竹马-33朵红玫瑰鲜花束","goodsprice":218,"goodscount":5,"goodsdes":"有你我才能闯过每一次的风雨，谢谢你一路的陪伴","goodsimg":"2020-04-12/E674D891094C4224A6E4F5B195B08B01.jpg"},{"goodsid":20200006,"goodsname":"纯白花嫁-11朵粉玫瑰+满天星尤加利鲜花束","goodsprice":128,"goodscount":21,"goodsdes":"多喜事，硕果累累；少困苦，有滋有味！","goodsimg":"2020-04-12/BAF3B203D2954FE19B5FA3F11A21330F.jpg"},{"goodsid":20200007,"goodsname":"白色恋人-25朵白玫瑰绣球尤加利叶混搭花束","goodsprice":198,"goodscount":23,"goodsdes":"用简简单单的方式陪伴着你绽放你心中的美","goodsimg":"2020-04-12/1080F33AD2D54DA7AB9949DEE5262906.jpg"},{"goodsid":20200008,"goodsname":"为你写诗-9朵白玫瑰尤加利混搭花束","goodsprice":198,"goodscount":12,"goodsdes":"为你写诗，为你静止，为你做不可能的事","goodsimg":"2020-04-12/DB181DA6DA5B428988FEA90B2060B9ED.jpg"},{"goodsid":20200009,"goodsname":"一往情深-19朵香槟玫瑰混搭花束","goodsprice":188,"goodscount":12,"goodsdes":"谢你一往情深 你好比条命根 何幸我命途里 碰着你这知音","goodsimg":"2020-04-12/21DF3828955747F3B3398C9DCD8AF7FA.jpg"},{"goodsid":20200010,"goodsname":"生生世世-19朵红玫瑰鲜花黑纱礼盒","goodsprice":178,"goodscount":12,"goodsdes":"生生世世，永永远远","goodsimg":"2020-04-12/4F3DEC0D3A3D4F05BF63DC0CE81064C4.jpg"},{"goodsid":20200011,"goodsname":"爱的告白-19朵玫瑰鲜花礼盒","goodsprice":178,"goodscount":12,"goodsdes":"缘分，让我遇见你；感觉，让我喜欢你；时间，让我爱上你","goodsimg":"2020-04-12/44F46D3484F5412490B95A23E590384F.jpg"},{"goodsid":20200012,"goodsname":"心动恋人-19朵红玫瑰5朵百合鲜花束","goodsprice":188,"goodscount":12,"goodsdes":"遇上你是今生的缘份，爱上你是我今生的幸福，守护你是我今生的选择，为你我今生无怨无悔，爱你一生不变！","goodsimg":"2020-04-12/D1A6084DCCEC4D5C93BB32D953B56B88.jpg"},{"goodsid":20200013,"goodsname":"不负遇见-33朵玫瑰精美鲜花束","goodsprice":198,"goodscount":12,"goodsdes":"不负遇见，不负此生","goodsimg":"2020-04-12/7E45918C94BE43FA95C86326997EAEBC.jpg"},{"goodsid":20200014,"goodsname":"璀璨星辰/满天星花束一束","goodsprice":188,"goodscount":12,"goodsdes":"我要让你知道，在这个世界上总有一个人能是等着你的，不管在什么时候，什么地方，反正你知道，总有这么一个人","goodsimg":"2020-04-12/881656403F7947DA848C78933227C6AF.jpg"},{"goodsid":20200015,"goodsname":"语笑嫣然/99朵玫瑰精美花束","goodsprice":418,"goodscount":12,"goodsdes":"语笑嫣然","goodsimg":"2020-04-12/DE14DA9EEEFA44808B3DF074A5DF30E5.jpg"},{"goodsid":20200016,"goodsname":"梦幻巴黎-99朵粉玫瑰满天星花束","goodsprice":428,"goodscount":12,"goodsdes":"梦幻巴黎","goodsimg":"2020-04-12/BAF3B203D2954FE19B5FA3F11A21330F.jpg"},{"goodsid":20200017,"goodsname":"遇见你-9支粉色玫瑰+绣球鲜花花束","goodsprice":218,"goodscount":12,"goodsdes":"世界那么大，还是遇见你","goodsimg":"2020-04-12/859FB20B6D254E73A39D223345000BD9.jpg"},{"goodsid":20200018,"goodsname":"安暖相伴-33朵康乃馨鲜花2选1","goodsprice":228,"goodscount":12,"goodsdes":"情话些许,岁月静好,安暖相伴","goodsimg":"2020-04-12/DB960F1D609341AFAF855FD8C74304C2.jpg"},{"goodsid":20200019,"goodsname":"往后余生-11朵红玫瑰红豆点缀鲜花花束","goodsprice":160,"goodscount":12,"goodsdes":"往后的余生，我只要你","goodsimg":"2020-04-12/B8F9476F93F248A4AC4EB11DF0A523E2.jpg"},{"goodsid":20200020,"goodsname":"春暖花开-2朵向日葵+6朵香槟玫瑰情人草混搭","goodsprice":168,"goodscount":12,"goodsdes":"春暖花开，这是我的世界，每次怒放，都是心中喷发的爱","goodsimg":"2020-04-12/CEC00DC8F9F149AFAEA96E3100AD7ADE.jpg"},{"goodsid":20200021,"goodsname":"开业大吉-开业三脚架花篮单个","goodsprice":118,"goodscount":12,"goodsdes":"大吉大利，今晚吃鸡","goodsimg":"2020-04-12/A505486CD5AB477DAA4427C362623BB2.jpg"},{"goodsid":20200022,"goodsname":"结婚挚爱-V型婚车鲜花装饰服务一次","goodsprice":880,"goodscount":5,"goodsdes":"我们结婚吧","goodsimg":"2020-04-12/8D23C2C97F4047768C707618378D4C22.jpg"},{"goodsid":20200023,"goodsname":"梦幻告白-蓝色妖姬玫瑰19朵礼盒","goodsprice":256,"goodscount":6,"goodsdes":"爱你写满整面告白墙","goodsimg":"2020-04-12/44DDABCE401C41738FCAE78D6F794F90.jpg"}]
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

    public static class DataBean implements Serializable {
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
        private double goodsprice;
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

        public double getGoodsprice() {
            return goodsprice;
        }

        public void setGoodsprice(double goodsprice) {
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
}
