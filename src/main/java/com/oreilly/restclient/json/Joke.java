package com.oreilly.restclient.json;


import java.util.Arrays;

public class Joke {
    private String type;
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }

    public class Value {
        private int id;
        private String joke;
        private String[] categories;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public String[] getCategories() {
            return categories;
        }

        public void setCategories(String[] categories) {
            this.categories = categories;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "id=" + id +
                    ", joke='" + joke + '\'' +
                    ", categories=" + Arrays.toString(categories) +
                    '}';
        }
    }
}
