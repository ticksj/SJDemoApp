package com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor;

import java.util.List;

/**
 * Created by SJ on 2020/3/18.
 */
public class TestBean {


    /**
     * error : false
     * results : [{"_id":"5aff4645421aa95f55cab5e6","createdAt":"2018-05-18T00:00:00.0Z","desc":"2018-05-18","publishedAt":"2018-05-18T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frevscw2wej30je0ps78h.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5e5","createdAt":"2018-05-17T00:00:00.0Z","desc":"2018-05-17","publishedAt":"2018-05-17T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepozc5taj30qp0yg7aq.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5df","createdAt":"2018-05-16T00:00:00.0Z","desc":"2018-05-16","publishedAt":"2018-05-16T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepq6mfvdj30p00wcwmq.jpg","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5aff4645421aa95f55cab5e6
         * createdAt : 2018-05-18T00:00:00.0Z
         * desc : 2018-05-18
         * publishedAt : 2018-05-18T00:00:00.0Z
         * source : web
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/0065oQSqly1frevscw2wej30je0ps78h.jpg
         * used : true
         * who : lijinshanmx
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
