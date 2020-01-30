public class Iter {
    private Integer id;
    private Boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Iter{" +
                "id=" + id +
                ", flag=" + flag +
                '}';
    }

    private Iter(Builder builder){
        id = builder.id;
        flag = builder.flag;
    }

    public static class Builder {
        private Integer id;
        private Boolean flag;

        public Builder withId(Integer val){
            id = val;
            return this;
        }
        public Builder withFlag(Boolean val){
            flag = val;
            return this;
        }
        public Iter build() {
            return new Iter(this);
        }
    }

}
