public enum Files {
    INPUT("input.xml"),
    RESERVATIONS("reservations.xml");
    private final String path;
    Files(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
