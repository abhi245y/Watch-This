package com.abhi245y.watchthis.Models;

import java.util.List;

public class OMDbSearchModel {
    /**
     * Search : [{"Title":"Mulan","Year":"1998","imdbID":"tt0120762","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BODkxNGQ1NWYtNzg0Ny00Yjg3LThmZTItMjE2YjhmZTQ0ODY5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"},{"Title":"Mulan","Year":"2020","imdbID":"tt4566758","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDliY2E1MjUtNzZkOS00MzJlLTgyOGEtZDg4MTI1NzZkMTBhXkEyXkFqcGdeQXVyNjMwMzc3MjE@._V1_SX300.jpg"},{"Title":"Mulan II","Year":"2004","imdbID":"tt0279967","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BODEzMmIxOGMtY2RhYS00YTFiLThkZmYtMDlmZGJlYzg0NWEzXkEyXkFqcGdeQXVyNjk1Njg5NTA@._V1_SX300.jpg"},{"Title":"Mulan: Rise of a Warrior","Year":"2009","imdbID":"tt1308138","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNmMyMTY2YmEtZjM2ZS00ZWQ5LWE4YjEtOGMxOGZhY2RlZjJjXkEyXkFqcGdeQXVyNDM2OTEyOTM@._V1_SX300.jpg"},{"Title":"Unparalleled Mulan","Year":"2020","imdbID":"tt12186846","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDZiMTA2NTktMWU5NC00NzJhLTk1MTgtNjA2NzFkZmM4MDhkXkEyXkFqcGdeQXVyMjAwNzczNTU@._V1_SX300.jpg"},{"Title":"Mulan","Year":"1998","imdbID":"tt0238429","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDM3OTQ3NDc0OF5BMl5BanBnXkFtZTgwNjE1MjA2MDE@._V1_SX300.jpg"},{"Title":"Hua Mulan","Year":"1998\u2013","imdbID":"tt0972658","Type":"series","Poster":"https://m.media-amazon.com/images/M/MV5BYjIyN2ViMTItNzUwMS00MTQ0LWE5N2YtMjkyMDQzNGQ1OTkwXkEyXkFqcGdeQXVyNjgwNTk4Mg@@._V1_SX300.jpg"},{"Title":"The Legend of Mulan","Year":"1998","imdbID":"tt0180798","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMjE1MTIzMDU2NF5BMl5BanBnXkFtZTYwMjMyNDY5._V1_SX300.jpg"},{"Title":"The Secret of Mulan","Year":"1998","imdbID":"tt0218589","Type":"movie","Poster":"https://ia.media-imdb.com/images/M/MV5BMTI0NDg2NDkwNF5BMl5BanBnXkFtZTYwNjYwMTk4._V1_SX300.jpg"},{"Title":"Reflections on Ice: Michelle Kwan Skates to the Music of Disney's 'Mulan'","Year":"1998","imdbID":"tt0228769","Type":"movie","Poster":"N/A"}]
     * totalResults : 27
     * Response : True
     */

    private String totalResults;
    private String Response;
    private List<SearchBean> Search;

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public List<SearchBean> getSearch() {
        return Search;
    }

    public static class SearchBean {
        /**
         * Title : Mulan
         * Year : 1998
         * imdbID : tt0120762
         * Type : movie
         * Poster : https://m.media-amazon.com/images/M/MV5BODkxNGQ1NWYtNzg0Ny00Yjg3LThmZTItMjE2YjhmZTQ0ODY5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg
         */

        private String Title;
        private String Year;
        private String imdbID;
        private String Type;
        private String Poster;


        public String getTitle() {
            return Title;
        }

        public String getYear() {
            return Year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public String getType() {
            return Type;
        }

        public String getPoster() {
            return Poster;
        }
    }
}
