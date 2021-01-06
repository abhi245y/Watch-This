package com.abhi245y.watchthis.Models;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TMDbGetImagesModel {


    /**
     * id : 485789
     * backdrops : [{"aspect_ratio":1.779359430604982,"file_path":"/v8t1Oh5SOTERymW3b1tewf0pLcO.jpg","height":843,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1500},{"aspect_ratio":1.779359430604982,"file_path":"/wWdZn0z7McpAQEaGMqJwoH9IiDG.jpg","height":1686,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":3000},{"aspect_ratio":1.777777777777778,"file_path":"/xnmJeWhDjETKA1xpGVQftpqBE6k.jpg","height":2160,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":3840},{"aspect_ratio":1.779458097038437,"file_path":"/4yclkgKTGWiRbNnE6WqKWSFBhPU.jpg","height":1587,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":2824},{"aspect_ratio":1.779359430604982,"file_path":"/ja767CHjMSNGkpjb5HSrxVweRZT.jpg","height":1686,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":3000},{"aspect_ratio":1.777777777777778,"file_path":"/zAChUOMPE23FHhSib8UuLvaCQQK.jpg","height":2160,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":3840},{"aspect_ratio":1.777777777777778,"file_path":"/Aap44UxxxnpUXIP1rc1R1zXfsga.jpg","height":2160,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":3840},{"aspect_ratio":1.779458097038437,"file_path":"/h6e1JLuNJLDtBP5OGYplRNkqcoz.jpg","height":1587,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":2824},{"aspect_ratio":1.778393351800554,"file_path":"/jSIwpy0mMhQ4PD7G9YfSo6LGs75.jpg","height":722,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1284},{"aspect_ratio":1.778656126482213,"file_path":"/rRWITBNubuGsFCFoUavgxMuSDfP.jpg","height":1012,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1800},{"aspect_ratio":1.780021253985122,"file_path":"/nFJZsOJcqejYb8yMcP9BcR73Bjh.jpg","height":1882,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":3350},{"aspect_ratio":1.777777777777778,"file_path":"/nKSklcYvr2jDFPPHVBr6zB700gq.jpg","height":720,"iso_639_1":null,"vote_average":0,"vote_count":0,"width":1280}]
     * posters : [{"aspect_ratio":0.6666666666666666,"file_path":"/eepnc6C5Rb8mgUNDSjWiuAgpXuh.jpg","height":1500,"iso_639_1":"ta","vote_average":5.312,"vote_count":1,"width":1000},{"aspect_ratio":0.6666666666666666,"file_path":"/quGwnd4DjXOX25aLwuuRJJ5YmlS.jpg","height":1500,"iso_639_1":"te","vote_average":5.312,"vote_count":1,"width":1000},{"aspect_ratio":0.6666666666666666,"file_path":"/f00V2b7nZtmmSSZkIBbN1PQUWBt.jpg","height":1500,"iso_639_1":"ta","vote_average":5.246,"vote_count":2,"width":1000},{"aspect_ratio":0.637901861252115,"file_path":"/uNYtn5iYJgCb6RUmPwEAn6TKrT9.jpg","height":1182,"iso_639_1":"te","vote_average":5.172,"vote_count":1,"width":754},{"aspect_ratio":0.6666666666666666,"file_path":"/mXNuARfwCIRv9Lv10HT6IEAARDo.jpg","height":1500,"iso_639_1":"te","vote_average":5.172,"vote_count":1,"width":1000},{"aspect_ratio":0.7052083333333333,"file_path":"/aSASR2Xv7pgIBXYyUiuVs43KSsi.jpg","height":960,"iso_639_1":"te","vote_average":0,"vote_count":0,"width":677},{"aspect_ratio":0.6666666666666666,"file_path":"/c954Q37WKu9rbI1FD6HMDWYvdbF.jpg","height":1500,"iso_639_1":"ml","vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.6666666666666666,"file_path":"/qX7lyLsaXO3zQrF3ZTrnSlonHnN.jpg","height":1500,"iso_639_1":"ml","vote_average":0,"vote_count":0,"width":1000},{"aspect_ratio":0.6666666666666666,"file_path":"/b1rSVStsKWFGRVhJ7TW7ju7QiDE.jpg","height":1500,"iso_639_1":"ta","vote_average":0,"vote_count":0,"width":1000}]
     */

    private Integer id;
    private List<BackdropsBean> backdrops;
    private List<PostersBean> posters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BackdropsBean> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<BackdropsBean> backdrops) {
        this.backdrops = backdrops;
    }

    public List<PostersBean> getPosters() {
        return posters;
    }

    public void setPosters(List<PostersBean> posters) {
        this.posters = posters;
    }

    @NoArgsConstructor
    @Data
    public static class BackdropsBean {
        /**
         * aspect_ratio : 1.779359430604982
         * file_path : /v8t1Oh5SOTERymW3b1tewf0pLcO.jpg
         * height : 843
         * iso_639_1 : null
         * vote_average : 0
         * vote_count : 0
         * width : 1500
         */

        private Double aspect_ratio;
        private String file_path;
        private float height;
        private Object iso_639_1;
        private float vote_average;
        private float vote_count;
        private float width;


        public Double getAspect_ratio() {
            return aspect_ratio;
        }

        public void setAspect_ratio(Double aspect_ratio) {
            this.aspect_ratio = aspect_ratio;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        public Object getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(Object iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public float getVote_average() {
            return vote_average;
        }

        public void setVote_average(float vote_average) {
            this.vote_average = vote_average;
        }

        public float getVote_count() {
            return vote_count;
        }

        public void setVote_count(float vote_count) {
            this.vote_count = vote_count;
        }

        public float getWidth() {
            return width;
        }

        public void setWidth(float width) {
            this.width = width;
        }
    }

    @NoArgsConstructor
    @Data
    public static class PostersBean {
        /**
         * aspect_ratio : 0.6666666666666666
         * file_path : /eepnc6C5Rb8mgUNDSjWiuAgpXuh.jpg
         * height : 1500
         * iso_639_1 : ta
         * vote_average : 5.312
         * vote_count : 1
         * width : 1000
         */

        private Double aspect_ratio;
        private String file_path;
        private Integer height;
        private String iso_639_1;
        private Double vote_average;
        private Integer vote_count;
        private Integer width;

        public Double getAspect_ratio() {
            return aspect_ratio;
        }

        public void setAspect_ratio(Double aspect_ratio) {
            this.aspect_ratio = aspect_ratio;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public Double getVote_average() {
            return vote_average;
        }

        public void setVote_average(Double vote_average) {
            this.vote_average = vote_average;
        }

        public Integer getVote_count() {
            return vote_count;
        }

        public void setVote_count(Integer vote_count) {
            this.vote_count = vote_count;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }
    }
}
