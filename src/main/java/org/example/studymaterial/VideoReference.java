package org.example.studymaterial;

public class VideoReference extends Reference {
    private boolean isAvailable;
    private String resolution;
    private String frameRate;
    private String videoFormat;

    public VideoReference(String title, String description){
        this.setTitle(title);
        this.setDescription(description);
    }

    public VideoReference(boolean isAvailable, String title, String description, String resolution,
                          String frameRate, String videoFormat, String accessRights){
        this.isAvailable = isAvailable;
        this.resolution = resolution;
        this.frameRate = frameRate;
        this.videoFormat = videoFormat;
        this.setTitle(title);
        this.setDescription(description);
        this.setAccessRights(accessRights);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }

    /**
     * Atualiza disponibilidade e status de download
     */
    public void editAvailability(boolean isAvailable, boolean isDownloadable){
        this.isAvailable = isAvailable;
        this.setDownloadable(isDownloadable);
    }

    /**
     * Lógica que determina se streaming está disponível
     */
    public boolean handleStreamAvailability(){
        if (!isAvailable) {
            return false;
        }
        if (!this.getIsDownloadable()) {
            return false;
        }
        return true;
    }
}
