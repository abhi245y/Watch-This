package com.abhi245y.watchthis.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TMDbSimilarMoviesModel {


    /**
     * page : 1
     * results : [{"adult":false,"id":605116,"genre_ids":[28,80,878],"vote_count":1709,"original_language":"en","original_title":"Project Power","poster_path":"/TnOeov4w0sTtV2gqICqIxVi74V.jpg","title":"Project Power","video":false,"vote_average":6.6,"backdrop_path":"/qVygtf2vU15L2yKS4Ke44U4oMdD.jpg","overview":"An ex-soldier, a teen and a cop collide in New Orleans as they hunt for the source behind a dangerous new pill that grants users temporary superpowers.","release_date":"2020-08-14","popularity":110.972},{"adult":false,"backdrop_path":"/1R6cvRtZgsYCkh8UFuWFN33xBP4.jpg","vote_count":3361,"title":"Extraction","genre_ids":[18,28,53],"video":false,"original_language":"en","original_title":"Extraction","poster_path":"/wlfDxbGEsW58vGhFljKkcR5IxDj.jpg","id":545609,"release_date":"2020-04-24","vote_average":7.4,"overview":"Tyler Rake, a fearless mercenary who offers his services on the black market, embarks on a dangerous mission when he is hired to rescue the kidnapped son of a Mumbai crime lord.","popularity":49.259},{"adult":false,"backdrop_path":"/eFw5YSorHidsajLTayo1noueIxI.jpg","genre_ids":[28,53],"original_language":"en","original_title":"6 Underground","poster_path":"/lnWkyG3LLgbbrIEeyl5mK5VRFe4.jpg","vote_count":2745,"title":"6 Underground","vote_average":6.3,"video":false,"overview":"After faking his death, a tech billionaire recruits a team of international operatives for a bold and bloody mission to take down a brutal dictator.","release_date":"2019-12-13","id":509967,"popularity":41.54},{"id":461130,"vote_average":6.2,"overview":"In Lincoln City, some inhabitants have extraordinary abilities. Most live below the poverty line, under the close surveillance of a heavily militarized police force. Connor, a construction worker with powers, involves with a criminal gang to help his ailing mother. (Based on the short film \u201cCode 8,\u201d 2016.)","release_date":"2019-12-06","title":"Code 8","adult":false,"backdrop_path":"/wlnDNMQlnwl5ETlVY6n9CEtR5s0.jpg","vote_count":1005,"genre_ids":[878,28,80,53,18],"video":false,"original_language":"en","original_title":"Code 8","poster_path":"/izGX7npHEopDQvngYcxMJEfcFbj.jpg","popularity":28.195},{"original_language":"en","original_title":"Spenser Confidential","poster_path":"/fePczipv6ZzDO2uoww4vTAu2Sq3.jpg","video":false,"vote_average":6.6,"overview":"Spenser, a former Boston patrolman who just got out from prison, teams up with Hawk, an aspiring fighter, to unravel the truth behind the death of two police officers.","id":581600,"vote_count":1352,"title":"Spenser Confidential","adult":false,"backdrop_path":"/ftODZXaXpWtV5XFD8gS9n9KwLDr.jpg","release_date":"2020-03-06","genre_ids":[35,28,53],"popularity":22.217},{"poster_path":"/riYInlsq2kf1AWoGm80JQW5dLKp.jpg","video":false,"vote_average":7.5,"overview":"While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord.","release_date":"2020-09-23","vote_count":3006,"adult":false,"backdrop_path":"/kMe4TKMDNXTKptQPAdOF0oZHq3V.jpg","id":497582,"genre_ids":[80,18,9648],"title":"Enola Holmes","original_language":"en","original_title":"Enola Holmes","popularity":322.446},{"poster_path":"/gzlbb3yeVISpQ3REd3Ga1scWGTU.jpg","video":false,"vote_average":6.3,"overview":"After an earthquake destroys their underwater station, six researchers must navigate two miles along the dangerous, unknown depths of the ocean floor to make it to safety in a race against time.","release_date":"2020-01-08","vote_count":1784,"adult":false,"backdrop_path":"/ww7eC3BqSbFsyE5H5qMde8WkxJ2.jpg","id":443791,"genre_ids":[28,27,878,53],"title":"Underwater","original_language":"en","original_title":"Underwater","popularity":39.85},{"id":399361,"video":false,"vote_count":2095,"vote_average":6.3,"title":"Triple Frontier","release_date":"2019-03-06","original_language":"en","original_title":"Triple Frontier","genre_ids":[28,12,80,53],"backdrop_path":"/s9I2LmQMYCanl6DvC3X1AOHs2r8.jpg","adult":false,"overview":"Struggling to make ends meet, former special ops soldiers reunite for a high-stakes heist: stealing $75 million from a South American drug lord.","poster_path":"/aBw8zYuAljVM1FeK5bZKITPH8ZD.jpg","popularity":21.12},{"original_language":"en","original_title":"Gemini Man","poster_path":"/uTALxjQU8e1lhmNjP9nnJ3t2pRU.jpg","video":false,"vote_average":6.4,"overview":"Henry Brogan is an elite 51-year-old assassin who's ready to call it quits after completing his 72nd job. His plans get turned upside down when he becomes the target of a mysterious operative who can seemingly predict his every move. To his horror, Brogan soon learns that the man who's trying to kill him is a younger, faster, cloned version of himself.","release_date":"2019-10-02","vote_count":3226,"title":"Gemini Man","adult":false,"backdrop_path":"/c3F4P2oauA7IQmy4hM0OmRt2W7d.jpg","id":453405,"genre_ids":[28,18,878,53],"popularity":55.416},{"vote_average":7.4,"overview":"In Knockemstiff, Ohio and its neighboring backwoods, sinister characters converge around young Arvin Russell as he fights the evil forces that threaten him and his family.","release_date":"2020-09-11","adult":false,"backdrop_path":"/rUeqBuNDR9zN6vZV9kpEFMtQm0E.jpg","vote_count":1433,"genre_ids":[80,18,53],"id":499932,"original_language":"en","original_title":"The Devil All the Time","poster_path":"/sdMZmKVvrnyYbl9Az4L6ehuIrFp.jpg","title":"The Devil All the Time","video":false,"popularity":50.44},{"original_title":"Terminator: Dark Fate","poster_path":"/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg","video":false,"vote_average":6.6,"overview":"Decades after Sarah Connor prevented Judgment Day, a lethal new Terminator is sent to eliminate the future leader of the resistance. In a fight to save mankind, battle-hardened Sarah Connor teams up with an unexpected ally and an enhanced super soldier to stop the deadliest Terminator yet.","release_date":"2019-10-23","id":290859,"adult":false,"backdrop_path":"/a6cDxdwaQIFjSkXf7uskg78ZyTq.jpg","vote_count":3100,"genre_ids":[28,12,878],"title":"Terminator: Dark Fate","original_language":"en","popularity":73.38},{"adult":false,"backdrop_path":"/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg","genre_ids":[10752,28,18],"original_language":"en","original_title":"Greyhound","poster_path":"/kjMbDciooTbJPofVXgAoFjfX8Of.jpg","id":516486,"vote_average":7.4,"title":"Greyhound","overview":"A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the \u201cBlack Pit\u201d to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.","release_date":"2020-07-10","vote_count":1458,"video":false,"popularity":111.191},{"adult":false,"backdrop_path":"/uK9uFbAwQ1s2JHKkJ5l0obPTcXI.jpg","genre_ids":[35,878],"vote_count":3035,"original_language":"en","original_title":"Men in Black: International","id":479455,"title":"Men in Black: International","video":false,"vote_average":6,"poster_path":"/dPrUPFcgLfNbmDL8V69vcrTyEfb.jpg","overview":"The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.","release_date":"2019-06-12","popularity":53.493},{"vote_average":6.8,"overview":"An embattled NYPD detective, is thrust into a citywide manhunt for a pair of cop killers after uncovering a massive and unexpected conspiracy. As the night unfolds, lines become blurred on who he is pursuing, and who is in pursuit of him.","release_date":"2019-10-24","title":"21 Bridges","adult":false,"backdrop_path":"/5KmhjlR5CEarB8mKtpjcjHRYIu9.jpg","genre_ids":[80,28,18],"vote_count":1083,"original_language":"en","original_title":"21 Bridges","poster_path":"/bSN9SysoRBMwJKNkfOlQlCw2YQO.jpg","id":535292,"video":false,"popularity":23.951},{"adult":false,"backdrop_path":"/tintsaQ0WLzZsTMkTiqtMB3rfc8.jpg","vote_count":2523,"title":"The Gentlemen","genre_ids":[28,80,35],"video":false,"original_language":"en","original_title":"The Gentlemen","poster_path":"/jtrhTYB7xSrJxR1vusu99nvnZ1g.jpg","id":522627,"release_date":"2020-01-01","vote_average":7.7,"overview":"American expat Mickey Pearson has built a highly profitable marijuana empire in London. When word gets out that he\u2019s looking to cash out of the business forever it triggers plots, schemes, bribery and blackmail in an attempt to steal his domain out from under him.","popularity":46.912},{"original_title":"In the Shadow of the Moon","poster_path":"/5DSVYlKwEzGBxTkS95L73c3oxLs.jpg","video":false,"vote_average":6.2,"overview":"In 1988, Philadelphia police officer Thomas \"Locke\" Lockhart, hungry to become a detective, begins tracking a serial killer whose crimes defy scientific explanation. When the killer mysteriously resurfaces nine years later, Locke's obsession with finding the truth threatens to destroy his career, his family, and possibly his sanity.","release_date":"2019-09-27","id":530382,"adult":false,"backdrop_path":"/jJUK0IKdVvsTONsCVTVHQkEn7bZ.jpg","vote_count":770,"genre_ids":[9648,878,53],"title":"In the Shadow of the Moon","original_language":"en","popularity":23.887},{"overview":"A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong.","release_date":"2020-07-02","adult":false,"backdrop_path":"/54yOImQgj8i85u9hxxnaIQBRUuo.jpg","vote_count":944,"genre_ids":[28,80,18,53],"id":539885,"original_language":"en","original_title":"Ava","poster_path":"/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg","title":"Ava","video":false,"vote_average":5.6,"popularity":332.51},{"original_language":"fr","original_title":"Anna","poster_path":"/sNgoPUAUAGviF3oMSDNG3DgN9i0.jpg","video":false,"vote_average":6.7,"overview":"Beneath Anna Poliatova's striking beauty lies a secret that will unleash her indelible strength and skill to become one of the world's most feared government assassins.","release_date":"2019-06-19","vote_count":1424,"title":"Anna","adult":false,"backdrop_path":"/oHDnvxSDOTsaYZSUibJjrEMWMLL.jpg","id":484641,"genre_ids":[53,28],"popularity":29.207},{"adult":false,"backdrop_path":"/jCCdt0e8Xe9ttvevD4S3TSMNdH.jpg","genre_ids":[27,28,35],"vote_count":3205,"original_language":"en","original_title":"Zombieland: Double Tap","id":338967,"title":"Zombieland: Double Tap","video":false,"vote_average":7,"poster_path":"/dtRbVsUb5O12WWO54SRpiMtHKC0.jpg","overview":"Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family.","release_date":"2019-10-09","popularity":80.496},{"genre_ids":[878,28,12],"original_language":"en","original_title":"Dark Phoenix","poster_path":"/kZv92eTc0Gg3mKxqjjDAM73z9cy.jpg","video":false,"title":"Dark Phoenix","vote_count":4150,"overview":"The X-Men face their most formidable and powerful foe when one of their own, Jean Grey, starts to spiral out of control. During a rescue mission in outer space, Jean is nearly killed when she's hit by a mysterious cosmic force. Once she returns home, this force not only makes her infinitely more powerful, but far more unstable. The X-Men must now band together to save her soul and battle aliens that want to use Grey's new abilities to rule the galaxy.","release_date":"2019-06-05","id":320288,"vote_average":6.1,"adult":false,"backdrop_path":"/phxiKFDvPeQj4AbkvJLmuZEieDU.jpg","popularity":49.694}]
     * total_pages : 2
     * total_results : 40
     */

    private Integer page;
    private Integer total_pages;
    private Integer total_results;
    private List<ResultsBean> results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @NoArgsConstructor
    @Data
    public static class ResultsBean {
        /**
         * adult : false
         * id : 605116
         * genre_ids : [28,80,878]
         * vote_count : 1709
         * original_language : en
         * original_title : Project Power
         * poster_path : /TnOeov4w0sTtV2gqICqIxVi74V.jpg
         * title : Project Power
         * video : false
         * vote_average : 6.6
         * backdrop_path : /qVygtf2vU15L2yKS4Ke44U4oMdD.jpg
         * overview : An ex-soldier, a teen and a cop collide in New Orleans as they hunt for the source behind a dangerous new pill that grants users temporary superpowers.
         * release_date : 2020-08-14
         * popularity : 110.972
         */

        private Boolean adult;
        private Integer id;
        private Integer vote_count;
        private String original_language;
        private String original_title;
        private String poster_path;
        private String title;
        private Boolean video;
        private Double vote_average;
        private String backdrop_path;
        private String overview;
        private String release_date;
        private Double popularity;
        private ArrayList<Integer> genre_ids;

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getVote_count() {
            return vote_count;
        }

        public void setVote_count(Integer vote_count) {
            this.vote_count = vote_count;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Boolean getVideo() {
            return video;
        }

        public void setVideo(Boolean video) {
            this.video = video;
        }

        public Double getVote_average() {
            return vote_average;
        }

        public void setVote_average(Double vote_average) {
            this.vote_average = vote_average;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public ArrayList<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(ArrayList<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
