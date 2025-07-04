package org.example.studymaterial;

public abstract class Reference {
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private boolean isDownloadable;
    private int rating;
    private String language;
    private int viewCount;
    private int downloadCount;
    private int shareCount;

    // Getters (deixo só getters públicos, setters são privados ou protegidos para controlar atualizações)
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
    public String getAccessRights() { return accessRights; }
    public String getLicense() { return license; }
    public boolean isDownloadable() { return isDownloadable; }
    public int getRating() { return rating; }
    public String getLanguage() { return language; }
    public int getViewCount() { return viewCount; }
    public int getDownloadCount() { return downloadCount; }
    public int getShareCount() { return shareCount; }

    // Setters protegidos para controlar atualização (usar métodos públicos focados em comportamento)
    protected void setTitle(String title) { this.title = title; }
    protected void setDescription(String description) { this.description = description; }
    protected void setLink(String link) { this.link = link; }
    protected void setAccessRights(String accessRights) { this.accessRights = accessRights; }
    protected void setLicense(String license) { this.license = license; }
    protected void setDownloadable(boolean downloadable) { this.isDownloadable = downloadable; }
    protected void setRating(int rating) { this.rating = rating; }
    protected void setLanguage(String language) { this.language = language; }
    protected void setViewCount(int viewCount) { this.viewCount = viewCount; }
    protected void setDownloadCount(int downloadCount) { this.downloadCount = downloadCount; }
    protected void setShareCount(int shareCount) { this.shareCount = shareCount; }

    // Métodos de negócio mais ricos

    public void updateBasicInfo(String title, String description, String link) {
        setTitle(title);
        setDescription(description);
        setLink(link);
    }

    public void updateMetrics(int rating, int viewCount, int downloadCount, int shareCount) {
        setRating(rating);
        setViewCount(viewCount);
        setDownloadCount(downloadCount);
        setShareCount(shareCount);
    }

    public void updateAccessDetails(String accessRights, String license, boolean isDownloadable, String language) {
        setAccessRights(accessRights);
        setLicense(license);
        setDownloadable(isDownloadable);
        setLanguage(language);
    }

    /**
     * Exemplo de método que agrega dados e retorna um score da referência,
     * misturando rating, views, downloads e compartilhamentos.
     */
    public double calculateEngagementScore() {
        // Exemplo simples ponderado
        return rating * 0.4 + viewCount * 0.3 + downloadCount * 0.2 + shareCount * 0.1;
    }

    /**
     * Valida se a referência está disponível para acesso público e download
     */
    public boolean isPubliclyAvailable() {
        return "Public".equalsIgnoreCase(accessRights) && isDownloadable;
    }

    @Override
    public String toString() {
        return String.format("Reference[title=%s, rating=%d, views=%d, downloads=%d, shares=%d]",
                title, rating, viewCount, downloadCount, shareCount);
    }
}
