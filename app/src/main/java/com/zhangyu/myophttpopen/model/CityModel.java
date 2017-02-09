package com.zhangyu.myophttpopen.model;

import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */

public class CityModel {


    /**
     * message : 1
     * ishotlist : [{"code":"1","name":"哈尔滨"},{"code":"2","name":"沈阳"},{"code":"3","name":"北京"},{"code":"5","name":"上海"},{"code":"6","name":"广州"},{"code":"11","name":"天津"},{"code":"10","name":"南京"},{"code":"9","name":"杭州"},{"code":"8","name":"成都"},{"code":"7","name":"深圳"},{"code":"12","name":"武汉"},{"code":"13","name":"重庆"}]
     * arealist : [{"letter":"A","list":[{"code":"4","name":"鞍山"}]},{"letter":"B","list":[{"code":"3","name":"北京"}]},{"letter":"C","list":[{"code":"8","name":"成都"},{"code":"13","name":"重庆"},{"code":"28","name":"长沙"},{"code":"31","name":"长春"}]},{"letter":"D","list":[{"code":"30","name":"大连"},{"code":"34","name":"大理"}]},{"letter":"E","list":[{"code":"46","name":"鄂尔多斯"}]},{"letter":"F","list":[{"code":"20","name":"福州"}]},{"letter":"G","list":[{"code":"6","name":"广州"},{"code":"23","name":"桂林"},{"code":"35","name":"贵阳"}]},{"letter":"H","list":[{"code":"1","name":"哈尔滨"},{"code":"9","name":"杭州"},{"code":"18","name":"合肥"},{"code":"24","name":"海口"},{"code":"40","name":"呼和浩特"}]},{"letter":"J","list":[{"code":"15","name":"济南"},{"code":"32","name":"吉林"}]},{"letter":"K","list":[{"code":"33","name":"昆明"}]},{"letter":"L","list":[{"code":"27","name":"洛阳"},{"code":"36","name":"拉萨"},{"code":"43","name":"兰州"}]},{"letter":"M","list":[{"code":"47","name":"绵阳"}]},{"letter":"N","list":[{"code":"10","name":"南京"},{"code":"17","name":"宁波"},{"code":"22","name":"南宁"},{"code":"29","name":"南昌"}]},{"letter":"P","list":[{"code":"48","name":"平顶山"},{"code":"49","name":"盘锦"}]},{"letter":"Q","list":[{"code":"14","name":"青岛"},{"code":"38","name":"秦皇岛"}]},{"letter":"S","list":[{"code":"2","name":"沈阳"},{"code":"5","name":"上海"},{"code":"7","name":"深圳"},{"code":"16","name":"苏州"},{"code":"25","name":"三亚"},{"code":"37","name":"石家庄"}]},{"letter":"T","list":[{"code":"11","name":"天津"},{"code":"39","name":"太原"}]},{"letter":"W","list":[{"code":"12","name":"武汉"},{"code":"19","name":"芜湖"},{"code":"42","name":"乌鲁木齐"}]},{"letter":"S","list":[{"code":"2","name":"沈阳"},{"code":"5","name":"上海"},{"code":"7","name":"深圳"},{"code":"16","name":"苏州"},{"code":"25","name":"三亚"},{"code":"37","name":"石家庄"}]},{"letter":"Y","list":[{"code":"44","name":"银川"}]},{"letter":"Z","list":[{"code":"26","name":"郑州"}]}]
     */

    private String message;
    private List<IshotlistBean> ishotlist;
    private List<ArealistBean> arealist;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<IshotlistBean> getIshotlist() {
        return ishotlist;
    }

    public void setIshotlist(List<IshotlistBean> ishotlist) {
        this.ishotlist = ishotlist;
    }

    public List<ArealistBean> getArealist() {
        return arealist;
    }

    public void setArealist(List<ArealistBean> arealist) {
        this.arealist = arealist;
    }

    public static class IshotlistBean {
        /**
         * code : 1
         * name : 哈尔滨
         */

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ArealistBean {
        /**
         * letter : A
         * list : [{"code":"4","name":"鞍山"}]
         */

        private String letter;
        private List<ListBean> list;

        public String getLetter() {
            return letter;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * code : 4
             * name : 鞍山
             */

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
